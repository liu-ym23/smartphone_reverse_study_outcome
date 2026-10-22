package com.bytedance.android.live.openplatform.impl.minigameanchor.launch;

import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.LiveMgXplayRtcContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.jsb.MiniGameCommonJsbContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener;
import com.bytedance.android.live.openplatform.impl.minigamecommon.launch.LaunchMgContextService;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xs2.b;
import yq0.e;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/launch/AnchorLaunchMgContextService;", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/launch/LaunchMgContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLaunchMgContextService extends LaunchMgContextService {
    public final a a;

    public static final class a implements OnMiniGameLifecycleChangeListener {
        public final /* synthetic */ OpenPlatformContext a;

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void a() {
            ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
            if (r0 == null) goto L6;
            r0.setMiniAppActivityStatue(true);
            return;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void b() {
            ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
            if (r0 == null) goto L6;
            r0.setMiniAppActivityStatue(false);
            return;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void c() {
            ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getMiniAppActivityState() != true) goto L28;
            Room r1 = this.a.getRoom();
            if (r1 == null) goto L9;
            LiveMode r2 = r1.getStreamType();
        L11:
            if (r2 != LiveMode.VIDEO) goto L29;
            AnchorMiniGameDataContext.Companion.getClass();
            AnchorMiniGameDataContext r3 = AnchorMiniGameDataContext.a.a();
            if (r3 == null) goto L30;
            m<Boolean> r4 = r3.getOpenLynxPanelInGame();
            if (r4 != null) goto L17;
            return;
        L17:
            if (((Boolean) r4.getValue()).booleanValue() == true) goto L32;
            RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r5 == null) goto L25;
            j r6 = r5.getLiveStream();
            if (r6 == null) goto L25;
            d r7 = (d) r6.getValue();
            if (r7 == null) goto L25;
            r7.J0("mini_game_enter_background", new uv0.a(LiveRequestSourceRole.Business, "AnchorLaunchMgContextService.onMiniGameStop", null));
        L25:
            b.a().post(new h1(79));
            return;
        L32:
            return;
        L30:
            return;
        L29:
            return;
        L9:
            r2 = null;
            goto L11
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void d() {
            ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
            if (r0 == null) goto L5;
            r0.setMiniAppActivityStatue(false);
        L5:
            ((MiniGameCommonJsbContextService) this.a.getService(MiniGameCommonJsbContextService.class)).f();
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void e() {
            ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getMiniAppActivityState() != true) goto L28;
            Room r1 = this.a.getRoom();
            if (r1 == null) goto L9;
            LiveMode r2 = r1.getStreamType();
        L11:
            if (r2 != LiveMode.VIDEO) goto L29;
            AnchorMiniGameDataContext.Companion.getClass();
            AnchorMiniGameDataContext r3 = AnchorMiniGameDataContext.a.a();
            if (r3 == null) goto L30;
            m<Boolean> r4 = r3.getOpenLynxPanelInGame();
            if (r4 != null) goto L17;
            return;
        L17:
            if (((Boolean) r4.getValue()).booleanValue() == true) goto L32;
            RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r5 == null) goto L25;
            j r6 = r5.getLiveStream();
            if (r6 == null) goto L25;
            d r7 = (d) r6.getValue();
            if (r7 == null) goto L25;
            r7.q1("mini_game_enter_foreground", new uv0.a(LiveRequestSourceRole.Business, "AnchorLaunchMgContextService.onMiniGameResume", null));
        L25:
            b.a().post(new h1(80));
            return;
        L32:
            return;
        L30:
            return;
        L29:
            return;
        L9:
            r2 = null;
            goto L11
        }

        public a(OpenPlatformContext r1) {
            this.a = r1;
        }
    }

    public AnchorLaunchMgContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new a(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.launch.LaunchMgContextService
    public final Map<String, String> f(HashMap<String, String> r4) {
        Map<String, String> r5 = super.f(r4);
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        Boolean r1 = null;
        if (r0 == null) goto L9;
        n<c0> r2 = r0.getMicroGameInfo();
        if (r2 == null) goto L9;
        c0 r3 = (c0) r2.getValue();
        if (r3 == null) goto L9;
        String r6 = r3.taskId;
    L10:
        if (r6 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L25;
        AnchorMiniGameDataContext r8 = AnchorMiniGameDataContext.a.a();
        if (r8 == null) goto L24;
        n<OpenPlatformMgInfoModel> r9 = r8.getOpenPlatformMg();
        if (r9 == null) goto L24;
        OpenPlatformMgInfoModel r10 = (OpenPlatformMgInfoModel) r9.getValue();
        if (r10 == null) goto L24;
        r6 = r10.getTaskId();
    L24:
        r6 = null;
    L25:
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        r5.put("task_id", r6);
        AnchorMiniGameDataContext r11 = AnchorMiniGameDataContext.a.a();
        if (r11 == null) goto L33;
        m<Boolean> r12 = r11.getOpenCamera();
        if (r12 == null) goto L33;
        r1 = (Boolean) r12.getValue();
    L33:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L35;
        String r13 = "1";
    L36:
        r5.put("open_camera", r13);
        return r5;
    L35:
        r13 = "0";
        goto L36
    L12:
        if (r6.length() == 0) goto L15;
        r7 = false;
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.launch.LaunchMgContextService
    public final Map<String, String> g(String r6) {
        Intrinsics.checkNotNullParameter(r6, "openSchema");
        boolean r7 = zq0.b.a();
        Pair[] r0 = new Pair[3];
        e.a r1 = ((LiveMgXplayRtcContextService) getOpenPlatformContext().getService(LiveMgXplayRtcContextService.class)).a;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.a();
        if (r3 == null) goto L6;
    L7:
        r0[0] = TuplesKt.to("forward_info", r3);
        Room r4 = getOpenPlatformContext().getRoom();
        if (r4 == null) goto L13;
        String r5 = String.valueOf(r4.getRoomId());
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        r0[1] = TuplesKt.to("live_room_id", r2);
        if (r7 == false) goto L16;
        String r8 = "1";
    L17:
        r0[2] = TuplesKt.to("is_multilink", r8);
        return MapsKt.mutableMapOf(r0);
    L16:
        r8 = "0";
    L6:
        r3 = "";
        goto L7
    }

    public final void j(String r4, Function1<? super String, Unit> r5) {
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        if (StringsKt.isBlank(r4) == false) goto L7;
        String r0 = r4;
    L8:
        if (r0 == null) goto L24;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r1 = AnchorMiniGameDataContext.a.a();
        if (r1 == null) goto L24;
        n<OpenPlatformMgInfoModel> r2 = r1.getOpenPlatformMg();
        if (r2 == null) goto L24;
        OpenPlatformMgInfoModel r3 = (OpenPlatformMgInfoModel) r2.getValue();
        if (r3 == null) goto L24;
        String r6 = r3.getAppId();
        if (r6 == null) goto L24;
        if ((!StringsKt.isBlank(r6)) == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L24;
        r4 = "sslocal://" + SchemaInfo.Host.MICROGAME + "?app_id=" + r6;
    L24:
        if (TextUtils.isEmpty(r4) == false) goto L28;
        if (r5 == null) goto L42;
        Unit r7 = (Unit) r5.invoke("fail");
        return;
    L42:
        return;
    L28:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r8 = AnchorMiniGameDataContext.a.a();
        if (r8 == null) goto L33;
        n<c0> r9 = r8.getMicroGameInfo();
        if (r9 == null) goto L33;
        c0 r10 = (c0) r9.getValue();
    L34:
        if (r10 != null) goto L36;
        i(r4, h(MountedMiniGameSource.GameLiveBtn, r4, null), r5);
        AnchorMiniGameAppLogContextService r11 = (AnchorMiniGameAppLogContextService) getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r12 = new HashMap();
        r12.put("launch_from", "live");
        r12.put("scene", LaunchParamConstant$Scene.a);
        r12.put("location", "anchor_game_live_btn");
        Unit r13 = Unit.INSTANCE;
        r11.reportLiveRoomMgAppLog("mp_click", r12);
        return;
    L36:
        OpenPlatformContext r14 = getOpenPlatformContext();
        if (r14 == null) goto L41;
        ((MiniGameContext) r14).unregisterMiniGameLifecycleChangeListener(this.a);
        ((MiniGameContext) getOpenPlatformContext()).registerMiniGameLifecycleChangeListener(this.a);
        i(r4, h(MountedMiniGameSource.InteractPanel, r4, null), r5);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    L33:
        r10 = null;
        goto L34
    L7:
        r0 = null;
        goto L8
    }
}
