package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0086\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00062"}, d2 = {"Lcom/larus/platform/model/SKUInfo;", "Ljava/io/Serializable;", "id", "", "name", "currency", "amount", "", "discount", "Lcom/larus/platform/model/SKUDiscountInfo;", "tip", "buttonText", "buttonTipText", "periodName", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/larus/platform/model/SKUDiscountInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCurrency", "getAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDiscount", "()Lcom/larus/platform/model/SKUDiscountInfo;", "getTip", "getButtonText", "getButtonTipText", "getPeriodName", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/larus/platform/model/SKUDiscountInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/SKUInfo;", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SKUInfo implements Serializable {

    @SerializedName("amount")
    private final Double amount;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("button_tip_text")
    private final String buttonTipText;

    @SerializedName("currency")
    private final String currency;

    @SerializedName("discount")
    private final SKUDiscountInfo discount;

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName("period_name")
    private final String periodName;

    @SerializedName("tip")
    private final String tip;

    @SerializedName("version")
    private final String version;

    public SKUInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ SKUInfo copy$default(SKUInfo r11, String r12, String r13, String r14, Double r15, SKUDiscountInfo r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.id;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.name;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.currency;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Double r5 = r11.amount;
    L19:
        if ((r22 & 16) == 0) goto L21;
        SKUDiscountInfo r6 = r11.discount;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.tip;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.buttonText;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.buttonTipText;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.periodName;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.version;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.version;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.currency;
    }

    public final Double component4() {
        return this.amount;
    }

    public final SKUDiscountInfo component5() {
        return this.discount;
    }

    public final String component6() {
        return this.tip;
    }

    public final String component7() {
        return this.buttonText;
    }

    public final String component8() {
        return this.buttonTipText;
    }

    public final String component9() {
        return this.periodName;
    }

    public final SKUInfo copy(String r13, String r14, String r15, Double r16, SKUDiscountInfo r17, String r18, String r19, String r20, String r21, String r22) {
        return new SKUInfo(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SKUInfo) == true) goto L8;
        return false;
    L8:
        SKUInfo r6 = (SKUInfo) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currency, r6.currency) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.amount, r6.amount) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.discount, r6.discount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tip, r6.tip) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.buttonText, r6.buttonText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buttonTipText, r6.buttonTipText) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.periodName, r6.periodName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.currency;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.amount;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        SKUDiscountInfo r13 = this.discount;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.tip;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.buttonText;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.buttonTipText;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.periodName;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.version;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
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
        return "SKUInfo(id=" + this.id + ", name=" + this.name + ", currency=" + this.currency + ", amount=" + this.amount + ", discount=" + this.discount + ", tip=" + this.tip + ", buttonText=" + this.buttonText + ", buttonTipText=" + this.buttonTipText + ", periodName=" + this.periodName + ", version=" + this.version + ')';
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getButtonTipText() {
        return this.buttonTipText;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final SKUDiscountInfo getDiscount() {
        return this.discount;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPeriodName() {
        return this.periodName;
    }

    public final String getTip() {
        return this.tip;
    }

    public final String getVersion() {
        return this.version;
    }

    public SKUInfo(String r1, String r2, String r3, Double r4, SKUDiscountInfo r5, String r6, String r7, String r8, String r9, String r10) {
        this.id = r1;
        this.name = r2;
        this.currency = r3;
        this.amount = r4;
        this.discount = r5;
        this.tip = r6;
        this.buttonText = r7;
        this.buttonTipText = r8;
        this.periodName = r9;
        this.version = r10;
    }

    public /* synthetic */ SKUInfo(String r12, String r13, String r14, Double r15, SKUDiscountInfo r16, String r17, String r18, String r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Double r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        SKUDiscountInfo r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
