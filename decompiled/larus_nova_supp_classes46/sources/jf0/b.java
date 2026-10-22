package jf0;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    public static HashMap b() {
        boolean r1 = true;
        if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() == 1) goto L6;
        r1 = false;
    L6:
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L9;
        IRoom r2 = (IRoom) r0.getValue();
    L10:
        HashMap r3 = new HashMap();
        if (r1 == false) goto L13;
        r3.put("channel_id", String.valueOf(k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId()));
        c(r3);
    L13:
        String r4 = "0";
        if (r2 == null) goto L18;
        String r5 = r2.getOwnerUserIdString();
        if (r5 == null) goto L18;
    L19:
        r3.put("anchor_id", r5);
        if (r2 == null) goto L25;
        String r6 = String.valueOf(r2.getId());
        if (r6 == null) goto L25;
        r4 = r6;
    L25:
        r3.put("room_id", r4);
        return r3;
    L18:
        r5 = "0";
        goto L19
    L9:
        r2 = null;
        goto L10
    }

    static {
    }

    public static void a(HashMap r2) {
        if (d.Y() == false) goto L5;
        String r0 = d.b0().toString();
    L6:
        r2.put("admin_id", r0);
        if (d.Y() == false) goto L9;
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
        boolean r1 = true;
        if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        HashMap r3 = (HashMap) r2;
        r3.put("pk_id", String.valueOf(k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId()));
        r3.put("is_in_pk", "1");
        return;
    }

    public static void g(boolean r4) {
        HashMap r0 = b();
        if (r4 == false) goto L5;
        String r5 = "open";
    L6:
        r0.put("choice", r5);
        j0.l().sendLog("livesdk_anchor_audience_connection_switch", r0, new Object[]{IRoom.class});
        return;
    L5:
        r5 = "shut";
        goto L6
    }

    public static void j(String r8) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L5;
        boolean r0 = true;
    L6:
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
    L10:
        HashMap r5 = new HashMap();
        if (r0 == false) goto L13;
        r5.put("channel_id", String.valueOf(k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId()));
    L13:
        if (r0 == false) goto L15;
        String r6 = String.valueOf(k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
    L16:
        r5.put("pk_id", r6);
        String r7 = "0";
        if (r0 == false) goto L19;
        String r1 = "1";
    L20:
        r5.put("is_in_pk", r1);
        if (r4 == null) goto L24;
        String r2 = r4.getOwnerUserIdString();
        if (r2 == null) goto L24;
    L25:
        r5.put("anchor_id", r2);
        if (r4 == null) goto L31;
        String r9 = String.valueOf(r4.getId());
        if (r9 == null) goto L31;
        r7 = r9;
    L31:
        r5.put("room_id", r7);
        a(r5);
        j0.l().sendLog(r8, r5, new Object[]{IRoom.class});
        return;
    L24:
        r2 = "0";
        goto L25
    L19:
        r1 = "0";
        goto L20
    L15:
        r6 = "";
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static void e(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        if (r4 == false) goto L5;
        r0.put("function_type", "new_audience");
        r0.put("function_type2", "new_audience");
    L6:
        r0.put("request_page", r3);
        TalkRoomLogUtils.V0(r0);
        j0.l().sendLog("livesdk_anchor_audience_connection_open", r0, new Object[]{x.class, IRoom.class});
        return;
    L5:
        r0.put("function_type", "audience");
        goto L6
    }

    public static void f(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "closeType");
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        r0.put("function_type", "audience");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("applicant_id", r3);
        r0.put("close_type", r4);
        j0.l().sendLog("livesdk_anchor_audience_connection_application_close", r0, new Object[]{IRoom.class});
    }

    public static void h(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "connectType");
        HashMap r0 = b();
        r0.put("apply_choice", r3);
        if (r4 == false) goto L5;
        String r5 = "open";
    L6:
        r0.put("choice", r5);
        j0.l().sendLog("livesdk_anchor_audience_connection_apply_setup_click", r0, new Object[]{IRoom.class});
        return;
    L5:
        r5 = "shut";
        goto L6
    }

    public static void k(String r3, ICircleInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        r0.put("function_type", "audience");
        r0.put("shoot_way", "null");
        r0.put("request_page", r3);
        if (r4 == null) goto L8;
        String r5 = r4.getCircleName();
        if (r5 == null) goto L8;
        r0.put("circle_name", r5);
    L8:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue() == false) goto L10;
        String r6 = "on";
    L11:
        r0.put("is_camera_allow", r6);
        c(r0);
        String r7 = TalkRoomLogUtils.d;
        if (r7 == null) goto L15;
        r0.put("source", r7);
    L15:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L17;
        String r8 = "1";
    L18:
        r0.put("is_invite_only", r8);
        TalkRoomLogUtils.H0(r0);
        j0.l().sendLog("livesdk_anchor_audience_connection_open_success", r0, new Object[]{x.class, IRoom.class});
        return;
    L17:
        r8 = "0";
        goto L18
    L10:
        r6 = "off";
        goto L11
    }

    public static void d(String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "page");
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L5;
        r0.put("function_type", "new_audience");
        r0.put("function_type2", "new_audience");
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("invitee_id", r3);
        r0.put("request_page", r4);
        if (r5 == false) goto L11;
        String r6 = "anchor";
    L12:
        r0.put("invite_type", r6);
        r0.put("play_mode", u0.b());
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L15;
        String r7 = "1";
    L16:
        r0.put("is_invite_only", r7);
        TalkRoomLogUtils.V0(r0);
        a(r0);
        j0.l().sendLog("livesdk_anchor_audience_connection_invite", r0, new Object[]{x.class, IRoom.class});
        return;
    L15:
        r7 = "0";
        goto L16
    L11:
        r6 = "administrator";
        goto L12
    L5:
        r0.put("function_type", "audience");
        goto L6
    }

    public static void i(String r3, boolean r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "page");
        Intrinsics.checkNotNullParameter(r5, "json");
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        r0.put("function_type", "audience");
        r0.put("enter_from", "icon");
        r0.put("request_page", r3);
        if (r4 == false) goto L5;
        String r6 = "anchor";
    L6:
        r0.put("user_type", r6);
        r0.put("show_num", r5.toString());
        j0.l().sendLog("livesdk_anchor_invite_page_show", r0, new Object[]{IRoom.class});
        return;
    L5:
        r6 = "admin";
        goto L6
    }

    public static void l(String r16, boolean r17, String r18, String r19, boolean r20, String r21, String r22, String r23, int r24) {
        String r4 = "";
        if ((r24 & 32) == 0) goto L5;
        Object r2 = "";
    L7:
        if ((r24 & 64) == 0) goto L9;
        Object r5 = "";
    L11:
        if ((r24 & 128) == 0) goto L13;
        Object r6 = "";
    L15:
        if ((r24 & 256) == 0) goto L17;
        Object r7 = "";
    L19:
        if ((r24 & 1024) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r24 & 2048) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r24 & 4096) == 0) goto L29;
        String r1 = "";
    L30:
        Intrinsics.checkNotNullParameter(r19, "page");
        Intrinsics.checkNotNullParameter(r2, "fanTicket");
        Intrinsics.checkNotNullParameter(r5, "relationship");
        Intrinsics.checkNotNullParameter(r6, "topPos");
        Intrinsics.checkNotNullParameter(r7, "userLevel");
        HashMap r11 = new HashMap();
        int r12 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r12 != 5) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == false) goto L39;
        String r14 = "voice_live";
    L40:
        r11.put("live_type", r14);
        TalkRoomLogUtils.B0(r11, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        if (r16 == null) goto L43;
        String r3 = r16;
    L44:
        r11.put("applicant_id", r3);
        if (r17 == false) goto L47;
        Object r15 = "1";
    L48:
        r11.put("is_application_valid", r15);
        if (r20 == false) goto L51;
        String r110 = "anchor";
    L52:
        r11.put("pass_type", r110);
        if (TextUtils.isEmpty(r18) == false) goto L55;
        r11.put("is_application", "0");
    L60:
        r11.put("request_page", r19);
        li0.b r0 = li0.b.b;
        String r10 = li0.b.b();
        if (r10 == null) goto L63;
        r11.put("grouppk_stage", r10);
    L63:
        if (r20 == true) goto L67;
        if (d.Y() == true) goto L67;
    L69:
        a(r11);
        r11.put("label_name_live", String.valueOf(r8));
        if (r9 != null) goto L72;
    L77:
        r11.put("module_type", String.valueOf(r1));
        j0.l().sendLog("livesdk_anchor_audience_connection_pass_show", r11, new Object[]{IRoom.class, x.class});
        return;
    L72:
        if (r9.length() <= 0) goto L74;
        boolean r25 = true;
    L75:
        if (r25 != true) goto L77;
        r11.put("interactive_info", r9);
        goto L77
    L74:
        r25 = false;
    L67:
        if (vm2.d.r() != 1) goto L69;
        i0 r26 = TalkRoomLogUtils.a;
        r11.put("ordering_mode", TalkRoomLogUtils.v());
        r11.put("money", r2);
        r11.put("relationship", r5);
        r11.put("top_r", r6);
        r11.put("contribution_level", r7);
        goto L69
    L55:
        r11.put("is_application", "1");
        if (r18 == null) goto L59;
        r4 = r18;
    L59:
        r11.put("application_message", r4);
        goto L60
    L51:
        r110 = "administrator";
        goto L52
    L47:
        r15 = "0";
        goto L48
    L43:
        r3 = "";
        goto L44
    L39:
        r14 = "video_live";
        goto L40
    L33:
        if (r12 == 9) goto L36;
        r13 = false;
        goto L37
    L29:
        r1 = r23;
        goto L30
    L25:
        r9 = r22;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r2 = null;
        goto L7
    }
}
