package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LiveMode.values().length];
            a = r0;
            r0[LiveMode.AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[LiveMode.THIRD_PARTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public s4() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        DataCenter r10 = this.a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.get("data_room") == null) goto L65;
        Room r11 = (Room) this.a.get("data_room");
        if (r11.getBaseOwner() == null) goto L10;
        String r2 = r11.getBaseOwner().getCastSecUid();
    L11:
        zg1.r2 r1 = new zg1.r2(r2, r11.getId(), jc1.k.f(IUserService.class).user().b().getCastSecUid());
        r1.g = "report_anchor";
        r1.i = "more";
        r1.j = r11.getId();
        jc1.k.f(IReportService.class).reportWithReportAnchorEvent(ReportConstant.BusinessSource.MorePanelReportButton, r1, r11);
        HashMap r12 = new HashMap();
        DataCenter r3 = this.a;
        if (r3 == null) goto L66;
        Room r0 = (Room) r3.get("data_room");
        IUser r4 = jc1.k.f(IUserService.class).user().b();
        if (r0 != null) goto L17;
        return;
    L17:
        if (r0.getBaseOwner() == null) goto L63;
        if (r4 == null) goto L67;
        r12.put("report_type", "report_anchor");
        r12.put("show_type", "more");
        r12.put("request_page", "more");
        r12.put("to_user_id", r0.getBaseOwner().getIdString());
        String r5 = "1";
        if (r4.isVcdContentAuthorized() == false) goto L23;
        Object r6 = "1";
    L24:
        r12.put("is_reporting_user_authorized", r6);
        if (r0.getBaseOwner().isVcdContentAuthorized() == true) goto L28;
        r5 = "0";
    L28:
        r12.put("is_reported_user_authorized", r5);
        if (r0.getRoomLayout() != 1) goto L31;
        String r7 = "media";
    L32:
        r12.put("room_layout", r7);
        int r8 = a.a[r0.getStreamType().ordinal()];
        if (r8 == 1) goto L37;
        if (r8 == 2) goto L36;
        String r13 = "video_live";
    L38:
        r12.put("live_type", r13);
        r12.put("is_vr_machine", VrUtils.o(this.a));
        lc0.c r14 = jc1.k.f(ILinkServiceExternal.class).getMultiDataHolderExternal();
        com.bytedance.android.livesdk.log.g r15 = com.bytedance.android.livesdk.log.u.l();
        am2.l r16 = r14.v();
        int r17 = am2.c0.b;
        r15.sendLog("livesdk_live_user_report", r12, new Object[]{am2.x.class, Room.class, am2.n.f(), am2.c0.a.a(r16)});
        if (com.bytedance.android.livesdk.utils.c1.b(this.a) == false) goto L41;
    L42:
        JSONObject r18 = new JSONObject();
        r18.put("room_id", String.valueOf(r0.getId()));     // Catch: Exception -> L45
        r18.put("anchor_id", r0.author().getIdString());     // Catch: Exception -> L45
        r18.put("is_dou_plus_ad", com.bytedance.android.livesdk.utils.c1.b(this.a));     // Catch: Exception -> L45
        com.bytedance.android.livesdk.chatroom.utils.k1.f(r18);     // Catch: Exception -> L45
    L47:
        ILiveDouPlusService r19 = jc1.k.f(ILiveDouPlusService.class);
        if (com.bytedance.android.livesdk.utils.c1.c(this.a) == false) goto L50;
        Map r20 = com.bytedance.android.livesdk.utils.c1.f(this.a);
    L51:
        HashMap r21 = new HashMap();
        r21.put("ad_extra_data", r18.toString());
        if (r20 != null) goto L54;
    L57:
        r21.put("refer", "report_sharebutton");
        r19.logEvent(true, "live_ad", "otherclick", r21);
        return;
    L54:
        if (r20.isEmpty() == true) goto L57;
        r21.putAll(r20);
        goto L57
    L50:
        r20 = com.bytedance.android.livesdk.utils.c1.e(this.a);
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L47
    L41:
        if (com.bytedance.android.livesdk.utils.c1.c(this.a) == true) goto L42;
        return;
    L36:
        r13 = "third_party";
        goto L38
    L37:
        r13 = "voice_live";
        goto L38
    L31:
        r7 = "normal";
        goto L32
    L23:
        r6 = "0";
        goto L24
    L67:
        return;
    L63:
        return;
    L66:
        return;
    L10:
        r2 = "";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        this.a = r7;
        Room r8 = (Room) r7.get("data_room", null);
        HashMap r9 = new HashMap();
        DataCenter r10 = this.a;
        if (r10 == null) goto L33;
        Room r11 = (Room) r10.get("data_room");
        IUser r0 = jc1.k.f(IUserService.class).user().b();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.getBaseOwner() == null) goto L32;
        if (r0 == null) goto L34;
        r9.put("report_type", "report_anchor");
        r9.put("show_type", "more");
        r9.put("to_user_id", r11.getBaseOwner().getCastSecUid());
        String r1 = "1";
        if (r0.isVcdContentAuthorized() == false) goto L14;
        Object r2 = "1";
    L15:
        r9.put("is_reporting_user_authorized", r2);
        if (r11.getBaseOwner().isVcdContentAuthorized() == true) goto L19;
        r1 = "0";
    L19:
        r9.put("is_reported_user_authorized", r1);
        if (r11.getRoomLayout() != 1) goto L22;
        String r3 = "media";
    L23:
        r9.put("room_layout", r3);
        int r12 = a.a[r11.getStreamType().ordinal()];
        if (r12 == 1) goto L28;
        if (r12 == 2) goto L27;
        String r13 = "video_live";
    L29:
        r9.put("live_type", r13);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_report_icon_show", r9, new Object[]{Room.class, new am2.x()});
        return;
    L27:
        r13 = "third_party";
        goto L29
    L28:
        r13 = "voice_live";
        goto L29
    L22:
        r3 = "normal";
        goto L23
    L14:
        r2 = "0";
        goto L15
    L34:
        return;
    L32:
        return;
    }
}
