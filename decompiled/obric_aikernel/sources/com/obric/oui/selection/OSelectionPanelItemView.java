package com.obric.oui.selection;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.d;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0014R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\f\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u00060"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "", "addAccessibilityCompat", "", "showDivider", "setDividerMode", "dismissDivider", "select", "unSelect", "show", "showSelectLabel", "isMultiSelect", "setSelectMode", "Landroid/widget/ImageView;", "getIconView", "Lcom/obric/oui/text/OTextView;", "getTextView", "Lcom/obric/oui/radio/ORadio;", "getRadioView", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "Z", "()Z", "setMultiSelect", "(Z)V", "checkbox", "Lcom/obric/oui/checkbox/OCheckBox;", EventBody.KEY_VALUE, "isItemSelected", "setItemSelected", "Landroid/view/View;", "divider", "Landroid/view/View;", "getShowDivider", "setShowDivider", "ivIcon", "Landroid/widget/ImageView;", "tvText", "Lcom/obric/oui/text/OTextView;", "radio", "Lcom/obric/oui/radio/ORadio;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ZZ)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSelectionPanelItemView extends OUIConstraintLayout {
    private final OCheckBox checkbox;
    private final View divider;
    private boolean isMultiSelect;
    private final ImageView ivIcon;
    private final ORadio radio;
    private boolean showDivider;
    private boolean showSelectLabel;
    private final OTextView tvText;

    @JvmOverloads
    public OSelectionPanelItemView(Context r10) {
        this(r10, null, false, false, 14, null);
    }

    @JvmOverloads
    public OSelectionPanelItemView(Context r10, AttributeSet r11) {
        this(r10, r11, false, false, 12, null);
    }

    @JvmOverloads
    public OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12) {
        this(r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, 0, null, 12, null);
        this.isMultiSelect = r12;
        this.showDivider = r13;
        this.showSelectLabel = true;
        ViewGroup.inflate(r10, h.o_view_selection_item, this);
        setMinHeight((int) getResources().getDimension(d.oui_h_l2));
        View r14 = findViewById(f.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) r14;
        View r15 = findViewById(f.tv_text);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.tv_text)");
        this.tvText = (OTextView) r15;
        View r16 = findViewById(f.radio);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.radio)");
        this.radio = (ORadio) r16;
        View r17 = findViewById(f.checkbox);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.checkbox)");
        OCheckBox r18 = (OCheckBox) r17;
        this.checkbox = r18;
        View r19 = findViewById(f.divider);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.divider)");
        this.divider = r19;
        r18.setClickable(false);
        setRadius((int) getResources().getDimension(d.oui_r_l3_rect));
        setSelectMode(this.isMultiSelect);
        setDividerMode(this.showDivider);
        Resources r20 = getResources();
        int r110 = d.oui_p_list_item_2;
        setPadding(r20.getDimensionPixelSize(r110), getPaddingTop(), getResources().getDimensionPixelSize(r110), getPaddingBottom());
        addAccessibilityCompat();
    }

    public /* synthetic */ OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = false;
    L11:
        this(r10, r11, r12, r13);
    }

    private final void addAccessibilityCompat() {
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    private final void setDividerMode(boolean r10) {
        View r11 = this.divider;
        if (r10 == false) goto L5;
        k.h(r11);
        return;
    L5:
        k.f(r11);
    }

    public final void dismissDivider() {
        k.f(this.divider);
    }

    public final OCheckBox getCheckBox() {
        return this.checkbox;
    }

    public final ImageView getIconView() {
        return this.ivIcon;
    }

    public final ORadio getRadioView() {
        return this.radio;
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final OTextView getTextView() {
        return this.tvText;
    }

    public final boolean isItemSelected() {
        if (this.isMultiSelect == false) goto L6;
        return this.checkbox.isChecked();
    L6:
        return this.radio.isChecked();
    }

    public final boolean isMultiSelect() {
        return this.isMultiSelect;
    }

    public final void select() {
        setItemSelected(true);
    }

    public final void setItemSelected(boolean r10) {
        if (this.isMultiSelect == false) goto L5;
        this.checkbox.setChecked(r10);
    L7:
        if (this.showSelectLabel == true) goto L10;
        k.g(this.radio);
        return;
    L10:
        return;
    L5:
        this.radio.setChecked(r10);
        goto L7
    }

    public final void setMultiSelect(boolean r10) {
        this.isMultiSelect = r10;
    }

    public final void setSelectMode(boolean r10) {
        this.isMultiSelect = r10;
        if (r10 == false) goto L5;
        k.h(this.checkbox);
        k.f(this.radio);
    L6:
        setItemSelected(isItemSelected());
        return;
    L5:
        k.f(this.checkbox);
        k.h(this.radio);
        goto L6
    }

    public final void setShowDivider(boolean r10) {
        this.showDivider = r10;
    }

    public final void showSelectLabel(boolean r10) {
        this.showSelectLabel = r10;
        if (r10 == false) goto L5;
        setSelectMode(this.isMultiSelect);
        return;
    L5:
        k.f(this.checkbox);
        k.f(this.radio);
    }

    public final void unSelect() {
        setItemSelected(false);
    }
}
