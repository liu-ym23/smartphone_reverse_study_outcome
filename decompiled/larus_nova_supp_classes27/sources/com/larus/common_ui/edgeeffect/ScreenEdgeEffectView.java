package com.larus.common_ui.edgeeffect;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.utils.b0;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import d19.g;
import d19.m;
import d19.n;
import d19.o;
import d19.p;
import d19.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016JT\u0010\u001a\u001a\u00020\u00182%\u0010\u001b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001c2#\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cH\u0016JT\u0010\"\u001a\u00020\u00182%\u0010\u001b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001c2#\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cH\u0016J(\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0014J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0014J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0002J\b\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/common_ui/edgeeffect/ScreenEdgeEffectView;", "Landroid/view/View;", "Lcom/larus/common_ui/edgeeffect/IScreenEdgeEffectView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shader", "Lcom/larus/common_ui/edgeeffect/ScreenEdgeEffectShader;", "paint", "Landroid/graphics/Paint;", "timeAnimator", "Landroid/animation/ValueAnimator;", "showAnimator", "hideAnimator", "currentAlpha", "", "isAnimationActive", "", "init", "", "destroy", "showScreenEdgeEffect", "onEnd", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", "name", "animator", "onCancel", "dismissScreenEdgeEffect", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setAudioAmplitude", "amplitude", "setDarkMode", "darkMode", "pauseEdgeEffect", "resumeEdgeEffect", "initializeShader", "startTimeAnimation", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenEdgeEffectView extends View implements g {
    public static final /* synthetic */ int h = 0;
    public final m a;
    public final Paint b;
    public ValueAnimator c;
    public ValueAnimator d;
    public ValueAnimator e;
    public float f;
    public boolean g;

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
        public final /* synthetic */ ScreenEdgeEffectView a;
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
            FLogger.a.i("ScreenEdgeEffectView", "showScreenEdgeEffect onCancel");
            this.a.post(new c(this.c, r4));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            FLogger.a.i("ScreenEdgeEffectView", "showScreenEdgeEffect onEnd");
            this.a.post(new b(this.b, r4));
        }

        public d(ScreenEdgeEffectView r1, Function1 r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public ScreenEdgeEffectView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ScreenEdgeEffectView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // d19.g
    public final void init() {
        this.f = 0.0f;
        m r1 = this.a;
        boolean r3 = true;
        if (r1.a != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        r1.setFloatUniform("uTime", 0.0f);
        r1.a = 0.0f;
    L8:
        r1.a(this.f);
        Resources r0 = getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        if (r1.c == r4) goto L12;
        r3 = false;
    L12:
        if (r3 == true) goto L15;
        r1.setFloatUniform("uDensity", r4);
        r1.c = r4;
        return;
    L15:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // d19.g
    public final void c() {
        if (this.g == true) goto L5;
        return;
    L5:
        FLogger.a.i("ScreenEdgeEffectView", "pauseEdgeEffect");
        this.g = false;
        ValueAnimator r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isRunning() == false) goto L12;
        r0.pause();
        return;
    }

    @Override // d19.g
    public final void d() {
        if (this.g == false) goto L5;
        return;
    L5:
        FLogger.a.i("ScreenEdgeEffectView", "resumeEdgeEffect");
        this.g = true;
        ValueAnimator r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isPaused() == false) goto L12;
        r0.resume();
        return;
    }

    @Override // d19.g
    public final void destroy() {
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.c;
        if (r1 == null) goto L8;
        r1.removeAllUpdateListeners();
    L8:
        ValueAnimator r2 = this.d;
        if (r2 == null) goto L11;
        r2.removeAllUpdateListeners();
    L11:
        ValueAnimator r3 = this.d;
        if (r3 == null) goto L14;
        r3.removeAllListeners();
    L14:
        ValueAnimator r4 = this.e;
        if (r4 == null) goto L17;
        r4.removeAllUpdateListeners();
    L17:
        ValueAnimator r5 = this.e;
        if (r5 == null) goto L20;
        r5.removeAllListeners();
    L20:
        this.c = null;
        this.d = null;
        this.e = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        if (this.f >= 0.001f) goto L5;
        return;
    L5:
        r3.drawPaint(this.b);
    }

    @Override // d19.g
    public void setAudioAmplitude(float r3) {
        m r0 = this.a;
        if (r0.d != r3) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0.setFloatUniform("uAudioAmplitude", r3);
        r0.d = r3;
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // d19.g
    public void setDarkMode(boolean r3) {
        m r0 = this.a;
        if (r0.e == r3) goto L6;
        r0.setIntUniform("uDarkMode", r3 ? 1 : 0);
        r0.e = r3 ? 1 : 0;
        return;
    }

    @Override // d19.g
    public final void a(f2 r5, g2 r6) {
        if (b0.a(this.f, 0.0f) == false) goto L6;
        r5.invoke(null);
        return;
    L6:
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{this.f, 0.0f});
        r0.setDuration(100);
        r0.setInterpolator(new LinearInterpolator());
        r0.addUpdateListener(new o(this));
        Intrinsics.checkNotNull(r0);
        r0.addListener(new s(this, r5, r6));
        r0.start();
        this.e = r0;
    }

    @Override // d19.g
    public final void b(Function1<? super Animator, Unit> r8, Function1<? super Animator, Unit> r9) {
        if (b0.a(this.f, 1.0f) == false) goto L7;
        if (r8 == null) goto L19;
        r8.invoke(null);
        return;
    L19:
        return;
    L7:
        ValueAnimator r0 = this.c;
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L14:
        if (r1 == true) goto L17;
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, Float.MAX_VALUE});
        r2.setDuration(j0.G2_OTA_RECOVERY_BLOCK_FOREVER);
        r2.setInterpolator(new LinearInterpolator());
        r2.setRepeatCount(-1);
        r2.addUpdateListener(new p(this));
        r2.start();
        this.c = r2;
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.f, 1.0f});
        r3.setDuration(300);
        r3.setInterpolator(new DecelerateInterpolator());
        r3.addUpdateListener(new n(this));
        Intrinsics.checkNotNull(r3);
        r3.addListener(new d(this, r8, r9));
        r3.start();
        this.d = r3;
        return;
    L10:
        if (r0.isRunning() != true) goto L12;
        r1 = true;
        goto L14
    }

    public ScreenEdgeEffectView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        m r5 = new m();
        this.a = r5;
        Paint r6 = new Paint();
        this.b = r6;
        setLayerType(2, null);
        setBackground(null);
        r6.setShader(r5);
    }

    public /* synthetic */ ScreenEdgeEffectView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        m r7 = this.a;
        float r8 = r3;
        float r9 = r4;
        boolean r0 = true;
        if (r7.f != r8) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
    L12:
        r7.setFloatUniform("uResolution", r8, r9);
        r7.f = r8;
        r7.g = r9;
    L13:
        Resources r11 = Resources.getSystem();
        float r12 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density;
        if (r7.c == r12) goto L17;
        r0 = false;
    L17:
        if (r0 == true) goto L20;
        r7.setFloatUniform("uDensity", r12);
        r7.c = r12;
        return;
    L20:
        return;
    L8:
        if (r7.g != r9) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == true) goto L13;
    L10:
        r13 = false;
        goto L11
    L5:
        r10 = false;
        goto L6
    }
}
