package y50;

import android.os.Build;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends BaseMonitor {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @JvmStatic
    public static final void l(String r5, String r6, String r7, String r8, int r9, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r5, "containerType");
        Intrinsics.checkNotNullParameter(r6, "schema");
        Intrinsics.checkNotNullParameter(r7, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r8, "methodName");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        if (r12 != null) goto L5;
        r12 = new JSONObject();
    L5:
        a.getClass();
        BaseMonitor.add(r12, "device_name", Build.MODEL);
        IMiddleWareHostContext r2 = jc1.k.f(IMiddleWareHostContext.class);
        int r3 = 0;
        if (r2 == null) goto L8;
        int r4 = r2.hostAppId();
    L9:
        BaseMonitor.add(r12, "host_app_id", String.valueOf(r4));
        IMiddleWareHostContext r13 = jc1.k.f(IMiddleWareHostContext.class);
        if (r13 == null) goto L12;
        r3 = r13.appId();
    L12:
        BaseMonitor.add(r12, "webcast_app_id", String.valueOf(r3));
        BaseMonitor.add(r12, "container_type", r5);
        BaseMonitor.add(r12, "schema", r6);
        BaseMonitor.add(r12, LiveSlardarConstants.EXTRA_KEY_URL, r7);
        BaseMonitor.add(r12, "method_name", r8);
        BaseMonitor.add(r12, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r11);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_monitor_container", r9, r12);
        return;
    L8:
        r4 = 0;
        goto L9
    }

    public static /* synthetic */ void m(String r5, String r6, String r7, String r8, int r9, String r11, JSONObject r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r5 = "unknown";
    L5:
        String r1 = "";
        if ((r13 & 2) == 0) goto L8;
        String r0 = "";
    L10:
        if ((r13 & 4) == 0) goto L12;
        String r2 = "";
    L14:
        if ((r13 & 8) == 0) goto L16;
        String r3 = "";
    L18:
        if ((r13 & 16) == 0) goto L20;
        int r4 = 0;
    L22:
        if ((r13 & 32) != 0) goto L26;
        r1 = r11;
    L26:
        if ((r13 & 64) == 0) goto L28;
        r12 = null;
    L28:
        JSONObject r14 = r12;
        l(r5, r0, r2, r3, r4, r1, r14);
        return;
    L20:
        r4 = r9;
        goto L22
    L16:
        r3 = r8;
        goto L18
    L12:
        r2 = r7;
        goto L14
    L8:
        r0 = r6;
        goto L10
    }
}
