package com.bytedance.rpc.model.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003JP\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/MemoryItem;", "Ljava/io/Serializable;", "itemId", "", "memoryKey", "", "memoryType", "Lcom/bytedance/rpc/model/kotlin/MemoryType;", "dataType", "Lcom/bytedance/rpc/model/kotlin/DataType;", "memoryData", "", "Lcom/bytedance/rpc/model/kotlin/MemoryData;", "(Ljava/lang/Long;Ljava/lang/String;Lcom/bytedance/rpc/model/kotlin/MemoryType;Lcom/bytedance/rpc/model/kotlin/DataType;Ljava/util/List;)V", "getDataType", "()Lcom/bytedance/rpc/model/kotlin/DataType;", "setDataType", "(Lcom/bytedance/rpc/model/kotlin/DataType;)V", "getItemId", "()Ljava/lang/Long;", "setItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMemoryData", "()Ljava/util/List;", "setMemoryData", "(Ljava/util/List;)V", "getMemoryKey", "()Ljava/lang/String;", "setMemoryKey", "(Ljava/lang/String;)V", "getMemoryType", "()Lcom/bytedance/rpc/model/kotlin/MemoryType;", "setMemoryType", "(Lcom/bytedance/rpc/model/kotlin/MemoryType;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/bytedance/rpc/model/kotlin/MemoryType;Lcom/bytedance/rpc/model/kotlin/DataType;Ljava/util/List;)Lcom/bytedance/rpc/model/kotlin/MemoryItem;", "equals", "", "other", "", "hashCode", "", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class MemoryItem implements Serializable {

    @SerializedName("data_type")
    private DataType dataType;

    @SerializedName("item_id")
    private Long itemId;

    @SerializedName("memory_data")
    private List<MemoryData> memoryData;

    @SerializedName("memory_key")
    private String memoryKey;

    @SerializedName("memory_type")
    private MemoryType memoryType;

    public MemoryItem() {
        this(null, null, null, null, null, 31, null);
    }

    public MemoryItem(Long r3, String r4, MemoryType r5, DataType r6, List<MemoryData> r7) {
        List<MemoryData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.itemId = r3;
        this.memoryKey = r4;
        this.memoryType = r5;
        this.dataType = r6;
        this.memoryData = r8;
    }

    public /* synthetic */ MemoryItem(Long r9, String r10, MemoryType r11, DataType r12, List r13, int r14, DefaultConstructorMarker r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r9 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
    L5:
        Long r3 = r9;
        if ((r14 & 2) == 0) goto L8;
        r10 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L8:
        String r4 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = (MemoryType) ZeusTransformUtils.preCheckCast(null, MemoryType.class, "com.obric.memorydata.plugin");
    L11:
        MemoryType r5 = r11;
        if ((r14 & 8) == 0) goto L14;
        r12 = (DataType) ZeusTransformUtils.preCheckCast(null, DataType.class, "com.obric.memorydata.plugin");
    L14:
        DataType r6 = r12;
        if ((r14 & 16) == 0) goto L17;
        r16 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
    L17:
        this(r3, r4, r5, r6, r16);
    }

    public static /* synthetic */ MemoryItem copy$default(MemoryItem r6, Long r7, String r8, MemoryType r9, DataType r10, List r11, int r12, Object r13) {
        List<MemoryData> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.itemId;
    L5:
        Long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.memoryKey;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.memoryType;
    L11:
        MemoryType r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.dataType;
    L14:
        DataType r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.memoryData;
    L18:
        return r6.copy(r1, r2, r3, r4, r14);
    }

    public final Long component1() {
        return this.itemId;
    }

    public final String component2() {
        return this.memoryKey;
    }

    public final MemoryType component3() {
        return this.memoryType;
    }

    public final DataType component4() {
        return this.dataType;
    }

    public final List<MemoryData> component5() {
        return this.memoryData;
    }

    public final MemoryItem copy(Long r7, String r8, MemoryType r9, DataType r10, List<MemoryData> r11) {
        return new MemoryItem(r7, r8, r9, r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, MemoryItem.class) == false) goto L17;
        MemoryItem r4 = (MemoryItem) ZeusTransformUtils.preCheckCast(r3, MemoryItem.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.memoryKey, r4.memoryKey) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.memoryType, r4.memoryType) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.dataType, r4.dataType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.memoryData, r4.memoryData) == true) goto L26;
        return false;
    L26:
        return true;
    L17:
        return false;
    }

    public final DataType getDataType() {
        return this.dataType;
    }

    public final Long getItemId() {
        return this.itemId;
    }

    public final List<MemoryData> getMemoryData() {
        return this.memoryData;
    }

    public final String getMemoryKey() {
        return this.memoryKey;
    }

    public final MemoryType getMemoryType() {
        return this.memoryType;
    }

    public int hashCode() {
        Long r0 = this.itemId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.memoryKey;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        MemoryType r7 = this.memoryType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        DataType r10 = this.dataType;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<MemoryData> r13 = this.memoryData;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
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

    public final void setItemId(Long r1) {
        this.itemId = r1;
    }

    public final void setMemoryData(List<MemoryData> r3) {
        this.memoryData = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setMemoryKey(String r1) {
        this.memoryKey = r1;
    }

    public final void setMemoryType(MemoryType r1) {
        this.memoryType = r1;
    }

    public String toString() {
        return "MemoryItem(itemId=" + this.itemId + ", memoryKey=" + this.memoryKey + ", memoryType=" + this.memoryType + ", dataType=" + this.dataType + ", memoryData=" + this.memoryData + ")";
    }
}
