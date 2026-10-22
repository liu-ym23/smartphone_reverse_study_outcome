package com.suite.lark.platform.component.cta.newstyle.widgets;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014J0\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/widgets/CustomButtonGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horizontalSpacing", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "isTextTruncated", "view", "Landroid/view/View;", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CustomButtonGroup extends FrameLayout {
    public final int a;

    public CustomButtonGroup(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomButtonGroup(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static boolean a(View r2) {
        if ((r2 instanceof TextView) == false) goto L9;
        Layout r3 = ((TextView) r2).getLayout();
        if (r3 == null) goto L9;
        if (r3.getEllipsisCount(r3.getLineCount() - 1) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r16, int r17) {
        int r7 = View.MeasureSpec.getMode(r16);
        int r8 = View.MeasureSpec.getSize(r16);
        int r9 = View.MeasureSpec.getMode(r17);
        int r10 = View.MeasureSpec.getSize(r17);
        int r0 = getChildCount();
        int r1 = 0;
        if (r0 != 0) goto L6;
        setMeasuredDimension(0, 0);
        return;
    L6:
        boolean r3 = true;
        if (r0 != 1) goto L9;
        View r12 = getChildAt(0);
        measureChildWithMargins(r12, r16, 0, r17, 0);
        int r4 = r12.getMeasuredWidth();
        int r5 = r12.getMeasuredHeight();
    L28:
        if (r7 == 1073741824) goto L31;
        r8 = r4;
    L31:
        if (r9 == 1073741824) goto L34;
        r10 = r5;
    L34:
        setMeasuredDimension(r8, r10);
        return;
    L9:
        if (r0 == 2) goto L16;
        r4 = 0;
        r5 = 0;
    L11:
        if (r1 >= r0) goto L28;
        View r13 = getChildAt(r1);
        measureChild(r13, r16, r17);
        r4 = Math.max(r4, r13.getMeasuredWidth());
        r5 = r5 + r13.getMeasuredHeight();
        if (r1 >= (r0 - 1)) goto L15;
        r5 = r5 + this.a;
    L15:
        r1 = r1 + 1;
        goto L11
    L16:
        View r2 = getChildAt(0);
        View r14 = getChildAt(1);
        measureChild(r2, View.MeasureSpec.makeMeasureSpec(r8, Target.SIZE_ORIGINAL), r17);
        measureChild(r14, View.MeasureSpec.makeMeasureSpec(r8, Target.SIZE_ORIGINAL), r17);
        if (((r2.getMeasuredWidth() + r14.getMeasuredWidth()) + this.a) > r8) goto L23;
        Intrinsics.checkNotNull(r2);
        if (a(r2) == true) goto L23;
        Intrinsics.checkNotNull(r14);
        if (a(r14) == true) goto L23;
    L24:
        if (r3 == false) goto L26;
        int r6 = View.MeasureSpec.makeMeasureSpec((r8 - this.a) / 2, 1073741824);
        int r11 = View.MeasureSpec.makeMeasureSpec(0, 0);
        measureChild(r2, r6, r11);
        measureChild(r14, r6, r11);
        r5 = Math.max(r2.getMeasuredHeight(), r14.getMeasuredHeight());
        r4 = r8;
        goto L28
    L26:
        measureChild(r2, r16, r17);
        measureChild(r14, r16, r17);
        r4 = Math.max(r2.getMeasuredWidth(), r14.getMeasuredWidth());
        r5 = (r2.getMeasuredHeight() + this.a) + r14.getMeasuredHeight();
    L23:
        r3 = false;
        goto L24
    }

    public CustomButtonGroup(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = UIUtils.dp2px(r2, 10.0f);
    }

    public /* synthetic */ CustomButtonGroup(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        if (r9 != 0) goto L5;
        return;
    L5:
        boolean r10 = true;
        if (r9 != 1) goto L8;
        View r11 = getChildAt(0);
        r11.layout(0, 0, r11.getMeasuredWidth(), r11.getMeasuredHeight());
        return;
    L8:
        if (r9 == 2) goto L12;
        int r12 = 0;
        int r13 = 0;
    L10:
        if (r12 >= r9) goto L28;
        View r14 = getChildAt(r12);
        int r0 = r14.getMeasuredHeight();
        r14.layout(0, r13, getWidth(), r13 + r0);
        r13 = r13 + (r0 + this.a);
        r12 = r12 + 1;
        goto L10
    L28:
        return;
    L12:
        View r15 = getChildAt(0);
        View r16 = getChildAt(1);
        int r1 = getWidth();
        if (((r15.getMeasuredWidth() + r16.getMeasuredWidth()) + this.a) > r1) goto L19;
        Intrinsics.checkNotNull(r15);
        if (a(r15) == true) goto L19;
        Intrinsics.checkNotNull(r16);
        if (a(r16) == true) goto L19;
    L20:
        if (r10 == false) goto L22;
        int r17 = (r1 - this.a) / 2;
        int r18 = Math.max(r15.getMeasuredHeight(), r16.getMeasuredHeight());
        r15.layout(0, 0, r17, r18);
        r16.layout(r17 + this.a, 0, r1, r18);
        return;
    L22:
        int r19 = r15.getMeasuredHeight();
        r15.layout(0, 0, r1, r19);
        int r20 = r19 + this.a;
        r16.layout(0, r20, r1, r16.getMeasuredHeight() + r20);
        return;
    L19:
        r10 = false;
        goto L20
    }
}
