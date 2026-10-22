package com.larus.disk.impl;

import com.larus.applog.api.IApplog;
import com.larus.disk.api.ManualCacheCleanError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static double g(long r2) {
        return RangesKt.coerceAtLeast(r2, 0) / 1048576.0d;
    }

    @JvmStatic
    public static final void d(List<m0> r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "bizFileInfoList");
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        Object r1 = r9.next();
        if (((m0) r1).g <= 512000) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L11:
        Iterator r10 = r0.iterator();
    L13:
        if (r10.hasNext() == false) goto L19;
        m0 r3 = (m0) r10.next();
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L17
        r4.putOpt("path", r3.a);     // Catch: Exception -> L17
        r4.putOpt("biz", r3.c);     // Catch: Exception -> L17
        r4.putOpt("business", r3.d);     // Catch: Exception -> L17
        r4.putOpt("is_internal", Boolean.valueOf(r3.e));     // Catch: Exception -> L17
        r4.putOpt("is_directory", Boolean.valueOf(r3.f));     // Catch: Exception -> L17
        r4.putOpt("biz_file_threshold", Long.valueOf(r3.j));     // Catch: Exception -> L17
        r4.putOpt("is_over_threshold", Boolean.valueOf(r3.k));     // Catch: Exception -> L17
        r4.putOpt("clean_type", Integer.valueOf(r8));     // Catch: Exception -> L17
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L17
        r5.putOpt("file_size", Long.valueOf(r3.g));     // Catch: Exception -> L17
        r5.putOpt("report_file_size", Double.valueOf(r3.h));     // Catch: Exception -> L17
        r5.putOpt("child_file_count", Integer.valueOf(r3.i));     // Catch: Exception -> L17
        com.larus.platform.service.g.a.monitorEventForSlardar("app_disk_scan_biz_file", r4, r5, null);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        FLogger.a.e("AppDiskLogger", "report Slardar event failed event=app_disk_scan_biz_file", e);
        goto L13
    }

    public static void e(String r2, Function0 r3) {
        IApplog.a.reportEvent(r2, (JSONObject) r3.invoke());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        FLogger.a.e("AppDiskLogger", "report TEA event failed event=".concat(r2), e);
    }

    public static double f(long r9, long r11) {
        if (r11 > 0) goto L7;
        return 0.0d;
    L7:
        return RangesKt.coerceIn(r9, 0, r11) / r11;
    }

    public static /* synthetic */ void b(int r17, String r18, long r110, long r21, boolean r23, boolean r24, Boolean r25, String r26, ManualCacheCleanError r27, int r28) {
        if ((r28 & 8) == 0) goto L5;
        long r5 = -1;
    L7:
        if ((r28 & 16) == 0) goto L9;
        long r7 = -1;
    L11:
        if ((r28 & 32) == 0) goto L13;
        boolean r9 = false;
    L15:
        if ((r28 & 64) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r28 & 128) == 0) goto L21;
        Boolean r11 = null;
    L23:
        if ((r28 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r28 & 512) == 0) goto L29;
        ManualCacheCleanError r13 = ManualCacheCleanError.NONE;
    L30:
        a(null, r17, r18, r5, r7, r9, r10, r11, r12, r13, false, false, false);
        return;
    L29:
        r13 = r27;
        goto L30
    L25:
        r12 = r26;
        goto L27
    L21:
        r11 = r25;
        goto L23
    L17:
        r10 = r24;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r5 = r110;
        goto L7
    }

    @JvmStatic
    public static final void a(final a r17, final int r18, final String r110, final long r20, final long r22, final boolean r24, final boolean r25, final Boolean r26, final String r27, final ManualCacheCleanError r28, final boolean r210, final boolean r30, final boolean r31) {
        Intrinsics.checkNotNullParameter(r110, "status");
        Intrinsics.checkNotNullParameter(r28, "error");
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L24
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L24
        if (r17 == null) goto L7;
        r1.putOpt("before_total_data_size", Double.valueOf(r17.a));     // Catch: Exception -> L24
        r1.putOpt("before_total_cache_size", Double.valueOf(r17.b));     // Catch: Exception -> L24
        r1.putOpt("after_total_data_size", Double.valueOf(r17.c));     // Catch: Exception -> L24
        r1.putOpt("after_total_cache_size", Double.valueOf(r17.d));     // Catch: Exception -> L24
        r1.putOpt("clean_total_handler_size", Double.valueOf(r17.e));     // Catch: Exception -> L24
        r1.putOpt("clean_total_size", Double.valueOf(r17.f));     // Catch: Exception -> L24
        r1.putOpt("time_cost", Long.valueOf(r17.j));     // Catch: Exception -> L24
    L7:
        if (r20 < 0) goto L10;
        r1.putOpt("before_cleanable_bytes", Long.valueOf(r20));     // Catch: Exception -> L24
    L10:
        if (r22 < 0) goto L12;
        r1.putOpt("remaining_cleanable_bytes", Long.valueOf(r22));     // Catch: Exception -> L24
    L12:
        r2.putOpt("status", r110);     // Catch: Exception -> L24
        r2.putOpt("is_manual", Boolean.valueOf(r24));     // Catch: Exception -> L24
        r2.putOpt("is_custom_biz_clean", Boolean.valueOf(r25));     // Catch: Exception -> L24
        if (r17 == null) goto L15;
        Boolean r0 = Boolean.valueOf(r17.g);     // Catch: Exception -> L24
    L16:
        if (r0 == null) goto L18;
        r2.putOpt("is_low_disk", Boolean.valueOf(r0.booleanValue()));     // Catch: Exception -> L24
    L18:
        r2.putOpt("clean_type", Integer.valueOf(r18));     // Catch: Exception -> L24
        r2.putOpt("task_id", r27);     // Catch: Exception -> L22
        r2.putOpt("error_code", r28.getCode());     // Catch: Exception -> L22
        r2.putOpt("error_reason", r28.getReason());     // Catch: Exception -> L22
        r2.putOpt("failure_stage", r28.getStage());     // Catch: Exception -> L22
        r2.putOpt("root_cache_failed", Boolean.valueOf(r210));     // Catch: Exception -> L22
        r2.putOpt("configured_path_failed", Boolean.valueOf(r30));     // Catch: Exception -> L22
        r2.putOpt("business_handler_failed", Boolean.valueOf(r31));     // Catch: Exception -> L22
        com.larus.platform.service.g.a.monitorEventForSlardar("app_disk_clean", r2, r1, null);     // Catch: Exception -> L22
    L27:
        e("app_disk_clean_result", new f(r18, r110, r24, r25, r27, r28, r210, r30, r31, r17, r26, r20, r22));
        return;
    L22:
        e = e;
    L26:
        FLogger.a.e("AppDiskLogger", "report Slardar event failed event=app_disk_clean", e);
        goto L27
    L15:
        r0 = r26;
    L24:
        e = e;
        goto L26
    }

    @JvmStatic
    public static final void c(String r8, int r9, String r10, String r11, String r12, long r13, long r15, long r17, long r110, long r21, boolean r23, boolean r24, String r25) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        Intrinsics.checkNotNullParameter(r10, "business");
        Intrinsics.checkNotNullParameter(r11, "bizTag");
        Intrinsics.checkNotNullParameter(r12, "status");
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L14
        r6.putOpt("task_id", r8);     // Catch: Exception -> L14
        r6.putOpt("clean_type", Integer.valueOf(r9));     // Catch: Exception -> L14
        r6.putOpt("business", r10);     // Catch: Exception -> L14
        r6.putOpt("biz", r11);     // Catch: Exception -> L14
        r6.putOpt("status", r12);     // Catch: Exception -> L14
        r6.putOpt("is_manual", Boolean.valueOf(r23));     // Catch: Exception -> L14
        r6.putOpt("is_low_disk", Boolean.valueOf(r24));     // Catch: Exception -> L14
        r6.putOpt("error_type", r25);     // Catch: Exception -> L14
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L14
        if (r13 < 0) goto L7;
        r0.putOpt("before_total_bytes", Long.valueOf(r13));     // Catch: Exception -> L14
    L7:
        if (r15 < 0) goto L9;
        r0.putOpt("before_cleanable_bytes", Long.valueOf(r15));     // Catch: Exception -> L14
    L9:
        r0.putOpt("cleaned_bytes", Long.valueOf(RangesKt.coerceAtLeast(r17, 0)));     // Catch: Exception -> L14
        if (r110 < 0) goto L12;
        r0.putOpt("remaining_cleanable_bytes", Long.valueOf(r110));     // Catch: Exception -> L14
    L12:
        r0.putOpt("duration_ms", Long.valueOf(RangesKt.coerceAtLeast(r21, 0)));     // Catch: Exception -> L14
        com.larus.platform.service.g.a.monitorEventForSlardar("app_disk_handler_clean", r6, r0, null);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        FLogger.a.e("AppDiskLogger", "report Slardar event failed event=app_disk_handler_clean", e);
    }
}
