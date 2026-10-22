package com.ss.android.lark.chameleonv2.lkapi.resource;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "target", BuildConfig.FLAVOR, "filePath", "fileName", "uploadId", "mountPoint", "mountPointToken", "ext", "Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadExtInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadExtInfo;)V", "getTarget", "()Ljava/lang/String;", "getFilePath", "getFileName", "getUploadId", "getMountPoint", "getMountPointToken", "getExt", "()Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadExtInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IResource$Internal$ResourceUploadRequest implements NonProguard {
    private final IResource$Internal$ResourceUploadExtInfo ext;
    private final String fileName;
    private final String filePath;
    private final String mountPoint;
    private final String mountPointToken;
    private final String target;
    private final String uploadId;

    public static /* synthetic */ IResource$Internal$ResourceUploadRequest copy$default(IResource$Internal$ResourceUploadRequest r5, String r6, String r7, String r8, String r9, String r10, String r11, IResource$Internal$ResourceUploadExtInfo r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.target;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.filePath;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.fileName;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.uploadId;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.mountPoint;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.mountPointToken;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.ext;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.target;
    }

    public final String component2() {
        return this.filePath;
    }

    public final String component3() {
        return this.fileName;
    }

    public final String component4() {
        return this.uploadId;
    }

    public final String component5() {
        return this.mountPoint;
    }

    public final String component6() {
        return this.mountPointToken;
    }

    public final IResource$Internal$ResourceUploadExtInfo component7() {
        return this.ext;
    }

    public final IResource$Internal$ResourceUploadRequest copy(String r10, String r11, String r12, String r13, String r14, String r15, IResource$Internal$ResourceUploadExtInfo r16) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        Intrinsics.checkNotNullParameter(r12, "fileName");
        Intrinsics.checkNotNullParameter(r13, "uploadId");
        Intrinsics.checkNotNullParameter(r14, "mountPoint");
        Intrinsics.checkNotNullParameter(r15, "mountPointToken");
        return new IResource$Internal$ResourceUploadRequest(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IResource$Internal$ResourceUploadRequest) == true) goto L8;
        return false;
    L8:
        IResource$Internal$ResourceUploadRequest r6 = (IResource$Internal$ResourceUploadRequest) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filePath, r6.filePath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadId, r6.uploadId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mountPoint, r6.mountPoint) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mountPointToken, r6.mountPointToken) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.target.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.fileName.hashCode()) * 31) + this.uploadId.hashCode()) * 31) + this.mountPoint.hashCode()) * 31) + this.mountPointToken.hashCode()) * 31;
        IResource$Internal$ResourceUploadExtInfo r1 = this.ext;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceUploadRequest(target=" + this.target + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", uploadId=" + this.uploadId + ", mountPoint=" + this.mountPoint + ", mountPointToken=" + this.mountPointToken + ", ext=" + this.ext + ')';
    }

    public final IResource$Internal$ResourceUploadExtInfo getExt() {
        return this.ext;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getMountPoint() {
        return this.mountPoint;
    }

    public final String getMountPointToken() {
        return this.mountPointToken;
    }

    public final String getTarget() {
        return this.target;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    public IResource$Internal$ResourceUploadRequest(String r2, String r3, String r4, String r5, String r6, String r7, IResource$Internal$ResourceUploadExtInfo r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "filePath");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "uploadId");
        Intrinsics.checkNotNullParameter(r6, "mountPoint");
        Intrinsics.checkNotNullParameter(r7, "mountPointToken");
        this.target = r2;
        this.filePath = r3;
        this.fileName = r4;
        this.uploadId = r5;
        this.mountPoint = r6;
        this.mountPointToken = r7;
        this.ext = r8;
    }
}
