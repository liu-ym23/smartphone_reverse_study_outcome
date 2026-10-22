package com.ss.android.lark.officesdk.minutes.api.recording.doubao;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u0000J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jw\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00060"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoBizInfo;", "Ljava/io/Serializable;", "userId", "", "conversationId", "messageId", "replyMessageId", "bizId", "appId", "tenantId", "deviceId", "recordingId", "doubaoAppVersion", "doubaoRecorderExtra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getConversationId", "getMessageId", "getReplyMessageId", "getBizId", "getAppId", "getTenantId", "getDeviceId", "getRecordingId", "getDoubaoAppVersion", "getDoubaoRecorderExtra", "withHostAppVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoBizInfo implements Serializable {

    @SerializedName("AppID")
    private final String appId;

    @SerializedName("BizID")
    private final String bizId;

    @SerializedName("ConversationID")
    private final String conversationId;

    @SerializedName("DeviceID")
    private final String deviceId;

    @SerializedName("DoubaoAppVersion")
    private final String doubaoAppVersion;

    @SerializedName("DoubaoRecorderExtra")
    private final String doubaoRecorderExtra;

    @SerializedName("MessageID")
    private final String messageId;

    @SerializedName("RecordingIDV2")
    private final String recordingId;

    @SerializedName("ReplyMessageID")
    private final String replyMessageId;

    @SerializedName("TenantID")
    private final String tenantId;

    @SerializedName("UserID")
    private final String userId;

    public static /* synthetic */ DoubaoBizInfo copy$default(DoubaoBizInfo r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.userId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.conversationId;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.messageId;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.replyMessageId;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.bizId;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.appId;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.tenantId;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.deviceId;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.recordingId;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = r12.doubaoAppVersion;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.doubaoRecorderExtra;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.doubaoAppVersion;
    }

    public final String component11() {
        return this.doubaoRecorderExtra;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.replyMessageId;
    }

    public final String component5() {
        return this.bizId;
    }

    public final String component6() {
        return this.appId;
    }

    public final String component7() {
        return this.tenantId;
    }

    public final String component8() {
        return this.deviceId;
    }

    public final String component9() {
        return this.recordingId;
    }

    public final DoubaoBizInfo copy(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r14, "userId");
        Intrinsics.checkNotNullParameter(r15, "conversationId");
        Intrinsics.checkNotNullParameter(r16, "messageId");
        Intrinsics.checkNotNullParameter(r17, "replyMessageId");
        Intrinsics.checkNotNullParameter(r18, "bizId");
        Intrinsics.checkNotNullParameter(r19, "appId");
        Intrinsics.checkNotNullParameter(r20, "tenantId");
        Intrinsics.checkNotNullParameter(r21, "deviceId");
        Intrinsics.checkNotNullParameter(r22, "recordingId");
        Intrinsics.checkNotNullParameter(r23, "doubaoAppVersion");
        Intrinsics.checkNotNullParameter(r24, "doubaoRecorderExtra");
        return new DoubaoBizInfo(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoubaoBizInfo) == true) goto L8;
        return false;
    L8:
        DoubaoBizInfo r6 = (DoubaoBizInfo) r5;
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.replyMessageId, r6.replyMessageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizId, r6.bizId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tenantId, r6.tenantId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.deviceId, r6.deviceId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.recordingId, r6.recordingId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.doubaoAppVersion, r6.doubaoAppVersion) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.doubaoRecorderExtra, r6.doubaoRecorderExtra) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((this.userId.hashCode() * 31) + this.conversationId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.replyMessageId.hashCode()) * 31) + this.bizId.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.tenantId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.recordingId.hashCode()) * 31) + this.doubaoAppVersion.hashCode()) * 31) + this.doubaoRecorderExtra.hashCode();
    }

    public String toString() {
        return "DoubaoBizInfo(userId=" + this.userId + ", conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", replyMessageId=" + this.replyMessageId + ", bizId=" + this.bizId + ", appId=" + this.appId + ", tenantId=" + this.tenantId + ", deviceId=" + this.deviceId + ", recordingId=" + this.recordingId + ", doubaoAppVersion=" + this.doubaoAppVersion + ", doubaoRecorderExtra=" + this.doubaoRecorderExtra + ')';
    }

    public final DoubaoBizInfo withHostAppVersion() {
        String r0 = OfficeSDKManager.getHostAppVersion();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r13 = StringsKt.removePrefix(r0, "doubao:");
        String r2 = this.userId;
        if (r2 != null) goto L8;
        String r4 = "";
    L9:
        String r3 = this.conversationId;
        if (r3 != null) goto L12;
        String r5 = "";
    L13:
        String r6 = this.messageId;
        if (r6 != null) goto L16;
        String r7 = "";
    L17:
        String r8 = this.replyMessageId;
        if (r8 != null) goto L20;
        String r9 = "";
    L21:
        String r10 = this.bizId;
        if (r10 != null) goto L24;
        String r11 = "";
    L25:
        String r12 = this.appId;
        if (r12 != null) goto L28;
        String r14 = "";
    L29:
        String r15 = this.tenantId;
        if (r15 != null) goto L32;
        String r16 = "";
    L33:
        String r17 = this.deviceId;
        if (r17 != null) goto L36;
        String r18 = "";
    L37:
        String r19 = this.recordingId;
        if (r19 != null) goto L40;
        String r110 = "";
    L41:
        String r20 = this.doubaoRecorderExtra;
        if (r20 != null) goto L44;
        String r111 = "";
    L46:
        return new DoubaoBizInfo(r4, r5, r7, r9, r11, r14, r16, r18, r110, r13, r111);
    L44:
        r111 = r20;
        goto L46
    L40:
        r110 = r19;
        goto L41
    L36:
        r18 = r17;
        goto L37
    L32:
        r16 = r15;
        goto L33
    L28:
        r14 = r12;
        goto L29
    L24:
        r11 = r10;
        goto L25
    L20:
        r9 = r8;
        goto L21
    L16:
        r7 = r6;
        goto L17
    L12:
        r5 = r3;
        goto L13
    L8:
        r4 = r2;
        goto L9
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDoubaoAppVersion() {
        return this.doubaoAppVersion;
    }

    public final String getDoubaoRecorderExtra() {
        return this.doubaoRecorderExtra;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final String getReplyMessageId() {
        return this.replyMessageId;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public DoubaoBizInfo(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r5, "replyMessageId");
        Intrinsics.checkNotNullParameter(r6, "bizId");
        Intrinsics.checkNotNullParameter(r7, "appId");
        Intrinsics.checkNotNullParameter(r8, "tenantId");
        Intrinsics.checkNotNullParameter(r9, "deviceId");
        Intrinsics.checkNotNullParameter(r10, "recordingId");
        Intrinsics.checkNotNullParameter(r11, "doubaoAppVersion");
        Intrinsics.checkNotNullParameter(r12, "doubaoRecorderExtra");
        this.userId = r2;
        this.conversationId = r3;
        this.messageId = r4;
        this.replyMessageId = r5;
        this.bizId = r6;
        this.appId = r7;
        this.tenantId = r8;
        this.deviceId = r9;
        this.recordingId = r10;
        this.doubaoAppVersion = r11;
        this.doubaoRecorderExtra = r12;
    }

    public /* synthetic */ DoubaoBizInfo(String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 256) == 0) goto L5;
        String r12 = "";
    L7:
        if ((r27 & 512) == 0) goto L9;
        String r13 = "";
    L11:
        if ((r27 & 1024) == 0) goto L13;
        String r14 = "";
    L14:
        this(r16, r17, r18, r19, r20, r21, r22, r23, r12, r13, r14);
        return;
    L13:
        r14 = r26;
        goto L14
    L9:
        r13 = r25;
        goto L11
    L5:
        r12 = r24;
        goto L7
    }
}
