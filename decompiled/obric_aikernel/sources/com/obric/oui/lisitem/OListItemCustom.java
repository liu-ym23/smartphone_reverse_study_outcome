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
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.d;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b\u0005\u00103¨\u0006;"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCustom;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "text", "", "setTrailingText", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "", "enabled", "setListItemSettingsEnabled", "", "getContentDefaultOneChildWidth", "Landroid/widget/FrameLayout;", "z", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", EventBody.KEY_VALUE, "D", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "trailingTextString", "Lcom/obric/oui/layout/OUIFrameLayout;", "A", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", "Landroid/widget/ImageView;", "C", "Landroid/widget/ImageView;", "getTrailingImageView", "()Landroid/widget/ImageView;", "setTrailingImageView", "(Landroid/widget/ImageView;)V", "trailingImageView", "Lcom/obric/oui/text/OTextView;", "B", "Lcom/obric/oui/text/OTextView;", "getTrailingText", "()Lcom/obric/oui/text/OTextView;", "(Lcom/obric/oui/text/OTextView;)V", "trailingText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OListItemCustom extends OListItemGeneral {
    public OUIFrameLayout A;
    public OTextView B;
    public ImageView C;
    private String D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FrameLayout f6885z;

    public OListItemCustom(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        View r12 = findViewById(f.title_info);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.title_info)");
        this.f6885z = (FrameLayout) r12;
        View r13 = findViewById(f.iv_content_img_background);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_content_img_background)");
        this.A = (OUIFrameLayout) r13;
        View r14 = findViewById(f.trailingText);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.trailingText)");
        this.B = (OTextView) r14;
        View r15 = findViewById(f.trailingImage);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.trailingImage)");
        this.C = (ImageView) r15;
        TypedArray r16 = r10.obtainStyledAttributes(r11, l.OListItemGeneral);
        setTrailingTextString(r16.getString(l.OListItemGeneral_oui_list_item_trailing_text));
        r16.recycle();
        if (getContentImage() == null) goto L9;
        OUIFrameLayout r17 = this.A;
        if (r17 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
    L7:
        r17.setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void d() {
        LayoutInflater.from(getContext()).inflate(h.o_listitem_custom_trailing, this);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(d.oui_listitem_content_width_large));
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r10 = this.A;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
    L5:
        return r10;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r10 = this.f6885z;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
    L5:
        return r10;
    }

    public final ImageView getTrailingImageView() {
        ImageView r10 = this.C;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trailingImageView");
    L5:
        return r10;
    }

    public final OTextView getTrailingText() {
        OTextView r10 = this.B;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trailingText");
    L5:
        return r10;
    }

    public final String getTrailingTextString() {
        return this.D;
    }

    public final void setContentImgBackground(OUIFrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.A = r10;
    }

    public final void setImageView(Drawable r10) {
        ImageView r11 = this.C;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trailingImageView");
    L5:
        r11.setImageDrawable(r10);
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

    public final void setMTitleInfo(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6885z = r10;
    }

    public final void setTrailingImageView(ImageView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.C = r10;
    }

    public final void setTrailingText(OTextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.B = r10;
    }

    public final void setTrailingText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        OTextView r11 = this.B;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trailingText");
    L5:
        r11.setText(r10);
    }

    public final void setTrailingTextString(String r10) {
        this.D = r10;
        i();
        String r11 = this.D;
        if (r11 == null) goto L6;
        setTrailingText(r11);
        return;
    }
}
