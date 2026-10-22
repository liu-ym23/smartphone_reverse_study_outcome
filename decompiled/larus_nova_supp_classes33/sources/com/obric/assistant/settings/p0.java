package com.obric.assistant.settings;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p0 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ View.OnLayoutChangeListener b;
        public final /* synthetic */ GradientDrawable c;
        public final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.obric.assistant.settings.p0$a$a, reason: collision with other inner class name */
        public static final class C0024a extends AnimatorListenerAdapter {
            public final /* synthetic */ View a;
            public final /* synthetic */ View.OnLayoutChangeListener b;
            public final /* synthetic */ GradientDrawable c;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                this.a.removeOnLayoutChangeListener(this.b);
                this.a.getOverlay().remove(this.c);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                this.a.removeOnLayoutChangeListener(this.b);
                this.a.getOverlay().remove(this.c);
            }

            public C0024a(View r1, View.OnLayoutChangeListener r2, GradientDrawable r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.removeOnLayoutChangeListener(this.b);
            this.a.getOverlay().remove(this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            this.c.setColor(this.d);
            this.c.setAlpha(255);
            final View r5 = this.a;
            final GradientDrawable r0 = this.c;
            final View.OnLayoutChangeListener r1 = this.b;
            r5.postDelayed(new n0(r0, r5, r1), 1000);
        }

        public a(View r1, l0 r2, GradientDrawable r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public static Rect a(ViewGroup r8) {
        Rect r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        int r1 = r8.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L25;
        View r3 = r8.getChildAt(r2);
        if (r3.getVisibility() != 0) goto L24;
        if (r3.getWidth() <= 0) goto L24;
        if (r3.getHeight() <= 0) goto L24;
        if ((r3 instanceof ViewGroup) == false) goto L20;
        ViewGroup r4 = (ViewGroup) r3;
        Rect r5 = a(r4);
        if (r5 == null) goto L19;
        r8.offsetDescendantRectToMyCoords(r3, r5);
    L21:
        if (r0 == null) goto L23;
        r0.union(r5);
        goto L24
    L23:
        r0 = r5;
        goto L24
    L19:
        r5 = new Rect(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
        goto L21
    L20:
        r5 = new Rect(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
    L24:
        r2 = r2 + 1;
        goto L6
    L25:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.obric.assistant.settings.k0] */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View$OnLayoutChangeListener, com.obric.assistant.settings.l0] */
    public static void d(final View r7) {
        Intrinsics.checkNotNullParameter(r7, "targetView");
        int r0 = ContextCompat.getColor(r7.getContext(), 2131104781);
        final GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setColor(r0);
        r1.setAlpha(0);
        float[] r4 = null;
        if ((r7 instanceof OCardListItem) == false) goto L5;
        OCardListItem r3 = (OCardListItem) r7;
    L6:
        if (r3 == null) goto L10;
        FrameLayout r5 = r3.getCardContainer();
        if (r5 == null) goto L10;
        Drawable r6 = r5.getBackground();
    L12:
        if ((r6 instanceof GradientDrawable) == false) goto L14;
        GradientDrawable r8 = (GradientDrawable) r6;
    L15:
        if (r8 == null) goto L17;
        r4 = r8.getCornerRadii();
    L17:
        if (r4 == null) goto L19;
        r1.setCornerRadii(Arrays.copyOf(r4, r4.length));
    L23:
        final ?? r9 = new k0(r7, r1);
        ?? r10 = new l0(r9);
        r9.invoke();
        r7.animate().cancel();
        r7.getOverlay().clear();
        r7.getOverlay().add(r1);
        r7.addOnLayoutChangeListener(r10);
        ValueAnimator r11 = ValueAnimator.ofInt(new int[]{0, 224});
        r11.setDuration(220);
        r11.setInterpolator(new DecelerateInterpolator());
        r11.addUpdateListener(new m0(r1));
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(new Animator[]{r11});
        r12.addListener(new a(r7, r10, r1, r0));
        r12.start();
        return;
    L19:
        if (r8 == null) goto L21;
        float r13 = r8.getCornerRadius();
    L22:
        r1.setCornerRadius(r13);
        goto L23
    L21:
        r13 = b(r7.getContext(), 16.0f);
        goto L22
    L14:
        r8 = null;
    L10:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static float b(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    public static Rect c(Rect r5, int r6, int r7, int r8) {
        int r0 = RangesKt.coerceAtMost(r6, RangesKt.coerceAtLeast(r5.width() - 1, 0) / 2);
        int r9 = RangesKt.coerceAtMost(r6, RangesKt.coerceAtLeast(r5.height() - 1, 0) / 2);
        return new Rect(RangesKt.coerceAtLeast(r5.left + r0, 0), RangesKt.coerceAtLeast(r5.top + r9, 0), RangesKt.coerceAtMost(r5.right - r0, r7), RangesKt.coerceAtMost(r5.bottom - r9, r8));
    }
}
