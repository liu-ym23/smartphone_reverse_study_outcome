package com.bytedance.android.livesdk.followtool.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/api/RelationSyncSwitch;", "", "followerSync", "", "followedSync", "followerScope", "anchorLiveSync", "(ZZZZ)V", "getAnchorLiveSync", "()Z", "setAnchorLiveSync", "(Z)V", "getFollowedSync", "setFollowedSync", "getFollowerScope", "setFollowerScope", "getFollowerSync", "setFollowerSync", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RelationSyncSwitch {

    @SerializedName("anchor_live_sync")
    private boolean anchorLiveSync;

    @SerializedName("followed_sync")
    private boolean followedSync;

    @SerializedName("follower_scope")
    private boolean followerScope;

    @SerializedName("follower_sync")
    private boolean followerSync;

    public RelationSyncSwitch() {
        this(false, false, false, false, 15, null);
    }

    public final boolean getAnchorLiveSync() {
        return this.anchorLiveSync;
    }

    public final boolean getFollowedSync() {
        return this.followedSync;
    }

    public final boolean getFollowerScope() {
        return this.followerScope;
    }

    public final boolean getFollowerSync() {
        return this.followerSync;
    }

    public final void setAnchorLiveSync(boolean r1) {
        this.anchorLiveSync = r1;
    }

    public final void setFollowedSync(boolean r1) {
        this.followedSync = r1;
    }

    public final void setFollowerScope(boolean r1) {
        this.followerScope = r1;
    }

    public final void setFollowerSync(boolean r1) {
        this.followerSync = r1;
    }

    public RelationSyncSwitch(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.followerSync = r1;
        this.followedSync = r2;
        this.followerScope = r3;
        this.anchorLiveSync = r4;
    }

    public /* synthetic */ RelationSyncSwitch(boolean r2, boolean r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
