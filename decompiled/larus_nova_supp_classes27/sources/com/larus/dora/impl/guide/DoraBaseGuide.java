package com.larus.dora.impl.guide;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class DoraBaseGuide implements t39.l {
    public final String a;
    public volatile int b;
    public t39.m c;
    public i59.a d;
    public j59.a e;
    public final AtomicBoolean f;

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r1) {
        return n(this, r1);
    }

    public abstract void h();

    public abstract DoraGuideMeta i();

    public abstract String j();

    public void r(j59.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public void s(j59.a r1, Fragment r2) {
        Intrinsics.checkNotNullParameter(r1, "state");
    }

    public void u(j59.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public Object v() {
        return null;
    }

    public abstract void x(j59.a r1, Fragment r2, View r3);

    public final j59.b g() {
        i59.a r0 = this.d;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        g49.d.d(k(), "buildStateManager() skipped: wDid is null or empty");
        return null;
    L15:
        com.larus.dora.impl.util.b0.a.getClass();
        return new j59.b(new j59.c(com.larus.dora.impl.util.b0.j()), j(), r1);
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final boolean o() {
        IDoraGuideService r0 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.b();
    L6:
        if (r1 == false) goto L8;
        g49.d.d(k(), "guide suppressed: dora guide is degraded");
    L8:
        return r1;
    L5:
        r1 = true;
        goto L6
    }

    public final void q() {
        if (this.f.compareAndSet(false, true) == false) goto L8;
        g49.d.d(k(), "notifyGuideFinishedOnce() for guide=" + i());
        t39.m r0 = this.c;
        if (r0 == null) goto L9;
        r0.a(this);
        return;
    L9:
        return;
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "(meta=" + i() + ", state=" + this.b + ')';
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d(k(), "startGuide()");
        if (o() == true) goto L7;
        y(1);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return i().getGuideId();
    }

    public String k() {
        String r0 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r0 != null) goto L6;
        return "DoraBaseGuide";
    L6:
        return r0;
    }

    public final void l() {
        j59.b r0 = g();
        if (r0 == null) goto L8;
        j59.a r1 = this.e;
        if (r1 != null) goto L7;
        r1 = r0.b();
    L7:
        j59.a r2 = r1;
        j59.a r3 = j59.a.a(r2, 0, 0, r2.c + 1, 0, 11);
        r0.a.putInt(r0.a("close_times"), r3.c);
    L9:
        this.e = r3;
        r(r3);
        return;
    L8:
        j59.a r4 = this.e;
        r3 = j59.a.a(r4, 0, 0, r4.c + 1, 0, 11);
        goto L9
    }

    public final void t() {
        g49.d.d(k(), "Guide dismissed for guide=" + i());
        y(3);
        q();
    }

    public DoraBaseGuide(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        this.a = r2;
        this.e = new j59.a(0);
        this.f = new AtomicBoolean(false);
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        g49.d.d(k(), "setStateListener() called with " + r4);
        this.c = r4;
    }

    public final void m(Fragment r12) {
        j59.b r0 = g();
        if (r0 == null) goto L8;
        j59.a r1 = this.e;
        if (r1 != null) goto L7;
        r1 = r0.b();
    L7:
        j59.a r2 = r1;
        j59.a r3 = j59.a.a(r2, 0, 0, 0, r2.d + 1, 7);
        r0.a.putInt(r0.a("click_times"), r3.d);
    L9:
        this.e = r3;
        s(r3, r12);
        return;
    L8:
        j59.a r4 = this.e;
        r3 = j59.a.a(r4, 0, 0, 0, r4.d + 1, 7);
        goto L9
    }

    public Object p(Continuation<? super Boolean> r1) {
        return Boxing.boxBoolean(false);
    }

    public final void y(int r5) {
        if (this.b != r5) goto L5;
        return;
    L5:
        int r0 = this.b;
        this.b = r5;
        g49.d.d(k(), "Guide state changed: prev=" + r0 + ", new=" + r5 + ", guide=" + i());
        t39.m r1 = this.c;
        if (r1 == null) goto L9;
        r1.b(this, r5, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.dora.impl.guide.DoraBaseGuide] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.dora.impl.guide.DoraBaseGuide] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.dora.impl.guide.DoraBaseGuide, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v44 */
    /* JADX WARN: Type inference failed for: r10v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.dora.impl.guide.DoraBaseGuide, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.dora.impl.guide.DoraBaseGuide, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    public static Object n(DoraBaseGuide r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof DoraBaseGuide$isGuideConditionMet$1) == false) goto L7;
        DoraBaseGuide$isGuideConditionMet$1 r0 = (DoraBaseGuide$isGuideConditionMet$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = r0.label;
        if (r3 == 0) goto L28;
        if (r3 == 1) goto L25;
        if (r3 == 2) goto L20;
        if (r3 != 3) goto L19;
        ?? r13 = r0.Z$0;
        j59.a r4 = (j59.a) r0.L$2;
        i59.a r5 = (i59.a) r0.L$1;
        ?? r6 = (DoraBaseGuide) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L16
        r6 = r6;
        r13 = r13;
    L79:
        Object r14 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r12).booleanValue()));     // Catch: Throwable -> L16
        ?? r7 = r6;
        ?? r15 = r13;
    L85:
        Throwable r8 = Result.exceptionOrNull-impl(r14);
        if (r8 == null) goto L88;
        g49.d.c(r7.k(), "serverConditionCheck() error: " + r8.getMessage(), r8);
    L88:
        Boolean r9 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r14) == false) goto L91;
        r14 = r9;
    L91:
        boolean r16 = ((Boolean) r14).booleanValue();
        g49.d.d(r7.k(), "isGuideConditionMet() end, localOk=" + r15 + ", serverOk=" + r16 + ", params=" + r5 + ", state=" + r4);
        return Boxing.boxBoolean(r16);
    L16:
        Throwable th = th;
        j59.a r17 = r4;
        ?? r18 = r6;
        ?? r110 = r13;
    L84:
        Result.Companion r20 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        r4 = r17;
        r7 = r18;
        r15 = r110;
        goto L85
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        boolean r111 = r0.Z$0;
        DoraBaseGuide r21 = (DoraBaseGuide) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L23
        r3 = r21;
        r10 = r111;
    L56:
        Object r112 = Result.constructor-impl((i59.a) r12);     // Catch: Throwable -> L23
        ?? r22 = r3;
        ?? r113 = r10;
    L59:
        Throwable r23 = Result.exceptionOrNull-impl(r112);
        if (r23 == null) goto L63;
        g49.d.c(r22.k(), "resolveDeviceParams() error: " + r23.getMessage(), r23);
    L63:
        if (Result.isFailure-impl(r112) == false) goto L65;
        r112 = null;
    L65:
        i59.a r114 = (i59.a) r112;
        if (r114 != null) goto L68;
    L93:
        g49.d.d(r22.k(), "resolveDeviceParams() returns null/empty wDid, skip guide");
        return Boxing.boxBoolean(false);
    L68:
        if (StringsKt.isBlank(r114.a) == true) goto L93;
        r22.d = r114;
        j59.b r24 = r22.g();
        if (r24 == null) goto L73;
        r17 = r24.b();
    L74:
        r22.e = r17;
        r0.L$0 = r22;     // Catch: Throwable -> L82
        r0.L$1 = r114;     // Catch: Throwable -> L82
        r0.L$2 = r17;     // Catch: Throwable -> L82
        r0.Z$0 = r113;     // Catch: Throwable -> L82
        r0.label = 3;     // Catch: Throwable -> L82
        Object r25 = r22.w(r114, r17, r0);     // Catch: Throwable -> L82
        if (r25 != r2) goto L78;
        return r2;
    L78:
        r4 = r17;
        ?? r26 = r22;
        r5 = r114;
        r12 = r25;
        r6 = r26;
        r13 = r113;
    L82:
        th = move-exception;
        ?? r27 = r22;
        r5 = r114;
        th = th;
        r18 = r27;
        r110 = r113;
        goto L84
    L73:
        r17 = new j59.a(0);
        goto L74
    L25:
        DoraBaseGuide r115 = (DoraBaseGuide) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L41
        r10 = r115;
    L39:
        Object r116 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r12).booleanValue()));     // Catch: Throwable -> L41
        ?? r117 = r10;
    L43:
        ?? r28 = r117;
        Throwable r118 = Result.exceptionOrNull-impl(r116);
        if (r118 == null) goto L46;
        g49.d.c(r28.k(), "localConditionCheck() error: " + r118.getMessage(), r118);
    L46:
        Boolean r119 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r116) == false) goto L49;
        r116 = r119;
    L49:
        boolean r120 = ((Boolean) r116).booleanValue();
        if (r120 == true) goto L53;
        g49.d.d(r28.k(), "localConditionCheck() not met, skip guide");
        return Boxing.boxBoolean(false);
    L53:
        r0.L$0 = r28;     // Catch: Throwable -> L23
        r0.Z$0 = r120;     // Catch: Throwable -> L23
        r0.label = 2;     // Catch: Throwable -> L23
        r12 = r28.v();     // Catch: Throwable -> L23
        r3 = r28;
        r10 = r120;
        if (r12 != r2) goto L56;
        return r2;
    L28:
        ResultKt.throwOnFailure(r12);
        if (AccountService.a.isLogin().booleanValue() == true) goto L33;
        g49.d.d(r10.k(), "guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L33:
        if (r10.o() == true) goto L35;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L41
        r0.L$0 = r10;     // Catch: Throwable -> L41
        r0.label = 1;     // Catch: Throwable -> L41
        r12 = r10.p(r0);     // Catch: Throwable -> L41
        r10 = r10;
        if (r12 != r2) goto L39;
        return r2;
    L35:
        return Boxing.boxBoolean(false);
    L41:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
        r117 = r10;
    L23:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        r22 = r3;
        r113 = r10;
    L7:
        r0 = new DoraBaseGuide$isGuideConditionMet$1(r10, r11);
        goto L8
    }

    @Override // t39.l
    public final Object d(Fragment r2, View r3, Continuation<? super Unit> r4) {
        g49.d.d(k(), "dismissGuide() called");
        h();     // Catch: Exception -> L5
    L8:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        g49.d.c(k(), "dismissGuide() exception: " + e.getMessage(), e);
        y(404);
        q();
        goto L8
    }

    @Override // t39.l
    public final Object e(Fragment r8, View r9, Continuation<? super Unit> r10) {
        g49.d.d(k(), "showGuide() called, fragment=" + r8 + ", anchorView=" + r9);
        if (o() == true) goto L21;
        y(2);
        j59.b r11 = g();     // Catch: Exception -> L15
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L15
        if (r11 == null) goto L12;
        j59.a r0 = this.e;     // Catch: Exception -> L15
        if (r0 != null) goto L11;
        r0 = r11.b();     // Catch: Exception -> L15
    L11:
        j59.a r2 = j59.a.a(r0, r1, r0.b + 1, 0, 0, 12);     // Catch: Exception -> L15
        r11.a.putLong(r11.a("last_show_time"), r2.a);     // Catch: Exception -> L15
        r11.a.putInt(r11.a("show_times"), r2.b);     // Catch: Exception -> L15
    L13:
        this.e = r2;     // Catch: Exception -> L15
        u(r2);     // Catch: Exception -> L15
        x(r2, r8, r9);     // Catch: Exception -> L15
    L18:
        return Unit.INSTANCE;
    L12:
        j59.a r3 = this.e;     // Catch: Exception -> L15
        r2 = j59.a.a(r3, r1, r3.b + 1, 0, 0, 12);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        g49.d.c(k(), "showGuide() exception: " + e.getMessage(), e);
        y(404);
        q();
        goto L18
    L21:
        return Unit.INSTANCE;
    }

    public Object w(i59.a r1, j59.a r2, Continuation<? super Boolean> r3) {
        return Boxing.boxBoolean(false);
    }
}
