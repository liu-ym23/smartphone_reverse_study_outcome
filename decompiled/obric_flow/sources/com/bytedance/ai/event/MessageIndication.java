package com.bytedance.ai.event;

import ai.j0;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n2.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001+Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0011Jn\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\u0003\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b$\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b%\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b&\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b'\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b(\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b)\u0010\u0011¨\u0006,"}, d2 = {"Lcom/bytedance/ai/event/MessageIndication;", "", "", "isSend", "", "msgId", "localId", "replyId", "contentType", "messageType", NotificationCompat.CATEGORY_STATUS, "content", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/event/MessageIndication;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getMsgId", "getLocalId", "getReplyId", "getContentType", "getMessageType", "getStatus", "getContent", "Companion", "n2/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MessageIndication {
    public static final String CONTENT_TYPE_TEXT = "text";
    public static final a Companion = null;
    public static final String EVENT_NAME = "msg_indication";
    public static final String MESSAGE_TYPE_LOADING = "loading";
    public static final String MESSAGE_TYPE_MSG = "msg";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_INTERRUPT = "interrupt";
    public static final String STATUS_PREPARE = "prepare";
    public static final String STATUS_RECEIVED = "received";
    public static final String STATUS_RECEIVE_FAILED = "receive_failed";
    public static final String STATUS_RECEIVING = "receiving";
    public static final String STATUS_SENDING = "sending";
    public static final String STATUS_SUCCESS = "success";

    @SerializedName("content")
    private final String content;

    @SerializedName("contentType")
    private final String contentType;

    @SerializedName("isSend")
    private final boolean isSend;

    @SerializedName("localId")
    private final String localId;

    @SerializedName("messageType")
    private final String messageType;

    @SerializedName("msgId")
    private final String msgId;

    @SerializedName("replyId")
    private final String replyId;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final String status;

    static {
        Companion = new a();
    }

    public MessageIndication() {
        boolean r5 = false;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        this(r5, r10, r11, r12, r13, r14, r15, r16, 255, null);
    }

    public static /* synthetic */ MessageIndication copy$default(MessageIndication r10, boolean r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        boolean r5 = r10.isSend;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r20 = r10.msgId;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r21 = r10.localId;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r22 = r10.replyId;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r23 = r10.contentType;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r24 = r10.messageType;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r25 = r10.status;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r26 = r10.content;
    L35:
        return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
    L33:
        r26 = r18;
        goto L35
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public final boolean component1() {
        return this.isSend;
    }

    public final String component2() {
        return this.msgId;
    }

    public final String component3() {
        return this.localId;
    }

    public final String component4() {
        return this.replyId;
    }

    public final String component5() {
        return this.contentType;
    }

    public final String component6() {
        return this.messageType;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.content;
    }

    public final MessageIndication copy(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18) {
        return new MessageIndication(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageIndication) == true) goto L8;
        return false;
    L8:
        MessageIndication r10 = (MessageIndication) r5;
        if (this.isSend == r10.isSend) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msgId, r10.msgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localId, r10.localId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.replyId, r10.replyId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contentType, r10.contentType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageType, r10.messageType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r10.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getLocalId() {
        return this.localId;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int r5 = Boolean.hashCode(this.isSend) * 31;
        String r10 = this.msgId;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.localId;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.replyId;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.contentType;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.messageType;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.status;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.content;
        if (r29 == null) goto L31;
        r11 = r29.hashCode();
    L31:
        return r28 + r11;
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final boolean isSend() {
        return this.isSend;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("MessageIndication(isSend=");
        r5.append(this.isSend);
        r5.append(", msgId=");
        r5.append(this.msgId);
        r5.append(", localId=");
        r5.append(this.localId);
        r5.append(", replyId=");
        r5.append(this.replyId);
        r5.append(", contentType=");
        r5.append(this.contentType);
        r5.append(", messageType=");
        r5.append(this.messageType);
        r5.append(", status=");
        r5.append(this.status);
        r5.append(", content=");
        return j0.p(r5, this.content, ')');
    }

    public MessageIndication(boolean r5, String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        this.isSend = r5;
        this.msgId = r10;
        this.localId = r11;
        this.replyId = r12;
        this.contentType = r13;
        this.messageType = r14;
        this.status = r15;
        this.content = r16;
    }

    public /* synthetic */ MessageIndication(boolean r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r5 = false;
    L6:
        String r20 = "";
        if ((r18 & 2) == 0) goto L9;
        String r21 = "";
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r22 = "";
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r23 = "";
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r24 = "";
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r25 = "";
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r26 = "";
    L31:
        if ((r18 & 128) != 0) goto L34;
        r20 = r17;
    L34:
        this(r5, r21, r22, r23, r24, r25, r26, r20);
        return;
    L29:
        r26 = r16;
        goto L31
    L25:
        r25 = r15;
        goto L27
    L21:
        r24 = r14;
        goto L23
    L17:
        r23 = r13;
        goto L19
    L13:
        r22 = r12;
        goto L15
    L9:
        r21 = r11;
        goto L11
    L5:
        r5 = r10;
        goto L6
    }
}
