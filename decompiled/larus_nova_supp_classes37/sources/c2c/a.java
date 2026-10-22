package c2c;

import com.ss.android.lark.statistics.Statistics;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {

    /* JADX INFO: renamed from: c2c.a$a, reason: collision with other inner class name */
    public static final class C0004a {
    }

    static {
    }

    public a() {
    }

    public static void b(long r4, VEBachQRCodeResult r6) {
        Intrinsics.checkNotNullParameter("ve", "type");
        Intrinsics.checkNotNullParameter("album", "scanSource");
        Statistics.sendEvent("qrcode_success_scan", new JSONObject().put("ve_scan_type", "ve").put("use_enigma_detect", false).put("time_consuming", r4).put("algo_duration", Float.valueOf(r6.getAvgTimeForQRCodeMs())).put("scan_source", "album").put("imageWidth", Integer.valueOf(r6.getCurrentFrameWidth())).put("imageHeight", Integer.valueOf(r6.getCurrentFrameHeight())).put("vesdk_enabled", "true"));
    }

    public static void a(String r3, boolean r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r5, "reason");
        Statistics.sendEvent("qrcode_exit_dev", new JSONObject().put("ve_scan_type", r3).put("use_enigma_detect", r4).put("reason", r5).put("time_consuming", r6).put("vesdk_enabled", "true"));
    }
}
