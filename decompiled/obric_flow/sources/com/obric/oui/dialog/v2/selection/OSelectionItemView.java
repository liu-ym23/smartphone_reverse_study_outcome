package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.lynx.tasm.ui.image.h;
import com.obric.common.oui.R$drawable;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getCheckMark", "()Landroid/view/View;", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "style", "", "setCheckStyle", "(Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;)V", "", "checked", "setChecked", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionItemView extends ODialogListItemView {
    public OSelectionItemView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setCheckStyle(OSelectionItemView$Companion$CheckStyle.NONE);
        getLeadingContainer().measure(0, 0);
        OneShotPreDrawListener.add(this, new h(this, this));
    }

    private final View getCheckMark() {
        View r5 = getTrailingContainer().getChildAt(0);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        ViewGroup r10 = (ViewGroup) r5;
        if (r10 != null) goto L11;
        return null;
    L11:
        return r10.getChildAt(0);
    L6:
        if ((r5 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    public final void setCheckStyle(OSelectionItemView$Companion$CheckStyle r5) {
        Intrinsics.checkNotNullParameter(r5, "style");
        int r10 = c.f13181a[r5.ordinal()];
        ImageView r11 = null;
        if (r10 != 1) goto L5;
        ImageView r12 = new ImageView(getContext());
        r12.setImageDrawable(ResourcesCompat.getDrawable(r12.getContext().getResources(), R$drawable.oui_select_list_item_checker, null));
        r11 = r12;
    L13:
        if (r11 == null) goto L15;
        FrameLayout r13 = new FrameLayout(getContext());
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 17;
        r13.addView(r11, r14);
        ViewGroup.LayoutParams r15 = new ViewGroup.LayoutParams(com.lynx.tasm.utils.a.B(32, this), -2);
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r15, "layoutParams");
        ODialogListItemView.o(getTrailingContainer(), r13, r15);
        return;
    L15:
        getTrailingContainer().setVisibility(8);
        return;
    L5:
        if (r10 != 2) goto L7;
        r11 = new OCheckBox(getContext());
        goto L13
    L7:
        if (r10 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public final void setChecked(boolean r5) {
        View r10 = getCheckMark();
        if ((r10 instanceof OCheckBox) == false) goto L6;
        ((OCheckBox) r10).setChecked(r5);
        return;
    L6:
        if ((r10 instanceof ImageView) == false) goto L12;
        ImageView r11 = (ImageView) r10;
        if (r5 == false) goto L10;
        int r12 = 0;
    L11:
        r11.setVisibility(r12);
        return;
    L10:
        r12 = 4;
        goto L11
    L12:
        ps.a.a("OSelectionItemView", "checkMark is not OCheckBox or ImageView");
    }
}
