package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.cae.R;
import com.obric.oui.layout.OUIFrameLayout;
import ha.t;
import he.i;
import lc.a;
import lc.f;
import lc.g;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OListItemSettings extends f {
    public final ViewGroup E;
    public final g F;
    public FrameLayout G;
    public OUIFrameLayout H;
    public String I;
    public int J;
    public a K;

    public OListItemSettings(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10);
        this.J = r8.getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_large);
        this.K = a.f9208a;
        View r11 = findViewById(R.id.ll_root);
        i.e(r11, "findViewById(R.id.ll_root)");
        this.E = (ViewGroup) r11;
        this.F = new g(r8);
        View r12 = findViewById(R.id.title_info);
        i.e(r12, "findViewById(R.id.title_info)");
        this.G = (FrameLayout) r12;
        View r13 = findViewById(R.id.iv_content_img_background);
        i.e(r13, "findViewById(R.id.iv_content_img_background)");
        this.H = (OUIFrameLayout) r13;
        TypedArray r14 = r8.obtainStyledAttributes(r10, nb.a.f9499m);
        setTrailingTextString(r14.getString(7));
        r14.recycle();
        if (getContentImage() == null) goto L9;
        OUIFrameLayout r15 = this.H;
        if (r15 == null) goto L7;
        r15.setVisibility(0);
        return;
    L7:
        i.j("contentImgBackground");
        throw null;
    }

    @Override // lc.f
    public void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_settings, this);
    }

    @Override // lc.f
    public int getContentDefaultOneChildWidth() {
        return this.J;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r8 = this.H;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("contentImgBackground");
        throw null;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r8 = this.G;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mTitleInfo");
        throw null;
    }

    public final g getSettingsTrailingView() {
        return this.F;
    }

    public final String getTrailingTextString() {
        return this.I;
    }

    public final void setContentImgBackground(OUIFrameLayout r8) {
        i.f(r8, "<set-?>");
        this.H = r8;
    }

    public final void setImageView(Drawable r8) {
        this.F.setTrailingImage(r8);
    }

    public final void setListItemHeightMode(a r8) {
        i.f(r8, "mode");
        if (this.K != r8) goto L5;
        return;
    L5:
        int r10 = r8.ordinal();
        if (r10 != 0) goto L8;
        Resources r11 = getResources();
        int r12 = R.dimen.oui_listitem_content_width_large;
    L13:
        int r13 = r11.getDimensionPixelSize(r12);
        this.E.setMinimumHeight(r13);
        getMClContent().setMinimumHeight(r13);
        getMClContent().setMinHeight(r13);
        ViewGroup.LayoutParams r14 = getMTrailingElement().getLayoutParams();
        if (r14 != null) goto L16;
    L20:
        this.J = r13;
        i();
        this.K = r8;
        return;
    L16:
        if ((r14 instanceof ConstraintLayout.a) == false) goto L20;
        int r15 = (r13 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        ConstraintLayout.a r16 = (ConstraintLayout.a) r14;
        if (r15 >= r16.O) goto L20;
        FrameLayout r17 = getMTrailingElement();
        r16.O = r15;
        j r18 = j.f13877a;
        r17.setLayoutParams(r14);
        goto L20
    L8:
        if (r10 != 1) goto L11;
        r11 = getResources();
        r12 = R.dimen.oui_listitem_content_width_middle;
        goto L13
    L11:
        throw new t();
    }

    public final void setListItemSettingsEnabled(boolean r8) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r8);
        if (r8 == false) goto L5;
        FrameLayout r10 = getMLeadingElement();
        float r11 = 1.0f;
    L6:
        r10.setAlpha(r11);
        getMClContent().setAlpha(r11);
        getMContentElement().setAlpha(r11);
        return;
    L5:
        r10 = getMLeadingElement();
        r11 = 0.3f;
        goto L6
    }

    public final void setMTitleInfo(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.G = r8;
    }

    public final void setTrailingText(String r8) {
        i.f(r8, "text");
        this.F.setTrailingText(r8);
    }

    public final void setTrailingTextString(String r8) {
        this.I = r8;
        i();
        String r10 = this.I;
        if (r10 == null) goto L5;
        setTrailingText(r10);
    L5:
        setTrailingView(this.F);
    }

    public final void setTrailingViewMinWidth(int r8) {
        ViewGroup.LayoutParams r10 = getMTrailingElement().getLayoutParams();
        if ((r10 instanceof ConstraintLayout.a) == false) goto L6;
        FrameLayout r11 = getMTrailingElement();
        ((ConstraintLayout.a) r10).N = r8;
        j r12 = j.f13877a;
        r11.setLayoutParams(r10);
        return;
    }
}
