package com.larksuite.framework.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0014J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J0\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014¨\u0006 "}, d2 = {"Lcom/larksuite/framework/ui/PriorityLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "handleMeasure", "onLayout", "changed", "", "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getMeasureMode", "lp", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "Lcom/larksuite/framework/ui/PriorityLayout$LayoutParams;", "generateDefaultLayoutParams", "LayoutParams", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PriorityLayout extends FrameLayout {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000f¢\u0006\u0004\b\u0006\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/larksuite/framework/ui/PriorityLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Lcom/larksuite/framework/ui/PriorityLayout$LayoutParams;)V", "priority", "getPriority", "()I", "setPriority", "(I)V", "Companion", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        public int a;

        public static final class a {
        }

        static {
        }

        public LayoutParams(ViewGroup.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
            this.a = 1;
        }

        public LayoutParams(Context r5, AttributeSet r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            super(r5, r6);
            this.a = 1;
            TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130973615});
            this.a = Math.max(1, Math.min(r7.getInt(0, 0), 10));
            r7.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.a = 1;
        }
    }

    public PriorityLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PriorityLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "lp");
        return new LayoutParams(r2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r19, int r20) {
        int r1 = r19;
        if (getChildCount() <= 0) goto L63;
        if (r1 == 0) goto L63;
        int r3 = View.MeasureSpec.getSize(r19);
        int r4 = getPaddingLeft() + getPaddingRight();
        int r5 = getPaddingTop() + getPaddingBottom();
        List[] r7 = new List[11];
        int r9 = 0;
    L7:
        if (r9 >= 11) goto L9;
        r7[r9] = new ArrayList();
        r9 = r9 + 1;
        goto L7
    L9:
        LinkedHashMap r6 = new LinkedHashMap();
        LinkedHashMap r10 = new LinkedHashMap();
        int r11 = getChildCount();
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L10:
        if (r12 >= r11) goto L16;
        View r15 = getChildAt(r12);
        if (r15.getVisibility() == 8) goto L15;
        measureChild(r15, r1, r20);
        ViewGroup.LayoutParams r8 = r15.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larksuite.framework.ui.PriorityLayout.LayoutParams");
        LayoutParams r16 = (LayoutParams) r8;
        int r17 = ((FrameLayout.LayoutParams) r16).topMargin + ((FrameLayout.LayoutParams) r16).bottomMargin;
        int r2 = ((FrameLayout.LayoutParams) r16).leftMargin + ((FrameLayout.LayoutParams) r16).rightMargin;
        r14 = Math.max(r14, r15.getMeasuredHeight() + r17);
        List r21 = r7[r16.a];
        Intrinsics.checkNotNull(r15);
        r21.add(r15);
        r6.put(r15, Integer.valueOf(r15.getMeasuredWidth()));
        r10.put(r15, Integer.valueOf(r2));
        r13 = r13 + (r15.getMeasuredWidth() + r2);
    L15:
        r12 = r12 + 1;
        r1 = r19;
        r11 = r11;
        goto L10
    L16:
        int r22 = r13;
        int r23 = 0;
    L18:
        if ((r22 + r4) < r3) goto L33;
        if (r23 >= 10) goto L33;
        r23 = r23 + 1;
        List r24 = r7[r23];
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r25 = r24.iterator();
    L22:
        if (r25.hasNext() == false) goto L28;
        Integer r111 = (Integer) r6.get((View) r25.next());
        if (r111 == null) goto L26;
        int r112 = r111.intValue();
    L27:
        r110.add(Integer.valueOf(r112));
        goto L22
    L26:
        r112 = 0;
        goto L27
    L28:
        int r26 = CollectionsKt.sumOfInt(r110);
        List r113 = r7[r23];
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L30:
        if (r115.hasNext() == false) goto L32;
        r114.add(Integer.valueOf(((View) r115.next()).getMinimumWidth()));
        goto L30
    L32:
        r22 = (r22 - r26) + CollectionsKt.sumOfInt(r114);
    L33:
        if (r23 <= 0) goto L59;
        int r27 = 0;
    L35:
        int r116 = -2;
        if (r27 >= r23) goto L46;
        Iterator r117 = r7[r27].iterator();
    L39:
        if (r117.hasNext() == false) goto L45;
        View r118 = (View) r117.next();
        if (r118.getLayoutParams().width != r116) goto L43;
        int r29 = LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L44:
        r118.measure(View.MeasureSpec.makeMeasureSpec(r118.getMinimumWidth(), r29), r20);
        r116 = -2;
        goto L39
    L43:
        r29 = 1073741824;
        goto L44
    L45:
        r27 = r27 + 1;
        goto L35
    L46:
        int r30 = (r3 - r4) - r22;
        List r31 = r7[r23];
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
        Iterator r33 = r31.iterator();
    L48:
        if (r33.hasNext() == false) goto L50;
        r32.add(Integer.valueOf(((View) r33.next()).getMeasuredWidth()));
        goto L48
    L50:
        float r34 = CollectionsKt.sumOfInt(r32);
        Iterator r35 = r7[r23].iterator();
    L52:
        if (r35.hasNext() == false) goto L59;
        View r36 = (View) r35.next();
        int r37 = (int) (r30 * (r36.getMeasuredWidth() / r34));
        if (r36.getLayoutParams().width != (-2)) goto L56;
        int r119 = LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L57:
        r36.measure(View.MeasureSpec.makeMeasureSpec(r36.getMinimumWidth() + r37, r119), r20);
        goto L52
    L56:
        r119 = 1073741824;
    L59:
        if (View.MeasureSpec.getMode(r19) != Integer.MIN_VALUE) goto L61;
        r3 = Math.min(r13 + r4, r3);
    L61:
        setMeasuredDimension(r3, r14 + r5);
        return;
    L63:
        super.onMeasure(r19, r20);
    }

    public PriorityLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ PriorityLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = getChildCount();
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L20;
        View r0 = getChildAt(r13);
        if (r0.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        int r3 = (r2.leftMargin + r14) + getPaddingLeft();
        int r4 = r2.gravity & 112;
        if (r4 != 16) goto L9;
        int r5 = ((((((getPaddingTop() + r9) + r2.topMargin) + r11) - getPaddingBottom()) - r2.bottomMargin) - r0.getMeasuredHeight()) / 2;
    L17:
        int r6 = r5 - r9;
    L18:
        r0.layout(r3, r6, r0.getMeasuredWidth() + r3, r0.getMeasuredHeight() + r6);
        r14 = r14 + ((r0.getMeasuredWidth() + r2.leftMargin) + r2.rightMargin);
        goto L19
    L9:
        if (r4 != 48) goto L11;
        int r15 = r2.topMargin;
        int r16 = getPaddingTop();
    L15:
        r6 = r15 + r16;
        goto L18
    L11:
        if (r4 == 80) goto L13;
        r15 = r2.topMargin;
        r16 = getPaddingTop();
        goto L15
    L13:
        r5 = ((r11 - r2.bottomMargin) - getPaddingBottom()) - r0.getMeasuredHeight();
    L19:
        r13 = r13 + 1;
        goto L3
    }
}
