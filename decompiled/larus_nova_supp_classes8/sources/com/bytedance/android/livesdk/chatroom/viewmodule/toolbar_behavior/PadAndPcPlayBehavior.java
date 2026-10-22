package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostMultiDeviceResume;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastMatchRoomLandScapeAnimCallback;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.castscreen.utils.LivePadPcLogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PadAndPcPlayBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public com.bytedance.android.livesdk.castscreen.padandpc.vm.a b;
    public final Lazy c;
    public final String d;
    public final b e;
    public final RoomContext f;

    public static final class a {
    }

    public static final class b implements ILiveCastMatchRoomLandScapeAnimCallback {
        public final /* synthetic */ PadAndPcPlayBehavior a;

        public final void dismissDialog() {
            this.a.getClass();
            if (m50.a.getValue().n() == false) goto L5;
            MatchRoomLandScapeAnimUtil.E.j("PadAndPcPlayBehavior");
        L5:
            com.bytedance.android.livesdk.f.d().f();
        }

        public b(PadAndPcPlayBehavior r1) {
            this.a = r1;
        }

        public final void showDialog(Integer r3, Dialog r4) {
            IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
            if (r0 == null) goto L7;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(this.a.a);
            if (r1 == null) goto L7;
            r1.setVisibilityStatus(false);
        L7:
            this.a.getClass();
            if (m50.a.getValue().n() == false) goto L10;
            boolean r2 = MatchRoomLandScapeAnimUtil.a;
            MatchRoomLandScapeAnimUtil.x("PadAndPcPlayBehavior", r4, r3);
        L10:
            com.bytedance.android.livesdk.f.d().a();
        }
    }

    static {
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
    public final void onClick(View r34) {
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.a).F0(PaidInteractEntry.CONTROL_PAD_OPEN) == true) goto L5;
        return;
    L5:
        LivePadPcLogger.a("livesdk_screen_share_click", this.a, AnonymousClass1.INSTANCE);
        DataCenter r1 = this.a;
        String r2 = this.d;
        AnonymousClass2 r3 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter("continued_broadcast_button_click", "$this$eventReportNoPrefix");
        LivePadPcLogger.d("continued_broadcast_button_click", r1, r2, r3);
        DataCenter r4 = this.a;
        if (r4 == null) goto L105;
        Room r5 = com.bytedance.android.live.core.utils.z.o(r4);
        if (r5 == null) goto L106;
        long r6 = r5.getRoomId();
        if (r34 == null) goto L107;
        Context r7 = r34.getContext();
        if (r7 == null) goto L109;
        com.bytedance.android.livesdk.user.f r8 = jc1.k.n(IUserService.class).user();
        com.bytedance.android.livesdk.log.filter.o r9 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        Lazy r10 = LazyKt.lazy(new PadAndPcPlayBehavior$onClick$roomLogger$2(this));
        JSONObject r11 = new JSONObject();
        r11.put("url_source", "app_continued");
        DataCenter r12 = this.a;
        if (r12 == null) goto L99;
        Room r13 = com.bytedance.android.live.core.utils.z.o(r12);
        if (r13 == null) goto L99;
        long r14 = r13.getRoomId();
        Pair[] r15 = new Pair[12];
        r15[0] = TuplesKt.to("author_id", r13.getOwnerUserIdString());
        r15[1] = TuplesKt.to("from_device_id", jc1.k.n(IHostContext.class).getServerDeviceId().toString());
        r15[2] = TuplesKt.to("from_user_id", r8.n());
        Context r16 = r7;
        r15[3] = TuplesKt.to("is_login", Boolean.valueOf(r8.isLogin()));
        String r17 = null;
        long r18 = r6;
        if (r9 == null) goto L23;
        Map r19 = r9.getMap();
        if (r19 == null) goto L23;
        String r20 = (String) r19.get("action_type");
    L24:
        r15[4] = TuplesKt.to("action_type", r20);
        r15[5] = TuplesKt.to("is_app_login", com.bytedance.android.live.core.utils.m2.b(r8.isLogin()));
        r15[6] = TuplesKt.to("scene", "live");
        ii1.a r21 = (ii1.a) r10.getValue();
        if (r21 == null) goto L27;
        String r22 = r21.h();
    L28:
        r15[7] = TuplesKt.to("enter_from_on_cellphone", r22);
        ii1.a r23 = (ii1.a) r10.getValue();
        if (r23 == null) goto L31;
        String r24 = r23.b();
    L32:
        r15[8] = TuplesKt.to("previous_page_on_cellphone", r24);
        DataCenter r25 = this.a;
        if (r25 != null) goto L35;
    L37:
        Object r26 = "0";
    L38:
        r15[9] = TuplesKt.to("is_landscape_status_on_cellphone", r26);
        String r27 = this.d;
        if (r27 != null) goto L41;
        r27 = "more_pannel";
    L41:
        r15[10] = TuplesKt.to("enter_method_on_cellphone", r27);
        JSONObject r28 = new JSONObject();
        r28.put("common_data", r11);
        Unit r30 = Unit.INSTANCE;
        r15[11] = TuplesKt.to("event_params", r28.toString());
        String r29 = com.bytedance.android.livesdk.castscreen.utils.d.a(r14, r15);
        IHostMultiDeviceResume r31 = (IHostMultiDeviceResume) this.c.getValue();
        if (r31 != null) goto L44;
    L100:
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r32 = this.b;
        if (r32 == null) goto L108;
        long r33 = r18;
        r32.checkAndShowDevicesDialog(r33, r16, this.f);
        return;
    L108:
        return;
    L44:
        if (r31.canUseNew() != true) goto L100;
        IHostMultiDeviceResume r35 = (IHostMultiDeviceResume) this.c.getValue();
        if (r35 == null) goto L104;
        DataCenter r110 = this.a;
        if (r110 != null) goto L50;
    L52:
        boolean r111 = false;
    L53:
        String r112 = r13.getAnchorId();
        JSONObject r36 = new JSONObject();
        r36.put("author_id", r13.getOwnerUserIdString());
        r36.put("from_device_id", jc1.k.n(IHostContext.class).getServerDeviceId().toString());
        r36.put("from_user_id", r8.n());
        r36.put("is_login", r8.isLogin());
        if (r9 == null) goto L58;
        Map r37 = r9.getMap();
        if (r37 == null) goto L58;
        String r38 = (String) r37.get("action_type");
    L59:
        r36.put("action_type", r38);
        r36.put("is_app_login", com.bytedance.android.live.core.utils.m2.b(r8.isLogin()));
        r36.put("scene", "live");
        r36.put("room_id", r13.getRoomId());
        r36.put("request_id", r13.getRequestId());
        r36.put("aweme_type", 101);
        ii1.a r39 = (ii1.a) r10.getValue();
        if (r39 == null) goto L62;
        String r40 = r39.h();
    L63:
        r36.put("enter_from_on_cellphone", r40);
        ii1.a r41 = (ii1.a) r10.getValue();
        if (r41 == null) goto L66;
        String r42 = r41.b();
    L67:
        r36.put("previous_page_on_cellphone", r42);
        DataCenter r43 = this.a;
        if (r43 != null) goto L70;
    L72:
        Object r44 = "0";
    L73:
        r36.put("is_landscape_status_on_cellphone", r44);
        String r45 = this.d;
        if (r45 != null) goto L76;
        r45 = "more_pannel";
    L76:
        r36.put("enter_method_on_cellphone", r45);
        JSONObject r46 = new JSONObject();
        r46.put("common_data", r11);
        r36.put("event_params", r46.toString());
        DataCenter r47 = this.a;
        if (r47 == null) goto L84;
        Room r48 = com.bytedance.android.live.core.utils.z.o(r47);
        if (r48 == null) goto L84;
        User r49 = r48.getOwner();
        if (r49 == null) goto L84;
        Object r50 = r49.getDisplayId();
        if (r50 == null) goto L84;
    L92:
        r36.put("u_display_id", r50);
        py.k r51 = r13.getCover();
        if (r51 == null) goto L97;
        List r52 = r51.getUrls();
        if (r52 == null) goto L97;
        r17 = (String) CollectionsKt.firstOrNull(r52);
    L97:
        r36.put("cover_url", r17);
        r35.startResume(r111, r18, r112, r29, r36.toString(), this.e);
        return;
    L84:
        DataCenter r53 = this.a;
        if (r53 == null) goto L91;
        Room r54 = com.bytedance.android.live.core.utils.z.o(r53);
        if (r54 == null) goto L91;
        User r55 = r54.getOwner();
        if (r55 == null) goto L91;
        r50 = Long.valueOf(r55.getShortId());
    L91:
        r50 = null;
        goto L92
    L70:
        if (com.bytedance.android.live.core.utils.z.m(r43, true) == true) goto L72;
        r44 = "1";
        goto L73
    L66:
        r42 = null;
        goto L67
    L62:
        r40 = null;
    L58:
        r38 = null;
        goto L59
    L50:
        if (com.bytedance.android.live.core.utils.z.m(r110, true) == true) goto L52;
        r111 = true;
        goto L53
    L104:
        return;
    L35:
        if (com.bytedance.android.live.core.utils.z.m(r25, true) == true) goto L37;
        r26 = "1";
        goto L38
    L31:
        r24 = null;
        goto L32
    L27:
        r22 = null;
    L23:
        r20 = null;
    L99:
        r16 = r7;
        r18 = r6;
        goto L100
    L109:
        return;
    L107:
        return;
    L106:
        return;
    }

    public PadAndPcPlayBehavior(RoomContext r1, String r2) {
        this.f = r1;
        this.c = LazyKt.lazy(PadAndPcPlayBehavior$hostAdapter$2.INSTANCE);
        this.d = r2;
        this.e = new b(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.a = r4;
        RoomContext r5 = this.f;
        DataContext r0 = null;
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.j r6 = r5.getPadAndPcPlayVm();
        if (r6 == null) goto L7;
        DataContext r7 = (DataContext) r6.getValue();
    L9:
        if ((r7 instanceof com.bytedance.android.livesdk.castscreen.padandpc.vm.a) == false) goto L12;
        r0 = r7;
    L12:
        this.b = (com.bytedance.android.livesdk.castscreen.padandpc.vm.a) r0;
        if (Intrinsics.areEqual(this.d, "landscape_control") == false) goto L16;
        LivePadPcLogger.b("continued_broadcast_button_show", r4, this.d, PadAndPcPlayBehavior$onLoad$1.INSTANCE);
        return;
    L16:
        return;
    L7:
        r7 = null;
        goto L9
    }
}
