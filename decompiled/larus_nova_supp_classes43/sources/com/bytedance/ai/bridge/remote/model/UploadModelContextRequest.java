package com.bytedance.ai.bridge.remote.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006."}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/UploadModelContextRequest;", "Ljava/io/Serializable;", "taskId", "", "packageName", "messageId", "conversationId", "entityId", "content", "timestamp", "", "source", "widgetId", "pageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getPackageName", "getMessageId", "getConversationId", "getEntityId", "getContent", "getTimestamp", "()J", "getSource", "getWidgetId", "getPageId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadModelContextRequest implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("conv_id")
    private final String conversationId;

    @SerializedName("entity_id")
    private final String entityId;

    @SerializedName("msg_id")
    private final String messageId;

    @SerializedName("app_key")
    private final String packageName;

    @SerializedName(a.KEY_PAGE_ID)
    private final String pageId;

    @SerializedName("source")
    private final String source;

    @SerializedName("biz_task_id")
    private final String taskId;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("widget_id")
    private final String widgetId;

    public UploadModelContextRequest() {
        this(null, null, null, null, null, null, 0, null, null, null, 1023, null);
    }

    public static /* synthetic */ UploadModelContextRequest copy$default(UploadModelContextRequest r12, String r13, String r14, String r15, String r16, String r17, String r18, long r19, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r10 = r12.taskId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r11 = r12.packageName;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r20 = r12.messageId;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r26 = r12.conversationId;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r27 = r12.entityId;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r28 = r12.content;
    L27:
        if ((r24 & 64) == 0) goto L29;
        long r29 = r12.timestamp;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r110 = r12.source;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r111 = r12.widgetId;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r1 = r12.pageId;
    L43:
        return r12.copy(r10, r11, r20, r26, r27, r28, r29, r110, r111, r1);
    L41:
        r1 = r23;
        goto L43
    L37:
        r111 = r22;
        goto L39
    L33:
        r110 = r21;
        goto L35
    L29:
        r29 = r19;
        goto L31
    L25:
        r28 = r18;
        goto L27
    L21:
        r27 = r17;
        goto L23
    L17:
        r26 = r16;
        goto L19
    L13:
        r20 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component10() {
        return this.pageId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final String component5() {
        return this.entityId;
    }

    public final String component6() {
        return this.content;
    }

    public final long component7() {
        return this.timestamp;
    }

    public final String component8() {
        return this.source;
    }

    public final String component9() {
        return this.widgetId;
    }

    public final UploadModelContextRequest copy(String r14, String r15, String r16, String r17, String r18, String r19, long r20, String r22, String r23, String r24) {
        return new UploadModelContextRequest(r14, r15, r16, r17, r18, r19, r20, r22, r23, r24);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof UploadModelContextRequest) == true) goto L8;
        return false;
    L8:
        UploadModelContextRequest r11 = (UploadModelContextRequest) r10;
        if (Intrinsics.areEqual(this.taskId, r11.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversationId, r11.conversationId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entityId, r11.entityId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r11.content) == true) goto L27;
        return false;
    L27:
        if (this.timestamp == r11.timestamp) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.source, r11.source) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.pageId, r11.pageId) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.packageName;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.messageId;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.conversationId;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.entityId;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.content;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        long r27 = this.timestamp;
        int r28 = (r26 + ((int) (r27 ^ (r27 >>> 32)))) * 31;
        String r29 = this.source;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.widgetId;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        String r35 = this.pageId;
        if (r35 == null) goto L39;
        r1 = r35.hashCode();
    L39:
        return r34 + r1;
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r25 = r24.hashCode();
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "UploadModelContextRequest(taskId=" + this.taskId + ", packageName=" + this.packageName + ", messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", entityId=" + this.entityId + ", content=" + this.content + ", timestamp=" + this.timestamp + ", source=" + this.source + ", widgetId=" + this.widgetId + ", pageId=" + this.pageId + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public UploadModelContextRequest(String r1, String r10, String r11, String r12, String r13, String r14, long r15, String r16, String r17, String r18) {
        this.taskId = r1;
        this.packageName = r10;
        this.messageId = r11;
        this.conversationId = r12;
        this.entityId = r13;
        this.content = r14;
        this.timestamp = r15;
        this.source = r16;
        this.widgetId = r17;
        this.pageId = r18;
    }

    public /* synthetic */ UploadModelContextRequest(String r13, String r14, String r15, String r16, String r17, String r18, long r19, String r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        String r10 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r20 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r26 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r27 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        long r28 = 0;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r24 & 512) != 0) goto L42;
        r10 = r23;
    L42:
        this(r1, r11, r12, r20, r26, r27, r28, r110, r111, r10);
        return;
    L37:
        r111 = r22;
        goto L39
    L33:
        r110 = r21;
        goto L35
    L29:
        r28 = r19;
        goto L31
    L25:
        r27 = r18;
        goto L27
    L21:
        r26 = r17;
        goto L23
    L17:
        r20 = r16;
        goto L19
    L13:
        r12 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
