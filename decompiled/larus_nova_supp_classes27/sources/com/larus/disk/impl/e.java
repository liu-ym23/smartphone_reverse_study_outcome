package com.larus.disk.impl;

import com.larus.dora.api.model.FlowDoraConnectReason;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ g0 a;

    public /* synthetic */ e(g0 r1) {
        this.a = r1;
    }

    public final Object invoke() {
        g0 r0 = this.a;
        JSONObject r1 = new JSONObject();
        r1.put("disk_schema_version", 4);
        r1.put("disk_snapshot_id", r0.a);
        r1.put("disk_clean_type", r0.t);
        r1.put("scan_sample_rate", r0.u);
        r1.put("disk_sampling_strategy", r0.v);
        r1.put("scan_interval_ms", r0.w);
        r1.put("is_low_disk", r0.s);
        r1.put("is_external_storage_available", r0.r);
        boolean r3 = false;
        if (r0.b == null) goto L5;
        boolean r2 = true;
    L6:
        r1.put("system_storage_available", r2);
        if (r0.c == null) goto L9;
        r3 = true;
    L9:
        r1.put("device_storage_available", r3);
        t0 r4 = r0.b;
        int r5 = i.a;
        if (r4 == null) goto L16;
        long r6 = r4.a;
        long r7 = r4.b;
        long r8 = com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER;
        if ((com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER - r6) < r7) goto L15;
        r8 = r6 + r7;
    L15:
        r1.put("app_storage_mb", i.g(r8));
        r1.put("app_binary_mb", i.g(r4.a));
        r1.put("app_data_mb", i.g(r4.b));
        r1.put("app_cache_mb", i.g(r4.c));
    L16:
        r1.put("sandbox_storage_mb", i.g(r0.f));
        y r9 = r0.c;
        if (r9 == null) goto L19;
        r1.put("device_total_mb", i.g(r9.a));
        r1.put("device_storage_tier", r9.a());
        r1.put("device_available_mb", i.g(r9.b));
        r1.put("device_used_mb", i.g(RangesKt.coerceAtLeast(r9.a - r9.b, 0)));
        r1.put("device_available_ratio", r9.b / r9.a);
        r1.put("device_used_ratio", RangesKt.coerceAtLeast(r9.a - r9.b, 0) / r9.a);
    L19:
        r1.put("external_total_mb", i.g(r0.d));
        r1.put("external_available_mb", i.g(r0.e));
        r1.put("root_cache_storage_mb", i.g(r0.g));
        r1.put("registered_usage_mb", i.g(r0.h));
        r1.put("registered_auto_cleanable_mb", i.g(r0.i));
        r1.put("registered_manual_cleanable_mb", i.g(r0.j));
        r1.put("registered_handler_count", r0.k);
        r1.put("registered_handler_expected_count", r0.l);
        r1.put("registered_handler_failure_count", r0.m);
        r1.put("registered_candidate_failure_count", r0.n);
        r1.put("registered_collection_status", r0.o);
        r1.put("business_group_count", r0.p);
        r1.put("biz_group_count", r0.q);
        r1.put("file_type_scan_status", r0.y.a);
        r1.put("file_type_scan_depth", r0.x);
        r1.put("file_type_unreadable_path_count", r0.y.c);
        r1.put("file_type_scanned_mb", i.g(r0.y.a()));
        r1.put("file_type_coverage_ratio", i.f(r0.y.a(), r0.f));
        if (Intrinsics.areEqual(r0.y.a, FlowDoraConnectReason.SUCCESS) == false) goto L22;
    L23:
        a0 r10 = r0.y;
        r1.put("file_type_image_mb", i.g(r10.b(DiskFileType.IMAGE)));
        r1.put("file_type_video_mb", i.g(r10.b(DiskFileType.VIDEO)));
        r1.put("file_type_audio_mb", i.g(r10.b(DiskFileType.AUDIO)));
        r1.put("file_type_document_mb", i.g(r10.b(DiskFileType.DOCUMENT)));
        r1.put("file_type_archive_mb", i.g(r10.b(DiskFileType.ARCHIVE)));
        r1.put("file_type_database_mb", i.g(r10.b(DiskFileType.DATABASE)));
        r1.put("file_type_kv_mb", i.g(r10.b(DiskFileType.KV)));
        r1.put("file_type_log_mb", i.g(r10.b(DiskFileType.LOG)));
        r1.put("file_type_offline_resource_mb", i.g(r10.b(DiskFileType.OFFLINE_RESOURCE)));
        r1.put("file_type_other_mb", i.g(r10.b(DiskFileType.OTHER)));
    L24:
        return r1;
    L22:
        if (Intrinsics.areEqual(r0.y.a, "partial") == false) goto L24;
    L5:
        r2 = false;
        goto L6
    }
}
