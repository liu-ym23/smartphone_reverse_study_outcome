package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final void a() {
        mz0.n r0 = new mz0.n();
        mz0.m r1 = new mz0.m();
        r1.b(LogCommon.ROOM);
        r1.b(LogCommon.PAGE_SOURCE_LOG);
        List r2 = r0.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r1.a);
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r5 = com.bytedance.android.scope.m.b(r4).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r5);
        ((f80.a) r5).w3("shortcut_popup_show", r0.a, r0.b);
    }

    static {
    }

    @JvmStatic
    public static final void g(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonType");
        HashMap r0 = new HashMap();
        r0.put("button_type", r2);
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r0.put("is_not_remind", r4);
        mz0.n r5 = new mz0.n();
        Map r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        List r1 = r5.b;
        ArrayList r8 = (ArrayList) r1;
        r8.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("shortcut_popup_click", r5.a, r5.b);
        return;
    L5:
        r4 = "0";
        goto L6
    }

    @JvmStatic
    public static final void c(long r3, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "alertType");
        Intrinsics.checkNotNullParameter("convenient", "pageFrom");
        HashMap r0 = new HashMap();
        r0.put("gift_id", String.valueOf(r3));
        r0.put("money", String.valueOf(r5));
        r0.put("alert_click", r6);
        r0.put("page_from", "convenient");
        mz0.n r4 = new mz0.n();
        Map r7 = r4.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        r8.b(LogCommon.PAGE_SOURCE_LOG);
        List r9 = r4.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r11 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r11).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((f80.a) r13).w3("livesdk_gift_send_alert_show", r4.a, r4.b);
    }

    @JvmStatic
    public static final void d(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "componentType");
        Intrinsics.checkNotNullParameter(r3, "confirmType");
        Intrinsics.checkNotNullParameter(r4, "isSelect");
        HashMap r0 = new HashMap();
        r0.put("component_type", r2);
        r0.put("confirm_type", r3);
        r0.put("is_select", r4);
        mz0.n r5 = new mz0.n();
        Map r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        List r8 = r5.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r11 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r11);
        ((f80.a) r11).w3("livesdk_gift_convenient_popup_click", r5.a, r5.b);
    }

    @JvmStatic
    public static final void b(long r3, int r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "alertType");
        Intrinsics.checkNotNullParameter("convenient", "pageFrom");
        Intrinsics.checkNotNullParameter(r7, "clickType");
        HashMap r0 = new HashMap();
        r0.put("gift_id", String.valueOf(r3));
        r0.put("money", String.valueOf(r5));
        r0.put("alert_click", r6);
        r0.put("page_from", "convenient");
        r0.put("click_type", r7);
        mz0.n r4 = new mz0.n();
        Map r8 = r4.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r8.putAll(r0);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List r10 = r4.b;
        ArrayList r11 = (ArrayList) r10;
        r11.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_gift_send_alert_click", r4.a, r4.b);
    }

    @JvmStatic
    public static final void e(boolean r2, long r3, com.bytedance.android.livesdk.gift.platform.core.model.e0 r5, int r6, my1.a r7, Map<String, String> r8, int r9, String r10) {
        HashMap r0 = new HashMap();
        if (r2 == false) goto L5;
        String r4 = "0";
    L6:
        r0.put("room_orientation", r4);
        r0.put("gift_id", String.valueOf(r3));
        r0.put("click_type", String.valueOf(r6));
        if (r5 == null) goto L14;
        Map<String, String> r11 = r5.a();
        if (r11 == null) goto L14;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<String, String> r14 = r13.next();
        r0.put(r14.getKey(), r14.getValue());
    L14:
        r0.put("content", "normal");
        if (r7 == null) goto L22;
        my1.b r15 = r7.a;
        if (r15 == null) goto L22;
        r0.put("content", "gift_coin_task");
        String r16 = r15.rewardNum;
        if (r16 != null) goto L21;
        r16 = BuildConfig.FLAVOR;
    L21:
        r0.put("coin_reward_amt", r16);
    L22:
        if (r8 == null) goto L24;
        r0.putAll(r8);
    L24:
        r0.put("recommend_num", String.valueOf(r9));
        if (r10 != null) goto L27;
        r10 = BuildConfig.FLAVOR;
    L27:
        r0.put("to_user_id", r10);
        r0.put("to_user_type", "anchor");
        mz0.n r17 = new mz0.n();
        Map r18 = r17.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r18.putAll(r0);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r20 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r20, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r20.c("live_detail");
        Intrinsics.checkNotNullParameter("bottom_tab", "module");
        r20.b("bottom_tab");
        Intrinsics.checkNotNullParameter("live", "belong");
        r20.a("live");
        Intrinsics.checkNotNullParameter("click", "type");
        r20.d("click");
        List r21 = r19.a;
        ArrayList r23 = (ArrayList) r21;
        r23.add(r20.a);
        List r24 = r17.b;
        ArrayList r25 = (ArrayList) r24;
        r25.addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((f80.a) r27).w3("shortcut_gift_click", r17.a, r17.b);
        return;
    L5:
        r4 = "1";
        goto L6
    }

    public static void f(long r4, com.bytedance.android.livesdk.gift.platform.core.model.e0 r6, my1.a r7, long r8, long r10, Map r13, int r14, String r15, int r16) {
        if ((r16 & 2) == 0) goto L6;
        r6 = null;
    L6:
        if ((r16 & 4) == 0) goto L9;
        r7 = null;
    L9:
        if ((r16 & 32) == 0) goto L12;
        r13 = null;
    L12:
        if ((r16 & 64) == 0) goto L15;
        r14 = 0;
    L15:
        if ((r16 & 128) == 0) goto L18;
        r15 = null;
    L18:
        if (r4 == 0) goto L51;
        HashMap r17 = new HashMap();
        r17.put("gift_id", String.valueOf(r4));
        long r5 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        if (r8 <= r5) goto L23;
        r17.put("enter_time", String.valueOf(System.currentTimeMillis() - r8));
    L25:
        if (r10 <= r5) goto L27;
        r17.put("first_frame_time", String.valueOf(System.currentTimeMillis() - r10));
    L28:
        if (r6 == null) goto L35;
        Map<String, String> r9 = r6.a();
        if (r9 == null) goto L35;
        Iterator<Map.Entry<String, String>> r11 = r9.entrySet().iterator();
    L33:
        if (r11.hasNext() == false) goto L35;
        Map.Entry<String, String> r18 = r11.next();
        r17.put(r18.getKey(), r18.getValue());
    L35:
        r17.put("content", "normal");
        if (r7 == null) goto L43;
        my1.b r19 = r7.a;
        if (r19 == null) goto L43;
        r17.put("content", "gift_coin_task");
        String r20 = r19.rewardNum;
        if (r20 != null) goto L42;
        r20 = BuildConfig.FLAVOR;
    L42:
        r17.put("coin_reward_amt", r20);
    L43:
        if (r13 == null) goto L45;
        r17.putAll(r13);
    L45:
        r17.put("recommend_num", String.valueOf(r14));
        if (r15 != null) goto L48;
        r15 = BuildConfig.FLAVOR;
    L48:
        r17.put("to_user_id", r15);
        r17.put("to_user_type", "anchor");
        mz0.n r21 = new mz0.n();
        Map r23 = r21.a;
        Intrinsics.checkNotNullParameter(r23, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r23.putAll(r17);
        mz0.m r24 = new mz0.m();
        r24.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r25 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r25, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r25.c("live_detail");
        Intrinsics.checkNotNullParameter("bottom_tab", "module");
        r25.b("bottom_tab");
        Intrinsics.checkNotNullParameter("live", "belong");
        r25.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r25.d("other");
        ((ArrayList) r24.a).add(r25.a);
        ((ArrayList) r21.b).addAll(r24.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((f80.a) r27).w3("shortcut_gift_show", r21.a, r21.b);
        return;
    L27:
        r17.put("first_frame_time", "-1");
        goto L28
    L23:
        r17.put("enter_time", "-1");
        goto L25
    }
}
