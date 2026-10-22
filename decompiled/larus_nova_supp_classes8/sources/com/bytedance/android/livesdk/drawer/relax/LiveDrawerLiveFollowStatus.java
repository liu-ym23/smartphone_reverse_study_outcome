package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerLiveFollowStatus;", "", "", "value", "J", "getValue", "()J", "Fail", "UnFollow", "Followed", "FollowingFollowed", "BeenFollowed", "UnDefined", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerLiveFollowStatus extends Enum<LiveDrawerLiveFollowStatus> {
    public static final LiveDrawerLiveFollowStatus BeenFollowed = null;
    public static final LiveDrawerLiveFollowStatus Fail = null;
    public static final LiveDrawerLiveFollowStatus Followed = null;
    public static final LiveDrawerLiveFollowStatus FollowingFollowed = null;
    public static final LiveDrawerLiveFollowStatus UnDefined = null;
    public static final LiveDrawerLiveFollowStatus UnFollow = null;
    public static final /* synthetic */ LiveDrawerLiveFollowStatus[] a = null;
    private final long value;

    static {
        LiveDrawerLiveFollowStatus r1 = new LiveDrawerLiveFollowStatus("Fail", 0, -1);
        Fail = r1;
        LiveDrawerLiveFollowStatus r2 = new LiveDrawerLiveFollowStatus("UnFollow", 1, 0);
        UnFollow = r2;
        LiveDrawerLiveFollowStatus r3 = new LiveDrawerLiveFollowStatus("Followed", 2, 1);
        Followed = r3;
        LiveDrawerLiveFollowStatus r4 = new LiveDrawerLiveFollowStatus("FollowingFollowed", 3, 2);
        FollowingFollowed = r4;
        LiveDrawerLiveFollowStatus r5 = new LiveDrawerLiveFollowStatus("BeenFollowed", 4, 3);
        BeenFollowed = r5;
        LiveDrawerLiveFollowStatus r6 = new LiveDrawerLiveFollowStatus("UnDefined", 5, 4);
        UnDefined = r6;
        a = new LiveDrawerLiveFollowStatus[]{r1, r2, r3, r4, r5, r6};
    }

    public static LiveDrawerLiveFollowStatus valueOf(String r1) {
        return (LiveDrawerLiveFollowStatus) r27.a.a(LiveDrawerLiveFollowStatus.class, r1);
    }

    public static LiveDrawerLiveFollowStatus[] values() {
        return (LiveDrawerLiveFollowStatus[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerLiveFollowStatus(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
