package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "Ljava/io/Serializable;", "specLocation", "", "sizeComponent", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "hasSizeComponent", "", "isFillUserClothesSize", "isSupportClothesSizeRecommend", "recommendClothesSize", "", "linkSchema", "abTest", "recommendText", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAbTest", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasSizeComponent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLinkSchema", "()Ljava/lang/String;", "getRecommendClothesSize", "getRecommendText", "getSizeComponent", "()Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "getSpecLocation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "equals", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClothesSizeAssistantStruct implements Serializable {

    @SerializedName("ab_test")
    private final Integer abTest;

    @SerializedName("has_size_component")
    private final Boolean hasSizeComponent;

    @SerializedName("is_fill_user_clothes_size")
    private final Boolean isFillUserClothesSize;

    @SerializedName("is_support_clothes_size_recommend")
    private final Boolean isSupportClothesSizeRecommend;

    @SerializedName("link_schema")
    private final String linkSchema;

    @SerializedName("recommend_clothes_size")
    private final String recommendClothesSize;

    @SerializedName("recommend_text")
    private final String recommendText;

    @SerializedName("size_component")
    private final SpecChartStruct sizeComponent;

    @SerializedName("spec_location")
    private final Integer specLocation;

    public ClothesSizeAssistantStruct() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ ClothesSizeAssistantStruct copy$default(ClothesSizeAssistantStruct r10, Integer r11, SpecChartStruct r12, Boolean r13, Boolean r14, Boolean r15, String r16, String r17, Integer r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Integer r22 = r10.specLocation;
    L7:
        if ((r20 & 2) == 0) goto L9;
        SpecChartStruct r23 = r10.sizeComponent;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Boolean r24 = r10.hasSizeComponent;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Boolean r25 = r10.isFillUserClothesSize;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Boolean r26 = r10.isSupportClothesSizeRecommend;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r27 = r10.recommendClothesSize;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r28 = r10.linkSchema;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Integer r29 = r10.abTest;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.recommendText;
    L39:
        return r10.copy(r22, r23, r24, r25, r26, r27, r28, r29, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r29 = r18;
        goto L35
    L29:
        r28 = r17;
        goto L31
    L25:
        r27 = r16;
        goto L27
    L21:
        r26 = r15;
        goto L23
    L17:
        r25 = r14;
        goto L19
    L13:
        r24 = r13;
        goto L15
    L9:
        r23 = r12;
        goto L11
    L5:
        r22 = r11;
        goto L7
    }

    public final Integer component1() {
        return this.specLocation;
    }

    public final SpecChartStruct component2() {
        return this.sizeComponent;
    }

    public final Boolean component3() {
        return this.hasSizeComponent;
    }

    public final Boolean component4() {
        return this.isFillUserClothesSize;
    }

    public final Boolean component5() {
        return this.isSupportClothesSizeRecommend;
    }

    public final String component6() {
        return this.recommendClothesSize;
    }

    public final String component7() {
        return this.linkSchema;
    }

    public final Integer component8() {
        return this.abTest;
    }

    public final String component9() {
        return this.recommendText;
    }

    public final ClothesSizeAssistantStruct copy(Integer r12, SpecChartStruct r13, Boolean r14, Boolean r15, Boolean r16, String r17, String r18, Integer r19, String r20) {
        return new ClothesSizeAssistantStruct(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ClothesSizeAssistantStruct) == false) goto L24;
        ClothesSizeAssistantStruct r11 = (ClothesSizeAssistantStruct) r10;
        if (Intrinsics.areEqual(this.specLocation, r11.specLocation) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sizeComponent, r11.sizeComponent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hasSizeComponent, r11.hasSizeComponent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFillUserClothesSize, r11.isFillUserClothesSize) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isSupportClothesSizeRecommend, r11.isSupportClothesSizeRecommend) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.recommendClothesSize, r11.recommendClothesSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.linkSchema, r11.linkSchema) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.abTest, r11.abTest) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.recommendText, r11.recommendText) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.specLocation;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        SpecChartStruct r12 = this.sizeComponent;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Boolean r15 = this.hasSizeComponent;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.isFillUserClothesSize;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Boolean r21 = this.isSupportClothesSizeRecommend;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.recommendClothesSize;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        String r27 = this.linkSchema;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        Integer r30 = this.abTest;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        String r33 = this.recommendText;
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
        return "ClothesSizeAssistantStruct(specLocation=" + this.specLocation + ", sizeComponent=" + this.sizeComponent + ", hasSizeComponent=" + this.hasSizeComponent + ", isFillUserClothesSize=" + this.isFillUserClothesSize + ", isSupportClothesSizeRecommend=" + this.isSupportClothesSizeRecommend + ", recommendClothesSize=" + this.recommendClothesSize + ", linkSchema=" + this.linkSchema + ", abTest=" + this.abTest + ", recommendText=" + this.recommendText + ")";
    }

    public final Integer getAbTest() {
        return this.abTest;
    }

    public final Boolean getHasSizeComponent() {
        return this.hasSizeComponent;
    }

    public final String getLinkSchema() {
        return this.linkSchema;
    }

    public final String getRecommendClothesSize() {
        return this.recommendClothesSize;
    }

    public final String getRecommendText() {
        return this.recommendText;
    }

    public final SpecChartStruct getSizeComponent() {
        return this.sizeComponent;
    }

    public final Integer getSpecLocation() {
        return this.specLocation;
    }

    public final Boolean isFillUserClothesSize() {
        return this.isFillUserClothesSize;
    }

    public final Boolean isSupportClothesSizeRecommend() {
        return this.isSupportClothesSizeRecommend;
    }

    public ClothesSizeAssistantStruct(Integer r1, SpecChartStruct r10, Boolean r11, Boolean r12, Boolean r13, String r14, String r15, Integer r16, String r17) {
        this.specLocation = r1;
        this.sizeComponent = r10;
        this.hasSizeComponent = r11;
        this.isFillUserClothesSize = r12;
        this.isSupportClothesSizeRecommend = r13;
        this.recommendClothesSize = r14;
        this.linkSchema = r15;
        this.abTest = r16;
        this.recommendText = r17;
    }

    public /* synthetic */ ClothesSizeAssistantStruct(Integer r11, SpecChartStruct r12, Boolean r13, Boolean r14, Boolean r15, String r16, String r17, Integer r18, String r19, int r20, DefaultConstructorMarker r21) {
        String r10 = null;
        if ((r20 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        SpecChartStruct r22 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Boolean r23 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Boolean r24 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Boolean r25 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r26 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r27 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Integer r28 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r10 = r19;
    L38:
        this(r1, r22, r23, r24, r25, r26, r27, r28, r10);
        return;
    L33:
        r28 = r18;
        goto L35
    L29:
        r27 = r17;
        goto L31
    L25:
        r26 = r16;
        goto L27
    L21:
        r25 = r15;
        goto L23
    L17:
        r24 = r14;
        goto L19
    L13:
        r23 = r13;
        goto L15
    L9:
        r22 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
