package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.r2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w extends OptionAction {
    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.l.c;
    }

    public w(ActionsManager r7) {
        Intrinsics.checkNotNullParameter(r7, "actionsManager");
        super(r7);
        HashMap r8 = new HashMap();
        IUser r0 = jc1.k.n(IUserService.class).user().b();
        if (this.b == null) goto L52;
        r8.put("report_type", "report_anchor");
        r8.put("show_type", "keep_press");
        Room r1 = this.b;
        String r2 = "";
        if (r1 == null) goto L11;
        User r3 = r1.getOwner();
        if (r3 == null) goto L11;
        String r4 = r3.getCastSecUid();
        if (r4 == null) goto L11;
    L12:
        r8.put("to_user_id", r4);
        com.bytedance.android.livesdk.log.filter.o r5 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r5.getMap().containsKey("video_id") == false) goto L19;
        String r6 = (String) r5.getMap().get("video_id");
        if (r6 == null) goto L18;
        r2 = r6;
    L18:
        r8.put("video_id", r2);
    L19:
        String r9 = "1";
        if (r0.isVcdContentAuthorized() == false) goto L22;
        Object r10 = "1";
    L23:
        r8.put("is_reporting_user_authorized", r10);
        Room r11 = this.b;
        if (r11 == null) goto L30;
        User r12 = r11.getOwner();
        if (r12 == null) goto L30;
        if (r12.isVcdContentAuthorized() != true) goto L30;
    L31:
        r8.put("is_reported_user_authorized", r9);
        Room r13 = this.b;
        if (r13 != null) goto L34;
    L36:
        String r14 = "normal";
    L37:
        r8.put("room_layout", r14);
        Room r15 = this.b;
        if (r15 == null) goto L40;
        LiveMode r16 = r15.getStreamType();
    L42:
        if (r16 == null) goto L47;
        int r17 = v.a[r16.ordinal()];
        if (r17 == 1) goto L49;
        if (r17 != 2) goto L47;
        String r18 = "third_party";
    L50:
        r8.put("live_type", r18);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_report_icon_show", r8, new Object[]{Room.class, new am2.x()});
        return;
    L49:
        r18 = "voice_live";
    L47:
        r18 = "video_live";
        goto L50
    L40:
        r16 = null;
        goto L42
    L34:
        if (r13.getRoomLayout() != 1) goto L36;
        r14 = "media";
    L30:
        r9 = "0";
        goto L31
    L22:
        r10 = "0";
    L11:
        r4 = "";
        goto L12
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        Room r10 = this.b;
        if (r10 == null) goto L78;
        User r1 = r10.getOwner();
        String r2 = "";
        if (r1 == null) goto L8;
        String r3 = r1.getCastSecUid();
        if (r3 == null) goto L8;
    L9:
        long r4 = r10.id;
        IUserService r5 = jc1.k.f(IUserService.class);
        if (r5 == null) goto L17;
        com.bytedance.android.livesdk.user.f r6 = r5.user();
        if (r6 == null) goto L17;
        IUser r7 = r6.b();
        if (r7 == null) goto L17;
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        String r8 = r7.getCastSecUid();
        if (r8 == null) goto L17;
    L18:
        r2 r0 = new r2(r3, r4, r8);
        r0.g = "report_anchor";
        r0.i = "keep_press_in";
        r0.j = r10.id;
        IReportService r11 = jc1.k.f(IReportService.class);
        if (r11 == null) goto L21;
        r11.reportWithReportAnchorEvent(ReportConstant.BusinessSource.LongPressPanel, r0, r10);
    L21:
        com.bytedance.android.livesdk.log.filter.o r12 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        HashMap r13 = new HashMap();
        r13.put("report_type", "report_anchor");
        r13.put("request_page", "keep_press_in");
        r13.put("to_user_id", r10.getOwnerUserIdString());
        r13.put("layer_show_page", "live_detail");
        if (r12.getMap().containsKey("video_id") == false) goto L28;
        String r14 = (String) r12.getMap().get("video_id");
        if (r14 == null) goto L27;
        r2 = r14;
    L27:
        r13.put("video_id", r2);
    L28:
        lc0.c r15 = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        com.bytedance.android.livesdk.log.filter.o r16 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        Long r17 = null;
        if ((r16 instanceof n0) == true) goto L31;
        r16 = null;
    L31:
        n0 r18 = (n0) r16;
        boolean r19 = false;
        if (r18 == null) goto L44;
        String r20 = r18.D();
        if (r20 == null) goto L44;
        if (r20.length() <= 0) goto L38;
        boolean r21 = true;
    L39:
        if (r21 == true) goto L42;
        r20 = null;
    L42:
        if (r20 == null) goto L44;
        r13.put("group_member_id", r20);
        goto L44
    L38:
        r21 = false;
    L44:
        com.bytedance.android.livesdk.log.g r22 = com.bytedance.android.livesdk.log.u.l();
        int r23 = am2.c0.b;
        r22.sendLog("livesdk_live_user_report", r13, new Object[]{am2.x.class, Room.class, am2.n.f(), am2.c0.a.a(r15.v())});
        if (am2.n.f().c().length() <= 0) goto L47;
        r19 = true;
    L47:
        if (r19 == false) goto L79;
        JSONObject r24 = new JSONObject();
        RoomContext.a r25 = RoomContext.Companion;     // Catch: JSONException -> L68
        RoomContext r26 = RoomContext.a.c(r25, null, 0, 3);     // Catch: JSONException -> L68
        if (r26 == null) goto L58;
        com.bytedance.live.datacontext.m r27 = r26.getRoom();     // Catch: JSONException -> L68
        if (r27 == null) goto L58;
        Room r28 = (Room) r27.getValue();     // Catch: JSONException -> L68
        if (r28 == null) goto L58;
        IUser r29 = r28.author();     // Catch: JSONException -> L68
        if (r29 == null) goto L58;
        String r30 = r29.getIdString();     // Catch: JSONException -> L68
    L59:
        r24.put("anchor_id", r30);     // Catch: JSONException -> L68
        RoomContext r31 = RoomContext.a.c(r25, null, 0, 3);     // Catch: JSONException -> L68
        if (r31 == null) goto L66;
        com.bytedance.live.datacontext.m r32 = r31.getRoom();     // Catch: JSONException -> L68
        if (r32 == null) goto L66;
        Room r33 = (Room) r32.getValue();     // Catch: JSONException -> L68
        if (r33 == null) goto L66;
        r17 = Long.valueOf(r33.id);     // Catch: JSONException -> L68
    L66:
        r24.put("room_id", r17);     // Catch: JSONException -> L68
    L70:
        k1.f(r24);
        LinkedHashMap r34 = new LinkedHashMap();
        r34.put("value", am2.n.f().c());
        r34.put("log_extra", am2.n.f().d());
        ILiveDouPlusService r35 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r36 = new HashMap();
        r36.put("ad_extra_data", r24.toString());
        if (r34.isEmpty() == true) goto L74;
        r36.putAll(r34);
    L74:
        r36.put("refer", "report_longpress");
        r35.logEvent(true, "live_ad", "otherclick", r36);
        return;
    L58:
        r30 = null;
    L68:
        e = move-exception;
        e.printStackTrace();
        goto L70
    L79:
        return;
    L17:
        r8 = "";
    L8:
        r3 = "";
        goto L9
    }
}
