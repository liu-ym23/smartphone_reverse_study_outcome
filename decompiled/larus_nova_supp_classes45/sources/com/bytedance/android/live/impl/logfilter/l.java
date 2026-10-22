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
public final class l implements Runnable {
    public final /* synthetic */ boolean a;

    public l(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        String r1 = UserFeatureInRoomFilter.y1.g().d("key_start_live_count", r0.toString());
        if (r1 == null) goto L43;
        SimpleDateFormat r2 = TimeUtils.a;
        String r3 = TimeUtils.b(UserFeatureInRoomFilter.Q);
        int r4 = JsonHelper.a;
        List r5 = JsonHelper.e(r1, JsonItemType.START_LIVE_COUNT_ITEM);
        if ((r5 instanceof List) == true) goto L7;
        r5 = null;
    L7:
        if (r5 == null) goto L44;
        int r6 = 0;
        if (this.a == true) goto L19;
        Iterator r7 = r5.iterator();
        int r8 = 0;
    L12:
        if (r7.hasNext() == false) goto L17;
        JsonItemHelper.StartLiveDataItem r9 = (JsonItemHelper.StartLiveDataItem) r7.next();
        if (Intrinsics.areEqual(r9.getDate(), r3) == true) goto L15;
        r8 = r8 + r9.getStartLiveCount();
        r0.add(JsonHelper.f(r9));
        goto L12
    L15:
        r9.setStartLiveCount(r9.getStartLiveCount() + 1);
        r0.add(JsonHelper.f(r9));
        r8 = r8 + r9.getStartLiveCount();
        r6 = 1;
        goto L12
    L17:
        if (r6 != 0) goto L30;
        int r11 = JsonHelper.a;
        r0.add(JsonHelper.f(new JsonItemHelper.StartLiveDataItem(r3, 1)));
        r8 = r8 + 1;
    L30:
        FeatureManager.u.i("recent_start_live_count", Integer.valueOf(r8), FeatureType.DYNAMIC);
        UserFeatureInRoomFilter.y1.g().e("key_start_live_count", r0.toString());
        return;
    L19:
        Iterator r12 = r5.iterator();
    L21:
        if (r12.hasNext() == false) goto L29;
        JsonItemHelper.StartLiveDataItem r13 = (JsonItemHelper.StartLiveDataItem) r12.next();
        String r14 = r13.getDate();
        if (r14 == null) goto L25;
        long r15 = TimeUtils.c(r14);
    L26:
        SimpleDateFormat r16 = TimeUtils.a;
        int r17 = UserFeatureInRoomFilter.b;
        if (TimeUtils.a(r15, UserFeatureInRoomFilter.Q) >= j40.d.a.getValue().f()) goto L21;
        r0.add(JsonHelper.f(r13));
        r6 = r6 + r13.getStartLiveCount();
        goto L21
    L25:
        r15 = 0;
        goto L26
    L29:
        r8 = r6;
        goto L30
    L44:
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
