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
public final class k implements Runnable {
    public final /* synthetic */ boolean a;

    public k(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        String r1 = UserFeatureInRoomFilter.y1.g().d("key_gift_show_day_count", r0.toString());
        if (r1 == null) goto L45;
        SimpleDateFormat r2 = TimeUtils.a;
        String r3 = TimeUtils.b(UserFeatureInRoomFilter.Q);
        int r4 = JsonHelper.a;
        List r5 = JsonHelper.e(r1, JsonItemType.GIFT_SHOW_DATE_ITEM);
        if ((r5 instanceof List) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L43;
        int r8 = 0;
        if (this.a == false) goto L24;
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L13:
        if (r6.hasNext() == false) goto L23;
        JsonItemHelper.GiftShowDateItem r9 = (JsonItemHelper.GiftShowDateItem) r6.next();
        String r11 = r9.getDate();
        if (r11 == null) goto L17;
        long r12 = TimeUtils.c(r11);
    L18:
        SimpleDateFormat r13 = TimeUtils.a;
        int r14 = UserFeatureInRoomFilter.b;
        long r15 = TimeUtils.a(r12, UserFeatureInRoomFilter.Q);
        FeatureManager.u.getClass();
        if (r15 >= FeatureManager.j) goto L13;
        r0.add(JsonHelper.f(r9));
        r7 = r7 + 1;
        if (TimeUtils.a(r12, UserFeatureInRoomFilter.Q) >= 7) goto L13;
        r8 = r8 + 1;
        goto L13
    L17:
        r12 = 0;
        goto L18
    L23:
        int r16 = r8;
        r8 = r7;
    L42:
        FeatureManager r17 = FeatureManager.u;
        Integer r18 = Integer.valueOf(r8);
        FeatureType r19 = FeatureType.DYNAMIC;
        r17.i("gift_show_day_count_in_month", r18, r19);
        r17.i("gift_show_day_count_in_week", Integer.valueOf(r16), r19);
        goto L43
    L24:
        Iterator r21 = r5.iterator();
        r16 = 0;
        boolean r110 = false;
    L26:
        if (r21.hasNext() == false) goto L40;
        JsonItemHelper.GiftShowDateItem r111 = (JsonItemHelper.GiftShowDateItem) r21.next();
        if (Intrinsics.areEqual(r111.getDate(), r3) == false) goto L30;
        r110 = true;
    L30:
        String r112 = r111.getDate();
        if (r112 == null) goto L33;
        long r113 = TimeUtils.c(r112);
    L34:
        SimpleDateFormat r114 = TimeUtils.a;
        int r115 = UserFeatureInRoomFilter.b;
        if (TimeUtils.a(r113, UserFeatureInRoomFilter.Q) >= 7) goto L38;
        r16 = r16 + 1;
    L38:
        if (TimeUtils.a(r113, UserFeatureInRoomFilter.Q) >= 30) goto L26;
        r16 = r16 + 1;
        goto L26
    L33:
        r113 = 0;
        goto L34
    L40:
        if (r110 == true) goto L42;
        int r22 = JsonHelper.a;
        r0.add(JsonHelper.f(new JsonItemHelper.WatchLiveDateItem(r3)));
        r16 = r16 + 1;
        r8 = 1;
    L43:
        UserFeatureInRoomFilter.y1.g().e("key_gift_show_day_count", r0.toString());
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
