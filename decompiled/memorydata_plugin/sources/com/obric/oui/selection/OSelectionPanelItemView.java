package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.o;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001eJ\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "isMultiSelect", "", "showDivider", "(Landroid/content/Context;Landroid/util/AttributeSet;ZZ)V", "checkbox", "Lcom/obric/oui/checkbox/OCheckBox;", "divider", "Landroid/view/View;", EventBody.KEY_VALUE, "isItemSelected", "()Z", "setItemSelected", "(Z)V", "setMultiSelect", "ivIcon", "Landroid/widget/ImageView;", "radio", "Lcom/obric/oui/radio/ORadio;", "getShowDivider", "setShowDivider", "showSelectLabel", "tvText", "Lcom/obric/oui/text/OTextView;", "addAccessibilityCompat", "", "dismissDivider", "getCheckBox", "getIconView", "getRadioView", "getTextView", "select", "setDividerMode", "setSelectMode", "show", "unSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelItemView extends OUIConstraintLayout {
    private final OCheckBox checkbox;
    private final View divider;
    private boolean isMultiSelect;
    private final ImageView ivIcon;
    private final ORadio radio;
    private boolean showDivider;
    private boolean showSelectLabel;
    private final OTextView tvText;

    public OSelectionPanelItemView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, false, false, 14, null);
    }

    public OSelectionPanelItemView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, false, false, 12, null);
    }

    public OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, false, 8, null);
    }

    public OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12, boolean r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r4, 0, null, 12, null);
        this.isMultiSelect = r12;
        this.showDivider = r13;
        this.showSelectLabel = true;
        ConstraintLayout.inflate(r14, ZeusTransformUtils.mapRes(R.layout.o_view_selection_item, "layout", "o_view_selection_item"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setMinHeight((int) ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_h_l2, "dimen", "oui_h_l2")));
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) ZeusTransformUtils.preCheckCast(r15, ImageView.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_text, OaidModel.KEY_ID, "tv_text"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.tv_text)");
        this.tvText = (OTextView) ZeusTransformUtils.preCheckCast(r16, OTextView.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.radio, OaidModel.KEY_ID, "radio"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.radio)");
        this.radio = (ORadio) ZeusTransformUtils.preCheckCast(r17, ORadio.class, "com.obric.memorydata.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.checkbox, OaidModel.KEY_ID, "checkbox"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.checkbox)");
        OCheckBox r19 = (OCheckBox) ZeusTransformUtils.preCheckCast(r18, OCheckBox.class, "com.obric.memorydata.plugin");
        this.checkbox = r19;
        View r110 = findViewById(ZeusTransformUtils.mapRes(R.id.divider, OaidModel.KEY_ID, "divider"));
        Intrinsics.checkNotNullExpressionValue(r110, "findViewById(R.id.divider)");
        this.divider = r110;
        r19.setClickable(false);
        setRadius((int) ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3_rect, "dimen", "oui_r_l3_rect")));
        setSelectMode(this.isMultiSelect);
        setDividerMode(this.showDivider);
        setPadding(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_list_item_2, "dimen", "oui_p_list_item_2")), getPaddingTop(), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_list_item_2, "dimen", "oui_p_list_item_2")), getPaddingBottom());
        addAccessibilityCompat();
    }

    public /* synthetic */ OSelectionPanelItemView(Context r2, AttributeSet r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r8, r9, r4, r5);
    }

    private final void addAccessibilityCompat() {
        ViewCompat.setAccessibilityDelegate((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin"));
    }

    private final void setDividerMode(boolean r1) {
        View r0 = this.divider;
        if (r1 == false) goto L5;
        o.a(r0);
        return;
    L5:
        o.b(r0);
    }

    public final void dismissDivider() {
        o.b(this.divider);
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

    public final void setItemSelected(boolean r2) {
        if (this.isMultiSelect == false) goto L5;
        this.checkbox.setChecked(r2);
    L7:
        if (this.showSelectLabel == true) goto L10;
        o.c((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        return;
    L5:
        this.radio.setChecked(r2);
        goto L7
    }

    public final void setMultiSelect(boolean r1) {
        this.isMultiSelect = r1;
    }

    public final void setSelectMode(boolean r3) {
        this.isMultiSelect = r3;
        if (r3 == false) goto L5;
        o.a((View) ZeusTransformUtils.preCheckCast(this.checkbox, View.class, "com.obric.memorydata.plugin"));
        o.b((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.memorydata.plugin"));
    L6:
        setItemSelected(isItemSelected());
        return;
    L5:
        o.b((View) ZeusTransformUtils.preCheckCast(this.checkbox, View.class, "com.obric.memorydata.plugin"));
        o.a((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    public final void setShowDivider(boolean r1) {
        this.showDivider = r1;
    }

    public final void showSelectLabel(boolean r3) {
        this.showSelectLabel = r3;
        if (r3 == false) goto L5;
        setSelectMode(this.isMultiSelect);
        return;
    L5:
        o.b((View) ZeusTransformUtils.preCheckCast(this.checkbox, View.class, "com.obric.memorydata.plugin"));
        o.b((View) ZeusTransformUtils.preCheckCast(this.radio, View.class, "com.obric.memorydata.plugin"));
    }

    public final void unSelect() {
        setItemSelected(false);
    }
}
