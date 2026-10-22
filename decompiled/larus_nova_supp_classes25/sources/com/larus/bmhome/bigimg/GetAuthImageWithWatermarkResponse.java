package com.larus.bmhome.bigimg;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/bigimg/GetAuthImageWithWatermarkResponse;", "Ljava/io/Serializable;", "itemIdToUrl", "", "", "<init>", "(Ljava/util/Map;)V", "getItemIdToUrl", "()Ljava/util/Map;", "setItemIdToUrl", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GetAuthImageWithWatermarkResponse implements Serializable {

    @SerializedName("itemIDToUrl")
    private Map<String, String> itemIdToUrl;

    public GetAuthImageWithWatermarkResponse() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetAuthImageWithWatermarkResponse copy$default(GetAuthImageWithWatermarkResponse r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.itemIdToUrl;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, String> component1() {
        return this.itemIdToUrl;
    }

    public final GetAuthImageWithWatermarkResponse copy(Map<String, String> r2) {
        return new GetAuthImageWithWatermarkResponse(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof GetAuthImageWithWatermarkResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.itemIdToUrl, ((GetAuthImageWithWatermarkResponse) r4).itemIdToUrl) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Map<String, String> r0 = this.itemIdToUrl;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "GetAuthImageWithWatermarkResponse(itemIdToUrl=" + this.itemIdToUrl + ')';
    }

    public final Map<String, String> getItemIdToUrl() {
        return this.itemIdToUrl;
    }

    public GetAuthImageWithWatermarkResponse(Map<String, String> r1) {
        this.itemIdToUrl = r1;
    }

    public final void setItemIdToUrl(Map<String, String> r1) {
        this.itemIdToUrl = r1;
    }

    public /* synthetic */ GetAuthImageWithWatermarkResponse(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
