package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.button.OIconButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.d;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\fH\u0016R.\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR.\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R.\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0019\u0010.\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006="}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImg;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "text", "", "setTrailingText", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "", "enabled", "setListItemSettingsEnabled", "", "getContentDefaultOneChildWidth", EventBody.KEY_VALUE, "C", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "trailingTextString", "Landroid/widget/ImageView;", "B", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "ivIcon", "D", "Landroid/graphics/drawable/Drawable;", "getCircleImage", "()Landroid/graphics/drawable/Drawable;", "setCircleImage", "(Landroid/graphics/drawable/Drawable;)V", "circleImage", "E", "getIconImage", "setIconImage", "iconImage", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "z", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Lcom/obric/oui/button/OIconButton;", "A", "Lcom/obric/oui/button/OIconButton;", "getContentImgCircle", "()Lcom/obric/oui/button/OIconButton;", "setContentImgCircle", "(Lcom/obric/oui/button/OIconButton;)V", "contentImgCircle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OListItemCircleImg extends OListItemGeneral {
    private OIconButton A;
    private ImageView B;
    private String C;
    private Drawable D;
    private Drawable E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final SettingsTrailingView f6883z;

    public OListItemCircleImg(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.f6883z = new SettingsTrailingView(r10, null, 0, 6, null);
        View r12 = findViewById(f.contentImgCircle);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.contentImgCircle)");
        this.A = (OIconButton) r12;
        View r13 = findViewById(f.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_icon)");
        this.B = (ImageView) r13;
        TypedArray r14 = r10.obtainStyledAttributes(r11, l.OListItemGeneral);
        setTrailingTextString(r14.getString(l.OListItemGeneral_oui_list_item_trailing_text));
        r14.recycle();
        if (this.D == null) goto L5;
        OIconButton r15 = this.A;
        int r16 = 0;
    L6:
        r15.setVisibility(r16);
        getMContentElement().setVisibility(r16);
        return;
    L5:
        r15 = this.A;
        r16 = 8;
        goto L6
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void d() {
        LayoutInflater.from(getContext()).inflate(h.o_listitem_circle_img, this);
    }

    public final Drawable getCircleImage() {
        return this.D;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(d.oui_listitem_content_width_large));
    }

    public final OIconButton getContentImgCircle() {
        return this.A;
    }

    public final Drawable getIconImage() {
        return this.E;
    }

    public final ImageView getIvIcon() {
        return this.B;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f6883z;
    }

    public final String getTrailingTextString() {
        return this.C;
    }

    public final void setCircleImage(Drawable r10) {
        this.D = r10;
        if (r10 == null) goto L5;
        this.A.setImageDrawable(r10);
        OIconButton r11 = this.A;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        getMContentElement().setVisibility(r12);
        i();
        return;
    L5:
        r11 = this.A;
        r12 = 8;
        goto L6
    }

    public final void setContentImgCircle(OIconButton r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.A = r10;
    }

    public final void setIconImage(Drawable r10) {
        this.E = r10;
        if (r10 == null) goto L5;
        this.B.setImageDrawable(r10);
        ImageView r11 = this.B;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        i();
        return;
    L5:
        r11 = this.B;
        r12 = 8;
        goto L6
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r10) {
        this.f6883z.setTrailingImage(r10);
    }

    public final void setIvIcon(ImageView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.B = r10;
    }

    public final void setListItemSettingsEnabled(boolean r10) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r10);
        if (r10 == false) goto L5;
        FrameLayout r11 = getMLeadingElement();
        float r12 = 1.0f;
    L6:
        r11.setAlpha(r12);
        getMClContent().setAlpha(r12);
        getMContentElement().setAlpha(r12);
        return;
    L5:
        r11 = getMLeadingElement();
        r12 = 0.3f;
        goto L6
    }

    public final void setTrailingText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.f6883z.setTrailingText(r10);
    }

    public final void setTrailingTextString(String r10) {
        this.C = r10;
        i();
        String r11 = this.C;
        if (r11 == null) goto L5;
        setTrailingText(r11);
    L5:
        setTrailingView(this.f6883z);
    }
}
