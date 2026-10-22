package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

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
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0003\\]^B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\u0018\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0014J\u0010\u0010/\u001a\u00020)2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u00100\u001a\u00020)2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u00101\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\bJ\u000e\u00104\u001a\u00020)2\u0006\u00103\u001a\u00020\bJ\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\bJ\u000e\u00107\u001a\u00020)2\u0006\u00106\u001a\u00020\bJ\u000e\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001dJ\u000e\u0010<\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010=\u001a\u00020)2\b\b\u0001\u0010>\u001a\u00020\bJ\u0010\u0010?\u001a\u00020)2\b\b\u0001\u0010@\u001a\u00020\bJ&\u0010A\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u001d2\b\b\u0001\u0010E\u001a\u00020\bH\u0002J\u001c\u0010F\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0G2\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\bH\u0002J\b\u0010K\u001a\u00020\bH\u0002J\b\u0010L\u001a\u00020\bH\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020\"2\u0006\u0010H\u001a\u00020'H\u0002J\b\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020'H\u0002J\b\u0010R\u001a\u00020)H\u0002J\b\u0010S\u001a\u00020\bH\u0002J\b\u0010T\u001a\u00020\u001dH\u0002J\u0010\u0010U\u001a\u00020\b2\u0006\u0010J\u001a\u00020\bH\u0002J \u0010V\u001a\u00020)2\u0006\u0010J\u001a\u00020\b2\u0006\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\bH\u0016J\u0010\u0010Y\u001a\u00020)2\u0006\u0010J\u001a\u00020\bH\u0016J\u0010\u0010Z\u001a\u00020)2\u0006\u0010[\u001a\u00020\bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator;", "Landroid/view/View;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "internalRecyclerScrollListener", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "internalPageChangeCallback", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalPageChangeCallback;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "dotCount", "fadingDotCount", "selectedDotRadiusPx", "dotRadiusPx", "dotSeparationDistancePx", "supportRtl", "", "verticalSupport", "dotColor", "selectedDotColor", "selectedDotPaint", "Landroid/graphics/Paint;", "dotPaint", "selectedItemPosition", "intermediateSelectedItemPosition", "offsetPercent", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "attachToRecyclerView", "attachToViewPager", "attachToViewPager2", "setDotCount", "count", "setFadingDotCount", "setSelectedDotRadius", "radius", "setDotRadius", "setDotSeparationDistance", "distance", "setRTLSupport", "supportRTL", "setVerticalSupport", "setDotColor", "newDotColor", "setSelectedDotColor", "newSelectedDotColor", "getDefaultPaintConfig", "defaultStyle", "Landroid/graphics/Paint$Style;", "isAntiAliasDefault", "defaultColor", "getXYPositionsByCoordinate", "Lkotlin/Pair;", "coordinate", "getDotCoordinate", "position", "getDotYCoordinate", "getDistanceBetweenTheCenterOfTwoDots", "getRadius", "getPaint", "getCalculatedWidth", "dpToPx", "dp", "removeAllSources", "getItemCount", "isRtl", "getRTLPosition", "onPageScrolled", "positionOffset", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "Companion", "InternalRecyclerScrollListener", "InternalPageChangeCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IndefinitePagerIndicator extends View implements ViewPager.OnPageChangeListener {
    public static final /* synthetic */ int r = 0;
    public ViewPager2 a;
    public InternalPageChangeCallback b;
    public final DecelerateInterpolator c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public final Paint m;
    public final Paint n;
    public int o;
    public int p;
    public float q;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "<init>", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator;)V", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator;)V", "previousMostVisibleChild", "Landroid/view/View;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "getMostVisibleChild", "calculatePercentVisible", "", "child", "setIntermediateSelectedItemPosition", "mostVisibleChild", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        public final void onScrolled(RecyclerView r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "recyclerView");
            int r4 = IndefinitePagerIndicator.r;
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

    private final int getCalculatedWidth() {
        return (((this.d + (this.e * 2)) - 1) * getDistanceBetweenTheCenterOfTwoDots()) + (this.g * 2);
    }

    private final int getDistanceBetweenTheCenterOfTwoDots() {
        return (this.g * 2) + this.h;
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

    private final int getDotYCoordinate() {
        return this.f;
    }

    public final int a(float r3) {
        Resources r0 = getResources();
        return (int) (r3 * (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).densityDpi / 160));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        IntRange r0 = RangesKt.until(0, getItemCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Float.valueOf(((r2.nextInt() - this.p) * getDistanceBetweenTheCenterOfTwoDots()) + (getDistanceBetweenTheCenterOfTwoDots() * this.q)));
        goto L4
    L6:
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L26;
        float r4 = ((Number) r3.next()).floatValue();
        if (this.j == false) goto L12;
        float r5 = getDotYCoordinate();
        float r6 = (getHeight() / 2) + r4;
    L13:
        Pair r7 = new Pair(Float.valueOf(r5), Float.valueOf(r6));
        float r8 = ((Number) r7.component1()).floatValue();
        float r9 = ((Number) r7.component2()).floatValue();
        float r11 = Math.abs(r4);
        float r12 = (this.d / 2) * getDistanceBetweenTheCenterOfTwoDots();
        if (r11 >= (getDistanceBetweenTheCenterOfTwoDots() / 2)) goto L17;
        int r13 = this.f;
    L19:
        float r14 = r13;
    L22:
        if (Math.abs(r4) >= (getDistanceBetweenTheCenterOfTwoDots() / 2)) goto L24;
        Paint r15 = this.m;
    L25:
        r10.drawCircle(r8, r9, r14, r15);
        goto L8
    L24:
        r15 = this.n;
        goto L25
    L17:
        if (r11 > r12) goto L20;
        r13 = this.g;
        goto L19
    L20:
        r14 = this.c.getInterpolation(1 - ((r11 - r12) / ((getCalculatedWidth() / 2.01f) - r12))) * this.g;
        goto L22
    L12:
        r5 = (getWidth() / 2) + r4;
        r6 = getDotYCoordinate();
        goto L13
    }

    public final void onPageSelected(int r3) {
        this.p = this.o;
        if (this.i == false) goto L10;
        boolean r1 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        r3 = (getItemCount() - r3) - 1;
    L10:
        this.o = r3;
        invalidate();
    }

    public final void setDotColor(int r2) {
        this.k = r2;
        this.n.setColor(r2);
        invalidate();
    }

    public final void setDotCount(int r1) {
        this.d = r1;
        invalidate();
    }

    public final void setDotRadius(int r1) {
        this.g = a(r1);
        invalidate();
    }

    public final void setDotSeparationDistance(int r1) {
        this.h = a(r1);
        invalidate();
    }

    public final void setFadingDotCount(int r1) {
        this.e = r1;
        invalidate();
    }

    public final void setRTLSupport(boolean r1) {
        this.i = r1;
        invalidate();
    }

    public final void setSelectedDotColor(int r2) {
        this.l = r2;
        this.m.setColor(r2);
        invalidate();
    }

    public final void setSelectedDotRadius(int r1) {
        this.f = a(r1);
        invalidate();
    }

    public final void setVerticalSupport(boolean r1) {
        this.j = r1;
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
        int r3 = this.f * 2;
        if (this.j == false) goto L5;
        setMeasuredDimension(r3, getCalculatedWidth());
        return;
    L5:
        setMeasuredDimension(getCalculatedWidth(), r3);
    }

    public IndefinitePagerIndicator(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.c = new DecelerateInterpolator();
        this.d = 5;
        this.e = 1;
        this.f = a(5.5f);
        this.g = a(4.0f);
        this.h = a(10.0f);
        this.k = ContextCompat.getColor(r4, 2131103022);
        this.l = ContextCompat.getColor(r4, 2131103023);
        if (r5 == null) goto L5;
        TypedArray r7 = r4.getTheme().obtainStyledAttributes(r5, new int[]{2130971131, 2130971132, 2130971133, 2130971134, 2130971605, 2130972229, 2130972230, 2130972320, 2130972348}, 0, 0);
        this.d = r7.getInteger(1, 5);
        this.e = r7.getInt(4, 1);
        this.g = r7.getDimensionPixelSize(2, this.g);
        this.f = r7.getDimensionPixelSize(6, this.f);
        this.k = r7.getColor(0, this.k);
        this.l = r7.getColor(5, this.l);
        this.h = r7.getDimensionPixelSize(3, this.h);
        this.i = r7.getBoolean(7, false);
        this.j = r7.getBoolean(8, false);
        r7.recycle();
    L5:
        this.m = b(this, this.l);
        this.n = b(this, this.k);
    }

    public final void onPageScrolled(int r3, float r4, int r5) {
        if (this.i == true) goto L5;
    L10:
        this.o = r3;
        this.p = r3;
        this.q = r4 * (-1);
    L11:
        invalidate();
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        int r7 = (getItemCount() - r3) - 1;
        this.o = r7;
        this.p = r7;
        this.q = r4 * 1;
        goto L11
    L7:
        r6 = false;
        goto L8
    }

    public /* synthetic */ IndefinitePagerIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
