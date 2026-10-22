package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.c2;
import com.bytedance.android.livesdk.config.l40;
import com.bytedance.android.livesdk.config.z90;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AnchorConfigCompatFixLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorConfigCompatFixLoader extends AbsDynamicLoader {
    public final ArrayList<ToolbarButton> h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList(this.h);
        if (this.c == true) goto L5;
    L34:
        Iterator r2 = r1.iterator();
    L36:
        if (r2.hasNext() == false) goto L92;
        ToolbarButton r3 = (ToolbarButton) r2.next();
        if (r3 != ToolbarButton.COMMENT) goto L43;
        if (z.h(this.a) == true) goto L43;
        boolean r5 = ((Boolean) this.a.get("data_room_audio_comment_anchor_show", Boolean.FALSE)).booleanValue();
    L73:
        boolean r6 = !r5;
    L90:
        if (r6 == true) goto L36;
        r0.add(r3);
    L43:
        if (r3 != ToolbarButton.AUDIO_COMMENT) goto L46;
        r5 = ((Boolean) this.a.get("data_room_audio_comment_anchor_show", Boolean.FALSE)).booleanValue();
        goto L73
    L46:
        if (r3 != ToolbarButton.AUDIENCE_RESOLUTION) goto L49;
        r5 = AudienceVideoResolutionManager.x();
        goto L73
    L49:
        if (r3 != ToolbarButton.PLAY_SETTING) goto L54;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.a), PaidSceneEnum.PAID_ROOM, 2) == true) goto L54;
    L88:
        r6 = true;
    L54:
        if (r3 != ToolbarButton.VOICE_LIVE_THEME) goto L71;
        RoomContext.a r7 = RoomContext.Companion;
        DataCenter r8 = this.a;
        r7.getClass();
        RoomContext r9 = RoomContext.a.a(r8, 0);
        com.bytedance.android.live.liveinteract.revenue.fight.b r10 = k.n(IInteractService.class).teamFightService();
        if (r10 != null) goto L58;
    L60:
        if (r9 != null) goto L62;
    L89:
        r6 = false;
        goto L90
    L62:
        if (r9.getVoiceTalkRoomSubScene().getValue() == null) goto L89;
        Object r11 = r9.getVoiceTalkRoomSubScene().getValue();
        Intrinsics.checkNotNull(r11);
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r11).t().a == 10) goto L88;
        Object r12 = r9.getVoiceTalkRoomSubScene().getValue();
        Intrinsics.checkNotNull(r12);
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r12).t().a != 9) goto L89;
        if (l40.a.getValue().isAnchorEnable() == true) goto L89;
    L58:
        if (r10.isTeamFightShowing() != true) goto L60;
    L71:
        if (r3 != ToolbarButton.TASK_CENTER) goto L75;
        r5 = TTLiveSDKContext.getHostService().h().isLogin();
        goto L73
    L75:
        if (r3 != ToolbarButton.REN_QI_BAO) goto L78;
        r6 = ((Boolean) this.a.get("data_ren_qi_bao_button_dismiss", Boolean.FALSE)).booleanValue();
        goto L90
    L78:
        if (r3 != ToolbarButton.RECORD) goto L83;
        if (this.c == true) goto L88;
    L83:
        if (r3 == ToolbarButton.FNA_GROUP) goto L87;
        if (r3 != ToolbarButton.FAN_GROUP_MANAGE) goto L89;
    L87:
        if (this.c == false) goto L89;
    L92:
        return r0;
    L5:
        if (z90.a.getValue().booleanValue() == false) goto L34;
        if (tb1.c.a == false) goto L34;
        ToolbarButton r4 = ToolbarButton.REN_QI_BAO;
        if (r1.contains(r4) == true) goto L11;
    L16:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r1.iterator();
    L18:
        if (r14.hasNext() == false) goto L27;
        ToolbarButton r15 = (ToolbarButton) r14.next();
        if (r15 == ToolbarButton.ROOM_INTRO) goto L25;
        if (r15 == ToolbarButton.HASH_TAG) goto L25;
        if (r15 != ToolbarButton.LIVE_CONTENT) goto L18;
    L25:
        r13.add(r15);
        goto L18
    L27:
        if (r13.size() > 1) goto L29;
    L31:
        ToolbarButton r16 = ToolbarButton.BROADCAST_ADMIN;
        if (r1.contains(r16) == false) goto L34;
        y3.f(this.a).p(r16.extended(), new c2());
        goto L34
    L29:
        if (r1.contains(ToolbarButton.BROADCAST_INFO) == true) goto L31;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a(this, r1, r13)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        goto L31
    L11:
        if (((Boolean) this.a.get("data_ren_qi_bao_button_dismiss", Boolean.FALSE)).booleanValue() == false) goto L16;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L14
        Result.constructor-impl(Boolean.valueOf(r1.remove(r4)));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        ArrayList<ToolbarButton> r0 = this.h;
        l.d().getClass();
        r0.addAll(((v) com.bytedance.android.livesdk.service.k.b(v.class)).a(this.a));
    }

    public AnchorConfigCompatFixLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new ArrayList();
    }
}
