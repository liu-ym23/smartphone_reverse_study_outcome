package rc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.obric.cae.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import he.i;
import j0.w;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends OUIConstraintLayout {
    public final ImageView G;
    public final OTextView H;
    public final ORadio I;
    public final OCheckBox J;
    public final View K;
    public boolean L;
    public boolean M;
    public boolean N;

    public c(Context r8, boolean r10) {
        super(r8, null, 0);
        this.M = false;
        this.N = r10;
        this.L = true;
        ViewGroup.inflate(r8, R.layout.o_view_selection_item, this);
        setMinHeight((int) getResources().getDimension(R.dimen.oui_h_l2));
        View r11 = findViewById(R.id.iv_icon);
        i.e(r11, "findViewById(R.id.iv_icon)");
        this.G = (ImageView) r11;
        View r12 = findViewById(R.id.tv_text);
        i.e(r12, "findViewById(R.id.tv_text)");
        this.H = (OTextView) r12;
        View r13 = findViewById(R.id.radio);
        i.e(r13, "findViewById(R.id.radio)");
        this.I = (ORadio) r13;
        View r14 = findViewById(R.id.checkbox);
        i.e(r14, "findViewById(R.id.checkbox)");
        OCheckBox r15 = (OCheckBox) r14;
        this.J = r15;
        View r16 = findViewById(R.id.divider);
        i.e(r16, "findViewById(R.id.divider)");
        this.K = r16;
        r15.setClickable(false);
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setSelectMode(this.M);
        setDividerMode(this.N);
        setPadding(getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingTop(), getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingBottom());
        w.m(this, new b(this));
    }

    private final void setDividerMode(boolean r8) {
        View r10 = this.K;
        if (r8 == false) goto L5;
        bc.a.c(r10);
        return;
    L5:
        bc.a.b(r10);
    }

    public final OCheckBox getCheckBox() {
        return this.J;
    }

    public final ImageView getIconView() {
        return this.G;
    }

    public final ORadio getRadioView() {
        return this.I;
    }

    public final boolean getShowDivider() {
        return this.N;
    }

    public final OTextView getTextView() {
        return this.H;
    }

    public final boolean s() {
        if (this.M == false) goto L6;
        return this.J.isChecked();
    L6:
        return this.I.isChecked();
    }

    public final void setItemSelected(boolean r8) {
        boolean r10 = this.M;
        ORadio r11 = this.I;
        if (r10 == false) goto L5;
        this.J.setChecked(r8);
    L7:
        if (this.L == true) goto L10;
        i.f(r11, "$this$makeInvisible");
        r11.setVisibility(4);
        return;
    L10:
        return;
    L5:
        r11.setChecked(r8);
        goto L7
    }

    public final void setMultiSelect(boolean r8) {
        this.M = r8;
    }

    public final void setSelectMode(boolean r8) {
        this.M = r8;
        ORadio r10 = this.I;
        OCheckBox r11 = this.J;
        if (r8 == false) goto L5;
        bc.a.c(r11);
        bc.a.b(r10);
    L6:
        setItemSelected(s());
        return;
    L5:
        bc.a.b(r11);
        bc.a.c(r10);
        goto L6
    }

    public final void setShowDivider(boolean r8) {
        this.N = r8;
    }
}
