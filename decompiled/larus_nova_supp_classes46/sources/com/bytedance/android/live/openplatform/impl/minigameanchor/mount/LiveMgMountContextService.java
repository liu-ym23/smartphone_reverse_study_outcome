package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.broadcastgame.api.model.f0;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgToolbarContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.jsb.MiniGameCommonJsbContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.launch.AnchorLaunchMgContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.config.m51;
import com.bytedance.android.livesdk.config.r50;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/mount/LiveMgMountContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMgMountContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int h = 0;
    public String a;
    public String b;
    public boolean c;
    public long d;
    public boolean e;
    public c0 f;
    public HybridDialog g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveMgMountContextService a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ c0 c;

        public b(LiveMgMountContextService r1, Context r2, c0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r19) {
            Response r2 = (Response) r19;
            HybridDialog r0 = this.a.g;
            if (r0 != null) goto L58;
        L10:
            int r1 = ((yq0.a) r2.data).a();
            if (r1 != 4) goto L30;
            Double r6 = null;
            qo0.a.b("LiveMgMountContextService", "直播门槛校验通过", null);
            final LiveMgMountContextService r3 = this.a;
            Context r4 = this.b;
            final c0 r7 = this.c;
            r3.getClass();
            if (Intrinsics.areEqual(r7.hasTask, Boolean.FALSE) == false) goto L15;
            Function0<Unit> r8 = new LiveMgMountContextService$handleMount$1(r3, r7);
            LiveMgMountContextService$handleMount$2 r5 = LiveMgMountContextService$handleMount$2.INSTANCE;
            x0.b r9 = new x0.b(r4, 4);
            x0.d r10 = r9.a;
            r10.k = false;
            r10.l = false;
            r9.a.d = s1.B(2131923035);
            r9.i(0, 2131923036, new k(r8));
            r9.i(1, 2131920982, new l(r5));
            r9.n();
            return;
        L15:
            Boolean r11 = r7.hasTask;
            Boolean r12 = Boolean.TRUE;
            if (Intrinsics.areEqual(r11, r12) == true) goto L18;
        L28:
            LiveMgMountContextService.h(r3, r7.taskId, r7.gameId);
            return;
        L18:
            if (Intrinsics.areEqual(r7.taskChange, r12) == false) goto L28;
            Function0<Unit> r13 = new LiveMgMountContextService$handleMount$3(r3, r7);
            LiveMgMountContextService$handleMount$4 r14 = LiveMgMountContextService$handleMount$4.INSTANCE;
            View r15 = LayoutInflater.from(r4).inflate(2131567572, null, false);
            StringBuilder r16 = new StringBuilder();
            Integer r17 = r7.taskPrice;
            if (r17 == null) goto L22;
            r6 = Double.valueOf(((double) r17.intValue()) / 100.0d);
        L22:
            r16.append(r6);
            r16.append(20803);
            String r18 = r16.toString();
            Integer r110 = r7.cpsRatio;
            if (r110 == null) goto L27;
            int r111 = r110.intValue();
            if (r111 <= 0) goto L27;
            r18 = r18 + '+' + r111 + '%';
        L27:
            ((TextView) r15.findViewById(2131383012)).setText(s1.C(2131923038, new Object[]{r18}));
            ((TextView) r15.findViewById(2131386024)).setText(s1.C(2131923039, new Object[]{r7.bidMetaTag}));
            x0.b r20 = new x0.b(r4, 4);
            x0.d r21 = r20.a;
            r21.k = false;
            r21.l = false;
            r21.f = r15;
            r20.i(0, 2131923036, new t(r13));
            r20.i(1, 2131920982, new u(r14));
            ((TextView) r15.findViewById(2131381506)).setOnClickListener(new s(r3, r7, r20.n()));
            return;
        L30:
            if (r1 != 16) goto L32;
        L47:
            DataCenter r22 = this.a.getOpenPlatformContext().getDataCenter();
            if (r22 == null) goto L50;
            r22.put("cmd_live_toolbarmore_dialog_dismiss", 0);
        L50:
            LiveMgMountContextService r23 = this.a;
            c0 r24 = this.c;
            r23.getClass();
            String r25 = ((m51) r50.a.getValue()).d();
            if (r25 != null) goto L53;
            r25 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-normal-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fmicro_game%2Fdetail%2Fwebcast%2Fmicro_game_detail_webcast%2Fpages%2Fthreshold%2Ftemplate.js&use_xbridge3=1&use_bullet_container=1&disable_swipe=0&enable_prefetch=1&width_percent=100&height_percent=100&gravity=bottom&containerKey=annie_x_live&engine_type=new&mix_container_type=annie&type=popup&pad_adapter=width_percent&rate_height=100&pad_use_phone_size=1";
        L53:
            u6 r26 = new u6(r25);
            String r27 = GsonProtectorUtils.toJson(GsonHelper.get(), r24);
            if (r27 != null) goto L56;
            r27 = "";
        L56:
            r26.b("micro_game_info", r27);
            IBaseBrowserService.b.a(jc1.k.n(IBrowserService.class), r23.getOpenPlatformContext().getContext(), r26.c());
            return;
        L32:
            if (21 > r1) goto L38;
            if (30 >= r1) goto L47;
        L38:
            if (r1 != 14) goto L41;
            LiveMgMountContextService.f(this.a, true, ((yq0.a) r2.data).c(), new LiveMgMountContextService$checkEnableStarLive$1$1(this));
            return;
        L41:
            if (r1 != 15) goto L43;
            LiveMgMountContextService.f(this.a, false, ((yq0.a) r2.data).c(), new LiveMgMountContextService$checkEnableStarLive$1$2(this));
            return;
        L43:
            String r28 = ((yq0.a) r2.data).b();
            if (r28 != null) goto L46;
            r28 = s1.B(2131921004);
        L46:
            f2.c(r28, 0);
            return;
        L58:
            r0.dismiss();     // Catch: Exception -> L6
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r29 = DialogFragmentLancet.sLastShowStack;
            if (r29 == null) goto L10;
            com.bytedance.crash.d.d(r29, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveMgMountContextService a;

        public c(LiveMgMountContextService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            qo0.a.b("LiveMgMountContextService", "request checkLiveThreshold fail", r4);
            HybridDialog r0 = this.a.g;
            if (r0 != null) goto L15;
        L10:
            String r5 = r4.getMessage();
            if (r5 != null) goto L13;
            r5 = s1.B(2131921004);
        L13:
            f2.c(r5, 0);
            return;
        L15:
            r0.dismiss();     // Catch: Exception -> L6
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r1 = DialogFragmentLancet.sLastShowStack;
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(((Response) r2).data);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Function1 r0 = this.a;
            String r1 = r5.getMessage();
            if (r1 != null) goto L5;
            r1 = "request start config fail";
        L5:
            r0.invoke(r1);
            qo0.a.b("LiveMgMountContextService", "request start config fail", r5);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LiveMgMountContextService a;
        public final /* synthetic */ Function1 b;

        public f(LiveMgMountContextService r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Response r3 = (Response) r2;
            Function1 r4 = this.b;
            if (r4 == null) goto L5;
            Unit r5 = (Unit) r4.invoke(Boolean.TRUE);
        L5:
            LiveMgMountContextService r6 = this.a;
            r6.c = false;
            r6.i();
            LiveMgMountContextService r7 = this.a;
            r7.a = "";
            r7.b = "";
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public g(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Function1 r0 = this.a;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(Boolean.FALSE);
        L5:
            f2.b(2131921004, 0);
            qo0.a.b("LiveMgMountContextService", "request game/stop fail", r4);
        }
    }

    static {
    }

    public final void i() {
        HybridDialog r0 = this.g;
        if (r0 != null) goto L47;
    L10:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r1 = AnchorMiniGameDataContext.a.a();
        if (r1 == null) goto L17;
        com.bytedance.live.datacontext.n<c0> r2 = r1.getMicroGameInfo();
        if (r2 == null) goto L17;
        c0 r3 = (c0) r2.getValue();
        if (r3 == null) goto L17;
        String r4 = r3.a;
    L18:
        AnchorMiniGameDataContext r5 = AnchorMiniGameDataContext.a.a();
        if (r5 == null) goto L23;
        com.bytedance.live.datacontext.n<c0> r6 = r5.getMicroGameInfo();
        if (r6 == null) goto L23;
        r6.setValue(null);
    L23:
        AnchorMiniGameDataContext r7 = AnchorMiniGameDataContext.a.a();
        if (r7 == null) goto L28;
        com.bytedance.live.datacontext.n<OpenPlatformMgInfoModel> r8 = r7.getOpenPlatformMg();
        if (r8 == null) goto L28;
        r8.setValue(null);
    L28:
        ((MiniGameCommonJsbContextService) getOpenPlatformContext().getService(MiniGameCommonJsbContextService.class)).f();
        LiveMgCastContextService r9 = (LiveMgCastContextService) getOpenPlatformContext().getService(LiveMgCastContextService.class);
        r9.q(this.b, "unmount game");
        r9.g();
        ((LiveMgToolbarContextService) getOpenPlatformContext().getService(LiveMgToolbarContextService.class)).f(false);
        OpenPlatformContext r10 = getOpenPlatformContext();
        if (r10 == null) goto L46;
        ((MiniGameContext) r10).setMiniGameInstance(null);
        xs2.b r11 = xs2.b.a();
        AnchorMiniGameDataContext r12 = AnchorMiniGameDataContext.a.a();
        if (r12 == null) goto L36;
        com.bytedance.live.datacontext.m<String> r13 = r12.getOpenFeatureBinderId();
        if (r13 == null) goto L36;
        String r14 = (String) r13.getValue();
        if (r14 == null) goto L36;
    L37:
        r11.post(new f0(r14, ReloadPanelType.FROM_CAHCE, false, false, 4));
        if (TextUtils.isEmpty(r4) == true) goto L49;
        AnchorMiniGameAppLogContextService.reportLiveRoomMgAppLog$default((AnchorMiniGameAppLogContextService) getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class), "livesdk_live_game_end", null, 2, null);
        AnchorMiniGameAppLogContextService r15 = (AnchorMiniGameAppLogContextService) getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r16 = new HashMap();
        long r17 = System.currentTimeMillis() - this.d;
        if (r17 > 0) goto L43;
        r17 = 0;
    L43:
        r16.put("duration", String.valueOf(r17));
        Unit r18 = Unit.INSTANCE;
        r15.reportLiveRoomMgAppLog("livesdk_game_duration", r16);
        return;
    L49:
        return;
    L36:
        r14 = "";
        goto L37
    L46:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    L17:
        r4 = null;
        goto L18
    L47:
        r0.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L10;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final void l() {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<c0> r1 = r0.getMicroGameInfo();
        if (r1 == null) goto L9;
        c0 r2 = (c0) r1.getValue();
        if (r2 == null) goto L9;
        String r3 = r2.schema;
    L10:
        if (r3 != null) goto L12;
        r3 = "sslocal://" + SchemaInfo.Host.MICROGAME + "?app_id=" + this.b;
    L12:
        SchemaInfo.a r4 = new SchemaInfo.a(r3);
        r4.f(SchemaInfo.LaunchMode.HOST_STACK);
        AnchorLaunchMgContextService r5 = (AnchorLaunchMgContextService) getOpenPlatformContext().getService(AnchorLaunchMgContextService.class);
        SchemaInfo r6 = r4.c();
        if (r6 == null) goto L16;
        String r7 = r6.h();
        if (r7 == null) goto L16;
    L17:
        r5.j(r7, new LiveMgMountContextService$openMountedGame$1(this));
        return;
    L16:
        r7 = "";
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        n(null);
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.g(getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.LittleGame.INSTANCE);
    }

    public LiveMgMountContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = "";
        this.b = "";
    }

    public final void j(boolean r13) {
        this.c = r13;
        DataCenter r0 = getOpenPlatformContext().getDataCenter();
        if (r0 == null) goto L5;
        r0.put("cmd_update_live_game_candy_toolbar_status", Boolean.valueOf(r13));
    L5:
        if (r13 == false) goto L116;
        HybridDialog r14 = this.g;
        if (r14 != null) goto L119;
    L14:
        c0 r15 = this.f;
        c0 r1 = null;
        if (r15 == null) goto L27;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r2 = AnchorMiniGameDataContext.a.a();
        if (r2 == null) goto L21;
        com.bytedance.live.datacontext.n<c0> r3 = r2.getMicroGameInfo();
        if (r3 == null) goto L21;
        r3.setValue(this.f);
    L21:
        OpenPlatformMgInfoModel r4 = new OpenPlatformMgInfoModel();
        r4.setAppId(r15.gameId);
        r4.setAppName(r15.gameName);
        r4.setAppIcon(r15.gameIcon);
        r4.setGameType(r15.gameType);
        r4.setTaskId(r15.taskId);
        AnchorMiniGameDataContext r16 = AnchorMiniGameDataContext.a.a();
        if (r16 == null) goto L26;
        com.bytedance.live.datacontext.n<OpenPlatformMgInfoModel> r17 = r16.getOpenPlatformMg();
        if (r17 == null) goto L26;
        r17.setValue(r4);
    L26:
        l();
        AnchorMiniGameAppLogContextService.reportLiveRoomMgAppLog$default((AnchorMiniGameAppLogContextService) getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class), "livesdk_live_game_start", null, 2, null);
    L27:
        this.f = null;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r18 = AnchorMiniGameDataContext.a.a();
        if (r18 == null) goto L94;
        com.bytedance.live.datacontext.n<OpenPlatformMgInfoModel> r19 = r18.getOpenPlatformMg();
        if (r19 == null) goto L94;
        OpenPlatformMgInfoModel r110 = (OpenPlatformMgInfoModel) r19.getValue();
        if (r110 == null) goto L94;
        InteractGameContext.Companion r5 = InteractGameContext.Companion;
        InteractGameContext r6 = r5.getContext();
        if (r6 == null) goto L39;
        com.bytedance.live.datacontext.m r7 = r6.isPlayingGame();
        if (r7 == null) goto L39;
        r7.setValue(Boolean.TRUE);
    L39:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L94;
        DataCenter r8 = getOpenPlatformContext().getDataCenter();
        if (r8 == null) goto L43;
        LiveMode r9 = (LiveMode) r8.get("data_live_mode", LiveMode.VIDEO);
    L45:
        if (r9 != LiveMode.VIDEO) goto L94;
        String r10 = r110.getAppId();
        String r11 = "";
        if (r10 != null) goto L50;
        r10 = "";
    L50:
        xs2.b.a().post(new f0(r10, null, true, true, 2));
        AnchorMiniGameDataContext r12 = AnchorMiniGameDataContext.a.a();
        if (r12 == null) goto L55;
        com.bytedance.live.datacontext.m<String> r20 = r12.getOpenFeatureBinderId();
        if (r20 == null) goto L55;
        r20.setValue(r10);
    L55:
        AnchorMiniGameDataContext r21 = AnchorMiniGameDataContext.a.a();
        if (r21 == null) goto L60;
        com.bytedance.live.datacontext.n<String> r22 = r21.getFirstMountGameId();
        if (r22 == null) goto L60;
        String r23 = (String) r22.getValue();
    L61:
        if (r23 != null) goto L67;
        AnchorMiniGameDataContext r24 = AnchorMiniGameDataContext.a.a();
        if (r24 == null) goto L67;
        com.bytedance.live.datacontext.n<String> r25 = r24.getFirstMountGameId();
        if (r25 == null) goto L67;
        r25.setValue(r10);
    L67:
        InteractGameContext r26 = r5.getContext();
        if (r26 == null) goto L82;
        com.bytedance.live.datacontext.n r27 = r26.getCurrentOpenPlatformAppInfo();
        if (r27 == null) goto L82;
        String r28 = r110.getAppId();
        if (r28 != null) goto L74;
        r28 = "";
    L74:
        String r29 = r110.getAppName();
        if (r29 != null) goto L77;
        r29 = "";
    L77:
        i0 r30 = new i0(r28, r29, InteractID.OpenMicroGame);
        String r31 = r110.getAppIcon();
        if (r31 == null) goto L81;
        r11 = r31;
    L81:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r30.a = r11;
        Unit r32 = Unit.INSTANCE;
        r27.setValue(r30);
    L82:
        AnchorMiniGameDataContext r33 = AnchorMiniGameDataContext.a.a();
        if (r33 == null) goto L87;
        com.bytedance.live.datacontext.n<c0> r34 = r33.getMicroGameInfo();
        if (r34 == null) goto L87;
        r1 = (c0) r34.getValue();
    L87:
        if (r1 != null) goto L93;
        c0 r35 = new c0(0);
        r35.gameId = r110.getAppId();
        r35.gameName = r110.getAppName();
        r35.gameIcon = r110.getAppIcon();
        r35.gameType = r110.getGameType();
        r35.taskId = r110.getTaskId();
        AnchorMiniGameDataContext r111 = AnchorMiniGameDataContext.a.a();
        if (r111 == null) goto L93;
        com.bytedance.live.datacontext.n<c0> r112 = r111.getMicroGameInfo();
        if (r112 == null) goto L93;
        r112.setValue(r35);
    L93:
        ((LiveMgToolbarContextService) getOpenPlatformContext().getService(LiveMgToolbarContextService.class)).f(true);
    L60:
        r23 = null;
        goto L61
    L43:
        r9 = null;
    L94:
        InteractGameContext r113 = InteractGameContext.Companion.getContext();
        if (r113 == null) goto L99;
        com.bytedance.live.datacontext.m r114 = r113.isPlayingGame();
        if (r114 == null) goto L99;
        r114.setValue(Boolean.TRUE);
    L99:
        LiveMgCastContextService r115 = (LiveMgCastContextService) getOpenPlatformContext().getService(LiveMgCastContextService.class);
        r115.getClass();
        WeakReference r36 = com.bytedance.android.live.core.utils.a.a;
        if (com.bytedance.android.live.core.utils.a.e(r115.getOpenPlatformContext().getContext()) == true) goto L103;
        return;
    L103:
        if (r115.c != null) goto L105;
        r115.c = new com.bytedance.android.live.openplatform.impl.minigameanchor.cast.h(jc1.k.n(IHostApp.class).getTopActivity(), r115.getOpenPlatformContext());
    L105:
        com.bytedance.android.live.openplatform.impl.minigameanchor.cast.h r37 = r115.c;
        if (r37 != null) goto L108;
        return;
    L108:
        if (r37.isShowing() == true) goto L124;
        com.bytedance.android.live.openplatform.impl.minigameanchor.cast.h r116 = r115.c;
        if (r116 != null) goto L112;
        return;
    L112:
        if (DialogLancet.shouldBlockDialogShow(r116) == false) goto L121;
        DialogLancet.handleBlockedDialogShow(r116);
        return;
    L121:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L118
    L115:
        DialogLancet.beforeDialogShow(r116);
        r116.show();
        DialogLancet.afterDialogShow(r116);
        return;
    L124:
        return;
    L119:
        r14.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r117 = DialogFragmentLancet.sLastShowStack;
        if (r117 == null) goto L14;
        com.bytedance.crash.d.d(r117, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L116:
        i();
    }

    public final void n(Function1<? super Boolean, Unit> r8) {
        if (this.c == false) goto L19;
        Lazy r0 = LiveOpenPlatformMgClient.c;
        MiniGameAnchorApi r1 = (MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class);
        String r2 = this.a;
        Room r3 = getOpenPlatformContext().getRoom();
        if (r3 == null) goto L7;
        long r4 = r3.appId;
    L8:
        autoDispose(r1.requestGameStop(r2, r4, getOpenPlatformContext().getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r8), new g(r8)));
        InteractGameContext.Companion r9 = InteractGameContext.Companion;
        InteractGameContext r5 = r9.getContext();
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.n r6 = r5.getCurrentOpenPlatformAppInfo();
        if (r6 == null) goto L13;
        r6.setValue(null);
    L13:
        InteractGameContext r10 = r9.getContext();
        if (r10 == null) goto L20;
        com.bytedance.live.datacontext.m r11 = r10.isPlayingGame();
        if (r11 == null) goto L21;
        r11.setValue(Boolean.FALSE);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r4 = -1;
        goto L8
    }

    public final void g(Context r4, c0 r5) {
        MiniGameAnchorApi r0 = (MiniGameAnchorApi) ((LiveOpenPlatformMgClient) LiveOpenPlatformMgClient.d.getValue()).a(MiniGameAnchorApi.class);
        String r1 = r5.taskId;
        if (r1 != null) goto L5;
        r1 = "0";
    L5:
        autoDispose(r0.checkLiveThreshold(r1, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r4, r5), new c(this)));
    }

    public final void m(Function1<? super yq0.e, Unit> r6, Function1<? super String, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "onSuccess");
        Intrinsics.checkNotNullParameter(r7, "onFail");
        Lazy r0 = LiveOpenPlatformMgClient.c;
        autoDispose(((MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class)).requestStartConfig(this.b, getOpenPlatformContext().getRoomId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r6), new e(r7)));
    }

    public static void h(LiveMgMountContextService r19, String r20, String r21) {
        r19.getClass();
        boolean r2 = false;
        if (r20 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L19;
        if (r21 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        qo0.a.b("LiveMgMountContextService", "request game/start fail taskId and gameId both empty.", null);
        return;
    L13:
        if (StringsKt.isBlank(r21) == true) goto L16;
        r5 = false;
    L19:
        if (r20 != null) goto L21;
    L22:
        r2 = true;
    L23:
        if (r2 == false) goto L25;
    L28:
        long r3 = 2;
    L29:
        long r11 = r3;
        if (r19.f == null) goto L33;
        int r6 = 4;
    L32:
        Integer r17 = r6;
    L41:
        Lazy r7 = LiveOpenPlatformMgClient.c;
        MiniGameAnchorApi r8 = (MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class);
        Room r9 = r19.getOpenPlatformContext().getRoom();
        if (r9 == null) goto L44;
        long r10 = r9.appId;
    L45:
        long r12 = r10;
        long r13 = r19.getOpenPlatformContext().getRoomId();
        long r14 = System.currentTimeMillis();
        if (r20 != null) goto L48;
        String r15 = "";
    L49:
        if (r21 != null) goto L51;
        String r16 = "";
    L52:
        r19.autoDispose(r8.requestGameStart(r12, r13, r11, r14, r15, r16, r17, "").compose(RxUtil.rxSchedulerHelper()).retry(3).subscribe(new com.bytedance.android.live.openplatform.impl.minigameanchor.mount.f(r19, null), new com.bytedance.android.live.openplatform.impl.minigameanchor.mount.g(r19, null)));
        return;
    L51:
        r16 = r21;
        goto L52
    L48:
        r15 = r20;
        goto L49
    L44:
        r10 = -1;
        goto L45
    L33:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r18 = AnchorMiniGameDataContext.a.a();
        if (r18 == null) goto L40;
        com.bytedance.live.datacontext.n<OpenPlatformMgInfoModel> r22 = r18.getOpenPlatformMg();
        if (r22 == null) goto L40;
        OpenPlatformMgInfoModel r23 = (OpenPlatformMgInfoModel) r22.getValue();
        if (r23 == null) goto L40;
        r6 = r23.getEntranceFrom();
    L40:
        r17 = null;
        goto L41
    L25:
        if (Intrinsics.areEqual(r20, "0") == true) goto L28;
        r3 = 1;
        goto L29
    L21:
        if (StringsKt.isBlank(r20) == false) goto L23;
    L5:
        if (StringsKt.isBlank(r20) == true) goto L8;
        r4 = false;
        goto L10
    }

    public static final void f(LiveMgMountContextService r24, boolean r25, List r26, Function0 r27) {
        r24.getClass();
        LiveMgMountContextService$showStarAtlasAgreementDialog$1 r5 = new LiveMgMountContextService$showStarAtlasAgreementDialog$1(r24);
        LiveMgMountContextService$showStarAtlasAgreementDialog$2 r0 = new LiveMgMountContextService$showStarAtlasAgreementDialog$2(r5);
        Activity r1 = jc1.k.n(IHostApp.class).getTopActivity();
        View r2 = LayoutInflater.from(r1).inflate(2131567571, null);
        CheckBox r3 = (CheckBox) r2.findViewById(2131365404);
        TextView r8 = (TextView) r2.findViewById(2131362319);
        String r4 = s1.B(2131923045);
        String r16 = s1.B(2131923044);
        String r17 = s1.B(2131923046);
        String r13 = s1.C(2131923042, new Object[]{r4, r16, r17});
        SpannableString r12 = new SpannableString(r13);
        int r9 = StringsKt.indexOf$default(r13, r4, 0, false, 6, null);
        int r15 = StringsKt.indexOf$default(r13, r16, 0, false, 6, null);
        int r10 = StringsKt.indexOf$default(r13, r17, 0, false, 6, null);
        p r11 = new p(r0);
        q r14 = new q(r0);
        r r18 = new r(r0);
        r12.setSpan(r11, r9, r4.length() + r9, 33);
        r12.setSpan(r14, r15, r15 + r16.length(), 33);
        r12.setSpan(r18, r10, r17.length() + r10, 33);
        TextView r6 = (TextView) r2.findViewById(2131362328);
        r6.setMovementMethod(LinkMovementMethod.getInstance());
        r6.setHighlightColor(s1.h(2131106784));
        r6.setText(r12);
        x0.d r7 = new x0.d();
        r7.b = r1;
        r7.a = 0;
        r7.e = r2;
        r7.k = true;
        r7.l = true;
        r7.i = new o(r5);
        x0 r19 = new x0(r7.b, r7);
        x0.b.g(r19);
        r3.setOnCheckedChangeListener(new m(r8, r5));
        LiveMgMountContextService$showStarAtlasAgreementDialog$4 r20 = LiveMgMountContextService$showStarAtlasAgreementDialog$4.INSTANCE;
        r8.setOnClickListener(new n(r24, r3, r25, new LiveMgMountContextService$showStarAtlasAgreementDialog$5(r24, r26, r27, r19), r5));
        AnchorMiniGameAppLogContextService r21 = (AnchorMiniGameAppLogContextService) r24.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r22 = new HashMap();
        int r23 = v.a;
        c0 r28 = r24.f;
        if (r28 == null) goto L5;
        String r29 = r28.a;
    L6:
        r22.put("source", v.a(r29));
        Unit r30 = Unit.INSTANCE;
        r21.reportLiveRoomMgAppLog("mp_star_task_authorization_show", r22);
        return;
    L5:
        r29 = null;
        goto L6
    }

    public static void k(LiveMgMountContextService r3, Context r4, c0 r5, JSONObject r6, x0 r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r6 = null;
    L6:
        if ((r8 & 8) == 0) goto L8;
        r7 = null;
    L8:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "gameInfo");
        if (r4 != null) goto L11;
        qo0.a.b("LiveMgMountContextService", "openLynxDetailDialog failed, context is null", null);
        return;
    L11:
        String r9 = ((m51) r50.a.getValue()).b();
        if (r9 != null) goto L14;
        r9 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-normal-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fmicro_game%2Fdetail%2Fwebcast%2Fmicro_game_detail_webcast%2Fpages%2Fdetail%2Ftemplate.js&use_xbridge3=1&use_bullet_container=1&disable_swipe=0&enable_prefetch=1&width_percent=100&height_percent=100&gravity=bottom&containerKey=annie_x_live&engine_type=new&mix_container_type=annie&type=popup&pad_adapter=width_percent&rate_height=100&pad_use_phone_size=1";
    L14:
        u6 r0 = new u6(r9);
        if (r6 == null) goto L20;
        Iterator<String> r10 = r6.keys();
    L18:
        if (r10.hasNext() == false) goto L20;
        String r1 = r10.next();
        r0.b(r1, r6.optString(r1));
    L20:
        String r11 = GsonProtectorUtils.toJson(GsonHelper.get(), r5);
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        r0.b("micro_game_info", r11);
        int r12 = v.a;
        String r13 = v.a(r5.a);
        if (r3.c == false) goto L26;
        String r14 = "1";
    L27:
        r0.b("is_game_mounting", r14);
        if (r7 == null) goto L30;
        r13 = "star_task_detail";
    L30:
        r0.b("source", r13);
        r3.g = jc1.k.n(IBrowserService.class).showHybridDialogWithListener(r4, r0.c(), new LiveMgMountContextService$openLynxDetailDialog$3(r3, r7, r4), i.a);
        return;
    L26:
        r14 = "0";
        goto L27
    }
}
