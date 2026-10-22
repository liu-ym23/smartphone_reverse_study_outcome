package com.ss.android.lark.conditional.access.auth.v2.handler;

import android.os.Handler;
import android.os.SystemClock;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.auth.v2.z;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.h;
import com.ss.android.lark.security.compliance.api.model.filepolicy.k;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import i8b.v;
import i8b.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements c {
    public static final a a = null;
    public static Handler b;
    public static final Map<String, WeakReference<com.ss.android.lark.security.compliance.api.model.filepolicy.c>> c = null;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.auth.v2.handler.a$a, reason: collision with other inner class name */
    public static final class RunnableC0151a implements Runnable {
        public final /* synthetic */ Object a;

        public RunnableC0151a(Object r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map<String, WeakReference<com.ss.android.lark.security.compliance.api.model.filepolicy.c>> r0 = a.c;     // Catch: Throwable -> L10
            LinkedHashMap r1 = (LinkedHashMap) r0;     // Catch: Throwable -> L10
            WeakReference r2 = (WeakReference) r1.get(this.a);     // Catch: Throwable -> L10
            if (r2 == null) goto L13;
            com.ss.android.lark.security.compliance.api.model.filepolicy.c r3 = (com.ss.android.lark.security.compliance.api.model.filepolicy.c) r2.get();     // Catch: Throwable -> L10
            if (r3 == null) goto L17;
            Function0 r4 = r3.d;     // Catch: Throwable -> L10
            if (r4 == null) goto L18;
            r4.invoke();     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.b a;

        public b(com.ss.android.lark.security.compliance.api.model.filepolicy.b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = a.a;     // Catch: Throwable -> L4
            a.k(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
    }

    static {
        a = new a();
        c = new LinkedHashMap();
    }

    public static final /* synthetic */ void k(com.ss.android.lark.security.compliance.api.model.filepolicy.b r1) {
        a.update(r1);
    }

    private final void update(com.ss.android.lark.security.compliance.api.model.filepolicy.b r9) {
        qqb.a.h("CCMDLPTimerHandler update");     // Catch: Throwable -> L14
        int r1 = ScsLogger.a;     // Catch: Throwable -> L14
        ScsLogger.d("SecurityPolicy_CCMDLPTimerHandler", "update(), identifier is " + r9.getIdentifier());     // Catch: Throwable -> L14
        List r0 = r9.c;     // Catch: Throwable -> L14
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L14
    L5:
        if (r3.hasNext() == false) goto L9;
        PolicyModel r4 = h.j((PolicyModel) r3.next());     // Catch: Throwable -> L14
        if (r4 == null) goto L5;
        r2.add(r4);     // Catch: Throwable -> L14
        goto L5
    L9:
        z.a.c(new i8b.e(new i8b.d(r2, r9.getIdentifier())));     // Catch: Throwable -> L14
        Handler r5 = b;     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r5.postAtTime(new b(r9), r9.getIdentifier(), SystemClock.uptimeMillis() + (w4c.c.a().t() * ((long) 1000)));     // Catch: Throwable -> L14
    L12:
        qqb.a.a();
        return;
    L14:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    @Override // com.ss.android.lark.conditional.access.auth.v2.handler.c
    public final void c(l r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (b != null) goto L6;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("CCMDLPTimerHandler");
        ThreadMethodProxy.start(r0);
        b = new Handler(r0.getLooper());
    L6:
        if ((r6 instanceof com.ss.android.lark.security.compliance.api.model.filepolicy.b) == false) goto L12;
        com.ss.android.lark.security.compliance.api.model.filepolicy.b r7 = (com.ss.android.lark.security.compliance.api.model.filepolicy.b) r6;
        String r1 = r7.getIdentifier();
        c.put(r1, new WeakReference(r7.getContext()));
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CCMDLPTimerHandler", "handleEvent(), event is CCMOpenFileEvent, identifier is " + r1);
        Handler r3 = b;
        if (r3 == null) goto L10;
        r3.removeCallbacksAndMessages(r1);
    L10:
        update(r7);
        return;
    L12:
        if ((r6 instanceof com.ss.android.lark.security.compliance.api.model.filepolicy.a) == false) goto L17;
        String r8 = ((com.ss.android.lark.security.compliance.api.model.filepolicy.a) r6).getIdentifier();
        c.remove(r8);
        int r4 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CCMDLPTimerHandler", "handleEvent(), event is CCMLeaveFileEvent, identifier is " + r8);
        Handler r5 = b;
        if (r5 == null) goto L25;
        r5.removeCallbacksAndMessages(r8);
        return;
    L25:
        return;
    L17:
        if ((r6 instanceof w) == false) goto L27;
        FileAuthMonitor.a r9 = ((v) ((k) ((w) r6)).a).c;
        if (r9.a != FileAuthMonitor.UpdateTrigger.DocScene) goto L28;
        Object r10 = r9.b;
        if ((r10 instanceof String) == false) goto L29;
        CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC0151a(r10));
        return;
    L29:
        return;
    L28:
        return;
    }
}
