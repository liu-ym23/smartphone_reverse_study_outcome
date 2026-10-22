package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/PreviewProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "color", "", "setProgressColor", "", "percent", "setProgress", "", "progress", "setProgressText", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "getDragProgressListener", "()Lkotlin/jvm/functions/Function1;", "setDragProgressListener", "(Lkotlin/jvm/functions/Function1;)V", "dragProgressListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PreviewProgressView extends ConstraintLayout {
    public final View a;
    public final View b;
    public final TextView c;
    public float d;
    public Float e;
    public Function1<? super Float, Unit> f;
    public float g;
    public boolean h;
    public Boolean i;
    public View j;
    public final int k;
    public ViewPager2 l;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ PreviewProgressView a;

        public a(PreviewProgressView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r10v4, types: [android.view.ViewGroup, com.bytedance.android.live.ktv.common.view.PreviewProgressView] */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r11, MotionEvent r12) {
            int r13 = r12.getAction();
            boolean r3 = false;
            if (r13 == 0) goto L52;
            if (r13 != 1) goto L6;
            PreviewProgressView r14 = this.a;
            r14.h = false;
            if (r12.getX() < this.a.g) goto L46;
            r3 = true;
        L46:
            r14.i = Boolean.valueOf(r3);
            Function1<Float, Unit> r15 = this.a.getDragProgressListener();
            if (r15 == null) goto L49;
            Unit r16 = (Unit) r15.invoke(Float.valueOf(this.a.d));
        L49:
            PreviewProgressView.R5(this.a);
            ViewPager2 r17 = this.a.l;
            if (r17 == null) goto L95;
            r17.setUserInputEnabled(true);
        L95:
            return true;
        L6:
            if (r13 != 2) goto L8;
            float r18 = r12.getX();
            PreviewProgressView r19 = this.a;
            float r4 = r19.g;
            float r5 = r4 + (r18 - r4);
            View r110 = r19.b;
            if (r110 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L23:
            float r6 = r5 / r110.getWidth();
            if (r6 <= 1.0f) goto L27;
            r19.d = 1.0f;
        L30:
            View r111 = this.a.a;
            if (r111 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L33:
            PreviewProgressView r112 = this.a;
            float r0 = r112.d;
            View r113 = r112.b;
            if (r113 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L36:
            q32.a.a(r111, (int) (r0 * r113.getWidth()));
            PreviewProgressView r114 = this.a;
            View r115 = r114.j;
            if (r115 == null) goto L42;
            float r1 = r114.d;
            View r116 = r114.b;
            if (r116 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L41:
            r115.setX((r1 * r116.getWidth()) - (this.a.k / 2.0f));
        L42:
            this.a.h = true;
            goto L95
        L27:
            if (r6 >= 0.0f) goto L29;
            r19.d = 0.0f;
            goto L30
        L29:
            r19.d = r6;
            goto L30
        L8:
            if (r13 != 3) goto L10;
            PreviewProgressView.R5(this.a);
            goto L95
        L10:
            if (r13 != 4) goto L95;
            View r117 = this.a.a;
            if (r117 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L15:
            PreviewProgressView r118 = this.a;
            float r2 = r118.d;
            View r119 = r118.b;
            if (r119 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L18:
            q32.a.a(r117, (int) (r2 * r119.getWidth()));
            PreviewProgressView.R5(this.a);
            goto L95
        L52:
            this.a.g = r12.getX();
            PreviewProgressView r120 = this.a;
            r120.e = Float.valueOf(r120.d);
            ?? r121 = this.a;
            View r122 = r121.a;
            if (r122 != null) goto L55;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L55:
            Drawable r123 = r122.getBackground();
            View r7 = null;
            if ((r123 instanceof GradientDrawable) == true) goto L58;
            r123 = null;
        L58:
            GradientDrawable r124 = (GradientDrawable) r123;
            if (r124 == null) goto L61;
            r124.setCornerRadius(UtilityKotlinExtentionsKt.h(24));
        L61:
            View r125 = r121.a;
            if (r125 != null) goto L64;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L64:
            View r8 = r121.a;
            if (r8 != null) goto L67;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L67:
            r125.setPivotY(r8.getHeight() / 2.0f);
            View r126 = r121.a;
            if (r126 != null) goto L70;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L70:
            r126.animate().scaleY(2.0f).setDuration(300).start();
            View r127 = r121.j;
            if (r127 != null) goto L91;
            View r128 = new View(r121.getContext());
            r121.j = r128;
            r128.setBackgroundResource(2131253075);
            int r9 = r121.k;
            FrameLayout.LayoutParams r129 = new FrameLayout.LayoutParams(r9, r9);
            View r21 = r121.j;
            if (r21 == null) goto L78;
            View r22 = r121.a;
            if (r22 != null) goto L77;
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        L77:
            r21.setY((-r22.getHeight()) / 2.0f);
        L78:
            View r23 = r121.j;
            if (r23 == null) goto L81;
            r23.setLayoutParams(r129);
        L81:
            View r24 = r121.b;
            if (r24 != null) goto L85;
            Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
        L85:
            if ((r24 instanceof FrameLayout) == false) goto L88;
            r7 = r24;
        L88:
            FrameLayout r25 = (FrameLayout) r7;
            if (r25 == null) goto L92;
            r25.addView(r121.j, r129);
        L92:
            ViewPager2 r130 = this.a.l;
            if (r130 == null) goto L95;
            r130.setUserInputEnabled(false);
            goto L95
        L91:
            r127.setVisibility(0);
            goto L92
        }
    }

    public static final class b {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        ViewPager2 r0 = getParent();
        View r2 = null;
        if ((r0 instanceof View) == true) goto L5;
        r0 = null;
    L5:
        View r1 = (View) r0;
    L6:
        if (r1 == null) goto L14;
        if ((r1 instanceof ViewPager2) == true) goto L14;
        ViewPager2 r3 = r1.getParent();
        if ((r3 instanceof View) == true) goto L12;
        r3 = null;
    L12:
        r1 = (View) r3;
    L14:
        if ((r1 instanceof ViewPager2) == false) goto L17;
        r2 = r1;
    L17:
        this.l = (ViewPager2) r2;
    }

    public final Function1<Float, Unit> getDragProgressListener() {
        return this.f;
    }

    public static final void R5(PreviewProgressView r4) {
        View r0 = r4.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L5:
        Drawable r1 = r0.getBackground();
        if ((r1 instanceof GradientDrawable) == true) goto L8;
        r1 = null;
    L8:
        GradientDrawable r2 = (GradientDrawable) r1;
        if (r2 == null) goto L11;
        r2.setCornerRadius(UtilityKotlinExtentionsKt.h(12));
    L11:
        View r3 = r4.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L14:
        View r5 = r4.a;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L17:
        r3.setPivotY(r5.getHeight() / 2.0f);
        View r6 = r4.a;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L20:
        r6.animate().scaleY(1.0f).setDuration(300).start();
        View r7 = r4.j;
        if (r7 == null) goto L24;
        r7.setVisibility(8);
        return;
    }

    public final void setDragProgressListener(Function1<? super Float, Unit> r1) {
        this.f = r1;
    }

    public final void setProgress(float r4) {
        if (this.e == null) goto L20;
        Boolean r0 = this.i;
        if (r0 == null) goto L20;
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L12;
        if (r4 >= this.d) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(this.i, Boolean.FALSE) == false) goto L20;
        Float r1 = this.e;
        if (r1 == null) goto L16;
        float r2 = r1.floatValue();
    L18:
        if (r4 <= r2) goto L20;
        return;
    L16:
        r2 = 0.0f;
    L20:
        this.e = null;
        this.i = null;
        if (this.h == false) goto L24;
        return;
    L24:
        if (r4 <= 1.0f) goto L27;
        this.d = 1.0f;
    L30:
        View r3 = this.a;
        if (r3 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L33:
        View r5 = this.b;
        if (r5 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("progressViewParent");
    L36:
        q32.a.a(r3, (int) (r5.getWidth() * r4));
        return;
    L27:
        if (r4 >= 0.0f) goto L29;
        this.d = 0.0f;
        goto L30
    L29:
        this.d = r4;
        goto L30
    }

    public final void setProgressColor(int r3) {
        View r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
    L5:
        r0.setBackgroundColor(r3);
    }

    public final void setProgressText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "progress");
        TextView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvProgress");
    L5:
        r0.setText(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewProgressView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.k = UtilityKotlinExtentionsKt.i(10);
        LayoutInflater.from(r2).inflate(2131568192, this);
        this.a = findViewById(2131383333);
        this.b = findViewById(2131383311);
        this.c = (TextView) findViewById(2131391556);
        setOnTouchListener(new a(this));
    }
}
