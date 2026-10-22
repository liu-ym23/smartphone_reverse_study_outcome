package com.ss.android.lark.movable.attatchment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageParams;", "", "imgUrl", "", "imgType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getImgUrl", "()Ljava/lang/String;", "getImgType", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class n {

    @SerializedName("img_type")
    private final String imgType;

    @SerializedName("img_url")
    private final String imgUrl;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.imgUrl, r6.imgUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imgType, r6.imgType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.imgUrl.hashCode() * 31) + this.imgType.hashCode();
    }

    public final String toString() {
        return "ImageParams(imgUrl=" + this.imgUrl + ", imgType=" + this.imgType + ')';
    }

    public n() {
        Intrinsics.checkNotNullParameter("", "imgUrl");
        Intrinsics.checkNotNullParameter(LocationHitPoint$ResultType.DEFAULT, "imgType");
        this.imgUrl = "";
        this.imgType = LocationHitPoint$ResultType.DEFAULT;
    }

    public final String a() {
        return this.imgType;
    }

    public final String b() {
        return this.imgUrl;
    }
}
