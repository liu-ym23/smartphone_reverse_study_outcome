package com.larksuite.component.card.monitor;

import android.text.TextUtils;
import com.larksuite.component.card.component.res.LynxResourceFetcher;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import fyb.e;
import idb.f;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardMonitorUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(boolean r2, String r3, OPTrace r4) {
        Intrinsics.checkNotNullParameter(r4, "trace");
        e r0 = b.a;
        b.c.a(ncb.c.s).addCategoryValue("content_same", Boolean.valueOf(r2)).addCategoryValue(CardActionService.CARD_ID, r3).tracing(r4).flush();
    }

    public static void c(String r2, long r3, Throwable r5, OPTrace r6) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r6, "trace");
        e r0 = b.a;
        OPMonitor r4 = b.c.a(ncb.c.p).addCategoryValue("js_path", r2).setResultTypeFail().setDuration(System.currentTimeMillis() - r3).tracing(r6);
        if ((r5 instanceof LynxResourceFetcher.LoadError) == false) goto L5;
        LynxResourceFetcher.LoadError r7 = (LynxResourceFetcher.LoadError) r5;
        r4.setErrorCode(String.valueOf(r7.getCode()));
        r4.setErrorMessage(r7.getMessage());
    L5:
        r4.flush();
    }

    public static void d(String r2, long r3, String r5, OPTrace r6) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r6, "trace");
        e r0 = b.a;
        b.c.a(ncb.c.p).addCategoryValue("js_path", r2).addCategoryValue("js_from", r5).setResultTypeSuccess().tracing(r6).setDuration(System.currentTimeMillis() - r3).flush();
    }

    public static void f(String r2, OPTrace r3, UniversalCardMonitorData r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "monitorData");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        e r0 = b.a;
        b.c.a(ncb.c.k).addCategoryValue(CardActionService.CARD_ID, r2).addCategoryValue("component_tag", r5).addMap(r4.getMonitorCategoryMap()).addCategoryValue("is_universal_card", Boolean.TRUE).addCategoryValue("is_streaming_mode", Boolean.valueOf(r6)).tracing(r3).flush();
    }

    public static void a(final String r3, final String r4, int r5, long r6, Map r8, Map r9) {
        if (r5 == 0) goto L10;
        if (r5 != 1) goto L25;
        if (r9 == null) goto L25;
        Long r10 = (Long) r9.get("draw_end");
        if (r10 == null) goto L25;
        long r11 = r10.longValue();
    L26:
        final long r12 = r11 - r6;
        Function1<String, Unit> r7 = new UniversalCardMonitorUtils$logCardRenderSuccess$log$1(r3, r4, r12);
        if (r5 == 0) goto L31;
        if (r5 != 1) goto L34;
        r7.invoke("update");
        return;
    L34:
        return;
    L31:
        r7.invoke("setup");
        return;
    L25:
        r11 = 0;
        goto L26
    L10:
        Long r13 = null;
        if (r8 == null) goto L13;
        Object r14 = r8.get("setup_timing");
    L15:
        if ((r14 instanceof Map) == false) goto L17;
        Map r15 = (Map) r14;
    L18:
        if (r15 != null) goto L20;
        return;
    L20:
        Object r16 = r15.get("draw_end");
        if ((r16 instanceof Long) == false) goto L23;
        r13 = (Long) r16;
    L23:
        if (r13 == null) goto L25;
        r11 = r13.longValue();
        goto L26
    L17:
        r15 = null;
        goto L18
    L13:
        r14 = null;
        goto L15
    }

    public static void e(int r3, String r4, OPTrace r5, long r6, long r8, long r10, Map r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "templateJsVersion");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        boolean r0 = f.a().isEnable("openplatform.universalcard.v8_engine");
        e r1 = b.a;
        OPMonitor r7 = b.c.a(ncb.c.e).addCategoryValue(CardActionService.CARD_ID, r4).addCategoryValue("render_duration", Long.valueOf(r8)).addCategoryValue("lynx_duration", Long.valueOf(r10)).addCategoryValue("card_duration", Long.valueOf(r6)).addCategoryValue("render_type", Integer.valueOf(r3)).addCategoryValue("template_version", r13).addCategoryValue("js_cache_enable", Boolean.TRUE).addCategoryValue("v8_enable", Boolean.valueOf(r0)).setDuration(r6).tracing(r5);
        if (r12 == null) goto L13;
        if (r3 != 0) goto L9;
        r7.addCategoryValue("setup_timing", r12);
        goto L13
    L9:
        if (r3 != 1) goto L13;
        r7.addCategoryValue("update_timing", r12);
    L13:
        r7.flush();
    }

    public static void h(String r2, OPTrace r3, long r4, String r6, boolean r7, UniversalCardMonitorData r8, String r9, Map r10, Map r11) {
        Intrinsics.checkNotNullParameter(r8, "monitorData");
        Intrinsics.checkNotNullParameter(r9, "componentType");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        e r0 = b.a;
        OPMonitor r5 = b.c.a(ncb.c.i).addCategoryValue(CardActionService.CARD_ID, r2).addCategoryValue(CardActionService.ACTION_ID, r6).addCategoryValue("component_tag", r9);
        if (r10 != null) goto L8;
        r10 = MapsKt.emptyMap();
    L8:
        OPMonitor r12 = r5.addCategoryValue("timestamp_detail", r10);
        if (r11 != null) goto L11;
        r11 = MapsKt.emptyMap();
    L11:
        r12.addCategoryValue("time_cost", r11).addCategoryValue("is_universal_card", Boolean.TRUE).addCategoryValue("is_streaming_mode", Boolean.valueOf(r7)).addMap(r8.getMonitorCategoryMap()).setDuration(r4).tracing(r3).flush();
    }

    public static void g(String r2, OPTrace r3, String r4, boolean r5, int r6, String r7, int r8, int r9, String r10, UniversalCardMonitorData r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "logId");
        Intrinsics.checkNotNullParameter(r11, "monitorData");
        Intrinsics.checkNotNullParameter(r12, "componentTag");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        e r0 = b.a;
        b.c.a(ncb.c.j).addCategoryValue(CardActionService.CARD_ID, r2).addCategoryValue(CardActionService.ACTION_ID, r4).addCategoryValue("error_code", Integer.valueOf(r6)).addCategoryValue("error_msg", r7).addCategoryValue("status", Integer.valueOf(r8)).addCategoryValue("regulate_code", Integer.valueOf(r9)).addCategoryValue("log_id", r10).addCategoryValue("component_tag", r12).addCategoryValue("is_universal_card", Boolean.TRUE).addCategoryValue("is_streaming_mode", Boolean.valueOf(r5)).addMap(r11.getMonitorCategoryMap()).tracing(r3).flush();
    }
}
