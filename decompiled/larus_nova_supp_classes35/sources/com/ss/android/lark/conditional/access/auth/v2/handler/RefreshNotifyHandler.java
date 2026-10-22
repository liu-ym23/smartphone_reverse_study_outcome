package com.ss.android.lark.conditional.access.auth.v2.handler;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMLocalFileContent;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMOnlineFileContent;
import com.ss.android.lark.security.compliance.api.model.filepolicy.RefreshContext;
import com.ss.android.lark.security.compliance.api.model.filepolicy.j;
import com.ss.android.lark.security.compliance.api.model.filepolicy.k;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.api.model.filepolicy.n;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.h;
import i8b.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RefreshNotifyHandler implements c {
    public static final RefreshNotifyHandler a = null;
    public static final ConcurrentHashMap<String, WeakReference<RefreshContext>> b = null;
    public static final ConcurrentHashMap<String, e> c = null;

    public RefreshNotifyHandler() {
    }

    static {
        a = new RefreshNotifyHandler();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_RefreshNotifyHandler", "init with push interval: " + w4c.c.a().u0());
    }

    @Override // com.ss.android.lark.conditional.access.auth.v2.handler.c
    public final void c(l r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof j) == false) goto L6;
        j r6 = (j) r5;
        String r0 = r6.getContext().getIdentifier();
        b.put(r0, new WeakReference(r6.getContext()));
        int r7 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_RefreshNotifyHandler", "handleEvent(), event is RegisterRefreshEvent, identifier is " + r0);
        return;
    L6:
        if ((r5 instanceof n) == false) goto L9;
        String r8 = ((n) r5).getContext().getIdentifier();
        b.remove(r8);
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_RefreshNotifyHandler", "handleEvent(), event is UnRegisterRefreshEvent, identifier is " + r8);
        return;
    L9:
        if ((r5 instanceof i) == false) goto L25;
        h r9 = (h) ((k) ((i) r5)).a;
        int r2 = ScsLogger.a;     // Catch: Exception -> L16
        ScsLogger.d("SecurityPolicy_RefreshNotifyHandler", "receive DataResultChangeEvent，trigger is " + r9.b.a.name() + ", pointKeys is " + r9.a);     // Catch: Exception -> L16
        Iterator r3 = CollectionsKt.iterator(b.keys());     // Catch: Exception -> L16
    L13:
        if (r3.hasNext() == false) goto L26;
        String r4 = (String) r3.next();     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L16
        k(r4, b.get(r4), r9);     // Catch: Exception -> L16
        goto L13
    L26:
        return;
    L16:
        e = move-exception;
        int r10 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_RefreshNotifyHandler", "receive DataResultChangeEvent error，e is " + ExceptionsKt.stackTraceToString(e));
        return;
    }

    public static void k(final String r10, final WeakReference r11, final h r12) {
        if (r11 == null) goto L40;
        RefreshContext r0 = (RefreshContext) r11.get();
        if (r0 == null) goto L41;
        com.ss.android.lark.security.compliance.api.model.filepolicy.i r1 = r0.getRefreshableScene();
        if (r1 == null) goto L42;
        List r2 = r1.getPointKeys();
        if (r2 == null) goto L45;
        Set r3 = CollectionsKt.intersect(r12.a, r2);
        Set r4 = r3;
        if ((!r4.isEmpty()) == false) goto L43;
        RefreshContext r5 = (RefreshContext) r11.get();
        if (r5 == null) goto L15;
        com.ss.android.lark.security.compliance.api.model.filepolicy.i r6 = r5.getRefreshableScene();
    L17:
        if ((r6 instanceof CCMOnlineFileContent) == false) goto L20;
        final String r7 = "ccmOnlineContent";
    L23:
        final Function1<Set<? extends String>, Unit> r8 = new RefreshNotifyHandler$handleRefresh$makeTraceRefresh$1(r11, r10, r7, r12);
        ConcurrentHashMap<String, e> r13 = c;
        e r9 = r13.get(r10);
        if (r9 != null) goto L26;
        r9 = new e(w4c.c.a().u0(), new RefreshNotifyHandler$handleRefresh$handlerDebounce$1(r8));
    L26:
        Intrinsics.checkNotNullParameter(r3, "pointKeys");
        r9.d.addAll(r4);
        r13.put(r10, r9);
        FileAuthMonitor.UpdateTrigger r14 = r12.b.a;
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r14, "trigger");
        if ((System.currentTimeMillis() - r9.c) >= r9.a) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == false) goto L38;
        int r16 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_RefreshNotifyHandler", r7 + " is debounce，delayNotify with pointKeys: " + r9.d + ", identifier: " + r10);
        long r17 = r9.a - (System.currentTimeMillis() - r9.c);
        if (r17 > 0) goto L34;
    L37:
        FileAuthMonitor.UpdateTrigger[] r18 = FileAuthMonitor.a;
        FileAuthMonitor.r(r7, r10, r14, r9.d, "delayNotify");
        return;
    L34:
        if (r9.e == true) goto L37;
        r9.e = true;
        CoreThreadPool.getBackgroundHandler().postDelayed(new d(r9), r17);
        goto L37
    L38:
        r9.b.invoke(r9.d);
        r9.c = System.currentTimeMillis();
        r9.d.clear();
        r9.e = false;
        return;
    L29:
        r15 = false;
        goto L30
    L20:
        if ((r6 instanceof CCMLocalFileContent) == false) goto L22;
        r7 = "ccmLocalContent";
        goto L23
    L22:
        r7 = "unknown";
        goto L23
    L15:
        r6 = null;
        goto L17
    L43:
        return;
    L45:
        return;
    L42:
        return;
    L41:
        return;
    }
}
