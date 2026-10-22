package wj8;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JN\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "", "rawReqMsgId", "", "attachMessageIds", "", "downgradedModelVersion", "", "autoGenAfterAvatarCreated", "", "scene", "<init>", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getRawReqMsgId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAttachMessageIds", "()Ljava/util/List;", "getDowngradedModelVersion", "()Ljava/lang/String;", "getAutoGenAfterAvatarCreated", "()Z", "getScene", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("attach_message_ids")
    private final List<Long> attachMessageIds;

    @SerializedName("auto_gen_after_avatar_created")
    private final boolean autoGenAfterAvatarCreated;

    @SerializedName("downgraded_model_version")
    private final String downgradedModelVersion;

    @SerializedName("raw_req_msg_id")
    private final Long rawReqMsgId;

    @SerializedName("scene")
    private final String scene;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.rawReqMsgId, r6.rawReqMsgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachMessageIds, r6.attachMessageIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.downgradedModelVersion, r6.downgradedModelVersion) == true) goto L18;
        return false;
    L18:
        if (this.autoGenAfterAvatarCreated == r6.autoGenAfterAvatarCreated) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.rawReqMsgId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Long> r4 = this.attachMessageIds;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.downgradedModelVersion;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.autoGenAfterAvatarCreated == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.scene;
        if (r12 == null) goto L23;
        r1 = r12.hashCode();
    L23:
        return r11 + r1;
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationBtnReplayInfo(rawReqMsgId=" + this.rawReqMsgId + ", attachMessageIds=" + this.attachMessageIds + ", downgradedModelVersion=" + this.downgradedModelVersion + ", autoGenAfterAvatarCreated=" + this.autoGenAfterAvatarCreated + ", scene=" + this.scene + ')';
    }

    public b() {
        this.rawReqMsgId = 0L;
        this.attachMessageIds = null;
        this.downgradedModelVersion = null;
        this.autoGenAfterAvatarCreated = false;
        this.scene = null;
    }

    public final List<Long> a() {
        return this.attachMessageIds;
    }

    public final boolean b() {
        return this.autoGenAfterAvatarCreated;
    }

    public final Long c() {
        return this.rawReqMsgId;
    }
}
