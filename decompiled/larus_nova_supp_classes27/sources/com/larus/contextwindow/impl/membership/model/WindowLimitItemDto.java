package com.larus.contextwindow.impl.membership.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003Jn\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/WindowLimitItemDto;", "", "windowType", "Lcom/google/gson/JsonElement;", "itemType", "usedPercent", "lessThanOnePercent", "", "usedAmount", "", "totalAmount", "endTime", "exemption", "Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "<init>", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;)V", "getWindowType", "()Lcom/google/gson/JsonElement;", "getItemType", "getUsedPercent", "getLessThanOnePercent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUsedAmount", "()Ljava/lang/String;", "getTotalAmount", "getEndTime", "getExemption", "()Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;)Lcom/larus/contextwindow/impl/membership/model/WindowLimitItemDto;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLimitItemDto {

    @SerializedName("end_time")
    private final JsonElement endTime;

    @SerializedName("exemption")
    private final WindowLimitExemptionDto exemption;

    @SerializedName("item_type")
    private final JsonElement itemType;

    @SerializedName("less_than_one_percent")
    private final Boolean lessThanOnePercent;

    @SerializedName("total_amount")
    private final String totalAmount;

    @SerializedName("used_amount")
    private final String usedAmount;

    @SerializedName("used_percent")
    private final JsonElement usedPercent;

    @SerializedName("window_type")
    private final JsonElement windowType;

    public WindowLimitItemDto() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ WindowLimitItemDto copy$default(WindowLimitItemDto r9, JsonElement r10, JsonElement r11, JsonElement r12, Boolean r13, String r14, String r15, JsonElement r16, WindowLimitExemptionDto r17, int r18, Object r110) {
        if ((r18 & 1) == 0) goto L5;
        JsonElement r2 = r9.windowType;
    L7:
        if ((r18 & 2) == 0) goto L9;
        JsonElement r3 = r9.itemType;
    L11:
        if ((r18 & 4) == 0) goto L13;
        JsonElement r4 = r9.usedPercent;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Boolean r5 = r9.lessThanOnePercent;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.usedAmount;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.totalAmount;
    L27:
        if ((r18 & 64) == 0) goto L29;
        JsonElement r8 = r9.endTime;
    L31:
        if ((r18 & 128) == 0) goto L33;
        WindowLimitExemptionDto r1 = r9.exemption;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final JsonElement component1() {
        return this.windowType;
    }

    public final JsonElement component2() {
        return this.itemType;
    }

    public final JsonElement component3() {
        return this.usedPercent;
    }

    public final Boolean component4() {
        return this.lessThanOnePercent;
    }

    public final String component5() {
        return this.usedAmount;
    }

    public final String component6() {
        return this.totalAmount;
    }

    public final JsonElement component7() {
        return this.endTime;
    }

    public final WindowLimitExemptionDto component8() {
        return this.exemption;
    }

    public final WindowLimitItemDto copy(JsonElement r11, JsonElement r12, JsonElement r13, Boolean r14, String r15, String r16, JsonElement r17, WindowLimitExemptionDto r18) {
        return new WindowLimitItemDto(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowLimitItemDto) == true) goto L8;
        return false;
    L8:
        WindowLimitItemDto r6 = (WindowLimitItemDto) r5;
        if (Intrinsics.areEqual(this.windowType, r6.windowType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemType, r6.itemType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.usedPercent, r6.usedPercent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lessThanOnePercent, r6.lessThanOnePercent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.usedAmount, r6.usedAmount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.totalAmount, r6.totalAmount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.exemption, r6.exemption) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        JsonElement r0 = this.windowType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        JsonElement r4 = this.itemType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        JsonElement r7 = this.usedPercent;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.lessThanOnePercent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.usedAmount;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.totalAmount;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        JsonElement r20 = this.endTime;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        WindowLimitExemptionDto r23 = this.exemption;
        if (r23 == null) goto L35;
        r1 = r23.hashCode();
    L35:
        return r22 + r1;
    L29:
        r21 = r20.hashCode();
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
        return "WindowLimitItemDto(windowType=" + this.windowType + ", itemType=" + this.itemType + ", usedPercent=" + this.usedPercent + ", lessThanOnePercent=" + this.lessThanOnePercent + ", usedAmount=" + this.usedAmount + ", totalAmount=" + this.totalAmount + ", endTime=" + this.endTime + ", exemption=" + this.exemption + ')';
    }

    public final JsonElement getEndTime() {
        return this.endTime;
    }

    public final WindowLimitExemptionDto getExemption() {
        return this.exemption;
    }

    public final JsonElement getItemType() {
        return this.itemType;
    }

    public final Boolean getLessThanOnePercent() {
        return this.lessThanOnePercent;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final String getUsedAmount() {
        return this.usedAmount;
    }

    public final JsonElement getUsedPercent() {
        return this.usedPercent;
    }

    public final JsonElement getWindowType() {
        return this.windowType;
    }

    public WindowLimitItemDto(JsonElement r1, JsonElement r2, JsonElement r3, Boolean r4, String r5, String r6, JsonElement r7, WindowLimitExemptionDto r8) {
        this.windowType = r1;
        this.itemType = r2;
        this.usedPercent = r3;
        this.lessThanOnePercent = r4;
        this.usedAmount = r5;
        this.totalAmount = r6;
        this.endTime = r7;
        this.exemption = r8;
    }

    public /* synthetic */ WindowLimitItemDto(JsonElement r10, JsonElement r11, JsonElement r12, Boolean r13, String r14, String r15, JsonElement r16, WindowLimitExemptionDto r17, int r18, DefaultConstructorMarker r110) {
        WindowLimitExemptionDto r2 = null;
        if ((r18 & 1) == 0) goto L5;
        JsonElement r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        JsonElement r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        JsonElement r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Boolean r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        JsonElement r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
