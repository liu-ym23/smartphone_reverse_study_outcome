package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/InviteGuideEffectView;", "Landroid/view/View;", "", "visibility", "", "setVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InviteGuideEffectView extends View {
    public final float a;
    public final float b;
    public float c;
    public final Paint d;
    public SweepGradient e;
    public final int[] f;
    public final RectF g;
    public ValueAnimator h;
    public ValueAnimator i;
    public AnimatorSet j;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ InviteGuideEffectView a;

        public b(InviteGuideEffectView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            if ((r3 instanceof Float) == true) goto L5;
            r3 = null;
        L5:
            Float r4 = (Float) r3;
            if (r4 == null) goto L9;
            float r5 = r4.floatValue();
            InviteGuideEffectView r0 = this.a;
            r0.c = r5;
            r0.invalidate();
            return;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ InviteGuideEffectView a;

        public c(InviteGuideEffectView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            if ((r3 instanceof Float) == true) goto L5;
            r3 = null;
        L5:
            Float r4 = (Float) r3;
            if (r4 == null) goto L9;
            float r5 = r4.floatValue();
            this.a.setAlpha(r5);
            return;
        }
    }

    static {
    }

    public InviteGuideEffectView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InviteGuideEffectView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        ValueAnimator r0 = this.h;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.i;
        if (r1 == null) goto L8;
        r1.removeAllUpdateListeners();
    L8:
        ValueAnimator r2 = this.h;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = this.i;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        AnimatorSet r4 = this.j;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public final void a() {
        b();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.a, this.b});
        ValueAnimator r5 = null;
        if (r1 == null) goto L5;
        r1.setDuration(1000);
        r1.setRepeatMode(2);
        r1.setRepeatCount(-1);
        r1.addUpdateListener(new b(this));
        Unit r8 = Unit.INSTANCE;
    L6:
        this.h = r1;
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r2 == null) goto L9;
        r2.setDuration(1000);
        r2.setRepeatMode(2);
        r2.setRepeatCount(-1);
        r2.addUpdateListener(new c(this));
        Unit r3 = Unit.INSTANCE;
        r5 = r2;
    L9:
        this.i = r5;
        AnimatorSet r4 = new AnimatorSet();
        r4.playTogether(new Animator[]{this.h, this.i});
        r4.setDuration(1000);
        Unit r0 = Unit.INSTANCE;
        this.j = r4;
        r4.start();
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L6;
        a();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        this.d.setStrokeWidth(this.c);
        r3.drawRect(this.g, this.d);
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        a();
        return;
    L5:
        b();
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.e != null) goto L5;
        SweepGradient r6 = new SweepGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.f, null);
        this.e = r6;
        this.d.setShader(r6);
    L5:
        RectF r7 = this.g;
        r7.right = 0.0f;
        r7.left = getMeasuredWidth();
        RectF r8 = this.g;
        r8.top = 0.0f;
        r8.bottom = getMeasuredHeight();
    }

    public InviteGuideEffectView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        float r7 = UtilityKotlinExtentionsKt.h(1);
        this.a = r7;
        this.b = UtilityKotlinExtentionsKt.h(10);
        this.c = r7;
        Paint r8 = new Paint();
        this.d = r8;
        this.f = new int[]{ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF")};
        this.g = new RectF();
        r8.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ InviteGuideEffectView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
