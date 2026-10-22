package com.larus.extension.offline_message.api.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bµ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010%J¼\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006/"}, d2 = {"Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;", "Ljava/io/Serializable;", "conversationId", "", "conversationType", "", "senderId", "contentType", "content", "ttsContent", "ext", "", "localMessageId", "botType", "localConversationId", "botId", "bizContentType", "status", "createTime", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "()Ljava/lang/Long;", "copy", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;)Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;", "equals", "", "other", "", "hashCode", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMessageUplinkBody implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("biz_content_type")
    public String bizContentType;

    @SerializedName("bot_id")
    public String botId;

    @SerializedName("bot_type")
    public int botType;

    @SerializedName("content")
    public String content;

    @SerializedName("content_type")
    public int contentType;

    @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
    public String conversationId;

    @SerializedName("conversation_type")
    public int conversationType;

    @SerializedName("create_time")
    public Long createTime;

    @SerializedName("ext")
    public Map<String, String> ext;

    @SerializedName("local_conversation_id")
    public String localConversationId;

    @SerializedName("local_message_id")
    public String localMessageId;

    @SerializedName("sender_id")
    public String senderId;

    @SerializedName("status")
    public int status;

    @SerializedName("tts_content")
    public String ttsContent;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SendMessageUplinkBody() {
        this(null, 0, null, 0, null, null, null, null, 0, null, null, null, 0, null, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendMessageUplinkBody copy$default(SendMessageUplinkBody r15, String r16, int r17, String r18, int r19, String r20, String r21, Map r22, String r23, int r24, String r25, String r26, String r27, int r28, Long r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.conversationId;
    L7:
        if ((r30 & 2) == 0) goto L9;
        int r3 = r15.conversationType;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = r15.senderId;
    L15:
        if ((r30 & 8) == 0) goto L17;
        int r5 = r15.contentType;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.content;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = r15.ttsContent;
    L27:
        if ((r30 & 64) == 0) goto L29;
        Map r8 = r15.ext;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r9 = r15.localMessageId;
    L35:
        if ((r30 & 256) == 0) goto L37;
        int r10 = r15.botType;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r11 = r15.localConversationId;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = r15.botId;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r13 = r15.bizContentType;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        int r14 = r15.status;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        Long r1 = r15.createTime;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component10() {
        return this.localConversationId;
    }

    public final String component11() {
        return this.botId;
    }

    public final String component12() {
        return this.bizContentType;
    }

    public final int component13() {
        return this.status;
    }

    public final Long component14() {
        return this.createTime;
    }

    public final int component2() {
        return this.conversationType;
    }

    public final String component3() {
        return this.senderId;
    }

    public final int component4() {
        return this.contentType;
    }

    public final String component5() {
        return this.content;
    }

    public final String component6() {
        return this.ttsContent;
    }

    public final Map<String, String> component7() {
        return this.ext;
    }

    public final String component8() {
        return this.localMessageId;
    }

    public final int component9() {
        return this.botType;
    }

    public final SendMessageUplinkBody copy(String r17, int r18, String r19, int r20, String r21, String r22, Map<String, String> r23, String r24, int r25, String r26, String r27, String r28, int r29, Long r30) {
        return new SendMessageUplinkBody(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendMessageUplinkBody) == true) goto L8;
        return false;
    L8:
        SendMessageUplinkBody r6 = (SendMessageUplinkBody) r5;
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.conversationType == r6.conversationType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.senderId, r6.senderId) == true) goto L18;
        return false;
    L18:
        if (this.contentType == r6.contentType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ttsContent, r6.ttsContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.localMessageId, r6.localMessageId) == true) goto L33;
        return false;
    L33:
        if (this.botType == r6.botType) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.localConversationId, r6.localConversationId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.bizContentType, r6.bizContentType) == true) goto L45;
        return false;
    L45:
        if (this.status == r6.status) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r0 = this.conversationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.conversationType) * 31;
        String r4 = this.senderId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.contentType) * 31;
        String r7 = this.content;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.ttsContent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.ext;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.localMessageId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((r15 + r17) * 31) + this.botType) * 31;
        String r19 = this.localConversationId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.botId;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.bizContentType;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (((r24 + r26) * 31) + this.status) * 31;
        Long r28 = this.createTime;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
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

    public String toString() {
        return "SendMessageUplinkBody(conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", senderId=" + this.senderId + ", contentType=" + this.contentType + ", content=" + this.content + ", ttsContent=" + this.ttsContent + ", ext=" + this.ext + ", localMessageId=" + this.localMessageId + ", botType=" + this.botType + ", localConversationId=" + this.localConversationId + ", botId=" + this.botId + ", bizContentType=" + this.bizContentType + ", status=" + this.status + ", createTime=" + this.createTime + ')';
    }

    public SendMessageUplinkBody(String r1, int r2, String r3, int r4, String r5, String r6, Map<String, String> r7, String r8, int r9, String r10, String r11, String r12, int r13, Long r14) {
        this.conversationId = r1;
        this.conversationType = r2;
        this.senderId = r3;
        this.contentType = r4;
        this.content = r5;
        this.ttsContent = r6;
        this.ext = r7;
        this.localMessageId = r8;
        this.botType = r9;
        this.localConversationId = r10;
        this.botId = r11;
        this.bizContentType = r12;
        this.status = r13;
        this.createTime = r14;
    }

    public /* synthetic */ SendMessageUplinkBody(String r17, int r18, String r19, int r20, String r21, String r22, Map r23, String r24, int r25, String r26, String r27, String r28, int r29, Long r30, int r31, DefaultConstructorMarker r32) {
        Long r2 = null;
        if ((r31 & 1) == 0) goto L5;
        String r1 = null;
    L6:
        int r4 = 0;
        if ((r31 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r31 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r31 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        Map r9 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        int r11 = 0;
    L39:
        if ((r31 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r31 & 4096) != 0) goto L55;
        r4 = r29;
    L55:
        if ((r31 & 8192) != 0) goto L58;
        r2 = r30;
    L58:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r4, r2);
        return;
    L49:
        r14 = r28;
        goto L51
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
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
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L6
    }
}
