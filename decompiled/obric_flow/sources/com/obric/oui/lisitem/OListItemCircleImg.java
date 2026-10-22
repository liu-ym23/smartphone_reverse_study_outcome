package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OIconButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u00104\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\fR.\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010.\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0010R.\u0010>\u001a\u0004\u0018\u00010\r2\b\u0010.\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010\u0010¨\u0006?"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImg;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setTrailingText", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "enabled", "setListItemSettingsEnabled", "(Z)V", "", "getContentDefaultOneChildWidth", "()I", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "v", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Lcom/obric/oui/button/OIconButton;", "w", "Lcom/obric/oui/button/OIconButton;", "getContentImgCircle", "()Lcom/obric/oui/button/OIconButton;", "setContentImgCircle", "(Lcom/obric/oui/button/OIconButton;)V", "contentImgCircle", "Landroid/widget/ImageView;", "x", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "ivIcon", "value", "y", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "trailingTextString", "z", "Landroid/graphics/drawable/Drawable;", "getCircleImage", "()Landroid/graphics/drawable/Drawable;", "setCircleImage", "circleImage", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getIconImage", "setIconImage", "iconImage", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCircleImg extends OListItemGeneral {
    public Drawable A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SettingsTrailingView f13562v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OIconButton f13563w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f13564x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f13565y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f13566z;

    public OListItemCircleImg(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f13562v = new SettingsTrailingView(r5, null, 6, 0);
        this.f13563w = (OIconButton) findViewById(R$id.contentImgCircle);
        this.f13564x = (ImageView) findViewById(R$id.iv_icon);
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.OListItemGeneral);
        setTrailingTextString(r11.getString(R$styleable.OListItemGeneral_oui_list_item_trailing_text));
        r11.recycle();
        if (this.f13566z == null) goto L5;
        this.f13563w.setVisibility(0);
        getMContentElement().setVisibility(0);
        return;
    L5:
        this.f13563w.setVisibility(8);
        getMContentElement().setVisibility(8);
    }

    public final Drawable getCircleImage() {
        return this.f13566z;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(R$dimen.oui_listitem_content_width_large));
    }

    public final OIconButton getContentImgCircle() {
        return this.f13563w;
    }

    public final Drawable getIconImage() {
        return this.A;
    }

    public final ImageView getIvIcon() {
        return this.f13564x;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f13562v;
    }

    public final String getTrailingTextString() {
        return this.f13565y;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public final void n() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_circle_img, this);
    }

    public final void setCircleImage(Drawable r5) {
        this.f13566z = r5;
        if (r5 == null) goto L5;
        this.f13563w.setImageDrawable(r5);
        this.f13563w.setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        p();
        return;
    L5:
        this.f13563w.setVisibility(8);
        getMContentElement().setVisibility(8);
        goto L6
    }

    public final void setContentImgCircle(OIconButton r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13563w = r5;
    }

    public final void setIconImage(Drawable r5) {
        this.A = r5;
        if (r5 == null) goto L5;
        this.f13564x.setImageDrawable(r5);
        this.f13564x.setVisibility(0);
    L6:
        p();
        return;
    L5:
        this.f13564x.setVisibility(8);
        goto L6
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r5) {
        this.f13562v.setTrailingImage(r5);
    }

    public final void setIvIcon(ImageView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13564x = r5;
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

    public final void setTrailingText(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        this.f13562v.setTrailingText(r5);
    }

    public final void setTrailingTextString(String r5) {
        this.f13565y = r5;
        p();
        String r10 = this.f13565y;
        if (r10 == null) goto L6;
        setTrailingText(r10);
    L6:
        setTrailingView(this.f13562v);
    }
}
