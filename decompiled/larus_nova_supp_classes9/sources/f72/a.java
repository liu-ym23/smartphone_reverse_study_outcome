package f72;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void b(String r5) {
        Intrinsics.checkNotNullParameter("a100.a100.a313", "spm");
        Intrinsics.checkNotNullParameter(r5, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a313").addArg("info", r5), "LiveAudioComment");
    }

    public static void a(int r2, int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("error_code", r3);     // Catch: JSONException -> L5
    L7:
        LiveTracingMonitor.j("ttlive_sami_create_error", LiveTracingMonitor.EventModule.DIGG, r2, r0);
        return;
    L5:
        e = move-exception;
        Logger.e("LiveAudioLogger", e.getMessage());
        goto L7
    }
}
