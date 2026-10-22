package od0;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.user.e;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    static {
    }

    public static void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "extra");
        tc0.c r0 = tc0.c.h();
        BaseMonitor.add(r4, "channel_id", String.valueOf(r0.getChannelId()));
        BaseMonitor.add(r4, "rtc_owner_user_id", r0.e);
        e r1 = k.n(IMiddlewareUserService.class).user();
        if (r1 == null) goto L6;
        String r2 = r1.n();
        if (r2 == null) goto L6;
    L7:
        BaseMonitor.add(r4, "rtc_current_user_id", r2);
        if (r0.N == false) goto L10;
        long r3 = 1;
    L11:
        BaseMonitor.add(r4, "is_client_mixstream", r3);
        BaseMonitor.add(r4, "rtc_extra_info", r0.k);
        v1 r5 = r0.n;
        if (r5 == null) goto L14;
        String r6 = r5.toString();
    L15:
        BaseMonitor.add(r4, "rtc_multi_extra_info", r6);
        BaseMonitor.add(r4, "linker_session_id", r0.x);
        BaseMonitor.add(r4, "remote_linker_session_id", r0.y);
        BaseMonitor.add(r4, "linker_media_type", ((IInteractService) k.n(IInteractService.class)).getVideoShowMode());
        return;
    L14:
        r6 = null;
        goto L15
    L10:
        r3 = 0;
    L6:
        r2 = "";
        goto L7
    }
}
