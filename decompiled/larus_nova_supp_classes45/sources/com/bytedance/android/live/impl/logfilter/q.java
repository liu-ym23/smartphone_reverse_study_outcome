package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.utils.TimeUtils;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements Runnable {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public static void a() {
        ArrayList r0 = new ArrayList();
        String r1 = UserFeatureInRoomFilter.y1.g().d("key_watch_live_day_count", r0.toString());
        if (r1 == null) goto L38;
        SimpleDateFormat r2 = TimeUtils.a;
        String r3 = TimeUtils.b(UserFeatureInRoomFilter.Q);
        int r4 = JsonHelper.a;
        List r5 = JsonHelper.e(r1, JsonItemType.WATCH_LIVE_DATE_ITEM);
        if ((r5 instanceof List) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L32;
        Iterator r6 = r5.iterator();
        boolean r7 = false;
        int r8 = 0;
        int r9 = 0;
        long r11 = 0;
    L11:
        if (r6.hasNext() == false) goto L28;
        JsonItemHelper.WatchLiveDateItem r12 = (JsonItemHelper.WatchLiveDateItem) r6.next();
        if (Intrinsics.areEqual(r12.getDate(), r3) == false) goto L15;
        r7 = true;
    L15:
        String r13 = r12.getDate();
        if (r13 == null) goto L18;
        long r14 = TimeUtils.c(r13);
    L19:
        SimpleDateFormat r15 = TimeUtils.a;
        int r16 = UserFeatureInRoomFilter.b;
        long r17 = TimeUtils.a(r14, UserFeatureInRoomFilter.Q);
        FeatureManager r18 = FeatureManager.u;
        r18.getClass();
        Iterator r19 = r6;
        long r110 = r11;
        if (r17 >= FeatureManager.j) goto L25;
        r0.add(JsonHelper.f(r12));
        r8 = r8 + 1;
        if (TimeUtils.a(r14, UserFeatureInRoomFilter.Q) >= 7) goto L25;
        r9 = r9 + 1;
    L25:
        if (TimeUtils.a(r14, UserFeatureInRoomFilter.Q) <= ((Number) r18.getFeature("install_app_days", 0L)).longValue()) goto L27;
        r110 = TimeUtils.a(r14, UserFeatureInRoomFilter.Q);
    L27:
        r6 = r19;
        r11 = r110;
        goto L11
    L18:
        r14 = 0;
        goto L19
    L28:
        long r111 = r11;
        if (r7 == true) goto L31;
        int r21 = JsonHelper.a;
        r0.add(JsonHelper.f(new JsonItemHelper.WatchLiveDateItem(r3)));
        r8 = r8 + 1;
        r9 = r9 + 1;
    L31:
        FeatureManager r22 = FeatureManager.u;
        Integer r23 = Integer.valueOf(r8);
        FeatureType r24 = FeatureType.DYNAMIC;
        r22.i("watch_live_day_count_in_month", r23, r24);
        r22.i("watch_live_day_count_in_week", Integer.valueOf(r9), r24);
        long r25 = r111;
    L33:
        z90.a.C0301a.a(FeatureManager.u, "install_app_days", Long.valueOf(r25));
        UserFeatureInRoomFilter.y1.g().e("key_watch_live_day_count", r0.toString());
        return;
    L32:
        r25 = 0;
        goto L33
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
