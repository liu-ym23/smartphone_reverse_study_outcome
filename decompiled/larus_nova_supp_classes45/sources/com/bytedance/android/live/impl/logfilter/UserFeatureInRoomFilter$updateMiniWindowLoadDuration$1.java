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
public final class UserFeatureInRoomFilter$updateMiniWindowLoadDuration$1 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ long b;

    public UserFeatureInRoomFilter$updateMiniWindowLoadDuration$1(boolean r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        UserFeatureInRoomFilter r1 = UserFeatureInRoomFilter.y1;
        String r2 = r1.g().d("key_mini_window_load_duration", r0.toString());
        if (r2 == null) goto L43;
        SimpleDateFormat r3 = TimeUtils.a;
        String r4 = TimeUtils.b(UserFeatureInRoomFilter.Q);
        int r5 = JsonHelper.a;
        List r6 = JsonHelper.e(r2, JsonItemType.MINI_WINDOW_LOAD_DURATION_ITEM);
        if ((r6 instanceof List) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L33;
        int r7 = 0;
        long r8 = 0;
        if (this.a == true) goto L20;
        Iterator r9 = r6.iterator();
        int r11 = 0;
    L12:
        if (r9.hasNext() == false) goto L18;
        JsonItemHelper.MiniWindowLoadDurationItem r12 = (JsonItemHelper.MiniWindowLoadDurationItem) r9.next();
        if (Intrinsics.areEqual(r12.getDate(), r4) == false) goto L16;
        r12.setFrequency(r12.getFrequency() + 1);
        r12.setLoadDurationSum(r12.getLoadDurationSum() + this.b);
        r0.add(JsonHelper.f(r12));
        r7 = 1;
    L17:
        r8 = r8 + r12.getLoadDurationSum();
        r11 = r11 + r12.getFrequency();
        goto L12
    L16:
        r0.add(JsonHelper.f(r12));
        goto L17
    L18:
        if (r7 != 0) goto L31;
        int r13 = JsonHelper.a;
        r0.add(JsonHelper.f(new JsonItemHelper.MiniWindowLoadDurationItem(r4, this.b, 1)));
        r8 = r8 + this.b;
        r11 = r11 + 1;
    L31:
        if (r11 == 0) goto L44;
        UserFeatureInRoomFilter.y1.g().e("key_mini_window_load_duration", r0.toString());
        FeatureManager r14 = FeatureManager.u;
        Long r15 = Long.valueOf(r8 / ((long) r11));
        FeatureType r16 = FeatureType.DYNAMIC;
        r14.i("mini_window_load_duration_avg_in_week", r15, r16);
        r14.i("mini_window_show_count", Integer.valueOf(r11), r16);
        return;
    L44:
        return;
    L20:
        Iterator r17 = r6.iterator();
        long r18 = 0;
    L22:
        if (r17.hasNext() == false) goto L30;
        JsonItemHelper.MiniWindowLoadDurationItem r19 = (JsonItemHelper.MiniWindowLoadDurationItem) r17.next();
        String r21 = r19.getDate();
        if (r21 == null) goto L26;
        long r22 = TimeUtils.c(r21);
    L27:
        SimpleDateFormat r110 = TimeUtils.a;
        int r111 = UserFeatureInRoomFilter.b;
        long r23 = TimeUtils.a(r22, UserFeatureInRoomFilter.Q);
        FeatureManager.u.getClass();
        if (r23 >= FeatureManager.j) goto L22;
        r0.add(JsonHelper.f(r19));
        r18 = r18 + r19.getLoadDurationSum();
        r7 = r7 + r19.getFrequency();
        goto L22
    L26:
        r22 = 0;
        goto L27
    L30:
        r8 = r18;
        r11 = r7;
        goto L31
    L33:
        boolean r24 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b(r1.a, UserFeatureInRoomFilter$updateMiniWindowLoadDuration$1$1$2$1.INSTANCE, null);
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
