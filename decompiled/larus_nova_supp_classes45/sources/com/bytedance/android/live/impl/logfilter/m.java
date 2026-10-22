package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements Runnable {
    public final /* synthetic */ long a;

    public m(long r1) {
        this.a = r1;
    }

    public final void a() {
        UserFeatureInRoomFilter r0 = UserFeatureInRoomFilter.y1;
        long r3 = r0.g().c("stay_preview_duration_sum");
        long r6 = r0.g().c("stay_preview_frequency");
        r0.g().e("stay_preview_duration_sum", Long.valueOf(this.a + r3));
        long r7 = r6 + 1;
        r0.g().e("stay_preview_frequency", Long.valueOf(r7));
        FeatureManager.u.i("preview_stay_duration_avg", Float.valueOf(r3 / r7), FeatureType.DYNAMIC);
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
