package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.trace.DarEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTABuryPointManager {
    public static long a;
    public static long b;
    public static long c;
    public static long d;
    public static long e;
    public static long f;
    public static long g;
    public static long h;
    public static long i;
    public static long j;
    public static long k;
    public static String l;
    public static int m;
    public static String n;
    public static int o;
    public static int p;
    public static DoraDevice q;
    public static boolean r;
    public static int s;
    public static String t;

    public DoraOTABuryPointManager() {
    }

    static {
        h = -1;
        i = -1;
        j = -1;
        k = -1;
        l = "";
        n = "";
        r = true;
        t = "";
    }

    public static void c() {
        if (b == 0) goto L5;
        return;
    L5:
        b = System.currentTimeMillis();
        k("ota_update_connect", MapsKt.mapOf(TuplesKt.to("step", "start")));
    }

    public static void l() {
        if (g == 0) goto L5;
        return;
    L5:
        g = System.currentTimeMillis();
        k("ota_update_check", MapsKt.mapOf(TuplesKt.to("step", "start")));
    }

    public static void n() {
        if (g == 0) goto L5;
        return;
    L5:
        g = System.currentTimeMillis();
        k("ota_update_pre_check", MapsKt.mapOf(TuplesKt.to("step", "start")));
    }

    public static boolean a() {
        if (kj4.a.g().getDoraLinkState(ak4.a.d().a.A) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static void d(int r5) {
        if (a != 0) goto L5;
        return;
    L5:
        h = System.currentTimeMillis() - a;
        m = r5;
        k("ota_update_download", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("duration", Long.valueOf(h)), TuplesKt.to("fail_reason", String.valueOf(r5))}));
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L9;
        com.larus.dora.impl.trace.a.a(DarEvent.OtaDownloadEnd);
        return;
    }

    public static void e(String r6) {
        if (e != 0) goto L5;
        return;
    L5:
        k = System.currentTimeMillis() - e;
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("step", "end");
        r0[1] = TuplesKt.to("duration", Long.valueOf(k));
        if (r6 != null) goto L8;
        r6 = FlowDoraConnectReason.SUCCESS;
    L8:
        r0[2] = TuplesKt.to("fail_reason", r6);
        k("ota_update_reboot", MapsKt.mapOf(r0));
        e = 0;
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L12;
        com.larus.dora.impl.trace.a.a(DarEvent.OtaRebootEnd);
        return;
    }

    public static void h(OTAUpdatePackage r5) {
        System.currentTimeMillis();
        String r0 = "";
        if (r5 == null) goto L11;
        String r1 = r5.getVersion();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        l = r1;
        String r2 = r5.getUrl();
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        n = r2;
        o = r5.getType();
    L11:
        k("ota_update_begin", MapsKt.mapOf(TuplesKt.to("step", "start")));
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L37;
        com.larus.dora.impl.trace.b r3 = (com.larus.dora.impl.trace.b) com.larus.dora.impl.trace.a.a.getValue();
        if (r3 != null) goto L35;
    L23:
        DarEvent r4 = DarEvent.OtaUpdateBegin;
        LinkedHashMap r6 = new LinkedHashMap();
        if (r == false) goto L26;
        String r7 = "manual";
    L27:
        r6.put("update_method", r7);
        if (r5 == null) goto L33;
        String r8 = r5.toString();
        if (r8 == null) goto L33;
        r0 = r8;
    L33:
        r6.put("packageInfo", r0);
        r6.put("requestParams", t);
        r4.setExtra(r6);
        com.larus.dora.impl.trace.a.a(r4);
        return;
    L26:
        r7 = "automatic";
        goto L27
    L35:
    L21:
        e = move-exception;
        g49.d.b("【DarLite】", "startRecord:" + e.getMessage());
        goto L23
    L16:
        if (r3.b.contains(r3.c) == true) goto L23;
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L21
        String r10 = r3.c;     // Catch: Exception -> L21
        if (r10 == null) goto L23;
        r3.b.put(r10, r9);     // Catch: Exception -> L21
        goto L23
    }

    public static void b(String r7, String r8) {
        if (b != 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - b;
        Pair[] r4 = new Pair[4];
        r4[0] = TuplesKt.to("step", "end");
        r4[1] = TuplesKt.to("duration", Long.valueOf(r0));
        if (r7 != null) goto L8;
        r7 = FlowDoraConnectReason.SUCCESS;
    L8:
        r4[2] = TuplesKt.to("fail_reason", r7);
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r4[3] = TuplesKt.to("error_message", r8);
        k("ota_update_connect", MapsKt.mapOf(r4));
        b = 0;
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L15;
        com.larus.dora.impl.trace.a.a(DarEvent.OtaConnectEnd);
        return;
    }

    public static void f(String r6, String r7) {
        if (c != 0) goto L5;
        return;
    L5:
        i = System.currentTimeMillis() - c;
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("step", "end");
        r0[1] = TuplesKt.to("duration", Long.valueOf(i));
        if (r6 != null) goto L8;
        r6 = FlowDoraConnectReason.SUCCESS;
    L8:
        r0[2] = TuplesKt.to("fail_reason", r6);
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r0[3] = TuplesKt.to("error_message", r7);
        k("ota_update_transfer", MapsKt.mapOf(r0));
        c = 0;
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L15;
        com.larus.dora.impl.trace.a.a(DarEvent.OtaTransferEnd);
        return;
    }

    public static void g(String r6, String r7) {
        if (d != 0) goto L5;
        return;
    L5:
        j = System.currentTimeMillis() - d;
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("step", "end");
        r0[1] = TuplesKt.to("duration", Long.valueOf(j));
        if (r6 != null) goto L8;
        r6 = FlowDoraConnectReason.SUCCESS;
    L8:
        r0[2] = TuplesKt.to("fail_reason", r6);
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r0[3] = TuplesKt.to("error_message", r7);
        k("ota_update_verify", MapsKt.mapOf(r0));
        d = 0;
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L15;
        com.larus.dora.impl.trace.a.a(DarEvent.OtaVerifyEnd);
        return;
    }

    public static void k(String r7, Map r8) {
        Map r9 = MapsKt.toMutableMap(r8);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraOTABuryPointManager$reportOtaStageEvent$1(r9, r7, null), 3, null);
    }

    public static void m(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        if (g != 0) goto L5;
        return;
    L5:
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("step", "end");
        r0[1] = TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - g));
        r0[2] = TuplesKt.to("fail_reason", r8);
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        r0[3] = TuplesKt.to("error_message", r9);
        k("ota_update_check", MapsKt.mapOf(r0));
        g = 0;
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r8, FlowDoraConnectReason.SUCCESS) == true) goto L15;
        com.larus.dora.impl.trace.a.a(DarEvent.OtaUpdateCheck);
        return;
    }

    public static void o(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        if (g != 0) goto L5;
        return;
    L5:
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("step", "end");
        r0[1] = TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - g));
        r0[2] = TuplesKt.to("fail_reason", r8);
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        r0[3] = TuplesKt.to("error_message", r9);
        k("ota_update_pre_check", MapsKt.mapOf(r0));
        g = 0;
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r8, FlowDoraConnectReason.SUCCESS) == true) goto L15;
        com.larus.dora.impl.trace.a.a(DarEvent.OtaUpdatePreCheck);
        return;
    }

    public static void i(boolean r4, String r5, OTAUpdatePackage r6) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        a = System.currentTimeMillis();
        if (r6 == null) goto L12;
        String r0 = r6.getVersion();
        String r1 = "";
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        l = r0;
        String r2 = r6.getUrl();
        if (r2 == null) goto L11;
        r1 = r2;
    L11:
        n = r1;
        o = r6.getType();
    L12:
        Pair[] r7 = new Pair[3];
        String r3 = FlowDoraConnectReason.SUCCESS;
        if (r4 == false) goto L15;
        Object r8 = FlowDoraConnectReason.SUCCESS;
    L16:
        r7[0] = TuplesKt.to("update_status", r8);
        r7[1] = TuplesKt.to("fail_reason", r5);
        r7[2] = TuplesKt.to("error_message", r5);
        k("ota_check_update_result", MapsKt.mapOf(r7));
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L26;
        DarEvent r9 = DarEvent.OtaCheckUpdateResult;
        r9.setMessage(r5);
        Map<String, Object> r10 = r9.getExtra();
        if (r10 == null) goto L24;
        if (r4 == true) goto L23;
        r3 = "failure";
    L23:
        com.larus.utils.l.c(r10, "status", r3);
    L24:
        com.larus.dora.impl.trace.a.a(r9);
        return;
    L26:
        return;
    L15:
        r8 = "failure";
        goto L16
    }

    public static void j(boolean r10, String r11, String r12, int r13) {
        if (f != 0) goto L5;
        return;
    L5:
        f = 0;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraOTABuryPointManager$reportOtaEnd$1(r10, r11, r13, r12, null), 3, null);
    }
}
