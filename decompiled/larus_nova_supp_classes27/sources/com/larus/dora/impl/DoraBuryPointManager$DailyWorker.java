package com.larus.dora.impl;

import ak4.a;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.bytedance.dora.device.DoraDevice;
import g49.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/DoraBuryPointManager$DailyWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraBuryPointManager$DailyWorker extends Worker {
    public final ListenableWorker.Result doWork() {
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        r0.getClass();
        String r1 = DoraBuryPointManager.b;
        d.d(r1, "doDailyWork");
        long r2 = DoraBuryPointManager.i;
        DoraDevice r4 = a.d().a.A;
        if (r4 != null) goto L5;
    L54:
        DoraBuryPointManager.k();
    L56:
        return ListenableWorker.Result.success();
    L5:
        if (r2 == 0) goto L54;
        if (DoraBuryPointManager.m <= 0) goto L10;
        boolean r7 = true;
    L12:
        if (DoraBuryPointManager.l <= 0) goto L14;
        boolean r8 = true;
    L15:
        d.d(r1, "uploadTodayWearDuration. hasWearStartTime = " + r7 + " ,hasFoldOutTime = " + r8);
        r0.R(r4, false, "from:TodayWear");
        if (r7 == false) goto L18;
        DoraBuryPointManager.m = System.currentTimeMillis();
    L18:
        if (r8 == false) goto L20;
        DoraBuryPointManager.l = System.currentTimeMillis();
    L20:
        long r9 = System.currentTimeMillis();
        DoraBuryPointManager.j = r9;
        DoraDevice r3 = a.d().a.A;
        Pair[] r5 = new Pair[7];
        r5[0] = TuplesKt.to("external_device_type", "earphone");
        r5[1] = TuplesKt.to("external_device_name", "dora");
        r5[2] = TuplesKt.to("protocol_status", "end_of_day_disconnection");
        r5[3] = TuplesKt.to("protocol_time", Long.valueOf(r9 - r2));
        String r6 = "none";
        if (r3 == null) goto L24;
        String r10 = r3.getSerialNumber();
        if (r10 == null) goto L24;
    L25:
        r5[4] = TuplesKt.to("dora_series_no", r10);
        if (r3 == null) goto L29;
        String r11 = r3.getSerialNumber();
        if (r11 == null) goto L29;
    L30:
        r5[5] = TuplesKt.to("series_no", r11);
        if (r3 == null) goto L34;
        String r12 = r3.softVersion;
        if (r12 == null) goto L34;
    L35:
        r5[6] = TuplesKt.to("dora_FW_version", r12);
        Map r13 = MapsKt.mutableMapOf(r5);
        Pair[] r14 = new Pair[6];
        r14[0] = TuplesKt.to("external_device_type", "earphone");
        r14[1] = TuplesKt.to("external_device_name", "dora");
        r14[2] = TuplesKt.to("protocol_status", "end_of_day_connection");
        if (r3 == null) goto L39;
        String r15 = r3.getSerialNumber();
        if (r15 == null) goto L39;
    L40:
        r14[3] = TuplesKt.to("dora_series_no", r15);
        if (r3 == null) goto L44;
        String r16 = r3.getSerialNumber();
        if (r16 == null) goto L44;
    L45:
        r14[4] = TuplesKt.to("series_no", r16);
        if (r3 == null) goto L51;
        String r17 = r3.softVersion;
        if (r17 == null) goto L51;
        r6 = r17;
    L51:
        r14[5] = TuplesKt.to("dora_FW_version", r6);
        Map r18 = MapsKt.mutableMapOf(r14);
        r0.M("dora_proprietary_protocol_status", r13, new nk4.c(CollectionsKt.listOf(r3)), r3);
        r0.M("dora_proprietary_protocol_status", r18, new nk4.c(CollectionsKt.listOf(r3)), r3);
        r0.M("dora_proprietary_protocol_status_new", r13, new nk4.c(CollectionsKt.listOf(r3)), r3);
        r0.M("dora_proprietary_protocol_status_new", r18, new nk4.c(CollectionsKt.listOf(r3)), r3);
        long r20 = System.currentTimeMillis();
        if (DoraBuryPointManager.t.get() == false) goto L56;
        long r21 = r20 - DoraBuryPointManager.r;
        DoraBuryPointManager.r = r20;
        r0.N("end_of_day_disconnection", r21);
        DoraBuryPointManager.s = r20;
        r0.N("end_of_day_connection_earphone_mode", 0);
    L44:
        r16 = "none";
    L39:
        r15 = "none";
    L34:
        r12 = "none";
    L29:
        r11 = "none";
    L24:
        r10 = "none";
        goto L25
    L14:
        r8 = false;
        goto L15
    L10:
        r7 = false;
        goto L12
    }

    public DoraBuryPointManager$DailyWorker(Context r2, WorkerParameters r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "workerParams");
        super(r2, r3);
    }
}
