package com.larus.extension.chat_extension.impl;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/extension/chat_extension/impl/RecommendVideos;", "Ljava/io/Serializable;", "ext", "", "", "itemIds", "", "hasMore", "", "<init>", "(Ljava/util/Map;Ljava/util/List;Z)V", "getExt", "()Ljava/util/Map;", "getItemIds", "()Ljava/util/List;", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RecommendVideos implements Serializable {

    @SerializedName("ext")
    private final Map<String, String> ext;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("item_ids")
    private final List<String> itemIds;

    public RecommendVideos() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendVideos copy$default(RecommendVideos r0, Map r1, List r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.ext;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.itemIds;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.hasMore;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Map<String, String> component1() {
        return this.ext;
    }

    public final List<String> component2() {
        return this.itemIds;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final RecommendVideos copy(Map<String, String> r2, List<String> r3, boolean r4) {
        return new RecommendVideos(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RecommendVideos) == true) goto L8;
        return false;
    L8:
        RecommendVideos r6 = (RecommendVideos) r5;
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemIds, r6.itemIds) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Map<String, String> r0 = this.ext;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.itemIds;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        if (this.hasMore == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RecommendVideos(ext=" + this.ext + ", itemIds=" + this.itemIds + ", hasMore=" + this.hasMore + ')';
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<String> getItemIds() {
        return this.itemIds;
    }

    public RecommendVideos(Map<String, String> r1, List<String> r2, boolean r3) {
        this.ext = r1;
        this.itemIds = r2;
        this.hasMore = r3;
    }

    public /* synthetic */ RecommendVideos(Map r2, List r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}
