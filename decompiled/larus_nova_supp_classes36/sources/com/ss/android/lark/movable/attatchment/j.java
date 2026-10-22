package com.ss.android.lark.movable.attatchment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageGalleryItem;", "", "originUrl", "", TabAppInfo.IMAGE_JSON_KEY, "caption", "isDriveImage", "", "isExtraLong", "width", "", "height", "itemViewFrame", "Lcom/ss/android/lark/movable/attatchment/CGFrame;", "imageViewSize", "Lcom/ss/android/lark/movable/attatchment/CGSize;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZFFLcom/ss/android/lark/movable/attatchment/CGFrame;Lcom/ss/android/lark/movable/attatchment/CGSize;)V", "getOriginUrl", "()Ljava/lang/String;", "getKey", "getCaption", "()Z", "getWidth", "()F", "getHeight", "getItemViewFrame", "()Lcom/ss/android/lark/movable/attatchment/CGFrame;", "getImageViewSize", "()Lcom/ss/android/lark/movable/attatchment/CGSize;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class j {

    @SerializedName("caption")
    private final String caption;

    @SerializedName("height")
    private final float height;

    @SerializedName("image_view_size")
    private final g imageViewSize;

    @SerializedName("is_drive_image")
    private final boolean isDriveImage;

    @SerializedName("is_extra_long")
    private final boolean isExtraLong;

    @SerializedName("item_view_frame")
    private final e itemViewFrame;

    @SerializedName(TabAppInfo.IMAGE_JSON_KEY)
    private final String key;

    @SerializedName("origin_url")
    private final String originUrl;

    @SerializedName("width")
    private final float width;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.originUrl, r6.originUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.caption, r6.caption) == true) goto L18;
        return false;
    L18:
        if (this.isDriveImage == r6.isDriveImage) goto L21;
        return false;
    L21:
        if (this.isExtraLong == r6.isExtraLong) goto L24;
        return false;
    L24:
        if (Float.compare(this.width, r6.width) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.height, r6.height) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.itemViewFrame, r6.itemViewFrame) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imageViewSize, r6.imageViewSize) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.originUrl.hashCode() * 31) + this.key.hashCode()) * 31) + this.caption.hashCode()) * 31;
        int r2 = 1231;
        if (this.isDriveImage == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.isExtraLong == true) goto L11;
        r2 = 1237;
    L11:
        return ((((((((r3 + r2) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31) + this.itemViewFrame.hashCode()) * 31) + this.imageViewSize.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageGalleryItem(originUrl=" + this.originUrl + ", key=" + this.key + ", caption=" + this.caption + ", isDriveImage=" + this.isDriveImage + ", isExtraLong=" + this.isExtraLong + ", width=" + this.width + ", height=" + this.height + ", itemViewFrame=" + this.itemViewFrame + ", imageViewSize=" + this.imageViewSize + ')';
    }

    public final String b() {
        return this.caption;
    }

    public final float c() {
        return this.height;
    }

    public final g d() {
        return this.imageViewSize;
    }

    public final e e() {
        return this.itemViewFrame;
    }

    public final String f() {
        return this.key;
    }

    public final String g() {
        return this.originUrl;
    }

    public final float h() {
        return this.width;
    }

    public final boolean i() {
        return this.isExtraLong;
    }

    public static j a(j r10, float r11, float r12, e r13, g r14) {
        String r1 = r10.originUrl;
        String r2 = r10.key;
        String r3 = r10.caption;
        boolean r4 = r10.isDriveImage;
        boolean r5 = r10.isExtraLong;
        Intrinsics.checkNotNullParameter(r1, "originUrl");
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "caption");
        Intrinsics.checkNotNullParameter(r13, "itemViewFrame");
        Intrinsics.checkNotNullParameter(r14, "imageViewSize");
        return new j(r1, r2, r3, r4, r5, r11, r12, r13, r14);
    }

    public j(String r2, String r3, String r4, boolean r5, boolean r6, float r7, float r8, e r9, g r10) {
        Intrinsics.checkNotNullParameter(r2, "originUrl");
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r4, "caption");
        Intrinsics.checkNotNullParameter(r9, "itemViewFrame");
        Intrinsics.checkNotNullParameter(r10, "imageViewSize");
        this.originUrl = r2;
        this.key = r3;
        this.caption = r4;
        this.isDriveImage = r5;
        this.isExtraLong = r6;
        this.width = r7;
        this.height = r8;
        this.itemViewFrame = r9;
        this.imageViewSize = r10;
    }
}
