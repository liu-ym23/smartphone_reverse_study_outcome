package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.obric.cae.R;
import h9.g;
import h9.h;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.WeakHashMap;
import o9.d;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f5165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f5166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f5167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f5168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f5169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5170h;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f5172b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f5173m;

        public a(boolean r8, View r10, View r11) {
            this.f5171a = r8;
            this.f5172b = r10;
            this.f5173m = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            if (this.f5171a == true) goto L6;
            this.f5172b.setVisibility(4);
            View r10 = this.f5173m;
            r10.setAlpha(1.0f);
            r10.setVisibility(0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r8) {
            if (this.f5171a == false) goto L6;
            this.f5172b.setVisibility(0);
            View r10 = this.f5173m;
            r10.setAlpha(0.0f);
            r10.setVisibility(4);
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f5174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t2.b f5175b;
    }

    public FabTransformationBehavior() {
        this.f5165c = new Rect();
        this.f5166d = new RectF();
        this.f5167e = new RectF();
        this.f5168f = new int[2];
    }

    public static Pair A(float r8, float r10, boolean r11, b r12) {
        if (r8 != 0.0f) goto L5;
    L14:
        h r13 = r12.f5174a.c("translationXLinear");
        g r14 = r12.f5174a;
        String r15 = "translationYLinear";
    L16:
        return new Pair(r13, r14.c(r15));
    L5:
        if (r10 == 0.0f) goto L14;
        if (r11 == true) goto L9;
    L10:
        if (r11 == true) goto L13;
        if (r10 <= 0.0f) goto L13;
    L12:
        r13 = r12.f5174a.c("translationXCurveUpwards");
        r14 = r12.f5174a;
        r15 = "translationYCurveUpwards";
    L13:
        r13 = r12.f5174a.c("translationXCurveDownwards");
        r14 = r12.f5174a;
        r15 = "translationYCurveDownwards";
        goto L16
    L9:
        if (r10 < 0.0f) goto L12;
        goto L10
    }

    public static float D(b r8, h r10, float r11) {
        long r12 = r10.f7957a;
        h r13 = r8.f5174a.c("expansion");
        float r14 = r10.b().getInterpolation((((r13.f7957a + r13.f7958b) + 17) - r12) / r10.f7958b);
        LinearInterpolator r15 = h9.a.f7943a;
        return defpackage.a.a(0.0f, r11, r14, r11);
    }

    public final float B(View r8, View r10, t2.b r11) {
        RectF r12 = this.f5166d;
        RectF r13 = this.f5167e;
        E(r8, r12);
        r12.offset(this.f5169g, this.f5170h);
        E(r10, r13);
        r11.getClass();
        return (r13.centerX() - r12.centerX()) + 0.0f;
    }

    public final float C(View r8, View r10, t2.b r11) {
        RectF r12 = this.f5166d;
        RectF r13 = this.f5167e;
        E(r8, r12);
        r12.offset(this.f5169g, this.f5170h);
        E(r10, r13);
        r11.getClass();
        return (r13.centerY() - r12.centerY()) + 0.0f;
    }

    public final void E(View r8, RectF r10) {
        r10.set(0.0f, 0.0f, r8.getWidth(), r8.getHeight());
        int[] r11 = this.f5168f;
        r8.getLocationInWindow(r11);
        r10.offsetTo(r11[0], r11[1]);
        r10.offset((int) (-r8.getTranslationX()), (int) (-r8.getTranslationY()));
    }

    public abstract b F(Context r8, boolean r10);

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean b(CoordinatorLayout r8, View r10, View r11) {
        if (r10.getVisibility() == 8) goto L14;
        if ((r11 instanceof FloatingActionButton) == false) goto L11;
        int r12 = ((FloatingActionButton) r11).getExpandedComponentIdHint();
        if (r12 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r12 == r10.getId()) goto L10;
    L11:
        return false;
    L14:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void c(CoordinatorLayout.f r8) {
        if (r8.f1570h != 0) goto L6;
        r8.f1570h = 80;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet z(View r27, View r28, boolean r29, boolean r30) {
        b r8 = F(r28.getContext(), r29);
        if (r29 == false) goto L5;
        this.f5169g = r27.getTranslationX();
        this.f5170h = r27.getTranslationY();
    L5:
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        WeakHashMap<View, h0> r12 = w.f8437a;
        float r13 = w.i.i(r28) - w.i.i(r27);
        if (r29 == false) goto L10;
        if (r30 == true) goto L9;
        r28.setTranslationZ(-r13);
    L9:
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_Z, new float[]{0.0f});
    L11:
        r8.f5174a.c("elevation").a(r14);
        r10.add(r14);
        RectF r15 = this.f5166d;
        float r16 = B(r27, r28, r8.f5175b);
        float r17 = C(r27, r28, r8.f5175b);
        Pair r18 = A(r16, r17, r29, r8);
        h r19 = (h) r18.first;
        h r110 = (h) r18.second;
        RectF r111 = this.f5167e;
        Rect r20 = this.f5165c;
        if (r29 == false) goto L16;
        if (r30 == true) goto L15;
        r28.setTranslationX(-r16);
        r28.setTranslationY(-r17);
    L15:
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_Y, new float[]{0.0f});
        float r112 = D(r8, r19, -r16);
        float r113 = D(r8, r110, -r17);
        r28.getWindowVisibleDisplayFrame(r20);
        r15.set(r20);
        E(r28, r111);
        r111.offset(r112, r113);
        r111.intersect(r15);
        r15.set(r111);
        ObjectAnimator r114 = r22;
        ObjectAnimator r23 = r21;
    L17:
        r19.a(r23);
        r110.a(r114);
        r10.add(r23);
        r10.add(r114);
        float r24 = r15.width();
        float r115 = r15.height();
        float r116 = B(r27, r28, r8.f5175b);
        float r117 = C(r27, r28, r8.f5175b);
        Pair r118 = A(r116, r117, r29, r8);
        h r119 = (h) r118.first;
        h r120 = (h) r118.second;
        Property r121 = View.TRANSLATION_X;
        float[] r122 = new float[1];
        if (r29 == false) goto L20;
        float r25 = r116;
    L21:
        r122[0] = r25;
        ObjectAnimator r26 = ObjectAnimator.ofFloat(r27, r121, r122);
        Property r123 = View.TRANSLATION_Y;
        float[] r124 = new float[1];
        if (r29 == false) goto L24;
        float r125 = r117;
    L25:
        r124[0] = r125;
        ObjectAnimator r126 = ObjectAnimator.ofFloat(r27, r123, r124);
        r119.a(r26);
        r120.a(r126);
        r10.add(r26);
        r10.add(r126);
        boolean r31 = r28 instanceof d;
        if (r31 == true) goto L28;
    L40:
        ArrayList r127 = r11;
    L41:
        if (r31 == true) goto L43;
        b r210 = r8;
        ArrayList r32 = r10;
        ArrayList r33 = r127;
    L83:
        if (r31 == true) goto L85;
        boolean r34 = r29;
        b r35 = r210;
    L96:
        boolean r36 = r28 instanceof ViewGroup;
        if (r36 == false) goto L122;
        View r37 = r28.findViewById(R.id.mtrl_child_content_container);
        if (r37 != null) goto L112;
        if ((r28 instanceof fa.c) == false) goto L105;
    L110:
        r37 = ((ViewGroup) r28).getChildAt(0);
        goto L112
    L105:
        if ((r28 instanceof fa.b) == true) goto L110;
        if (r36 == false) goto L109;
        ViewGroup r128 = (ViewGroup) r28;
    L114:
        if (r128 == null) goto L122;
        if (r34 == false) goto L120;
        if (r30 == true) goto L119;
        h9.c.f7949a.set(r128, Float.valueOf(0.0f));
    L119:
        ObjectAnimator r38 = ObjectAnimator.ofFloat(r128, h9.c.f7949a, new float[]{1.0f});
    L121:
        r35.f5174a.c("contentFade").a(r38);
        r32.add(r38);
        goto L122
    L120:
        r38 = ObjectAnimator.ofFloat(r128, h9.c.f7949a, new float[]{0.0f});
    L109:
        r128 = null;
    L112:
        if ((r37 instanceof ViewGroup) == false) goto L109;
        r128 = (ViewGroup) r37;
    L122:
        AnimatorSet r39 = new AnimatorSet();
        t2.b.R(r39, r32);
        r39.addListener(new a(r34, r28, r27));
        int r40 = r33.size();
        int r129 = 0;
    L123:
        if (r129 >= r40) goto L125;
        r39.addListener((Animator.AnimatorListener) r33.get(r129));
        r129 = r129 + 1;
        goto L123
    L125:
        return r39;
    L85:
        d r41 = (d) r28;
        WeakHashMap<View, h0> r42 = w.f8437a;
        ColorStateList r43 = w.i.g(r27);
        if (r43 == null) goto L88;
        int r44 = r43.getColorForState(r27.getDrawableState(), r43.getDefaultColor());
    L89:
        int r45 = 16777215 & r44;
        r34 = r29;
        if (r34 == false) goto L94;
        if (r30 == true) goto L93;
        r41.setCircularRevealScrimColor(r44);
    L93:
        ObjectAnimator r46 = ObjectAnimator.ofInt(r41, d.c.f9765a, new int[]{r45});
    L95:
        r46.setEvaluator(h9.b.f7948a);
        r35 = r210;
        r35.f5174a.c("color").a(r46);
        r32.add(r46);
        goto L96
    L94:
        r46 = ObjectAnimator.ofInt(r41, d.c.f9765a, new int[]{r44});
        goto L95
    L88:
        r44 = 0;
        goto L89
    L43:
        d r130 = (d) r28;
        t2.b r131 = r8.f5175b;
        E(r27, r15);
        r15.offset(this.f5169g, this.f5170h);
        E(r28, r111);
        r111.offset(-B(r27, r28, r131), 0.0f);
        float r132 = r15.centerX() - r111.left;
        t2.b r133 = r8.f5175b;
        E(r27, r15);
        r15.offset(this.f5169g, this.f5170h);
        E(r28, r111);
        r111.offset(0.0f, -C(r27, r28, r133));
        float r47 = r15.centerY() - r111.top;
        FloatingActionButton r48 = (FloatingActionButton) r27;
        if (w.g.c(r48) == true) goto L126;
        float r49 = r20.width() / 2.0f;
        h r50 = r8.f5174a.c("expansion");
        if (r29 == false) goto L72;
        if (r30 == true) goto L49;
        r130.setRevealInfo(new d.C0130d(r132, r47, r49));
    L49:
        if (r30 == false) goto L51;
        r49 = r130.getRevealInfo().f9768c;
    L51:
        double r134 = 0.0f - r132;
        ArrayList r211 = r127;
        double r51 = 0.0f - r47;
        float r52 = (float) Math.hypot(r134, r51);
        double r53 = r24 - r132;
        float r54 = (float) Math.hypot(r53, r51);
        double r55 = r115 - r47;
        float r56 = (float) Math.hypot(r53, r55);
        float r57 = (float) Math.hypot(r134, r55);
        if (r52 <= r54) goto L59;
        if (r52 <= r56) goto L59;
        if (r52 <= r57) goto L59;
    L67:
        AnimatorSet r58 = o9.b.a(r130, r132, r47, r52);
        r58.addListener(new c(r130));
        long r59 = r50.f7957a;
        int r60 = (int) r132;
        int r61 = (int) r47;
        if (r59 <= 0) goto L70;
        Animator r62 = ViewAnimationUtils.createCircularReveal(r28, r60, r61, r49, r49);
        r62.setStartDelay(0);
        r62.setDuration(r59);
        ArrayList r63 = r10;
        r63.add(r62);
    L71:
        AnimatorSet r64 = r58;
        r32 = r63;
        r210 = r8;
    L82:
        r50.a(r64);
        r32.add(r64);
        r33 = r211;
        r33.add(new o9.a(r130));
        goto L83
    L70:
        r63 = r10;
    L59:
        if (r54 <= r56) goto L64;
        if (r54 <= r57) goto L64;
        r52 = r54;
    L64:
        if (r56 <= r57) goto L66;
        r52 = r56;
        goto L67
    L66:
        r52 = r57;
        goto L67
    L72:
        ArrayList r65 = r10;
        r211 = r127;
        float r66 = r130.getRevealInfo().f9768c;
        r64 = o9.b.a(r130, r132, r47, r49);
        long r67 = r50.f7957a;
        int r68 = (int) r132;
        int r69 = (int) r47;
        if (r67 <= 0) goto L75;
        Animator r70 = ViewAnimationUtils.createCircularReveal(r28, r68, r69, r66, r66);
        r70.setStartDelay(0);
        r70.setDuration(r67);
        r65.add(r70);
    L75:
        b r71 = r8;
        n.h<String, h> r72 = r71.f5174a.f7955a;
        int r135 = r72.f9401m;
        long r136 = 0;
        int r137 = 0;
    L76:
        if (r137 >= r135) goto L78;
        h r138 = r72.k(r137);
        r136 = Math.max(r136, r138.f7957a + r138.f7958b);
        r137 = r137 + 1;
        r72 = r72;
        r135 = r135;
        r71 = r71;
        r65 = r65;
        goto L76
    L78:
        r210 = r71;
        ArrayList r212 = r65;
        long r73 = r50.f7957a + r50.f7958b;
        if (r73 >= r136) goto L81;
        Animator r74 = ViewAnimationUtils.createCircularReveal(r28, r68, r69, r49, r49);
        r74.setStartDelay(r73);
        r74.setDuration(r136 - r73);
        r32 = r212;
        r32.add(r74);
        goto L82
    L81:
        r32 = r212;
        goto L82
    L126:
        r20.set(0, 0, r48.getWidth(), r48.getHeight());
        throw null;
    L28:
        if ((r27 instanceof ImageView) == false) goto L40;
        d r139 = (d) r28;
        Drawable r140 = ((ImageView) r27).getDrawable();
        if (r140 == null) goto L40;
        r140.mutate();
        if (r29 == false) goto L38;
        if (r30 == true) goto L37;
        r140.setAlpha(255);
    L37:
        ObjectAnimator r141 = ObjectAnimator.ofInt(r140, h9.d.f7950a, new int[]{0});
    L39:
        r141.addUpdateListener(new com.google.android.material.transformation.a(r28));
        r8.f5174a.c("iconFade").a(r141);
        r10.add(r141);
        com.google.android.material.transformation.b r142 = new com.google.android.material.transformation.b(r139, r140);
        r127 = r11;
        r127.add(r142);
        goto L41
    L38:
        r141 = ObjectAnimator.ofInt(r140, h9.d.f7950a, new int[]{255});
        goto L39
    L24:
        r125 = this.f5170h;
        goto L25
    L20:
        r25 = this.f5169g;
        goto L21
    L16:
        r23 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_X, new float[]{-r16});
        r114 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_Y, new float[]{-r17});
        goto L17
    L10:
        r14 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_Z, new float[]{-r13});
        goto L11
    }

    public FabTransformationBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f5165c = new Rect();
        this.f5166d = new RectF();
        this.f5167e = new RectF();
        this.f5168f = new int[2];
    }
}
