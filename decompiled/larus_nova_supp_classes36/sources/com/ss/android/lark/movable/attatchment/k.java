package com.ss.android.lark.movable.attatchment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageInfo;", "", "attachmentInfo", "Lcom/ss/android/lark/movable/attatchment/AttachmentInfo;", "imageParams", "Lcom/ss/android/lark/movable/attatchment/ImageParams;", "<init>", "(Lcom/ss/android/lark/movable/attatchment/AttachmentInfo;Lcom/ss/android/lark/movable/attatchment/ImageParams;)V", "getAttachmentInfo", "()Lcom/ss/android/lark/movable/attatchment/AttachmentInfo;", "getImageParams", "()Lcom/ss/android/lark/movable/attatchment/ImageParams;", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class k {

    @SerializedName("attachmentInfo")
    private final b attachmentInfo;

    @SerializedName("imageParams")
    private final n imageParams;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.attachmentInfo, r6.attachmentInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageParams, r6.imageParams) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.attachmentInfo.hashCode() * 31) + this.imageParams.hashCode();
    }

    public final String toString() {
        return "ImageInfo(attachmentInfo=" + this.attachmentInfo + ", imageParams=" + this.imageParams + ')';
    }

    public final n a() {
        return this.imageParams;
    }

    public k(b r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "attachmentInfo");
        Intrinsics.checkNotNullParameter(r3, "imageParams");
        this.attachmentInfo = r2;
        this.imageParams = r3;
    }
}
