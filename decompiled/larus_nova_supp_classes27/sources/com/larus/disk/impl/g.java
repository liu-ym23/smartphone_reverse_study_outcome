package com.larus.disk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ float c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Pair f;
    public final /* synthetic */ List g;

    public /* synthetic */ g(String r1, int r2, float r3, long r4, boolean r6, Pair r7, List r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public final Object invoke() {
        String r1 = this.a;
        int r2 = this.b;
        float r3 = this.c;
        long r4 = this.d;
        boolean r6 = this.e;
        Pair r7 = this.f;
        List r8 = this.g;
        JSONObject r9 = new JSONObject();
        r9.put("disk_schema_version", 4);
        r9.put("disk_snapshot_id", r1);
        r9.put("disk_clean_type", r2);
        r9.put("scan_sample_rate", r3);
        r9.put("disk_sampling_strategy", "stable_install_bucket");
        r9.put("scan_interval_ms", r4);
        r9.put("is_low_disk", r6);
        r9.put("disk_business", r7.getFirst());
        r9.put("disk_biz", r7.getSecond());
        int r5 = i.a;
        List r10 = r8;
        Iterator r11 = r10.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        long r13 = RangesKt.coerceAtLeast(((s0) r11.next()).c, 0);
        if ((com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER - r12) < r13) goto L7;
        r12 = r12 + r13;
        goto L4
    L7:
        r12 = Long.MAX_VALUE;
        goto L4
    L9:
        r9.put("disk_business_usage_mb", i.g(r12));
        Iterator r14 = r10.iterator();
        long r15 = 0;
    L11:
        if (r14.hasNext() == false) goto L20;
        s0 r16 = (s0) r14.next();
        Intrinsics.checkNotNullParameter(r16, "it");
        Long r17 = r16.g;
        if (r17 == null) goto L15;
        long r18 = RangesKt.coerceAtLeast(r17.longValue(), 0);
    L17:
        if ((com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER - r15) < r18) goto L18;
        r15 = r15 + r18;
        goto L11
    L18:
        r15 = Long.MAX_VALUE;
        goto L11
    L15:
        r18 = 0;
        goto L17
    L20:
        r9.put("disk_auto_cleanable_mb", i.g(r15));
        Iterator r20 = r10.iterator();
        long r21 = 0;
    L22:
        if (r20.hasNext() == false) goto L31;
        s0 r22 = (s0) r20.next();
        Intrinsics.checkNotNullParameter(r22, "it");
        Long r23 = r22.h;
        if (r23 == null) goto L26;
        long r110 = RangesKt.coerceAtLeast(r23.longValue(), 0);
    L28:
        if ((com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER - r21) < r110) goto L29;
        r21 = r21 + r110;
        goto L22
    L29:
        r21 = Long.MAX_VALUE;
        goto L22
    L26:
        r110 = 0;
        goto L28
    L31:
        r9.put("disk_manual_cleanable_mb", i.g(r21));
        int r24 = 0;
        if ((r10 instanceof Collection) == true) goto L34;
    L36:
        Iterator r25 = r10.iterator();
    L38:
        if (r25.hasNext() == false) goto L42;
        if (((s0) r25.next()).i == true) goto L38;
        boolean r26 = false;
    L43:
        if (r26 == false) goto L45;
        String r27 = "complete";
    L46:
        r9.put("disk_collection_status", r27);
        r9.put("disk_handler_count", r8.size());
        List r28 = r8;
        boolean r30 = r28 instanceof Collection;
        if (r30 == true) goto L49;
    L51:
        Iterator r31 = r28.iterator();
        int r32 = 0;
    L53:
        if (r31.hasNext() == false) goto L59;
        if (((s0) r31.next()).e == false) goto L53;
        r32 = r32 + 1;
        if (r32 >= 0) goto L53;
        CollectionsKt.throwCountOverflow();
    L59:
        r9.put("disk_auto_cleanable_handler_count", r32);
        if (r30 == true) goto L62;
    L64:
        Iterator r33 = r28.iterator();
    L66:
        if (r33.hasNext() == false) goto L72;
        if (((s0) r33.next()).f == false) goto L66;
        r24 = r24 + 1;
        if (r24 >= 0) goto L66;
        CollectionsKt.throwCountOverflow();
    L72:
        r9.put("disk_manual_cleanable_handler_count", r24);
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r35 = r28.iterator();
    L74:
        if (r35.hasNext() == false) goto L76;
        r34.add(((s0) r35.next()).d);
        goto L74
    L76:
        String r36 = (String) CollectionsKt.singleOrNull(CollectionsKt.distinct(r34));
        if (r36 != null) goto L79;
        r36 = "mixed";
    L79:
        r9.put("disk_storage_scope", r36);
        return r9;
    L62:
        if (r28.isEmpty() == false) goto L64;
    L49:
        if (r28.isEmpty() == false) goto L51;
        r32 = 0;
        goto L59
    L45:
        r27 = "partial";
    L42:
        r26 = true;
        goto L43
    L34:
        if (r10.isEmpty() == false) goto L36;
        goto L36
    }
}
