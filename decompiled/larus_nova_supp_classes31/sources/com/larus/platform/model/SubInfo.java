package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/platform/model/SubInfo;", "Ljava/io/Serializable;", "skuInfo", "Lcom/larus/platform/model/SKUInfo;", "startTime", "", "endTime", "tradePlatform", "", "<init>", "(Lcom/larus/platform/model/SKUInfo;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getSkuInfo", "()Lcom/larus/platform/model/SKUInfo;", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getTradePlatform", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/platform/model/SKUInfo;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/platform/model/SubInfo;", "equals", "", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SubInfo implements Serializable {

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("sku_info")
    private final SKUInfo skuInfo;

    @SerializedName("start_time")
    private final Long startTime;

    @SerializedName("trade_platform")
    private final Integer tradePlatform;

    public SubInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SubInfo copy$default(SubInfo r0, SKUInfo r1, Long r2, Long r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.skuInfo;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.startTime;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.endTime;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.tradePlatform;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final SKUInfo component1() {
        return this.skuInfo;
    }

    public final Long component2() {
        return this.startTime;
    }

    public final Long component3() {
        return this.endTime;
    }

    public final Integer component4() {
        return this.tradePlatform;
    }

    public final SubInfo copy(SKUInfo r2, Long r3, Long r4, Integer r5) {
        return new SubInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubInfo) == true) goto L8;
        return false;
    L8:
        SubInfo r6 = (SubInfo) r5;
        if (Intrinsics.areEqual(this.skuInfo, r6.skuInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tradePlatform, r6.tradePlatform) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        SKUInfo r0 = this.skuInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.startTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.endTime;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.tradePlatform;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "SubInfo(skuInfo=" + this.skuInfo + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", tradePlatform=" + this.tradePlatform + ')';
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final SKUInfo getSkuInfo() {
        return this.skuInfo;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Integer getTradePlatform() {
        return this.tradePlatform;
    }

    public SubInfo(SKUInfo r1, Long r2, Long r3, Integer r4) {
        this.skuInfo = r1;
        this.startTime = r2;
        this.endTime = r3;
        this.tradePlatform = r4;
    }

    public /* synthetic */ SubInfo(SKUInfo r2, Long r3, Long r4, Integer r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
