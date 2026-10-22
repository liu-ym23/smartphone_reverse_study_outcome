package com.ss.android.lark.keyboard.base;

import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ResourceUploadInfo;", "Ljava/io/Serializable;", "sendFileType", "Lcom/bytedance/lark/pb/basic/v1/ResourceFile$FileType;", "imageCompressInfo", "Lcom/ss/android/lark/keyboard/base/ImageCompressInfo;", "<init>", "(Lcom/bytedance/lark/pb/basic/v1/ResourceFile$FileType;Lcom/ss/android/lark/keyboard/base/ImageCompressInfo;)V", "getSendFileType", "()Lcom/bytedance/lark/pb/basic/v1/ResourceFile$FileType;", "getImageCompressInfo", "()Lcom/ss/android/lark/keyboard/base/ImageCompressInfo;", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ResourceUploadInfo implements Serializable {
    private final ImageCompressInfo imageCompressInfo;
    private final ResourceFile.FileType sendFileType;

    public static /* synthetic */ ResourceUploadInfo copy$default(ResourceUploadInfo r0, ResourceFile.FileType r1, ImageCompressInfo r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.sendFileType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.imageCompressInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public final ResourceFile.FileType component1() {
        return this.sendFileType;
    }

    public final ImageCompressInfo component2() {
        return this.imageCompressInfo;
    }

    public final ResourceUploadInfo copy(ResourceFile.FileType r2, ImageCompressInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "sendFileType");
        return new ResourceUploadInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceUploadInfo) == true) goto L8;
        return false;
    L8:
        ResourceUploadInfo r6 = (ResourceUploadInfo) r5;
        if (this.sendFileType == r6.sendFileType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageCompressInfo, r6.imageCompressInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.sendFileType.hashCode() * 31;
        ImageCompressInfo r1 = this.imageCompressInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceUploadInfo(sendFileType=" + this.sendFileType + ", imageCompressInfo=" + this.imageCompressInfo + ')';
    }

    public final ImageCompressInfo getImageCompressInfo() {
        return this.imageCompressInfo;
    }

    public final ResourceFile.FileType getSendFileType() {
        return this.sendFileType;
    }

    public ResourceUploadInfo(ResourceFile.FileType r2, ImageCompressInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "sendFileType");
        this.sendFileType = r2;
        this.imageCompressInfo = r3;
    }

    public /* synthetic */ ResourceUploadInfo(ResourceFile.FileType r1, ImageCompressInfo r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
