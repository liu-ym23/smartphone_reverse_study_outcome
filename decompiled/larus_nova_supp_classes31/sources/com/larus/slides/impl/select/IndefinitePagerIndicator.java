package com.larus.slides.impl.select;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0003]^_B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\u0018\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0014J\u0010\u0010/\u001a\u00020)2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u00100\u001a\u00020)2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u00101\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\bJ\u000e\u00104\u001a\u00020)2\u0006\u00103\u001a\u00020\bJ\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\bJ\u000e\u00107\u001a\u00020)2\u0006\u00106\u001a\u00020\bJ\u000e\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001dJ\u000e\u0010<\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010=\u001a\u00020)2\b\b\u0001\u0010>\u001a\u00020\bJ\u0010\u0010?\u001a\u00020)2\b\b\u0001\u0010@\u001a\u00020\bJ&\u0010A\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u001d2\b\b\u0001\u0010E\u001a\u00020\bH\u0002J\u001c\u0010F\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0G2\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\bH\u0002J\b\u0010K\u001a\u00020\bH\u0002J\b\u0010L\u001a\u00020\bH\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020\"2\u0006\u0010J\u001a\u00020\bH\u0002J\b\u0010O\u001a\u00020\bH\u0002J\b\u0010P\u001a\u00020\bH\u0002J\u0010\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020'H\u0002J\b\u0010S\u001a\u00020)H\u0002J\b\u0010T\u001a\u00020\bH\u0002J\b\u0010U\u001a\u00020\u001dH\u0002J\u0010\u0010V\u001a\u00020\b2\u0006\u0010J\u001a\u00020\bH\u0002J \u0010W\u001a\u00020)2\u0006\u0010J\u001a\u00020\b2\u0006\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020\bH\u0016J\u0010\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u00020\bH\u0016J\u0010\u0010[\u001a\u00020)2\u0006\u0010\\\u001a\u00020\bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/larus/slides/impl/select/IndefinitePagerIndicator;", "Landroid/view/View;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "internalRecyclerScrollListener", "Lcom/larus/slides/impl/select/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "internalPageChangeCallback", "Lcom/larus/slides/impl/select/IndefinitePagerIndicator$InternalPageChangeCallback;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "dotCount", "fadingDotCount", "selectedDotRadiusPx", "dotRadiusPx", "dotSeparationDistancePx", "supportRtl", "", "verticalSupport", "dotColor", "selectedDotColor", "selectedDotPaint", "Landroid/graphics/Paint;", "dotPaint", "selectedItemPosition", "intermediateSelectedItemPosition", "offsetPercent", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "attachToRecyclerView", "attachToViewPager", "attachToViewPager2", "setDotCount", "count", "setFadingDotCount", "setSelectedDotRadius", "radius", "setDotRadius", "setDotSeparationDistance", "distance", "setRTLSupport", "supportRTL", "setVerticalSupport", "setDotColor", "newDotColor", "setSelectedDotColor", "newSelectedDotColor", "getDefaultPaintConfig", "defaultStyle", "Landroid/graphics/Paint$Style;", "isAntiAliasDefault", "defaultColor", "getXYPositionsByCoordinate", "Lkotlin/Pair;", "coordinate", "getDotCoordinate", "position", "getDotYCoordinate", "getDistanceBetweenTheCenterOfTwoDots", "getRadius", "getPaint", "getSelectedDotIndex", "getCalculatedWidth", "dpToPx", "dp", "removeAllSources", "getItemCount", "isRtl", "getRTLPosition", "onPageScrolled", "positionOffset", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "Companion", "InternalRecyclerScrollListener", "InternalPageChangeCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class IndefinitePagerIndicator extends View implements ViewPager.OnPageChangeListener {
    public static final /* synthetic */ int m = 0;
    public ViewPager2 a;
    public InternalPageChangeCallback b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public final Paint j;
    public final Paint k;
    public int l;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/slides/impl/select/IndefinitePagerIndicator$InternalPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "<init>", "(Lcom/larus/slides/impl/select/IndefinitePagerIndicator;)V", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class InternalPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        public final /* synthetic */ IndefinitePagerIndicator a;

        public InternalPageChangeCallback(IndefinitePagerIndicator r1) {
            this.a = r1;
        }

        public final void onPageSelected(int r2) {
            this.a.onPageSelected(r2);
        }

        public final void onPageScrolled(int r2, float r3, int r4) {
            this.a.onPageScrolled(r2, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/slides/impl/select/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Lcom/larus/slides/impl/select/IndefinitePagerIndicator;)V", "previousMostVisibleChild", "Landroid/view/View;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "getMostVisibleChild", "calculatePercentVisible", "", "child", "setIntermediateSelectedItemPosition", "mostVisibleChild", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        public final void onScrolled(RecyclerView r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "recyclerView");
            int r4 = IndefinitePagerIndicator.m;
            throw null;
        }
    }

    public static final class a {
    }

    static {
    }

    public IndefinitePagerIndicator(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IndefinitePagerIndicator(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onPageScrollStateChanged(int r1) {
    }

    private final int getDistanceBetweenTheCenterOfTwoDots() {
        return (this.d * 2) + this.e;
    }

    private final int getItemCount() {
        ViewPager2 r0 = this.a;
        if (r0 == null) goto L9;
        if (r0 == null) goto L10;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 != null) goto L8;
        return 0;
    L8:
        return r1.getItemCount();
    L10:
        return 0;
    L9:
        return 0;
    }

    private final int getCalculatedWidth() {
        return ((getItemCount() - 1) * getDistanceBetweenTheCenterOfTwoDots()) + (this.d * 2);
    }

    private final int getSelectedDotIndex() {
        int r0 = getItemCount();
        if (r0 > 0) goto L6;
        return 0;
    L6:
        return RangesKt.coerceIn(this.l, 0, r0 - 1);
    }

    private final int getDotYCoordinate() {
        return this.d;
    }

    public final int a(float r3) {
        Resources r0 = getResources();
        return (int) (r3 * (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).densityDpi / 160));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.onDraw(r7);
        IntIterator r0 = RangesKt.until(0, getItemCount()).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        int r1 = r0.nextInt();
        int r2 = getItemCount();
        if (r2 > 0) goto L8;
        float r3 = 0.0f;
    L10:
        if (this.g == false) goto L12;
        float r4 = getDotYCoordinate();
        float r5 = (getHeight() / 2) + r3;
    L13:
        Pair r6 = new Pair(Float.valueOf(r4), Float.valueOf(r5));
        float r8 = ((Number) r6.component1()).floatValue();
        float r9 = ((Number) r6.component2()).floatValue();
        float r10 = this.d;
        if (r1 != getSelectedDotIndex()) goto L16;
        Paint r11 = this.j;
    L17:
        r7.drawCircle(r8, r9, r10, r11);
        goto L4
    L16:
        r11 = this.k;
        goto L17
    L12:
        r4 = (getWidth() / 2) + r3;
        r5 = getDotYCoordinate();
        goto L13
    L8:
        r3 = getDistanceBetweenTheCenterOfTwoDots() * (r1 - ((r2 - 1) / 2.0f));
        goto L10
    }

    public final void onPageSelected(int r3) {
        if (this.f == false) goto L10;
        boolean r1 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        r3 = (getItemCount() - r3) - 1;
    L10:
        this.l = r3;
        invalidate();
    }

    public final void setDotColor(int r2) {
        this.h = r2;
        this.k.setColor(r2);
        invalidate();
    }

    public final void setDotCount(int r1) {
        invalidate();
    }

    public final void setDotRadius(int r1) {
        this.d = a(r1);
        invalidate();
    }

    public final void setDotSeparationDistance(int r1) {
        this.e = a(r1);
        invalidate();
    }

    public final void setFadingDotCount(int r1) {
        invalidate();
    }

    public final void setRTLSupport(boolean r1) {
        this.f = r1;
        invalidate();
    }

    public final void setSelectedDotColor(int r2) {
        this.i = r2;
        this.j.setColor(r2);
        invalidate();
    }

    public final void setSelectedDotRadius(int r1) {
        this.c = a(r1);
        invalidate();
    }

    public final void setVerticalSupport(boolean r1) {
        this.g = r1;
        invalidate();
    }

    public static Paint b(IndefinitePagerIndicator r1, int r2) {
        Paint.Style r0 = Paint.Style.FILL;
        r1.getClass();
        Paint r3 = new Paint();
        r3.setStyle(r0);
        r3.setAntiAlias(true);
        r3.setColor(r2);
        return r3;
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        int r3 = this.d * 2;
        if (this.g == false) goto L5;
        setMeasuredDimension(r3, getCalculatedWidth());
        return;
    L5:
        setMeasuredDimension(getCalculatedWidth(), r3);
    }

    public IndefinitePagerIndicator(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        new DecelerateInterpolator();
        this.c = a(5.5f);
        this.d = a(4.0f);
        this.e = a(10.0f);
        this.h = ContextCompat.getColor(r3, 2131103289);
        this.i = ContextCompat.getColor(r3, 2131103290);
        if (r4 == null) goto L5;
        TypedArray r6 = r3.getTheme().obtainStyledAttributes(r4, new int[]{2130972258, 2130972259, 2130972260, 2130972261, 2130972262, 2130972263, 2130972264, 2130972265, 2130972266}, 0, 0);
        r6.getInteger(1, 5);
        r6.getInt(4, 1);
        this.d = r6.getDimensionPixelSize(2, this.d);
        this.c = r6.getDimensionPixelSize(6, this.c);
        this.h = r6.getColor(0, this.h);
        this.i = r6.getColor(5, this.i);
        this.e = r6.getDimensionPixelSize(3, this.e);
        this.f = r6.getBoolean(7, false);
        this.g = r6.getBoolean(8, false);
        r6.recycle();
    L5:
        this.j = b(this, this.i);
        this.k = b(this, this.h);
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
        if (this.f == false) goto L10;
        boolean r4 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L8;
        r4 = false;
    L8:
        if (r4 == false) goto L10;
        this.l = (getItemCount() - r1) - 1;
    L11:
        invalidate();
        return;
    L10:
        this.l = r1;
        goto L11
    }

    public /* synthetic */ IndefinitePagerIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
