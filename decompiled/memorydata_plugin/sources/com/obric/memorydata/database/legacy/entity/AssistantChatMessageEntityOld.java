package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u007f\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010,\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/AssistantChatMessageEntityOld;", "", OaidModel.KEY_ID, "", "messageId", "", "replyId", "collectionId", "createTime", "timestamp", "type", "omniId", "omniState", Params.CONTENT, "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()J", "getMessageId", "()Ljava/lang/String;", "getReplyId", "getCollectionId", "getCreateTime", "getTimestamp", "getType", "getOmniId", "getOmniState", "getContent", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantChatMessageEntityOld {
    private final String collectionId;
    private final String content;
    private final long createTime;
    private final long id;
    private final String messageId;
    private final String omniId;
    private final String omniState;
    private final boolean personalDbSplitMigrated;
    private final String replyId;
    private final long timestamp;
    private final String type;

    public AssistantChatMessageEntityOld(long r2, String r4, String r5, String r6, long r7, long r9, String r11, String r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r14, Params.CONTENT);
        this.id = r2;
        this.messageId = r4;
        this.replyId = r5;
        this.collectionId = r6;
        this.createTime = r7;
        this.timestamp = r9;
        this.type = r11;
        this.omniId = r12;
        this.omniState = r13;
        this.content = r14;
        this.personalDbSplitMigrated = r15;
    }

    public /* synthetic */ AssistantChatMessageEntityOld(long r19, String r21, String r22, String r23, long r24, long r26, String r28, String r29, String r30, String r31, boolean r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r33 & 4) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r33 & 8) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r33 & 128) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r33 & 256) == 0) goto L21;
        String r15 = null;
    L23:
        if ((r33 & 512) == 0) goto L25;
        String r16 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L27:
        if ((r33 & 1024) == 0) goto L29;
        boolean r17 = false;
    L30:
        this(r4, r21, r7, r8, r24, r26, r28, r14, r15, r16, r17);
        return;
    L29:
        r17 = r32;
        goto L30
    L25:
        r16 = r31;
        goto L27
    L21:
        r15 = r30;
        goto L23
    L17:
        r14 = r29;
        goto L19
    L13:
        r8 = r23;
        goto L15
    L9:
        r7 = r22;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public static /* synthetic */ AssistantChatMessageEntityOld copy$default(AssistantChatMessageEntityOld r15, long r16, String r18, String r19, String r20, long r21, long r23, String r25, String r26, String r27, String r28, boolean r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        long r2 = r15.id;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r4 = r15.messageId;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r5 = r15.replyId;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r6 = r15.collectionId;
    L19:
        if ((r30 & 16) == 0) goto L21;
        long r7 = r15.createTime;
    L23:
        if ((r30 & 32) == 0) goto L25;
        long r9 = r15.timestamp;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r11 = r15.type;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r12 = r15.omniId;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r13 = r15.omniState;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r14 = r15.content;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        boolean r1 = r15.personalDbSplitMigrated;
    L47:
        return r15.copy(r2, r4, r5, r6, r7, r9, r11, r12, r13, r14, r1);
    L45:
        r1 = r29;
        goto L47
    L41:
        r14 = r28;
        goto L43
    L37:
        r13 = r27;
        goto L39
    L33:
        r12 = r26;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.content;
    }

    public final boolean component11() {
        return this.personalDbSplitMigrated;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.replyId;
    }

    public final String component4() {
        return this.collectionId;
    }

    public final long component5() {
        return this.createTime;
    }

    public final long component6() {
        return this.timestamp;
    }

    public final String component7() {
        return this.type;
    }

    public final String component8() {
        return this.omniId;
    }

    public final String component9() {
        return this.omniState;
    }

    public final AssistantChatMessageEntityOld copy(long r17, String r19, String r20, String r21, long r22, long r24, String r26, String r27, String r28, String r29, boolean r30) {
        Intrinsics.checkNotNullParameter(r19, "messageId");
        Intrinsics.checkNotNullParameter(r26, "type");
        Intrinsics.checkNotNullParameter(r29, Params.CONTENT);
        return new AssistantChatMessageEntityOld(r17, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AssistantChatMessageEntityOld.class) == true) goto L8;
        return false;
    L8:
        AssistantChatMessageEntityOld r10 = (AssistantChatMessageEntityOld) ZeusTransformUtils.preCheckCast(r9, AssistantChatMessageEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r10.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.replyId, r10.replyId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.collectionId, r10.collectionId) == true) goto L21;
        return false;
    L21:
        if (this.createTime == r10.createTime) goto L24;
        return false;
    L24:
        if (this.timestamp == r10.timestamp) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.omniId, r10.omniId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.omniState, r10.omniState) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L39;
        return false;
    L39:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L41;
        return false;
    L41:
        return true;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getId() {
        return this.id;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getOmniId() {
        return this.omniId;
    }

    public final String getOmniState() {
        return this.omniState;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.id) * 31) + this.messageId.hashCode()) * 31;
        String r1 = this.replyId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.collectionId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.type.hashCode()) * 31;
        String r8 = this.omniId;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.omniState;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((((r10 + r2) * 31) + this.content.hashCode()) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
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

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AssistantChatMessageEntityOld(id=").append(this.id).append(", messageId=").append(this.messageId).append(", replyId=").append(this.replyId).append(", collectionId=").append(this.collectionId).append(", createTime=").append(this.createTime).append(", timestamp=").append(this.timestamp).append(", type=").append(this.type).append(", omniId=").append(this.omniId).append(", omniState=").append(this.omniState).append(", content=").append(this.content).append(", personalDbSplitMigrated=").append(this.personalDbSplitMigrated).append(')');
        return r0.toString();
    }
}
