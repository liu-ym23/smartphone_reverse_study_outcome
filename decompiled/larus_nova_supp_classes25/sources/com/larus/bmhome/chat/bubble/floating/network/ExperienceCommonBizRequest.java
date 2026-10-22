package com.larus.bmhome.chat.bubble.floating.network;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizRequest;", "", "bizReqId", "", "fromSource", "", "params", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBizReqId", "()Ljava/lang/String;", "getFromSource", "()I", "getParams", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ExperienceCommonBizRequest {
    public static final a Companion = null;
    public static final int FROM_SOURCE_BANNER = 1;

    @SerializedName("biz_req_id")
    private final String bizReqId;

    @SerializedName("from_source")
    private final int fromSource;

    @SerializedName("params")
    private final String params;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ExperienceCommonBizRequest() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ ExperienceCommonBizRequest copy$default(ExperienceCommonBizRequest r0, String r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.bizReqId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.fromSource;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.params;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.bizReqId;
    }

    public final int component2() {
        return this.fromSource;
    }

    public final String component3() {
        return this.params;
    }

    public final ExperienceCommonBizRequest copy(String r2, int r3, String r4) {
        return new ExperienceCommonBizRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ExperienceCommonBizRequest) == true) goto L8;
        return false;
    L8:
        ExperienceCommonBizRequest r6 = (ExperienceCommonBizRequest) r5;
        if (Intrinsics.areEqual(this.bizReqId, r6.bizReqId) == true) goto L12;
        return false;
    L12:
        if (this.fromSource == r6.fromSource) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.bizReqId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.fromSource) * 31;
        String r4 = this.params;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ExperienceCommonBizRequest(bizReqId=" + this.bizReqId + ", fromSource=" + this.fromSource + ", params=" + this.params + ')';
    }

    public final String getBizReqId() {
        return this.bizReqId;
    }

    public final int getFromSource() {
        return this.fromSource;
    }

    public final String getParams() {
        return this.params;
    }

    public ExperienceCommonBizRequest(String r1, int r2, String r3) {
        this.bizReqId = r1;
        this.fromSource = r2;
        this.params = r3;
    }

    public /* synthetic */ ExperienceCommonBizRequest(String r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 1;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
