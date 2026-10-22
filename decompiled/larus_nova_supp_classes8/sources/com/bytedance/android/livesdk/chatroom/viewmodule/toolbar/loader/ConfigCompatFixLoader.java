package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.setting.o;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/ConfigCompatFixLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConfigCompatFixLoader extends AbsDynamicLoader {
    public static final /* synthetic */ int i = 0;
    public ArrayList<ToolbarButton> h;

    public static final class a {
        public static boolean a(DataCenter r11) {
            Intrinsics.checkNotNullParameter(r11, "dataCenter");
            Room r0 = (Room) r11.get("data_room");
            if (r0 == null) goto L9;
            User r2 = r0.getOwner();
            if (r2 == null) goto L9;
            if (r2.getSecret() != 1) goto L9;
            return true;
        L9:
            if (r0 == null) goto L15;
            RoomAuthStatus r3 = r0.getMRoomAuthStatus();
            if (r3 == null) goto L15;
            if (r3.isDisableShare() != true) goto L15;
            return true;
        L15:
            Boolean r4 = (Boolean) r11.get("data_is_anchor", Boolean.FALSE);
            Object r9 = null;
            if (((Boolean) r11.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L18;
            r.a r5 = r.f;
            RoomContext.a r6 = RoomContext.Companion;
            RoomContext r10 = RoomContext.a.c(r6, r11, 0, 2);
            if (r10 == null) goto L63;
            m r12 = r10.getRoom();
            if (r12 == null) goto L63;
            Room r13 = (Room) r12.getValue();
        L64:
            r5.getClass();
            if (r.a.d(r13) == false) goto L67;
            return true;
        L67:
            if (r0 == null) goto L72;
            if (r0.isMergeVSRoom() != true) goto L72;
            return true;
        L72:
            if (LiveTbArchUtils.INSTANCE.enableOpt(r11) == false) goto L78;
            com.bytedance.android.livesdk.arch.context.a.a r7 = com.bytedance.android.livesdk.arch.context.a.K0;
            RoomContext r8 = RoomContext.a.c(r6, r11, 0, 2);
            r7.getClass();
            com.bytedance.android.livesdk.arch.context.a r14 = com.bytedance.android.livesdk.arch.context.a.a.a(r8, r11);
            if (r14 == null) goto L81;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r15 = r14.getCompactTbLoader();
            if (r15 == null) goto L81;
            s r16 = r15.findContainButtonById(20);
        L82:
            if (r0 == null) goto L98;
            LiveToolbarData r17 = r0.getToolbarData();
            if (r17 == null) goto L98;
            List r18 = r17.getToolbarDataList();
            if (r18 == null) goto L98;
            Iterator r19 = r18.iterator();
        L89:
            if (r19.hasNext() == false) goto L96;
            Object r20 = r19.next();
            if (((IToolbarComponentData) r20).getId() != 20) goto L93;
            boolean r21 = true;
        L94:
            if (r21 == false) goto L89;
        L97:
            IToolbarComponentData r22 = (IToolbarComponentData) r20;
        L99:
            if (r0 == null) goto L115;
            LiveToolbarData r1 = r0.getToolbarData();
            if (r1 == null) goto L115;
            List r23 = r1.getMorePanelDataList();
            if (r23 == null) goto L115;
            Iterator r24 = r23.iterator();
        L106:
            if (r24.hasNext() == false) goto L113;
            Object r25 = r24.next();
            if (((ToolbarComponentData) r25).getId() != 20) goto L110;
            boolean r26 = true;
        L111:
            if (r26 == false) goto L106;
            r9 = r25;
            goto L113
        L110:
            r26 = false;
        L113:
            r9 = (ToolbarComponentData) r9;
        L115:
            if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L119;
            if (r16 != null) goto L119;
            return true;
        L119:
            if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L123;
            if (r22 != null) goto L123;
            if (r9 != null) goto L123;
            return true;
        L123:
            return false;
        L93:
            r21 = false;
            goto L94
        L96:
            r20 = null;
        L98:
            r22 = null;
        L81:
            r16 = null;
            goto L82
        L78:
            BottomToolbarViewModel.Companion.getClass();
            BottomToolbarViewModel r110 = BottomToolbarViewModel.a.a(r11);
            if (r110 == null) goto L81;
            r16 = r110.findContainButtonById(20);
        L63:
            r13 = null;
            goto L64
        L18:
            if (LiveTbArchUtils.INSTANCE.enableOpt(r11) == false) goto L28;
            IToolbarService r27 = k.f(IToolbarService.class);
            if (r27 == null) goto L33;
            com.bytedance.android.livesdk.arch.context.a r111 = r27.getTbContext(RoomContext.a.c(RoomContext.Companion, r11, 0, 2), r11);
            if (r111 == null) goto L33;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r112 = r111.getCompactTbLoader();
            if (r112 == null) goto L33;
            List<ToolbarButton> r113 = r112.getFoldButtons(r4);
            if (r113 == null) goto L33;
            Boolean r114 = Boolean.valueOf(r113.contains(ToolbarButton.SHARE));
        L34:
            if (r0 == null) goto L50;
            LiveToolbarData r28 = r0.getToolbarData();
            if (r28 == null) goto L50;
            List r29 = r28.getMorePanelDataList();
            if (r29 == null) goto L50;
            Iterator r30 = r29.iterator();
        L41:
            if (r30.hasNext() == false) goto L48;
            Object r31 = r30.next();
            if (((ToolbarComponentData) r31).getId() != 20) goto L45;
            boolean r32 = true;
        L46:
            if (r32 == false) goto L41;
            r9 = r31;
            goto L48
        L45:
            r32 = false;
        L48:
            r9 = (ToolbarComponentData) r9;
        L50:
            if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L55;
            if ((!Intrinsics.areEqual(r114, Boolean.TRUE)) == false) goto L55;
            return true;
        L55:
            if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L123;
            if (r9 != null) goto L123;
            return true;
        L33:
            r114 = null;
            goto L34
        L28:
            BottomToolbarViewModel.Companion.getClass();
            BottomToolbarViewModel r115 = BottomToolbarViewModel.a.a(r11);
            if (r115 == null) goto L33;
            List<ToolbarButton> r116 = r115.getFoldButtons(r4);
            if (r116 == null) goto L33;
            r114 = Boolean.valueOf(r116.contains(ToolbarButton.SHARE));
            goto L34
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        Iterator<ToolbarButton> r1 = this.h.iterator();
    L4:
        if (r1.hasNext() == false) goto L84;
        ToolbarButton r2 = r1.next();
        ILivePlayerExtraRenderController r4 = null;
        boolean r5 = true;
        if (r2 != ToolbarButton.AUDIENCE_RESOLUTION) goto L15;
        ILivePlayerClient r3 = LivePlatformPlayerManager.f();
        if (r3 == null) goto L10;
        r4 = r3.extraRenderController();
    L10:
        if (r4 != null) goto L12;
    L14:
        boolean r6 = AudienceVideoResolutionManager.x();
    L23:
        r5 = true ^ r6;
    L82:
        if (r5 == true) goto L4;
        r0.add(r2);
        goto L4
    L12:
        if (r4.isUgcRoom() != true) goto L14;
    L15:
        ToolbarButton r7 = ToolbarButton.PLAY_SETTING;
        if (r2 != r7) goto L21;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.a), PaidSceneEnum.PAID_ROOM, 2) == false) goto L82;
    L21:
        if (r2 != ToolbarButton.TASK_CENTER) goto L25;
        r6 = TTLiveSDKContext.getHostService().h().isLogin();
        goto L23
    L25:
        if (r2 != ToolbarButton.REN_QI_BAO) goto L28;
        r5 = ((Boolean) this.a.get("data_ren_qi_bao_button_dismiss", Boolean.FALSE)).booleanValue();
        goto L82
    L28:
        if (r2 == ToolbarButton.SHARE) goto L30;
        ToolbarButton r8 = ToolbarButton.RECORD;
        if (r2 != r8) goto L54;
    L55:
        ILivePlayerClient r9 = LivePlatformPlayerManager.f();
        if (r9 == null) goto L58;
        r4 = r9.extraRenderController();
    L58:
        if (r4 != null) goto L60;
    L62:
        if (r2 != r8) goto L70;
        DataCenter r10 = this.a;
        if (r10 == null) goto L70;
        if (z.e(r10, false) == true) goto L70;
        LiveRoomPermission.D.getClass();
        if (LiveRoomPermission.Companion.c() == false) goto L82;
    L70:
        if (r2 != r7) goto L75;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.a(this.a) == true) goto L82;
    L75:
        if (r2 != ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE) goto L81;
        ILiveDouPlusService r11 = k.f(ILiveDouPlusService.class);
        Intrinsics.checkNotNull(r11);
        if (r11.shouldBlockEcpLiveEntry() == false) goto L81;
        if (((Boolean) this.a.get("is_type_up_cart", Boolean.FALSE)).booleanValue() == true) goto L82;
    L81:
        r5 = false;
        goto L82
    L60:
        if (r4.isUgcRoom() != true) goto L62;
    L54:
        if (r2 != ToolbarButton.RECORD_COMBINE) goto L70;
    L30:
        if (this.d == true) goto L44;
        RoomContext r12 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r12 == null) goto L44;
        m r13 = r12.getRoom();
        if (r13 == null) goto L44;
        Room r14 = (Room) r13.getValue();
        if (r14 == null) goto L44;
        r.f.getClass();
        if (r.a.d(r14) == true) goto L82;
        if (r14.isMergeVSRoom() == true) goto L82;
    L44:
        if (Intrinsics.areEqual((Boolean) h21.a.getValue(), Boolean.FALSE) == true) goto L81;
        if (o.b() == true) goto L82;
        if (a.a(this.a) == false) goto L81;
    L84:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        this.h = new ArrayList();
        l.d().f().e(this.a, this.h);
        l.d().f().f();
        if (this.h.contains(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE) == false) goto L6;
        this.a.put("data_dou_plus_share_entry_enable", Boolean.FALSE);
    L6:
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L11;
        ArrayList<ToolbarButton> r0 = this.h;
        ToolbarButton r1 = ToolbarButton.SHARE;
        if (r0.contains(r1) == true) goto L12;
        this.h.add(r1);
        return;
    L12:
        return;
    }

    public ConfigCompatFixLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new ArrayList();
    }
}
