package ic8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016Jb\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\n\u0010\u0016¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/bean/ImageItem;", "", "key", "", "requestId", "imageThumb", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;", "imageOrigin", "previewImage", "feedback", "isPlaceHolderImg", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Ljava/lang/String;Ljava/lang/Boolean;)V", "getKey", "()Ljava/lang/String;", "getRequestId", "getImageThumb", "()Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;", "getImageOrigin", "getPreviewImage", "getFeedback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/bean/ImageItem;", "equals", "other", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class a0 {

    @SerializedName("feedback")
    private final String feedback;

    @SerializedName("image_ori")
    private final ImageEntity imageOrigin;

    @SerializedName("image_thumb")
    private final ImageEntity imageThumb;

    @SerializedName("placeholder_img")
    private final Boolean isPlaceHolderImg;

    @SerializedName("key")
    private final String key;

    @SerializedName("preview_img")
    private final ImageEntity previewImage;

    @SerializedName("request_id")
    private final String requestId;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageThumb, r6.imageThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOrigin, r6.imageOrigin) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.previewImage, r6.previewImage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.feedback, r6.feedback) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isPlaceHolderImg, r6.isPlaceHolderImg) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.requestId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ImageEntity r7 = this.imageThumb;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ImageEntity r10 = this.imageOrigin;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ImageEntity r13 = this.previewImage;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.feedback;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.isPlaceHolderImg;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageItem(key=" + this.key + ", requestId=" + this.requestId + ", imageThumb=" + this.imageThumb + ", imageOrigin=" + this.imageOrigin + ", previewImage=" + this.previewImage + ", feedback=" + this.feedback + ", isPlaceHolderImg=" + this.isPlaceHolderImg + ')';
    }

    public a0() {
        Boolean r0 = Boolean.FALSE;
        this.key = null;
        this.requestId = null;
        this.imageThumb = null;
        this.imageOrigin = null;
        this.previewImage = null;
        this.feedback = null;
        this.isPlaceHolderImg = r0;
    }
}
