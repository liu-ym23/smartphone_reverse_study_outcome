package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.utils.TimeUtils;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class DeviceFeatureFilter$updateStopLiveReasonCount$1 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;

    public DeviceFeatureFilter$updateStopLiveReasonCount$1(boolean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ArrayList r1 = new ArrayList();
        DeviceFeatureFilter r2 = DeviceFeatureFilter.O;
        String r3 = DeviceFeatureFilter.e(r2).d("key_restart_live_alert_show_reason_3456_count", r1.toString());
        if (r3 == null) goto L89;
        SimpleDateFormat r4 = TimeUtils.a;
        String r5 = TimeUtils.b(DeviceFeatureFilter.t);
        int r6 = JsonHelper.a;
        List r7 = JsonHelper.e(r3, JsonItemType.RESTART_LIVE_ALERT_SHOW_REASON_3_COUNT_ITEM);
        if ((r7 instanceof List) == true) goto L7;
        r7 = null;
    L7:
        int r8 = 0;
        List r9 = CollectionsKt.mutableListOf(new Integer[]{0, 0, 0, 0, 0, 0, 0});
        List r11 = CollectionsKt.listOf(new String[]{"0", GamePromoteDataContext.GAME_TYPE_MOBILE, GamePromoteDataContext.GAME_TYPE_MINI, "3", "4", "5", "6"});
        int r15 = r11.size();
        if (r7 == null) goto L72;
        boolean r12 = this.a;
        if (r12 == false) goto L12;
    L50:
        if (r12 == false) goto L69;
        Iterator r13 = r7.iterator();
    L53:
        if (r13.hasNext() == false) goto L69;
        JsonItemHelper.StopLiveReasonDataItem r14 = (JsonItemHelper.StopLiveReasonDataItem) r13.next();
        String r16 = r14.getDate();
        if (r16 == null) goto L57;
        long r17 = TimeUtils.c(r16);
    L58:
        SimpleDateFormat r18 = TimeUtils.a;
        float r19 = DeviceFeatureFilter.b;
        long r21 = TimeUtils.a(r17, DeviceFeatureFilter.t);
        FeatureManager.u.getClass();
        if (r21 >= FeatureManager.j) goto L53;
        r1.add(JsonHelper.f(r14));
        int r22 = 0;
    L61:
        if (r22 >= r15) goto L53;
        int r23 = ((Number) ListProtector.get(r9, r22)).intValue();
        List<Integer> r24 = r14.getReasonCountList();
        if (r24 == null) goto L67;
        Integer r25 = (Integer) ListProtector.get(r24, r22);
        if (r25 == null) goto L67;
        int r26 = r25.intValue();
    L68:
        ListProtector.set(r9, r22, Integer.valueOf(r23 + r26));
        r22 = r22 + 1;
    L67:
        r26 = 0;
        goto L68
    L57:
        r17 = 0;
    L69:
        DeviceFeatureFilter.e(DeviceFeatureFilter.O).e("key_restart_live_alert_show_reason_3456_count", r1.toString());
    L70:
        if (r8 >= r15) goto L90;
        z90.a.C0301a.a(FeatureManager.u, "stop_live_reason_" + r8 + "_count", ListProtector.get(r9, r8));
        r8 = r8 + 1;
        goto L70
    L90:
        return;
    L12:
        if (this.b == null) goto L50;
        Iterator r27 = r7.iterator();
        boolean r28 = false;
    L15:
        if (r27.hasNext() == false) goto L35;
        JsonItemHelper.StopLiveReasonDataItem r110 = (JsonItemHelper.StopLiveReasonDataItem) r27.next();
        if (Intrinsics.areEqual(r110.getDate(), r5) == true) goto L19;
        r1.add(JsonHelper.f(r110));
    L25:
        int r111 = 0;
    L26:
        if (r111 >= r15) goto L15;
        int r112 = ((Number) ListProtector.get(r9, r111)).intValue();
        List<Integer> r113 = r110.getReasonCountList();
        if (r113 == null) goto L32;
        Integer r114 = (Integer) ListProtector.get(r113, r111);
        if (r114 == null) goto L32;
        int r115 = r114.intValue();
    L33:
        ListProtector.set(r9, r111, Integer.valueOf(r112 + r115));
        r111 = r111 + 1;
    L32:
        r115 = 0;
        goto L33
    L19:
        if (r11.contains(this.b) == false) goto L23;
        List<Integer> r29 = r110.getReasonCountList();
        if (r29 == null) goto L23;
        int r116 = CastIntegerProtector.parseInt(this.b);
        ((Number) ListProtector.set(r29, r116, Integer.valueOf(((Number) ListProtector.get(r29, r116)).intValue() + 1))).intValue();
    L23:
        r1.add(JsonHelper.f(r110));
        r28 = true;
        goto L25
    L35:
        if (r28 == true) goto L69;
        JsonItemHelper.StopLiveReasonDataItem r31 = new JsonItemHelper.StopLiveReasonDataItem(r5, CollectionsKt.mutableListOf(new Integer[]{0, 0, 0, 0, 0, 0, 0}));
        if (r11.contains(this.b) == false) goto L41;
        List<Integer> r32 = r31.getReasonCountList();
        if (r32 == null) goto L41;
        int r33 = CastIntegerProtector.parseInt(this.b);
        ((Number) ListProtector.set(r32, r33, Integer.valueOf(((Number) ListProtector.get(r32, r33)).intValue() + 1))).intValue();
    L41:
        r1.add(JsonHelper.f(r31));
        int r34 = 0;
    L42:
        if (r34 >= r15) goto L69;
        int r35 = ((Number) ListProtector.get(r9, r34)).intValue();
        List<Integer> r36 = r31.getReasonCountList();
        if (r36 == null) goto L48;
        Integer r37 = (Integer) ListProtector.get(r36, r34);
        if (r37 == null) goto L48;
        int r38 = r37.intValue();
    L49:
        ListProtector.set(r9, r34, Integer.valueOf(r35 + r38));
        r34 = r34 + 1;
    L48:
        r38 = 0;
        goto L49
    L72:
        boolean r39 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d(r2.a, DeviceFeatureFilter$updateStopLiveReasonCount$1$1$2$1.INSTANCE);
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
