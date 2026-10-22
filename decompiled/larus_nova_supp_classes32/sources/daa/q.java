package daa;

import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.WindowManager;
import bytedanceos.api.TransactionSmt;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common.AiScreenEdgeEffectView;
import com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common.RippleEffectView;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iaa.h$a;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q implements aaa.a {
    public boolean a;
    public boolean b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final k g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public static WindowManager.LayoutParams d() {
        WindowManager.LayoutParams r6 = new WindowManager.LayoutParams(-1, -1, 2006, 218629400, -3);
        r6.windowAnimations = 0;
        r6.dimAmount = 0.0f;
        r6.gravity = 49;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 28) goto L6;
        r6.layoutInDisplayCutoutMode = 1;
    L6:
        if (r1 >= 31) goto L17;
        ILogDepend.a.i("WindowEffectsImpl", "setTrustedOverlayReflectively failed, sdk version < 31");
    L16:
        return r6;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        Method r3 = WindowManager.LayoutParams.class.getDeclaredMethod("setTrustedOverlay", new Class[0]);     // Catch: Throwable -> L9
        r3.setAccessible(true);     // Catch: Throwable -> L9
        Object r0 = Result.constructor-impl(r3.invoke(r6, new Object[0]));     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r0);
        if (r4 == null) goto L14;
        ILogDepend.a.w("WindowEffectsImpl", "setTrustedOverlayReflectively failed", r4);
    L14:
        Result.box-impl(r0);
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void c() {
        RippleEffectView r0 = (RippleEffectView) this.e.getValue();
        if (r0 != null) goto L7;
        ILogDepend.a.w("WindowEffectsImpl", "addV2OverlayView: v2RippleEffectView is null");
        return;
    L7:
        if (this.b == false) goto L10;
        ILogDepend.a.w("WindowEffectsImpl", "addV2OverlayView is already added");
        return;
    L10:
        this.b = true;
        ILogDepend.a.i("WindowEffectsImpl", "addV2OverlayView");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        WindowManager r3 = (WindowManager) this.h.getValue();     // Catch: Throwable -> L13
        WindowManager.LayoutParams r4 = d();     // Catch: Throwable -> L13
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r0, r4);     // Catch: Throwable -> L13
        r3.addView(r0, r4);     // Catch: Throwable -> L13
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r5 = Result.exceptionOrNull-impl(r1);
        if (r5 == null) goto L21;
        ILogDepend.a.w("WindowEffectsImpl", "addV2OverlayView failed: " + r5.getMessage(), r5);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final AiScreenEdgeEffectView e() {
        return (AiScreenEdgeEffectView) this.d.getValue();
    }

    public final boolean f() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public final void i() {
        if (this.b == true) goto L6;
        ILogDepend.a.i("WindowEffectsImpl", "removeV2OverlayView is not added");
        return;
    L6:
        ILogDepend.a.i("WindowEffectsImpl", "removeV2OverlayView");
        this.b = false;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        ((WindowManager) this.h.getValue()).removeView((RippleEffectView) this.e.getValue());     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L17;
        ILogDepend.a.w("WindowEffectsImpl", "removeV2OverlayView failed: " + r2.getMessage(), r2);
        return;
    L17:
        return;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // aaa.a
    public final void stopActivateEffect() {
        ILogDepend.a.i("WindowEffectsImpl", "stopActivateEffect");
        j("stopActivateEffect", new p(this));
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [daa.k] */
    public q() {
        ILogDepend.a.i("WindowEffectsImpl", "WindowEffectsImpl: new instance");
        this.c = LazyKt.lazy(new daa.a());
        this.d = LazyKt.lazy(new h());
        this.e = LazyKt.lazy(new i());
        this.f = LazyKt.lazy(new j());
        this.g = new k(this);
        this.h = LazyKt.lazy(new l());
    }

    public final void h() {
        AiScreenEdgeEffectView r0 = e();
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (this.a == true) goto L9;
        ILogDepend.a.i("WindowEffectsImpl", "removeV1OverlayView is not added");
        return;
    L9:
        ILogDepend.a.i("WindowEffectsImpl", "removeV1OverlayView");
        this.a = false;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        ((WindowManager) this.h.getValue()).removeView(e());     // Catch: Throwable -> L12
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L20;
        ILogDepend.a.w("WindowEffectsImpl", "removeV1OverlayView failed: " + r3.getMessage());
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void l() {
        if (f() == true) goto L23;
        RippleEffectView r0 = (RippleEffectView) this.e.getValue();
        if (r0 == null) goto L21;
        r0.d();
    L21:
        i();
        return;
    L23:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        gaa.d r2 = (gaa.d) this.f.getValue();     // Catch: Throwable -> L12
        fja.d r3 = r2.c;     // Catch: Throwable -> L12
        r2.c = null;     // Catch: Throwable -> L12
        r2.f++;     // Catch: Throwable -> L12
        if (r3 == null) goto L7;
        r3.a(false);     // Catch: Throwable -> L12
    L7:
        IBinder r4 = r2.d;     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        TransactionSmt.getInstance().stopAnimation(r4);     // Catch: Throwable -> L12
    L10:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L17;
        ILogDepend.a.w("WindowEffectsImpl", "stopEffect failed: " + r6.getMessage(), r6);
    L17:
        Result.box-impl(r5);
        return;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // aaa.a
    public final void startActivateEffect(final boolean r4) {
        ILogDepend.a.i("WindowEffectsImpl", "startActivateEffect: withRipple = " + r4 + ", isObricOS = " + f());
        j("startActivateEffect", new n(this, r4));
    }

    public static void j(String r2, Function0 r3) {
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        ILogDepend.a.w("WindowEffectsImpl", r2.concat(": isSupportWindowEffects is false"));
        return;
    L6:
        Handler r4 = iaa.h.a;
        final iaa.i r5 = new iaa.i(r3);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L9;
        r5.run();
        return;
    L9:
        iaa.h.a.post(new h$a(r5));
    }

    @Override // aaa.a
    public final void a(final boolean r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "windowLayerName");
        ILogDepend.a.i("WindowEffectsImpl", "playRippleEffect: isObricOS = " + f() + ", skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        j("playRippleEffect", new m(this, r4, r5));
    }

    @Override // aaa.a
    public final void b(final boolean r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "windowLayerName");
        ILogDepend.a.i("WindowEffectsImpl", "showScreenShotEffect: isObricOS = " + f() + ", skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        j("showScreenShotEffect", new o(this, r4, r5));
    }

    public final void g(boolean r5, String r6) {
        ILogDepend.a.i("WindowEffectsImpl", "playV2RippleEffect start, skipWindowLayer = " + r5 + ", windowLayerName = " + r6);
        if (f() == true) goto L16;
        c();
        RippleEffectView r7 = (RippleEffectView) this.e.getValue();
        if (r7 == null) goto L19;
        r7.c(RippleEffectView.m, new c(this));
        return;
    L19:
        return;
    L16:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        gaa.d r1 = (gaa.d) this.f.getValue();     // Catch: Throwable -> L6
        Runnable r2 = new b();     // Catch: Throwable -> L6
        r1.getClass();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r6, "windowLayerName");     // Catch: Throwable -> L6
        r1.d(gaa.d.g, r5, r6, r2);     // Catch: Throwable -> L6
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L11;
        ILogDepend.a.w("WindowEffectsImpl", "playWakeUpEffect failed: " + r9.getMessage(), r9);
    L11:
        Result.box-impl(r8);
        return;
    L6:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void k(boolean r5, String r6) {
        ILogDepend.a.i("WindowEffectsImpl", "showV2ScreenShotEffect start, skipWindowLayer = " + r5 + ", windowLayerName = " + r6);
        if (f() == true) goto L16;
        c();
        RippleEffectView r7 = (RippleEffectView) this.e.getValue();
        if (r7 == null) goto L19;
        r7.c(RippleEffectView.n, new g(this));
        return;
    L19:
        return;
    L16:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        gaa.d r1 = (gaa.d) this.f.getValue();     // Catch: Throwable -> L6
        Runnable r2 = new f();     // Catch: Throwable -> L6
        r1.getClass();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r6, "windowLayerName");     // Catch: Throwable -> L6
        r1.d(gaa.d.h, r5, r6, r2);     // Catch: Throwable -> L6
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L11;
        ILogDepend.a.w("WindowEffectsImpl", "playCaptureEffect failed: " + r9.getMessage(), r9);
    L11:
        Result.box-impl(r8);
        return;
    L6:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
