package com.obric.memorydata.init.tasks.pitaya;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/init/tasks/pitaya/BridgeData;", "", "protocol", "", "version", "", "apiInfo", "Lcom/obric/memorydata/init/tasks/pitaya/APIInfo;", "<init>", "(Ljava/lang/String;ILcom/obric/memorydata/init/tasks/pitaya/APIInfo;)V", "getProtocol", "()Ljava/lang/String;", "getVersion", "()I", "getApiInfo", "()Lcom/obric/memorydata/init/tasks/pitaya/APIInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BridgeData {

    @SerializedName("body")
    private final APIInfo apiInfo;
    private final String protocol;
    private final int version;

    public BridgeData(String r2, int r3, APIInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "protocol");
        Intrinsics.checkNotNullParameter(r4, "apiInfo");
        this.protocol = r2;
        this.version = r3;
        this.apiInfo = r4;
    }

    public static /* synthetic */ BridgeData copy$default(BridgeData r0, String r1, int r2, APIInfo r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.protocol;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.version;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.apiInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.protocol;
    }

    public final int component2() {
        return this.version;
    }

    public final APIInfo component3() {
        return this.apiInfo;
    }

    public final BridgeData copy(String r1, int r2, APIInfo r3) {
        Intrinsics.checkNotNullParameter(r1, "protocol");
        Intrinsics.checkNotNullParameter(r3, "apiInfo");
        return new BridgeData(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BridgeData.class) == true) goto L8;
        return false;
    L8:
        BridgeData r6 = (BridgeData) ZeusTransformUtils.preCheckCast(r5, BridgeData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.protocol, r6.protocol) == true) goto L12;
        return false;
    L12:
        if (this.version == r6.version) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.apiInfo, r6.apiInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final APIInfo getApiInfo() {
        return this.apiInfo;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.protocol.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.apiInfo.hashCode();
    }

    public String toString() {
        return "BridgeData(protocol=" + this.protocol + ", version=" + this.version + ", apiInfo=" + this.apiInfo + ')';
    }
}
