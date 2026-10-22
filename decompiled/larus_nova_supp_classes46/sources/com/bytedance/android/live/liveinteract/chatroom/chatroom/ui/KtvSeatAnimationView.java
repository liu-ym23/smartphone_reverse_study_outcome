package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.ktv.IKtvSeatAnimationView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/KtvSeatAnimationView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdkapi/ktv/IKtvSeatAnimationView;", "", "visibility", "", "setVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSeatAnimationView extends View implements IKtvSeatAnimationView {
    public final float a;
    public final float b;
    public float c;
    public float d;
    public final Paint e;
    public SweepGradient f;
    public final int[] g;
    public final RectF h;
    public final long i;
    public ValueAnimator j;
    public ValueAnimator k;
    public ValueAnimator l;
    public AnimatorSet m;
    public final Matrix n;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ KtvSeatAnimationView a;

        public a(KtvSeatAnimationView r1) {
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
            KtvSeatAnimationView r0 = this.a;
            r0.c = r5;
            r0.invalidate();
            return;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ KtvSeatAnimationView a;

        public b(KtvSeatAnimationView r1) {
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
            KtvSeatAnimationView r0 = this.a;
            r0.d = r5;
            r0.invalidate();
            return;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ KtvSeatAnimationView a;

        public c(KtvSeatAnimationView r1) {
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

    public KtvSeatAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvSeatAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        ValueAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.k;
        if (r1 == null) goto L8;
        r1.removeAllUpdateListeners();
    L8:
        ValueAnimator r2 = this.l;
        if (r2 == null) goto L11;
        r2.removeAllUpdateListeners();
    L11:
        ValueAnimator r3 = this.j;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        ValueAnimator r4 = this.k;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        ValueAnimator r5 = this.l;
        if (r5 == null) goto L20;
        r5.cancel();
    L20:
        AnimatorSet r6 = this.m;
        if (r6 == null) goto L23;
        r6.cancel();
    L23:
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
    }

    public final void a() {
        b();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.a, this.b});
        ValueAnimator r5 = null;
        if (r1 == null) goto L5;
        r1.setDuration(this.i);
        r1.setRepeatMode(2);
        r1.setRepeatCount(-1);
        r1.addUpdateListener(new a(this));
        Unit r6 = Unit.INSTANCE;
    L6:
        this.j = r1;
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        if (r2 == null) goto L9;
        r2.setDuration(this.i);
        r2.setRepeatMode(1);
        r2.setRepeatCount(-1);
        r2.addUpdateListener(new b(this));
        Unit r7 = Unit.INSTANCE;
    L10:
        this.k = r2;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r3 == null) goto L13;
        r3.setDuration(this.i);
        r3.setRepeatMode(2);
        r3.setRepeatCount(-1);
        r3.addUpdateListener(new c(this));
        Unit r4 = Unit.INSTANCE;
        r5 = r3;
    L13:
        this.l = r5;
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(new Animator[]{this.j, this.k, this.l});
        r8.setDuration(this.i);
        Unit r0 = Unit.INSTANCE;
        this.m = r8;
        r8.start();
        return;
    L9:
        r2 = null;
        goto L10
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
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        this.e.setStrokeWidth(this.c);
        this.n.setRotate(this.d, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        SweepGradient r0 = this.f;
        if (r0 == null) goto L5;
        r0.setLocalMatrix(this.n);
    L5:
        r6.drawRect(this.h, this.e);
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
        if (this.f != null) goto L5;
        SweepGradient r6 = new SweepGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.g, null);
        this.f = r6;
        this.e.setShader(r6);
    L5:
        RectF r7 = this.h;
        r7.right = 0.0f;
        r7.left = getMeasuredWidth();
        RectF r8 = this.h;
        r8.top = 0.0f;
        r8.bottom = getMeasuredHeight();
    }

    public KtvSeatAnimationView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        float r8 = UtilityKotlinExtentionsKt.h(1);
        this.a = r8;
        this.b = UtilityKotlinExtentionsKt.h(3);
        this.c = r8;
        Paint r9 = new Paint();
        this.e = r9;
        this.g = new int[]{ColorProtector.parseColor("#63E5FF"), ColorProtector.parseColor("#A2BDFF"), ColorProtector.parseColor("#FF72C8"), ColorProtector.parseColor("#A2BDFF"), ColorProtector.parseColor("#63E5FF")};
        this.h = new RectF();
        this.i = 1000;
        this.n = new Matrix();
        r9.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ KtvSeatAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
