package com.larus.uaigc.bean.remove;

import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "Ljava/io/Serializable;", "sendMsgImgStoragePath", "", "maskImgFilePath", "oriImgFilePath", "oriImgUri", "oriImgUrl", "imageUploadInfo", "Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;)V", "getSendMsgImgStoragePath", "()Ljava/lang/String;", "setSendMsgImgStoragePath", "(Ljava/lang/String;)V", "getMaskImgFilePath", "setMaskImgFilePath", "getOriImgFilePath", "setOriImgFilePath", "getOriImgUri", "setOriImgUri", "getOriImgUrl", "setOriImgUrl", "getImageUploadInfo", "()Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "setImageUploadInfo", "(Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageEditDataWithMask implements Serializable {
    private ImageUploadInfo imageUploadInfo;
    private String maskImgFilePath;
    private String oriImgFilePath;
    private String oriImgUri;
    private String oriImgUrl;
    private String sendMsgImgStoragePath;

    public ImageEditDataWithMask() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final ImageUploadInfo getImageUploadInfo() {
        return this.imageUploadInfo;
    }

    public final String getMaskImgFilePath() {
        return this.maskImgFilePath;
    }

    public final String getOriImgFilePath() {
        return this.oriImgFilePath;
    }

    public final String getOriImgUri() {
        return this.oriImgUri;
    }

    public final String getOriImgUrl() {
        return this.oriImgUrl;
    }

    public final String getSendMsgImgStoragePath() {
        return this.sendMsgImgStoragePath;
    }

    public final void setImageUploadInfo(ImageUploadInfo r1) {
        this.imageUploadInfo = r1;
    }

    public final void setMaskImgFilePath(String r1) {
        this.maskImgFilePath = r1;
    }

    public final void setOriImgFilePath(String r1) {
        this.oriImgFilePath = r1;
    }

    public final void setOriImgUri(String r1) {
        this.oriImgUri = r1;
    }

    public final void setOriImgUrl(String r1) {
        this.oriImgUrl = r1;
    }

    public final void setSendMsgImgStoragePath(String r1) {
        this.sendMsgImgStoragePath = r1;
    }

    public ImageEditDataWithMask(String r1, String r2, String r3, String r4, String r5, ImageUploadInfo r6) {
        this.sendMsgImgStoragePath = r1;
        this.maskImgFilePath = r2;
        this.oriImgFilePath = r3;
        this.oriImgUri = r4;
        this.oriImgUrl = r5;
        this.imageUploadInfo = r6;
    }

    public /* synthetic */ ImageEditDataWithMask(String r6, String r7, String r8, String r9, String r10, ImageUploadInfo r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        ImageUploadInfo r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
