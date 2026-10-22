package com.bytedance.rpc.model.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J?\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/MockData;", "Ljava/io/Serializable;", "memoryKey", "Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;", "memoryType", "Lcom/bytedance/rpc/model/kotlin/MemoryType;", "dataType", "Lcom/bytedance/rpc/model/kotlin/DataType;", "memoryData", "", "Lcom/bytedance/rpc/model/kotlin/MemoryData;", "(Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;Lcom/bytedance/rpc/model/kotlin/MemoryType;Lcom/bytedance/rpc/model/kotlin/DataType;Ljava/util/List;)V", "getDataType", "()Lcom/bytedance/rpc/model/kotlin/DataType;", "setDataType", "(Lcom/bytedance/rpc/model/kotlin/DataType;)V", "getMemoryData", "()Ljava/util/List;", "setMemoryData", "(Ljava/util/List;)V", "getMemoryKey", "()Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;", "setMemoryKey", "(Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;)V", "getMemoryType", "()Lcom/bytedance/rpc/model/kotlin/MemoryType;", "setMemoryType", "(Lcom/bytedance/rpc/model/kotlin/MemoryType;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class MockData implements Serializable {

    @SerializedName("data_type")
    private DataType dataType;

    @SerializedName("memory_data")
    private List<MemoryData> memoryData;

    @SerializedName("memory_key")
    private DefinedMemoryKey memoryKey;

    @SerializedName("memory_type")
    private MemoryType memoryType;

    public MockData() {
        this(null, null, null, null, 15, null);
    }

    public MockData(DefinedMemoryKey r3, MemoryType r4, DataType r5, List<MemoryData> r6) {
        List<MemoryData> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.memoryKey = r3;
        this.memoryType = r4;
        this.dataType = r5;
        this.memoryData = r7;
    }

    public /* synthetic */ MockData(DefinedMemoryKey r3, MemoryType r4, DataType r5, List r6, int r7, DefaultConstructorMarker r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if ((r7 & 1) == 0) goto L6;
        r3 = (DefinedMemoryKey) ZeusTransformUtils.preCheckCast(null, DefinedMemoryKey.class, "com.obric.memorydata.plugin");
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = (MemoryType) ZeusTransformUtils.preCheckCast(null, MemoryType.class, "com.obric.memorydata.plugin");
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = (DataType) ZeusTransformUtils.preCheckCast(null, DataType.class, "com.obric.memorydata.plugin");
    L12:
        if ((r7 & 8) == 0) goto L14;
        r9 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
    L14:
        this(r3, r4, r5, r9);
    }

    public static /* synthetic */ MockData copy$default(MockData r1, DefinedMemoryKey r2, MemoryType r3, DataType r4, List r5, int r6, Object r7) {
        List<MemoryData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.memoryKey;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.memoryType;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.dataType;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.memoryData;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final DefinedMemoryKey component1() {
        return this.memoryKey;
    }

    public final MemoryType component2() {
        return this.memoryType;
    }

    public final DataType component3() {
        return this.dataType;
    }

    public final List<MemoryData> component4() {
        return this.memoryData;
    }

    public final MockData copy(DefinedMemoryKey r2, MemoryType r3, DataType r4, List<MemoryData> r5) {
        return new MockData(r2, r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, MockData.class) == false) goto L15;
        MockData r4 = (MockData) ZeusTransformUtils.preCheckCast(r3, MockData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.memoryKey, r4.memoryKey) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.memoryType, r4.memoryType) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.dataType, r4.dataType) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.memoryData, r4.memoryData) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        return false;
    }

    public final DataType getDataType() {
        return this.dataType;
    }

    public final List<MemoryData> getMemoryData() {
        return this.memoryData;
    }

    public final DefinedMemoryKey getMemoryKey() {
        return this.memoryKey;
    }

    public final MemoryType getMemoryType() {
        return this.memoryType;
    }

    public int hashCode() {
        DefinedMemoryKey r0 = this.memoryKey;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        MemoryType r4 = this.memoryType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        DataType r7 = this.dataType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<MemoryData> r10 = this.memoryData;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void setDataType(DataType r1) {
        this.dataType = r1;
    }

    public final void setMemoryData(List<MemoryData> r3) {
        this.memoryData = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setMemoryKey(DefinedMemoryKey r1) {
        this.memoryKey = r1;
    }

    public final void setMemoryType(MemoryType r1) {
        this.memoryType = r1;
    }

    public String toString() {
        return "MockData(memoryKey=" + this.memoryKey + ", memoryType=" + this.memoryType + ", dataType=" + this.dataType + ", memoryData=" + this.memoryData + ")";
    }
}
