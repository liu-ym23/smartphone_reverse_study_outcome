package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPlatformMonitorUtils {
    public static long a;
    public static long b;
    public static final OpenPlatformMonitorUtils c = null;

    public OpenPlatformMonitorUtils() {
    }

    static {
        c = new OpenPlatformMonitorUtils();
        a = -1;
        b = -1;
    }

    public final void h(d r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "appInfo");
        Intrinsics.checkNotNullParameter(r4, "launchParam");
        d(this, "ttlive_open_platform_audience_entrence_hide", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4).c();
    }

    public static void o(Map r8, e r9, int r11) {
        OpenPlatformMonitorUtils r0 = c;
        Intrinsics.checkNotNullParameter(r8, "appInfo");
        Intrinsics.checkNotNullParameter(r9, "launchParam");
        Object r1 = r8.get("game");
        Object r3 = null;
        if ((r1 instanceof u) == true) goto L5;
        r1 = null;
    L5:
        u r4 = (u) r1;
        if (r4 == null) goto L8;
        a("ttlive_open_platform_parse_schema", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r4, r9, r11, null, null).c();
        return;
    L8:
        Object r12 = r8.get(OpenPlatformBaseDebugger.APP_ID);
        if ((r12 instanceof String) == true) goto L11;
        r12 = null;
    L11:
        String r13 = (String) r12;
        Object r2 = r8.get("OPEN_APP_NAME");
        if ((r2 instanceof String) == true) goto L14;
        r2 = null;
    L14:
        String r5 = (String) r2;
        Object r14 = r8.get("schema");
        if ((r14 instanceof String) == false) goto L18;
        r3 = r14;
    L18:
        d(r0, "ttlive_open_platform_parse_schema", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, new d(r13, r5, (String) r3), r9).c();
    }

    public final void g(d r3, e r4, final String r5) {
        Intrinsics.checkNotNullParameter(r3, "appInfo");
        Intrinsics.checkNotNullParameter(r4, "launchParam");
        Intrinsics.checkNotNullParameter(r5, "clickLocation");
        g r6 = d(this, "ttlive_open_platform_audience_entrance_click", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4);
        Function1<g, Unit> r7 = new OpenPlatformMonitorUtils$logEntranceClick$1(r5);
        Intrinsics.checkNotNullParameter(r7, "block");
        r7.invoke(r6);
        r6.c();
    }

    public final void l(u r8, e r9, final boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "launchParam");
        g r12 = b(this, "ttlive_open_platform_icon_click", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r8, r9, 96);
        Function1<g, Unit> r13 = new OpenPlatformMonitorUtils$logIconClick$1(r11);
        Intrinsics.checkNotNullParameter(r13, "block");
        r13.invoke(r12);
        r12.c();
    }

    public static g e(String r1, LiveTracingMonitor.EventType r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "service");
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r4, "launchFrom");
        g r0 = new g(r1, r2, r3);
        JSONObject r5 = r0.d;
        r5.put("launch_from", r4);
        r5.put("status", r3);
        return r0;
    }

    public final void j(d r3, e r4, final boolean r5, final boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "appInfo");
        Intrinsics.checkNotNullParameter(r4, "launchParam");
        g r7 = d(this, "ttlive_open_platform_audience_entrance_prepare", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L5
        Function1<g, Unit> r9 = new OpenPlatformMonitorUtils$logEntrancePrepare$$inlined$runCatching$lambda$1(r5, r6);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r9, "block");     // Catch: Throwable -> L5
        r9.invoke(r7);     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl(r7);     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r11) == false) goto L10;
        r11 = null;
    L10:
        g r12 = (g) r11;
        if (r12 == null) goto L16;
        r12.c();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void k(d r3, e r4, final long r5, final boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "appInfo");
        Intrinsics.checkNotNullParameter(r4, "launchParam");
        g r6 = d(this, "ttlive_open_platform_audience_entrance_show", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L5
        Function1<g, Unit> r9 = new OpenPlatformMonitorUtils$logEntranceShow$$inlined$runCatching$lambda$1(r5, r7);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r9, "block");     // Catch: Throwable -> L5
        r9.invoke(r6);     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl(r6);     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r11) == false) goto L10;
        r11 = null;
    L10:
        g r12 = (g) r11;
        if (r12 == null) goto L16;
        r12.c();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ g d(OpenPlatformMonitorUtils r8, String r9, LiveTracingMonitor.EventType r11, d r12, e r13) {
        r8.getClass();
        return c(r9, r11, r12, r13, 0, null, null, null);
    }

    public static void m(u r8, e r9, int r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "launchParam");
        a("ttlive_open_platform_launch_check", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r8, r9, r11, r12, r13).c();
    }

    public final void n(d r3, e r4, final boolean r5, final String r6, final boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "appInfo");
        Intrinsics.checkNotNullParameter(r4, "launchParam");
        Intrinsics.checkNotNullParameter(r6, "entranceStatus");
        g r8 = d(this, "ttlive_open_platform_audience_receive_entrance", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L5
        final boolean r0 = false;
        Function1<g, Unit> r11 = new OpenPlatformMonitorUtils$logReceiveEntrance$$inlined$runCatching$lambda$1(r0, r5, r6, r7);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r11, "block");     // Catch: Throwable -> L5
        r11.invoke(r8);     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(r8);     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r12) == false) goto L10;
        r12 = null;
    L10:
        g r13 = (g) r12;
        if (r13 == null) goto L16;
        r13.c();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ g b(OpenPlatformMonitorUtils r7, String r8, LiveTracingMonitor.EventType r9, u r11, e r12, int r13) {
        r7.getClass();
        return a(r8, r9, r11, r12, 0, null, null);
    }

    public static g a(String r6, LiveTracingMonitor.EventType r7, final u r8, final e r9, final int r11, final Integer r12, final String r13) {
        g r14 = e(r6, r7, r11, "anchor");
        Function1<g, Unit> r15 = new OpenPlatformMonitorUtils$anchorEvent$1(r8, r9, r11, r12, r13);
        Intrinsics.checkNotNullParameter(r15, "block");
        r15.invoke(r14);
        return r14;
    }

    public static g c(String r7, LiveTracingMonitor.EventType r8, final d r9, final e r11, final int r12, final Integer r13, final String r14, final String r15) {
        g r16 = e(r7, r8, r12, "audience");
        Function1<g, Unit> r17 = new OpenPlatformMonitorUtils$audienceEvent$1(r9, r11, r12, r13, r14, r15);
        Intrinsics.checkNotNullParameter(r17, "block");
        r17.invoke(r16);
        return r16;
    }

    public static void i(d r11, e r12, int r13, final boolean r14, final long r15, Integer r17, String r18, String r19, int r21) {
        Object r2 = null;
        if ((r21 & 32) == 0) goto L5;
        Integer r8 = null;
    L7:
        if ((r21 & 64) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r21 & 128) == 0) goto L13;
        String r16 = null;
    L14:
        Intrinsics.checkNotNullParameter(r11, "appInfo");
        Intrinsics.checkNotNullParameter(r12, "launchParam");
        g r0 = c("ttlive_open_platform_audience_entrance_info", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r11, r12, r13, r8, r9, r16);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        Function1<g, Unit> r3 = new OpenPlatformMonitorUtils$logEntranceInfo$$inlined$runCatching$lambda$1(r14, r15);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r3, "block");     // Catch: Throwable -> L17
        r3.invoke(r0);     // Catch: Throwable -> L17
        Object r4 = Result.constructor-impl(r0);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r4) == true) goto L23;
        r2 = r4;
    L23:
        g r5 = (g) r2;
        if (r5 == null) goto L29;
        r5.c();
        return;
    L29:
        return;
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L13:
        r16 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    public static void f(d r14, e r15, int r16, final boolean r17, boolean r18, long r19, Integer r21, String r22, String r23, int r24) {
        if ((r24 & 16) == 0) goto L5;
        final boolean r1 = false;
    L7:
        if ((r24 & 32) == 0) goto L9;
        final long r2 = 0;
    L10:
        Object r5 = null;
        if ((r24 & 64) == 0) goto L13;
        Integer r11 = null;
    L15:
        if ((r24 & 128) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r24 & 256) == 0) goto L21;
        String r13 = null;
    L22:
        Intrinsics.checkNotNullParameter(r14, "appInfo");
        Intrinsics.checkNotNullParameter(r15, "launchParam");
        g r0 = c("ttlive_open_platform_entrance_visible_check", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r14, r15, r16, r11, r12, r13);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        Function1<g, Unit> r6 = new OpenPlatformMonitorUtils$logAudienceVisibleCheck$$inlined$runCatching$lambda$1(r17, r1, r2);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r6, "block");     // Catch: Throwable -> L25
        r6.invoke(r0);     // Catch: Throwable -> L25
        Object r3 = Result.constructor-impl(r0);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r3) == true) goto L31;
        r5 = r3;
    L31:
        g r7 = (g) r5;
        if (r7 == null) goto L37;
        r7.c();
        return;
    L37:
        return;
    L25:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L21:
        r13 = r23;
        goto L22
    L17:
        r12 = r22;
        goto L19
    L13:
        r11 = r21;
        goto L15
    L9:
        r2 = r19;
        goto L10
    L5:
        r1 = r18;
        goto L7
    }
}
