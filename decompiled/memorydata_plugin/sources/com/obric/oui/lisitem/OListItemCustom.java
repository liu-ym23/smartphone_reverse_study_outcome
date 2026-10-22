package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/J\u000e\u0010\u001d\u001a\u00020)2\u0006\u00100\u001a\u00020 R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00061"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCustom;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentImgBackground", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "mTitleInfo", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "trailingImageView", "Landroid/widget/ImageView;", "getTrailingImageView", "()Landroid/widget/ImageView;", "setTrailingImageView", "(Landroid/widget/ImageView;)V", "trailingText", "Lcom/obric/oui/text/OTextView;", "getTrailingText", "()Lcom/obric/oui/text/OTextView;", "setTrailingText", "(Lcom/obric/oui/text/OTextView;)V", EventBody.KEY_VALUE, "", "trailingTextString", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "getContentDefaultOneChildWidth", "", "inflateContent", "", "setImageView", "drawable", "Landroid/graphics/drawable/Drawable;", "setListItemSettingsEnabled", "enabled", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCustom extends OListItemGeneral {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f13977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OUIFrameLayout f13978b;
    public OTextView c;
    public ImageView d;
    private String l;

    public OListItemCustom(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.title_info, OaidModel.KEY_ID, "title_info"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) ZeusTransformUtils.preCheckCast(r0, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_content_img_background, OaidModel.KEY_ID, "iv_content_img_background"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r1, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.trailingText, OaidModel.KEY_ID, "trailingText"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.trailingText)");
        setTrailingText((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin"));
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.trailingImage, OaidModel.KEY_ID, "trailingImage"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.trailingImage)");
        setTrailingImageView((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.memorydata.plugin"));
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.OListItemGeneral);
        setTrailingTextString(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_text, "styleable", "OListItemGeneral_oui_list_item_trailing_text")));
        r9.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void a() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_custom_trailing, "layout", "o_listitem_custom_trailing"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_large, "dimen", "oui_listitem_content_width_large")));
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.f13978b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.f13977a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    public final ImageView getTrailingImageView() {
        ImageView r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingImageView");
        return null;
    }

    public final OTextView getTrailingText() {
        OTextView r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingText");
        return null;
    }

    public final String getTrailingTextString() {
        return this.l;
    }

    public final void setContentImgBackground(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13978b = r2;
    }

    public final void setImageView(Drawable r1) {
        getTrailingImageView().setImageDrawable(r1);
    }

    public final void setListItemSettingsEnabled(boolean r2) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r2);
        if (r2 == false) goto L5;
        FrameLayout r3 = getMLeadingElement();
        float r0 = 1.0f;
    L6:
        r3.setAlpha(r0);
        getMClContent().setAlpha(r0);
        getMContentElement().setAlpha(r0);
        return;
    L5:
        r3 = getMLeadingElement();
        r0 = 0.3f;
        goto L6
    }

    public final void setMTitleInfo(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13977a = r2;
    }

    public final void setTrailingImageView(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setTrailingText(OTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setTrailingText(String r3) {
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        getTrailingText().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void setTrailingTextString(String r1) {
        this.l = r1;
        b();
        String r2 = this.l;
        if (r2 == null) goto L7;
        setTrailingText(r2);
        return;
    }
}
