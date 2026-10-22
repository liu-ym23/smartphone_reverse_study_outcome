package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0000H\u0016J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ImageProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "image", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "alt", BuildConfig.FLAVOR, "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "imageUrl", "dmImage", "dmImageUrl", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/UDIcon;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;)V", "getImage", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setImage", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getAlt", "()Ljava/lang/String;", "setAlt", "(Ljava/lang/String;)V", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "setUdIcon", "(Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getImageUrl", "setImageUrl", "getDmImage", "setDmImage", "getDmImageUrl", "setDmImageUrl", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageProperty extends BaseProperty {
    private String alt;
    private ImageSet dmImage;
    private String dmImageUrl;
    private ImageSet image;
    private String imageUrl;
    private UDIcon udIcon;

    public ImageProperty clone() {
        ImageSet r1 = this.image;
        String r2 = this.alt;
        UDIcon r0 = this.udIcon;
        if (r0 == null) goto L5;
        UDIcon r3 = r0.clone();
    L6:
        ImageProperty r7 = new ImageProperty(r1, r2, r3, this.imageUrl, this.dmImage, this.dmImageUrl);
        r7.setMarginLeft(getMarginLeft());
        r7.setMarginRight(getMarginRight());
        r7.setMarginTop(getMarginTop());
        r7.setMarginBottom(getMarginBottom());
        return r7;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        ImageSet r1 = this.image;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.alt;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        UDIcon r8 = this.udIcon;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.imageUrl;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        ImageSet r14 = this.dmImage;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.dmImageUrl;
        if (r17 == null) goto L26;
        r2 = r17.hashCode();
    L26:
        return r16 + r2;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String getAlt() {
        return this.alt;
    }

    public final ImageSet getDmImage() {
        return this.dmImage;
    }

    public final String getDmImageUrl() {
        return this.dmImageUrl;
    }

    public final ImageSet getImage() {
        return this.image;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Props m663clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        ImageProperty r6 = (ImageProperty) r5;
        if (Intrinsics.areEqual(this.image, r6.image) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.alt, r6.alt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.udIcon, r6.udIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageUrl, r6.imageUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dmImage, r6.dmImage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dmImageUrl, r6.dmImageUrl) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L36;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        ImageSet r3 = null;
        String r4 = null;
        UDIcon r7 = null;
        String r8 = null;
        if (r1 == ComponentAttribute.image.getValue()) goto L9;
        if (r1 == ComponentAttribute.alt.getValue()) goto L15;
        if (r1 == ComponentAttribute.ud_icon_key.getValue()) goto L32;
        if (r1 == ComponentAttribute.ud_icon_theme_color.getValue()) goto L32;
        if (r1 == ComponentAttribute.unicode.getValue()) goto L32;
        if (r1 != ComponentAttribute.image_url.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L31;
        r4 = r2.getString();
    L31:
        this.imageUrl = r4;
    L32:
        UDIcon r9 = this.udIcon;
        if (r9 == null) goto L35;
        r7 = r9.patchData(r0.getKey().intValue(), r0.getValue(), this.udIcon);
    L35:
        this.udIcon = r7;
        goto L6
    L15:
        PreviewData r10 = r0.getValue();
        if (r10 == null) goto L18;
        r8 = r10.getString();
    L18:
        this.alt = r8;
        goto L6
    L9:
        PreviewData r11 = r0.getValue();
        if (r11 == null) goto L12;
        r3 = r11.getImageSet();
    L12:
        this.image = r3;
        goto L6
    }

    public final void setAlt(String r1) {
        this.alt = r1;
    }

    public final void setDmImage(ImageSet r1) {
        this.dmImage = r1;
    }

    public final void setDmImageUrl(String r1) {
        this.dmImageUrl = r1;
    }

    public final void setImage(ImageSet r1) {
        this.image = r1;
    }

    public final void setImageUrl(String r1) {
        this.imageUrl = r1;
    }

    public final void setUdIcon(UDIcon r1) {
        this.udIcon = r1;
    }

    public ImageProperty(ImageSet r2, String r3, UDIcon r4, String r5, ImageSet r6, String r7) {
        super(Type.IMAGE);
        this.image = r2;
        this.alt = r3;
        this.udIcon = r4;
        this.imageUrl = r5;
        this.dmImage = r6;
        this.dmImageUrl = r7;
    }

    public /* synthetic */ ImageProperty(ImageSet r10, String r11, UDIcon r12, String r13, ImageSet r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        UDIcon r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        ImageSet r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        String r8 = null;
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
