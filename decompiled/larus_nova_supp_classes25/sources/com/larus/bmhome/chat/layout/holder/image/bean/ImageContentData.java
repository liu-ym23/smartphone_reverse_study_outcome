package com.larus.bmhome.chat.layout.holder.image.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageContentData;", "Ljava/io/Serializable;", "imageList", "", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItem;", "<init>", "(Ljava/util/List;)V", "getImageList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImageContentData implements Serializable {

    @SerializedName("image_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<ImageItem> imageList;

    public ImageContentData() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageContentData copy$default(ImageContentData r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.imageList;
    L6:
        return r0.copy(r1);
    }

    public final List<ImageItem> component1() {
        return this.imageList;
    }

    public final ImageContentData copy(List<ImageItem> r2) {
        return new ImageContentData(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ImageContentData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.imageList, ((ImageContentData) r4).imageList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ImageItem> r0 = this.imageList;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ImageContentData(imageList=" + this.imageList + ')';
    }

    public final List<ImageItem> getImageList() {
        return this.imageList;
    }

    public ImageContentData(List<ImageItem> r1) {
        this.imageList = r1;
    }

    public /* synthetic */ ImageContentData(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        this(r1);
    }
}
