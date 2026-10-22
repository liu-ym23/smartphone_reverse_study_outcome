package com.larus.bmhome.chat.layout.holder.video.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;", "Ljava/io/Serializable;", "key", "", "imageThumb", "Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;", "previewImage", "imageUri", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getImageThumb", "()Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverImageEntity;", "getPreviewImage", "getImageUri", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CoverItem implements Serializable {

    @SerializedName("image_thumb")
    private final CoverImageEntity imageThumb;

    @SerializedName("image_uri")
    private final String imageUri;

    @SerializedName("key")
    private final String key;

    @SerializedName("preview_img")
    private final CoverImageEntity previewImage;

    public CoverItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CoverItem copy$default(CoverItem r0, String r1, CoverImageEntity r2, CoverImageEntity r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.imageThumb;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.previewImage;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.imageUri;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.key;
    }

    public final CoverImageEntity component2() {
        return this.imageThumb;
    }

    public final CoverImageEntity component3() {
        return this.previewImage;
    }

    public final String component4() {
        return this.imageUri;
    }

    public final CoverItem copy(String r2, CoverImageEntity r3, CoverImageEntity r4, String r5) {
        return new CoverItem(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CoverItem) == true) goto L8;
        return false;
    L8:
        CoverItem r6 = (CoverItem) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageThumb, r6.imageThumb) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewImage, r6.previewImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUri, r6.imageUri) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CoverImageEntity r4 = this.imageThumb;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CoverImageEntity r7 = this.previewImage;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.imageUri;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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

    public String toString() {
        return "CoverItem(key=" + this.key + ", imageThumb=" + this.imageThumb + ", previewImage=" + this.previewImage + ", imageUri=" + this.imageUri + ')';
    }

    public final CoverImageEntity getImageThumb() {
        return this.imageThumb;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final String getKey() {
        return this.key;
    }

    public final CoverImageEntity getPreviewImage() {
        return this.previewImage;
    }

    public CoverItem(String r1, CoverImageEntity r2, CoverImageEntity r3, String r4) {
        this.key = r1;
        this.imageThumb = r2;
        this.previewImage = r3;
        this.imageUri = r4;
    }

    public /* synthetic */ CoverItem(String r2, CoverImageEntity r3, CoverImageEntity r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
