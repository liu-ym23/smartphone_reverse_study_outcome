package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.LiveRoomMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l5 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final CompositeDisposable a;
    public final Context b;
    public final DataCenter c;

    public static final class a {
    }

    public static final class b extends SimpleShareCallback {
        public final /* synthetic */ l5 a;

        public b(l5 r1) {
            this.a = r1;
        }

        public final void onSuccess(String r2, String r3) {
            onSuccessWithExtra(r2, r3, null);
        }

        public final void onSuccessWithExtra(String r4, String r5, Map<String, List<String>> r6) {
            String r0 = null;
            Room r7 = (Room) this.a.c.get("data_room", null);
            HashMap r8 = new HashMap();
            if (r7 == null) goto L5;
            String r1 = r7.getOwnerUserIdString();
        L6:
            r8.put("anchor_id", String.valueOf(r1));
            if (r7 == null) goto L9;
            r0 = r7.getIdStr();
        L9:
            r8.put("room_id", String.valueOf(r0));
            r8.put("enter_from", String.valueOf(com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap().get("enter_from_merge")));
            r8.put("enter_method", String.valueOf(com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap().get("enter_method")));
            r8.put("share_platform", String.valueOf(r4));
            com.bytedance.android.livesdk.log.u.l().h("livesdk_share", r8, new Object[]{new am2.x(), Room.class});
            return;
        L5:
            r1 = null;
            goto L6
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

    public final HashMap<String, String> a() {
        String r2 = null;
        Room r0 = (Room) this.c.get("data_room", null);
        HashMap<String, String> r1 = new HashMap();
        if (r0 == null) goto L5;
        String r3 = r0.getOwnerUserIdString();
    L6:
        r1.put("anchor_id", String.valueOf(r3));
        if (r0 == null) goto L9;
        r2 = r0.getIdStr();
    L9:
        r1.put("room_id", String.valueOf(r2));
        r1.put("enter_from_merge", String.valueOf(com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap().get("enter_from_merge")));
        r1.put("enter_method", String.valueOf(com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap().get("enter_method")));
        r1.put("event_page", "live_detail");
        r1.put("request_page", "more");
        if (r0 == null) goto L16;
        User r4 = r0.getOwner();
        if (r4 == null) goto L16;
        if (r4.isFollowing() != true) goto L16;
        String r5 = "1";
    L17:
        r1.put("is_fans", r5);
        r1.put("share_to_story_type", "live_room");
        return r1;
    L16:
        r5 = "0";
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r31) {
        boolean r1 = hd0.c.f().h();
        Boolean r14 = Boolean.FALSE;
        if (r1 == false) goto L6;
        com.bytedance.android.live.core.utils.f2.b(2131922512, 0);
        return;
    L6:
        Room r2 = (Room) this.c.get("data_room");
        Map r3 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (LivePlatformPlayerManager.f() != null) goto L10;
        ALogger.e("ToolbarShareToDailyBehavior", "LivePlatformPlayerManager currentClient is null");
        return;
    L10:
        ILiveShareService r12 = jc1.k.n(ILiveShareService.class);
        ShareParams.Builder r4 = ShareParams.buildUponRoom(r2).setPlatform("share_to_story").setLivePlayerClient(LivePlatformPlayerManager.f()).setShareEnterFrom((String) r3.get("enter_from_merge")).setEnterMethod((String) r3.get("enter_method")).setShareEnterMethod("more");
        if (jc1.k.n(IInteractService.class).getCurrentScene() > 0) goto L15;
        if (r2 != null) goto L14;
    L16:
        Unit r5 = Unit.INSTANCE;
        r12.share(new i81.a(null, ContextUtil.contextToActivity(this.b), null, r4.build(), null, null, null, null, null, null, null, r14, null, null, null, null, false), "ToolbarShareToDailyBehavior", LiveShareType.SHARE_DIRECT, new b(this));
        com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
        HashMap<String, String> r7 = a();
        r7.put("escape_prefix_check", "1");
        r7.put("enter_from", String.valueOf(com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap().get("enter_from_merge")));
        jc1.k.n(ILiveShareService.class).cacheMob(this.b, r7);
        r6.sendLog("click_share_to_diary", r7, new Object[]{new am2.x(), Room.class});
        return;
    L14:
        if (r2.getLiveRoomMode() != LiveRoomMode.Audio.getValue()) goto L16;
    L15:
        r4.setEnableScreenShot(false);
        goto L16
    }

    public l5(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share_to_diary_show", a(), new Object[]{new am2.x(), Room.class});
        com.bytedance.android.livesdk.log.g r8 = com.bytedance.android.livesdk.log.u.l();
        HashMap<String, String> r9 = a();
        r9.put("escape_prefix_check", "1");
        Unit r1 = Unit.INSTANCE;
        r8.sendLog("show_share_to_diary", r9, new Object[]{new am2.x(), Room.class});
    }
}
