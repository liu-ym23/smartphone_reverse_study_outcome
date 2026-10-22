package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003JI\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedDynamicConfig;", "", "enable", "", "dynamicOutFlow", "", "Lcom/bytedance/android/livesdk/config/feed/LiveFeedDynamic;", "dynamicInnerFlow", "dynamicDrawer", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDynamicDrawer", "()Ljava/util/List;", "getDynamicInnerFlow", "getDynamicOutFlow", "getEnable", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedDynamicConfig {

    @SerializedName("live_feed_dynamic_drawer")
    private final List<LiveFeedDynamic> dynamicDrawer;

    @SerializedName("live_feed_dynamic_innerflow")
    private final List<LiveFeedDynamic> dynamicInnerFlow;

    @SerializedName("live_feed_dynamic_outflow")
    private final List<LiveFeedDynamic> dynamicOutFlow;

    @SerializedName("enable")
    private final boolean enable;

    public LiveFeedDynamicConfig() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveFeedDynamicConfig copy$default(LiveFeedDynamicConfig r0, boolean r1, List r2, List r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.dynamicOutFlow;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.dynamicInnerFlow;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.dynamicDrawer;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<LiveFeedDynamic> component2() {
        return this.dynamicOutFlow;
    }

    public final List<LiveFeedDynamic> component3() {
        return this.dynamicInnerFlow;
    }

    public final List<LiveFeedDynamic> component4() {
        return this.dynamicDrawer;
    }

    public final LiveFeedDynamicConfig copy(boolean r2, List<LiveFeedDynamic> r3, List<LiveFeedDynamic> r4, List<LiveFeedDynamic> r5) {
        return new LiveFeedDynamicConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveFeedDynamicConfig) == false) goto L14;
        LiveFeedDynamicConfig r4 = (LiveFeedDynamicConfig) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dynamicOutFlow, r4.dynamicOutFlow) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dynamicInnerFlow, r4.dynamicInnerFlow) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dynamicDrawer, r4.dynamicDrawer) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<LiveFeedDynamic> r3 = this.dynamicOutFlow;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        List<LiveFeedDynamic> r7 = this.dynamicInnerFlow;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        List<LiveFeedDynamic> r10 = this.dynamicDrawer;
        if (r10 == null) goto L17;
        r4 = r10.hashCode();
    L17:
        return r9 + r4;
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public String toString() {
        return "LiveFeedDynamicConfig(enable=" + this.enable + ", dynamicOutFlow=" + this.dynamicOutFlow + ", dynamicInnerFlow=" + this.dynamicInnerFlow + ", dynamicDrawer=" + this.dynamicDrawer + ")";
    }

    public final List<LiveFeedDynamic> getDynamicDrawer() {
        return this.dynamicDrawer;
    }

    public final List<LiveFeedDynamic> getDynamicInnerFlow() {
        return this.dynamicInnerFlow;
    }

    public final List<LiveFeedDynamic> getDynamicOutFlow() {
        return this.dynamicOutFlow;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public LiveFeedDynamicConfig(boolean r1, List<LiveFeedDynamic> r2, List<LiveFeedDynamic> r3, List<LiveFeedDynamic> r4) {
        this.enable = r1;
        this.dynamicOutFlow = r2;
        this.dynamicInnerFlow = r3;
        this.dynamicDrawer = r4;
    }

    public /* synthetic */ LiveFeedDynamicConfig(boolean r2, List r3, List r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
