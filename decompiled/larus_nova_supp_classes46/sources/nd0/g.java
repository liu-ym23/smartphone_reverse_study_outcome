package nd0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.e1;
import com.bytedance.android.livesdk.chatroom.model.interact.d2;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import gm2.i;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Deprecated(message = "大多数逻辑已经下沉KMP-TalkRoomBusinessFullLinkMonitor，遗留部分在此，新增考虑加在TalkRoomBusinessFullLinkMonitor")
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String e(int r2) {
        if (r2 != 1) goto L5;
        return "switch_on";
    L5:
        if (r2 != 2) goto L7;
    L12:
        return "switch_off";
    L7:
        if (r2 == 3) goto L12;
        if (r2 != 4) goto L15;
        return "switch_continue";
    L15:
        return "unknown(" + r2 + ')';
    }

    public static void g(int r7) {
        JSONObject r2 = new JSONObject();
        r2.put("target_status", e(r7));
        c.o(c.a, LinkMonitorData.SelfDisciplineManagePanelOpenMonitorData, r2, 0, null, false, 28);
    }

    public static void d(long r5, ExtraResponse r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        e1 r2 = (e1) r7.data;
        if (r2 == null) goto L10;
        List r3 = r2.getInteractItems();
        if (r3 == null) goto L10;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        k1 r6 = (k1) r4.next();
        r1.put(String.valueOf(r6.getType()), r6.getTitle());
    L10:
        r0.put("play_mode_list", r1);
        TalkRoomBusinessFullLinkMonitor r8 = TalkRoomBusinessFullLinkMonitor.a;
        LinkMonitorData r9 = LinkMonitorData.InteractListApiMonitorData;
        r8.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r9, TalkRoomBusinessFullLinkMonitor.h(r5), r7.logId, r0);
    }

    public static void f(long r8, long r10, ILinkmicProfitMessage r12) {
        Intrinsics.checkNotNullParameter(r12, MultiLinkOpenSource.MESSAGE);
        JSONObject r3 = new JSONObject();
        r3.put("msg_id", r12.getMessageId());
        int r0 = r12.getMsgType();
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleCheckIn.getValue()) goto L6;
        String r13 = "checkin";
    L12:
        r3.put("msg_type", r13);
        r3.put("current_version_id", r8);
        r3.put("msg_version_id", r10);
        c.o(c.a, LinkMonitorData.ReceiveAudioSubtitleMsgMonitorData, r3, 0, null, false, 28);
        return;
    L6:
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleStart.getValue()) goto L9;
        r13 = "start";
        goto L12
    L9:
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleClose.getValue()) goto L11;
        r13 = "close";
        goto L12
    L11:
        r13 = "unknown: " + r12.getMsgType();
        goto L12
    }

    public static void h(i r3, long r4, Throwable r6) {
        Intrinsics.checkNotNullParameter(r3, "signal");
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
    L6:
        JSONObject r0 = new JSONObject();
        switch(r3.type) {
            case 100101: goto L10;
            case 100102: goto L9;
            default: goto L8;
        };
    L8:
        String r5 = "unknown: " + r3.type;
    L11:
        r0.put("signal_type", r5);
        TalkRoomBusinessFullLinkMonitor r7 = TalkRoomBusinessFullLinkMonitor.a;
        LinkMonitorData r1 = LinkMonitorData.SendSignalingApiMonitorData;
        r7.getClass();
        TalkRoomBusinessFullLinkMonitor.Y(r1, TalkRoomBusinessFullLinkMonitor.h(r4), r6, r0);
        return;
    L9:
        r5 = "foreground";
        goto L11
    L10:
        r5 = "background";
        goto L11
    L5:
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == true) goto L6;
    }

    public static void i(i r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "signal");
        Intrinsics.checkNotNullParameter(r6, "logId");
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
    L6:
        JSONObject r0 = new JSONObject();
        switch(r3.type) {
            case 100101: goto L10;
            case 100102: goto L9;
            default: goto L8;
        };
    L8:
        String r5 = "unknown: " + r3.type;
    L11:
        r0.put("signal_type", r5);
        TalkRoomBusinessFullLinkMonitor r7 = TalkRoomBusinessFullLinkMonitor.a;
        LinkMonitorData r1 = LinkMonitorData.SendSignalingApiMonitorData;
        r7.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r1, TalkRoomBusinessFullLinkMonitor.h(r4), r6, r0);
        return;
    L9:
        r5 = "foreground";
        goto L11
    L10:
        r5 = "background";
        goto L11
    L5:
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == true) goto L6;
    }

    public static void a(boolean r9, boolean r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "duration");
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        JSONObject r4 = new JSONObject();
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r1 = "anchor";
    L12:
        r4.put("open_status", r9);
        r4.put("subtitle_is_show", r10);
        r4.put("user_type", r1);
        r4.put("duration", r11);
        r4.put("request_page", r12);
        c.o(c.a, LinkMonitorData.AudioSubtitleDurationMonitorData, r4, 0, null, false, 28);
        return;
    L5:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L9;
    L10:
        r1 = "guest";
        goto L12
    L9:
        if (r2.intValue() != 0) goto L10;
        r1 = "user";
        goto L12
    }

    public static void b(boolean r9, boolean r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "duration");
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        JSONObject r4 = new JSONObject();
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r1 = "anchor";
    L12:
        r4.put("open_status", r9);
        r4.put("subtitle_is_show", r10);
        r4.put("user_type", r1);
        r4.put("duration", r11);
        r4.put("request_page", r12);
        c.o(c.a, LinkMonitorData.AudioSubtitlePauseDurationMonitorData, r4, 0, null, false, 28);
        return;
    L5:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L9;
    L10:
        r1 = "guest";
        goto L12
    L9:
        if (r2.intValue() != 0) goto L10;
        r1 = "user";
        goto L12
    }

    public static void j(String r2, int r3, long r4, ExtraResponse r6) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r6, "response");
        JSONObject r0 = new JSONObject();
        r0.put("to_user_id", r2);
        pd0.b r5 = pd0.b.a;
        r0.put("target_link_type", pd0.b.g(r3));
        TalkRoomBusinessFullLinkMonitor r7 = TalkRoomBusinessFullLinkMonitor.a;
        LinkMonitorData r8 = LinkMonitorData.UpdateLinkTypeApplyApiMonitorData;
        r7.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r8, TalkRoomBusinessFullLinkMonitor.h(r4), r6.logId, r0);
        d2 r9 = (d2) r6.data;
        Intrinsics.checkNotNullParameter(r9, "$this$getLiveCoreExtInfo");
        String r10 = r9.getLiveCoreExtInfoRaw();
        String r11 = "";
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        d2 r12 = (d2) r6.data;
        Intrinsics.checkNotNullParameter(r12, "$this$getRtcExtInfo");
        String r13 = r12.getRtcExtInfoRaw();
        if (r13 == null) goto L9;
        r11 = r13;
    L9:
        InteractLinkFullLinkMonitor.t0("update_link_type_apply_success", r10, r11, null, null);
    }

    public static void c(int r2, int r3, int r4, long r5, ExtraResponse r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        JSONObject r0 = new JSONObject();
        r0.put("target_scene", r2);
        pd0.b r6 = pd0.b.a;
        r0.put("emoji_type", pd0.b.b(r3));
        r0.put("category", pd0.b.a(r4));
        TalkRoomBusinessFullLinkMonitor r8 = TalkRoomBusinessFullLinkMonitor.a;
        LinkMonitorData r9 = LinkMonitorData.ListEmojisApiMonitorData;
        r8.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r9, TalkRoomBusinessFullLinkMonitor.h(r5), r7.logId, r0);
    }

    public static void k(int r2, int r3, String r4, long r5, Throwable r7) {
        Intrinsics.checkNotNullParameter(r4, "sourceFrom");
        JSONObject r0 = new JSONObject();
        r0.put("target_status", e(r2));
        r0.put("setting_value", r3);
        r0.put("source_from", r4);
        TalkRoomBusinessFullLinkMonitor r6 = TalkRoomBusinessFullLinkMonitor.a;
        LinkMonitorData r8 = LinkMonitorData.SelfDisciplineConfigApiMonitorData;
        r6.getClass();
        TalkRoomBusinessFullLinkMonitor.Y(r8, TalkRoomBusinessFullLinkMonitor.h(r5), r7, r0);
    }

    public static void l(int r2, int r3, String r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r4, "sourceFrom");
        Intrinsics.checkNotNullParameter(r7, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("target_status", e(r2));
        r0.put("setting_value", r3);
        r0.put("source_from", r4);
        TalkRoomBusinessFullLinkMonitor r6 = TalkRoomBusinessFullLinkMonitor.a;
        LinkMonitorData r8 = LinkMonitorData.SelfDisciplineConfigApiMonitorData;
        r6.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r8, TalkRoomBusinessFullLinkMonitor.h(r5), r7, r0);
    }
}
