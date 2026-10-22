package com.larksuite.component.card.component.udicon;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JT\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "", "token", "", "color", "customColor", "imageId", "isTranslateElement", "", "iconSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)V", "getToken", "()Ljava/lang/String;", "getColor", "getCustomColor", "getImageId", "()Z", "getIconSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDIconContentProps {

    @SerializedName("color")
    private final String color;

    @SerializedName("customColor")
    private final String customColor;

    @SerializedName("iconSize")
    private final Integer iconSize;

    @SerializedName("imageID")
    private final String imageId;

    @SerializedName("isTranslateElement")
    private final boolean isTranslateElement;

    @SerializedName("token")
    private final String token;

    public UDIconContentProps() {
        this(null, null, null, null, false, null, 63, null);
    }

    public static /* synthetic */ UDIconContentProps copy$default(UDIconContentProps r4, String r5, String r6, String r7, String r8, boolean r9, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.token;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.color;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.customColor;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.imageId;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.isTranslateElement;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.iconSize;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.color;
    }

    public final String component3() {
        return this.customColor;
    }

    public final String component4() {
        return this.imageId;
    }

    public final boolean component5() {
        return this.isTranslateElement;
    }

    public final Integer component6() {
        return this.iconSize;
    }

    public final UDIconContentProps copy(String r9, String r10, String r11, String r12, boolean r13, Integer r14) {
        return new UDIconContentProps(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UDIconContentProps) == true) goto L8;
        return false;
    L8:
        UDIconContentProps r6 = (UDIconContentProps) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.customColor, r6.customColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageId, r6.imageId) == true) goto L21;
        return false;
    L21:
        if (this.isTranslateElement == r6.isTranslateElement) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconSize, r6.iconSize) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.token;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.color;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.customColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.imageId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.isTranslateElement == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        Integer r15 = this.iconSize;
        if (r15 == null) goto L27;
        r1 = r15.hashCode();
    L27:
        return r14 + r1;
    L21:
        r13 = 1237;
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

    public String toString() {
        return "UDIconContentProps(token=" + this.token + ", color=" + this.color + ", customColor=" + this.customColor + ", imageId=" + this.imageId + ", isTranslateElement=" + this.isTranslateElement + ", iconSize=" + this.iconSize + ')';
    }

    public final String getColor() {
        return this.color;
    }

    public final String getCustomColor() {
        return this.customColor;
    }

    public final Integer getIconSize() {
        return this.iconSize;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean isTranslateElement() {
        return this.isTranslateElement;
    }

    public UDIconContentProps(String r1, String r2, String r3, String r4, boolean r5, Integer r6) {
        this.token = r1;
        this.color = r2;
        this.customColor = r3;
        this.imageId = r4;
        this.isTranslateElement = r5;
        this.iconSize = r6;
    }

    public /* synthetic */ UDIconContentProps(String r5, String r6, String r7, String r8, boolean r9, Integer r10, int r11, DefaultConstructorMarker r12) {
        String r0 = null;
        if ((r11 & 1) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r11 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r11 & 8) != 0) goto L19;
        r0 = r8;
    L19:
        if ((r11 & 16) == 0) goto L21;
        boolean r3 = false;
    L23:
        if ((r11 & 32) == 0) goto L25;
        r10 = 0;
    L25:
        this(r13, r1, r2, r0, r3, r10);
        return;
    L21:
        r3 = r9;
        goto L23
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
