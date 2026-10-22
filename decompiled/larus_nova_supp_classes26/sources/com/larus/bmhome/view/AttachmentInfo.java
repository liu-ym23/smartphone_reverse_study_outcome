package com.larus.bmhome.view;

import com.larus.im.bean.message.Image;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100JÒ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0007HÖ\u0001J\t\u0010I\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100¨\u0006J"}, d2 = {"Lcom/larus/bmhome/view/AttachmentInfo;", "Ljava/io/Serializable;", "isImage", "", "tosKey", "", "height", "", "width", "filePath", "fileName", "fromScene", "resourceId", "fileIdentifier", "actionBarKey", "enterMethod", "serverUrl", "previewUrl", "instantUploadInfo", "Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;", "image", "Lcom/larus/im/bean/message/Image;", "localMessageId", "aiCreationImage", "<init>", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;Lcom/larus/im/bean/message/Image;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Z", "getTosKey", "()Ljava/lang/String;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "getFilePath", "getFileName", "getFromScene", "getResourceId", "getFileIdentifier", "getActionBarKey", "getEnterMethod", "getServerUrl", "getPreviewUrl", "getInstantUploadInfo", "()Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;", "getImage", "()Lcom/larus/im/bean/message/Image;", "getLocalMessageId", "getAiCreationImage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;Lcom/larus/im/bean/message/Image;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/view/AttachmentInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentInfo implements Serializable {
    private final String actionBarKey;
    private final Boolean aiCreationImage;
    private final String enterMethod;
    private final String fileIdentifier;
    private final String fileName;
    private final String filePath;
    private final String fromScene;
    private final Integer height;
    private final Image image;
    private final ResourceUploadInstantInfo instantUploadInfo;
    private final boolean isImage;
    private final String localMessageId;
    private final String previewUrl;
    private final String resourceId;
    private final String serverUrl;
    private final String tosKey;
    private final Integer width;

    public static /* synthetic */ AttachmentInfo copy$default(AttachmentInfo r17, boolean r18, String r19, Integer r20, Integer r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, ResourceUploadInstantInfo r31, Image r32, String r33, Boolean r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        boolean r2 = r17.isImage;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r3 = r17.tosKey;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Integer r4 = r17.height;
    L15:
        if ((r35 & 8) == 0) goto L17;
        Integer r5 = r17.width;
    L19:
        if ((r35 & 16) == 0) goto L21;
        String r6 = r17.filePath;
    L23:
        if ((r35 & 32) == 0) goto L25;
        String r7 = r17.fileName;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r8 = r17.fromScene;
    L31:
        if ((r35 & 128) == 0) goto L33;
        String r9 = r17.resourceId;
    L35:
        if ((r35 & 256) == 0) goto L37;
        String r10 = r17.fileIdentifier;
    L39:
        if ((r35 & 512) == 0) goto L41;
        String r11 = r17.actionBarKey;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        String r12 = r17.enterMethod;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        String r13 = r17.serverUrl;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        String r14 = r17.previewUrl;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        ResourceUploadInstantInfo r15 = r17.instantUploadInfo;
    L58:
        ResourceUploadInstantInfo r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        Image r16 = r17.image;
    L62:
        Image r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        String r110 = r17.localMessageId;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        Boolean r1 = r17.aiCreationImage;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final boolean component1() {
        return this.isImage;
    }

    public final String component10() {
        return this.actionBarKey;
    }

    public final String component11() {
        return this.enterMethod;
    }

    public final String component12() {
        return this.serverUrl;
    }

    public final String component13() {
        return this.previewUrl;
    }

    public final ResourceUploadInstantInfo component14() {
        return this.instantUploadInfo;
    }

    public final Image component15() {
        return this.image;
    }

    public final String component16() {
        return this.localMessageId;
    }

    public final Boolean component17() {
        return this.aiCreationImage;
    }

    public final String component2() {
        return this.tosKey;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Integer component4() {
        return this.width;
    }

    public final String component5() {
        return this.filePath;
    }

    public final String component6() {
        return this.fileName;
    }

    public final String component7() {
        return this.fromScene;
    }

    public final String component8() {
        return this.resourceId;
    }

    public final String component9() {
        return this.fileIdentifier;
    }

    public final AttachmentInfo copy(boolean r20, String r21, Integer r22, Integer r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, ResourceUploadInstantInfo r33, Image r34, String r35, Boolean r36) {
        Intrinsics.checkNotNullParameter(r21, "tosKey");
        Intrinsics.checkNotNullParameter(r24, "filePath");
        Intrinsics.checkNotNullParameter(r26, "fromScene");
        return new AttachmentInfo(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AttachmentInfo) == true) goto L8;
        return false;
    L8:
        AttachmentInfo r6 = (AttachmentInfo) r5;
        if (this.isImage == r6.isImage) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tosKey, r6.tosKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.filePath, r6.filePath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fromScene, r6.fromScene) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.resourceId, r6.resourceId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileIdentifier, r6.fileIdentifier) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actionBarKey, r6.actionBarKey) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.serverUrl, r6.serverUrl) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.previewUrl, r6.previewUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.instantUploadInfo, r6.instantUploadInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.image, r6.image) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.localMessageId, r6.localMessageId) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.aiCreationImage, r6.aiCreationImage) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        if (this.isImage == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.tosKey.hashCode()) * 31;
        Integer r2 = this.height;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        Integer r6 = this.width;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r5 + r7) * 31) + this.filePath.hashCode()) * 31;
        String r9 = this.fileName;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (((r8 + r10) * 31) + this.fromScene.hashCode()) * 31;
        String r12 = this.resourceId;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.fileIdentifier;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        String r18 = this.actionBarKey;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.enterMethod;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        String r24 = this.serverUrl;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        String r27 = this.previewUrl;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        ResourceUploadInstantInfo r30 = this.instantUploadInfo;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        Image r33 = this.image;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        String r36 = this.localMessageId;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        Boolean r39 = this.aiCreationImage;
        if (r39 == null) goto L59;
        r3 = r39.hashCode();
    L59:
        return r38 + r3;
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "AttachmentInfo(isImage=" + this.isImage + ", tosKey=" + this.tosKey + ", height=" + this.height + ", width=" + this.width + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", fromScene=" + this.fromScene + ", resourceId=" + this.resourceId + ", fileIdentifier=" + this.fileIdentifier + ", actionBarKey=" + this.actionBarKey + ", enterMethod=" + this.enterMethod + ", serverUrl=" + this.serverUrl + ", previewUrl=" + this.previewUrl + ", instantUploadInfo=" + this.instantUploadInfo + ", image=" + this.image + ", localMessageId=" + this.localMessageId + ", aiCreationImage=" + this.aiCreationImage + ')';
    }

    public final String getActionBarKey() {
        return this.actionBarKey;
    }

    public final Boolean getAiCreationImage() {
        return this.aiCreationImage;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Image getImage() {
        return this.image;
    }

    public final ResourceUploadInstantInfo getInstantUploadInfo() {
        return this.instantUploadInfo;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getServerUrl() {
        return this.serverUrl;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final boolean isImage() {
        return this.isImage;
    }

    public AttachmentInfo(boolean r6, String r7, Integer r8, Integer r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, ResourceUploadInstantInfo r19, Image r20, String r21, Boolean r22) {
        Intrinsics.checkNotNullParameter(r7, "tosKey");
        Intrinsics.checkNotNullParameter(r10, "filePath");
        Intrinsics.checkNotNullParameter(r12, "fromScene");
        this.isImage = r6;
        this.tosKey = r7;
        this.height = r8;
        this.width = r9;
        this.filePath = r10;
        this.fileName = r11;
        this.fromScene = r12;
        this.resourceId = r13;
        this.fileIdentifier = r14;
        this.actionBarKey = r15;
        this.enterMethod = r16;
        this.serverUrl = r17;
        this.previewUrl = r18;
        this.instantUploadInfo = r19;
        this.image = r20;
        this.localMessageId = r21;
        this.aiCreationImage = r22;
    }

    public /* synthetic */ AttachmentInfo(boolean r21, String r22, Integer r23, Integer r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, ResourceUploadInstantInfo r34, Image r35, String r36, Boolean r37, int r38, DefaultConstructorMarker r39) {
        if ((r38 & 1) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r38 & 4) == 0) goto L9;
        Integer r5 = null;
    L11:
        if ((r38 & 8) == 0) goto L13;
        Integer r6 = null;
    L15:
        if ((r38 & 32) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r38 & 128) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r38 & 256) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r38 & 512) == 0) goto L29;
        String r12 = null;
    L31:
        if ((r38 & 1024) == 0) goto L33;
        String r13 = null;
    L35:
        if ((r38 & 2048) == 0) goto L37;
        String r14 = null;
    L39:
        if ((r38 & 4096) == 0) goto L41;
        String r15 = null;
    L43:
        if ((r38 & 8192) == 0) goto L45;
        ResourceUploadInstantInfo r16 = null;
    L47:
        if ((r38 & 16384) == 0) goto L49;
        Image r17 = null;
    L51:
        if ((32768 & r38) == 0) goto L53;
        String r18 = null;
    L55:
        if ((r38 & 65536) == 0) goto L57;
        Boolean r19 = null;
    L58:
        this(r3, r22, r5, r6, r25, r8, r27, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L57:
        r19 = r37;
        goto L58
    L53:
        r18 = r36;
        goto L55
    L49:
        r17 = r35;
        goto L51
    L45:
        r16 = r34;
        goto L47
    L41:
        r15 = r33;
        goto L43
    L37:
        r14 = r32;
        goto L39
    L33:
        r13 = r31;
        goto L35
    L29:
        r12 = r30;
        goto L31
    L25:
        r11 = r29;
        goto L27
    L21:
        r10 = r28;
        goto L23
    L17:
        r8 = r26;
        goto L19
    L13:
        r6 = r24;
        goto L15
    L9:
        r5 = r23;
        goto L11
    L5:
        r3 = r21;
        goto L7
    }
}
