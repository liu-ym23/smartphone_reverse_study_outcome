package com.larksuite.component.card.component.image;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u009e\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u000bHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0019R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019¨\u00067"}, d2 = {"Lcom/larksuite/component/card/component/image/ImageContentProps;", "", "imageId", "", "resId", "tintColor", "cropType", "isTranslateElement", "", "forcePreview", "originWidth", "", "originHeight", "disableLongImageTag", "transparent", "disableTap", "loadingStyle", "preview", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/Integer;ZZZLjava/lang/String;Z)V", "getImageId", "()Ljava/lang/String;", "getResId", "getTintColor", "getCropType", "()Z", "getForcePreview", "getOriginWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOriginHeight", "getDisableLongImageTag", "getTransparent", "getDisableTap", "getLoadingStyle", "getPreview", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/Integer;ZZZLjava/lang/String;Z)Lcom/larksuite/component/card/component/image/ImageContentProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class a {

    @SerializedName("crop_type")
    private final String cropType;

    @SerializedName("disableLongImageTag")
    private final boolean disableLongImageTag;

    @SerializedName("disableTap")
    private final boolean disableTap;

    @SerializedName("forcePreview")
    private final boolean forcePreview;

    @SerializedName("image_id")
    private final String imageId;

    @SerializedName("isTranslateElement")
    private final boolean isTranslateElement;

    @SerializedName("loadingStyle")
    private final String loadingStyle;

    @SerializedName("originHeight")
    private final Integer originHeight;

    @SerializedName("originWidth")
    private final Integer originWidth;

    @SerializedName("preview")
    private final boolean preview;

    @SerializedName("res_id")
    private final String resId;

    @SerializedName("tint_color")
    private final String tintColor;

    @SerializedName("transparent")
    private final boolean transparent;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.imageId, r6.imageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resId, r6.resId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tintColor, r6.tintColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cropType, r6.cropType) == true) goto L21;
        return false;
    L21:
        if (this.isTranslateElement == r6.isTranslateElement) goto L24;
        return false;
    L24:
        if (this.forcePreview == r6.forcePreview) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.originWidth, r6.originWidth) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originHeight, r6.originHeight) == true) goto L33;
        return false;
    L33:
        if (this.disableLongImageTag == r6.disableLongImageTag) goto L36;
        return false;
    L36:
        if (this.transparent == r6.transparent) goto L39;
        return false;
    L39:
        if (this.disableTap == r6.disableTap) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.loadingStyle, r6.loadingStyle) == true) goto L45;
        return false;
    L45:
        if (this.preview == r6.preview) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.imageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.resId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.tintColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.cropType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        int r13 = 1231;
        if (this.isTranslateElement == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.forcePreview == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        Integer r19 = this.originWidth;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r17 + r20) * 31;
        Integer r22 = this.originHeight;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        if (this.disableLongImageTag == false) goto L37;
        int r25 = 1231;
    L38:
        int r26 = (r24 + r25) * 31;
        if (this.transparent == false) goto L41;
        int r27 = 1231;
    L42:
        int r29 = (r26 + r27) * 31;
        if (this.disableTap == false) goto L45;
        int r30 = 1231;
    L46:
        int r31 = (r29 + r30) * 31;
        String r32 = this.loadingStyle;
        if (r32 == null) goto L50;
        r1 = r32.hashCode();
    L50:
        int r33 = (r31 + r1) * 31;
        if (this.preview == true) goto L55;
        r13 = 1237;
    L55:
        return r33 + r13;
    L45:
        r30 = 1237;
        goto L46
    L41:
        r27 = 1237;
        goto L42
    L37:
        r25 = 1237;
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageContentProps(imageId=" + this.imageId + ", resId=" + this.resId + ", tintColor=" + this.tintColor + ", cropType=" + this.cropType + ", isTranslateElement=" + this.isTranslateElement + ", forcePreview=" + this.forcePreview + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ", disableLongImageTag=" + this.disableLongImageTag + ", transparent=" + this.transparent + ", disableTap=" + this.disableTap + ", loadingStyle=" + this.loadingStyle + ", preview=" + this.preview + ')';
    }

    public final String a() {
        return this.cropType;
    }

    public final boolean b() {
        return this.disableLongImageTag;
    }

    public final boolean c() {
        return this.disableTap;
    }

    public final boolean d() {
        return this.forcePreview;
    }

    public final String e() {
        return this.imageId;
    }

    public final String f() {
        return this.loadingStyle;
    }

    public final Integer g() {
        return this.originHeight;
    }

    public final Integer h() {
        return this.originWidth;
    }

    public final boolean i() {
        return this.preview;
    }

    public final String j() {
        return this.resId;
    }

    public final String k() {
        return this.tintColor;
    }

    public final boolean l() {
        return this.transparent;
    }

    public final boolean m() {
        return this.isTranslateElement;
    }

    public /* synthetic */ a(int r15) {
        this(null, null, null, null, false, false, null, null, true, true, true, null, false);
    }

    public a(String r1, String r2, String r3, String r4, boolean r5, boolean r6, Integer r7, Integer r8, boolean r9, boolean r10, boolean r11, String r12, boolean r13) {
        this.imageId = r1;
        this.resId = r2;
        this.tintColor = r3;
        this.cropType = r4;
        this.isTranslateElement = r5;
        this.forcePreview = r6;
        this.originWidth = r7;
        this.originHeight = r8;
        this.disableLongImageTag = r9;
        this.transparent = r10;
        this.disableTap = r11;
        this.loadingStyle = r12;
        this.preview = r13;
    }
}
