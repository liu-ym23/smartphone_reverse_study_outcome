package y8;

import a9.j;
import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public d() {
    }

    public static void b(DegradeStatus r10) {
        Intrinsics.checkNotNullParameter(r10, "degradeStatus");
        j.a.sendEventToAllJsBridges("onDegradeRecovered", c(r10, 0));
    }

    public static JSONObject c(DegradeStatus r10, int r11) {
        JSONObject r0 = new JSONObject();
        r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r10.getStatus());
        if (r10 != DegradeStatus.liveDegrade) goto L6;
        if (r11 <= 0) goto L6;
        r0.put("level", r11);
    L6:
        return r0;
    }

    public static void a(DegradeStatus r0, int r1, int r10) {
        if ((r10 & 2) == 0) goto L5;
        r1 = 1;
    L5:
        Intrinsics.checkNotNullParameter(r0, "degradeStatus");
        j.a.sendEventToAllJsBridges("onDegradeHappened", c(r0, r1));
    }
}
