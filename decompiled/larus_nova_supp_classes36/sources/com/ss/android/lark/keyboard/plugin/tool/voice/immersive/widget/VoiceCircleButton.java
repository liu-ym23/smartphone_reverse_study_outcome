package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\tH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0014J\u0010\u0010*\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020\u001aJ\u0010\u0010,\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020\u001aJ8\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceCircleButton;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "normalCircleColor", "", "normalCircleColorDM", "expandedCircleColor", "normalIconTintColor", "expandedIconTintColor", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconNonCnDrawable", "currentIconDrawable", "iconRotateAngle", "", "normalRadius", "expandedRadius", "iconSize", "paint", "Landroid/graphics/Paint;", "isNormal", "", "currentCircleRadius", "currentCircleColor", "currentIconColor", "isNightMode", "()Z", "isNightMode$delegate", "Lkotlin/Lazy;", "circleColor", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "scaleUpWithAnimationIfNeed", "needAnimation", "scaleDownWithAnimationIfNeed", "buildAnimator", "Landroid/animation/ValueAnimator;", "startRadius", "endRadius", "startColor", "endColor", "startIconColor", "endIconColor", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VoiceCircleButton extends View {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Drawable f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final Paint k;
    public float l;
    public int m;
    public int n;
    public final Lazy o;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ VoiceCircleButton a;
        public final /* synthetic */ ArgbEvaluator b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        public a(VoiceCircleButton r1, ArgbEvaluator r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r6) {
            Intrinsics.checkNotNullParameter(r6, "animation");
            VoiceCircleButton r0 = this.a;
            Object r1 = r6.getAnimatedValue();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Float");
            r0.l = ((Float) r1).floatValue();
            float r7 = r6.getAnimatedFraction();
            VoiceCircleButton r2 = this.a;
            Object r3 = this.b.evaluate(r7, Integer.valueOf(this.c), Integer.valueOf(this.d));
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            r2.m = ((Integer) r3).intValue();
            VoiceCircleButton r4 = this.a;
            Object r8 = this.b.evaluate(r7, Integer.valueOf(this.e), Integer.valueOf(this.f));
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Int");
            r4.n = ((Integer) r8).intValue();
            this.a.invalidate();
        }
    }

    public final void c() {
        float r1 = this.h;
        float r2 = this.i;
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L5;
        int r0 = this.b;
    L6:
        a(r1, r2, r0, this.c, this.d, this.e).start();
        return;
    L5:
        r0 = this.a;
        goto L6
    }

    public final void b(boolean r8) {
        if (r8 == false) goto L8;
        float r1 = this.i;
        float r2 = this.h;
        int r3 = this.c;
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L6;
        int r9 = this.b;
    L7:
        a(r1, r2, r3, r9, this.e, this.d).start();
        return;
    L6:
        r9 = this.a;
        goto L7
    L8:
        this.l = this.h;
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L11;
        int r10 = this.b;
    L12:
        this.m = r10;
        this.n = this.d;
        return;
    L11:
        r10 = this.a;
        goto L12
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        this.k.setColor(this.m);
        r8.drawCircle(r0, r2, this.l, this.k);
        Drawable r1 = this.f;
        if (r1 == null) goto L5;
        float r3 = (getWidth() / 2.0f) - (this.j / 2.0f);
        float r4 = (getHeight() / 2.0f) - (this.j / 2.0f);
        r8.save();
        r8.rotate(this.g, r8.getWidth() / 2.0f, r8.getHeight() / 2.0f);
        r1.setTint(this.n);
        float r5 = this.j;
        r1.setBounds((int) r3, (int) r4, (int) (r3 + r5), (int) (r4 + r5));
        r1.draw(r8);
        r8.restore();
    L5:
        super.onDraw(r8);
    }

    public VoiceCircleButton(final Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "attributeSet");
        super(r9, r10);
        Paint r0 = new Paint(5);
        r0.setStyle(Paint.Style.FILL);
        this.k = r0;
        Lazy r1 = LazyKt.lazy(new VoiceCircleButton$isNightMode$2(r9));
        this.o = r1;
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, new int[]{2130970005, 2130970006, 2130970007, 2130970284, 2130970290, 2130970293, 2130970294, 2130972833, 2130972834, 2130972835, 2130972836}, 0, 0);
        int r12 = r11.getColor(7, -7829368);     // Catch: Throwable -> L13
        this.a = r12;     // Catch: Throwable -> L13
        int r2 = r11.getColor(8, -7829368);     // Catch: Throwable -> L13
        this.b = r2;     // Catch: Throwable -> L13
        this.c = r11.getColor(0, -65536);     // Catch: Throwable -> L13
        int r3 = r11.getColor(9, -16777216);     // Catch: Throwable -> L13
        this.d = r3;     // Catch: Throwable -> L13
        this.e = r11.getColor(1, -65536);     // Catch: Throwable -> L13
        Drawable r4 = r11.getDrawable(3);     // Catch: Throwable -> L13
        Drawable r5 = r11.getDrawable(4);     // Catch: Throwable -> L13
        this.g = r11.getFloat(5, 8.0f);     // Catch: Throwable -> L13
        float r6 = r11.getDimension(10, 38.0f);     // Catch: Throwable -> L13
        this.h = r6;     // Catch: Throwable -> L13
        this.i = r11.getDimension(2, 44.0f);     // Catch: Throwable -> L13
        this.j = r11.getDimension(6, 24.0f);     // Catch: Throwable -> L13
        if (KeyboardVoiceModule.a().isZh() == true) goto L7;
        r4 = r5;
    L7:
        this.f = r4;     // Catch: Throwable -> L13
        this.l = r6;     // Catch: Throwable -> L13
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L10;
        r12 = r2;
    L10:
        this.m = r12;     // Catch: Throwable -> L13
        this.n = r3;     // Catch: Throwable -> L13
        r11.recycle();
        return;
    L13:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        int r3 = RangesKt.coerceAtMost(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
        setMeasuredDimension(r3, r3);
    }

    public final ValueAnimator a(float r8, float r9, int r10, int r11, int r12, int r13) {
        ArgbEvaluator r2 = new ArgbEvaluator();
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{r8, r9});
        r14.setDuration(200);
        r14.setInterpolator(new AccelerateInterpolator());
        r14.addUpdateListener(new a(this, r2, r10, r11, r12, r13));
        Intrinsics.checkNotNull(r14);
        return r14;
    }
}
