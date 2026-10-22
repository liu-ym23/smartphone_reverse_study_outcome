package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 02\u00020\u0001:\u00010Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J{\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Lcom/obric/memorydata/database/entity/AssistantChatMessageEntity;", "", OaidModel.KEY_ID, "", "messageId", "", "replyId", "collectionId", "createTime", "timestamp", "type", "omniId", "omniState", Params.CONTENT, "", "Lcom/obric/memorydata/database/entity/AssistantChatContent;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()J", "getMessageId", "()Ljava/lang/String;", "getReplyId", "getCollectionId", "getCreateTime", "getTimestamp", "getType", "getOmniId", "getOmniState", "getContent", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantChatMessageEntity {
    public static final a Companion = null;
    private static final long SECOND_TIMESTAMP_UPPER_BOUND = 10000000000L;
    private final String collectionId;
    private final List<AssistantChatContent> content;
    private final long createTime;
    private final long id;
    private final String messageId;
    private final String omniId;
    private final String omniState;
    private final String replyId;
    private final long timestamp;
    private final String type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/AssistantChatMessageEntity$Companion;", "", "<init>", "()V", "SECOND_TIMESTAMP_UPPER_BOUND", "", "fromJson", "Lcom/obric/memorydata/database/entity/AssistantChatMessageEntity;", "json", "", "trimBlankToNull", "normalizeCreateTimeMillis", "createTime", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final long a(long r4) {
            boolean r0 = false;
            if (1 <= r4) goto L5;
        L7:
            if (r0 == true) goto L9;
            return r4;
        L9:
            return r4 * ((long) 1000);
        L5:
            if (r4 >= AssistantChatMessageEntity.SECOND_TIMESTAMP_UPPER_BOUND) goto L7;
            r0 = true;
            goto L7
        }

        private final String b(String r2) {
            String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == true) goto L10;
            return null;
        L10:
            return r1;
        L5:
            r3 = false;
            goto L6
        }

        public final AssistantChatMessageEntity a(String r21) {
            Intrinsics.checkNotNullParameter(r21, "json");
            JSONObject r2 = new JSONObject(r21);
            String r1 = r2.optString("messageId");
            Intrinsics.checkNotNullExpressionValue(r1, "optString(...)");
            String r7 = b(r1);
            if (r7 != null) goto L5;
            return null;
        L5:
            String r4 = r2.optString("type");
            Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
            String r14 = b(r4);
            if (r14 != null) goto L8;
            return null;
        L8:
            long r12 = a(r2.optLong("createTime", System.currentTimeMillis()));
            JSONArray r3 = r2.optJSONArray(Params.CONTENT);
            List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L19;
            int r5 = 0;
            int r6 = r3.length();
        L11:
            if (r5 >= r6) goto L19;
            JSONObject r8 = r3.optJSONObject(r5);
            if (r8 == null) goto L18;
            a r9 = AssistantChatMessageEntity.Companion;
            String r10 = r8.optString("contentType");
            Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
            String r11 = r9.b(r10);
            if (r11 == null) goto L18;
            a r13 = AssistantChatMessageEntity.Companion;
            String r16 = r8.optString("contentValue");
            Intrinsics.checkNotNullExpressionValue(r16, "optString(...)");
            String r17 = r13.b(r16);
            a r18 = AssistantChatMessageEntity.Companion;
            String r19 = r8.optString(AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkNotNullExpressionValue(r19, "optString(...)");
            r15.add(new AssistantChatContent(r11, r17, r18.b(r19)));
        L18:
            r5 = r5 + 1;
            r3 = r3;
        L19:
            String r20 = r2.optString("replyId");
            Intrinsics.checkNotNullExpressionValue(r20, "optString(...)");
            String r22 = b(r20);
            String r23 = r2.optString("collectionId");
            Intrinsics.checkNotNullExpressionValue(r23, "optString(...)");
            String r24 = b(r23);
            String r25 = r2.optString("omniId");
            Intrinsics.checkNotNullExpressionValue(r25, "optString(...)");
            String r110 = b(r25);
            String r26 = r2.optString("omniState");
            Intrinsics.checkNotNullExpressionValue(r26, "optString(...)");
            return new AssistantChatMessageEntity(0, r7, r22, r24, r12, r12, r14, r110, b(r26), r15, 1, null);
        }
    }

    static {
        Companion = new a(null);
    }

    public AssistantChatMessageEntity(long r3, String r5, String r6, String r7, long r8, long r10, String r12, String r13, String r14, List<AssistantChatContent> r15) {
        List<AssistantChatContent> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r16, Params.CONTENT);
        this.id = r3;
        this.messageId = r5;
        this.replyId = r6;
        this.collectionId = r7;
        this.createTime = r8;
        this.timestamp = r10;
        this.type = r12;
        this.omniId = r13;
        this.omniState = r14;
        this.content = r16;
    }

    public /* synthetic */ AssistantChatMessageEntity(long r19, String r21, String r22, String r23, long r24, long r26, String r28, String r29, String r30, List r31, int r32, DefaultConstructorMarker r33) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
        if ((r32 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r32 & 4) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r32 & 8) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r32 & 128) == 0) goto L17;
        String r15 = null;
    L19:
        if ((r32 & 256) == 0) goto L21;
        String r16 = null;
    L23:
        if ((r32 & 512) == 0) goto L25;
        r1 = CollectionsKt.emptyList();
    L25:
        this(r5, r21, r8, r9, r24, r26, r28, r15, r16, r1);
        return;
    L21:
        r16 = r30;
        goto L23
    L17:
        r15 = r29;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r8 = r22;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }

    public static /* synthetic */ AssistantChatMessageEntity copy$default(AssistantChatMessageEntity r15, long r16, String r18, String r19, String r20, long r21, long r23, String r25, String r26, String r27, List r28, int r29, Object r30) {
        List<AssistantChatContent> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        if ((r29 & 1) == 0) goto L5;
        long r3 = r15.id;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r5 = r15.messageId;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r6 = r15.replyId;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r7 = r15.collectionId;
    L19:
        if ((r29 & 16) == 0) goto L21;
        long r8 = r15.createTime;
    L23:
        if ((r29 & 32) == 0) goto L25;
        long r10 = r15.timestamp;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r12 = r15.type;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r13 = r15.omniId;
    L35:
        if ((r29 & 256) == 0) goto L37;
        String r14 = r15.omniState;
    L39:
        if ((r29 & 512) == 0) goto L41;
        List<AssistantChatContent> r1 = r15.content;
    L43:
        return r15.copy(r3, r5, r6, r7, r8, r10, r12, r13, r14, r1);
    L41:
        r1 = r2;
        goto L43
    L37:
        r14 = r27;
        goto L39
    L33:
        r13 = r26;
        goto L35
    L29:
        r12 = r25;
        goto L31
    L25:
        r10 = r23;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r3 = r16;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final List<AssistantChatContent> component10() {
        return this.content;
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

    public final AssistantChatMessageEntity copy(long r16, String r18, String r19, String r20, long r21, long r23, String r25, String r26, String r27, List<AssistantChatContent> r28) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r18, "messageId");
        Intrinsics.checkNotNullParameter(r25, "type");
        Intrinsics.checkNotNullParameter(r14, Params.CONTENT);
        return new AssistantChatMessageEntity(r16, r18, r19, r20, r21, r23, r25, r26, r27, r14);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AssistantChatMessageEntity.class) == true) goto L8;
        return false;
    L8:
        AssistantChatMessageEntity r10 = (AssistantChatMessageEntity) ZeusTransformUtils.preCheckCast(r9, AssistantChatMessageEntity.class, "com.obric.memorydata.plugin");
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
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final List<AssistantChatContent> getContent() {
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
        return ((r10 + r2) * 31) + this.content.hashCode();
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
        return "AssistantChatMessageEntity(id=" + this.id + ", messageId=" + this.messageId + ", replyId=" + this.replyId + ", collectionId=" + this.collectionId + ", createTime=" + this.createTime + ", timestamp=" + this.timestamp + ", type=" + this.type + ", omniId=" + this.omniId + ", omniState=" + this.omniState + ", content=" + this.content + ')';
    }
}
