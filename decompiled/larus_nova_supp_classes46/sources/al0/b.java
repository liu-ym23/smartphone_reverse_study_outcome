package al0;

import am2.x;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.CircleInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import dl0.n;
import ey.f;
import ey.g;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    public static HashMap b() {
        Room r2 = null;
        long r3 = 0;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r2 = (Room) r1.getValue();
    L7:
        HashMap r4 = new HashMap();
        g.a.getClass();
        nc0.b r5 = g.a.a();
        if (r5 == null) goto L14;
        LiveData r6 = r5.c();
        if (r6 == null) goto L14;
        f r7 = (f) r6.getValue();
        if (r7 == null) goto L14;
        r3 = r7.a;
    L14:
        r4.put("channel_id", String.valueOf(r3));
        c(r4);
        String r8 = "0";
        if (r2 == null) goto L18;
        String r9 = r2.getOwnerUserIdString();
        if (r9 == null) goto L18;
    L19:
        r4.put("anchor_id", r9);
        if (r2 == null) goto L25;
        String r10 = String.valueOf(r2.id);
        if (r10 == null) goto L25;
        r8 = r10;
    L25:
        r4.put("room_id", r8);
        IPkAudienceLinkOutService r11 = (IPkAudienceLinkOutService) k.f(IPkAudienceLinkOutService.class);
        if (r11 == null) goto L30;
        com.bytedance.android.live.pkaudience.api.a r12 = r11.getPkLinkUserInfoCenter();
        if (r12 == null) goto L30;
        int r13 = r12.b();
    L31:
        r4.put("audience_connect_cnt", String.valueOf(r13));
        return r4;
    L30:
        r13 = 0;
    L18:
        r9 = "0";
        goto L19
    }

    public static String d() {
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L5;
        return "new_audience";
    L5:
        return "";
    }

    static {
    }

    public static void a(HashMap r2) {
        if (n.c() == false) goto L5;
        String r0 = n.d();
    L6:
        r2.put("admin_id", r0);
        if (n.c() == false) goto L9;
        String r1 = "1";
    L10:
        r2.put("is_admin", r1);
        return;
    L9:
        r1 = "0";
        goto L10
    L5:
        r0 = "";
        goto L6
    }

    public static void c(Map r2) {
        HashMap r3 = (HashMap) r2;
        r3.put("pk_id", String.valueOf(k.n(ILinkServiceExternal.class).getMultiDataHolder().getPkId()));
        r3.put("is_in_pk", "1");
    }

    public static void f(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        HashMap r0 = b();
        r0.put("user_id", r3);
        if (r4 == false) goto L5;
        String r5 = "mute";
    L6:
        r0.put("click", r5);
        r0.put("function_type", "audience");
        r0.put("live_type", "video_live");
        a(r0);
        u.l().sendLog("livesdk_anchor_audience_connection_user_mute_click", r0, new Object[]{Room.class});
        return;
    L5:
        r5 = "cancel_mute";
        goto L6
    }

    public static void e(DataCenter r7, long r8, int r10, CircleInfo r11, int r12) {
        Boolean r0 = null;
        String r1 = "off";
        if ((r12 & 32) == 0) goto L5;
        Object r13 = "off";
    L6:
        Intrinsics.checkNotNullParameter(r13, "actionModeStatus");
        HashMap r2 = new HashMap();
        r2.put("live_type", "video_live");
        r2.put("function_type", d());
        r2.put("function_type2", d());
        r2.put("shoot_way", "null");
        r2.put("auction_mode_status", r13);
        Integer r14 = (Integer) com.bytedance.android.livesdk.sharedpref.c.t0.getValue();
        if (r14 != null) goto L10;
    L12:
        Object r15 = "on";
    L13:
        r2.put("reminder_type", r15);
        r2.put("duration", String.valueOf((System.currentTimeMillis() - r8) / ((long) 1000)));
        if (r10 == 0) goto L16;
        int r16 = r10 - 1;
    L17:
        r2.put("connect_pcu", String.valueOf(r16));
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue() == false) goto L20;
        Object r17 = "on";
    L21:
        r2.put("admin_switch_type", r17);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.m1.getValue()).booleanValue() == false) goto L24;
        Object r18 = "on";
    L25:
        r2.put("fans_apply_switch_type", r18);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.K0.getValue()).booleanValue() == false) goto L28;
        Object r19 = "on";
    L29:
        r2.put("apply_approve_switch_type", r19);
        if (r11 == null) goto L35;
        String r110 = r11.getCircleName();
        if (r110 == null) goto L35;
        r2.put("circle_name", r110);
    L35:
        if (r7 == null) goto L38;
        String r111 = (String) r7.get("data_room_video_talk_log_over_for_over_path", "");
        if (r111 == null) goto L38;
    L40:
        if (TextUtils.isEmpty(r111) == true) goto L44;
        r2.put("over_path", r111);
        if (r7 == null) goto L46;
        r7.put("data_room_video_talk_log_over_for_over_path", "");
    L46:
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L48;
        Object r112 = "on";
    L49:
        r2.put("is_camera_allow", r112);
        if (r7 == null) goto L53;
        r0 = (Boolean) r7.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE);
    L53:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L55;
        r1 = "on";
    L55:
        r2.put("gift_guest_switch_type", r1);
        c(r2);
        u.l().sendLog("anchor_audience_connection_over", r2, new Object[]{Room.class, x.class});
        return;
    L48:
        r112 = "off";
        goto L49
    L44:
        r2.put("over_path", "live_over");
    L38:
        r111 = "";
        goto L40
    L28:
        r19 = "off";
        goto L29
    L24:
        r18 = "off";
        goto L25
    L20:
        r17 = "off";
        goto L21
    L16:
        r16 = 0;
        goto L17
    L10:
        if (r14.intValue() != 2) goto L12;
        r15 = "off";
        goto L13
    L5:
        r13 = null;
        goto L6
    }
}
