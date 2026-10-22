package com.ss.android.lark.keyboard.base;

import android.net.Uri;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010B\u001a\u00020\u0013J\b\u0010C\u001a\u00020\u0013H\u0002J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020EJ\u0010\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u0003H\u0002J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u000eHÆ\u0003J\t\u0010S\u001a\u00020\u000eHÆ\u0003J\t\u0010T\u001a\u00020\u0011HÆ\u0003J\t\u0010U\u001a\u00020\u0013HÆ\u0003J\t\u0010V\u001a\u00020\u0013HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0016HÆ\u0003J´\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u00132\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u000eHÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010:\"\u0004\b=\u0010<R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006_"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "Ljava/io/Serializable;", "identifier", "", "fileName", "size", "", "mimeType", "localResPath", "remoteKey", "resourceId", "sourceMessageId", "sourceChatId", "sourcePosition", "", "uploadProgress", "uploadState", "Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;", "isFromDraft", "", "isFolder", "uri", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;ZZLandroid/net/Uri;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getFileName", "setFileName", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMimeType", "setMimeType", "getLocalResPath", "setLocalResPath", "getRemoteKey", "setRemoteKey", "getResourceId", "setResourceId", "getSourceMessageId", "setSourceMessageId", "getSourceChatId", "setSourceChatId", "getSourcePosition", "()I", "setSourcePosition", "(I)V", "getUploadProgress", "setUploadProgress", "getUploadState", "()Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;", "setUploadState", "(Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;)V", "()Z", "setFromDraft", "(Z)V", "setFolder", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "hasLocalOrRemoteResource", "hasAvailableLocalResource", "toPbFile", "Lcom/bytedance/lark/pb/basic/v1/File;", "toSendPbFile", "isRemoteResourceKey", TabAppInfo.IMAGE_JSON_KEY, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;ZZLandroid/net/Uri;)Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ChatAttachmentEntity implements Serializable {
    public transient Uri a;
    private String fileName;
    private String identifier;
    private boolean isFolder;
    private boolean isFromDraft;
    private String localResPath;
    private String mimeType;
    private String remoteKey;
    private String resourceId;
    private Long size;
    private String sourceChatId;
    private String sourceMessageId;
    private int sourcePosition;
    private int uploadProgress;
    private ChatAttachmentUploadState uploadState;

    public static /* synthetic */ ChatAttachmentEntity copy$default(ChatAttachmentEntity r16, String r17, String r18, Long r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, int r27, ChatAttachmentUploadState r28, boolean r29, boolean r30, Uri r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        String r2 = r16.identifier;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = r16.fileName;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Long r4 = r16.size;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r5 = r16.mimeType;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r6 = r16.localResPath;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r7 = r16.remoteKey;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r8 = r16.resourceId;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r9 = r16.sourceMessageId;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r10 = r16.sourceChatId;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r11 = r16.sourcePosition;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        int r12 = r16.uploadProgress;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        ChatAttachmentUploadState r13 = r16.uploadState;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        boolean r14 = r16.isFromDraft;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r15 = r16.isFolder;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        Uri r1 = r16.a;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final String component1() {
        return this.identifier;
    }

    public final int component10() {
        return this.sourcePosition;
    }

    public final int component11() {
        return this.uploadProgress;
    }

    public final ChatAttachmentUploadState component12() {
        return this.uploadState;
    }

    public final boolean component13() {
        return this.isFromDraft;
    }

    public final boolean component14() {
        return this.isFolder;
    }

    public final Uri component15() {
        return this.a;
    }

    public final String component2() {
        return this.fileName;
    }

    public final Long component3() {
        return this.size;
    }

    public final String component4() {
        return this.mimeType;
    }

    public final String component5() {
        return this.localResPath;
    }

    public final String component6() {
        return this.remoteKey;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.sourceMessageId;
    }

    public final String component9() {
        return this.sourceChatId;
    }

    public final ChatAttachmentEntity copy(String r18, String r19, Long r20, String r21, String r22, String r23, String r24, String r25, String r26, int r27, int r28, ChatAttachmentUploadState r29, boolean r30, boolean r31, Uri r32) {
        Intrinsics.checkNotNullParameter(r18, "identifier");
        Intrinsics.checkNotNullParameter(r19, "fileName");
        Intrinsics.checkNotNullParameter(r29, "uploadState");
        return new ChatAttachmentEntity(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatAttachmentEntity) == true) goto L8;
        return false;
    L8:
        ChatAttachmentEntity r6 = (ChatAttachmentEntity) r5;
        if (Intrinsics.areEqual(this.identifier, r6.identifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mimeType, r6.mimeType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.localResPath, r6.localResPath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.remoteKey, r6.remoteKey) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resourceId, r6.resourceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sourceMessageId, r6.sourceMessageId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceChatId, r6.sourceChatId) == true) goto L36;
        return false;
    L36:
        if (this.sourcePosition == r6.sourcePosition) goto L39;
        return false;
    L39:
        if (this.uploadProgress == r6.uploadProgress) goto L42;
        return false;
    L42:
        if (this.uploadState == r6.uploadState) goto L45;
        return false;
    L45:
        if (this.isFromDraft == r6.isFromDraft) goto L48;
        return false;
    L48:
        if (this.isFolder == r6.isFolder) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.identifier.hashCode() * 31) + this.fileName.hashCode()) * 31;
        Long r1 = this.size;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.mimeType;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.localResPath;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.remoteKey;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.resourceId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.sourceMessageId;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.sourceChatId;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((((((r19 + r21) * 31) + this.sourcePosition) * 31) + this.uploadProgress) * 31) + this.uploadState.hashCode()) * 31;
        int r23 = 1231;
        if (this.isFromDraft == false) goto L33;
        int r24 = 1231;
    L34:
        int r25 = (r22 + r24) * 31;
        if (this.isFolder == true) goto L38;
        r23 = 1237;
    L38:
        int r26 = (r25 + r23) * 31;
        Uri r27 = this.a;
        if (r27 == null) goto L43;
        r2 = r27.hashCode();
    L43:
        return r26 + r2;
    L33:
        r24 = 1237;
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
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

    public String toString() {
        return "ChatAttachmentEntity(identifier=" + this.identifier + ", fileName=" + this.fileName + ", size=" + this.size + ", mimeType=" + this.mimeType + ", localResPath=" + this.localResPath + ", remoteKey=" + this.remoteKey + ", resourceId=" + this.resourceId + ", sourceMessageId=" + this.sourceMessageId + ", sourceChatId=" + this.sourceChatId + ", sourcePosition=" + this.sourcePosition + ", uploadProgress=" + this.uploadProgress + ", uploadState=" + this.uploadState + ", isFromDraft=" + this.isFromDraft + ", isFolder=" + this.isFolder + ", uri=" + this.a + ')';
    }

    public final boolean hasLocalOrRemoteResource() {
        String r0 = this.localResPath;
        if (r0 != null) goto L5;
    L23:
        boolean r1 = false;
    L24:
        if (r1 == false) goto L26;
        return true;
    L26:
        if (this.a != null) goto L47;
        String r2 = this.remoteKey;
        if (r2 != null) goto L30;
    L33:
        boolean r3 = true;
    L34:
        if (r3 == false) goto L48;
        String r4 = this.resourceId;
        if (r4 != null) goto L38;
    L41:
        boolean r5 = true;
    L42:
        if (r5 == false) goto L49;
        return false;
    L49:
        return true;
    L38:
        if (r4.length() == 0) goto L41;
        r5 = false;
        goto L42
    L48:
        return true;
    L30:
        if (r2.length() == 0) goto L33;
        r3 = false;
        goto L34
    L47:
        return true;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L23;
        PolarisFileWrapper r7 = new PolarisFileWrapper(r0);
        if (r7.exists() == false) goto L23;
        if (r7.canRead() == false) goto L23;
        if (this.isFolder == false) goto L20;
        boolean r8 = r7.isDirectory();
    L21:
        if (r8 == false) goto L23;
        r1 = true;
        goto L24
    L20:
        r8 = r7.isFile();
        goto L21
    L7:
        r6 = false;
        goto L8
    }

    public final File toSendPbFile() {
        String r0 = this.remoteKey;
        boolean r1 = true;
        String r3 = null;
        if (r0 != null) goto L5;
    L12:
        r0 = this.resourceId;
        if (r0 != null) goto L15;
    L20:
        r0 = null;
    L21:
        if (r0 != null) goto L26;
        r0 = this.identifier;
        if (StringsKt.startsWith$default(r0, "file_", false, 2, null) == true) goto L26;
        r0 = null;
    L26:
        if (r0 != null) goto L28;
        String r4 = this.identifier;
    L29:
        String r5 = "";
        if (r0 != null) goto L47;
        String r2 = this.localResPath;
        if (r2 != null) goto L34;
    L41:
        Uri r6 = this.a;
        if (r6 == null) goto L44;
        r3 = r6.toString();
    L44:
        if (r3 == null) goto L47;
        r2 = r3;
    L48:
        File.Builder r7 = new File.Builder().name(this.fileName).key(r4);
        Long r8 = this.size;
        if (r8 == null) goto L51;
        long r9 = r8.longValue();
    L52:
        File.Builder r10 = r7.size(Long.valueOf(r9));
        String r11 = this.mimeType;
        if (r11 == null) goto L57;
        r5 = r11;
    L57:
        return r10.mime(r5).path(r2).is_folder(Boolean.valueOf(this.isFolder)).build();
    L51:
        r9 = 0;
        goto L52
    L34:
        if (r2.length() > 0) goto L37;
        r1 = false;
    L37:
        if (r1 == true) goto L40;
        r2 = null;
    L40:
        if (r2 != null) goto L48;
    L47:
        r2 = "";
        goto L48
    L28:
        r4 = r0;
        goto L29
    L15:
        if (r0.length() <= 0) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
    L17:
        r12 = false;
        goto L18
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L26;
    L7:
        r13 = false;
        goto L8
    }

    public final File toPbFile() {
        return toSendPbFile();
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getLocalResPath() {
        return this.localResPath;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getRemoteKey() {
        return this.remoteKey;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSourceChatId() {
        return this.sourceChatId;
    }

    public final String getSourceMessageId() {
        return this.sourceMessageId;
    }

    public final int getSourcePosition() {
        return this.sourcePosition;
    }

    public final int getUploadProgress() {
        return this.uploadProgress;
    }

    public final ChatAttachmentUploadState getUploadState() {
        return this.uploadState;
    }

    public final Uri getUri() {
        return this.a;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    public final boolean isFromDraft() {
        return this.isFromDraft;
    }

    public final void setFileName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileName = r2;
    }

    public final void setFolder(boolean r1) {
        this.isFolder = r1;
    }

    public final void setFromDraft(boolean r1) {
        this.isFromDraft = r1;
    }

    public final void setIdentifier(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.identifier = r2;
    }

    public final void setLocalResPath(String r1) {
        this.localResPath = r1;
    }

    public final void setMimeType(String r1) {
        this.mimeType = r1;
    }

    public final void setRemoteKey(String r1) {
        this.remoteKey = r1;
    }

    public final void setResourceId(String r1) {
        this.resourceId = r1;
    }

    public final void setSize(Long r1) {
        this.size = r1;
    }

    public final void setSourceChatId(String r1) {
        this.sourceChatId = r1;
    }

    public final void setSourceMessageId(String r1) {
        this.sourceMessageId = r1;
    }

    public final void setSourcePosition(int r1) {
        this.sourcePosition = r1;
    }

    public final void setUploadProgress(int r1) {
        this.uploadProgress = r1;
    }

    public final void setUploadState(ChatAttachmentUploadState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uploadState = r2;
    }

    public final void setUri(Uri r1) {
        this.a = r1;
    }

    public ChatAttachmentEntity(String r6, String r7, Long r8, String r9, String r10, String r11, String r12, String r13, String r14, int r15, int r16, ChatAttachmentUploadState r17, boolean r18, boolean r19, Uri r20) {
        Intrinsics.checkNotNullParameter(r6, "identifier");
        Intrinsics.checkNotNullParameter(r7, "fileName");
        Intrinsics.checkNotNullParameter(r17, "uploadState");
        this.identifier = r6;
        this.fileName = r7;
        this.size = r8;
        this.mimeType = r9;
        this.localResPath = r10;
        this.remoteKey = r11;
        this.resourceId = r12;
        this.sourceMessageId = r13;
        this.sourceChatId = r14;
        this.sourcePosition = r15;
        this.uploadProgress = r16;
        this.uploadState = r17;
        this.isFromDraft = r18;
        this.isFolder = r19;
        this.a = r20;
    }

    public /* synthetic */ ChatAttachmentEntity(String r20, String r21, Long r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29, int r30, ChatAttachmentUploadState r31, boolean r32, boolean r33, Uri r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 4) == 0) goto L5;
        Long r6 = null;
    L7:
        if ((r35 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r35 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r35 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r35 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r35 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r35 & 256) == 0) goto L29;
        String r12 = null;
    L31:
        if ((r35 & 512) == 0) goto L33;
        int r13 = -1;
    L35:
        if ((r35 & 1024) == 0) goto L37;
        int r14 = 0;
    L39:
        if ((r35 & 2048) == 0) goto L41;
        ChatAttachmentUploadState r15 = ChatAttachmentUploadState.DEFAULT;
    L43:
        if ((r35 & 4096) == 0) goto L45;
        boolean r16 = false;
    L47:
        if ((r35 & 8192) == 0) goto L49;
        boolean r17 = false;
    L51:
        if ((r35 & 16384) == 0) goto L53;
        Uri r18 = null;
    L54:
        this(r20, r21, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L53:
        r18 = r34;
        goto L54
    L49:
        r17 = r33;
        goto L51
    L45:
        r16 = r32;
        goto L47
    L41:
        r15 = r31;
        goto L43
    L37:
        r14 = r30;
        goto L39
    L33:
        r13 = r29;
        goto L35
    L29:
        r12 = r28;
        goto L31
    L25:
        r11 = r27;
        goto L27
    L21:
        r10 = r26;
        goto L23
    L17:
        r9 = r25;
        goto L19
    L13:
        r8 = r24;
        goto L15
    L9:
        r7 = r23;
        goto L11
    L5:
        r6 = r22;
        goto L7
    }
}
