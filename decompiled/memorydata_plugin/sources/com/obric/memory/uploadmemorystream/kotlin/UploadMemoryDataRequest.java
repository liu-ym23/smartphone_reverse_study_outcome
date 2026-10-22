package com.obric.memory.uploadmemorystream.kotlin;

import com.bytedance.rpc.model.kotlin.TTNetCommonParam;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;", "Ljava/io/Serializable;", "data", "Lcom/obric/memory/uploadmemorystream/kotlin/MemoryData;", "commonParam", "Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;", "(Lcom/obric/memory/uploadmemorystream/kotlin/MemoryData;Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;)V", "getCommonParam", "()Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;", "setCommonParam", "(Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;)V", "getData", "()Lcom/obric/memory/uploadmemorystream/kotlin/MemoryData;", "setData", "(Lcom/obric/memory/uploadmemorystream/kotlin/MemoryData;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class UploadMemoryDataRequest implements Serializable {

    @SerializedName("common_param")
    private TTNetCommonParam commonParam;

    @SerializedName("data")
    private MemoryData data;

    public UploadMemoryDataRequest(MemoryData r2, TTNetCommonParam r3) {
        Intrinsics.checkParameterIsNotNull(r2, "data");
        Intrinsics.checkParameterIsNotNull(r3, "commonParam");
        this.data = r2;
        this.commonParam = r3;
    }

    public static /* synthetic */ UploadMemoryDataRequest copy$default(UploadMemoryDataRequest r0, MemoryData r1, TTNetCommonParam r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.commonParam;
    L9:
        return r0.copy(r1, r2);
    }

    public final MemoryData component1() {
        return this.data;
    }

    public final TTNetCommonParam component2() {
        return this.commonParam;
    }

    public final UploadMemoryDataRequest copy(MemoryData r1, TTNetCommonParam r2) {
        Intrinsics.checkParameterIsNotNull(r1, "data");
        Intrinsics.checkParameterIsNotNull(r2, "commonParam");
        return new UploadMemoryDataRequest(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, UploadMemoryDataRequest.class) == false) goto L11;
        UploadMemoryDataRequest r4 = (UploadMemoryDataRequest) ZeusTransformUtils.preCheckCast(r3, UploadMemoryDataRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.commonParam, r4.commonParam) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public final TTNetCommonParam getCommonParam() {
        return this.commonParam;
    }

    public final MemoryData getData() {
        return this.data;
    }

    public int hashCode() {
        MemoryData r0 = this.data;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TTNetCommonParam r4 = this.commonParam;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setCommonParam(TTNetCommonParam r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.commonParam = r2;
    }

    public final void setData(MemoryData r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.data = r2;
    }

    public String toString() {
        return "UploadMemoryDataRequest(data=" + this.data + ", commonParam=" + this.commonParam + ")";
    }
}
