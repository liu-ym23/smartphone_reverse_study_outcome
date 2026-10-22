package p8b;

import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "click");
        JSONObject r1 = new JSONObject();
        r1.put("click", r3);     // Catch: Exception -> L5
        r1.put("target", "none");     // Catch: Exception -> L5
    L7:
        d("scs_device_declare_click", r1);
        return;
    L5:
        e = move-exception;
        int r0 = ScsLogger.a;
        ScsLogger.c("scs-tracker", "tracker exception:" + e.getMessage());
        goto L7
    }

    public static String c(int r1) {
        if (r1 != NoPermissionType.DEVICE_OWNER.getValue()) goto L6;
        return "device_ownership";
    L6:
        if (r1 != NoPermissionType.DEVICE_STATE.getValue()) goto L9;
        return "device_status";
    L9:
        if (r1 != NoPermissionType.MFA.getValue()) goto L12;
        return "multi_factor";
    L12:
        if (r1 != NoPermissionType.NETWORK.getValue()) goto L14;
        return "web_environment";
    L14:
        return BuildConfig.FLAVOR;
    }

    public static void b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "click");
        JSONObject r1 = new JSONObject();
        r1.put("click", r2);     // Catch: Exception -> L5
        r1.put("reason", c(r3));     // Catch: Exception -> L5
        r1.put("target", "none");     // Catch: Exception -> L5
    L7:
        d("scs_no_access_click", r1);
        return;
    L5:
        e = move-exception;
        int r4 = ScsLogger.a;
        ScsLogger.c("scs-tracker", "tracker exception:" + e.getMessage());
        goto L7
    }

    public static void d(String r2, JSONObject r3) {
        int r0 = ScsLogger.a;
        ScsLogger.d("scs-tracker", "eventName: " + r2 + ", params: " + r3);
        Statistics.sendEvent(r2, r3);
    }
}
