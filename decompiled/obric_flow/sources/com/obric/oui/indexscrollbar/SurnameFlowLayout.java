package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SurnameFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f13423b;

    public SurnameFlowLayout(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f13422a = new ArrayList();
        this.f13423b = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        Intrinsics.checkNotNullParameter(r5, LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        return new ViewGroup.MarginLayoutParams(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        ArrayList r5 = this.f13422a;
        r5.clear();
        ArrayList r10 = this.f13423b;
        r10.clear();
        int r11 = getWidth();
        ArrayList r12 = new ArrayList();
        int r13 = getChildCount();
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14 >= r13) goto L13;
        int r17 = r14 + 1;
        View r23 = getChildAt(r14);
        ViewGroup.LayoutParams r110 = r23.getLayoutParams();
        if (r110 == null) goto L12;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        int r112 = r23.getMeasuredWidth();
        int r113 = r23.getMeasuredHeight();
        if ((((r111.leftMargin + r112) + r111.rightMargin) + r16) <= r11) goto L10;
        r10.add(Integer.valueOf(r15));
        r5.add(r12);
        r12 = new ArrayList();
        r16 = 0;
    L10:
        r16 = r16 + ((r112 + r111.leftMargin) + r111.rightMargin);
        r15 = (int) Math.max(r15, (r113 + r111.topMargin) + r111.bottomMargin);
        r12.add(r23);
        r14 = r17;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        r10.add(Integer.valueOf(r15));
        r5.add(r12);
        int r24 = r5.size();
        int r25 = 0;
        int r26 = 0;
    L14:
        if (r25 >= r24) goto L26;
        int r27 = r25 + 1;
        List r28 = (List) r5.get(r25);
        int r29 = ((Number) r10.get(r25)).intValue();
        int r30 = r28.size();
        int r31 = 0;
        int r114 = 0;
    L16:
        if (r31 >= r30) goto L25;
        r31 = r31 + 1;
        View r32 = (View) r28.get(r31);
        if (r32.getVisibility() == 8) goto L16;
        ViewGroup.LayoutParams r115 = r32.getLayoutParams();
        if (r115 == null) goto L24;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        int r117 = r116.leftMargin + r114;
        int r118 = r116.topMargin + r26;
        int r33 = r32.getMeasuredWidth() + r117;
        int r119 = r24;
        int r34 = r32.getMeasuredHeight() + r118;
        ArrayList r120 = r5;
        StringBuilder r35 = new StringBuilder();
        r35.append(r32.toString());
        r35.append(" , l = ");
        r35.append(r117);
        r35.append(" , t = ");
        a.C(r35, r20, " , r =", r33, " , b = ");
        r35.append(r34);
        Log.e("FlowLayout", r35.toString());
        r32.layout(r117, r118, r33, r34);
        r114 = r114 + ((r32.getMeasuredWidth() + r116.rightMargin) + r116.leftMargin);
        r24 = r119;
        r10 = r10;
        r27 = r27;
        r28 = r28;
        r5 = r120;
        goto L16
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        r26 = r26 + r29;
        r25 = r27;
        goto L14
    }

    @Override // android.view.View
    public final void onMeasure(int r19, int r20) {
        super.onMeasure(r19, r20);
        int r5 = View.MeasureSpec.getSize(r19);
        int r10 = View.MeasureSpec.getSize(r20);
        int r11 = View.MeasureSpec.getMode(r19);
        int r12 = View.MeasureSpec.getMode(r20);
        StringBuilder r13 = new StringBuilder();
        r13.append(r5);
        r13.append(',');
        r13.append(r10);
        Log.e("FlowLayout", r13.toString());
        int r14 = getChildCount();
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r110 = 0;
    L3:
        if (r15 >= r14) goto L16;
        int r111 = r15 + 1;
        View r112 = getChildAt(r15);
        measureChild(r112, r19, r20);
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L15;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        int r115 = r10;
        int r21 = (r112.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
        int r116 = r16;
        int r117 = (r112.getMeasuredHeight() + r114.topMargin) + r114.bottomMargin;
        int r22 = r17 + r21;
        if (r22 <= r5) goto L9;
        r16 = (int) Math.max(r17, r21);
        r110 = r110 + r18;
        r17 = r21;
        r18 = r117;
    L11:
        if (r15 != (r14 - 1)) goto L13;
        r16 = (int) Math.max(r16, r17);
        r110 = r110 + r18;
    L13:
        r15 = r111;
        r10 = r115;
        goto L3
    L9:
        r18 = (int) Math.max(r18, r117);
        r17 = r22;
        r16 = r116;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        int r118 = r10;
        int r119 = r16;
        if (r11 == 1073741824) goto L20;
        r5 = r119;
    L20:
        if (r12 != 1073741824) goto L22;
        int r23 = r118;
    L23:
        setMeasuredDimension(r5, r23);
        return;
    L22:
        r23 = r110;
        goto L23
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r5, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r5);
    }
}
