package com.obric.memory.uploadmemorystream.kotlin;

import com.bytedance.rpc.model.kotlin.UserParams;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memory/uploadmemorystream/kotlin/MemoryData;", "Ljava/io/Serializable;", "memoryStream", "", "Lcom/obric/memory/uploadmemorystream/kotlin/MemoryStreamItem;", "userParams", "Lcom/bytedance/rpc/model/kotlin/UserParams;", "(Ljava/util/List;Lcom/bytedance/rpc/model/kotlin/UserParams;)V", "getMemoryStream", "()Ljava/util/List;", "setMemoryStream", "(Ljava/util/List;)V", "getUserParams", "()Lcom/bytedance/rpc/model/kotlin/UserParams;", "setUserParams", "(Lcom/bytedance/rpc/model/kotlin/UserParams;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class MemoryData implements Serializable {

    @SerializedName("memory_stream")
    private List<MemoryStreamItem> memoryStream;

    @SerializedName("userParams")
    private UserParams userParams;

    public MemoryData(List<MemoryStreamItem> r3, UserParams r4) {
        List<MemoryStreamItem> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "memoryStream");
        Intrinsics.checkParameterIsNotNull(r4, "userParams");
        this.memoryStream = r5;
        this.userParams = r4;
    }

    public static /* synthetic */ MemoryData copy$default(MemoryData r1, List r2, UserParams r3, int r4, Object r5) {
        List<MemoryStreamItem> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.memoryStream;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.userParams;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<MemoryStreamItem> component1() {
        return this.memoryStream;
    }

    public final UserParams component2() {
        return this.userParams;
    }

    public final MemoryData copy(List<MemoryStreamItem> r2, UserParams r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r1, "memoryStream");
        Intrinsics.checkParameterIsNotNull(r3, "userParams");
        return new MemoryData(r1, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, MemoryData.class) == false) goto L11;
        MemoryData r4 = (MemoryData) ZeusTransformUtils.preCheckCast(r3, MemoryData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.memoryStream, r4.memoryStream) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.userParams, r4.userParams) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public final List<MemoryStreamItem> getMemoryStream() {
        return this.memoryStream;
    }

    public final UserParams getUserParams() {
        return this.userParams;
    }

    public int hashCode() {
        List<MemoryStreamItem> r0 = this.memoryStream;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        UserParams r4 = this.userParams;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setMemoryStream(List<MemoryStreamItem> r3) {
        List<MemoryStreamItem> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
        this.memoryStream = r4;
    }

    public final void setUserParams(UserParams r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.userParams = r2;
    }

    public String toString() {
        return "MemoryData(memoryStream=" + this.memoryStream + ", userParams=" + this.userParams + ")";
    }
}
