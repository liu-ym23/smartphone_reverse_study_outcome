package j69;

import com.larus.common.apphost.AppHost;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.ota.DoraOTAReporter;
import com.larus.dora.impl.device.ota.EventTypeOTAStatus;
import java.net.URL;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static int a;
    public static String b;

    public a() {
    }

    static {
        a = -1;
        b = "";
    }

    public static String a(String r1) {
        String r2 = new URL(r1).getHost();     // Catch: Exception -> L6
        if (r2 == null) goto L4;
        return r2;
    L4:
        return "none";
    }

    public static void d(String r6) {
        Intrinsics.checkNotNullParameter(r6, "failReason");
        b("ota_update_upload", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("duration", Long.valueOf(b.a("ota_update_upload"))), TuplesKt.to("fail_reason", r6), TuplesKt.to("error_message", "ota_" + r6)}));
    }

    public static void e(String r10) {
        long r1 = b.a("ota_update_device_reboot");
        if (r10 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        Map r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("duration", Long.valueOf(r1))});
    L13:
        b("ota_update_device_reboot", r11);
        return;
    L12:
        r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("duration", Long.valueOf(r1)), TuplesKt.to("fail_reason", r10), TuplesKt.to("error_message", "ota_" + r10)});
        goto L13
    L5:
        if (r10.length() == 0) goto L8;
        r5 = false;
        goto L10
    }

    public static void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "downloadUrl");
        b.b("ota_update_download");
        b("ota_update_download", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "start"), TuplesKt.to("package_host", a(r4))}));
        DoraOTAReporter.a.f.d = EventTypeOTAStatus.START_DOWNLOAD.getCode();
        DoraOTAReporter.d();
    }

    public static void h(String r3) {
        Intrinsics.checkNotNullParameter(r3, "failReason");
        b("ota_update_pre_check", MapsKt.mapOf(new Pair[]{TuplesKt.to("fail_reason", r3), TuplesKt.to("error_message", "ota_".concat(r3))}));
    }

    public static void b(String r5, Map r6) {
        DoraBuryPointManager.J(DoraBuryPointManager.a, r5, MapsKt.plus(r6, MapsKt.mapOf(new Pair[]{TuplesKt.to("update_method", "manual"), TuplesKt.to("package_type", Integer.valueOf(a)), TuplesKt.to("target_version", b), TuplesKt.to("background", Integer.valueOf(AppHost.a.a().isAppBackground() ? 1 : 0))})), false, 12);
    }

    public static void c(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "failReason");
        b("ota_update_check", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("fail_reason", r3), TuplesKt.to("error_message", "ota_" + r3), TuplesKt.to("retry_count", Integer.valueOf(r4))}));
    }

    public static void g(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "downloadUrl");
        b("ota_update_end", MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", Long.valueOf(b.a("ota_update_begin"))), TuplesKt.to("package_host", a(r4)), TuplesKt.to("update_status", FlowDoraConnectReason.SUCCESS), TuplesKt.to("retrycount", Integer.valueOf(r5))}));
        DoraOTAReporter.a.f.d = EventTypeOTAStatus.INSTALL_COMPLETED.getCode();
        DoraOTAReporter.d();
    }
}
