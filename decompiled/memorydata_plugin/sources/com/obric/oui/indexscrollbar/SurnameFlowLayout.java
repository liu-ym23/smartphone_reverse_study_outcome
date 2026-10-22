package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0014J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0014R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAllViews", "", "Landroid/view/View;", "mLineHeight", "", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "p", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SurnameFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<List<View>> f13910b;
    private final List<Integer> c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13909a = new a(null);
    }

    public SurnameFlowLayout(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.f13910b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        SurnameFlowLayout r0 = this;
        r0.f13910b.clear();
        r0.c.clear();
        int r1 = getWidth();
        String r4 = "com.obric.memorydata.plugin";
        List<View> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r3 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L4:
        if (r6 >= r3) goto L9;
        int r10 = r6 + 1;
        View r9 = r0.getChildAt(r6);
        ViewGroup.LayoutParams r11 = r9.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r13 = r9.getMeasuredWidth();
        int r14 = r9.getMeasuredHeight();
        if ((((r12.leftMargin + r13) + r12.rightMargin) + r8) <= r1) goto L8;
        r0.c.add(Integer.valueOf(r7));
        r0.f13910b.add(r2);
        r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r8 = 0;
    L8:
        r8 = r8 + ((r13 + r12.leftMargin) + r12.rightMargin);
        r7 = (int) Math.max(r7, (r14 + r12.topMargin) + r12.bottomMargin);
        Intrinsics.checkNotNullExpressionValue(r9, "child");
        r2.add(r9);
        r6 = r10;
        goto L4
    L9:
        r0.c.add(Integer.valueOf(r7));
        r0.f13910b.add(r2);
        int r5 = r0.f13910b.size();
        int r15 = 0;
        int r16 = 0;
    L10:
        if (r15 >= r5) goto L18;
        int r17 = r15 + 1;
        List r23 = (List) ZeusTransformUtils.preCheckCast(r0.f13910b.get(r15), List.class, r4);
        int r24 = ((Number) ZeusTransformUtils.preCheckCast(r0.c.get(r15), Number.class, r4)).intValue();
        int r25 = r23.size();
        int r110 = 0;
        int r111 = 0;
    L12:
        if (r110 >= r25) goto L17;
        int r112 = r110 + 1;
        View r113 = (View) ZeusTransformUtils.preCheckCast(r23.get(r110), View.class, r4);
        if (r113.getVisibility() == 8) goto L15;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        Objects.requireNonNull(r114, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r114, ViewGroup.MarginLayoutParams.class, r4);
        int r116 = r115.leftMargin + r111;
        int r117 = r115.topMargin + r16;
        int r26 = r116 + r113.getMeasuredWidth();
        int r27 = r117 + r113.getMeasuredHeight();
        Log.e("FlowLayout", r113.toString() + " , l = " + r116 + " , t = " + r20 + " , r =" + r26 + " , b = " + r27);
        r113.layout(r116, r117, r26, r27);
        r111 = r111 + ((r113.getMeasuredWidth() + r115.rightMargin) + r115.leftMargin);
        r5 = r5;
        r4 = r4;
    L15:
        r110 = r112;
        goto L12
    L17:
        r16 = r16 + r24;
        r0 = this;
        r15 = r17;
        goto L10
    }

    @Override // android.view.View
    public void onMeasure(int r19, int r20) {
        super.onMeasure(r19, r20);
        int r1 = View.MeasureSpec.getSize(r19);
        int r2 = View.MeasureSpec.getSize(r20);
        int r3 = View.MeasureSpec.getMode(r19);
        int r4 = View.MeasureSpec.getMode(r20);
        Log.e("FlowLayout", new StringBuilder().append(r1).append(',').append(r2).toString());
        int r5 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r6 >= r5) goto L12;
        int r11 = r6 + 1;
        View r12 = getChildAt(r6);
        measureChild(r12, r19, r20);
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        int r16 = r2;
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r17 = r7;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = (r12.getMeasuredWidth() + r13.leftMargin) + r13.rightMargin;
        int r18 = (r12.getMeasuredHeight() + r13.topMargin) + r13.bottomMargin;
        int r21 = r8 + r14;
        int r110 = r1;
        if (r21 <= r1) goto L7;
        int r22 = (int) Math.max(r8, r14);
        r10 = r10 + r9;
        r8 = r14;
        r9 = r18;
        r7 = r22;
    L9:
        if (r6 != (r5 - 1)) goto L11;
        r7 = (int) Math.max(r7, r8);
        r10 = r10 + r9;
    L11:
        r6 = r11;
        r1 = r110;
        r2 = r16;
        goto L3
    L7:
        r9 = (int) Math.max(r9, r18);
        r8 = r21;
        r7 = r17;
        goto L9
    L12:
        int r111 = r1;
        int r112 = r2;
        int r113 = r7;
        if (r3 == 1073741824) goto L16;
        r111 = r113;
    L16:
        if (r4 != 1073741824) goto L18;
        int r23 = r112;
    L19:
        setMeasuredDimension(r111, r23);
        return;
    L18:
        r23 = r10;
        goto L19
    }
}
