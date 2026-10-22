package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J0\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/MessageBubbleBodyContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRtl", BuildConfig.FLAVOR, "()Z", "setRtl", "(Z)V", "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "generateLayoutParams", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageBubbleBodyContainer extends ViewGroup {
    public boolean a;

    public MessageBubbleBodyContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MessageBubbleBodyContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (r3 != null) goto L6;
        return generateDefaultLayoutParams();
    L6:
        return new ViewGroup.MarginLayoutParams(r3.width, r3.height);
    }

    public final void setRtl(boolean r1) {
        this.a = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r13, int r14) {
        if (getChildCount() != 5) goto L10;
        int r6 = View.MeasureSpec.getSize(r13);
        int r0 = View.MeasureSpec.getMode(r13);
        int r1 = View.MeasureSpec.getSize(r14);
        if (r0 != Integer.MIN_VALUE) goto L7;
        setMeasuredDimension(r6, r1);
        return;
    L7:
        View r8 = getChildAt(2);
        measureChildWithMargins(r8, r13, 0, r14, 0);
        View r9 = getChildAt(1);
        measureChildWithMargins(r9, r13, 0, r14, 0);
        int r7 = Math.max(r8.getMeasuredWidth(), r9.getMeasuredWidth());
        View r10 = getChildAt(0);
        measureChildWithMargins(r10, r13, r7, r14, 0);
        int r11 = r7 + r10.getMeasuredWidth();
        int r12 = Math.max(r9.getMeasuredHeight() + r8.getMeasuredHeight(), r10.getMeasuredHeight());
        getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(r10.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r10.getMeasuredHeight(), 1073741824));
        measureChildWithMargins(getChildAt(4), r13, r7, r14, 0);
        setMeasuredDimension(Math.max(r11, r6), r12);
        return;
    L10:
        throw new IllegalStateException("There are must 5 child.");
    }

    public MessageBubbleBodyContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ MessageBubbleBodyContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        View r8 = getChildAt(0);
        if (this.a == false) goto L5;
        r8.layout(getMeasuredWidth() - r8.getMeasuredWidth(), 0, getMeasuredWidth(), r8.getMeasuredHeight());
    L6:
        View r9 = getChildAt(1);
        if (r9.getVisibility() != 8) goto L9;
    L12:
        View r10 = getChildAt(2);
        if (this.a == false) goto L15;
        r10.layout((getMeasuredWidth() - r8.getMeasuredWidth()) - r10.getMeasuredWidth(), 0, getMeasuredWidth() - r8.getMeasuredWidth(), r10.getMeasuredHeight());
    L16:
        View r11 = getChildAt(3);
        if (this.a == false) goto L19;
        r11.layout(getMeasuredWidth() - r11.getMeasuredWidth(), 0, getMeasuredWidth(), r11.getMeasuredHeight());
    L20:
        View r12 = getChildAt(4);
        r12.layout(r8.getLeft(), r8.getTop(), r8.getLeft() + r12.getMeasuredWidth(), r8.getTop() + r12.getMeasuredHeight());
        return;
    L19:
        r11.layout(0, 0, r11.getMeasuredWidth(), r11.getMeasuredHeight());
        goto L20
    L15:
        r10.layout(r8.getMeasuredWidth(), 0, r8.getMeasuredWidth() + r10.getMeasuredWidth(), r10.getMeasuredHeight());
        goto L16
    L9:
        if (this.a == false) goto L11;
        r9.layout((getMeasuredWidth() - r8.getMeasuredWidth()) - r9.getMeasuredWidth(), getMeasuredHeight() - r9.getMeasuredHeight(), getMeasuredWidth() - r8.getMeasuredWidth(), getMeasuredHeight());
        goto L12
    L11:
        r9.layout(r8.getMeasuredWidth(), getMeasuredHeight() - r9.getMeasuredHeight(), r8.getMeasuredWidth() + r9.getMeasuredWidth(), getMeasuredHeight());
        goto L12
    L5:
        r8.layout(0, 0, r8.getMeasuredWidth(), r8.getMeasuredHeight());
        goto L6
    }
}
