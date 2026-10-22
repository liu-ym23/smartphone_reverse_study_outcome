package k11;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR6\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lk11/k;", "", "", "inviteType", "J", "getInviteType", "()J", "matchType", "getMatchType", "", "inviteeList", "Ljava/lang/String;", "getInviteeList", "()Ljava/lang/String;", "requestId", "getRequestId", "flexActivityId", "getFlexActivityId", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "logMap", "Ljava/util/Map;", "getLogMap", "()Ljava/util/Map;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.LinkerLogInfo")
public final class k {

    @SerializedName("flex_activity_id")
    private final String flexActivityId;

    @SerializedName("invite_type")
    private final long inviteType;

    @SerializedName("invitee_list")
    private final String inviteeList;

    @SerializedName("log_map")
    private final Map<String, String> logMap;

    @SerializedName("match_type")
    private final long matchType;

    @SerializedName("request_id")
    private final String requestId;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L18;
        k r7 = (k) r6;
        if (this.inviteType == r7.inviteType) goto L8;
        return false;
    L8:
        if (this.matchType == r7.matchType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.inviteeList, r7.inviteeList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r7.requestId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.flexActivityId, r7.flexActivityId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.logMap, r7.logMap) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        long r0 = this.inviteType;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.matchType;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.inviteeList;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.requestId;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (r7 + r9) * 31;
        String r12 = this.flexActivityId;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (r10 + r13) * 31;
        Map<String, String> r15 = this.logMap;
        if (r15 == null) goto L18;
        r5 = r15.hashCode();
    L18:
        return r14 + r5;
    L13:
        r13 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkerLogInfo(inviteType=" + this.inviteType + ", matchType=" + this.matchType + ", inviteeList=" + this.inviteeList + ", requestId=" + this.requestId + ", flexActivityId=" + this.flexActivityId + ", logMap=" + this.logMap + ")";
    }
}
