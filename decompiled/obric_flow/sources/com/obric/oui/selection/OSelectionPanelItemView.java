package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0007\u0010\u0017\"\u0004\b\u0018\u0010\u0006R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0006R$\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0006¨\u0006 "}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "", "showDivider", "", "setDividerMode", "(Z)V", "isMultiSelect", "setSelectMode", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "Lcom/obric/oui/text/OTextView;", "getTextView", "()Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/radio/ORadio;", "getRadioView", "()Lcom/obric/oui/radio/ORadio;", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "n", "Z", "()Z", "setMultiSelect", "o", "getShowDivider", "setShowDivider", "value", "e", "setItemSelected", "isItemSelected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelItemView extends OUIConstraintLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f14386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OTextView f14387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ORadio f14388r;
    public final OCheckBox s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f14389t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14390u;

    @JvmOverloads
    public OSelectionPanelItemView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 14);
    }

    private final void setDividerMode(boolean r5) {
        View r10 = this.f14389t;
        if (r5 == false) goto L5;
        d.t(r10);
        return;
    L5:
        d.s(r10);
    }

    public final boolean e() {
        if (this.f14384n == false) goto L6;
        return this.s.isChecked();
    L6:
        return this.f14388r.isChecked();
    }

    public final OCheckBox getCheckBox() {
        return this.s;
    }

    public final ImageView getIconView() {
        return this.f14386p;
    }

    public final ORadio getRadioView() {
        return this.f14388r;
    }

    public final boolean getShowDivider() {
        return this.f14385o;
    }

    public final OTextView getTextView() {
        return this.f14387q;
    }

    public final void setItemSelected(boolean r5) {
        boolean r10 = this.f14384n;
        ORadio r11 = this.f14388r;
        if (r10 == false) goto L5;
        this.s.setChecked(r5);
    L7:
        if (this.f14390u == true) goto L10;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        r11.setVisibility(4);
        return;
    L10:
        return;
    L5:
        r11.setChecked(r5);
        goto L7
    }

    public final void setMultiSelect(boolean r5) {
        this.f14384n = r5;
    }

    public final void setSelectMode(boolean r5) {
        this.f14384n = r5;
        ORadio r10 = this.f14388r;
        OCheckBox r11 = this.s;
        if (r5 == false) goto L5;
        d.t(r11);
        d.s(r10);
    L6:
        setItemSelected(e());
        return;
    L5:
        d.s(r11);
        d.t(r10);
        goto L6
    }

    public final void setShowDivider(boolean r5) {
        this.f14385o = r5;
    }

    @JvmOverloads
    public OSelectionPanelItemView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 12);
    }

    public OSelectionPanelItemView(Context r5, AttributeSet r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, 0, 12);
        this.f14384n = false;
        this.f14385o = false;
        this.f14390u = true;
        View.inflate(r5, R$layout.o_view_selection_item, this);
        setMinHeight((int) getResources().getDimension(R$dimen.oui_h_l2));
        this.f14386p = (ImageView) findViewById(R$id.iv_icon);
        this.f14387q = (OTextView) findViewById(R$id.tv_text);
        this.f14388r = (ORadio) findViewById(R$id.radio);
        OCheckBox r12 = (OCheckBox) findViewById(R$id.checkbox);
        this.s = r12;
        this.f14389t = findViewById(R$id.divider);
        r12.setClickable(false);
        setRadius((int) getResources().getDimension(R$dimen.oui_r_l3_rect));
        setSelectMode(this.f14384n);
        setDividerMode(this.f14385o);
        setPadding(getResources().getDimensionPixelSize(R$dimen.oui_p_list_item_2), getPaddingTop(), getResources().getDimensionPixelSize(R$dimen.oui_p_list_item_2), getPaddingBottom());
        ViewCompat.setAccessibilityDelegate(this, new OSelectionPanelItemView$addAccessibilityCompat$1(this));
    }
}
