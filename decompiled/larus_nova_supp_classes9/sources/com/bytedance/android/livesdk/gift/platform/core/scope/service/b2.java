package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b2 implements com.bytedance.android.scope.o {
    public final HashMap<String, Integer> a;

    public final void onStart() {
    }

    public final void onStop() {
        Set<Map.Entry<String, Integer>> r0 = this.a.entrySet();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        c2 r4 = new c2();
        r4.a((String) r3.getKey());
        r4.b(String.valueOf(((Number) r3.getValue()).intValue()));
        r1.add(r4);
        goto L4
    L6:
        mz0.n r5 = new mz0.n();
        Map r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        String r7 = GsonProtectorUtils.toJson(new Gson(), r1);
        Intrinsics.checkNotNullParameter("scene_summary", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r6.put("scene_summary", r7);
        mz0.m r8 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        List r10 = r8.a;
        ArrayList r11 = (ArrayList) r10;
        r11.add(r9.a);
        r8.b(LogCommon.ROOM);
        List r13 = r5.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((f80.a) r16).w3("livesdk_gift_scene_leave_live_summary_result", r5.a, r5.b);
    }

    public b2() {
        this.a = new HashMap();
    }

    public final void a(String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "roomLiveScene");
        Intrinsics.checkNotNullParameter(r7, "eventTrack");
        Integer r0 = this.a.get(r6);
        if (r0 != null) goto L5;
        r0 = 0;
    L5:
        int r1 = r0.intValue() + 1;
        this.a.put(r6, Integer.valueOf(r1));
        mz0.n r2 = new mz0.n();
        Map r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter("room_live_scene", "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        r3.put("room_live_scene", r6);
        String r8 = r7.get("slice_id");
        if (r8 != null) goto L8;
        r8 = BuildConfig.FLAVOR;
    L8:
        Intrinsics.checkNotNullParameter("strategy_slice_id", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r3.put("strategy_slice_id", r8);
        mz0.m r9 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r10 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r10, "pageSourceLog");
        List r4 = r9.a;
        ArrayList r5 = (ArrayList) r4;
        r5.add(r10.a);
        r9.b(LogCommon.ROOM);
        List r11 = r2.b;
        ArrayList r13 = (ArrayList) r11;
        r13.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("livesdk_gift_room_live_scene_change", r2.a, r2.b);
    }
}
