package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerFollowStatus;", "", "", "value", "J", "getValue", "()J", "NoRelationStatus", "FollowingStatus", "FollowEachOtherStatus", "FollowRequestStatus", "FollowAlreadyRequest", "Unknow", "FollowAlreadyRequestSever", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerFollowStatus extends Enum<LiveDrawerFollowStatus> {
    public static final LiveDrawerFollowStatus FollowAlreadyRequest = null;
    public static final LiveDrawerFollowStatus FollowAlreadyRequestSever = null;
    public static final LiveDrawerFollowStatus FollowEachOtherStatus = null;
    public static final LiveDrawerFollowStatus FollowRequestStatus = null;
    public static final LiveDrawerFollowStatus FollowingStatus = null;
    public static final LiveDrawerFollowStatus NoRelationStatus = null;
    public static final LiveDrawerFollowStatus Unknow = null;
    public static final /* synthetic */ LiveDrawerFollowStatus[] a = null;
    private final long value;

    static {
        LiveDrawerFollowStatus r1 = new LiveDrawerFollowStatus("NoRelationStatus", 0, 0);
        NoRelationStatus = r1;
        LiveDrawerFollowStatus r2 = new LiveDrawerFollowStatus("FollowingStatus", 1, 1);
        FollowingStatus = r2;
        LiveDrawerFollowStatus r3 = new LiveDrawerFollowStatus("FollowEachOtherStatus", 2, 2);
        FollowEachOtherStatus = r3;
        LiveDrawerFollowStatus r4 = new LiveDrawerFollowStatus("FollowRequestStatus", 3, 3);
        FollowRequestStatus = r4;
        LiveDrawerFollowStatus r5 = new LiveDrawerFollowStatus("FollowAlreadyRequest", 4, 4);
        FollowAlreadyRequest = r5;
        LiveDrawerFollowStatus r6 = new LiveDrawerFollowStatus("Unknow", 5, 5);
        Unknow = r6;
        LiveDrawerFollowStatus r7 = new LiveDrawerFollowStatus("FollowAlreadyRequestSever", 6, 9);
        FollowAlreadyRequestSever = r7;
        a = new LiveDrawerFollowStatus[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static LiveDrawerFollowStatus valueOf(String r1) {
        return (LiveDrawerFollowStatus) r27.a.a(LiveDrawerFollowStatus.class, r1);
    }

    public static LiveDrawerFollowStatus[] values() {
        return (LiveDrawerFollowStatus[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerFollowStatus(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
