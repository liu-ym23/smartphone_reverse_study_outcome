package com.bytedance.android.live.platformplayer.room;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.platformplayer.extrarender.PlayerExtraRenderObserver;
import com.bytedance.android.live.platformplayer.panel.StreamAutoAdapterService;
import com.bytedance.android.live.platformplayer.utils.c;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import is2.d;
import is2.g;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ls2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements g {
    public final Lazy a;
    public final d b;
    public final RoomBaseSession c;

    public final String businessTypeV2() {
        return "RoomPlayerObserver";
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    public final String getSpm() {
        return null;
    }

    public final boolean isIgnored() {
        return false;
    }

    public final void onOrientationChangeV2(int r1) {
    }

    public final void onRoomBackgroundV2() {
    }

    public final void onRoomPrepareV2(boolean r1) {
    }

    public b(d r2, RoomSession r3) {
        Intrinsics.checkNotNullParameter(r2, "roomEngine");
        Intrinsics.checkNotNullParameter(r3, "roomSession");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new RoomPlayerObserver$extraRenderObserver$2(this));
    }

    public final void onRoomEnterV2(Room r9, ls2.a r10) {
        Intrinsics.checkNotNullParameter(r9, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r10, "enterExtra");
        RoomBaseSession r11 = this.c;
        boolean r1 = false;
        if (r11.isStopPlayerForNextRoomPrePullStream() == true) goto L8;
        this.b.startPullStreamV2("room_enter", false);
        ILivePlayerClient r0 = c.b(r11);
        if (r0 == null) goto L8;
        r0.unmute("RoomPlayerObserver.onRoomEnterV2");
    L8:
        if (((PlayerConfig) LivePlatformPlayerManager.f.getValue()).getFixResolutionInit() == false) goto L12;
        IResolutionService r2 = k.f(IResolutionService.class);
        if (r2 == null) goto L12;
        r2.initRoomResolutionSetting(r11.getDataCenter());
    L12:
        IResolutionService r3 = k.f(IResolutionService.class);
        if (r3 == null) goto L15;
        r3.onRoomEnter(r11.getContext(), r11.getLifecycleOwner(), r11.getRoomId(), r11.getDataCenter());
    L15:
        if (r9 != null) goto L17;
    L24:
        if (r1 == false) goto L26;
        ((PlayerExtraRenderObserver) this.a.getValue()).b();
    L26:
        ILivePlayerClient r12 = c.b(r11);
        ViewGroup r4 = null;
        if (r12 == null) goto L33;
        IRenderView r13 = r12.getRenderView();
        if (r13 == null) goto L33;
        View r14 = r13.getSelfView();
        if (r14 == null) goto L33;
        ViewGroup r15 = UtilityKotlinExtentionsKt.p(r14);
    L35:
        if ((r15 instanceof LivePlayerView) == false) goto L38;
        r4 = r15;
    L38:
        LivePlayerView r5 = (LivePlayerView) r4;
        com.bytedance.android.live.platformplayer.service.a r16 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r16 == null) goto L42;
        r16.Z2();
        StreamAutoAdapterService.o.i(r11.getDataCenter(), r5);
        return;
    L42:
        return;
    L33:
        r15 = null;
        goto L35
    L17:
        if (r9.isCompoundScene() == true) goto L19;
    L21:
        boolean r17 = false;
    L22:
        if (r17 != true) goto L24;
        r1 = true;
        goto L24
    L19:
        if (r9.getCompoundSceneType() != 2) goto L21;
        r17 = true;
        goto L22
    }

    public final void onRoomPreloadV2(Room r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L6;
        if (r3 == true) goto L6;
        return;
    L6:
        ILivePlayerClient r4 = c.b(this.c);
        if (r4 == null) goto L10;
        r4.unmute("RoomPlayerObserver.onRoomPreloadV2");
        return;
    }

    public final void onRoomExitV2(long r1, String r3, boolean r4, Room r5, e r6, boolean r7, EndReason r8) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r8, "reason");
        if (r7 == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.platformplayer.service.a r9 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r9 == null) goto L8;
        r9.Z2();
        StreamAutoAdapterService.o.j(r1, this.c.getDataCenter());
    L8:
        IResolutionService r10 = k.f(IResolutionService.class);
        if (r10 == null) goto L11;
        r10.clearAutoModeFlag();
    L11:
        boolean r11 = false;
        if (r5 != null) goto L14;
    L21:
        if (r11 == false) goto L23;
        ((PlayerExtraRenderObserver) this.a.getValue()).c();
    L23:
        IResolutionService r12 = k.f(IResolutionService.class);
        if (r12 == null) goto L27;
        r12.onRoomExit(r1);
        return;
    L27:
        return;
    L14:
        if (r5.isCompoundScene() == true) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r13 != true) goto L21;
        r11 = true;
        goto L21
    L16:
        if (r5.getCompoundSceneType() != 2) goto L18;
        r13 = true;
        goto L19
    }
}
