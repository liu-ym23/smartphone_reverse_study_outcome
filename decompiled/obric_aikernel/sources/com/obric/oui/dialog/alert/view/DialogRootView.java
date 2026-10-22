package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.common.util.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogRootView;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogRootView extends RadiusLayout {
    @JvmOverloads
    public DialogRootView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public DialogRootView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public DialogRootView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ DialogRootView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        Context r12 = getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        int r13 = (int) (((double) f.d(r12)) * 0.9d);
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = View.MeasureSpec.getMode(r11);
        if (r15 == Integer.MIN_VALUE) goto L7;
        if (r15 == 0) goto L6;
        int r16 = View.MeasureSpec.makeMeasureSpec(Math.min(r14, r13), 1073741824);
    L9:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L11;
        Context r17 = getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        r10 = View.MeasureSpec.makeMeasureSpec(f.e(r17), 1073741824);
    L11:
        super.onMeasure(r10, r16);
        return;
    L6:
        r16 = View.MeasureSpec.makeMeasureSpec(r13, Integer.MIN_VALUE);
        goto L9
    L7:
        r16 = View.MeasureSpec.makeMeasureSpec(Math.min(r14, r13), Integer.MIN_VALUE);
        goto L9
    }
}
