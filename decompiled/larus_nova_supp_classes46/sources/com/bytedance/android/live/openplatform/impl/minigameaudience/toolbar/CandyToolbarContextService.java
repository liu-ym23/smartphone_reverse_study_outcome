package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import am2.n;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AudienceMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameaudience.api.MiniGameAudienceApi;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.AudienceMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.RoomWatchDurationContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.launch.AudienceLaunchMgContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.utils.MiniGameLiveJsBridgeUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.y80;
import com.bytedance.android.livesdk.config.z80;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/CandyToolbarContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CandyToolbarContextService extends OpenPlatformContextService {
    public final String a;
    public fr0.b.a b;
    public boolean c;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ CandyToolbarContextService a;

        public a(CandyToolbarContextService r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            IHostLiveOpenPlatform r3 = TTLiveSDK.hostService().hostOpenPlatform();
            if (r3 == null) goto L6;
            r3.preloadMiniGame(this.a.h());
            return;
        }
    }

    public final String h() {
        fr0.b.a r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.schemaUrl;
    L7:
        if (((Boolean) z80.a.getValue()).booleanValue() == true) goto L9;
    L28:
        if (r2 != null) goto L31;
        return "";
    L31:
        return r2;
    L9:
        if (this.c == false) goto L28;
        String r3 = new JSONObject(n.f().d()).optString("micro_app_scheme");     // Catch: JSONException -> L12
    L13:
        int r4 = qo0.a.a;
        String r5 = this.a;
        StringBuilder r6 = new StringBuilder("getSchemaUrl ");
        fr0.b.a r7 = this.b;
        if (r7 == null) goto L16;
        String r8 = r7.a();
    L17:
        r6.append(r8);
        r6.append(", ");
        r6.append(r3);
        qo0.a.c(r5, r6.toString());
        SchemaInfo.s.getClass();
        SchemaInfo r9 = SchemaInfo.b.b(r3);
        if (TextUtils.isEmpty(r3) == true) goto L28;
        fr0.b.a r10 = this.b;
        if (r10 == null) goto L22;
        String r11 = r10.a();
    L23:
        if (r9 == null) goto L26;
        r1 = r9.a();
    L26:
        if (TextUtils.equals(r11, r1) == false) goto L28;
        r2 = r3;
        goto L28
    L22:
        r11 = null;
        goto L23
    L16:
        r8 = null;
    L12:
        r3 = "";
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        if (((Boolean) y80.a.getValue()).booleanValue() == true) goto L5;
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.g(getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.LittleGame.INSTANCE);
        return;
    L5:
        DataCenter r1 = getOpenPlatformContext().getDataCenter();
        if (r1 == null) goto L8;
        r1.put("CandyToolbarContextService", null);
    L8:
        DataCenter r2 = getOpenPlatformContext().getDataCenter();
        if (r2 == null) goto L11;
        r2.put("LittleGameConfig_entranceInfo", null);
    L11:
        DataCenter r3 = getOpenPlatformContext().getDataCenter();
        if (r3 == null) goto L14;
        r3.put("LittleGameConfig_loadButton", null);
    L14:
        DataCenter r4 = getOpenPlatformContext().getDataCenter();
        if (r4 == null) goto L19;
        r4.put("LittleGameConfig_dataFromEnter", null);
        return;
    }

    public CandyToolbarContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = "CandyToolbarContextService";
    }

    public final void i(long r4) {
        int r0 = MiniGameLiveJsBridgeUtils.a;
        autoDispose(MiniGameLiveJsBridgeUtils.a("lottery_open_game", new CandyToolbarContextService$initCandyToolbar$1(this)));
        if (((Boolean) y80.a.getValue()).booleanValue() == false) goto L23;
        DataCenter r5 = getOpenPlatformContext().getDataCenter();
        if (r5 == null) goto L7;
        r5.put("CandyToolbarContextService", this);
    L7:
        DataCenter r6 = getOpenPlatformContext().getDataCenter();
        Boolean r7 = null;
        if (r6 == null) goto L10;
        fr0.b.a r8 = (fr0.b.a) r6.get("LittleGameConfig_entranceInfo");
    L11:
        DataCenter r1 = getOpenPlatformContext().getDataCenter();
        if (r1 == null) goto L14;
        Function0<Unit> r2 = (Function0) r1.get("LittleGameConfig_loadButton");
    L15:
        DataCenter r3 = getOpenPlatformContext().getDataCenter();
        if (r3 == null) goto L18;
        r7 = (Boolean) r3.get("LittleGameConfig_dataFromEnter");
    L18:
        boolean r9 = Intrinsics.areEqual(r7, Boolean.TRUE);
        if (r8 == null) goto L25;
        if (r2 == null) goto L26;
        j(r8, r2, r9);
        return;
    L26:
        return;
    L25:
        return;
    L14:
        r2 = null;
        goto L15
    L10:
        r8 = null;
        goto L11
    L23:
        int r10 = qo0.a.a;
        qo0.a.c(this.a, "initCandyToolbar, this=" + this);
        Lazy r11 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.LittleGame.INSTANCE, new CandyToolbarContextService$initCandyToolbar$2(this, r4));
    }

    public static final void g(CandyToolbarContextService r4, Function0 r5, Function1 r6) {
        r4.getClass();
        String r0 = "";
        String r1 = new JSONObject(n.f().d()).optString("micro_app_scheme");     // Catch: JSONException -> L5
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L14;
    L9:
        Lazy r2 = LiveOpenPlatformMgClient.c;
        r4.autoDispose(((MiniGameAudienceApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAudienceApi.class)).getEntranceInfo(r4.getOpenPlatformContext().getRoomId(), r0).compose(RxUtil.rxSchedulerHelper()).retry(3).subscribe(new com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.a(r4, r6, r5), new b(r4, r6)));
        return;
    L14:
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L11
        r3.put("ad_schema", r1);     // Catch: JSONException -> L11
        r0 = r3.toString();     // Catch: JSONException -> L11
    L5:
        r1 = "";
        goto L7
    }

    public final void j(fr0.b.a r3, Function0<Unit> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "entranceInfo");
        Intrinsics.checkNotNullParameter(r4, "loadButton");
        this.c = r5;
        this.b = r3;
        MiniGameDataContext.Companion.getClass();
        MiniGameDataContext r6 = MiniGameDataContext.a.a();
        if (r6 == null) goto L7;
        m<String> r7 = r6.getGameId();
        if (r7 == null) goto L7;
        r7.setValue(r3.a());
    L7:
        MiniGameDataContext r8 = MiniGameDataContext.a.a();
        int r0 = 0;
        if (r8 == null) goto L16;
        m<Integer> r9 = r8.getInstantPlayOpenStatus();
        if (r9 == null) goto L16;
        Integer r1 = r3.f();
        if (r1 == null) goto L14;
        int r2 = r1.intValue();
    L15:
        r9.setValue(Integer.valueOf(r2));
        goto L16
    L14:
        r2 = 0;
    L16:
        MiniGameDataContext r10 = MiniGameDataContext.a.a();
        if (r10 == null) goto L25;
        m<Integer> r11 = r10.getInstantPlayToggleStatus();
        if (r11 == null) goto L25;
        Integer r12 = r3.g();
        if (r12 == null) goto L23;
        r0 = r12.intValue();
    L23:
        r11.setValue(Integer.valueOf(r0));
    L25:
        if (((Boolean) y80.a.getValue()).booleanValue() == false) goto L27;
    L30:
        ((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).f();
        RoomWatchDurationContextService r13 = (RoomWatchDurationContextService) getOpenPlatformContext().getService(RoomWatchDurationContextService.class);
        r13.getClass();
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r14 = AudienceMiniGameDataContext.a.a();
        if (r14 == null) goto L39;
        m<Boolean> r15 = r14.isCandyToolbarShow();
        if (r15 == null) goto L39;
        Observable r16 = r15.a();
        if (r16 == null) goto L39;
        Disposable r17 = r16.subscribe(new gr0.a(r13));
        if (r17 == null) goto L39;
        r13.autoDispose(r17);
    L39:
        AudienceMiniGameDataContext r18 = AudienceMiniGameDataContext.a.a();
        if (r18 == null) goto L48;
        m<Boolean> r19 = r18.isRoomBackground();
        if (r19 == null) goto L48;
        Observable r20 = r19.a();
        if (r20 == null) goto L48;
        Disposable r21 = r20.subscribe(new gr0.b(r13));
        if (r21 == null) goto L48;
        r13.autoDispose(r21);
    L48:
        OpenPlatformContext r22 = r13.getOpenPlatformContext();
        if (r22 == null) goto L60;
        ((MiniGameContext) r22).registerMiniGameLifecycleChangeListener(r13.f);
        com.bytedance.android.live.openplatform.impl.base.utils.m.f(Observable.create(new a(this)).subscribeOn(Schedulers.io()), null);
        int r23 = qo0.a.a;
        qo0.a.c(this.a, "load candy button.");
        r4.invoke();
        Room r24 = getOpenPlatformContext().getRoom();
        if (r24 == null) goto L53;
        r24.init();
    L53:
        AudienceMiniGameAppLogContextService r25 = (AudienceMiniGameAppLogContextService) getOpenPlatformContext().getService(AudienceMiniGameAppLogContextService.class);
        HashMap<String, String> r26 = new HashMap();
        r26.put("location", kr0.a.a("mg_link"));
        com.bytedance.android.live.openplatform.impl.base.utils.n.e(r26);
        if (((AudienceLaunchMgContextService) getOpenPlatformContext().getService(AudienceLaunchMgContextService.class)).d == false) goto L56;
        r26.put("is_mg_dail_page", "1");
    L57:
        Unit r27 = Unit.INSTANCE;
        r25.h("mp_show", r26);
        return;
    L56:
        r26.put("is_mg_dail_page", "0");
        goto L57
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    L27:
        if (y3.m(getOpenPlatformContext().getDataCenter()).n(ToolbarButton.LITTLE_GAME) == false) goto L30;
        int r28 = qo0.a.a;
        qo0.a.c(this.a, "candy button isShowing, don't load again");
    }

    public static final void f(CandyToolbarContextService r7, boolean r8, boolean r9, long r10) {
        r7.getClass();
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L21
        String r3 = "1";
        if (r8 == false) goto L7;
        Object r11 = "1";
    L8:
        r1.put("opt_group", r11);     // Catch: Exception -> L21
        if (r9 == false) goto L11;
        Object r12 = "1";
    L12:
        r1.put("validity", r12);     // Catch: Exception -> L21
        if (r10 > 0) goto L16;
        r3 = "0";
    L16:
        r1.put("has_start_timestamp", r3);     // Catch: Exception -> L21
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L21
        if (r10 <= 0) goto L19;
        r13.put("duration", System.currentTimeMillis() - r10);     // Catch: Exception -> L21
    L19:
        int r14 = qo0.a.a;     // Catch: Exception -> L21
        qo0.a.c(r7.a, "reportToolbarPerformance, category: " + r1 + ", metric: " + r13);     // Catch: Exception -> L21
        LiveTracingMonitor.f("ttlive_minigame_entrance_info", LiveTracingMonitor.EventModule.OPEN_PLATFORM, r1, r13, new JSONObject());     // Catch: Exception -> L21
        return;
    L11:
        r12 = "0";
        goto L12
    L7:
        r11 = "0";
    }
}
