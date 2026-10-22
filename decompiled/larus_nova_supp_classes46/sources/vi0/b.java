package vi0;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static void b() {
        JSONObject r5 = new JSONObject();
        r5.put("mute", true);
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerMedia, "guest_link_linkmic_player_mute_change", 0, null, r5, 88);
    }

    static {
    }

    public static void a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "channelId");
        Intrinsics.checkNotNullParameter(r9, "errorMsg");
        JSONObject r6 = new JSONObject();
        r6.put("channel_id", r8);
        r6.put("error", r9);
        int r10 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_join_rtc_room_finish", 0, null, r6, 88);
    }

    public static void c(String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "msgId");
        Intrinsics.checkNotNullParameter(r10, "reason");
        Intrinsics.checkNotNullParameter(r11, "toast");
        JSONObject r7 = new JSONObject();
        r7.put("msg_id", r9);
        r7.put("reason", r10);
        r7.put("toast", r11);
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_channel_finish_msg_receive", 0, null, r7, 88);
    }
}
