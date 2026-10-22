package com.ss.android.lark.conditional.access.auth.v2.handler;

import android.os.Handler;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.auth.v2.z;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import i8b.g;
import i8b.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements c {
    public final q a;
    public Handler b;
    public final Map<String, WeakReference<com.ss.android.lark.security.compliance.api.model.filepolicy.c>> c;
    public final List<String> d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.auth.v2.handler.b$b, reason: collision with other inner class name */
    public static final class RunnableC0152b implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.b b;

        public RunnableC0152b(b r1, com.ss.android.lark.security.compliance.api.model.filepolicy.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.k(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public b(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        this.a = r2;
        this.c = new LinkedHashMap();
        this.d = CollectionsKt.plus(com.ss.android.lark.security.compliance.api.model.filepolicy.f.b, w4c.c.a().q0());
    }

    private final void update(com.ss.android.lark.security.compliance.api.model.filepolicy.b r7) {
        qqb.a.h("CCMFileProtectTimerHandler update");     // Catch: Throwable -> L17
        int r1 = ScsLogger.a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_CCMFileProtectTimerHandler", "update(), identifier is " + r7.getIdentifier());     // Catch: Throwable -> L17
        List r0 = r7.c;     // Catch: Throwable -> L17
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L17
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L17
    L5:
        if (r3.hasNext() == false) goto L12;
        PolicyModel r4 = (PolicyModel) r3.next();     // Catch: Throwable -> L17
        if (this.d.contains(r4.getPointKey()) == false) goto L9;
        r4.setConfig(new PolicyModel.a(this.a.b(r4)));     // Catch: Throwable -> L17
    L10:
        if (r4 == null) goto L5;
        r2.add(r4);     // Catch: Throwable -> L17
        goto L5
    L9:
        r4 = null;
        goto L10
    L12:
        z.a.c(new g(new i8b.f(r2)));     // Catch: Throwable -> L17
        Handler r5 = this.b;     // Catch: Throwable -> L17
        if (r5 == null) goto L15;
        r5.postAtTime(new RunnableC0152b(this, r7), r7.getIdentifier(), SystemClock.uptimeMillis() + ((long) (w4c.c.a().Z() * 1000)));     // Catch: Throwable -> L17
    L15:
        qqb.a.a();
        return;
    L17:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    @Override // com.ss.android.lark.conditional.access.auth.v2.handler.c
    public final void c(l r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.b != null) goto L6;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("CCMFileProtectTimerHandler");
        ThreadMethodProxy.start(r0);
        this.b = new Handler(r0.getLooper());
    L6:
        if ((r6 instanceof com.ss.android.lark.security.compliance.api.model.filepolicy.b) == false) goto L12;
        com.ss.android.lark.security.compliance.api.model.filepolicy.b r7 = (com.ss.android.lark.security.compliance.api.model.filepolicy.b) r6;
        String r1 = r7.getIdentifier();
        this.c.put(r1, new WeakReference(r7.getContext()));
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CCMFileProtectTimerHandler", "handleEvent(), event is CCMOpenFileEvent, identifier is " + r1);
        Handler r3 = this.b;
        if (r3 == null) goto L10;
        r3.removeCallbacksAndMessages(r1);
    L10:
        update(r7);
        return;
    L12:
        if ((r6 instanceof com.ss.android.lark.security.compliance.api.model.filepolicy.a) == false) goto L18;
        String r8 = ((com.ss.android.lark.security.compliance.api.model.filepolicy.a) r6).getIdentifier();
        this.c.remove(r8);
        int r4 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CCMFileProtectTimerHandler", "handleEvent(), event is CCMLeaveFileEvent, identifier is " + r8);
        Handler r5 = this.b;
        if (r5 == null) goto L19;
        r5.removeCallbacksAndMessages(r8);
        return;
    L19:
        return;
    }

    public static final /* synthetic */ void k(b r0, com.ss.android.lark.security.compliance.api.model.filepolicy.b r1) {
        r0.update(r1);
    }
}
