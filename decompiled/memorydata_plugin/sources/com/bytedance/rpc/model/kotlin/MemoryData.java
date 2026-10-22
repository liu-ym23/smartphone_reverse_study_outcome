package com.bytedance.rpc.model.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/MemoryData;", "Ljava/io/Serializable;", "dataValue", "", "confidence", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "getConfidence", "()Ljava/lang/Double;", "setConfidence", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getDataValue", "()Ljava/lang/String;", "setDataValue", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/bytedance/rpc/model/kotlin/MemoryData;", "equals", "", "other", "", "hashCode", "", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class MemoryData implements Serializable {

    @SerializedName("confidence")
    private Double confidence;

    @SerializedName("data_value")
    private String dataValue;

    /* JADX WARN: Multi-variable type inference failed */
    public MemoryData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public MemoryData(String r1, Double r2) {
        this.dataValue = r1;
        this.confidence = r2;
    }

    public /* synthetic */ MemoryData(String r3, Double r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = (Double) ZeusTransformUtils.preCheckCast(null, Double.class, "com.obric.memorydata.plugin");
    L8:
        this(r3, r4);
    }

    public static /* synthetic */ MemoryData copy$default(MemoryData r0, String r1, Double r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.dataValue;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.confidence;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.dataValue;
    }

    public final Double component2() {
        return this.confidence;
    }

    public final MemoryData copy(String r1, Double r2) {
        return new MemoryData(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, MemoryData.class) == false) goto L11;
        MemoryData r4 = (MemoryData) ZeusTransformUtils.preCheckCast(r3, MemoryData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.dataValue, r4.dataValue) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.confidence, r4.confidence) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public final Double getConfidence() {
        return this.confidence;
    }

    public final String getDataValue() {
        return this.dataValue;
    }

    public int hashCode() {
        String r0 = this.dataValue;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.confidence;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setConfidence(Double r1) {
        this.confidence = r1;
    }

    public final void setDataValue(String r1) {
        this.dataValue = r1;
    }

    public String toString() {
        return "MemoryData(dataValue=" + this.dataValue + ", confidence=" + this.confidence + ")";
    }
}
