package dl0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.qd1;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends BaseMonitor {
    public static final m a = null;

    static {
        a = new m();
    }

    public static String p() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return "2";
    L9:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L13;
    L15:
        return "1";
    L13:
        if (r2.intValue() != 2) goto L15;
        return "3";
    }

    public m() {
    }

    public static void l(JSONObject r3) {
        BaseMonitor.add(r3, "channel_id", String.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder().getChannelId()));
        Room r0 = jc1.k.n(IRoomService.class).getCurrentRoom();
        IRoom.Companion r1 = IRoom.Companion;
        if (r1.isValid(r0) == false) goto L5;
        Room r2 = r0;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (r1.isValid(r0) == false) goto L10;
        String r4 = r2.getOwnerUserIdString();
    L11:
        BaseMonitor.add(r3, "anchor_id", r4);
        return;
    L10:
        r4 = "0";
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static void m(JSONObject r9) {
        lc0.c r0 = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder();
        BaseMonitor.add(r9, "channel_id", String.valueOf(r0.getChannelId()));
        BaseMonitor.add(r9, "event_session_id", String.valueOf(r0.getChannelId()));
        Room r1 = jc1.k.n(IRoomService.class).getCurrentRoom();
        IRoom.Companion r2 = IRoom.Companion;
        if (r2.isValid(r1) == false) goto L5;
        Room r3 = r1;
    L6:
        String r4 = "0";
        if (r3 != null) goto L9;
    L17:
        gy.c.c2.getClass();
        gy.c r5 = gy.c.a.a();
        long r6 = 1;
        if (r5 == null) goto L26;
        gy.f r7 = r5.getRtcManager();
        if (r7 == null) goto L26;
        if (r7.F() != true) goto L24;
        long r8 = 1;
    L25:
        BaseMonitor.add(r9, "is_client_mixstream", r8);
        goto L26
    L24:
        r8 = 0;
    L26:
        String r10 = r0.y();
        if (r10 == null) goto L33;
        com.bytedance.android.live.livepkaudience.service.f.z0.getClass();
        com.bytedance.android.live.livepkaudience.service.f r11 = com.bytedance.android.live.livepkaudience.service.f.a.a();
        if (r11 == null) goto L33;
        com.bytedance.android.live.livepkaudience.rtc.a r12 = r11.P2();
        if (r12 == null) goto L33;
        Intrinsics.checkNotNullParameter(r10, "interactId");
        boolean r13 = r12.t.contains(r10);
    L34:
        if (r13 == true) goto L37;
        r6 = 0;
    L37:
        BaseMonitor.add(r9, "disable_opposite_mic", r6);
        BaseMonitor.add(r9, "pk_id", r0.getPkId());
        BaseMonitor.add(r9, "invitee_list", r0.getInviteType());
        BaseMonitor.add(r9, "invitee_id", r0.a().toString());
        BaseMonitor.add(r9, "inviter_id", jc1.k.n(IUserService.class).user().n());
        BaseMonitor.add(r9, "use_multi_channel", "1");
        if (FoldScreenUtils.f() == false) goto L40;
        String r14 = "1";
    L41:
        BaseMonitor.add(r9, "is_fold_screen", r14);
        if (PadConfigUtils.c() == false) goto L44;
    L45:
        r4 = "1";
    L46:
        BaseMonitor.add(r9, "is_pad", r4);
        BaseMonitor.add(r9, "current_user_id", jc1.k.n(IUserService.class).user().n());
        BaseMonitor.add(r9, "current_mode", ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode());
        return;
    L44:
        if (PadConfigUtils.c() == false) goto L46;
    L40:
        r14 = "0";
    L33:
        r13 = false;
        goto L34
    L9:
        if (r2.isValid(r1) == false) goto L11;
        String r15 = r3.getIdStr();
    L12:
        BaseMonitor.add(r9, "room_id", r15);
        if (r2.isValid(r1) == false) goto L15;
        String r16 = r3.getOwnerUserIdString();
    L16:
        BaseMonitor.add(r9, "anchor_id", r16);
        goto L17
    L15:
        r16 = "0";
        goto L16
    L11:
        r15 = "0";
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static boolean t(m1.b r3) {
        if (r3.getLeft() == 1.0f) goto L5;
    L10:
        float r2 = 0;
        if (r3.getLeft() >= r2) goto L13;
    L14:
        return true;
    L13:
        if (r3.getRight() < r2) goto L14;
        return false;
    L5:
        if (r3.getRight() != 1.1f) goto L10;
        if (r3.getTop() != 1.0f) goto L10;
        if (r3.getBottom() == 1.1f) goto L14;
        goto L10
    }

    public static void v(BaseCheckException r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        JSONObject r0 = new JSONObject();
        OperateType r1 = r5.getOperateType();
        switch(l.a[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        String r2 = "universal_anim_for_saas";
    L14:
        BaseMonitor.add(r0, "operate_type", r2);
        BaseMonitor.add(r0, "check_type", r5.getCheckType().name());
        String r3 = r5.getMessage();
        String r4 = "";
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        BaseMonitor.add(r0, "error_msg", r3);
        CustomApiServerException r6 = r5.getCause();
        if (r6 != null) goto L20;
    L32:
        A("audience_check_link_permission_failed", r0);
        return;
    L20:
        if ((r6 instanceof CustomApiServerException) == false) goto L23;
        CustomApiServerException r7 = r6;
        BaseMonitor.add(r0, "url", r7.getUrl());
        BaseMonitor.add(r0, "xTtLogId", r7.getXTtLogId());
    L23:
        if ((r6 instanceof ApiServerException) == false) goto L30;
        String r8 = r6.getMessage();
        if (r8 == null) goto L28;
        r4 = r8;
    L28:
        BaseMonitor.add(r0, "cause_msg", r4);
    L30:
        if ((r6 instanceof ApiException) == false) goto L32;
        BaseMonitor.add(r0, "error_code", ((ApiException) r6).getErrorCode());
        goto L32
    L7:
        r2 = "midi";
        goto L14
    L8:
        r2 = "pre_reply";
        goto L14
    L9:
        r2 = "join";
        goto L14
    L10:
        r2 = "resume";
        goto L14
    L11:
        r2 = "pre_apply";
        goto L14
    L12:
        r2 = "reply";
        goto L14
    L13:
        r2 = "apply";
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void A(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "extra");
        if (r5 != null) goto L5;
        String r0 = "";
    L6:
        BaseMonitor.add(r6, "business_api_name", r0);
        m(r6);
        LiveTracingMonitor.EventModule r1 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.d("ttlive_pk_business_api_call", r1, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r6);
        HashMap r2 = new HashMap();
        r2.put("business_api_name", r5);
        r2.put("role_type", p());
        dy.b r3 = dy.b.a;
        r2.put("android_event_key", r5);
        dy.b.e("ttlive_pk_business_api_call", r1, r2, r6);
        return;
    L5:
        r0 = r5;
        goto L6
    }

    public static /* synthetic */ void B(m r1, String r2) {
        JSONObject r0 = new JSONObject();
        r1.getClass();
        A(r2, r0);
    }

    public static void C(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "apiName");
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        BaseMonitor.add(r0, "extra_msg", r3);
        A("pk_audience_" + r2, r0);
    }

    @JvmStatic
    public static final void n(long r6, Throwable r8) {
        JSONObject r5 = new JSONObject();
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r8 instanceof ApiServerException) == false) goto L10;
        m r0 = a;
        ApiServerException r9 = (ApiServerException) r8;
        int r2 = r9.getErrorCode();
        String r10 = r9.getErrorMsg();
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        long r3 = System.currentTimeMillis() - r6;
        r0.getClass();
        z("linkmic_audience/invite_list", r2, r10, r3, r5);
        return;
    L10:
        m r1 = a;
        String r11 = r8.toString();
        long r4 = System.currentTimeMillis() - r6;
        r1.getClass();
        z("linkmic_audience/invite_list", 1, r11, r4, r5);
    }

    @JvmStatic
    public static final void o(long r7, String r9) {
        Intrinsics.checkNotNullParameter(r9, "logId");
        JSONObject r6 = new JSONObject();
        BaseMonitor.add(r6, "api_log_id", r9);
        m r10 = a;
        long r4 = System.currentTimeMillis() - r7;
        r10.getClass();
        z("linkmic_audience/invite_list", 0, "", r4, r6);
    }

    @JvmStatic
    public static final void q(long r6, Throwable r8) {
        JSONObject r5 = new JSONObject();
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r8 instanceof ApiServerException) == false) goto L10;
        m r0 = a;
        ApiServerException r9 = (ApiServerException) r8;
        int r2 = r9.getErrorCode();
        String r10 = r9.getErrorMsg();
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        long r3 = System.currentTimeMillis() - r6;
        r0.getClass();
        z("linkmic_audience/waiting_list", r2, r10, r3, r5);
        return;
    L10:
        m r1 = a;
        String r11 = r8.toString();
        long r4 = System.currentTimeMillis() - r6;
        r1.getClass();
        z("linkmic_audience/waiting_list", 1, r11, r4, r5);
    }

    @JvmStatic
    public static final void r(long r7, String r9) {
        Intrinsics.checkNotNullParameter(r9, "logId");
        JSONObject r6 = new JSONObject();
        BaseMonitor.add(r6, "api_log_id", r9);
        m r10 = a;
        long r4 = System.currentTimeMillis() - r7;
        r10.getClass();
        z("linkmic_audience/waiting_list", 0, "", r4, r6);
    }

    @JvmStatic
    public static final void s(Throwable r6, long r7) {
        JSONObject r5 = new JSONObject();
        if (r6 != null) goto L5;
        return;
    L5:
        if ((r6 instanceof ApiServerException) == false) goto L10;
        m r0 = a;
        ApiServerException r8 = (ApiServerException) r6;
        int r2 = r8.getErrorCode();
        String r9 = r8.getErrorMsg();
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        r0.getClass();
        z("audience_pre_apply", r2, r9, r7, r5);
        return;
    L10:
        m r1 = a;
        String r10 = r6.toString();
        r1.getClass();
        z("audience_pre_apply", 1, r10, r7, r5);
    }

    @JvmStatic
    public static final void u(Throwable r7, long r8, String r10) {
        Intrinsics.checkNotNullParameter(r10, "reqFrom");
        JSONObject r6 = new JSONObject();
        BaseMonitor.add(r6, "request_source", r10);
        if (r7 != null) goto L5;
        return;
    L5:
        if ((r7 instanceof ApiServerException) == false) goto L10;
        m r11 = a;
        ApiServerException r9 = (ApiServerException) r7;
        int r2 = r9.getErrorCode();
        String r12 = r9.getErrorMsg();
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        r11.getClass();
        z("audience_leave", r2, r12, r8, r6);
        return;
    L10:
        m r13 = a;
        String r3 = r7.toString();
        r13.getClass();
        z("audience_leave", 1, r3, r8, r6);
    }

    public static void D(String r4, int r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "remoteViewIds");
        JSONObject r0 = new JSONObject();
        BaseMonitor.add(r0, "business_api_name", "update_first_video_frame");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        BaseMonitor.add(r0, "self_linkmic_id", r4);
        BaseMonitor.add(r0, "remote_view_size", r5);
        BaseMonitor.add(r0, "remote_view_ids", r6);
        BaseMonitor.add(r0, "is_anchor", r7 ? 1 : 0);
        l(r0);
        LiveTracingMonitor.EventModule r8 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.d("ttlive_pk_business_api_call", r8, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r0);
        HashMap r9 = new HashMap();
        r9.put("business_api_name", "update_first_video_frame");
        r9.put("role_type", p());
        dy.b r10 = dy.b.a;
        r9.put("android_event_key", "update_first_video_frame");
        dy.b.e("ttlive_pk_business_api_call", r8, r9, r0);
    }

    @JvmStatic
    public static final void w(int r9, long r10, String r12, String r13) {
        if (r12 == null) goto L13;
        int r1 = 1;
        if (r12.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 != true) goto L13;
        if (Intrinsics.areEqual(r12, "apply") == true) goto L12;
        r1 = 2;
    L12:
        r9 = r9 + (r1 * 1000);
        goto L13
    L6:
        r0 = false;
    L13:
        LinkedHashMap r2 = new LinkedHashMap();
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        r2.put("join_channel_type", r12);
        r2.put("stats", Integer.valueOf(r9));
        r2.put("duration", Long.valueOf(r10));
        r2.put("first_video_frame_type", "guest_self");
        m r11 = a;
        LiveTracingMonitor.EventModule r4 = LiveTracingMonitor.EventModule.PK;
        if (r13 != null) goto L19;
        r13 = "";
    L19:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        Intrinsics.checkNotNullParameter("first_remote_video_decoded_of_uid", "rtcCallBackName");
        Intrinsics.checkNotNullParameter(r13, "linkmicId");
        Intrinsics.checkNotNullParameter("", "statusMsg");
        dy.b r14 = dy.b.a;
        if (dy.b.c("first_remote_video_decoded_of_uid") == true) goto L29;
        JSONObject r8 = new JSONObject();
        BaseMonitor.add(r8, "rtc_callback_name", "first_remote_video_decoded_of_uid");
        BaseMonitor.add(r8, "linkmic_id", r13);
        Iterator r15 = r2.entrySet().iterator();
    L24:
        if (r15.hasNext() == false) goto L26;
        Map.Entry r16 = (Map.Entry) r15.next();
        r8.putOpt((String) r16.getKey(), r16.getValue());
        goto L24
    L26:
        HashMap r7 = new HashMap();
        r7.put("sdk_callback_name", "first_remote_video_decoded_of_uid");
        r7.put("role_type", p());
        dy.b r3 = dy.b.a;
        r7.put("android_event_key", "callback_".concat("first_remote_video_decoded_of_uid"));
        r3.d("ttlive_interact_sdk_callback", r4, 0, "", r7, r8);
        return;
    }

    public static /* synthetic */ void y(BaseMessage r7, long r8, int r10, long r11) {
        x(r7, r8, r10, r11, new JSONObject());
    }

    @JvmStatic
    public static final void x(BaseMessage r15, long r16, int r18, long r19, JSONObject r21) {
        Intrinsics.checkNotNullParameter(r15, "baseMessage");
        Intrinsics.checkNotNullParameter(r21, "extra");
        CommonMessageData r2 = r15.baseMessage;
        if (r2 == null) goto L10;
        String r3 = r2.method;
        if (r3 == null) goto L10;
        dy.b r4 = dy.b.a;
        if (dy.b.c(r3) == false) goto L10;
        return;
    L10:
        if (r15.baseMessage != null) goto L12;
        return;
    L12:
        BaseMonitor.add(r21, "server_message_type", r18);
        CommonMessageData r5 = r15.getBaseMessage();
        long r6 = 0;
        if (r5 == null) goto L15;
        long r7 = r5.messageId;
    L16:
        BaseMonitor.add(r21, "server_message_id", r7);
        CommonMessageData r8 = r15.getBaseMessage();
        if (r8 == null) goto L19;
        r6 = r8.createTime;
    L19:
        BaseMonitor.add(r21, "server_message_fetch_time", r6);
        BaseMonitor.add(r21, "server_message_process_time", r19);
        CommonMessageData r9 = r15.getBaseMessage();
        String r10 = "";
        if (r9 == null) goto L23;
        String r11 = r9.logId;
        if (r11 == null) goto L23;
    L24:
        BaseMonitor.add(r21, "server_message_log_id", r11);
        BaseMonitor.add(r21, "server_message_channel_id", r16);
        CommonMessageData r12 = r15.getBaseMessage();
        if (r12 == null) goto L28;
        String r13 = r12.method;
        if (r13 == null) goto L28;
    L29:
        BaseMonitor.add(r21, "server_message_name", r13);
        BaseMonitor.add(r21, "message_data", GsonProtectorUtils.toJson(GsonHelper.get(), r15));
        if ((r15 instanceof xe) == false) goto L35;
        xe r14 = (xe) r15;
        BaseMonitor.add(r21, "server_link_mic_scene", r14.getScene());
        String r17 = r14.getRtcExtInfo();
        if (r17 != null) goto L34;
        r17 = "";
    L34:
        BaseMonitor.add(r21, "server_rtc_extra_info", r17);
    L35:
        a.getClass();
        m(r21);
        LiveTracingMonitor.EventModule r20 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.d("ttlive_pk_server_message_receive", r20, LiveTracingMonitor.EventType.MESSAGE_RECEIVED, r21);
        HashMap r22 = new HashMap();
        CommonMessageData r23 = r15.getBaseMessage();
        if (r23 == null) goto L38;
        String r24 = r23.method;
    L39:
        r22.put("server_message_name", r24);
        if ((r15 instanceof if) == false) goto L70;
        if r25 = (if) r15;
        if (r25.getMType() != 101) goto L65;
        dy.b r26 = dy.b.a;
        StringBuilder r27 = new StringBuilder();
        CommonMessageData r28 = r15.getBaseMessage();
        if (r28 == null) goto L46;
        String r29 = r28.method;
    L47:
        r27.append(r29);
        r27.append("_");
        r27.append(r25.getMType());
        r27.append("_");
        LinkerSysKickOutContent r30 = r25.getMLinkerSysKickOutContent();
        if (r30 == null) goto L50;
        Integer r31 = Integer.valueOf(r30.getKickOutSource());
    L51:
        r27.append(r31.intValue());
        Object r32 = r27.toString();
        if (r32 != null) goto L54;
        r32 = 0;
    L54:
        r22.put("android_event_key", r32);
        LinkerSysKickOutContent r33 = r25.getMLinkerSysKickOutContent();
        if (r33 == null) goto L57;
        Integer r34 = Integer.valueOf(r33.getKickOutSource());
    L58:
        BaseMonitor.add(r21, "sys_kick_out_source", r34.intValue());
        LinkerSysKickOutContent r35 = r25.getMLinkerSysKickOutContent();
        if (r35 == null) goto L64;
        String r36 = r35.getLocalReasonToast();
        if (r36 == null) goto L64;
        r10 = r36;
    L64:
        BaseMonitor.add(r21, "sys_kick_out_reason", r10);
    L75:
        r22.put("role_type", p());
        dy.b r37 = dy.b.a;
        CommonMessageData r0 = r15.getBaseMessage();
        if (r0 == null) goto L78;
        String r110 = r0.logId;
    L79:
        Intrinsics.checkNotNullParameter("ttlive_pk_server_message_receive", "event");
        Intrinsics.checkNotNullParameter(r20, "module");
        Intrinsics.checkNotNullParameter(r22, "index");
        if (((Boolean) qd1.a.getValue()).booleanValue() == true) goto L83;
        return;
    L83:
        if (dy.b.c("ttlive_pk_server_message_receive") == true) goto L88;
        dy.b.a(r21);
        com.bytedance.android.live.core.monitor.trace.c.b(dy.b.b(r37, "ttlive_pk_server_message_receive", r20, r22, 0, null, r110, 0, 24), r21);
        return;
    L88:
        return;
    L78:
        r110 = null;
        goto L79
    L57:
        r34 = null;
        goto L58
    L50:
        r31 = null;
        goto L51
    L46:
        r29 = null;
        goto L47
    L65:
        dy.b r38 = dy.b.a;
        StringBuilder r39 = new StringBuilder();
        CommonMessageData r40 = r15.getBaseMessage();
        if (r40 == null) goto L68;
        String r41 = r40.method;
    L69:
        r39.append(r41);
        r39.append("_");
        r39.append(r25.getMType());
        r22.put("android_event_key", r39.toString());
        goto L75
    L68:
        r41 = null;
        goto L69
    L70:
        dy.b r42 = dy.b.a;
        CommonMessageData r43 = r15.getBaseMessage();
        if (r43 == null) goto L73;
        String r44 = r43.method;
    L74:
        r22.put("android_event_key", r44);
        goto L75
    L73:
        r44 = null;
        goto L74
    L38:
        r24 = null;
    L28:
        r13 = "";
    L23:
        r11 = "";
        goto L24
    L15:
        r7 = 0;
        goto L16
    }

    public static void z(String r9, int r10, String r11, long r12, JSONObject r14) {
        dy.b r0 = dy.b.a;
        if (dy.b.c(r9) == false) goto L5;
        return;
    L5:
        m(r14);
        BaseMonitor.add(r14, "duration", r12);
        BaseMonitor.add(r14, "server_api_name", r9);
        LiveTracingMonitor.EventModule r13 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.c("ttlive_pk_server_api_call", r13, LiveTracingMonitor.EventType.SERVER_API_CALL, r10, r11, null, null, r14);
        HashMap r5 = new HashMap();
        r5.put("server_api_name", r9);
        r5.put("android_event_key", r9);
        r5.put("role_type", p());
        r0.d("ttlive_pk_server_api_call", r13, r10, r11, r5, r14);
    }
}
