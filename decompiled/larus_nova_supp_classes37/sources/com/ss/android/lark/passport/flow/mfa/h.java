package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final AtomicReference<FlowMfaFlowSession> a;

    public static final class a {
    }

    static {
    }

    @Inject
    public h() {
        this.a = new AtomicReference();
    }

    public final void a(FlowMfaFlowSession r8) {
        Intrinsics.checkNotNullParameter(r8, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        AtomicReference<FlowMfaFlowSession> r0 = this.a;
    L3:
        boolean r3 = false;
        if (r0.compareAndSet(r8, null) == true) goto L5;
        if (r0.get() == r8) goto L3;
        boolean r1 = false;
    L9:
        if (r1 == false) goto L39;
        ConcurrentHashMap<String, FlowMfaFlowSession> r2 = o.a;
        String r4 = r8.a;
        Intrinsics.checkNotNullParameter(r4, "flowId");
        ConcurrentHashMap<String, FlowMfaFlowSession> r5 = o.a;
        if (r5.remove(r4) == null) goto L13;
        PassportLog.d("FlowMfaRuntime", "remove session success: sessionCount=" + r5.size());
    L14:
        AtomicReference<syb.b> r6 = com.ss.android.lark.passport.flow.core.router.a.c;
        FlowMfaFlowSession.d r7 = r8.w;
        syb.b r9 = r8.u.get();
        Intrinsics.checkNotNullParameter(r7, "router");
        AtomicReference<syb.b> r10 = com.ss.android.lark.passport.flow.core.router.a.c;
    L16:
        if (r10.compareAndSet(r7, r9) == true) goto L20;
        if (r10.get() == r7) goto L16;
    L20:
        r8.u.set(null);
        r8.m(FlowMfaBidpWebActivityType.EXTERNAL_BROWSER_LOADING);
        WeakReference<Activity> r11 = r8.o.getAndSet(null);
        if (r11 == null) goto L23;
        Activity r12 = r11.get();
    L24:
        StringBuilder r13 = new StringBuilder("finish pending BIDP callback activity: hasActivity=");
        if (r12 == null) goto L27;
        r3 = true;
    L27:
        r13.append(r3);
        r13.append(", activity=");
        if (r12 == null) goto L30;
        String r14 = r12.getClass().getSimpleName();
    L31:
        r13.append(r14);
        PassportLog.d("FlowMfaSession", r13.toString());
        r8.j(r12);
        r8.i.set(null);
        r8.j.set(null);
        r8.k.set(null);
        r8.l.set(null);
        r8.r.set(null);
        r8.s.set(null);
        r8.t.set(null);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r15 = r8.v;
        r15.set(com.ss.android.lark.passport.flow.mfa.a.a(r15.get(), ExternalBidpCallbackPhase.IDLE));
        CoroutineScopeKt.cancel$default(r8.h, null, 1, null);
        return;
    L30:
        r14 = null;
        goto L31
    L23:
        r12 = null;
        goto L24
    L13:
        PassportLog.b("FlowMfaRuntime", "remove session failed: session not found");
        goto L14
    L39:
        return;
    L5:
        r1 = true;
        goto L9
    }
}
