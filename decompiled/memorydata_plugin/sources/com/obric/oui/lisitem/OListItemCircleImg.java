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
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020!J\u0018\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020(2\b\b\u0002\u00104\u001a\u000205J\u0010\u00106\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\bR(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0007\u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00067"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImg;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", EventBody.KEY_VALUE, "Landroid/graphics/drawable/Drawable;", "circleImage", "getCircleImage", "()Landroid/graphics/drawable/Drawable;", "setCircleImage", "(Landroid/graphics/drawable/Drawable;)V", "contentImgCircle", "Lcom/obric/oui/button/OIconButton;", "getContentImgCircle", "()Lcom/obric/oui/button/OIconButton;", "setContentImgCircle", "(Lcom/obric/oui/button/OIconButton;)V", "iconImage", "getIconImage", "setIconImage", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "settingsTrailingView", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "", "trailingTextString", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "getContentDefaultOneChildWidth", "", "inflateContent", "", "setImageView", "drawable", "setListItemSettingsEnabled", "enabled", "", "setTrailingText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "setTrailingTextMaxLines", "lineCount", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "showTrailingImageView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCircleImg extends OListItemGeneral {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SettingsTrailingView f13973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OIconButton f13974b;
    private ImageView c;
    private String d;
    private Drawable l;
    private Drawable m;

    public OListItemCircleImg(Context r9, AttributeSet r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12);
        this.f13973a = new SettingsTrailingView(r11, null, 0, 6, null);
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.contentImgCircle, OaidModel.KEY_ID, "contentImgCircle"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.contentImgCircle)");
        this.f13974b = (OIconButton) ZeusTransformUtils.preCheckCast(r0, OIconButton.class, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.iv_icon)");
        this.c = (ImageView) ZeusTransformUtils.preCheckCast(r1, ImageView.class, "com.obric.memorydata.plugin");
        TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.OListItemGeneral);
        setTrailingTextString(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_text, "styleable", "OListItemGeneral_oui_list_item_trailing_text")));
        r13.recycle();
        if (this.l == null) goto L5;
        OIconButton r14 = this.f13974b;
        int r15 = 0;
    L6:
        r14.setVisibility(r15);
        getMContentElement().setVisibility(r15);
        return;
    L5:
        r14 = this.f13974b;
        r15 = 8;
        goto L6
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void a() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_circle_img, "layout", "o_listitem_circle_img"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public final Drawable getCircleImage() {
        return this.l;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_large, "dimen", "oui_listitem_content_width_large")));
    }

    public final OIconButton getContentImgCircle() {
        return this.f13974b;
    }

    public final Drawable getIconImage() {
        return this.m;
    }

    public final ImageView getIvIcon() {
        return this.c;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f13973a;
    }

    public final String getTrailingTextString() {
        return this.d;
    }

    public final void setCircleImage(Drawable r2) {
        this.l = r2;
        if (r2 == null) goto L5;
        this.f13974b.setImageDrawable(r2);
        OIconButton r3 = this.f13974b;
        int r0 = 0;
    L6:
        r3.setVisibility(r0);
        getMContentElement().setVisibility(r0);
        b();
        return;
    L5:
        r3 = this.f13974b;
        r0 = 8;
        goto L6
    }

    public final void setContentImgCircle(OIconButton r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13974b = r2;
    }

    public final void setIconImage(Drawable r2) {
        this.m = r2;
        if (r2 == null) goto L5;
        this.c.setImageDrawable(r2);
        ImageView r3 = this.c;
        int r0 = 0;
    L6:
        r3.setVisibility(r0);
        b();
        return;
    L5:
        r3 = this.c;
        r0 = 8;
        goto L6
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r1) {
        this.f13973a.setTrailingImage(r1);
    }

    public final void setIvIcon(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
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

    public final void setTrailingText(String r2) {
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.f13973a.setTrailingText(r2);
    }

    public final void setTrailingTextString(String r3) {
        this.d = r3;
        b();
        String r4 = this.d;
        if (r4 == null) goto L6;
        setTrailingText(r4);
    L6:
        setTrailingView((View) ZeusTransformUtils.preCheckCast(this.f13973a, View.class, "com.obric.memorydata.plugin"));
    }
}
