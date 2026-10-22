package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J0\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0014¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/MessageBubbleOptimizationLayout;", "Lcom/ss/android/lark/chatwindow/view/widget/MeasureDetectLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", BuildConfig.FLAVOR, "heightMeasureSpec", "onLayout", "changed", BuildConfig.FLAVOR, "left", "top", "right", "bottom", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageBubbleOptimizationLayout extends MeasureDetectLinearLayout {
    public MessageBubbleOptimizationLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // com.ss.android.lark.chatwindow.view.widget.MeasureDetectLinearLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r12, int r13) {
        if (getChildCount() != 4) goto L15;
        int r6 = View.MeasureSpec.getSize(r12);
        int r0 = View.MeasureSpec.getMode(r12);
        int r1 = View.MeasureSpec.getSize(r13);
        View.MeasureSpec.getMode(r13);
        if (r0 != Integer.MIN_VALUE) goto L7;
        setMeasuredDimension(r6, r1);
    L12:
        set_measureTimes(get_measureTimes() + 1);
        return;
    L7:
        measureChildWithMargins(getChildAt(2), r12, 0, r13, 0);
        View r8 = getChildAt(1);
        if (r8.getVisibility() == 8) goto L10;
        measureChildWithMargins(r8, r12, 0, r13, 0);
        int r2 = r8.getMeasuredWidth() + 0;
        int r3 = r8.getMeasuredHeight() + 0;
        int r9 = r2;
        int r10 = r3;
    L11:
        View r11 = getChildAt(0);
        measureChildWithMargins(r11, r12, r9, r13, r10);
        int r14 = r9 + r11.getMeasuredWidth();
        int r4 = Math.max(r10, r11.getMeasuredHeight());
        getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(r11.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r11.getMeasuredHeight(), 1073741824));
        setMeasuredDimension(Math.max(r14, r6), r4);
        goto L12
    L10:
        r9 = 0;
        r10 = 0;
        goto L11
    L15:
        throw new IllegalStateException("MessageBubbleOptimizationLinearLayout can hold at most 4 children");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        View r8 = getChildAt(0);
        r8.layout(0, 0, r8.getMeasuredWidth(), r8.getMeasuredHeight());
        View r9 = getChildAt(1);
        if (r9.getVisibility() == 8) goto L5;
        r9.layout(r8.getMeasuredWidth(), getMeasuredHeight() - r9.getMeasuredHeight(), r8.getMeasuredWidth() + r9.getMeasuredWidth(), getMeasuredHeight());
    L5:
        View r10 = getChildAt(2);
        r10.layout(r8.getMeasuredWidth(), 0, r8.getMeasuredWidth() + r10.getMeasuredWidth(), r10.getMeasuredHeight());
        View r11 = getChildAt(3);
        r11.layout(0, 0, r11.getMeasuredWidth(), r11.getMeasuredHeight());
    }
}
