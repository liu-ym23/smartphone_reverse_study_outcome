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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R,\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/AddMockDataRequest;", "Ljava/io/Serializable;", "userParams", "Lcom/bytedance/rpc/model/kotlin/UserParams;", "mockDefinedFeatureValues", "", "Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;", "Lcom/bytedance/rpc/model/kotlin/MemoryItem;", "mockQueryFeatureValues", "", "(Lcom/bytedance/rpc/model/kotlin/UserParams;Ljava/util/Map;Ljava/util/List;)V", "getMockDefinedFeatureValues", "()Ljava/util/Map;", "setMockDefinedFeatureValues", "(Ljava/util/Map;)V", "getMockQueryFeatureValues", "()Ljava/util/List;", "setMockQueryFeatureValues", "(Ljava/util/List;)V", "getUserParams", "()Lcom/bytedance/rpc/model/kotlin/UserParams;", "setUserParams", "(Lcom/bytedance/rpc/model/kotlin/UserParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class AddMockDataRequest implements Serializable {

    @SerializedName("mock_defined_feature_values")
    private Map<DefinedMemoryKey, MemoryItem> mockDefinedFeatureValues;

    @SerializedName("mock_query_feature_values")
    private List<MemoryItem> mockQueryFeatureValues;

    @SerializedName("user_params")
    private UserParams userParams;

    public AddMockDataRequest() {
        this(null, null, null, 7, null);
    }

    public AddMockDataRequest(UserParams r3, Map<DefinedMemoryKey, MemoryItem> r4, List<MemoryItem> r5) {
        Map<DefinedMemoryKey, MemoryItem> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        List<MemoryItem> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.userParams = r3;
        this.mockDefinedFeatureValues = r6;
        this.mockQueryFeatureValues = r7;
    }

    public /* synthetic */ AddMockDataRequest(UserParams r3, Map r4, List r5, int r6, DefaultConstructorMarker r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r3 = (UserParams) ZeusTransformUtils.preCheckCast(null, UserParams.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = (Map) ZeusTransformUtils.preCheckCast(null, Map.class, "com.obric.memorydata.plugin");
    L9:
        if ((r6 & 4) == 0) goto L11;
        r9 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
    L11:
        this(r3, r8, r9);
    }

    public static /* synthetic */ AddMockDataRequest copy$default(AddMockDataRequest r1, UserParams r2, Map r3, List r4, int r5, Object r6) {
        Map<DefinedMemoryKey, MemoryItem> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List<MemoryItem> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.userParams;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.mockDefinedFeatureValues;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.mockQueryFeatureValues;
    L12:
        return r1.copy(r2, r7, r8);
    }

    public final UserParams component1() {
        return this.userParams;
    }

    public final Map<DefinedMemoryKey, MemoryItem> component2() {
        return this.mockDefinedFeatureValues;
    }

    public final List<MemoryItem> component3() {
        return this.mockQueryFeatureValues;
    }

    public final AddMockDataRequest copy(UserParams r2, Map<DefinedMemoryKey, MemoryItem> r3, List<MemoryItem> r4) {
        return new AddMockDataRequest(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, AddMockDataRequest.class) == false) goto L13;
        AddMockDataRequest r4 = (AddMockDataRequest) ZeusTransformUtils.preCheckCast(r3, AddMockDataRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.userParams, r4.userParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.mockDefinedFeatureValues, r4.mockDefinedFeatureValues) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.mockQueryFeatureValues, r4.mockQueryFeatureValues) == true) goto L20;
        return false;
    L20:
        return true;
    L13:
        return false;
    }

    public final Map<DefinedMemoryKey, MemoryItem> getMockDefinedFeatureValues() {
        return this.mockDefinedFeatureValues;
    }

    public final List<MemoryItem> getMockQueryFeatureValues() {
        return this.mockQueryFeatureValues;
    }

    public final UserParams getUserParams() {
        return this.userParams;
    }

    public int hashCode() {
        UserParams r0 = this.userParams;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<DefinedMemoryKey, MemoryItem> r4 = this.mockDefinedFeatureValues;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<MemoryItem> r7 = this.mockQueryFeatureValues;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void setMockDefinedFeatureValues(Map<DefinedMemoryKey, MemoryItem> r3) {
        this.mockDefinedFeatureValues = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final void setMockQueryFeatureValues(List<MemoryItem> r3) {
        this.mockQueryFeatureValues = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setUserParams(UserParams r1) {
        this.userParams = r1;
    }

    public String toString() {
        return "AddMockDataRequest(userParams=" + this.userParams + ", mockDefinedFeatureValues=" + this.mockDefinedFeatureValues + ", mockQueryFeatureValues=" + this.mockQueryFeatureValues + ")";
    }
}
