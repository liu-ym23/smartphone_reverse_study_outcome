package com.obric.oui.dialog.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/base/DialogRootView;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogRootView extends RadiusLayout {
    @JvmOverloads
    public DialogRootView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = (int) (((double) com.lynx.tasm.utils.a.w(getContext())) * 0.9d);
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = View.MeasureSpec.getMode(r10);
        if (r13 == Integer.MIN_VALUE) goto L7;
        if (r13 == 0) goto L6;
        int r14 = View.MeasureSpec.makeMeasureSpec(Math.min(r12, r11), BasicMeasure.EXACTLY);
    L9:
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L11;
        r5 = View.MeasureSpec.makeMeasureSpec(com.lynx.tasm.utils.a.x(getContext()), BasicMeasure.EXACTLY);
    L11:
        super.onMeasure(r5, r14);
        return;
    L6:
        r14 = View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
        goto L9
    L7:
        r14 = View.MeasureSpec.makeMeasureSpec(Math.min(r12, r11), Integer.MIN_VALUE);
        goto L9
    }

    @JvmOverloads
    public DialogRootView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ DialogRootView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public DialogRootView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
    }
}
