package com.larus.common_ui.edgeeffect;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import d19.f;
import d19.g;
import d19.h;
import d19.i;
import d19.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016JT\u0010\u0017\u001a\u00020\u00152%\u0010\u0018\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0011H\u0016JT\u0010#\u001a\u00020\u00152%\u0010\u0018\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/common_ui/edgeeffect/ScreenEdgeEffectGLView;", "Landroid/opengl/GLSurfaceView;", "Lcom/larus/common_ui/edgeeffect/IScreenEdgeEffectView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "renderer", "Lcom/larus/common_ui/edgeeffect/EdgeRenderer;", "eglManager", "Lcom/larus/common_ui/edgeeffect/EdgeEffectEGLManager;", "showAnimator", "Landroid/animation/ValueAnimator;", "hideAnimator", "isRenderingActive", "", "lastAlpha", "", "init", "", "destroy", "showScreenEdgeEffect", "onEnd", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", "name", "animator", "onCancel", "setAudioAmplitude", "amplitude", "setDarkMode", "darkMode", "dismissScreenEdgeEffect", "pauseEdgeEffect", "resumeEdgeEffect", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenEdgeEffectGLView extends GLSurfaceView implements g {
    public static final /* synthetic */ int e = 0;
    public final f a;
    public ValueAnimator b;
    public ValueAnimator c;
    public boolean d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function1<Animator, Unit> a;
        public final /* synthetic */ Animator b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Animator, Unit> r1, Animator r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Animator, Unit> r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.invoke(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function1<Animator, Unit> a;
        public final /* synthetic */ Animator b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Animator, Unit> r1, Animator r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Animator, Unit> r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.invoke(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ ScreenEdgeEffectGLView a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ Function1 c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            FLogger.a.i("ScreenEdgeEffectGLView", "showScreenEdgeEffect onCancel");
            this.a.post(new c(this.c, r4));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            FLogger.a.i("ScreenEdgeEffectGLView", "showScreenEdgeEffect onEnd");
            this.a.post(new b(this.b, r4));
        }

        public d(ScreenEdgeEffectGLView r1, Function1 r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // d19.g
    public final void c() {
        if (this.d == true) goto L5;
        return;
    L5:
        FLogger.a.i("ScreenEdgeEffectGLView", "pauseEdgeEffect");
        this.d = false;
        setRenderMode(0);
    }

    @Override // d19.g
    public final void d() {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.i("ScreenEdgeEffectGLView", "resumeEdgeEffect");
        this.d = true;
        setRenderMode(1);
    }

    @Override // d19.g
    public final void init() {
        f r0 = this.a;
        r0.getClass();
        r0.b = 0.0f;
        r0.d = 0.0f;
        c();
    }

    @Override // d19.g
    public final void destroy() {
        c();
        ValueAnimator r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.b;
        if (r1 == null) goto L8;
        r1.removeAllListeners();
    L8:
        ValueAnimator r2 = this.c;
        if (r2 == null) goto L11;
        r2.removeAllUpdateListeners();
    L11:
        ValueAnimator r3 = this.c;
        if (r3 == null) goto L14;
        r3.removeAllListeners();
    L14:
        this.b = null;
        this.c = null;
        f r4 = this.a;
        r4.b = 0.0f;
        r4.d = 0.0f;
    }

    public ScreenEdgeEffectGLView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // d19.g
    public void setAudioAmplitude(float r2) {
        this.a.d = r2;
    }

    @Override // d19.g
    public void setDarkMode(boolean r2) {
        f r0 = this.a;
        r0.e = r2 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [d19.a] */
    public ScreenEdgeEffectGLView(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        f r9 = new f();
        this.a = r9;
        final d19.b r0 = new d19.b(r7, this, r9);
        Object r10 = r0.a.getSystemService("activity");
        ConfigurationInfo r2 = null;
        if ((r10 instanceof ActivityManager) == false) goto L5;
        ActivityManager r11 = (ActivityManager) r10;
    L6:
        if (r11 == null) goto L9;
        r2 = r11.getDeviceConfigurationInfo();
    L9:
        if (r2 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        FLogger.a.i("EdgeEffectEGLManager", "[setupEGL] supportsEs3: " + r3);
        if (r3 == false) goto L17;
        int r4 = 3;
    L18:
        r0.b.setEGLContextFactory(new d19.b.c(r4, new d19.a(r0)));
        r0.b.setEGLConfigChooser(new d19.b.C0123b(r4));
        r0.b.getHolder().setFormat(-3);
        r0.b.setZOrderOnTop(true);
        r0.b.setRenderer(r0.c);
        r0.b.setRenderMode(0);
        Resources r12 = getResources();
        r9.c = WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density;
        return;
    L17:
        r4 = 2;
        goto L18
    L11:
        if (r2.reqGlEsVersion < 196608) goto L13;
        r3 = true;
        goto L14
    L5:
        r11 = null;
        goto L6
    }

    @Override // d19.g
    public final void a(f2 r4, g2 r5) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{this.a.b, 0.0f});
        r0.setDuration(100);
        r0.setInterpolator(new LinearInterpolator());
        r0.addUpdateListener(new i(this));
        Intrinsics.checkNotNull(r0);
        r0.addListener(new l(this, r4, r5));
        r0.start();
        this.c = r0;
    }

    @Override // d19.g
    public final void b(Function1<? super Animator, Unit> r4, Function1<? super Animator, Unit> r5) {
        d();
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{this.a.b, 1.0f});
        r0.setDuration(300);
        r0.setInterpolator(new DecelerateInterpolator());
        r0.addUpdateListener(new h(this));
        Intrinsics.checkNotNull(r0);
        r0.addListener(new d(this, r4, r5));
        r0.start();
        this.b = r0;
    }
}
