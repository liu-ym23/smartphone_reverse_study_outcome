package ey9;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.uaigc.avatar.api.UserGender;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J|\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018¨\u00061"}, d2 = {"Lcom/larus/uaigc/avatar/api/CreateDigitalAvatarRequest;", "", "gender", "", "preGenImages", "", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "conversationId", "", "prompt", "masterIdx", "refMsgId", "replicaRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "fromCreation", "", "enterMethod", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;Ljava/lang/Boolean;Ljava/lang/String;)V", "getGender", "()I", "getPreGenImages", "()Ljava/util/List;", "getConversationId", "()Ljava/lang/String;", "getPrompt", "getMasterIdx", "getRefMsgId", "getReplicaRefVideo", "()Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "getFromCreation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnterMethod", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/uaigc/avatar/api/CreateDigitalAvatarRequest;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b {

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("from_creation")
    private final Boolean fromCreation;

    @SerializedName("gender")
    private final int gender;

    @SerializedName("master_idx")
    private final int masterIdx;

    @SerializedName("pre_gen_images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<k> preGenImages;

    @SerializedName("prompt")
    private final String prompt;

    @SerializedName("ref_msg_id")
    private final String refMsgId;

    @SerializedName("replica_ref_video")
    private final a replicaRefVideo;

    public b() {
        this(0, null, null, null, -1, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.gender == r6.gender) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preGenImages, r6.preGenImages) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L21;
        return false;
    L21:
        if (this.masterIdx == r6.masterIdx) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.refMsgId, r6.refMsgId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.replicaRefVideo, r6.replicaRefVideo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fromCreation, r6.fromCreation) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.gender * 31;
        List<k> r1 = this.preGenImages;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.conversationId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.prompt;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.masterIdx) * 31;
        String r11 = this.refMsgId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        a r14 = this.replicaRefVideo;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.fromCreation;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.enterMethod;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateDigitalAvatarRequest(gender=" + this.gender + ", preGenImages=" + this.preGenImages + ", conversationId=" + this.conversationId + ", prompt=" + this.prompt + ", masterIdx=" + this.masterIdx + ", refMsgId=" + this.refMsgId + ", replicaRefVideo=" + this.replicaRefVideo + ", fromCreation=" + this.fromCreation + ", enterMethod=" + this.enterMethod + ')';
    }

    public b(@UserGender int r1, List<k> r2, String r3, String r4, int r5, String r6, a r7, Boolean r8, String r9) {
        this.gender = r1;
        this.preGenImages = r2;
        this.conversationId = r3;
        this.prompt = r4;
        this.masterIdx = r5;
        this.refMsgId = r6;
        this.replicaRefVideo = r7;
        this.fromCreation = r8;
        this.enterMethod = r9;
    }
}
