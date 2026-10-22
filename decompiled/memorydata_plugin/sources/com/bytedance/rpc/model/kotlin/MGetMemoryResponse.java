package com.bytedance.rpc.model.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R,\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/MGetMemoryResponse;", "Ljava/io/Serializable;", "definedFeatureValues", "", "Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;", "Lcom/bytedance/rpc/model/kotlin/MemoryItem;", "queryFeatureValues", "", "(Ljava/util/Map;Ljava/util/List;)V", "getDefinedFeatureValues", "()Ljava/util/Map;", "setDefinedFeatureValues", "(Ljava/util/Map;)V", "getQueryFeatureValues", "()Ljava/util/List;", "setQueryFeatureValues", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class MGetMemoryResponse implements Serializable {

    @SerializedName("defined_feature_values")
    private Map<DefinedMemoryKey, MemoryItem> definedFeatureValues;

    @SerializedName("query_feature_values")
    private List<MemoryItem> queryFeatureValues;

    /* JADX WARN: Multi-variable type inference failed */
    public MGetMemoryResponse() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public MGetMemoryResponse(Map<DefinedMemoryKey, MemoryItem> r3, List<MemoryItem> r4) {
        Map<DefinedMemoryKey, MemoryItem> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List<MemoryItem> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.definedFeatureValues = r5;
        this.queryFeatureValues = r6;
    }

    public /* synthetic */ MGetMemoryResponse(Map r3, List r4, int r5, DefaultConstructorMarker r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = (Map) ZeusTransformUtils.preCheckCast(null, Map.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r8 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
    L8:
        this(r7, r8);
    }

    public static /* synthetic */ MGetMemoryResponse copy$default(MGetMemoryResponse r1, Map r2, List r3, int r4, Object r5) {
        Map<DefinedMemoryKey, MemoryItem> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        List<MemoryItem> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.definedFeatureValues;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.queryFeatureValues;
    L9:
        return r1.copy(r6, r7);
    }

    public final Map<DefinedMemoryKey, MemoryItem> component1() {
        return this.definedFeatureValues;
    }

    public final List<MemoryItem> component2() {
        return this.queryFeatureValues;
    }

    public final MGetMemoryResponse copy(Map<DefinedMemoryKey, MemoryItem> r2, List<MemoryItem> r3) {
        return new MGetMemoryResponse((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, MGetMemoryResponse.class) == false) goto L11;
        MGetMemoryResponse r4 = (MGetMemoryResponse) ZeusTransformUtils.preCheckCast(r3, MGetMemoryResponse.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.definedFeatureValues, r4.definedFeatureValues) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.queryFeatureValues, r4.queryFeatureValues) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public final Map<DefinedMemoryKey, MemoryItem> getDefinedFeatureValues() {
        return this.definedFeatureValues;
    }

    public final List<MemoryItem> getQueryFeatureValues() {
        return this.queryFeatureValues;
    }

    public int hashCode() {
        Map<DefinedMemoryKey, MemoryItem> r0 = this.definedFeatureValues;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<MemoryItem> r4 = this.queryFeatureValues;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setDefinedFeatureValues(Map<DefinedMemoryKey, MemoryItem> r3) {
        this.definedFeatureValues = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final void setQueryFeatureValues(List<MemoryItem> r3) {
        this.queryFeatureValues = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return "MGetMemoryResponse(definedFeatureValues=" + this.definedFeatureValues + ", queryFeatureValues=" + this.queryFeatureValues + ")";
    }
}
