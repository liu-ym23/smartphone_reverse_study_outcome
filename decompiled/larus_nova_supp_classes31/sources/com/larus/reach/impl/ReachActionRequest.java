package com.larus.reach.impl;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/larus/reach/impl/ReachActionRequest;", "", "bizReqPsm", "", "bizReqId", "fromSource", "", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBizReqPsm", "()Ljava/lang/String;", "getBizReqId", "getFromSource", "()I", "getParams", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final class ReachActionRequest {

    @SerializedName("biz_req_id")
    private final String bizReqId;

    @SerializedName("biz_req_psm")
    private final String bizReqPsm;

    @SerializedName("from_source")
    private final int fromSource;

    @SerializedName("params")
    private final String params;

    public ReachActionRequest() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ ReachActionRequest copy$default(ReachActionRequest r0, String r1, String r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.bizReqPsm;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.bizReqId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.fromSource;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.params;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.bizReqPsm;
    }

    public final String component2() {
        return this.bizReqId;
    }

    public final int component3() {
        return this.fromSource;
    }

    public final String component4() {
        return this.params;
    }

    public final ReachActionRequest copy(String r2, String r3, int r4, String r5) {
        return new ReachActionRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReachActionRequest) == true) goto L8;
        return false;
    L8:
        ReachActionRequest r6 = (ReachActionRequest) r5;
        if (Intrinsics.areEqual(this.bizReqPsm, r6.bizReqPsm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizReqId, r6.bizReqId) == true) goto L15;
        return false;
    L15:
        if (this.fromSource == r6.fromSource) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.bizReqPsm;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bizReqId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.fromSource) * 31;
        String r7 = this.params;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ReachActionRequest(bizReqPsm=" + this.bizReqPsm + ", bizReqId=" + this.bizReqId + ", fromSource=" + this.fromSource + ", params=" + this.params + ')';
    }

    public final String getBizReqId() {
        return this.bizReqId;
    }

    public final String getBizReqPsm() {
        return this.bizReqPsm;
    }

    public final int getFromSource() {
        return this.fromSource;
    }

    public final String getParams() {
        return this.params;
    }

    public ReachActionRequest(String r1, String r2, int r3, String r4) {
        this.bizReqPsm = r1;
        this.bizReqId = r2;
        this.fromSource = r3;
        this.params = r4;
    }

    public /* synthetic */ ReachActionRequest(String r2, String r3, int r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 1;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
