package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R.\u0010;\u001a\u0004\u0018\u00010\b2\b\u00105\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010\f¨\u0006<"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSettings;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setTrailingText", "(Ljava/lang/String;)V", "", "minWidth", "setTrailingViewMinWidth", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "enabled", "setListItemSettingsEnabled", "(Z)V", "getContentDefaultOneChildWidth", "()I", "Lcom/obric/oui/lisitem/ListItemHeightMode;", "mode", "setListItemHeightMode", "(Lcom/obric/oui/lisitem/ListItemHeightMode;)V", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "w", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Landroid/widget/FrameLayout;", "x", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", "Lcom/obric/oui/layout/OUIFrameLayout;", "y", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", "value", "z", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "trailingTextString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemSettings extends OListItemGeneral {
    public int A;
    public ListItemHeightMode B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f13585v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SettingsTrailingView f13586w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FrameLayout f13587x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OUIFrameLayout f13588y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f13589z;

    public OListItemSettings(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.A = r5.getResources().getDimensionPixelSize(R$dimen.oui_listitem_content_width_large);
        this.B = ListItemHeightMode.DEFAULT;
        this.f13585v = (ViewGroup) findViewById(R$id.ll_root);
        this.f13586w = new SettingsTrailingView(r5, null, 6, 0);
        setMTitleInfo((FrameLayout) findViewById(R$id.title_info));
        setContentImgBackground((OUIFrameLayout) findViewById(R$id.iv_content_img_background));
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.OListItemGeneral);
        setTrailingTextString(r11.getString(R$styleable.OListItemGeneral_oui_list_item_trailing_text));
        r11.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return this.A;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r5 = this.f13588y;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r5 = this.f13587x;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f13586w;
    }

    public final String getTrailingTextString() {
        return this.f13589z;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void n() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_settings, this);
    }

    public final void setContentImgBackground(OUIFrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13588y = r5;
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r5) {
        this.f13586w.setTrailingImage(r5);
    }

    public final void setListItemHeightMode(ListItemHeightMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        if (this.B != r10) goto L5;
        return;
    L5:
        int r5 = d.f13604a[r10.ordinal()];
        if (r5 != 1) goto L8;
        int r11 = getResources().getDimensionPixelSize(R$dimen.oui_listitem_content_width_large);
    L13:
        this.f13585v.setMinimumHeight(r11);
        getMClContent().setMinimumHeight(r11);
        getMClContent().setMinHeight(r11);
        ViewGroup.LayoutParams r12 = getMTrailingElement().getLayoutParams();
        if (r12 != null) goto L17;
    L21:
        this.A = r11;
        p();
        this.B = r10;
        return;
    L17:
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L21;
        int r13 = (r11 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r12;
        if (r13 >= r14.matchConstraintMinHeight) goto L21;
        FrameLayout r15 = getMTrailingElement();
        r14.matchConstraintMinHeight = r13;
        r15.setLayoutParams(r12);
        goto L21
    L8:
        if (r5 != 2) goto L11;
        r11 = getResources().getDimensionPixelSize(R$dimen.oui_listitem_content_width_middle);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void setListItemSettingsEnabled(boolean r5) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r5);
        if (r5 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    public final void setMTitleInfo(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13587x = r5;
    }

    public final void setTrailingText(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        this.f13586w.setTrailingText(r5);
    }

    public final void setTrailingTextString(String r5) {
        this.f13589z = r5;
        p();
        String r10 = this.f13589z;
        if (r10 == null) goto L6;
        setTrailingText(r10);
    L6:
        setTrailingView(this.f13586w);
    }

    public final void setTrailingViewMinWidth(int r5) {
        ViewGroup.LayoutParams r10 = getMTrailingElement().getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        FrameLayout r11 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) r10).matchConstraintMinWidth = r5;
        r11.setLayoutParams(r10);
        return;
    }
}
