package com.bytedance.android.live.impl.logfilter;

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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class DeviceFeatureFilter$updateStallSp$1 implements Runnable {
    public final /* synthetic */ boolean a;

    public DeviceFeatureFilter$updateStallSp$1(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        DeviceFeatureFilter r1 = DeviceFeatureFilter.O;
        String r2 = DeviceFeatureFilter.e(r1).d("stall_rate_items", r0.toString());
        if (r2 == null) goto L61;
        SimpleDateFormat r3 = TimeUtils.a;
        String r4 = TimeUtils.b(DeviceFeatureFilter.t);
        int r5 = JsonHelper.a;
        List r6 = JsonHelper.e(r2, JsonItemType.STALL_ITEM);
        if ((r6 instanceof List) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L47;
        int r7 = 0;
        float r8 = 0.0f;
        if (this.a == false) goto L34;
        Iterator r9 = r6.iterator();
        boolean r11 = false;
        float r12 = 0.0f;
        float r13 = 0.0f;
        int r14 = 0;
    L12:
        if (r9.hasNext() == false) goto L25;
        JsonItemHelper.StallRecordItem r15 = (JsonItemHelper.StallRecordItem) r9.next();
        if (Intrinsics.areEqual(r15.getDate(), r4) == false) goto L23;
        Object r16 = DeviceFeatureFilter.B;
        monitor-enter(r16);
        r15.setFrequency(r15.getFrequency() + DeviceFeatureFilter.h);     // Catch: Throwable -> L20
        r15.setStallVideoUiRateSum(r15.getStallVideoUiRateSum() + DeviceFeatureFilter.f);     // Catch: Throwable -> L20
        DeviceFeatureFilter.f = 0.0f;     // Catch: Throwable -> L20
        r15.setStallUiRateSum(r15.getStallUiRateSum() + DeviceFeatureFilter.g);     // Catch: Throwable -> L20
        DeviceFeatureFilter.g = 0.0f;     // Catch: Throwable -> L20
        DeviceFeatureFilter.h = 0;     // Catch: Throwable -> L20
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r16);
        r0.add(JsonHelper.f(r15));
        r11 = true;
    L24:
        r12 = r12 + r15.getStallVideoUiRateSum();
        r13 = r13 + r15.getStallUiRateSum();
        r14 = r14 + r15.getFrequency();
    L20:
        th = move-exception;
        throw th;
    L23:
        r0.add(JsonHelper.f(r15));
        goto L24
    L25:
        if (r11 == true) goto L45;
        Object r18 = DeviceFeatureFilter.B;
        monitor-enter(r18);
        int r19 = JsonHelper.a;     // Catch: Throwable -> L31
        r0.add(JsonHelper.f(new JsonItemHelper.StallRecordItem(r4, DeviceFeatureFilter.f, DeviceFeatureFilter.g, DeviceFeatureFilter.h)));     // Catch: Throwable -> L31
        r12 = r12 + DeviceFeatureFilter.f;     // Catch: Throwable -> L31
        DeviceFeatureFilter.f = 0.0f;     // Catch: Throwable -> L31
        r13 = r13 + DeviceFeatureFilter.g;     // Catch: Throwable -> L31
        DeviceFeatureFilter.g = 0.0f;     // Catch: Throwable -> L31
        r14 = r14 + DeviceFeatureFilter.h;     // Catch: Throwable -> L31
        DeviceFeatureFilter.h = 0;     // Catch: Throwable -> L31
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r18);
    L31:
        th = move-exception;
        throw th;
    L45:
        if (r14 == 0) goto L62;
        DeviceFeatureFilter r22 = DeviceFeatureFilter.O;
        float r23 = r14;
        DeviceFeatureFilter.b = r12 / r23;
        DeviceFeatureFilter.c = r13 / r23;
        DeviceFeatureFilter.e(r22).e("stall_rate_items", r0.toString());
        return;
    L62:
        return;
    L34:
        Iterator r24 = r6.iterator();
        float r25 = 0.0f;
    L36:
        if (r24.hasNext() == false) goto L44;
        JsonItemHelper.StallRecordItem r26 = (JsonItemHelper.StallRecordItem) r24.next();
        String r27 = r26.getDate();
        if (r27 == null) goto L40;
        long r28 = TimeUtils.c(r27);
    L41:
        SimpleDateFormat r29 = TimeUtils.a;
        float r31 = DeviceFeatureFilter.b;
        long r32 = TimeUtils.a(r28, DeviceFeatureFilter.t);
        FeatureManager.u.getClass();
        if (r32 >= FeatureManager.j) goto L36;
        r0.add(JsonHelper.f(r26));
        r25 = r25 + r26.getStallVideoUiRateSum();
        r8 = r8 + r26.getStallUiRateSum();
        r7 = r7 + r26.getFrequency();
        goto L36
    L40:
        r28 = 0;
        goto L41
    L44:
        r12 = r25;
        r14 = r7;
        r13 = r8;
        goto L45
    L47:
        boolean r33 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b(r1.a, DeviceFeatureFilter$updateStallSp$1$1$2$1.INSTANCE, null);
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
