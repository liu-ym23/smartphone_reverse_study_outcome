package com.google.android.material.carousel;

import ai.j0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ai.widget.contianer.c;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int ALIGNMENT_CENTER = 1;
    public static final int ALIGNMENT_START = 0;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "CarouselLayoutManager";
    public static final int VERTICAL = 1;
    private int carouselAlignment;

    @NonNull
    private CarouselStrategy carouselStrategy;
    private int currentEstimatedPosition;
    private int currentFillStartPosition;

    @Nullable
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private boolean isDebuggingEnabled;

    @Nullable
    private KeylineStateList keylineStateList;

    @Nullable
    private Map<Integer, KeylineState> keylineStatePositionMap;
    private int lastItemCount;

    @VisibleForTesting
    int maxScroll;

    @VisibleForTesting
    int minScroll;
    private CarouselOrientationHelper orientationHelper;
    private final View.OnLayoutChangeListener recyclerViewSizeChangeListener;

    @VisibleForTesting
    int scrollOffset;

    public static final class ChildCalculations {
        final float center;
        final View child;
        final float offsetCenter;
        final KeylineRange range;

        public ChildCalculations(View r5, float r10, float r11, KeylineRange r12) {
            this.child = r5;
            this.center = r10;
            this.offsetCenter = r11;
            this.range = r12;
        }
    }

    public static class DebugItemDecoration extends RecyclerView.ItemDecoration {
        private List<KeylineState.Keyline> keylines;
        private final Paint linePaint;

        public DebugItemDecoration() {
            Paint r5 = new Paint();
            this.linePaint = r5;
            this.keylines = Collections.unmodifiableList(new ArrayList());
            r5.setStrokeWidth(5.0f);
            r5.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull RecyclerView.State r12) {
            super.onDrawOver(r10, r11, r12);
            this.linePaint.setStrokeWidth(r11.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            Iterator<KeylineState.Keyline> r13 = this.keylines.iterator();
        L4:
            if (r13.hasNext() == false) goto L9;
            KeylineState.Keyline r5 = r13.next();
            this.linePaint.setColor(ColorUtils.blendARGB(-65281, -16776961, r5.mask));
            if (((CarouselLayoutManager) r11.getLayoutManager()).isHorizontal() == true) goto L7;
            r10.drawLine(CarouselLayoutManager.access$300((CarouselLayoutManager) r11.getLayoutManager()), r5.locOffset, CarouselLayoutManager.access$400((CarouselLayoutManager) r11.getLayoutManager()), r5.locOffset, this.linePaint);
            goto L4
        L7:
            r10.drawLine(r5.locOffset, CarouselLayoutManager.access$100((CarouselLayoutManager) r11.getLayoutManager()), r5.locOffset, CarouselLayoutManager.access$200((CarouselLayoutManager) r11.getLayoutManager()), this.linePaint);
            goto L4
        }

        public void setKeylines(List<KeylineState.Keyline> r5) {
            this.keylines = Collections.unmodifiableList(r5);
        }
    }

    public static class KeylineRange {
        final KeylineState.Keyline leftOrTop;
        final KeylineState.Keyline rightOrBottom;

        public KeylineRange(KeylineState.Keyline r5, KeylineState.Keyline r10) {
            if (r5.loc > r10.loc) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11);
            this.leftOrTop = r5;
            this.rightOrBottom = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    public static class LayoutDirection {
        private static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;

        private LayoutDirection() {
        }
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    public static /* synthetic */ void a(CarouselLayoutManager r5) {
        r5.refreshKeylineState();
    }

    public static /* synthetic */ KeylineStateList access$000(CarouselLayoutManager r5) {
        return r5.keylineStateList;
    }

    public static /* synthetic */ int access$100(CarouselLayoutManager r5) {
        return r5.getParentTop();
    }

    public static /* synthetic */ int access$200(CarouselLayoutManager r5) {
        return r5.getParentBottom();
    }

    public static /* synthetic */ int access$300(CarouselLayoutManager r5) {
        return r5.getParentLeft();
    }

    public static /* synthetic */ int access$400(CarouselLayoutManager r5) {
        return r5.getParentRight();
    }

    private void addAndLayoutView(View r5, int r10, ChildCalculations r11) {
        float r12 = this.currentKeylineState.getItemSize() / 2.0f;
        addView(r5, r10);
        float r13 = r11.offsetCenter;
        int r14 = (int) (r13 - r12);
        int r15 = (int) (r13 + r12);
        this.orientationHelper.layoutDecoratedWithMargins(r5, r14, r15);
        updateChildMaskForLocation(r5, r11.center, r11.range);
    }

    private float addEnd(float r5, float r10) {
        if (isLayoutRtl() == false) goto L6;
        return r5 - r10;
    L6:
        return r5 + r10;
    }

    private float addStart(float r5, float r10) {
        if (isLayoutRtl() == false) goto L6;
        return r5 + r10;
    L6:
        return r5 - r10;
    }

    private void addViewAtPosition(@NonNull RecyclerView.Recycler r5, int r10, int r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 >= getItemCount()) goto L9;
        ChildCalculations r12 = makeChildCalculations(r5, calculateChildStartForFill(r10), r10);
        addAndLayoutView(r12.child, r11, r12);
        return;
    }

    private void addViewsEnd(RecyclerView.Recycler r5, RecyclerView.State r10, int r11) {
        float r12 = calculateChildStartForFill(r11);
    L4:
        if (r11 >= r10.getItemCount()) goto L13;
        ChildCalculations r13 = makeChildCalculations(r5, r12, r11);
        if (isLocOffsetOutOfFillBoundsEnd(r13.offsetCenter, r13.range) == true) goto L18;
        r12 = addEnd(r12, this.currentKeylineState.getItemSize());
        if (isLocOffsetOutOfFillBoundsStart(r13.offsetCenter, r13.range) == true) goto L12;
        addAndLayoutView(r13.child, -1, r13);
    L12:
        r11 = r11 + 1;
        goto L4
    L18:
        return;
    }

    private void addViewsStart(RecyclerView.Recycler r5, int r10) {
        float r11 = calculateChildStartForFill(r10);
    L3:
        if (r10 < 0) goto L12;
        ChildCalculations r12 = makeChildCalculations(r5, r11, r10);
        if (isLocOffsetOutOfFillBoundsStart(r12.offsetCenter, r12.range) == true) goto L17;
        r11 = addStart(r11, this.currentKeylineState.getItemSize());
        if (isLocOffsetOutOfFillBoundsEnd(r12.offsetCenter, r12.range) == true) goto L11;
        addAndLayoutView(r12.child, 0, r12);
    L11:
        r10 = r10 - 1;
        goto L3
    L17:
        return;
    }

    public static /* synthetic */ void b(CarouselLayoutManager r5, View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        r5.lambda$new$0(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    private float calculateChildOffsetCenterForLocation(View r5, float r10, KeylineRange r11) {
        KeylineState.Keyline r12 = r11.leftOrTop;
        float r13 = r12.locOffset;
        KeylineState.Keyline r14 = r11.rightOrBottom;
        float r15 = AnimationUtils.lerp(r13, r14.locOffset, r12.loc, r14.loc, r10);
        if (r11.rightOrBottom != this.currentKeylineState.getFirstKeyline()) goto L5;
    L6:
        RecyclerView.LayoutParams r16 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        float r17 = this.orientationHelper.getMaskMargins(r16) / this.currentKeylineState.getItemSize();
        KeylineState.Keyline r18 = r11.rightOrBottom;
        float r19 = r10 - r18.loc;
        return r15 + (((1.0f - r18.mask) + r17) * r19);
    L5:
        if (r11.leftOrTop == this.currentKeylineState.getLastKeyline()) goto L6;
        return r15;
    }

    private float calculateChildStartForFill(int r5) {
        return addEnd(getParentStart() - this.scrollOffset, this.currentKeylineState.getItemSize() * r5);
    }

    private int calculateEndScroll(RecyclerView.State r5, KeylineStateList r10) {
        boolean r11 = isLayoutRtl();
        if (r11 == false) goto L5;
        KeylineState r12 = r10.getStartState();
    L6:
        if (r11 == false) goto L8;
        KeylineState.Keyline r13 = r12.getFirstFocalKeyline();
    L9:
        float r14 = (r5.getItemCount() - 1) * r12.getItemSize();
        if (r11 == false) goto L12;
        float r15 = -1.0f;
    L13:
        float r16 = r14 * r15;
        if (r11 == false) goto L16;
        float r17 = -r13.leftOrTopPaddingShift;
    L17:
        int r18 = (int) (((r16 - (r13.loc - getParentStart())) + (getParentEnd() - r13.loc)) + r17);
        if (r11 == false) goto L21;
        return Math.min(0, r18);
    L21:
        return Math.max(0, r18);
    L16:
        r17 = r13.rightOrBottomPaddingShift;
        goto L17
    L12:
        r15 = 1.0f;
        goto L13
    L8:
        r13 = r12.getLastFocalKeyline();
        goto L9
    L5:
        r12 = r10.getEndState();
        goto L6
    }

    private static int calculateShouldScrollBy(int r5, int r10, int r11, int r12) {
        int r13 = r10 + r5;
        if (r13 < r11) goto L5;
        if (r13 > r12) goto L8;
        return r5;
    L8:
        return r12 - r10;
    L5:
        return r11 - r10;
    }

    private int calculateStartScroll(@NonNull KeylineStateList r5) {
        boolean r10 = isLayoutRtl();
        if (r10 == false) goto L5;
        KeylineState r11 = r5.getEndState();
    L6:
        if (r10 == false) goto L8;
        KeylineState.Keyline r12 = r11.getLastFocalKeyline();
    L10:
        return (int) (getParentStart() - addStart(r12.loc, r11.getItemSize() / 2.0f));
    L8:
        r12 = r11.getFirstFocalKeyline();
        goto L10
    L5:
        r11 = r5.getStartState();
        goto L6
    }

    private int convertFocusDirectionToLayoutDirection(int r10) {
        int r5 = getOrientation();
        if (r10 != 1) goto L5;
        return -1;
    L5:
        if (r10 != 2) goto L7;
        return 1;
    L7:
        if (r10 != 17) goto L9;
        if (r5 == 0) goto L33;
        return Integer.MIN_VALUE;
    L33:
        if (isLayoutRtl() == true) goto L35;
        return -1;
    L35:
        return 1;
    L9:
        if (r10 != 33) goto L11;
        if (r5 != 1) goto L30;
        return -1;
    L30:
        return Integer.MIN_VALUE;
    L11:
        if (r10 != 66) goto L13;
        if (r5 == 0) goto L22;
        return Integer.MIN_VALUE;
    L22:
        if (isLayoutRtl() == false) goto L25;
        return -1;
    L25:
        return 1;
    L13:
        if (r10 == 130) goto L16;
        Log.d(TAG, "Unknown focus request:" + r10);
        return Integer.MIN_VALUE;
    L16:
        if (r5 != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    }

    private void fill(RecyclerView.Recycler r5, RecyclerView.State r10) {
        removeAndRecycleOutOfBoundsViews(r5);
        if (getChildCount() != 0) goto L5;
        addViewsStart(r5, this.currentFillStartPosition - 1);
        addViewsEnd(r5, r10, this.currentFillStartPosition);
    L6:
        validateChildOrderIfDebugging();
        return;
    L5:
        int r11 = getPosition(getChildAt(0));
        int r12 = getPosition(getChildAt(getChildCount() - 1));
        addViewsStart(r5, r11 - 1);
        addViewsEnd(r5, r10, r12 + 1);
        goto L6
    }

    private View getChildClosestToEnd() {
        if (isLayoutRtl() == false) goto L5;
        int r5 = 0;
    L7:
        return getChildAt(r5);
    L5:
        r5 = getChildCount() - 1;
        goto L7
    }

    private View getChildClosestToStart() {
        if (isLayoutRtl() == false) goto L5;
        int r5 = getChildCount() - 1;
    L7:
        return getChildAt(r5);
    L5:
        r5 = 0;
        goto L7
    }

    private int getContainerSize() {
        if (isHorizontal() == false) goto L7;
        return getContainerWidth();
    L7:
        return getContainerHeight();
    }

    private float getDecoratedCenterWithMargins(View r5) {
        Rect r10 = new Rect();
        super.getDecoratedBoundsWithMargins(r5, r10);
        if (isHorizontal() == false) goto L7;
        int r11 = r10.centerX();
    L6:
        return r11;
    L7:
        r11 = r10.centerY();
        goto L6
    }

    private int getItemMargins() {
        if (getChildCount() <= 0) goto L10;
        RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.orientationHelper.orientation != 0) goto L9;
        int r10 = ((ViewGroup.MarginLayoutParams) r5).leftMargin;
        int r11 = ((ViewGroup.MarginLayoutParams) r5).rightMargin;
    L8:
        return r10 + r11;
    L9:
        r10 = ((ViewGroup.MarginLayoutParams) r5).topMargin;
        r11 = ((ViewGroup.MarginLayoutParams) r5).bottomMargin;
        goto L8
    L10:
        return 0;
    }

    private KeylineState getKeylineStateForPosition(int r5) {
        Map<Integer, KeylineState> r10 = this.keylineStatePositionMap;
        if (r10 == null) goto L8;
        KeylineState r11 = r10.get(Integer.valueOf(MathUtils.clamp(r5, 0, Math.max(0, getItemCount() - 1))));
        if (r11 == null) goto L8;
        return r11;
    L8:
        return this.keylineStateList.getDefaultState();
    }

    private int getLeftOrTopPaddingForKeylineShift() {
        if (getClipToPadding() == false) goto L5;
        return 0;
    L5:
        if (this.carouselStrategy.isContained() == true) goto L8;
        return 0;
    L8:
        if (getOrientation() != 1) goto L12;
        return getPaddingTop();
    L12:
        return getPaddingLeft();
    }

    private float getMaskedItemSizeForLocOffset(float r5, KeylineRange r10) {
        KeylineState.Keyline r11 = r10.leftOrTop;
        float r12 = r11.maskedItemSize;
        KeylineState.Keyline r13 = r10.rightOrBottom;
        return AnimationUtils.lerp(r12, r13.maskedItemSize, r11.locOffset, r13.locOffset, r5);
    }

    private int getParentBottom() {
        return this.orientationHelper.getParentBottom();
    }

    private int getParentEnd() {
        return this.orientationHelper.getParentEnd();
    }

    private int getParentLeft() {
        return this.orientationHelper.getParentLeft();
    }

    private int getParentRight() {
        return this.orientationHelper.getParentRight();
    }

    private int getParentStart() {
        return this.orientationHelper.getParentStart();
    }

    private int getParentTop() {
        return this.orientationHelper.getParentTop();
    }

    private int getRightOrBottomPaddingForKeylineShift() {
        if (getClipToPadding() == false) goto L5;
        return 0;
    L5:
        if (this.carouselStrategy.isContained() == true) goto L8;
        return 0;
    L8:
        if (getOrientation() != 1) goto L12;
        return getPaddingBottom();
    L12:
        return getPaddingRight();
    }

    private int getScrollOffsetForPosition(int r5, KeylineState r10) {
        if (isLayoutRtl() == false) goto L7;
        return (int) (((getContainerSize() - r10.getLastFocalKeyline().loc) - (r5 * r10.getItemSize())) - (r10.getItemSize() / 2.0f));
    L7:
        return (int) ((r10.getItemSize() / 2.0f) + ((r5 * r10.getItemSize()) - r10.getFirstFocalKeyline().loc));
    }

    private int getSmallestScrollOffsetToFocalKeyline(int r10, @NonNull KeylineState r11) {
        Iterator<KeylineState.Keyline> r5 = r11.getFocalKeylines().iterator();
        int r12 = Integer.MAX_VALUE;
    L4:
        if (r5.hasNext() == false) goto L12;
        KeylineState.Keyline r13 = r5.next();
        float r14 = (r11.getItemSize() / 2.0f) + (r10 * r11.getItemSize());
        if (isLayoutRtl() == false) goto L8;
        int r15 = (int) ((getContainerSize() - r13.loc) - r14);
    L9:
        int r16 = r15 - this.scrollOffset;
        if (Math.abs(r12) <= Math.abs(r16)) goto L4;
        r12 = r16;
        goto L4
    L8:
        r15 = (int) (r14 - r13.loc);
        goto L9
    L12:
        return r12;
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> r13, float r14, boolean r15) {
        float r5 = Float.MAX_VALUE;
        int r10 = -1;
        int r11 = -1;
        int r12 = -1;
        int r16 = -1;
        float r17 = -3.4028235E38f;
        int r18 = 0;
        float r19 = Float.MAX_VALUE;
        float r20 = Float.MAX_VALUE;
    L4:
        if (r18 >= r13.size()) goto L26;
        KeylineState.Keyline r110 = r13.get(r18);
        if (r15 == false) goto L8;
        float r111 = r110.locOffset;
    L9:
        float r112 = Math.abs(r111 - r14);
        if (r111 > r14) goto L15;
        if (r112 > r5) goto L15;
        r10 = r18;
        r5 = r112;
    L15:
        if (r111 <= r14) goto L20;
        if (r112 > r19) goto L20;
        r12 = r18;
        r19 = r112;
    L20:
        if (r111 > r20) goto L23;
        r11 = r18;
        r20 = r111;
    L23:
        if (r111 <= r17) goto L25;
        r16 = r18;
        r17 = r111;
    L25:
        r18 = r18 + 1;
        goto L4
    L8:
        r111 = r110.loc;
        goto L9
    L26:
        if (r10 != (-1)) goto L28;
        r10 = r11;
    L28:
        if (r12 != (-1)) goto L31;
        r12 = r16;
    L31:
        return new KeylineRange(r13.get(r10), r13.get(r12));
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float r5, KeylineRange r10) {
        float r11 = addStart(r5, getMaskedItemSizeForLocOffset(r5, r10) / 2.0f);
        if (isLayoutRtl() == false) goto L8;
        if (r11 < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (r11 > getContainerSize()) goto L11;
        return false;
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float r5, KeylineRange r10) {
        float r11 = addEnd(r5, getMaskedItemSizeForLocOffset(r5, r10) / 2.0f);
        if (isLayoutRtl() == false) goto L8;
        if (r11 > getContainerSize()) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (r11 < 0.0f) goto L11;
        return false;
    }

    private /* synthetic */ void lambda$new$0(View r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        if (r10 != r14) goto L6;
        if (r11 != r15) goto L6;
        if (r12 != r16) goto L6;
        if (r13 != r17) goto L6;
        return;
    L6:
        r5.post(new d(this, 15));
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled == true) goto L6;
        return;
    L6:
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "internal representation of views on the screen");
        int r5 = 0;
    L9:
        if (r5 >= getChildCount()) goto L11;
        View r10 = getChildAt(r5);
        Log.d(TAG, "item position " + getPosition(r10) + ", center:" + getDecoratedCenterWithMargins(r10) + ", child index:" + r5);
        r5 = r5 + 1;
        goto L9
    L11:
        Log.d(TAG, "==============");
        return;
    }

    private ChildCalculations makeChildCalculations(RecyclerView.Recycler r5, float r10, int r11) {
        View r12 = r5.getViewForPosition(r11);
        measureChildWithMargins(r12, 0, 0);
        float r13 = addEnd(r10, this.currentKeylineState.getItemSize() / 2.0f);
        KeylineRange r14 = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r13, false);
        return new ChildCalculations(r12, r13, calculateChildOffsetCenterForLocation(r12, r13, r14), r14);
    }

    private float offsetChild(View r5, float r10, float r11, Rect r12) {
        float r13 = addEnd(r10, r11);
        KeylineRange r14 = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r13, false);
        float r15 = calculateChildOffsetCenterForLocation(r5, r13, r14);
        super.getDecoratedBoundsWithMargins(r5, r12);
        updateChildMaskForLocation(r5, r13, r14);
        this.orientationHelper.offsetChild(r5, r12, r11, r15);
        return r15;
    }

    private void recalculateKeylineStateList(RecyclerView.Recycler r5) {
        View r10 = r5.getViewForPosition(0);
        measureChildWithMargins(r10, 0, 0);
        KeylineState r11 = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, r10);
        if (isLayoutRtl() == false) goto L5;
        r11 = KeylineState.reverse(r11, getContainerSize());
    L5:
        this.keylineStateList = KeylineStateList.from(this, r11, getItemMargins(), getLeftOrTopPaddingForKeylineShift(), getRightOrBottomPaddingForKeylineShift());
    }

    private void refreshKeylineState() {
        this.keylineStateList = null;
        requestLayout();
    }

    private void removeAndRecycleOutOfBoundsViews(RecyclerView.Recycler r5) {
    L3:
        if (getChildCount() <= 0) goto L8;
        View r10 = getChildAt(0);
        float r11 = getDecoratedCenterWithMargins(r10);
        if (isLocOffsetOutOfFillBoundsStart(r11, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r11, true)) == false) goto L8;
        removeAndRecycleView(r10, r5);
    L8:
        if ((getChildCount() - 1) < 0) goto L12;
        View r12 = getChildAt(getChildCount() - 1);
        float r13 = getDecoratedCenterWithMargins(r12);
        if (isLocOffsetOutOfFillBoundsEnd(r13, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r13, true)) == false) goto L18;
        removeAndRecycleView(r12, r5);
        goto L8
    L18:
        return;
    }

    private void scrollBy(RecyclerView r5, int r10) {
        if (isHorizontal() == false) goto L5;
        r5.scrollBy(r10, 0);
        return;
    L5:
        r5.scrollBy(0, r10);
    }

    private void setCarouselAttributes(Context r5, AttributeSet r10) {
        if (r10 == null) goto L5;
        TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.Carousel);
        setCarouselAlignment(r11.getInt(R.styleable.Carousel_carousel_alignment, 0));
        setOrientation(r11.getInt(R.styleable.RecyclerView_android_orientation, 0));
        r11.recycle();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateChildMaskForLocation(View r10, float r11, KeylineRange r12) {
        if ((r10 instanceof Maskable) == true) goto L5;
        return;
    L5:
        KeylineState.Keyline r5 = r12.leftOrTop;
        float r13 = r5.mask;
        KeylineState.Keyline r14 = r12.rightOrBottom;
        float r15 = AnimationUtils.lerp(r13, r14.mask, r5.loc, r14.loc, r11);
        float r16 = r10.getHeight();
        float r17 = r10.getWidth();
        float r18 = AnimationUtils.lerp(0.0f, r17 / 2.0f, 0.0f, 1.0f, r15);
        RectF r19 = this.orientationHelper.getMaskRect(r16, r17, AnimationUtils.lerp(0.0f, r16 / 2.0f, 0.0f, 1.0f, r15), r18);
        float r110 = calculateChildOffsetCenterForLocation(r10, r11, r12);
        RectF r111 = new RectF(r110 - (r19.width() / 2.0f), r110 - (r19.height() / 2.0f), (r19.width() / 2.0f) + r110, (r19.height() / 2.0f) + r110);
        RectF r112 = new RectF(getParentLeft(), getParentTop(), getParentRight(), getParentBottom());
        if (this.carouselStrategy.isContained() == false) goto L8;
        this.orientationHelper.containMaskWithinBounds(r19, r111, r112);
    L8:
        this.orientationHelper.moveMaskOnEdgeOutsideBounds(r19, r111, r112);
        ((Maskable) r10).setMaskRectF(r19);
    }

    private void updateCurrentKeylineStateForScrollOffset(@NonNull KeylineStateList r5) {
        int r10 = this.maxScroll;
        int r11 = this.minScroll;
        if (r10 <= r11) goto L5;
        this.currentKeylineState = r5.getShiftedState(this.scrollOffset, r11, r10);
    L10:
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
        return;
    L5:
        if (isLayoutRtl() == false) goto L7;
        KeylineState r12 = r5.getEndState();
    L8:
        this.currentKeylineState = r12;
        goto L10
    L7:
        r12 = r5.getStartState();
        goto L8
    }

    private void updateItemCount() {
        int r5 = getItemCount();
        int r10 = this.lastItemCount;
        if (r5 != r10) goto L5;
        return;
    L5:
        if (this.keylineStateList != null) goto L8;
        return;
    L8:
        if (this.carouselStrategy.shouldRefreshKeylineState(this, r10) == false) goto L10;
        refreshKeylineState();
    L10:
        this.lastItemCount = r5;
    }

    private void validateChildOrderIfDebugging() {
        if (this.isDebuggingEnabled == true) goto L5;
        return;
    L5:
        if (getChildCount() < 1) goto L18;
        int r5 = 0;
    L9:
        if (r5 >= (getChildCount() - 1)) goto L19;
        int r10 = getPosition(getChildAt(r5));
        int r11 = r5 + 1;
        int r12 = getPosition(getChildAt(r11));
        if (r10 > r12) goto L13;
        r5 = r11;
        goto L9
    L13:
        logChildrenIfDebugging();
        StringBuilder r13 = j0.v("Detected invalid child order. Child at index [", r5, r10, "] had adapter position [", "] and child at index [");
        r13.append(r11);
        r13.append("] had adapter position [");
        r13.append(r12);
        r13.append("].");
        throw new IllegalStateException(r13.toString());
    L19:
        return;
    }

    public int calculateScrollDeltaToMakePositionVisible(int r5) {
        return (int) (this.scrollOffset - getScrollOffsetForPosition(r5, getKeylineStateForPosition(r5)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State r5) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (this.keylineStateList != null) goto L7;
        return 0;
    L7:
        if (getItemCount() > 1) goto L10;
        return 0;
    L10:
        return (int) (getWidth() * (this.keylineStateList.getDefaultState().getItemSize() / computeHorizontalScrollRange(r5)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State r5) {
        return this.scrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State r5) {
        return this.maxScroll - this.minScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    @Nullable
    public PointF computeScrollVectorForPosition(int r5) {
        if (this.keylineStateList != null) goto L6;
        return null;
    L6:
        int r10 = getOffsetToScrollToPosition(r5, getKeylineStateForPosition(r5));
        if (isHorizontal() == false) goto L11;
        return new PointF(r10, 0.0f);
    L11:
        return new PointF(0.0f, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State r5) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (this.keylineStateList != null) goto L7;
        return 0;
    L7:
        if (getItemCount() > 1) goto L10;
        return 0;
    L10:
        return (int) (getHeight() * (this.keylineStateList.getDefaultState().getItemSize() / computeVerticalScrollRange(r5)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State r5) {
        return this.scrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State r5) {
        return this.maxScroll - this.minScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getCarouselAlignment() {
        return this.carouselAlignment;
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerHeight() {
        return getHeight();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerWidth() {
        return getWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(@NonNull View r5, @NonNull Rect r10) {
        super.getDecoratedBoundsWithMargins(r5, r10);
        float r11 = r10.centerY();
        if (isHorizontal() == false) goto L5;
        r11 = r10.centerX();
    L5:
        float r12 = getMaskedItemSizeForLocOffset(r11, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r11, true));
        float r13 = 0.0f;
        if (isHorizontal() == false) goto L8;
        float r14 = (r10.width() - r12) / 2.0f;
    L10:
        if (isHorizontal() == true) goto L13;
        r13 = (r10.height() - r12) / 2.0f;
    L13:
        r10.set((int) (r10.left + r14), (int) (r10.top + r13), (int) (r10.right - r14), (int) (r10.bottom - r13));
        return;
    L8:
        r14 = 0.0f;
        goto L10
    }

    public int getOffsetToScrollToPosition(int r5, @NonNull KeylineState r10) {
        return getScrollOffsetForPosition(r5, r10) - this.scrollOffset;
    }

    public int getOffsetToScrollToPositionForSnap(int r10, boolean r11) {
        int r5 = getOffsetToScrollToPosition(r10, this.keylineStateList.getShiftedState(this.scrollOffset, this.minScroll, this.maxScroll, true));
        if (this.keylineStatePositionMap == null) goto L5;
        int r12 = getOffsetToScrollToPosition(r10, getKeylineStateForPosition(r10));
    L6:
        if (r11 == true) goto L8;
        return r5;
    L8:
        if (Math.abs(r12) < Math.abs(r5)) goto L10;
        return r5;
    L10:
        return r12;
    L5:
        r12 = r5;
        goto L6
    }

    public int getOrientation() {
        return this.orientationHelper.orientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.material.carousel.Carousel
    public boolean isHorizontal() {
        if (this.orientationHelper.orientation != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLayoutRtl() {
        if (isHorizontal() == true) goto L5;
    L7:
        return false;
    L5:
        if (getLayoutDirection() != 1) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(@NonNull View r10, int r11, int r12) {
        if ((r10 instanceof Maskable) == false) goto L19;
        RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) r10.getLayoutParams();
        Rect r13 = new Rect();
        calculateItemDecorationsForChild(r10, r13);
        int r14 = (r13.left + r13.right) + r11;
        int r15 = (r13.top + r13.bottom) + r12;
        KeylineStateList r16 = this.keylineStateList;
        if (r16 != null) goto L7;
    L9:
        float r17 = ((ViewGroup.MarginLayoutParams) r5).width;
    L10:
        KeylineStateList r18 = this.keylineStateList;
        if (r18 != null) goto L13;
    L15:
        float r19 = ((ViewGroup.MarginLayoutParams) r5).height;
    L16:
        r10.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), (((getPaddingRight() + getPaddingLeft()) + ((ViewGroup.MarginLayoutParams) r5).leftMargin) + ((ViewGroup.MarginLayoutParams) r5).rightMargin) + r14, (int) r17, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), (((getPaddingBottom() + getPaddingTop()) + ((ViewGroup.MarginLayoutParams) r5).topMargin) + ((ViewGroup.MarginLayoutParams) r5).bottomMargin) + r15, (int) r19, canScrollVertically()));
        return;
    L13:
        if (this.orientationHelper.orientation != 1) goto L15;
        r19 = r18.getDefaultState().getItemSize();
        goto L16
    L7:
        if (this.orientationHelper.orientation != 0) goto L9;
        r17 = r16.getDefaultState().getItemSize();
        goto L10
    L19:
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView r5) {
        super.onAttachedToWindow(r5);
        this.carouselStrategy.initialize(r5.getContext());
        refreshKeylineState();
        r5.addOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r5, RecyclerView.Recycler r10) {
        super.onDetachedFromWindow(r5, r10);
        r5.removeOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(@NonNull View r5, int r10, @NonNull RecyclerView.Recycler r11, @NonNull RecyclerView.State r12) {
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r13 = convertFocusDirectionToLayoutDirection(r10);
        if (r13 != Integer.MIN_VALUE) goto L9;
        return null;
    L9:
        if (r13 != (-1)) goto L15;
        if (getPosition(r5) != 0) goto L13;
        return null;
    L13:
        addViewAtPosition(r11, getPosition(getChildAt(0)) - 1, 0);
        return getChildClosestToStart();
    L15:
        if (getPosition(r5) != (getItemCount() - 1)) goto L17;
        return null;
    L17:
        addViewAtPosition(r11, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return getChildClosestToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        if (getChildCount() <= 0) goto L6;
        r5.setFromIndex(getPosition(getChildAt(0)));
        r5.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView r5, int r10, int r11) {
        super.onItemsAdded(r5, r10, r11);
        updateItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView r5, int r10, int r11) {
        super.onItemsRemoved(r5, r10, r11);
        updateItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (r11.getItemCount() > 0) goto L5;
    L27:
        removeAndRecycleAllViews(r10);
        this.currentFillStartPosition = 0;
        return;
    L5:
        if (getContainerSize() <= 0.0f) goto L27;
        boolean r5 = isLayoutRtl();
        if (this.keylineStateList != null) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
        recalculateKeylineStateList(r10);
    L13:
        int r13 = calculateStartScroll(this.keylineStateList);
        int r14 = calculateEndScroll(r11, this.keylineStateList);
        if (r5 == false) goto L16;
        int r15 = r14;
    L17:
        this.minScroll = r15;
        if (r5 == false) goto L20;
        r14 = r13;
    L20:
        this.maxScroll = r14;
        if (r12 == false) goto L25;
        this.scrollOffset = r13;
        this.keylineStatePositionMap = this.keylineStateList.getKeylineStateForPositionMap(getItemCount(), this.minScroll, this.maxScroll, isLayoutRtl());
        int r16 = this.currentEstimatedPosition;
        if (r16 == (-1)) goto L25;
        this.scrollOffset = getScrollOffsetForPosition(r16, getKeylineStateForPosition(r16));
    L25:
        int r17 = this.scrollOffset;
        this.scrollOffset = r17 + calculateShouldScrollBy(0, r17, this.minScroll, this.maxScroll);
        this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, r11.getItemCount());
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        detachAndScrapAttachedViews(r10);
        fill(r10, r11);
        this.lastItemCount = getItemCount();
        return;
    L16:
        r15 = r13;
        goto L17
    L10:
        r12 = false;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r5) {
        super.onLayoutCompleted(r5);
        if (getChildCount() != 0) goto L5;
        this.currentFillStartPosition = 0;
    L6:
        validateChildOrderIfDebugging();
        return;
    L5:
        this.currentFillStartPosition = getPosition(getChildAt(0));
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r5, @NonNull View r10, @NonNull Rect r11, boolean r12, boolean r13) {
        if (this.keylineStateList != null) goto L5;
        return false;
    L5:
        int r14 = getSmallestScrollOffsetToFocalKeyline(getPosition(r10), getKeylineStateForPosition(getPosition(r10)));
        if (r14 != 0) goto L8;
        return false;
    L8:
        scrollBy(r5, getSmallestScrollOffsetToFocalKeyline(getPosition(r10), this.keylineStateList.getShiftedState(this.scrollOffset + calculateShouldScrollBy(r14, this.scrollOffset, this.minScroll, this.maxScroll), this.minScroll, this.maxScroll)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (canScrollHorizontally() == true) goto L7;
        return 0;
    L7:
        return scrollBy(r5, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r5) {
        this.currentEstimatedPosition = r5;
        if (this.keylineStateList != null) goto L5;
        return;
    L5:
        this.scrollOffset = getScrollOffsetForPosition(r5, getKeylineStateForPosition(r5));
        this.currentFillStartPosition = MathUtils.clamp(r5, 0, Math.max(0, getItemCount() - 1));
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (canScrollVertically() == true) goto L7;
        return 0;
    L7:
        return scrollBy(r5, r10, r11);
    }

    public void setCarouselAlignment(int r5) {
        this.carouselAlignment = r5;
        refreshKeylineState();
    }

    public void setCarouselStrategy(@NonNull CarouselStrategy r5) {
        this.carouselStrategy = r5;
        refreshKeylineState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setDebuggingEnabled(@NonNull RecyclerView r5, boolean r10) {
        this.isDebuggingEnabled = r10;
        r5.removeItemDecoration(this.debugItemDecoration);
        if (r10 == false) goto L5;
        r5.addItemDecoration(this.debugItemDecoration);
    L5:
        r5.invalidateItemDecorations();
    }

    public void setOrientation(int r5) {
        if (r5 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        CarouselOrientationHelper r10 = this.orientationHelper;
        if (r10 != null) goto L11;
    L12:
        this.orientationHelper = CarouselOrientationHelper.createOrientationHelper(this, r5);
        refreshKeylineState();
        return;
    L11:
        if (r5 != r10.orientation) goto L12;
        return;
    L4:
        if (r5 == 1) goto L8;
        throw new IllegalArgumentException(j0.g(r5, "invalid orientation:"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r5, RecyclerView.State r10, int r11) {
        final Context r12 = r5.getContext();
        LinearSmoothScroller r13 = new AnonymousClass1(this, r12);
        r13.setTargetPosition(r11);
        startSmoothScroll(r13);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy r5) {
        this(r5, 0);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy r5, int r10) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new c(this, 1);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(r5);
        setOrientation(r10);
    }

    private int scrollBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        int r5 = 0;
        if (getChildCount() == 0) goto L24;
        if (r10 == 0) goto L24;
        if (this.keylineStateList != null) goto L9;
        recalculateKeylineStateList(r11);
    L9:
        int r13 = calculateShouldScrollBy(r10, this.scrollOffset, this.minScroll, this.maxScroll);
        this.scrollOffset += r13;
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        float r14 = this.currentKeylineState.getItemSize() / 2.0f;
        float r15 = calculateChildStartForFill(getPosition(getChildAt(0)));
        Rect r16 = new Rect();
        if (isLayoutRtl() == false) goto L12;
        float r17 = this.currentKeylineState.getLastFocalKeyline().locOffset;
    L13:
        float r18 = Float.MAX_VALUE;
    L15:
        if (r5 >= getChildCount()) goto L22;
        View r19 = getChildAt(r5);
        float r20 = Math.abs(r17 - offsetChild(r19, r15, r14, r16));
        if (r19 == null) goto L21;
        if (r20 >= r18) goto L21;
        this.currentEstimatedPosition = getPosition(r19);
        r18 = r20;
    L21:
        r15 = addEnd(r15, this.currentKeylineState.getItemSize());
        r5 = r5 + 1;
        goto L15
    L22:
        fill(r11, r12);
        return r13;
    L12:
        r17 = this.currentKeylineState.getFirstFocalKeyline().locOffset;
    L24:
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context r5, AttributeSet r10, int r11, int r12) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new c(this, 1);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
        setCarouselAttributes(r5, r10);
    }
}
