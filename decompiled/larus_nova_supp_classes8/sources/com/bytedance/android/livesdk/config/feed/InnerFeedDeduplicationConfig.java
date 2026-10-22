package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/InnerFeedDeduplicationConfig;", "", "enable", "", "enterSource", "", "", "maxCount", "", "(ZLjava/util/List;I)V", "getEnable", "()Z", "getEnterSource", "()Ljava/util/List;", "getMaxCount", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFeedDeduplicationConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enter_source")
    private final List<String> enterSource;

    @SerializedName("max_count")
    private final int maxCount;

    public InnerFeedDeduplicationConfig() {
        this(false, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InnerFeedDeduplicationConfig copy$default(InnerFeedDeduplicationConfig r0, boolean r1, List r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.enterSource;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.maxCount;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.enterSource;
    }

    public final int component3() {
        return this.maxCount;
    }

    public final InnerFeedDeduplicationConfig copy(boolean r2, List<String> r3, int r4) {
        return new InnerFeedDeduplicationConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof InnerFeedDeduplicationConfig) == false) goto L12;
        InnerFeedDeduplicationConfig r4 = (InnerFeedDeduplicationConfig) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterSource, r4.enterSource) == true) goto L10;
        return false;
    L10:
        if (this.maxCount == r4.maxCount) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<String> r3 = this.enterSource;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return ((r2 + r4) * 31) + this.maxCount;
    L8:
        r4 = 0;
        goto L10
    }

    public String toString() {
        return "InnerFeedDeduplicationConfig(enable=" + this.enable + ", enterSource=" + this.enterSource + ", maxCount=" + this.maxCount + ")";
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getEnterSource() {
        return this.enterSource;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public InnerFeedDeduplicationConfig(boolean r1, List<String> r2, int r3) {
        this.enable = r1;
        this.enterSource = r2;
        this.maxCount = r3;
    }

    public /* synthetic */ InnerFeedDeduplicationConfig(boolean r1, List r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = 60;
    L11:
        this(r1, r2, r3);
    }
}
