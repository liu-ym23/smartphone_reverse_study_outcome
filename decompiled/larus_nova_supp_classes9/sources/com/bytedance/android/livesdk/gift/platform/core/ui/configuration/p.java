package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(mz0.n r2) {
        mz0.m r0 = new mz0.m();
        r0.b(LogCommon.PAGE_SOURCE_LOG);
        r0.b(LogCommon.ROOM);
        r0.b(LogCommon.DRAWER_LOG);
        List r3 = r2.b;
        ArrayList r4 = (ArrayList) r3;
        r4.addAll(r0.a);
    }

    public static void d(boolean r5) {
        mz0.n r0 = new mz0.n();
        a(r0);
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        if (r5 == false) goto L5;
        String r6 = "confirm";
    L6:
        Intrinsics.checkNotNullParameter("click_type", "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        r1.put("click_type", r6);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L9;
        String r7 = "1";
    L10:
        Intrinsics.checkNotNullParameter("is_anchor", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r1.put("is_anchor", r7);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_gift_voice_setting_close_popup_click", r0.a, r0.b);
        return;
    L9:
        r7 = "0";
        goto L10
    L5:
        r6 = "cancel";
        goto L6
    }

    public static void b(ClickType r6, Boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "clickType");
        mz0.n r0 = new mz0.n();
        a(r0);
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Map r8 = MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "set"), TuplesKt.to("gift_type", r6.getValue())});
        Intrinsics.checkNotNullParameter(r8, "map");
        r1.putAll(r8);
        if (r7 != null) goto L5;
    L9:
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_anchor_gift_effects_setting_popup_click", r0.a, r0.b);
        return;
    L5:
        if (r7.booleanValue() == false) goto L7;
        String r11 = "open";
    L8:
        Map r13 = MapsKt.mapOf(TuplesKt.to("switch_status", r11));
        Intrinsics.checkNotNullParameter(r13, "map");
        r1.putAll(r13);
        goto L9
    L7:
        r11 = "close";
        goto L8
    }

    public static void e(String r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "clickType");
        mz0.n r0 = new mz0.n();
        a(r0);
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter("click_type", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r1.put("click_type", r5);
        if (r6 == null) goto L10;
        if (r6.booleanValue() == false) goto L7;
        String r7 = "open";
    L8:
        Intrinsics.checkNotNullParameter("switch_status", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r1.put("switch_status", r7);
        goto L10
    L7:
        r7 = "close";
    L10:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L12;
        String r8 = "1";
    L13:
        Intrinsics.checkNotNullParameter("is_anchor", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r1.put("is_anchor", r8);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_audience_gift_effects_setting_popup_click", r0.a, r0.b);
        return;
    L12:
        r8 = "0";
        goto L13
    }

    public static void c(ClickType r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "clickType");
        if (r7 == false) goto L5;
        String r9 = "open";
    L6:
        if (r8 == false) goto L8;
        String r10 = "success";
    L9:
        mz0.n r0 = new mz0.n();
        a(r0);
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Map r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "set"), TuplesKt.to("gift_type", r6.getValue()), TuplesKt.to("result_name", r9 + '_' + r10)});
        Intrinsics.checkNotNullParameter(r11, "map");
        r1.putAll(r11);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_anchor_gift_effects_setting_result", r0.a, r0.b);
        return;
    L8:
        r10 = "fail";
        goto L9
    L5:
        r9 = "close";
        goto L6
    }
}
