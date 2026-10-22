package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements Runnable {
    public final /* synthetic */ boolean a;

    public o(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        UserFeatureInRoomFilter r0 = UserFeatureInRoomFilter.y1;
        int r1 = r0.g().a("watchRoomCount");
        int r3 = r0.g().a("watchFollowRoomCount");
        if (r1 == 0) goto L6;
        FeatureManager.u.i("watch_follow_room_count_weight", Float.valueOf(r3 / r1), FeatureType.DYNAMIC);
    L6:
        if (this.a == false) goto L11;
        int r5 = UserFeatureInRoomFilter.T;
        if (r5 <= 0) goto L12;
        int r4 = r3 + UserFeatureInRoomFilter.S;
        r0.g().e("watchRoomCount", Integer.valueOf(r1 + r5));
        r0.g().e("watchFollowRoomCount", Integer.valueOf(r4));
        UserFeatureInRoomFilter.T = 0;
        UserFeatureInRoomFilter.S = 0;
        return;
    L12:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
