package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedDynamic;", "", "enterSource", "", "liveFeedUrl", "canDraw", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCanDraw", "()Z", "getEnterSource", "()Ljava/lang/String;", "getLiveFeedUrl", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedDynamic {

    @SerializedName("can_draw")
    private final boolean canDraw;

    @SerializedName("enter_source")
    private final String enterSource;

    @SerializedName("live_feed_url")
    private final String liveFeedUrl;

    public LiveFeedDynamic() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ LiveFeedDynamic copy$default(LiveFeedDynamic r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enterSource;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.liveFeedUrl;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.canDraw;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.enterSource;
    }

    public final String component2() {
        return this.liveFeedUrl;
    }

    public final boolean component3() {
        return this.canDraw;
    }

    public final LiveFeedDynamic copy(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "liveFeedUrl");
        return new LiveFeedDynamic(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveFeedDynamic) == false) goto L12;
        LiveFeedDynamic r4 = (LiveFeedDynamic) r3;
        if (Intrinsics.areEqual(this.enterSource, r4.enterSource) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveFeedUrl, r4.liveFeedUrl) == true) goto L10;
        return false;
    L10:
        if (this.canDraw == r4.canDraw) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.enterSource;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.liveFeedUrl;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.canDraw;
        ?? r7 = r6;
        if (r6 == false) goto L13;
        r7 = 1;
    L13:
        return r5 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LiveFeedDynamic(enterSource=" + this.enterSource + ", liveFeedUrl=" + this.liveFeedUrl + ", canDraw=" + this.canDraw + ")";
    }

    public final boolean getCanDraw() {
        return this.canDraw;
    }

    public final String getEnterSource() {
        return this.enterSource;
    }

    public final String getLiveFeedUrl() {
        return this.liveFeedUrl;
    }

    public LiveFeedDynamic(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "liveFeedUrl");
        this.enterSource = r2;
        this.liveFeedUrl = r3;
        this.canDraw = r4;
    }

    public /* synthetic */ LiveFeedDynamic(String r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        this(r2, r3, r4);
    }
}
