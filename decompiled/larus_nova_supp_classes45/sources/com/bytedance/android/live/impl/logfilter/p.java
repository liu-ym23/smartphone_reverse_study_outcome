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
public final class p implements Runnable {
    public final /* synthetic */ boolean a;

    public p(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        String r1 = UserFeatureInRoomFilter.y1.g().d("watch_hot_room_pv", r0.toString());
        if (r1 == null) goto L43;
        SimpleDateFormat r2 = TimeUtils.a;
        String r9 = TimeUtils.b(UserFeatureInRoomFilter.Q);
        int r3 = JsonHelper.a;
        List r4 = JsonHelper.e(r1, JsonItemType.WATCH_HOTROOM_PV_ITEM);
        Long r6 = null;
        if ((r4 instanceof List) == true) goto L7;
        r4 = null;
    L7:
        if (r4 == null) goto L43;
        boolean r18 = false;
        if (this.a != true) goto L21;
        Iterator r5 = r4.iterator();
        long r11 = 0;
        long r12 = 0;
        long r15 = 0;
        long r19 = 0;
        boolean r7 = false;
    L12:
        if (r5.hasNext() == false) goto L18;
        JsonItemHelper.WatchHotroomPvItem r8 = (JsonItemHelper.WatchHotroomPvItem) r5.next();
        if (Intrinsics.areEqual(r8.getDate(), r9) == false) goto L16;
        r8.setWatchHotroomCount(r8.getWatchHotroomCount() + UserFeatureInRoomFilter.Z);
        r8.setWatchHotroomDurationSum(r8.getWatchHotroomDurationSum() + UserFeatureInRoomFilter.p0);
        r8.setWatchNotHotroomCount(r8.getWatchNotHotroomCount() + UserFeatureInRoomFilter.k0);
        r8.setWatchNotHotroomDurationSum(r8.getWatchNotHotroomDurationSum() + UserFeatureInRoomFilter.H0);
        r0.add(JsonHelper.f(r8));
        r7 = true;
    L17:
        r19 = r19 + r8.getWatchHotroomCount();
        r12 = r8.getWatchNotHotroomCount();
        r11 = r8.getWatchHotroomDurationSum();
        r15 = r8.getWatchNotHotroomDurationSum();
        goto L12
    L16:
        r0.add(JsonHelper.f(r8));
        goto L17
    L18:
        if (r7 == true) goto L25;
        int r13 = JsonHelper.a;
        r0.add(JsonHelper.f(new JsonItemHelper.WatchHotroomPvItem(r9, UserFeatureInRoomFilter.Z, UserFeatureInRoomFilter.p0, UserFeatureInRoomFilter.k0, UserFeatureInRoomFilter.H0)));
        r19 = r19 + UserFeatureInRoomFilter.Z;
        r12 = UserFeatureInRoomFilter.p0;
        r11 = UserFeatureInRoomFilter.k0;
        r15 = UserFeatureInRoomFilter.H0;
    L25:
        Long r14 = Long.valueOf(r19);
        if (r14.longValue() == 0) goto L28;
        boolean r16 = true;
    L29:
        if (r16 == true) goto L32;
        r14 = null;
    L32:
        if (r14 == null) goto L34;
        r14.longValue();
        FeatureManager.u.i("hotroom_watch_duration_avg_history", Long.valueOf(r11 / r19), FeatureType.DYNAMIC);
    L34:
        Long r17 = Long.valueOf(r12);
        if (r17.longValue() == 0) goto L37;
        r18 = true;
    L37:
        if (r18 == false) goto L39;
        r6 = r17;
    L39:
        if (r6 == null) goto L41;
        r6.longValue();
        FeatureManager.u.i("nothotroom_watch_duration_avg_history", Long.valueOf(r15 / r12), FeatureType.DYNAMIC);
    L41:
        UserFeatureInRoomFilter.y1.g().e("watch_hot_room_pv", r0.toString());
        goto L43
    L28:
        r16 = false;
        goto L29
    L21:
        Iterator r21 = r4.iterator();
        r11 = 0;
        r12 = 0;
        r15 = 0;
        r19 = 0;
    L23:
        if (r21.hasNext() == false) goto L25;
        JsonItemHelper.WatchHotroomPvItem r22 = (JsonItemHelper.WatchHotroomPvItem) r21.next();
        r19 = r19 + r22.getWatchHotroomCount();
        r12 = r22.getWatchNotHotroomCount();
        r11 = r22.getWatchHotroomDurationSum();
        r15 = r22.getWatchNotHotroomDurationSum();
        r0.add(JsonHelper.f(r22));
    L43:
        UserFeatureInRoomFilter.Z = 0;
        UserFeatureInRoomFilter.k0 = 0;
        UserFeatureInRoomFilter.p0 = 0;
        UserFeatureInRoomFilter.H0 = 0;
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
