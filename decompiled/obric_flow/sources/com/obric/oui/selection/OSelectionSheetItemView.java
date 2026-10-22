package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$drawable;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OListItemGeneral;
import ds.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheetItemView;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getCheckMark", "()Landroid/view/View;", "Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;", "style", "", "setCheckStyle", "(Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;)V", "", "str", "setTitle", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "checked", "setChecked", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionSheetItemView extends OListItemGeneral {
    public OSelectionSheetItemView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setCheckStyle(OSelectionSheetItemView$Companion$CheckStyle.NONE);
        setShowDivider(true);
        setShowBackground(false);
        setBackground(null);
    }

    private final View getCheckMark() {
        View r5 = getMTrailingElement().getChildAt(0);
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

    public final void setCheckStyle(OSelectionSheetItemView$Companion$CheckStyle r5) {
        Intrinsics.checkNotNullParameter(r5, "style");
        int r10 = c.f16710a[r5.ordinal()];
        ImageView r11 = null;
        if (r10 != 1) goto L5;
        ImageView r12 = new ImageView(getContext());
        r12.setImageDrawable(ResourcesCompat.getDrawable(r12.getContext().getResources(), R$drawable.o_ic_radio_tick_checked, null));
        r11 = r12;
    L13:
        if (r11 == null) goto L15;
        FrameLayout r13 = new FrameLayout(getContext());
        r13.setLayoutParams(new FrameLayout.LayoutParams(a.B(32, r13), a.B(24, r13)));
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 17;
        r13.addView(r11, r14);
        setTrailingView(r13);
        return;
    L15:
        getMTrailingElement().setVisibility(8);
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
        ps.a.a("OSelectionSheetItemView", "checkMark is not OCheckBox or ImageView");
    }

    public final void setIcon(Drawable r5) {
        setContentImage(r5);
    }

    public final void setTitle(String r5) {
        Intrinsics.checkNotNullParameter(r5, "str");
        setTitleString(r5);
    }
}
