package com.ss.android.lark.flow.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J0\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/flow/chat/view/FlowBubbleMainContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "isRtl", "()Z", "setRtl", "(Z)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowBubbleMainContainer extends ViewGroup {
    public boolean a;

    public FlowBubbleMainContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowBubbleMainContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setRtl(boolean r1) {
        this.a = r1;
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        if (getChildCount() == 2) goto L5;
        return;
    L5:
        boolean r0 = false;
        View r1 = getChildAt(0);
        View r3 = getChildAt(1);
        int r4 = View.MeasureSpec.getSize(r8);
        if (r1.getLayoutParams().width == (-1)) goto L9;
        r8 = View.MeasureSpec.makeMeasureSpec(r4, Target.SIZE_ORIGINAL);
    L9:
        measureChild(r1, r8, r9);
        Intrinsics.checkNotNull(r3);
        if (r3.getVisibility() != 0) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L14;
        measureChild(r3, View.MeasureSpec.makeMeasureSpec(r1.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r1.getMeasuredHeight(), 1073741824));
    L14:
        setMeasuredDimension(r4, r1.getMeasuredHeight());
    }

    public FlowBubbleMainContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ FlowBubbleMainContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        if (getChildCount() == 2) goto L5;
        return;
    L5:
        View r8 = getChildAt(0);
        boolean r9 = true;
        View r10 = getChildAt(1);
        if (this.a == false) goto L8;
        int r11 = getMeasuredWidth() - r8.getMeasuredWidth();
    L9:
        r8.layout(r11, 0, r8.getMeasuredWidth() + r11, r8.getMeasuredHeight());
        Intrinsics.checkNotNull(r10);
        if (r10.getVisibility() == 0) goto L13;
        r9 = false;
    L13:
        if (r9 == false) goto L16;
        r10.layout(r11, 0, r10.getMeasuredWidth() + r11, r10.getMeasuredHeight());
        return;
    L16:
        return;
    L8:
        r11 = 0;
        goto L9
    }
}
