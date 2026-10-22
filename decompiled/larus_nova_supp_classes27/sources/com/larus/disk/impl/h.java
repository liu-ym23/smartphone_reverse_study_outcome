package com.larus.disk.impl;

import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ float c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ y f;
    public final /* synthetic */ b0 g;
    public final /* synthetic */ j0 h;
    public final /* synthetic */ int i;

    public /* synthetic */ h(String r1, int r2, float r3, long r4, boolean r6, y r7, b0 r8, j0 r9, int r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final Object invoke() {
        String r0 = this.a;
        int r1 = this.b;
        float r2 = this.c;
        long r3 = this.d;
        boolean r5 = this.e;
        y r6 = this.f;
        b0 r7 = this.g;
        j0 r8 = this.h;
        int r9 = this.i;
        JSONObject r10 = new JSONObject();
        r10.put("disk_schema_version", 4);
        r10.put("disk_snapshot_id", r0);
        r10.put("disk_clean_type", r1);
        r10.put("scan_sample_rate", r2);
        r10.put("disk_sampling_strategy", "stable_install_bucket");
        r10.put("scan_interval_ms", r3);
        r10.put("is_low_disk", r5);
        boolean r4 = false;
        if (r6 == null) goto L5;
        boolean r11 = true;
    L6:
        r10.put("device_storage_available", r11);
        int r12 = i.a;
        if (r6 == null) goto L9;
        r10.put("device_total_mb", i.g(r6.a));
        r10.put("device_storage_tier", r6.a());
    L9:
        r10.put("disk_path", r7.a);
        r10.putOpt("disk_parent_path", r7.b);
        r10.put("disk_path_level", r7.c);
        r10.put("disk_path_storage_mb", i.g(r7.d));
        r10.put("disk_access_known_mb", i.g(r7.e));
        r10.put("disk_accessed_7d_mb", i.g(r7.f));
        r10.put("disk_accessed_30d_mb", i.g(r7.g));
        r10.put("disk_access_coverage_ratio", f0.b(r7.e, r7.d));
        if (r7.f <= 0) goto L12;
        int r13 = 1;
    L13:
        r10.put("disk_is_accessed_7d", r13);
        if (r7.g <= 0) goto L16;
        int r14 = 1;
    L17:
        r10.put("disk_is_accessed_30d", r14);
        r10.put("disk_usage_7d_ratio", f0.b(r7.f, r7.d));
        r10.put("disk_usage_30d_ratio", f0.b(r7.g, r7.d));
        r10.put("disk_access_source", "native_open_atime");
        r10.put("disk_access_process_scope", "initialized_app_processes");
        r10.put("disk_access_monitor_version", r8.e);
        r10.put("disk_access_observation_days", (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r8.a - r8.b, 0) / l0.c, 2147483647L));
        r10.put("disk_access_tracked_file_count", r7.h);
        if (r9 != 0) goto L20;
        r4 = true;
    L20:
        r10.put("disk_access_health_summary", r4);
        if (r4 == false) goto L23;
        r10.put("disk_access_update_failure_count", l0.a(r8.c, r8.k.get()));
        r10.put("disk_access_hook_success_count", r8.f);
        r10.put("disk_access_hook_failure_count", r8.g);
        r10.put("disk_access_hook_last_error_code", r8.h);
        r10.put("disk_access_hooked_symbol_mask", r8.i);
        r10.put("disk_access_failed_symbol_mask", r8.j);
    L23:
        return r10;
    L16:
        r14 = 0;
        goto L17
    L12:
        r13 = 0;
        goto L13
    L5:
        r11 = false;
        goto L6
    }
}
