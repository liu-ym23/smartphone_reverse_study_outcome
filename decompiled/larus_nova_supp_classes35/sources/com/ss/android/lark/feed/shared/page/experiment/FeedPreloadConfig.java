package com.ss.android.lark.feed.shared.page.experiment;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/experiment/FeedPreloadConfig;", BuildConfig.FLAVOR, "isPreloadAtFeedPrefetch", BuildConfig.FLAVOR, "isPreloadAtNotification", "isPreloadAtShorts", "isPreloadAtFilter", "isPreloadAtFlag", "isPreloadAtTabClick", "isPreloadPriorityEnabled", "isPreloadInterruptable", "<init>", "(ZZZZZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedPreloadConfig {

    @SerializedName("is_preload_at_feed_prefetch")
    private final boolean isPreloadAtFeedPrefetch;

    @SerializedName("is_preload_at_filter")
    private final boolean isPreloadAtFilter;

    @SerializedName("is_preload_at_flag")
    private final boolean isPreloadAtFlag;

    @SerializedName("is_preload_at_notification")
    private final boolean isPreloadAtNotification;

    @SerializedName("is_preload_at_shorts")
    private final boolean isPreloadAtShorts;

    @SerializedName("is_preload_at_tab_click")
    private final boolean isPreloadAtTabClick;

    @SerializedName("is_preload_interruptable")
    private final boolean isPreloadInterruptable;

    @SerializedName("is_preload_priority_enabled")
    private final boolean isPreloadPriorityEnabled;

    public FeedPreloadConfig() {
        this(false, false, false, false, false, false, false, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    }

    public static /* synthetic */ FeedPreloadConfig copy$default(FeedPreloadConfig r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r2 = r9.isPreloadAtFeedPrefetch;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r3 = r9.isPreloadAtNotification;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r4 = r9.isPreloadAtShorts;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.isPreloadAtFilter;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.isPreloadAtFlag;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.isPreloadAtTabClick;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.isPreloadPriorityEnabled;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.isPreloadInterruptable;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final boolean component1() {
        return this.isPreloadAtFeedPrefetch;
    }

    public final boolean component2() {
        return this.isPreloadAtNotification;
    }

    public final boolean component3() {
        return this.isPreloadAtShorts;
    }

    public final boolean component4() {
        return this.isPreloadAtFilter;
    }

    public final boolean component5() {
        return this.isPreloadAtFlag;
    }

    public final boolean component6() {
        return this.isPreloadAtTabClick;
    }

    public final boolean component7() {
        return this.isPreloadPriorityEnabled;
    }

    public final boolean component8() {
        return this.isPreloadInterruptable;
    }

    public final FeedPreloadConfig copy(boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        return new FeedPreloadConfig(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeedPreloadConfig) == true) goto L8;
        return false;
    L8:
        FeedPreloadConfig r6 = (FeedPreloadConfig) r5;
        if (this.isPreloadAtFeedPrefetch == r6.isPreloadAtFeedPrefetch) goto L12;
        return false;
    L12:
        if (this.isPreloadAtNotification == r6.isPreloadAtNotification) goto L15;
        return false;
    L15:
        if (this.isPreloadAtShorts == r6.isPreloadAtShorts) goto L18;
        return false;
    L18:
        if (this.isPreloadAtFilter == r6.isPreloadAtFilter) goto L21;
        return false;
    L21:
        if (this.isPreloadAtFlag == r6.isPreloadAtFlag) goto L24;
        return false;
    L24:
        if (this.isPreloadAtTabClick == r6.isPreloadAtTabClick) goto L27;
        return false;
    L27:
        if (this.isPreloadPriorityEnabled == r6.isPreloadPriorityEnabled) goto L30;
        return false;
    L30:
        if (this.isPreloadInterruptable == r6.isPreloadInterruptable) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isPreloadAtFeedPrefetch == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isPreloadAtNotification == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.isPreloadAtShorts == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.isPreloadAtFilter == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.isPreloadAtFlag == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.isPreloadAtTabClick == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.isPreloadPriorityEnabled == false) goto L29;
        int r13 = 1231;
    L30:
        int r14 = (r12 + r13) * 31;
        if (this.isPreloadInterruptable == true) goto L35;
        r1 = 1237;
    L35:
        return r14 + r1;
    L29:
        r13 = 1237;
        goto L30
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "FeedPreloadConfig(isPreloadAtFeedPrefetch=" + this.isPreloadAtFeedPrefetch + ", isPreloadAtNotification=" + this.isPreloadAtNotification + ", isPreloadAtShorts=" + this.isPreloadAtShorts + ", isPreloadAtFilter=" + this.isPreloadAtFilter + ", isPreloadAtFlag=" + this.isPreloadAtFlag + ", isPreloadAtTabClick=" + this.isPreloadAtTabClick + ", isPreloadPriorityEnabled=" + this.isPreloadPriorityEnabled + ", isPreloadInterruptable=" + this.isPreloadInterruptable + ')';
    }

    public final boolean isPreloadAtFeedPrefetch() {
        return this.isPreloadAtFeedPrefetch;
    }

    public final boolean isPreloadAtFilter() {
        return this.isPreloadAtFilter;
    }

    public final boolean isPreloadAtFlag() {
        return this.isPreloadAtFlag;
    }

    public final boolean isPreloadAtNotification() {
        return this.isPreloadAtNotification;
    }

    public final boolean isPreloadAtShorts() {
        return this.isPreloadAtShorts;
    }

    public final boolean isPreloadAtTabClick() {
        return this.isPreloadAtTabClick;
    }

    public final boolean isPreloadInterruptable() {
        return this.isPreloadInterruptable;
    }

    public final boolean isPreloadPriorityEnabled() {
        return this.isPreloadPriorityEnabled;
    }

    public FeedPreloadConfig(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        this.isPreloadAtFeedPrefetch = r1;
        this.isPreloadAtNotification = r2;
        this.isPreloadAtShorts = r3;
        this.isPreloadAtFilter = r4;
        this.isPreloadAtFlag = r5;
        this.isPreloadAtTabClick = r6;
        this.isPreloadPriorityEnabled = r7;
        this.isPreloadInterruptable = r8;
    }

    public /* synthetic */ FeedPreloadConfig(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, DefaultConstructorMarker r19) {
        boolean r2 = false;
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = false;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
