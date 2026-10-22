package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0086\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "Ljava/io/Serializable;", a.KEY_SHOPPING_GUIDE_NAME, "", "specType", "", "specItems", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfoItem;", "sizeComponent", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "hideSpec", "", "defaultSelect", "showBigPic", "showSmallPic", "extraAttribute", "Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;", "specMode", "(Ljava/lang/String;ILjava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;Ljava/lang/Integer;)V", "getDefaultSelect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtraAttribute", "()Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;", "getHideSpec", "getName", "()Ljava/lang/String;", "getShowBigPic", "getShowSmallPic", "getSizeComponent", "()Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "getSpecItems", "()Ljava/util/List;", "getSpecMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSpecType", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;Ljava/lang/Integer;)Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "equals", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecInfo implements Serializable {

    @SerializedName("default_select")
    private final Boolean defaultSelect;

    @SerializedName("extra_attribute")
    private final ExtraAttribute extraAttribute;

    @SerializedName("hide_spec")
    private final Boolean hideSpec;

    @SerializedName(a.KEY_SHOPPING_GUIDE_NAME)
    private final String name;

    @SerializedName("show_big_pic")
    private final Boolean showBigPic;

    @SerializedName("show_small_pic")
    private final Boolean showSmallPic;

    @SerializedName("size_component")
    private final SpecChartStruct sizeComponent;

    @SerializedName("spec_items")
    private final List<SpecInfoItem> specItems;

    @SerializedName("spec_mode")
    private final Integer specMode;

    @SerializedName("spec_type")
    private final int specType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpecInfo copy$default(SpecInfo r11, String r12, int r13, List r14, SpecChartStruct r15, Boolean r16, Boolean r17, Boolean r18, Boolean r19, ExtraAttribute r20, Integer r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r10 = r11.name;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r24 = r11.specType;
    L11:
        if ((r22 & 4) == 0) goto L13;
        List r25 = r11.specItems;
    L15:
        if ((r22 & 8) == 0) goto L17;
        SpecChartStruct r26 = r11.sizeComponent;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Boolean r27 = r11.hideSpec;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Boolean r28 = r11.defaultSelect;
    L27:
        if ((r22 & 64) == 0) goto L29;
        Boolean r29 = r11.showBigPic;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Boolean r30 = r11.showSmallPic;
    L35:
        if ((r22 & 256) == 0) goto L37;
        ExtraAttribute r110 = r11.extraAttribute;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Integer r1 = r11.specMode;
    L43:
        return r11.copy(r10, r24, r25, r26, r27, r28, r29, r30, r110, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r110 = r20;
        goto L39
    L33:
        r30 = r19;
        goto L35
    L29:
        r29 = r18;
        goto L31
    L25:
        r28 = r17;
        goto L27
    L21:
        r27 = r16;
        goto L23
    L17:
        r26 = r15;
        goto L19
    L13:
        r25 = r14;
        goto L15
    L9:
        r24 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component10() {
        return this.specMode;
    }

    public final int component2() {
        return this.specType;
    }

    public final List<SpecInfoItem> component3() {
        return this.specItems;
    }

    public final SpecChartStruct component4() {
        return this.sizeComponent;
    }

    public final Boolean component5() {
        return this.hideSpec;
    }

    public final Boolean component6() {
        return this.defaultSelect;
    }

    public final Boolean component7() {
        return this.showBigPic;
    }

    public final Boolean component8() {
        return this.showSmallPic;
    }

    public final ExtraAttribute component9() {
        return this.extraAttribute;
    }

    public final SpecInfo copy(String r13, int r14, List<SpecInfoItem> r15, SpecChartStruct r16, Boolean r17, Boolean r18, Boolean r19, Boolean r20, ExtraAttribute r21, Integer r22) {
        Intrinsics.checkNotNullParameter(r13, a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r15, "specItems");
        return new SpecInfo(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SpecInfo) == false) goto L26;
        SpecInfo r11 = (SpecInfo) r10;
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L8;
        return false;
    L8:
        if (this.specType == r11.specType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.specItems, r11.specItems) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sizeComponent, r11.sizeComponent) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hideSpec, r11.hideSpec) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultSelect, r11.defaultSelect) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showBigPic, r11.showBigPic) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.showSmallPic, r11.showSmallPic) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extraAttribute, r11.extraAttribute) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.specMode, r11.specMode) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = ((r10 * 31) + this.specType) * 31;
        List<SpecInfoItem> r12 = this.specItems;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        SpecChartStruct r15 = this.sizeComponent;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.hideSpec;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Boolean r21 = this.defaultSelect;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        Boolean r24 = this.showBigPic;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        Boolean r27 = this.showSmallPic;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        ExtraAttribute r30 = this.extraAttribute;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        Integer r33 = this.specMode;
        if (r33 == null) goto L38;
        r1 = r33.hashCode();
    L38:
        return r32 + r1;
    L33:
        r31 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "SpecInfo(name=" + this.name + ", specType=" + this.specType + ", specItems=" + this.specItems + ", sizeComponent=" + this.sizeComponent + ", hideSpec=" + this.hideSpec + ", defaultSelect=" + this.defaultSelect + ", showBigPic=" + this.showBigPic + ", showSmallPic=" + this.showSmallPic + ", extraAttribute=" + this.extraAttribute + ", specMode=" + this.specMode + ")";
    }

    public final Boolean getDefaultSelect() {
        return this.defaultSelect;
    }

    public final ExtraAttribute getExtraAttribute() {
        return this.extraAttribute;
    }

    public final Boolean getHideSpec() {
        return this.hideSpec;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getShowBigPic() {
        return this.showBigPic;
    }

    public final Boolean getShowSmallPic() {
        return this.showSmallPic;
    }

    public final SpecChartStruct getSizeComponent() {
        return this.sizeComponent;
    }

    public final List<SpecInfoItem> getSpecItems() {
        return this.specItems;
    }

    public final Integer getSpecMode() {
        return this.specMode;
    }

    public final int getSpecType() {
        return this.specType;
    }

    public SpecInfo(String r10, int r11, List<SpecInfoItem> r12, SpecChartStruct r13, Boolean r14, Boolean r15, Boolean r16, Boolean r17, ExtraAttribute r18, Integer r19) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r12, "specItems");
        this.name = r10;
        this.specType = r11;
        this.specItems = r12;
        this.sizeComponent = r13;
        this.hideSpec = r14;
        this.defaultSelect = r15;
        this.showBigPic = r16;
        this.showSmallPic = r17;
        this.extraAttribute = r18;
        this.specMode = r19;
    }

    public /* synthetic */ SpecInfo(String r15, int r16, List r17, SpecChartStruct r18, Boolean r19, Boolean r20, Boolean r21, Boolean r22, ExtraAttribute r23, Integer r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 8) == 0) goto L5;
        SpecChartStruct r10 = null;
    L7:
        if ((r25 & 16) == 0) goto L9;
        Boolean r11 = null;
    L11:
        if ((r25 & 32) == 0) goto L13;
        Boolean r12 = null;
    L15:
        if ((r25 & 64) == 0) goto L17;
        Boolean r13 = Boolean.FALSE;
    L19:
        if ((r25 & 128) == 0) goto L21;
        Boolean r14 = Boolean.FALSE;
    L23:
        if ((r25 & 256) == 0) goto L25;
        ExtraAttribute r110 = null;
    L27:
        if ((r25 & 512) == 0) goto L29;
        Integer r111 = 2;
    L30:
        this(r15, r16, r17, r10, r11, r12, r13, r14, r110, r111);
        return;
    L29:
        r111 = r24;
        goto L30
    L25:
        r110 = r23;
        goto L27
    L21:
        r14 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }
}
