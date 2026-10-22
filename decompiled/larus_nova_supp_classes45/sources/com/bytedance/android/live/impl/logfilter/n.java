package com.bytedance.android.live.impl.logfilter;

import android.util.SparseArray;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Map b;

    public n(boolean r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        int r1 = 0;
        if (this.a == true) goto L26;
        Map r0 = this.b;
        if (r0 == null) goto L7;
        String r2 = (String) r0.get("definition");
    L8:
        if (r2 != null) goto L11;
    L25:
        UserFeatureInRoomFilter.e(UserFeatureInRoomFilter.y1, 4);
        goto L26
    L11:
        switch(r2.hashCode()) {
            case 853726: goto L23;
            case 1075212: goto L20;
            case 1151264: goto L17;
            case 1257005: goto L14;
            default: goto L25;
        };
    L14:
        if (r2.equals("高清") == false) goto L25;
        UserFeatureInRoomFilter.e(UserFeatureInRoomFilter.y1, 1);
        goto L26
    L17:
        if (r2.equals("超清") == false) goto L25;
        UserFeatureInRoomFilter.e(UserFeatureInRoomFilter.y1, 2);
        goto L26
    L20:
        if (r2.equals("蓝光") == false) goto L25;
        UserFeatureInRoomFilter.e(UserFeatureInRoomFilter.y1, 3);
        goto L26
    L23:
        if (r2.equals("标清") == false) goto L25;
        UserFeatureInRoomFilter.e(UserFeatureInRoomFilter.y1, 0);
        goto L26
    L7:
        r2 = null;
    L26:
        long r3 = -1;
        int r4 = 0;
        int r5 = 0;
    L27:
        UserFeatureInRoomFilter r6 = UserFeatureInRoomFilter.y1;
        List<String> r7 = UserFeatureInRoomFilter.V;
        if (r4 >= r7.size()) goto L33;
        SparseArray<Long> r8 = UserFeatureInRoomFilter.U;
        long r9 = r8.get(r4, 0L).longValue() + r6.g().c((String) ListProtector.get(r7, r4));
        r8.put(r4, Long.valueOf(r9));
        if (r3 >= r9) goto L32;
        r5 = r4;
        r3 = r9;
    L32:
        r4 = r4 + 1;
        goto L27
    L33:
        FeatureManager.u.i("watch_most_definition", UserFeatureInRoomFilter.W.get(Integer.valueOf(r5)), FeatureType.DYNAMIC);
        if (this.a == true) goto L38;
    L35:
        UserFeatureInRoomFilter r11 = UserFeatureInRoomFilter.y1;
        SparseArray<Long> r12 = UserFeatureInRoomFilter.U;
        if (r1 >= r12.size()) goto L38;
        r11.g().e((String) ListProtector.get(UserFeatureInRoomFilter.V, r1), r12.get(r1, 0L));
        r1 = r1 + 1;
    L38:
        UserFeatureInRoomFilter.U.clear();
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
