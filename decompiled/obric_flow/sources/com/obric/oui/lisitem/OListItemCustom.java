package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b\u000b\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R.\u0010=\u001a\u0004\u0018\u00010\b2\b\u00107\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\f¨\u0006>"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCustom;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setTrailingText", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "enabled", "setListItemSettingsEnabled", "(Z)V", "", "getContentDefaultOneChildWidth", "()I", "Landroid/widget/FrameLayout;", "v", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", "Lcom/obric/oui/layout/OUIFrameLayout;", "w", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", "Lcom/obric/oui/text/OTextView;", "x", "Lcom/obric/oui/text/OTextView;", "getTrailingText", "()Lcom/obric/oui/text/OTextView;", "(Lcom/obric/oui/text/OTextView;)V", "trailingText", "Landroid/widget/ImageView;", "y", "Landroid/widget/ImageView;", "getTrailingImageView", "()Landroid/widget/ImageView;", "setTrailingImageView", "(Landroid/widget/ImageView;)V", "trailingImageView", "value", "z", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "trailingTextString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCustom extends OListItemGeneral {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f13567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OUIFrameLayout f13568w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OTextView f13569x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f13570y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f13571z;

    public OListItemCustom(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setMTitleInfo((FrameLayout) findViewById(R$id.title_info));
        setContentImgBackground((OUIFrameLayout) findViewById(R$id.iv_content_img_background));
        setTrailingText((OTextView) findViewById(R$id.trailingText));
        setTrailingImageView((ImageView) findViewById(R$id.trailingImage));
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.OListItemGeneral);
        setTrailingTextString(r11.getString(R$styleable.OListItemGeneral_oui_list_item_trailing_text));
        r11.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(R$dimen.oui_listitem_content_width_large));
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r5 = this.f13568w;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r5 = this.f13567v;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    public final ImageView getTrailingImageView() {
        ImageView r5 = this.f13570y;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingImageView");
        return null;
    }

    public final OTextView getTrailingText() {
        OTextView r5 = this.f13569x;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingText");
        return null;
    }

    public final String getTrailingTextString() {
        return this.f13571z;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public final void n() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_custom_trailing, this);
    }

    public final void setContentImgBackground(OUIFrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13568w = r5;
    }

    public final void setImageView(Drawable r5) {
        getTrailingImageView().setImageDrawable(r5);
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
        this.f13567v = r5;
    }

    public final void setTrailingImageView(ImageView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13570y = r5;
    }

    public final void setTrailingText(OTextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13569x = r5;
    }

    public final void setTrailingTextString(String r5) {
        this.f13571z = r5;
        p();
        String r10 = this.f13571z;
        if (r10 == null) goto L7;
        setTrailingText(r10);
        return;
    }

    public final void setTrailingText(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        getTrailingText().setText(r5);
    }
}
