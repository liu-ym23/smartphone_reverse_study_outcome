package com.larus.platform.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/api/OuterFallbackInfo;", "Ljava/io/Serializable;", "outerFallbackVideoItems", "", "", "outerShowCount", "", "<init>", "(Ljava/util/List;I)V", "getOuterFallbackVideoItems", "()Ljava/util/List;", "getOuterShowCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OuterFallbackInfo implements Serializable {

    @SerializedName("outer_fallback_video_items")
    private final List<String> outerFallbackVideoItems;

    @SerializedName("outer_show_count")
    private final int outerShowCount;

    public OuterFallbackInfo() {
        List r2 = null;
        this(r2, 0, 3, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuterFallbackInfo copy$default(OuterFallbackInfo r0, List r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.outerFallbackVideoItems;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.outerShowCount;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.outerFallbackVideoItems;
    }

    public final int component2() {
        return this.outerShowCount;
    }

    public final OuterFallbackInfo copy(List<String> r2, int r3) {
        return new OuterFallbackInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OuterFallbackInfo) == true) goto L8;
        return false;
    L8:
        OuterFallbackInfo r6 = (OuterFallbackInfo) r5;
        if (Intrinsics.areEqual(this.outerFallbackVideoItems, r6.outerFallbackVideoItems) == true) goto L12;
        return false;
    L12:
        if (this.outerShowCount == r6.outerShowCount) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.outerFallbackVideoItems;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.outerShowCount;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "OuterFallbackInfo(outerFallbackVideoItems=" + this.outerFallbackVideoItems + ", outerShowCount=" + this.outerShowCount + ')';
    }

    public final List<String> getOuterFallbackVideoItems() {
        return this.outerFallbackVideoItems;
    }

    public final int getOuterShowCount() {
        return this.outerShowCount;
    }

    public OuterFallbackInfo(List<String> r1, int r2) {
        this.outerFallbackVideoItems = r1;
        this.outerShowCount = r2;
    }

    public /* synthetic */ OuterFallbackInfo(List r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
