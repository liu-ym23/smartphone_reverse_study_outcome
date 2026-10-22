package com.obric.oui.swipeaction;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.button.OIconButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements i, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSwipeLayout f14623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f14624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f14625c;
    public final ArrayList d;
    public final LinkedHashMap e;
    public View f;
    public Integer g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f14626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f14627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArgbEvaluator f14630l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f14631m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f14632n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f14633o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f14634p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f14635q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AnimatorSet f14636r;

    public l(OSwipeLayout r5, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r5, "swipeLayout");
        Intrinsics.checkNotNullParameter(r10, "menuContainer");
        this.f14623a = r5;
        this.f14624b = r10;
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        this.f14630l = new ArgbEvaluator();
        r5.setShowMode(OSwipeLayout.ShowMode.LayDown);
        ArrayList r11 = r5.f14599p;
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        i r13 = (i) r12.next();
        if ((r13 instanceof l) == false) goto L4;
        r11.remove(r13);
        goto L4
    L8:
        r5.A = null;
        this.f14623a.f14599p.add(this);
        this.f14623a.setQuickDeleteListener(this);
        this.f14623a.setQuickDeleteEnabled(true);
        this.f14623a.setClipChildren(false);
        this.f14623a.setClipToPadding(false);
        this.f14624b.setClipChildren(false);
        this.f14624b.setClipToPadding(false);
        if (this.f14624b.getWidth() <= 0) goto L11;
        e();
    L11:
        this.f14624b.addOnLayoutChangeListener(new com.bytedance.ai.widget.contianer.c(this, 5));
    }

    @Override // com.obric.oui.swipeaction.i
    public final void a(OSwipeLayout r12, int r13) {
        final int r5 = 0;
        final int r10 = 1;
        Intrinsics.checkNotNullParameter(r12, "layout");
        int r11 = r12.D;
        if (r11 <= 0) goto L5;
    L4:
        float r14 = r11;
        float r15 = 0.0f;
        if (r14 != 0.0f) goto L9;
        return;
    L9:
        float r16 = Math.abs(r13);
        float r17 = r16 / r14;
        this.f14631m = r16;
        this.f14632n = r14;
        if (r17 < r12.B) goto L12;
        float r18 = 1.0f;
    L14:
        if (this.f14633o == r18) goto L39;
        this.f14633o = r18;
        AnimatorSet r19 = this.f14636r;
        if (r19 == null) goto L20;
        r19.cancel();
    L20:
        this.f14636r = new AnimatorSet();
        if (r18 != 1.0f) goto L23;
        boolean r110 = true;
    L24:
        float r20 = this.f14634p;
        if (r110 == false) goto L27;
        float r21 = 1.0f;
    L28:
        ValueAnimator r22 = ValueAnimator.ofFloat(new float[]{r20, r21});
        r22.setDuration(300);
        r22.setInterpolator(new DecelerateInterpolator());
        r22.addUpdateListener(new j(this, r5));
        float r111 = this.f14635q;
        if (r110 == false) goto L31;
        r15 = 1.0f;
    L31:
        ValueAnimator r112 = ValueAnimator.ofFloat(new float[]{r111, r15});
        r112.setDuration(300);
        r112.setInterpolator(new DecelerateInterpolator());
        r112.addUpdateListener(new j(this, r10));
        AnimatorSet r23 = this.f14636r;
        if (r23 == null) goto L35;
        r23.playTogether(new Animator[]{r22, r112});
    L35:
        AnimatorSet r113 = this.f14636r;
        if (r113 == null) goto L39;
        r113.start();
        goto L39
    L27:
        r21 = 0.0f;
        goto L28
    L23:
        r110 = false;
    L39:
        g(r16, r14, r17);
        return;
    L12:
        r18 = 0.0f;
        goto L14
    L5:
        r11 = r12.getDragDistance();
        goto L4
    }

    @Override // com.obric.oui.swipeaction.i
    public final void b(OSwipeLayout r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        float r10 = r5.getResources().getDisplayMetrics().density;
        if (this.f14629k == false) goto L7;
        return;
    L7:
        View r11 = this.f;
        if (r11 == null) goto L17;
        Integer r12 = (Integer) this.e.get(r11);
        if (r12 != null) goto L13;
        View r13 = this.f;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getWidth();
    L14:
        float r15 = Math.abs(this.f14631m);
        int r16 = this.f14628j;
        if (r15 < (r16 - r14)) goto L17;
        r5.setDragDistance((int) (r16 / r10));
        r5.x();
        return;
    L13:
        r14 = r12.intValue();
    L17:
        r5.q(true);
    }

    @Override // com.obric.oui.swipeaction.i
    public final void c() {
        f();
    }

    @Override // com.obric.oui.swipeaction.i
    public final void d() {
    }

    public final void e() {
        ViewGroup r5 = this.f14624b;
        int r10 = r5.getWidth();
        List r11 = SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(r5), OSwipeQuickDeleteHelper$captureOriginalState$currentVisibleChildren$1.INSTANCE));
        boolean r12 = true;
        if (r10 == this.f14628j) goto L5;
        boolean r13 = true;
    L6:
        LinkedHashMap r14 = this.e;
        ArrayList r15 = this.d;
        if (r13 == false) goto L9;
    L25:
        r12 = r13;
    L26:
        if (r12 == true) goto L28;
        return;
    L28:
        this.f14628j = r10;
        r15.clear();
        r14.clear();
        Iterator r16 = r11.iterator();
    L30:
        if (r16.hasNext() == false) goto L33;
        View r17 = (View) r16.next();
        r15.add(r17);
        r14.put(r17, Integer.valueOf(r17.getWidth()));
        goto L30
    L33:
        if (r15.isEmpty() == true) goto L77;
        View r18 = (View) CollectionsKt.last(r15);
        this.f = r18;
        if (r18 == null) goto L77;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        Integer r20 = null;
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L40;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r19;
    L41:
        if (r21 != null) goto L43;
        int r22 = 0;
    L44:
        this.g = r22;
        if ((r18 instanceof ImageView) == false) goto L52;
        ColorStateList r23 = ((ImageView) r18).getImageTintList();
        if (r23 != null) goto L49;
        Integer r24 = null;
    L50:
        this.f14626h = r24;
        goto L52
    L49:
        r24 = Integer.valueOf(r23.getDefaultColor());
    L52:
        if (r18.getBackgroundTintList() == null) goto L59;
        ColorStateList r25 = r18.getBackgroundTintList();
        if (r25 == null) goto L57;
        r20 = Integer.valueOf(r25.getDefaultColor());
    L57:
        this.f14627i = r20;
        goto L77
    L59:
        if ((r18.getBackground() instanceof ColorDrawable) == false) goto L66;
        Drawable r26 = r18.getBackground();
        if (r26 == null) goto L64;
        this.f14627i = Integer.valueOf(((ColorDrawable) r26).getColor());
        goto L77
    L64:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L66:
        if ((r18.getBackground() instanceof GradientDrawable) == false) goto L76;
        Drawable r27 = r18.getBackground();
        if (r27 == null) goto L75;
        ColorStateList r28 = ((GradientDrawable) r27).getColor();
        if (r28 == null) goto L73;
        r20 = Integer.valueOf(r28.getDefaultColor());
    L73:
        this.f14627i = r20;
        goto L77
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L76:
        Log.e("OSwipeQuickDeleteHelper", Intrinsics.stringPlus("captureOriginalState : getLastItem bgColor failed: bg.class:", r18.getBackground().getClass().getName()));
        goto L77
    L43:
        r22 = Integer.valueOf(r21.getMarginStart());
        goto L44
    L40:
        r21 = null;
    L77:
        ViewGroup.LayoutParams r29 = r5.getLayoutParams();
        if (r29 == null) goto L80;
        r29.width = this.f14628j;
        r5.setLayoutParams(r29);
    L80:
        OSwipeLayout r30 = this.f14623a;
        int r31 = RangesKt.coerceAtLeast(r30.getWidth() - this.f14628j, 0);
        int r32 = this.f14628j;
        float r33 = r32;
        float r34 = (r31 * 0.4f) + r33;
        if (r32 <= 0) goto L83;
        float r35 = r34 / r33;
    L84:
        float r36 = RangesKt.coerceAtLeast(r35, 1.1f);
        r30.setQuickDeleteThreshold(r36);
        r30.setQuickDeleteMax(r36 + 0.5f);
        r30.setOverrideDragDistance(this.f14628j);
        return;
    L83:
        r35 = 1.5f;
        goto L84
    L9:
        if (r11.size() != r15.size()) goto L26;
        if (r11.size() != r14.size()) goto L26;
        int r37 = r11.size();
        int r38 = 0;
    L14:
        if (r38 >= r37) goto L25;
        int r110 = r38 + 1;
        if (Intrinsics.areEqual(r11.get(r38), r15.get(r38)) == false) goto L26;
        int r111 = ((View) r11.get(r38)).getWidth();
        Integer r39 = (Integer) r14.get(r11.get(r38));
        if (r39 != null) goto L21;
        int r40 = -1;
    L22:
        if (r111 != r40) goto L26;
        r38 = r110;
        goto L14
    L21:
        r40 = r39.intValue();
        goto L22
    L5:
        r13 = false;
        goto L6
    }

    public final void f() {
        this.f14634p = 0.0f;
        this.f14635q = 0.0f;
        this.f14633o = 0.0f;
        AnimatorSet r5 = this.f14636r;
        if (r5 == null) goto L6;
        r5.cancel();
    L6:
        Iterator r10 = CollectionsKt.dropLast(this.d, 1).iterator();
    L7:
        boolean r11 = r10.hasNext();
        LinkedHashMap r12 = this.e;
        if (r11 == false) goto L19;
        View r13 = (View) r10.next();
        Integer r14 = (Integer) r12.get(r13);
        if (r14 != null) goto L12;
        int r15 = r13.getWidth();
    L14:
        if (r13.getLayoutParams().width == r15) goto L16;
        r13.getLayoutParams().width = r15;
    L16:
        r13.setAlpha(1.0f);
        r13.setScaleX(1.0f);
        r13.setScaleY(1.0f);
        if (r13.getVisibility() == 0) goto L7;
        r13.setVisibility(0);
        goto L7
    L12:
        r15 = r14.intValue();
        goto L14
    L19:
        View r16 = this.f;
        if (r16 == null) goto L59;
        Integer r17 = (Integer) r12.get(r16);
        if (r17 != null) goto L25;
        int r18 = r16.getWidth();
    L27:
        if (r16.getLayoutParams().width == r18) goto L30;
        r16.getLayoutParams().width = r18;
    L30:
        if ((r16 instanceof OIconButton) == false) goto L32;
        ((OIconButton) r16).setAlignmentProgress(0.0f);
    L32:
        ViewGroup.LayoutParams r19 = r16.getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
    L36:
        if (r20 == null) goto L46;
        if (this.g == null) goto L46;
        int r21 = r20.getMarginStart();
        Integer r22 = this.g;
        if (r22 != null) goto L43;
    L44:
        Integer r23 = this.g;
        Intrinsics.checkNotNull(r23);
        r20.setMarginStart(r23.intValue());
        r16.setLayoutParams(r20);
        goto L46
    L43:
        if (r21 != r22.intValue()) goto L44;
    L46:
        if ((r16 instanceof ImageView) == false) goto L59;
        if (this.f14626h == null) goto L54;
        ImageView r24 = (ImageView) r16;
        if (r24.getImageTintList() == null) goto L52;
        Integer r25 = this.f14626h;
        Intrinsics.checkNotNull(r25);
        r24.setImageTintList(ColorStateList.valueOf(r25.intValue()));
        goto L54
    L52:
        Integer r26 = this.f14626h;
        Intrinsics.checkNotNull(r26);
        r24.setColorFilter(r26.intValue());
    L54:
        if (this.f14627i == null) goto L59;
        ImageView r27 = (ImageView) r16;
        if (r27.getBackgroundTintList() == null) goto L58;
        Integer r28 = this.f14627i;
        Intrinsics.checkNotNull(r28);
        r27.setBackgroundTintList(ColorStateList.valueOf(r28.intValue()));
        goto L59
    L58:
        Integer r29 = this.f14627i;
        Intrinsics.checkNotNull(r29);
        r16.setBackgroundColor(r29.intValue());
        goto L59
    L35:
        r20 = null;
        goto L36
    L25:
        r18 = r17.intValue();
    L59:
        this.f14624b.requestLayout();
    }

    public final void g(float r12, float r13, float r14) {
        ViewGroup r5 = this.f14624b;
        LinkedHashMap r10 = this.e;
        ArrayList r11 = this.d;
        ViewGroup.MarginLayoutParams r15 = null;
        int r16 = 0;
        if (r14 > 1.0f) goto L43;
        float r17 = this.f14628j - r12;
        Iterator r18 = r11.iterator();
        int r19 = 0;
    L6:
        if (r18.hasNext() == false) goto L21;
        View r20 = (View) r18.next();
        Integer r21 = (Integer) r10.get(r20);
        if (r21 != null) goto L10;
        int r22 = r20.getWidth();
    L12:
        if (r20.getLayoutParams().width == r22) goto L14;
        r20.getLayoutParams().width = r22;
        r20.requestLayout();
    L14:
        r19 = r19 + r22;
        float r23 = r19 - r17;
        float r110 = 0.0f;
        if (r22 <= 0) goto L18;
        r110 = RangesKt.coerceIn(r23 / r22, 0.0f, 1.0f);
    L20:
        r20.setAlpha(r110);
        r20.setScaleX(r110);
        r20.setScaleY(r110);
        goto L6
    L18:
        if (r23 < 0.0f) goto L20;
        r110 = 1.0f;
        goto L20
    L10:
        r22 = r21.intValue();
        goto L12
    L21:
        View r111 = this.f;
        if (r111 == null) goto L36;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r15 = (ViewGroup.MarginLayoutParams) r112;
    L27:
        if (r15 == null) goto L36;
        if (this.g == null) goto L36;
        int r113 = r15.getMarginStart();
        Integer r114 = this.g;
        if (r114 != null) goto L34;
    L35:
        Integer r115 = this.g;
        Intrinsics.checkNotNull(r115);
        r15.setMarginStart(r115.intValue());
        r111.setLayoutParams(r15);
        goto L36
    L34:
        if (r113 != r114.intValue()) goto L35;
    L36:
        Iterator r116 = CollectionsKt.dropLast(r11, 1).iterator();
    L38:
        if (r116.hasNext() == false) goto L42;
        View r117 = (View) r116.next();
        if (r117.getVisibility() == 0) goto L38;
        r117.setVisibility(0);
        goto L38
    L42:
        r5.requestLayout();
        return;
    L43:
        Iterator r118 = r11.iterator();
    L45:
        if (r118.hasNext() == false) goto L50;
        View r24 = (View) r118.next();
        if (r24.getAlpha() == 1.0f) goto L45;
        r24.setAlpha(1.0f);
        r24.setScaleX(1.0f);
        r24.setScaleY(1.0f);
        goto L45
    L50:
        float r119 = RangesKt.coerceAtMost(r12 - r13, (this.f14623a.C - 1.0f) * r13);
        View r120 = this.f;
        if (r120 != null) goto L53;
        return;
    L53:
        float r25 = 1.0f - this.f14634p;
        Iterator r26 = CollectionsKt.dropLast(r11, 1).iterator();
    L55:
        if (r26.hasNext() == false) goto L63;
        View r27 = (View) r26.next();
        r27.setAlpha(r25);
        r27.setScaleX(r25);
        r27.setScaleY(r25);
        Integer r28 = (Integer) r10.get(r27);
        if (r28 != null) goto L59;
        int r29 = r27.getWidth();
    L60:
        int r30 = (int) (r29 * r25);
        if (r27.getLayoutParams().width == r30) goto L55;
        r27.getLayoutParams().width = r30;
        r27.requestLayout();
        goto L55
    L59:
        r29 = r28.intValue();
        goto L60
    L63:
        float r31 = this.f14635q;
        ViewGroup.LayoutParams r32 = r120.getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == false) goto L66;
        r15 = (ViewGroup.MarginLayoutParams) r32;
    L66:
        if (r15 == null) goto L74;
        Integer r33 = this.g;
        if (r33 == null) goto L71;
        r16 = r33.intValue();
    L71:
        int r34 = (int) ((1.0f - r31) * r16);
        if (r15.getMarginStart() == r34) goto L74;
        r15.setMarginStart(r34);
        r120.setLayoutParams(r15);
    L74:
        Integer r35 = (Integer) r10.get(r120);
        if (r35 != null) goto L77;
        int r36 = r120.getWidth();
    L78:
        int r121 = (int) (r36 + r119);
        int r122 = (int) (((((int) (r12 - (r5.getPaddingRight() + r5.getPaddingLeft()))) - r121) * r31) + r121);
        if (r120.getLayoutParams().width == r122) goto L82;
        r120.getLayoutParams().width = r122;
        r120.requestLayout();
    L82:
        if ((r120 instanceof ImageView) == false) goto L104;
        if (this.f14626h == null) goto L104;
        Integer r123 = this.f14627i;
        ArgbEvaluator r124 = this.f14630l;
        if (r123 == null) goto L95;
        Intrinsics.checkNotNull(r123);
        Integer r37 = this.f14626h;
        Intrinsics.checkNotNull(r37);
        Object r125 = r124.evaluate(r31, r123, r37);
        if (r125 == null) goto L94;
        int r126 = ((Integer) r125).intValue();
        ImageView r38 = (ImageView) r120;
        if (r38.getBackgroundTintList() == null) goto L92;
        r38.setBackgroundTintList(ColorStateList.valueOf(r126));
        goto L95
    L92:
        r120.setBackgroundColor(r126);
        goto L95
    L94:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L95:
        Integer r127 = this.f14626h;
        Intrinsics.checkNotNull(r127);
        Object r128 = r124.evaluate(r31, r127, -1);
        if (r128 == null) goto L102;
        int r129 = ((Integer) r128).intValue();
        ImageView r130 = (ImageView) r120;
        if (r130.getImageTintList() == null) goto L100;
        r130.setImageTintList(ColorStateList.valueOf(r129));
        goto L104
    L100:
        r130.setColorFilter(r129);
        goto L104
    L102:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L104:
        if ((r120 instanceof OIconButton) == false) goto L127;
        ((OIconButton) r120).setAlignmentProgress(r31);
        return;
    L127:
        return;
    L77:
        r36 = r35.intValue();
        goto L78
    }

    @Override // com.obric.oui.swipeaction.i
    public final void onClose() {
        f();
    }
}
