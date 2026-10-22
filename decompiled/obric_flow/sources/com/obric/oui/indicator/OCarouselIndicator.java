package com.obric.oui.indicator;

import ai.j0;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003$%&B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010R*\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\rR*\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\rR*\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\rR\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator;", "Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconResId", "", "setStartDotDrawable", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "value", "F", "I", "getMaxVisibleDots", "()I", "setMaxVisibleDots", "maxVisibleDots", "G", "getSizeStyle", "setSizeStyle", "sizeStyle", "H", "getSelectedDotColor", "setSelectedDotColor", "selectedDotColor", "Lcom/obric/oui/indicator/j;", "getCustom", "()Lcom/obric/oui/indicator/j;", "custom", "com/obric/oui/indicator/o", "com/obric/oui/indicator/p", "com/obric/oui/indicator/s", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCarouselIndicator extends OBaseIndicator {
    public static final /* synthetic */ int J = 0;
    public final ArrayDeque A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public IndicatorImageDotView E;
    public int F;
    public int G;
    public int H;
    public final ArgbEvaluator I;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final IndicatorGroupLayout f13460w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LinearLayout f13461x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f f13462y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f13463z;

    @JvmOverloads
    public OCarouselIndicator(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void o(View r5, IndicatorDotVisualState r10) {
        if (r10 != IndicatorDotVisualState.HIDDEN) goto L5;
        int r11 = 4;
    L6:
        float r12 = v(r10);
        float r13 = u(r10);
        if (r5.getVisibility() == r11) goto L9;
    L15:
        r5.animate().setListener(null).cancel();
        r5.setVisibility(r11);
        r5.setScaleX(r12);
        r5.setScaleY(r12);
        r5.setAlpha(r13);
        return;
    L9:
        if (r5.getScaleX() != r12) goto L15;
        if (r5.getScaleY() != r12) goto L15;
        if (r5.getAlpha() != r13) goto L15;
        return;
    L5:
        r11 = 0;
        goto L6
    }

    public static float u(IndicatorDotVisualState r5) {
        int r10 = t.f13508a[r5.ordinal()];
        if (r10 != 2) goto L5;
        return 0.0f;
    L5:
        if (r10 == 3) goto L7;
        return 0.35f;
    L7:
        return 1.0f;
    }

    public static float v(IndicatorDotVisualState r5) {
        int r10 = t.f13508a[r5.ordinal()];
        if (r10 != 1) goto L5;
        return 0.5f;
    L5:
        if (r10 == 2) goto L7;
        return 1.0f;
    L7:
        return 0.0f;
    }

    public static List w(int r5, IntRange r10) {
        if (r5 <= 0) goto L27;
        if (r10.isEmpty() == true) goto L27;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<Integer> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L11;
        r11.add(new r(((IntIterator) r12).nextInt()));
        goto L8
    L11:
        if (r10.isEmpty() == false) goto L13;
        int r13 = 0;
    L14:
        if (r5 > r13) goto L16;
        return r11;
    L16:
        List r14 = CollectionsKt.createListBuilder(r11.size() + 2);
        if (r10.getFirst() <= 0) goto L19;
        s r15 = new r(r10.getFirst() - 1);
    L20:
        r14.add(r15);
        r14.addAll(r11);
        if (r10.getLast() >= (r5 - 1)) goto L23;
        s r16 = new r(r10.getLast() + 1);
    L24:
        r14.add(r16);
        return CollectionsKt.build(r14);
    L23:
        r16 = q.f13506b;
        goto L24
    L19:
        r15 = q.f13505a;
        goto L20
    L13:
        r13 = (r10.getLast() - r10.getFirst()) + 1;
    L27:
        return CollectionsKt.emptyList();
    }

    public static IndicatorDotVisualState y(p r5, h r10) {
        s r11 = r5.f13502a;
        boolean r12 = true;
        if ((r11 instanceof r) == false) goto L29;
        int r13 = ((r) r11).f13507a;
        IntRange r14 = r10.f13481c;
        int r15 = r14.getFirst();
        if (r13 > r14.getLast()) goto L40;
        if (r15 > r13) goto L40;
        if (r13 != r10.f13480b) goto L11;
        return IndicatorDotVisualState.ACTIVE;
    L11:
        if (r13 == r14.getFirst()) goto L13;
    L15:
        boolean r16 = false;
    L17:
        if (r13 == r14.getLast()) goto L19;
    L21:
        r12 = false;
    L22:
        if (r16 == true) goto L39;
        if (r12 == true) goto L39;
        return IndicatorDotVisualState.NORMAL;
    L39:
        return IndicatorDotVisualState.EDGE;
    L19:
        if (r14.getLast() >= (r10.f13479a - 1)) goto L21;
    L13:
        if (r14.getFirst() <= 0) goto L15;
        r16 = true;
    L40:
        return IndicatorDotVisualState.HIDDEN;
    L29:
        if (Intrinsics.areEqual(r11, q.f13505a) == true) goto L32;
        r12 = Intrinsics.areEqual(r11, q.f13506b);
    L32:
        if (r12 == false) goto L36;
        return IndicatorDotVisualState.HIDDEN;
    L36:
        throw new NoWhenBranchMatchedException();
    }

    public final void A(View r5, boolean r10) {
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        LinearLayout.LayoutParams r12 = null;
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r13 == null) goto L9;
        r12 = new LinearLayout.LayoutParams(r13);
    L9:
        if (r12 != null) goto L11;
        r12 = new LinearLayout.LayoutParams((int) getDotsWidth(), (int) getDotsHeight());
    L11:
        r12.width = (int) getDotsWidth();
        r12.height = (int) getDotsHeight();
        if (r10 == true) goto L14;
        r12.setMargins(0, 0, 0, 0);
    L14:
        r5.setLayoutParams(r12);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final void B() {
        IndicatorGroupLayout r5 = null;
        if (getType() == 1) goto L5;
    L4:
        Integer r10 = null;
    L14:
        IndicatorGroupLayout r11 = this.f13460w;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r11 = null;
    L18:
        if (Intrinsics.areEqual(r11.getFixedContentWidthPx(), r10) == false) goto L20;
        return;
    L20:
        IndicatorGroupLayout r12 = this.f13460w;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L24:
        r5.setFixedContentWidthPx(r10);
        return;
    L23:
        r5 = r12;
        goto L24
    L5:
        int r13 = g();
        if (r13 <= 0) goto L4;
        int r14 = this.F;
        if (r13 <= r14) goto L4;
        int r15 = RangesKt.coerceAtLeast(r14, 0);
        if (r15 != 0) goto L13;
        ps.a.g("OCarouselIndicator", Intrinsics.stringPlus("Skip PIC stable content width because maxVisibleDots is invalid, maxVisibleDots=", Integer.valueOf(this.F)));
        goto L4
    L13:
        r10 = Integer.valueOf(MathKt.roundToInt(((getDotsSpacing() * (r15 - 1)) * 2.0f) + (getDotsWidth() * r15)));
        goto L14
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [android.view.View, com.obric.oui.indicator.g] */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View, com.obric.oui.indicator.g] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, com.obric.oui.indicator.g] */
    public final void C() {
        ArrayList r5 = this.f13463z;
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        IntRange r10 = CollectionsKt.getIndices(r5);
        int r11 = (int) getDotsSpacing();
        Iterator r12 = r5.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L28;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        p r16 = (p) r14;
        Intrinsics.checkNotNullParameter(r10, "visibleRange");
        if (r10.getFirst() != r10.getLast()) goto L17;
        if (r13 != r10.getFirst()) goto L17;
        a r17 = new a(0, 0);
    L23:
        int r18 = r17.f13465b;
        int r19 = r17.f13464a;
        if (r19 != r18) goto L26;
        r16.f13504c.setHorizontalMargin(r19);
    L27:
        r13 = r15;
        goto L7
    L26:
        r16.f13504c.setStartMargin(r19);
        r16.f13504c.setEndMargin(r18);
    L17:
        if (r13 != r10.getFirst()) goto L20;
        r17 = new a(0, r11);
        goto L23
    L20:
        if (r13 != r10.getLast()) goto L22;
        r17 = new a(r11, 0);
        goto L23
    L22:
        r17 = new a(r11, r11);
        goto L23
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final r6.a b() {
        return new r6.a(this);
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void c() {
        l r5 = getPager();
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        Iterator r11 = this.f13463z.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        t((p) r11.next(), r10);
        goto L8
    L10:
        return;
    L5:
        r10 = r5.a();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void d() {
        B();
        l r5 = getPager();
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        Iterator r11 = this.f13463z.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        p r12 = (p) r11.next();
        A(r12.f13503b, true);
        t(r12, r10);
        goto L8
    L10:
        Iterator r13 = this.A.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        A((IndicatorDotView) r13.next(), true);
        goto L12
    L14:
        IndicatorImageDotView r14 = this.E;
        if (r14 == null) goto L21;
        A(r14, true);
        return;
    L21:
        return;
    L5:
        r10 = r5.a();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void e() {
        B();
        C();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void f() {
        B();
        l r5 = getPager();
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        IndicatorAnimator$RenderReason r11 = IndicatorAnimator$RenderReason.REFRESH_DOTS;
        h r12 = z(g(), r10);
        f r13 = this.f13462y;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r13 = null;
    L9:
        r13.a(r11, r12);
        return;
    L5:
        r10 = r5.a();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public j getCustom() {
        return new j(com.lynx.tasm.utils.a.E(6, this), com.lynx.tasm.utils.a.E(6, this), com.lynx.tasm.utils.a.E(4, this), R$styleable.OCarouselIndicator, R$styleable.OCarouselIndicator_oui_type, R$styleable.OCarouselIndicator_oui_layoutHeight, R$styleable.OCarouselIndicator_oui_dotsWidth, R$styleable.OCarouselIndicator_oui_dotsHeight, R$styleable.OCarouselIndicator_oui_dotsSpacing, R$styleable.OCarouselIndicator_oui_dotsColor, R$styleable.OCarouselIndicator_oui_dotsCornerRadius, R$styleable.OCarouselIndicator_oui_dotsClickable, R$styleable.OCarouselIndicator_oui_dotsStrokeColor, R$styleable.OCarouselIndicator_oui_dotsStrokeWidth);
    }

    public final int getMaxVisibleDots() {
        return this.F;
    }

    public final int getSelectedDotColor() {
        return this.H;
    }

    public final int getSizeStyle() {
        return this.G;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void k() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        IndicatorGroupLayout r5 = null;
        if (getType() != 1) goto L18;
        IndicatorGroupLayout r10 = this.f13460w;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r10 = null;
    L11:
        r10.setBgColor(ContextCompat.getColor(getContext(), R$color.carousel_indicator_bg_color));
        IndicatorGroupLayout r11 = this.f13460w;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r11 = null;
    L14:
        r11.setCornerRadius(com.lynx.tasm.utils.a.B(100, this));
        IndicatorGroupLayout r12 = this.f13460w;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r12 = null;
    L17:
        r12.setDrawBackground(true);
    L26:
        if (getType() == 1) goto L28;
    L30:
        IndicatorGroupLayout r13 = this.f13460w;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r13 = null;
    L33:
        r13.setPadding(getSidePadding(), getVerticalSidePadding(), getSidePadding(), getVerticalSidePadding());
    L34:
        B();
        IndicatorGroupLayout r14 = this.f13460w;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r14 = null;
    L37:
        IndicatorGroupLayout r15 = this.f13460w;
        if (r15 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L41:
        ViewGroup.LayoutParams r16 = r5.getLayoutParams();
        r16.height = getLayoutHeight();
        r14.setLayoutParams(r16);
        requestLayout();
        return;
    L40:
        r5 = r15;
        goto L41
    L28:
        if (this.G != 1) goto L30;
        r();
        goto L34
    L18:
        IndicatorGroupLayout r17 = this.f13460w;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r17 = null;
    L21:
        r17.setBgColor(ContextCompat.getColor(getContext(), R$color.Transparent));
        IndicatorGroupLayout r18 = this.f13460w;
        if (r18 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r18 = null;
    L24:
        r18.setDrawBackground(false);
        goto L26
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View, com.obric.oui.indicator.g] */
    public final void n(int r5, int r10, h r11) {
        if (r11.a(r5) == true) goto L5;
        return;
    L5:
        Iterator r12 = this.f13463z.iterator();
    L7:
        if (r12.hasNext() == false) goto L22;
        Object r13 = r12.next();
        s r14 = ((p) r13).f13502a;
        boolean r15 = false;
        boolean r16 = true;
        if ((r14 instanceof r) == false) goto L14;
        if (((r) r14).f13507a != r5) goto L18;
        r15 = true;
    L18:
        if (r15 == false) goto L7;
    L23:
        p r17 = (p) r13;
        if (r17 != null) goto L26;
        return;
    L26:
        ?? r18 = r17.f13504c;
        r18.setDotColor(r10);
        r18.invalidate();
        return;
    L14:
        if (Intrinsics.areEqual(r14, q.f13505a) == true) goto L17;
        r16 = Intrinsics.areEqual(r14, q.f13506b);
    L17:
        if (r16 == true) goto L18;
        throw new NoWhenBranchMatchedException();
    L22:
        r13 = null;
        goto L23
    }

    public final void p(float r10, int r11, int r12) {
        int r5 = g();
        h r13 = z(r5, r11);
        h r14 = z(r5, r12);
        f r15 = null;
        if (Intrinsics.areEqual(r13.f13481c, r14.f13481c) == true) goto L42;
        f r16 = this.f13462y;
        if (r16 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r16 = null;
    L7:
        float r17 = r16.g;
        if (r10 <= r17) goto L11;
        IndicatorAnimator$ScrollDirection r18 = IndicatorAnimator$ScrollDirection.FORWARD;
    L15:
        if (r18 != null) goto L17;
        int r19 = -1;
    L19:
        if (r19 == (-1)) goto L31;
        if (r19 == 1) goto L28;
        if (r19 == 2) goto L31;
        throw new NoWhenBranchMatchedException();
    L28:
        if (r10 > 0.5f) goto L32;
    L33:
        int r20 = r11;
    L35:
        if (r10 == 0.0f) goto L38;
        r16.g = r10;
    L38:
        IndicatorAnimator$RenderReason r21 = IndicatorAnimator$RenderReason.SCROLL;
        h r22 = z(g(), r20);
        f r23 = this.f13462y;
        if (r23 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r23 = null;
    L41:
        r23.a(r21, r22);
    L46:
        f r24 = this.f13462y;
        if (r24 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
    L50:
        h r25 = r15.d;
        if (r25 != null) goto L54;
    L73:
        invalidate();
        return;
    L54:
        if (r25.a(r11) == false) goto L73;
        if (r25.a(r12) == false) goto L73;
        ArgbEvaluator r26 = this.I;
        Object r27 = r26.evaluate(r10, Integer.valueOf(this.H), Integer.valueOf(getDotsColor()));
        if (r27 == null) goto L72;
        int r28 = ((Integer) r27).intValue();
        Object r29 = r26.evaluate(r10, Integer.valueOf(getDotsColor()), Integer.valueOf(this.H));
        if (r29 == null) goto L70;
        n(r12, ((Integer) r29).intValue(), r25);
        l r30 = getPager();
        if (r30 != null) goto L66;
    L68:
        n(r11, r28, r25);
        goto L73
    L66:
        if (r11 != r30.a()) goto L68;
        r28 = this.H;
        goto L68
    L70:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L72:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L49:
        r15 = r24;
    L32:
        r20 = r12;
    L31:
        if (r10 < 0.5f) goto L33;
    L17:
        r19 = d.f13472a[r18.ordinal()];
        goto L19
    L11:
        if (r10 >= r17) goto L13;
        r18 = IndicatorAnimator$ScrollDirection.BACKWARD;
        goto L15
    L13:
        r18 = null;
        goto L15
    L42:
        f r31 = this.f13462y;
        if (r31 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r31 = null;
    L45:
        r31.a(IndicatorAnimator$RenderReason.REFRESH_DOTS, r13);
        s(r13, r14, r10);
        goto L46
    }

    public final void q() {
        int r5 = this.G;
        o r10 = new o(getCustom().f13484a, getCustom().f13485b, getCustom().f13486c);
        if (r5 != 1) goto L6;
        r10 = new o(com.lynx.tasm.utils.a.s(getContext(), 4.0f), com.lynx.tasm.utils.a.s(getContext(), 4.0f), com.lynx.tasm.utils.a.s(getContext(), 2.0f));
    L6:
        if (this.B == true) goto L9;
        setDotsWidth(r10.f13499a);
    L9:
        if (this.C == true) goto L12;
        setDotsHeight(r10.f13500b);
    L12:
        if (this.D == true) goto L15;
        setDotsSpacing(r10.f13501c);
        return;
    }

    public final void r() {
        int r5 = com.lynx.tasm.utils.a.q(getContext(), 4.0f);
        int r10 = com.lynx.tasm.utils.a.q(getContext(), 4.0f);
        IndicatorGroupLayout r11 = this.f13460w;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r11 = null;
    L5:
        r11.setPadding(r5, r10, r5, r10);
    }

    public final void s(h r11, h r12, float r13) {
        l r5 = getPager();
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        Iterator r14 = this.f13463z.iterator();
    L8:
        if (r14.hasNext() == false) goto L29;
        p r15 = (p) r14.next();
        View r16 = r15.f13503b;
        IndicatorDotVisualState r17 = y(r15, r11);
        IndicatorDotVisualState r18 = y(r15, r12);
        if (r17 != r18) goto L12;
        o(r16, r17);
    L28:
        t(r15, r10);
        goto L8
    L12:
        float r19 = v(r17);
        float r20 = v(r18);
        float r21 = u(r17);
        float r22 = u(r18);
        float r23 = j0.b(r20, r19, r13, r19);
        float r24 = j0.b(r22, r21, r13, r21);
        if (r13 >= 1.0f) goto L15;
    L17:
        int r25 = 0;
    L19:
        if (r16.getVisibility() == r25) goto L21;
    L27:
        r16.animate().setListener(null).cancel();
        r16.setVisibility(r25);
        r16.setScaleX(r23);
        r16.setScaleY(r23);
        r16.setAlpha(r24);
        goto L28
    L21:
        if (r16.getScaleX() != r23) goto L27;
        if (r16.getScaleY() != r23) goto L27;
        if (r16.getAlpha() != r24) goto L27;
    L15:
        if (r18 != IndicatorDotVisualState.HIDDEN) goto L17;
        r25 = 4;
        goto L19
    L29:
        return;
    L5:
        r10 = r5.a();
        goto L6
    }

    public final void setMaxVisibleDots(int r5) {
        if (this.F == r5) goto L6;
        this.F = r5;
        h();
        return;
    }

    public final void setSelectedDotColor(int r5) {
        if (getType() != 1) goto L5;
        this.H = -218103809;
        i();
        return;
    L5:
        if (this.H == r5) goto L9;
        this.H = r5;
        i();
        return;
    }

    public final void setSizeStyle(int r5) {
        if (this.G == r5) goto L6;
        this.G = r5;
        q();
        h();
        return;
    }

    public final void setStartDotDrawable(@DrawableRes int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        Drawable r10 = ContextCompat.getDrawable(getContext(), r5);
        if (r10 != null) goto L7;
        return;
    L7:
        setStartDotDrawable(r10);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.obric.oui.indicator.g] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, com.obric.oui.indicator.g] */
    public final void t(p r5, int r10) {
        ?? r11 = r5.f13504c;
        s r12 = r5.f13502a;
        if ((r12 instanceof r) == false) goto L9;
        if (((r) r12).f13507a != r10) goto L7;
        int r13 = this.H;
    L14:
        r11.setDotColor(r13);
        float r14 = getDotsCornerRadius();
        ?? r15 = r5.f13504c;
        r15.setCornerRadius(r14);
        r15.setStrokeWidth(getDotsStrokeWidth());
        r15.setStrokeColor(getDotsStrokeColor());
        r15.invalidate();
        return;
    L7:
        r13 = getDotsColor();
        goto L14
    L9:
        if (Intrinsics.areEqual(r12, q.f13505a) == false) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L17;
        r13 = getDotsColor();
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    L11:
        r16 = Intrinsics.areEqual(r12, q.f13506b);
        goto L12
    }

    public final IndicatorImageDotView x(s r5) {
        if ((r5 instanceof r) == false) goto L8;
        if (((r) r5).f13507a == 0) goto L15;
        return null;
    L15:
        return this.E;
    L8:
        if (Intrinsics.areEqual(r5, q.f13505a) == false) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L14;
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    L10:
        r10 = Intrinsics.areEqual(r5, q.f13506b);
        goto L11
    }

    public final h z(int r5, int r10) {
        int r11 = Math.min(r5, this.F);
        if (r5 > r11) goto L5;
        IntRange r12 = RangesKt.until(0, r5);
    L7:
        return new h(r5, r10, r12);
    L5:
        int r13 = r10 - (r11 / 2);
        int r14 = RangesKt.coerceIn(r13, 0, r5 - r11);
        r12 = RangesKt.until(r14, r11 + r14);
        goto L7
    }

    @JvmOverloads
    public OCarouselIndicator(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OCarouselIndicator(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    public final void setStartDotDrawable(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        Drawable.ConstantState r10 = r5.getConstantState();
        if (r10 != null) goto L6;
        ps.a.g("OCarouselIndicator", "setStartDotDrawable(drawable) ignored, drawable.constantState is null");
        return;
    L6:
        Drawable r11 = r10.newDrawable(getResources()).mutate();
        Context r12 = getContext();
        Intrinsics.checkNotNullParameter(r12, "context");
        IndicatorImageDotView r13 = new IndicatorImageDotView(r12);
        r13.f13436a = -7829368;
        r13.setImageDrawable(r11);
        r13.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.E = r13;
        h();
    }

    @JvmOverloads
    public OCarouselIndicator(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f13463z = new ArrayList();
        this.A = new ArrayDeque();
        DecelerateInterpolator r13 = new DecelerateInterpolator();
        this.F = Integer.MAX_VALUE;
        this.H = ContextCompat.getColor(r10, R$color.oui_text_1);
        this.I = new ArgbEvaluator();
        LinearLayout r5 = null;
        IndicatorGroupLayout r14 = new IndicatorGroupLayout(getContext(), null, 6, 0);
        r14.setGravity(17);
        this.f13460w = r14;
        LinearLayout r15 = new LinearLayout(getContext());
        r15.setOrientation(0);
        r15.setGravity(17);
        this.f13461x = r15;
        if (getType() != 1) goto L14;
        IndicatorGroupLayout r16 = this.f13460w;
        if (r16 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r16 = null;
    L7:
        r16.setBgColor(ContextCompat.getColor(getContext(), R$color.carousel_indicator_bg_color));
        IndicatorGroupLayout r17 = this.f13460w;
        if (r17 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r17 = null;
    L10:
        r17.setCornerRadius(com.lynx.tasm.utils.a.B(100, this));
        IndicatorGroupLayout r18 = this.f13460w;
        if (r18 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r18 = null;
    L13:
        r18.setDrawBackground(true);
    L18:
        IndicatorGroupLayout r19 = this.f13460w;
        if (r19 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r19 = null;
    L21:
        r19.setPadding(getSidePadding(), 0, getSidePadding(), 0);
        IndicatorGroupLayout r20 = this.f13460w;
        if (r20 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r20 = null;
    L24:
        LinearLayout r21 = this.f13461x;
        if (r21 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r21 = null;
    L27:
        r20.addView(r21, new LinearLayout.LayoutParams(-2, -2));
        IndicatorGroupLayout r22 = this.f13460w;
        if (r22 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r22 = null;
    L30:
        addView(r22, new LinearLayout.LayoutParams(-2, getLayoutHeight()));
        LinearLayout r23 = this.f13461x;
        if (r23 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
    L34:
        this.f13462y = new f(r5, r13, new sg.a(this));
        if (r11 == null) goto L37;
        TypedArray r24 = getContext().obtainStyledAttributes(r11, getCustom().d, 0, 0);
        this.B = r24.hasValue(R$styleable.OCarouselIndicator_oui_dotsWidth);
        this.C = r24.hasValue(R$styleable.OCarouselIndicator_oui_dotsHeight);
        this.D = r24.hasValue(R$styleable.OCarouselIndicator_oui_dotsSpacing);
        setSelectedDotColor(r24.getColor(R$styleable.OCarouselIndicator_oui_selectedDotColor, getSelectedDotColor()));
        setMaxVisibleDots(r24.getInt(R$styleable.OCarouselIndicator_oui_maxVisibleDots, getMaxVisibleDots()));
        setSizeStyle(r24.getInt(R$styleable.OCarouselIndicator_oui_sizeStyle, 0));
        r24.recycle();
    L37:
        q();
        if (getType() == 1) goto L40;
    L42:
        this.f13442b = true;
        return;
    L40:
        if (this.G != 1) goto L42;
        r();
        goto L42
    L33:
        r5 = r23;
        goto L34
    L14:
        IndicatorGroupLayout r25 = this.f13460w;
        if (r25 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r25 = null;
    L17:
        r25.setDrawBackground(false);
        goto L18
    }
}
