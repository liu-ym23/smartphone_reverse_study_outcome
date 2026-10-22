package com.ss.android.lark.feed.shared.data.appconfig;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "im_batch_clear_badge_switch_526")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003Ja\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/feed/shared/data/appconfig/FeedClearBadgeConfigValue;", BuildConfig.FLAVOR, "feedGroupSwitchMap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "feedEntitySwitchMap", "secondaryFilterSwitchMap", "otherSwitchMap", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getFeedGroupSwitchMap", "()Ljava/util/Map;", "getFeedEntitySwitchMap", "getSecondaryFilterSwitchMap", "getOtherSwitchMap", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedClearBadgeConfigValue {

    @SerializedName("feedEntitySwitch")
    private final Map<String, Boolean> feedEntitySwitchMap;

    @SerializedName("feedgroup")
    private final Map<String, Boolean> feedGroupSwitchMap;

    @SerializedName("other")
    private final Map<String, Boolean> otherSwitchMap;

    @SerializedName("secondary_filter")
    private final Map<String, Boolean> secondaryFilterSwitchMap;

    public FeedClearBadgeConfigValue() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedClearBadgeConfigValue copy$default(FeedClearBadgeConfigValue r0, Map r1, Map r2, Map r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.feedGroupSwitchMap;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.feedEntitySwitchMap;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.secondaryFilterSwitchMap;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.otherSwitchMap;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Map<String, Boolean> component1() {
        return this.feedGroupSwitchMap;
    }

    public final Map<String, Boolean> component2() {
        return this.feedEntitySwitchMap;
    }

    public final Map<String, Boolean> component3() {
        return this.secondaryFilterSwitchMap;
    }

    public final Map<String, Boolean> component4() {
        return this.otherSwitchMap;
    }

    public final FeedClearBadgeConfigValue copy(Map<String, Boolean> r2, Map<String, Boolean> r3, Map<String, Boolean> r4, Map<String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupSwitchMap");
        Intrinsics.checkNotNullParameter(r3, "feedEntitySwitchMap");
        Intrinsics.checkNotNullParameter(r4, "secondaryFilterSwitchMap");
        Intrinsics.checkNotNullParameter(r5, "otherSwitchMap");
        return new FeedClearBadgeConfigValue(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeedClearBadgeConfigValue) == true) goto L8;
        return false;
    L8:
        FeedClearBadgeConfigValue r6 = (FeedClearBadgeConfigValue) r5;
        if (Intrinsics.areEqual(this.feedGroupSwitchMap, r6.feedGroupSwitchMap) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedEntitySwitchMap, r6.feedEntitySwitchMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.secondaryFilterSwitchMap, r6.secondaryFilterSwitchMap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.otherSwitchMap, r6.otherSwitchMap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.feedGroupSwitchMap.hashCode() * 31) + this.feedEntitySwitchMap.hashCode()) * 31) + this.secondaryFilterSwitchMap.hashCode()) * 31) + this.otherSwitchMap.hashCode();
    }

    public String toString() {
        return "FeedClearBadgeConfigValue(feedGroupSwitchMap=" + this.feedGroupSwitchMap + ", feedEntitySwitchMap=" + this.feedEntitySwitchMap + ", secondaryFilterSwitchMap=" + this.secondaryFilterSwitchMap + ", otherSwitchMap=" + this.otherSwitchMap + ')';
    }

    public final Map<String, Boolean> getFeedEntitySwitchMap() {
        return this.feedEntitySwitchMap;
    }

    public final Map<String, Boolean> getFeedGroupSwitchMap() {
        return this.feedGroupSwitchMap;
    }

    public final Map<String, Boolean> getOtherSwitchMap() {
        return this.otherSwitchMap;
    }

    public final Map<String, Boolean> getSecondaryFilterSwitchMap() {
        return this.secondaryFilterSwitchMap;
    }

    public FeedClearBadgeConfigValue(Map<String, Boolean> r2, Map<String, Boolean> r3, Map<String, Boolean> r4, Map<String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupSwitchMap");
        Intrinsics.checkNotNullParameter(r3, "feedEntitySwitchMap");
        Intrinsics.checkNotNullParameter(r4, "secondaryFilterSwitchMap");
        Intrinsics.checkNotNullParameter(r5, "otherSwitchMap");
        this.feedGroupSwitchMap = r2;
        this.feedEntitySwitchMap = r3;
        this.secondaryFilterSwitchMap = r4;
        this.otherSwitchMap = r5;
    }

    public /* synthetic */ FeedClearBadgeConfigValue(Map r1, Map r2, Map r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = MapsKt.emptyMap();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = MapsKt.emptyMap();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = MapsKt.emptyMap();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = MapsKt.emptyMap();
    L14:
        this(r1, r2, r3, r4);
    }
}
