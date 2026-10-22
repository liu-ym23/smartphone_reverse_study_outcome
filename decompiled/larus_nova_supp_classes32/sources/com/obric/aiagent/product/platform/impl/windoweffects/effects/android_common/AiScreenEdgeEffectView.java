package com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import eaa.c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ;\u0010 \u001a\u00020\u001e2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$JR\u0010)\u001a\u00020\u001e2%\b\u0002\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J+\u0010*\u001a\u00020\u001e2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J+\u0010+\u001a\u00020\u001e2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0$J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J(\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0014J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0018H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u001eH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u0018\u0010B\u001a\u00020\u0018*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "activeEffectTimeoutMs", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IJ)V", "getActiveEffectTimeoutMs", "()J", "shader", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/AiScreenEdgeEffectShader;", "paint", "Landroid/graphics/Paint;", "timeAnimator", "Landroid/animation/ValueAnimator;", "fadeAnimator", "shimmerAnimator", "captureAnimator", "currentAlpha", NameKeys.UnloadStrategy_No_Strategy, "currentCaptureProgress", "currentShimmerProgress", "isPreparedToShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "prepareToShow", NameKeys.UnloadStrategy_No_Strategy, "cancelShow", "playFadeInAnimation", "onEnd", "Lkotlin/Function0;", "onCancel", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "animator", "playFadeOutAnimation", "playShimmerAnimation", "playCaptureAnimation", "isPlayingShimmerAnimation", NameKeys.UnloadStrategy_No_Strategy, "isPlayingCaptureAnimation", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setShimmerProgress", "progress", "setCaptureProgress", "initializeShader", "startTimeAnimation", "setScreenCornerRadii", "density", "getDensity", "()F", "density$delegate", "Lkotlin/Lazy;", "dp", "getDp", "(F)F", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiScreenEdgeEffectView extends View {
    public static final /* synthetic */ int k = 0;
    public final long a;
    public final eaa.a b;
    public final Paint c;
    public ValueAnimator d;
    public ValueAnimator e;
    public ValueAnimator f;
    public ValueAnimator g;
    public float h;
    public final AtomicBoolean i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.b.invoke(r2);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.invoke(r2);
        }

        public b(Function1 r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public AiScreenEdgeEffectView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14);
    }

    public AiScreenEdgeEffectView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12);
    }

    public AiScreenEdgeEffectView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8);
    }

    private final void setCaptureProgress(float r1) {
    }

    private final void setShimmerProgress(float r1) {
    }

    private final float getDensity() {
        return ((Number) this.j.getValue()).floatValue();
    }

    public final void a() {
        ILogDepend.a.i("AiScreenEdgeEffectView", "cancelShow");
        setVisibility(8);
        this.i.set(false);
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.e;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ValueAnimator r2 = this.f;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = this.g;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public final long getActiveEffectTimeoutMs() {
        return this.a;
    }

    public final float b(float r2) {
        return r2 * getDensity();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (r2.isHardwareAccelerated() == true) goto L5;
        return;
    L5:
        super.onDraw(r2);
        r2.drawPaint(this.c);
    }

    public final void c(Function1<? super Animator, Unit> r8, Function1<? super Animator, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "onEnd");
        Intrinsics.checkNotNullParameter(r9, "onCancel");
        ILogDepend.Companion r0 = ILogDepend.a;
        r0.i("AiScreenEdgeEffectView", "playFadeOutAnimation");
        ValueAnimator r2 = this.e;
        if (r2 == null) goto L6;
        r2.cancel();
    L6:
        if (Math.abs(this.h - 0.0f) >= 1.0E-6f) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        r0.i("AiScreenEdgeEffectView", "playFadeOutAnimation: no need to play");
        r8.invoke(null);
        return;
    L12:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.h, 0.0f});
        r1.setDuration(100);
        r1.setInterpolator(new LinearInterpolator());
        r1.addUpdateListener(new c(this));
        Intrinsics.checkNotNull(r1);
        r1.addListener(new b(r8, r9));
        r1.start();
        this.e = r1;
        return;
    L8:
        r3 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super.onSizeChanged(r2, r3, r4, r5);
        eaa.a r6 = this.b;
        r6.setFloatUniform("uResolution", r2, r3);
        Resources r7 = Resources.getSystem();
        r6.setFloatUniform("uDensity", WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density);
        eaa.a r8 = this.b;
        String r9 = t9a.b.a().d();
        switch(r9.hashCode()) {
            case -2002884280: goto L23;
            case -2002884275: goto L20;
            case -1048984789: goto L16;
            case -807117175: goto L13;
            case 3440915: goto L9;
            case 1328894480: goto L6;
            default: goto L26;
        };
    L26:
        r8.a(b(44.0f), b(44.0f), b(42.0f), b(42.0f));
        return;
    L6:
        if (r9.equals("nerida-lite") == false) goto L26;
    L18:
        r8.a(b(47.0f), b(47.0f), b(47.0f), b(47.0f));
        return;
    L9:
        if (r9.equals("pike") == false) goto L26;
        r8.a(134.0f, 134.0f, 134.0f, 134.0f);
        return;
    L13:
        if (r9.equals("pacific") == false) goto L26;
        r8.a(b(44.0f), b(44.0f), b(42.0f), b(42.0f));
        return;
    L16:
        if (r9.equals("nerida") == true) goto L18;
    L20:
        if (r9.equals("Genesis-R") == false) goto L26;
    L25:
        r8.a(b(57.0f), b(57.0f), b(57.0f), b(57.0f));
        return;
    L23:
        if (r9.equals("Genesis-M") == true) goto L25;
        goto L25
    }

    public AiScreenEdgeEffectView(Context r4, AttributeSet r5, int r6, long r7, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r9 & 8) == 0) goto L11;
        r7 = 300000;
    L11:
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = r7;
        eaa.a r8 = new eaa.a();
        this.b = r8;
        Paint r10 = new Paint();
        this.c = r10;
        this.i = new AtomicBoolean(false);
        setLayerType(2, null);
        setBackground(null);
        r10.setShader(r8);
        this.j = LazyKt.lazy(new eaa.b());
    }
}
