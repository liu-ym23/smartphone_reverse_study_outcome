package com.bytedance.android.live.openplatform.impl.minigameanchor.jsb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import b30.l;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.v;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.c90;
import com.bytedance.android.livesdk.config.m51;
import com.bytedance.android.livesdk.config.r50;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/jsb/MiniGameCommonJsbContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniGameCommonJsbContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int c = 0;
    public HybridDialog a;
    public Activity b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ MiniGameCommonJsbContextService b;
        public final /* synthetic */ Function1 c;

        public b(boolean r1, MiniGameCommonJsbContextService r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            MiniGameDataContext.Companion.getClass();
            MiniGameDataContext r6 = MiniGameDataContext.a.a();
            if (r6 == null) goto L11;
            m<Integer> r7 = r6.getInstantPlayToggleStatus();
            if (r7 == null) goto L11;
            if (this.a == false) goto L9;
            int r0 = 1;
        L10:
            r7.setValue(Integer.valueOf(r0));
            goto L11
        L9:
            r0 = 2;
        L11:
            MiniGameCommonJsbContextService r8 = this.b;
            int r1 = MiniGameCommonJsbContextService.c;
            BridgeContextService r9 = (BridgeContextService) r8.getOpenPlatformContext().getService(BridgeContextService.class);
            Bundle r2 = new Bundle();
            r2.putBoolean("instant_play_status", this.a);
            Unit r3 = Unit.INSTANCE;
            r9.g("command_live_on_instant_play_status_change", r2);
            Function1 r10 = this.c;
            if (r10 == null) goto L21;
            JsonObject r11 = new JsonObject();
            r11.addProperty("success", Boolean.TRUE);
            MiniGameDataContext r12 = MiniGameDataContext.a.a();
            if (r12 == null) goto L18;
            m<Integer> r13 = r12.getInstantPlayToggleStatus();
            if (r13 == null) goto L18;
            Integer r14 = (Integer) r13.getValue();
        L19:
            r11.addProperty("current_status", r14);
            Unit r15 = (Unit) r10.invoke(r11);
            return;
        L18:
            r14 = null;
            goto L19
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Function1 r6 = this.a;
            if (r6 == null) goto L12;
            JsonObject r0 = new JsonObject();
            r0.addProperty("success", Boolean.FALSE);
            MiniGameDataContext.Companion.getClass();
            MiniGameDataContext r1 = MiniGameDataContext.a.a();
            if (r1 == null) goto L9;
            m<Integer> r2 = r1.getInstantPlayToggleStatus();
            if (r2 == null) goto L9;
            Integer r3 = (Integer) r2.getValue();
        L10:
            r0.addProperty("current_status", r3);
            Unit r7 = Unit.INSTANCE;
            Unit r8 = (Unit) r6.invoke(r0);
            return;
        L9:
            r3 = null;
            goto L10
        }
    }

    public static final class d extends b7.a {
        public final /* synthetic */ MiniGameCommonJsbContextService a;

        public d(MiniGameCommonJsbContextService r1) {
            this.a = r1;
        }

        public final void onLoadFail(View r1, String r2, String r3) {
            super.onLoadFail(r1, r2, r3);
            this.a.f();
            this.a.g();
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MiniGameCommonJsbContextService a;

        public e(MiniGameCommonJsbContextService r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            this.a.g();
        }
    }

    static {
    }

    public static boolean h() {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.getOpenLynxPanelInGame();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public final void f() {
        int r0 = v.a;
        HybridDialog r1 = this.a;
        if (r1 == null) goto L5;
        Context r2 = r1.getContext();
    L7:
        if (v.b(r2) == false) goto L20;
        HybridDialog r3 = this.a;
        if (r3 != null) goto L18;
    L16:
        this.a = null;
        return;
    L18:
        r3.dismiss();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L16
    L20:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void g() {
        Activity r0 = this.b;
        if (r0 == null) goto L5;
        r0.finish();
    L5:
        this.b = null;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r1 = AnchorMiniGameDataContext.a.a();
        if (r1 == null) goto L11;
        m<Boolean> r2 = r1.getOpenLynxPanelInGame();
        if (r2 == null) goto L12;
        r2.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    }

    public MiniGameCommonJsbContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public final void j(Context r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r1 = AnchorMiniGameDataContext.a.a();
        if (r1 == null) goto L35;
        n<c0> r2 = r1.getMicroGameInfo();
        if (r2 == null) goto L36;
        c0 r3 = (c0) r2.getValue();
        if (r3 == null) goto L37;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        if (r6 == null) goto L15;
        int r7 = qo0.a.a;     // Catch: Throwable -> L18
        qo0.a.c("MiniGameCommonJsbContextService", "openLynxPanel in game: " + h());     // Catch: Throwable -> L18
        if (h() == true) goto L13;
    L16:
        Result.constructor-impl(r6);     // Catch: Throwable -> L18
    L20:
        String r8 = ((m51) r50.a.getValue()).c();
        if (r8 != null) goto L23;
        r8 = "sslocal://webcast_lynxview/?url=https%3A%2F%2Flf-normal-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fmicro_game%2Flynx%2Funiversal%2Fmicro_game_lynx_universal_webcast%2Fpages%2Fgame_joystick%2Ftemplate.js&use_xbridge3=1&use_bullet_container=1&disable_swipe=0&width_percent=100&mix_container_type=annie&containerKey=annie_x_live&engine_type=new&pad_adapter=width_percent&bdhm_bid=ies_game_hybrid&pad_use_phone_size=1&hide_status_bar=1&pid=game_joystick&type=popup&gravity=bottom&enable_prefetch=1&force_show_top=1&landscape_custom_gravity=0&margin_right=0&margin_bottom=0";
    L23:
        u6 r0 = new u6(r8);
        String r9 = GsonProtectorUtils.toJson(GsonHelper.get(), r3);
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r0.b("micro_game_info", r9);
        r0.b("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        Room r10 = getOpenPlatformContext().getRoom();
        if (r10 == null) goto L30;
        String r11 = r10.getOwnerUserIdString();
        if (r11 == null) goto L30;
    L31:
        r0.b("anchor_id", r11);
        this.a = k.n(IBrowserService.class).showHybridDialogWithListener(r5, r0.c(), new d(this), new e(this));
        return;
    L30:
        r11 = k.n(IUserService.class).user().n();
        goto L31
    L13:
        if ((r5 instanceof Activity) == false) goto L16;
        this.b = (Activity) r5;     // Catch: Throwable -> L18
        r6.optBoolean("is_landscape");     // Catch: Throwable -> L18
        goto L16
    L15:
        r6 = null;
    L18:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L37:
        return;
    L36:
        return;
    }

    public final void i(String r13, final JsonObject r14, final Function1<? super JsonObject, Unit> r15) {
        Intrinsics.checkNotNullParameter(r13, "method");
        Intrinsics.checkNotNullParameter(r14, "param");
        String r2 = "";
        boolean r4 = false;
        Boolean r6 = null;
        String r7 = null;
        Integer r8 = null;
        r8 = null;
        switch(r13.hashCode()) {
            case 157843871: goto L133;
            case 595377332: goto L105;
            case 1019240161: goto L83;
            case 1111778759: goto L25;
            case 1967609240: goto L18;
            case 1991156014: goto L6;
            default: goto L203;
        };
    L203:
        return;
    L6:
        if (r13.equals("clickSwitchButton") == true) goto L8;
        return;
    L8:
        if (h() == false) goto L15;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r16 = AnchorMiniGameDataContext.a.a();
        if (r16 == null) goto L14;
        m<Boolean> r17 = r16.getOpenInteractPanel();
        if (r17 == null) goto L14;
        r17.setValue(Boolean.TRUE);
    L14:
        ((BridgeContextService) getOpenPlatformContext().getService(BridgeContextService.class)).g("command_close_minigame", null);
    L16:
        f();
        return;
    L15:
        xs2.b.a().post(new l(CollectionsKt.emptyList()));
        goto L16
    L18:
        if (r13.equals("clickExitButton") == false) goto L175;
        int r18 = v.a;
        Context r19 = this.b;
        if (r19 != null) goto L23;
        r19 = getOpenPlatformContext().getContext();
    L23:
        v.c(r19, getOpenPlatformContext(), new MiniGameCommonJsbContextService$handleCommonJSBInvoke$1(this, r15));
        return;
    L175:
        return;
    L25:
        if (r13.equals("operateSettings") == false) goto L177;
        JsonElement r110 = r14.get("item");
        if (r110 == null) goto L178;
        String r111 = r110.getAsString();
        if (r111 == null) goto L179;
        JsonElement r0 = r14.get("action");
        if (r0 == null) goto L33;
        r7 = r0.getAsString();
    L33:
        boolean r1 = Intrinsics.areEqual("open", r7);
        int r3 = r111.hashCode();
        if (r3 == (-1367751899)) goto L70;
        if (r3 == (-1309162249)) goto L56;
        if (r3 == (-255679790)) goto L41;
        return;
    L41:
        if (r111.equals("instant_play") == false) goto L180;
        Lazy r112 = LiveOpenPlatformMgClient.c;
        MiniGameAnchorApi r113 = (MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class);
        MiniGameDataContext.Companion.getClass();
        MiniGameDataContext r114 = MiniGameDataContext.a.a();
        if (r114 == null) goto L50;
        m<String> r115 = r114.getGameId();
        if (r115 == null) goto L50;
        String r116 = (String) r115.getValue();
        if (r116 == null) goto L50;
        r2 = r116;
    L50:
        long r5 = getOpenPlatformContext().getRoomId();
        if (r1 == false) goto L53;
        int r117 = 1;
    L54:
        autoDispose(r113.instantPlayUpdateConfig(r2, r5, r117).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r1, this, r15), new c(r15)));
        return;
    L53:
        r117 = 2;
        goto L54
    L180:
        return;
    L56:
        if (r111.equals("explain") == false) goto L182;
        final AnchorExplainCardContextService r118 = (AnchorExplainCardContextService) getOpenPlatformContext().getService(AnchorExplainCardContextService.class);
        if (r1 == false) goto L68;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r9 = AnchorMiniGameDataContext.a.a();
        if (r9 == null) goto L183;
        n<OpenPlatformMgInfoModel> r10 = r9.getOpenPlatformMg();
        if (r10 == null) goto L184;
        OpenPlatformMgInfoModel r11 = (OpenPlatformMgInfoModel) r10.getValue();
        if (r11 == null) goto L185;
        String r12 = r11.getTaskId();
        if (r12 == null) goto L186;
        r118.g(r12, new MiniGameCommonJsbContextService$handleCommonJSBInvoke$$inlined$apply$lambda$1(r118, this, r14, r15));
        return;
    L186:
        return;
    L185:
        return;
    L184:
        return;
    L183:
        return;
    L68:
        r118.f(new MiniGameCommonJsbContextService$handleCommonJSBInvoke$$inlined$apply$lambda$2(this, r14, r15));
        return;
    L182:
        return;
    L70:
        if (r111.equals("camera") == true) goto L72;
        return;
    L72:
        if (zq0.b.a() == false) goto L74;
        f2.c("小游戏开播连线观众期间暂不支持主播开启摄像头", 0);
        return;
    L74:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r119 = AnchorMiniGameDataContext.a.a();
        if (r119 == null) goto L79;
        m<Boolean> r120 = r119.getOpenCamera();
        if (r120 == null) goto L79;
        r120.setValue(Boolean.valueOf(r1));
    L79:
        if (r15 == null) goto L81;
        JsonObject r121 = new JsonObject();
        r121.addProperty("success", Boolean.TRUE);
        r121.addProperty("current_status", Boolean.valueOf(r1));
        Unit r122 = Unit.INSTANCE;
        Unit r123 = (Unit) r15.invoke(r121);
    L81:
        f();
        return;
    L179:
        return;
    L178:
        return;
    L177:
        return;
    L83:
        if (r13.equals("openLynxDetailPage") == false) goto L192;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r124 = AnchorMiniGameDataContext.a.a();
        if (r124 == null) goto L193;
        n<c0> r125 = r124.getMicroGameInfo();
        if (r125 == null) goto L194;
        c0 r20 = (c0) r125.getValue();
        if (r20 == null) goto L195;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L102
        JsonElement r127 = r14.get("extra");     // Catch: Throwable -> L102
        if (r127 == null) goto L96;
        String r128 = r127.getAsString();     // Catch: Throwable -> L102
        if (r128 == null) goto L96;
        r2 = r128;
    L96:
        JSONObject r21 = new JSONObject(r2);     // Catch: Throwable -> L102
        LiveMgMountContextService r22 = (LiveMgMountContextService) getOpenPlatformContext().getService(LiveMgMountContextService.class);     // Catch: Throwable -> L102
        Context r129 = this.b;     // Catch: Throwable -> L102
        if (r129 != null) goto L100;
        r129 = getOpenPlatformContext().getContext();     // Catch: Throwable -> L102
    L100:
        LiveMgMountContextService.k(r22, r129, r20, r21, null, 24);     // Catch: Throwable -> L102
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L102
        return;
    L102:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L195:
        return;
    L194:
        return;
    L193:
        return;
    L192:
        return;
    L105:
        if (r13.equals("getPanelSettingStatus") == false) goto L197;
        if (r15 == null) goto L198;
        JsonObject r131 = new JsonObject();
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r132 = AnchorMiniGameDataContext.a.a();
        if (r132 == null) goto L112;
        m<Boolean> r133 = r132.getOpenCamera();
        if (r133 == null) goto L112;
        Boolean r134 = (Boolean) r133.getValue();
    L113:
        r131.addProperty("camera_status", r134);
        r131.addProperty("explain_status", Boolean.valueOf(((AnchorExplainCardContextService) getOpenPlatformContext().getService(AnchorExplainCardContextService.class)).b));
        AnchorMiniGameDataContext r135 = AnchorMiniGameDataContext.a.a();
        if (r135 == null) goto L120;
        m<Boolean> r136 = r135.getSupportChangeMount();
        if (r136 == null) goto L120;
        Boolean r137 = (Boolean) r136.getValue();
        if (r137 == null) goto L120;
        r4 = r137.booleanValue();
    L120:
        r131.addProperty("show_switch_button", Boolean.valueOf(r4));
        r131.addProperty("show_camera_button", (Boolean) c90.a.getValue());
        r131.addProperty("is_casting", Boolean.valueOf(((LiveMgCastContextService) getOpenPlatformContext().getService(LiveMgCastContextService.class)).i()));
        MiniGameDataContext.Companion.getClass();
        MiniGameDataContext r138 = MiniGameDataContext.a.a();
        if (r138 == null) goto L125;
        m<Integer> r139 = r138.getInstantPlayToggleStatus();
        if (r139 == null) goto L125;
        Integer r140 = (Integer) r139.getValue();
    L126:
        r131.addProperty("instant_play", r140);
        MiniGameDataContext r141 = MiniGameDataContext.a.a();
        if (r141 == null) goto L131;
        m<Integer> r142 = r141.getInstantPlayOpenStatus();
        if (r142 == null) goto L131;
        r8 = (Integer) r142.getValue();
    L131:
        r131.addProperty("instant_open_play", r8);
        Unit r143 = Unit.INSTANCE;
        Unit r144 = (Unit) r15.invoke(r131);
        return;
    L125:
        r140 = null;
    L112:
        r134 = null;
        goto L113
    L198:
        return;
    L197:
        return;
    L133:
        if (r13.equals("openLottery") == false) goto L200;
        JsonElement r145 = r14.get("extra");
        if (r145 == null) goto L201;
        String r146 = r145.getAsString();
        if (r146 == null) goto L202;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L165
        JSONObject r148 = new JSONObject(r146);     // Catch: Throwable -> L165
        String r149 = r148.optString("lottery_gift_url");     // Catch: Throwable -> L165
        StringsKt.isBlank(r149);     // Catch: Throwable -> L165
        i r150 = yt0.c.f();     // Catch: Throwable -> L165
        if (r150 == null) goto L145;
        n r151 = r150.getCurrentLottery();     // Catch: Throwable -> L165
        if (r151 == null) goto L145;
        g r152 = (g) r151.getValue();     // Catch: Throwable -> L165
        if (r152 == null) goto L145;
        LotteryState r153 = r152.getState();     // Catch: Throwable -> L165
    L146:
        if (r153 != null) goto L148;
    L155:
        ILiveService r154 = TTLiveService.getLiveService();     // Catch: Throwable -> L165
        if (r154 == null) goto L162;
        Context r23 = this.b;     // Catch: Throwable -> L165
        if (r23 != null) goto L161;
        r23 = getOpenPlatformContext().getContext();     // Catch: Throwable -> L165
    L161:
        r6 = Boolean.valueOf(r154.handleSchema(r23, UriProtector.parse(r149)));     // Catch: Throwable -> L165
    L162:
        int r155 = qo0.a.a;     // Catch: Throwable -> L165
        qo0.a.c("MiniGameCommonJsbContextService", "open minigame lottery schema: " + r6);     // Catch: Throwable -> L165
    L163:
        Object r156 = Result.constructor-impl(r148);     // Catch: Throwable -> L165
    L167:
        Result.box-impl(r156);
        return;
    L148:
        if (com.bytedance.android.live.profit.lottery.l.b(r153) == true) goto L155;
        i r157 = yt0.c.f();     // Catch: Throwable -> L165
        if (r157 == null) goto L163;
        com.bytedance.live.datacontext.k r158 = r157.getOnToolbarButtonClick();     // Catch: Throwable -> L165
        if (r158 == null) goto L163;
        r158.post(Unit.INSTANCE);     // Catch: Throwable -> L165
    L145:
        r153 = null;
    L165:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        r156 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L167
    L202:
        return;
    L201:
        return;
    }
}
