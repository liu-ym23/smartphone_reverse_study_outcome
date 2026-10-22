package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SurnameFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<List<View>> f6769c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<Integer> f6770g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public SurnameFlowLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f6769c = new ArrayList();
        this.f6770g = new ArrayList();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r10, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        Intrinsics.checkNotNullParameter(r10, "p");
        return new ViewGroup.MarginLayoutParams(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        SurnameFlowLayout r10 = this;
        r10.f6769c.clear();
        r10.f6770g.clear();
        int r11 = getWidth();
        ArrayList r12 = new ArrayList();
        int r13 = getChildCount();
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14 >= r13) goto L9;
        View r17 = r10.getChildAt(r14);
        Intrinsics.checkNotNullExpressionValue(r17, "child");
        ViewGroup.LayoutParams r110 = r17.getLayoutParams();
        Objects.requireNonNull(r110, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        int r23 = r17.getMeasuredWidth();
        int r112 = r17.getMeasuredHeight();
        if ((((r111.leftMargin + r23) + r111.rightMargin) + r16) <= r11) goto L8;
        r10.f6770g.add(Integer.valueOf(r15));
        r10.f6769c.add(r12);
        r12 = new ArrayList();
        r16 = 0;
    L8:
        r16 = r16 + ((r23 + r111.leftMargin) + r111.rightMargin);
        r15 = (int) Math.max(r15, (r112 + r111.topMargin) + r111.bottomMargin);
        r12.add(r17);
        r14 = r14 + 1;
        goto L4
    L9:
        r10.f6770g.add(Integer.valueOf(r15));
        r10.f6769c.add(r12);
        int r24 = r10.f6769c.size();
        int r25 = 0;
        int r26 = 0;
    L10:
        if (r25 >= r24) goto L19;
        List<View> r27 = r10.f6769c.get(r25);
        int r28 = r10.f6770g.get(r25).intValue();
        int r29 = r27.size();
        int r30 = 0;
        int r113 = 0;
    L12:
        if (r30 >= r29) goto L18;
        View r114 = r27.get(r30);
        if (r114.getVisibility() == 8) goto L17;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        Objects.requireNonNull(r115, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        int r117 = r116.leftMargin + r113;
        int r118 = r116.topMargin + r26;
        int r119 = r114.getMeasuredWidth() + r117;
        int r31 = r118 + r114.getMeasuredHeight();
        Log.e("FlowLayout", r114.toString() + " , l = " + r117 + " , t = " + r20 + " , r =" + r119 + " , b = " + r31);
        r114.layout(r117, r118, r119, r31);
        r113 = r113 + ((r114.getMeasuredWidth() + r116.rightMargin) + r116.leftMargin);
    L17:
        r30 = r30 + 1;
        r24 = r24;
        goto L12
    L18:
        r26 = r26 + r28;
        r25 = r25 + 1;
        r10 = this;
        goto L10
    }

    @Override // android.view.View
    protected void onMeasure(int r18, int r19) {
        super.onMeasure(r18, r19);
        int r10 = View.MeasureSpec.getSize(r18);
        int r11 = View.MeasureSpec.getSize(r19);
        int r12 = View.MeasureSpec.getMode(r18);
        int r13 = View.MeasureSpec.getMode(r19);
        StringBuilder r14 = new StringBuilder();
        r14.append(r10);
        r14.append(',');
        r14.append(r11);
        Log.e("FlowLayout", r14.toString());
        int r15 = getChildCount();
        int r16 = 0;
        int r17 = 0;
        int r20 = 0;
        int r21 = 0;
        int r110 = 0;
    L3:
        if (r16 >= r15) goto L12;
        View r111 = getChildAt(r16);
        measureChild(r111, r18, r19);
        Intrinsics.checkNotNullExpressionValue(r111, "child");
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        Objects.requireNonNull(r112, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r114 = r11;
        int r115 = (r111.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
        int r22 = (r111.getMeasuredHeight() + r113.topMargin) + r113.bottomMargin;
        int r116 = r20 + r115;
        if (r116 <= r10) goto L7;
        r17 = (int) Math.max(r20, r115);
        r110 = r110 + r21;
        r21 = r22;
        r20 = r115;
    L9:
        if (r16 != (r15 - 1)) goto L11;
        r110 = r110 + r21;
        r17 = (int) Math.max(r17, r20);
    L11:
        r16 = r16 + 1;
        r11 = r114;
        goto L3
    L7:
        r21 = (int) Math.max(r21, r22);
        r20 = r116;
        goto L9
    L12:
        int r117 = r11;
        if (r12 == 1073741824) goto L16;
        r10 = r17;
    L16:
        if (r13 != 1073741824) goto L18;
        int r23 = r117;
    L19:
        setMeasuredDimension(r10, r23);
        return;
    L18:
        r23 = r110;
        goto L19
    }
}
