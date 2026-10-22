package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.live.room.enterprocess.IEnterProcessorService;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.android.livesdk.config.a71;
import com.bytedance.android.livesdk.config.cy;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.ey;
import com.bytedance.android.livesdk.config.fy;
import com.bytedance.android.livesdk.config.uf0;
import com.bytedance.android.livesdk.config.vc1;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.room.handler.SimpleLiveRoomViewHandler;
import com.bytedance.android.livesdk.room.service.ExternalFunctionInjectorService;
import com.bytedance.android.livesdk.room.util.ConvertorKt;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdk.utils.t5;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTouchAuth;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermIconFramework;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.android.livesdkapi.util.LiveEnterRoomControllerUtilKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/InteractionRoomControllerManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/i;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class InteractionRoomControllerManager extends i implements Observer<KVData> {
    public static final /* synthetic */ int l = 0;
    public InteractionContext b;
    public int c;
    public a71 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public SimpleLiveRoomViewHandler i;
    public com.bytedance.android.livesdk.room.handler.d j;
    public final CompositeDisposable k;

    public static final class a {
    }

    static {
    }

    public final void A() {
        if (this.e == true) goto L5;
        v(new InteractionRoomControllerManager$notifyControllerFunctionHandlerAttached$1(this));
        this.e = true;
    L5:
        int r0 = y.a;
        y.a(getContext().b(), this.k, "RoomController_Task", new InteractionRoomControllerManager$onInteractionReady$1(this));
        RoomContext r1 = getContext().d();
        Function0<Unit> r2 = new InteractionRoomControllerManager$onInteractionReady$2(this);
        Intrinsics.checkNotNullParameter(r1, "$this$runWithRoomEntered");
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (r1.getInteractionDataPrepared().getValue() == null) goto L8;
        r2.invoke();
        Disposable r3 = null;
    L9:
        if (r3 == null) goto L11;
        RxUtilKt.c(r3, this.k);
    L11:
        v(InteractionRoomControllerManager$notifyControllerActivityCreated$1.INSTANCE);
        if (MultiRoomConfig.INSTANCE.enableComponentPreload(getContext().c(), getContext().b()) == true) goto L14;
        return;
    L14:
        if (getContext().q.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L16;
        v(InteractionRoomControllerManager$notifyControllerStart$1.INSTANCE);
    L18:
        if (getContext().q.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L20;
        v(InteractionRoomControllerManager$notifyControllerResume$1.INSTANCE);
        return;
    L20:
        getContext().q.getLifecycle().addObserver(new InteractionRoomControllerManager$onInteractionReady$4(this));
        return;
    L16:
        getContext().q.getLifecycle().addObserver(new InteractionRoomControllerManager$onInteractionReady$3(this));
        goto L18
    L8:
        r3 = r1.getInteractionDataPrepared().a().subscribe(new ho1.c(r2));
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void f() {
        v(new InteractionRoomControllerManager$notifyControllerOnContextAttached$1(this));
        ILivePlayerClient r0 = LivePlatformPlayerManager.a(getContext().c().id, false);
        if (r0 == null) goto L7;
        final IRoomEventHub r1 = r0.getEventHub();
        if (this.h == true) goto L7;
        v(new InteractionRoomControllerManager$notifyControllerEventHubAttached$1(r1));
        this.h = true;
    L7:
        getContext().b().observeForever("cmd_p0_widget_loaded", this);
        getContext().b().observeForever("cmd_widget_loaded", this);
        getContext().b().observeForever("cmd_specific_widget_loaded", this);
        getContext().b().observeForever("cmd_specific_view_loaded", this);
        getContext().b().observeForever("cmd_specific_behavior_loaded", this);
        getContext().b().observeForever("cmd_specific_behavior_un_loaded", this);
        getContext().b().observeForever("data_right_card_loaded", this);
        getContext().b().observeForever("cmd_new_toolbar_double_check", this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void l() {
        v(InteractionRoomControllerManager$notifyControllerDestroyView$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void m() {
        v(InteractionRoomControllerManager$notifyControllerPause$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void n() {
        if (MultiRoomConfig.INSTANCE.enableComponentPreload(getContext().c(), getContext().b()) == true) goto L6;
        v(InteractionRoomControllerManager$notifyControllerResume$1.INSTANCE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void onDestroy() {
        this.k.dispose();
        SimpleLiveRoomViewHandler r0 = this.i;
        if (r0 == null) goto L8;
        Disposable r2 = r0.a;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        r0.d = null;
    L8:
        getContext().b().removeObserver(this);
        v(InteractionRoomControllerManager$notifyControllerDestroy$1.INSTANCE);
        this.b = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void p() {
        if (MultiRoomConfig.INSTANCE.enableComponentPreload(getContext().c(), getContext().b()) == true) goto L6;
        v(InteractionRoomControllerManager$notifyControllerStart$1.INSTANCE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void q() {
        v(InteractionRoomControllerManager$notifyControllerStop$1.INSTANCE);
    }

    public final void u() {
        v(new InteractionRoomControllerManager$checkRoomControllerParams$1(this));
        v(new InteractionRoomControllerManager$checkRoomControllerParams$2(this));
        if (this.e == true) goto L6;
        v(new InteractionRoomControllerManager$checkRoomControllerParams$3(this));
        this.e = true;
    L6:
        if (this.h == true) goto L13;
        ILivePlayerClient r0 = LivePlatformPlayerManager.a(getContext().c().id, false);
        if (r0 == null) goto L10;
        final IRoomEventHub r1 = r0.getEventHub();
    L11:
        if (r1 == null) goto L13;
        v(new InteractionRoomControllerManager$checkRoomControllerParams$4(r1));
        this.h = true;
        goto L13
    L10:
        r1 = null;
    L13:
        v(new InteractionRoomControllerManager$checkRoomControllerParams$5(this));
    }

    public Map<ILayoutConstraint, com.bytedance.android.livesdk.room.placeholder.widget.d> w() {
        return new HashMap();
    }

    public RoomState x() {
        String r3 = "anchor_id";
        Bundle r15 = new Bundle();
        Room r14 = getContext().c();
        DataCenter r12 = getContext().b();
        Bundle r9 = getContext().a();
        if (tb1.c.a == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        r15.putBoolean("EXTRA_IS_D_ROOM", r0);
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE", r14.isHasCommerceGoods());
        String r18 = null;
        if (getContext().r == true) goto L11;
    L39:
        User r1 = r14.getOwner();
        if (r1 != null) goto L42;
    L44:
        boolean r2 = false;
    L45:
        r15.putBoolean("EXTRA_BOOL_ANCHOR_HAS_COMMERCE_PERMISSION", r2);
        if (r9 == null) goto L49;
        r15.putBoolean("EXTRA_BOOL_SLIDED_IN_VIEW_PAGER", r9.getBoolean("is_slide_to_next_room", false));
    L49:
        if (r14.getRoomCart() == null) goto L83;
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_CART_INFO", true);
        IRoomCart r4 = r14.getRoomCart();
        if (r4 == null) goto L53;
        Boolean r5 = Boolean.valueOf(r4.getContainCart());
    L54:
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_INIT_GOOD", r5.booleanValue());
        IRoomCart r6 = r14.getRoomCart();
        if (r6 == null) goto L57;
        Integer r7 = Integer.valueOf(r6.getTotal());
    L58:
        r15.putInt("EXTRA_INT_TOTAL_SHOPPING_GOOD", r7.intValue());
        IRoomCart r8 = r14.getRoomCart();
        if (r8 == null) goto L61;
        Integer r10 = Integer.valueOf(r8.getFlashTotal());
    L62:
        r15.putInt("EXTRA_INT_FLASH_SHOPPING_GOOD", r10.intValue());
        IRoomCart r11 = r14.getRoomCart();
        if (r11 == null) goto L65;
        String r13 = r11.getCartIcon();
    L66:
        r15.putString("EXTRA_STRING_CART_ICON", r13);
        IRoomCart r16 = r14.getRoomCart();
        if (r16 == null) goto L69;
        Integer r17 = Integer.valueOf(r16.getShowCartExt());
    L70:
        r15.putInt("EXTRA_INT_SHOW_CART", r17.intValue());
        RoomCart r19 = r14.getRoomCart();
        if (r19 == null) goto L73;
        Serializable r20 = r19.getVerticalMap();
    L74:
        r15.putSerializable("EXTRA_MAP_CART_VERTICAL", r20);
        RoomCart r21 = r14.getRoomCart();
        if (r21 == null) goto L77;
        Serializable r22 = r21.getHorizontalMap();
    L78:
        r15.putSerializable("EXTRA_MAP_CART_HORIZONTAL", r22);
        RoomCart r23 = r14.getRoomCart();
        if (r23 == null) goto L81;
        Serializable r24 = r23.getCartStyleMap();
    L82:
        r15.putSerializable("EXTRA_MAP_CART_STYLE", r24);
        goto L83
    L81:
        r24 = null;
        goto L82
    L77:
        r22 = null;
        goto L78
    L73:
        r20 = null;
        goto L74
    L69:
        r17 = null;
        goto L70
    L65:
        r13 = null;
        goto L66
    L61:
        r10 = null;
        goto L62
    L57:
        r7 = null;
        goto L58
    L53:
        r5 = null;
    L83:
        r15.putString("EXTRA_ROOM_ENTER_LOG_ID", r14.getEnterLogId());
        if (r14.getToolbarData() == null) goto L94;
        LiveToolbarData r25 = r14.getToolbarData();
        Intrinsics.checkNotNull(r25);
        if (r25.getToolbarDataList() == null) goto L94;
        LiveToolbarData r26 = r14.getToolbarData();
        Intrinsics.checkNotNull(r26);
        List r27 = r26.getToolbarDataList();
        Intrinsics.checkNotNull(r27);
        Iterator r28 = r27.iterator();
    L89:
        if (r28.hasNext() == false) goto L94;
        String r29 = r3;
        if (((IToolbarComponentData) r28.next()).getId() == 1) goto L92;
        r3 = r29;
        goto L89
    L92:
        int r30 = 1;
    L96:
        if (r14.getRoomCart() == null) goto L104;
        IRoomCart r31 = r14.getRoomCart();
        if (r31 != null) goto L100;
    L102:
        boolean r32 = false;
    L103:
        r15.putBoolean("EXTRA_BOOL_IS_TOOLBAR_EQUAL_CART", r32);
        goto L104
    L100:
        if (r30 != r31.getShowCartExt()) goto L102;
        r32 = true;
    L104:
        Pair r33 = (Pair) getContext().b().get("data_video_size_pair");
        if (r33 == null) goto L107;
        Integer r34 = (Integer) r33.getFirst();
    L108:
        if (r34 == null) goto L115;
        if (r33.getSecond() == null) goto L115;
        Object r35 = r33.getFirst();
        Intrinsics.checkNotNull(r35);
        int r36 = ((Number) r35).intValue();
        Object r37 = r33.getSecond();
        Intrinsics.checkNotNull(r37);
        if (r36 > ((Number) r37).intValue()) goto L118;
    L119:
        boolean r38 = false;
    L120:
        boolean r110 = r38;
    L122:
        r15.putBoolean("EXTRA_BOOL_IS_HORIZONTAL_STREAM", r110);
        r15.putBoolean("EXTRA_BOOL_IS_LANDSCAPE_NEW_STYLE", com.bytedance.android.livesdk.utils.landscape.d.c(r12));
        r15.putBoolean("EXTRA_BOOL_FROM_AD", com.bytedance.android.livesdk.commerce.b.b(r12));
        m90.c r39 = m90.b.B;
        LiveEffectContextFactoryDelegate.Type r40 = LiveEffectContextFactoryDelegate.Type.DEFAULT;
        r15.putBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER", ((Boolean) r39.c(r40)).booleanValue());
        r15.putBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN", ((Boolean) m90.b.C.c(r40)).booleanValue());
        IHostCommerceServiceLive r41 = jc1.k.f(IHostCommerceServiceLive.class);
        if (r41 == null) goto L125;
        r15.putBoolean("EXTRA_BOOL_FULL_FEATURED_LIVE_COMMERCE", r41.enableFullLiveCommerce());
    L125:
        r15.putString("EXTRA_JSON_STR_ACTIVITY_TRANSMISSION", t5.b(r12));
        r15.putInt("EXTRA_ROOM_DRAW_INDEX", ((Number) r12.get("data_room_draw_index", -1)).intValue());
        com.bytedance.android.livesdk.commerce.a r42 = new com.bytedance.android.livesdk.commerce.a(r14);
        r42.d(g4.d());
        r42.e(g4.e());
        if (Intrinsics.areEqual((Boolean) r12.get("IS_MERGE_WIDGET_ENTER", Boolean.FALSE), Boolean.TRUE) == true) goto L128;
    L142:
        String r210 = "request_id";
        String r211 = "creative_id";
    L143:
        r42.a(g4.c());
        r42.i(g4.a());
        r42.g(g4.b());
        r42.f(l0.a("IESLiveEffectAdTrackExtraServiceKey", j0.l().c(am2.n.class)));
        r42.h(g4.g(r14.id));
        if (r9 == null) goto L159;
        Bundle r43 = m0.a(r9);
        if (r43 == null) goto L150;
        String r44 = r43.getString("live_recommend_info");
        if (TextUtils.isEmpty(r44) == true) goto L150;
        r42.a.put("live_recommend_info", r44);
    L150:
        String r45 = r9.getString("live_ads_params");
        r15.putString("live_ads_params", r45);
        if (r45 == null) goto L159;
        if (TextUtils.isEmpty(r45) == true) goto L159;
        r15.putBoolean("auto_open_live_ad_landing_page", new JSONObject(r45).optBoolean("auto_open_windmill_page"));     // Catch: JSONException -> L156
    L156:
        e = move-exception;
        ALogger.e("NewLiveAdsSchemaHandle", String.valueOf(e.getMessage()));
    L159:
        if (c1.b(r12) == false) goto L162;
        r42.b(c1.e(r12));
    L162:
        if (c1.c(r12) == false) goto L164;
        r42.c(c1.f(r12));
    L164:
        int r46 = x1.a;
        HashMap r47 = new HashMap();
        String r48 = (String) r12.get("data_enter_room_pop_type", "");
        if (r48 != null) goto L167;
        r48 = "";
    L167:
        r47.put("pop_type", r48);
        String r49 = (String) r12.get("data_enter_ecom_live_params", "");     // Catch: JSONException -> L187
        if (TextUtils.isEmpty(r49) == false) goto L171;
        JSONObject r50 = new JSONObject();     // Catch: JSONException -> L187
    L172:
        Long r51 = (Long) r12.get("data_preview_coupon_id", 0L);     // Catch: JSONException -> L187
        if (r51.longValue() <= 0) goto L175;
        r50.put("preview_coupon_id", String.valueOf(r51.longValue()));     // Catch: JSONException -> L187
    L175:
        Iterator<String> r52 = r50.keys();     // Catch: JSONException -> L187
    L177:
        if (r52.hasNext() == false) goto L182;
        String r111 = r52.next();     // Catch: JSONException -> L187
        String r112 = r50.optString(r111);     // Catch: JSONException -> L187
        if (r112 != null) goto L181;
        r112 = "";
    L181:
        r47.put(r111, r112);     // Catch: JSONException -> L187
        goto L177
    L182:
        JSONObject r53 = new JSONObject();     // Catch: JSONException -> L187
        if (r9 == null) goto L185;
        r53.put("live_ad_coupon_token", r9.getString("live_ad_coupon_token"));     // Catch: JSONException -> L187
        r53.put("live_apply_qcpx_params", r9.getString("live_apply_qcpx_params"));     // Catch: JSONException -> L187
        r53.put("live_ad_national_task_schema", r9.getString("live_ad_national_task_schema"));     // Catch: JSONException -> L187
        r53.put("qpon_token", r9.getString("qpon_token"));     // Catch: JSONException -> L187
        r53.put("qpon_biz_tag", r9.getString("qpon_biz_tag"));     // Catch: JSONException -> L187
    L185:
        String r54 = r211;
        r53.put(r54, r42.a.get(r54));     // Catch: JSONException -> L187
        String r55 = r210;
        r53.put(r55, r42.a.get(r55));     // Catch: JSONException -> L187
        String r56 = r29;
        r53.put(r56, r42.a.get(r56));     // Catch: JSONException -> L187
        r47.put("live_ad_business_extra_params", r53.toString());     // Catch: JSONException -> L187
    L189:
        if (r9 == null) goto L196;
        Bundle r57 = r9.getBundle("game_promote_enter_room");
        if (r57 == null) goto L193;
        r15.putBundle("game_promote_enter_room", r57);
    L193:
        String r58 = r9.getString("live.intent.extra.LIVE_JUMP_EXTRA");
        if (r58 == null) goto L196;
        r15.putString("live.intent.extra.LIVE_JUMP_EXTRA", r58);
    L196:
        HashMap r59 = new HashMap();
        IEnterProcessorService r60 = jc1.k.f(IEnterProcessorService.class);
        if (r60 == null) goto L199;
        Boolean[] r61 = {Boolean.FALSE};
        r60.interactionBizInterceptor().processFetchRoomState(r14, r15, r12, r47, r59, r42, r61);
        boolean r113 = Intrinsics.areEqual(Boolean.TRUE, r61[0]);
    L201:
        return t(r15, r14, r42.a, r47, r59, r113);
    L199:
        r113 = false;
        goto L201
    L171:
        r50 = new JSONObject(r49);     // Catch: JSONException -> L187
    L187:
        e = move-exception;
        ALogger.e("[build_room_state]", e);
        goto L189
    L128:
        if (r9 == null) goto L130;
        Bundle r114 = r9.getBundle("MERGE_WIDGET_ENTER_BUNDLE");
    L131:
        if (r114 == null) goto L142;
        Bundle r115 = r9.getBundle("MERGE_WIDGET_ENTER_BUNDLE");
        if (r115 == null) goto L142;
        r210 = "request_id";
        r211 = "creative_id";
        if (r115.containsKey("click_method") != true) goto L143;
        Bundle r62 = r9.getBundle("MERGE_WIDGET_ENTER_BUNDLE");
        if (r62 == null) goto L139;
        r18 = r62.getString("click_method");
    L139:
        String r63 = r18;
        if (TextUtils.isEmpty(r63) == true) goto L143;
        r42.a.put("click_method", r63);
        goto L143
    L130:
        r114 = null;
    L118:
        r38 = true;
    L115:
        if (r14.getStreamUrlExtra() == null) goto L121;
        StreamUrlExtra r64 = r14.getStreamUrlExtra();
        Intrinsics.checkNotNull(r64);
        int r65 = r64.getWidth();
        StreamUrlExtra r66 = r14.getStreamUrlExtra();
        Intrinsics.checkNotNull(r66);
        if (r65 <= r66.getHeight()) goto L119;
    L121:
        r110 = false;
        goto L122
    L107:
        r34 = null;
    L94:
        r29 = r3;
        r30 = 0;
        goto L96
    L42:
        if (r1.isWithCommercePermission() == false) goto L44;
        r2 = true;
        goto L45
    L11:
        if (r14.getBusinessLive() != 1) goto L21;
        RoomAuthStatus r67 = r14.getMRoomAuthStatus();
        if (r67 != null) goto L15;
    L16:
        RoomAuthStatus r68 = r14.getMRoomAuthStatus();
        if (r68 == null) goto L21;
        if (r68.getCommerceCard() != 1) goto L21;
    L20:
        boolean r69 = true;
    L22:
        r15.putBoolean("EXTRA_BOOL_IS_BUSINESS_ROOM", r69);
        if (r14.getShortTouchAuth() == null) goto L29;
        ShortTouchAuth r70 = r14.getShortTouchAuth();
        if (r70 == null) goto L27;
        Boolean r71 = Boolean.valueOf(r70.hasCommerceLottery());
    L28:
        boolean r72 = r71.booleanValue();
    L30:
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE_LOTTERY", r72);
        if (r14.getMRoomAuthStatus() == null) goto L37;
        RoomAuthStatus r73 = r14.getMRoomAuthStatus();
        if (r73 == null) goto L37;
        if (r73.getCommerceCard() != 2) goto L37;
        boolean r75 = true;
    L38:
        r15.putBoolean("EXTRA_BOOL_ROOM_FORBID_COMMERCE_CARD", r75);
        r15.putBoolean("auto_open_live_ad_landing_page", ((Boolean) r12.get("auto_open_live_ad_landing_page", Boolean.FALSE)).booleanValue());
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_GROUP_PURCHASE_PERMISSION", com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.c(r14));
        r15.putString("data_enter_locallife_live_params", (String) r12.get("data_enter_locallife_live_params", ""));
        r15.putString("data_enter_locallife_live_env_params", (String) r12.get("data_enter_locallife_live_env_params", ""));
    L37:
        r75 = false;
        goto L38
    L27:
        r71 = null;
        goto L28
    L29:
        r72 = false;
        goto L30
    L15:
        if (r67.getCommerceCard() == 0) goto L20;
    L21:
        r69 = false;
        goto L22
    L5:
        if (r14.isD3Room() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final SimpleLiveRoomViewHandler y() {
        SimpleLiveRoomViewHandler r0 = this.i;
        Widget r1 = null;
        if (r0 != null) goto L20;
        r0 = new SimpleLiveRoomViewHandler(w(), (IShortTermIconFramework) getContext().d().getShortTermIconFramework().getValue(), getContext().b());
        this.i = r0;
        e0 r2 = getContext().d;
        if (r2 == null) goto L13;
        IAbilityCenter r3 = r2.m;
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.r r4 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.r) r3.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.r.class);
    L10:
        if (r4 == null) goto L13;
        r1 = r4.pq();
        goto L13
    L9:
        r4 = null;
    L13:
        if (r0.d != null) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L19;
        if (r1 == null) goto L19;
        r0.d = r1;
    L19:
        getContext().d().getLiveRoomViewHandler().setValue(this.i);
    L38:
        return r0;
    L15:
        r5 = false;
        goto L16
    L20:
        Map r6 = r0.e;
        if (getContext().d().getInteractivityContext().getValue() == null) goto L38;
        DataCenter r7 = getContext().b();
        InteractionContext r8 = this.b;
        if (r8 != null) goto L25;
        InteractionContext.Companion.getClass();
        r8 = InteractionContext.b.a(r7);
        this.b = r8;
    L25:
        if (r8 == null) goto L29;
        com.bytedance.live.datacontext.m<Map<ILayoutConstraint, com.bytedance.android.livesdk.room.placeholder.widget.d>> r9 = r8.getRoomPlaceHolders();
        if (r9 == null) goto L29;
        r1 = (Map) r9.getValue();
    L29:
        if (r1 == null) goto L38;
        Iterator r10 = r1.keySet().iterator();
    L32:
        if (r10.hasNext() == false) goto L38;
        ILayoutConstraint r11 = (ILayoutConstraint) r10.next();
        if (r6.containsKey(r11) == true) goto L32;
        com.bytedance.android.livesdk.room.placeholder.widget.d r12 = (com.bytedance.android.livesdk.room.placeholder.widget.d) r1.get(r11);
        if (r12 == null) goto L32;
        r6.put(r11, r12);
        goto L32
    }

    public final boolean z() {
        if (tb1.c.a == true) goto L5;
    L11:
        return false;
    L5:
        if (cy.a.getValue().a() != 1) goto L7;
        return true;
    L7:
        if (ey.a.getValue().a() != 1) goto L9;
        return true;
    L9:
        if (fy.a.getValue().a() != 1) goto L11;
        return true;
    }

    public InteractionRoomControllerManager() {
        this.d = new a71();
        this.k = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void h() {
        boolean r1 = false;
        this.c = ((Number) getContext().b().get("room_controller_unique_key", 0)).intValue();
        ALogger.i("RoomControllerTracer", "mParentFragmentCode = " + this.c + ", abs = " + hashCode());
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L5;
    L7:
        a71 r0 = uf0.a.getValue();
        this.d = r0;
        if (r0.mEnable == true) goto L10;
    L12:
        if (r1 == true) goto L27;
        IHostGameCP r2 = jc1.k.f(IHostGameCP.class);
        if (r2 == null) goto L18;
        IGameCpLiveService r3 = r2.getGameCpLiveService();
        if (r3 == null) goto L18;
        Object r4 = r3.getGameCpRoomControllerProvider();
    L20:
        if (z() == false) goto L27;
        if ((r4 instanceof ILiveRoomControllerProvider) == false) goto L27;
        ExternalFunctionInjectorService r5 = jc1.k.f(ExternalFunctionInjectorService.class);
        if (r5 == null) goto L26;
        r5.injectRoomControllerProvider((ILiveRoomControllerProvider) r4);
    L26:
        LiveEnterRoomControllerUtilKt.setHasGameCpInjected(true);
    L18:
        r4 = null;
    L27:
        IEnterGuideService r6 = jc1.k.f(IEnterGuideService.class);
        if (r6 == null) goto L32;
        l32.c r7 = r6.getKeyRoomInfoBizController();
        if (r7 == null) goto L32;
        r7.a();
    L32:
        v(InteractionRoomControllerManager$notifyControllerOnCreate$1.INSTANCE);
        return;
    L10:
        if (r0.mGameCpOpt == false) goto L12;
        r1 = true;
        goto L12
    L5:
        if (Intrinsics.areEqual((Boolean) getContext().d().isRoomVisible().getValue(), Boolean.FALSE) == false) goto L7;
        on1.b r8 = new on1.b();
        r8.a = getContext().c();
        r8.b = getContext().b();
        r8.c = getContext().q.requireContext();
        on1.a.b(r8, false);
        goto L7
    }

    public static final com.bytedance.android.livesdk.room.handler.a s(InteractionRoomControllerManager r1) {
        r1.getClass();
        return new com.bytedance.android.livesdk.room.handler.a(r1.getContext().b());
    }

    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        if (getContext().e == false) goto L179;
        Object r0 = null;
        if (r12 == null) goto L8;
        String r1 = r12.getKey();
    L9:
        if (r1 == null) goto L180;
        final String r3 = "";
        switch(r1.hashCode()) {
            case -1911031524: goto L150;
            case -1836833765: goto L43;
            case -1575056762: goto L40;
            case -435307162: goto L37;
            case 373304631: goto L30;
            case 428857016: goto L23;
            case 1186479618: goto L18;
            case 1995521258: goto L15;
            default: goto L181;
        };
    L181:
        return;
    L15:
        if (r1.equals("cmd_specific_behavior_loaded") == false) goto L159;
        final ToolbarBehaviorData r13 = (ToolbarBehaviorData) r12.getData(null);
        u();
        v(new InteractionRoomControllerManager$notifyControllerSpecificBehaviorLoad$1(r13));
        return;
    L159:
        return;
    L18:
        if (r1.equals("cmd_new_toolbar_double_check") == false) goto L161;
        ALogger.i("NewToolbarLog", "CMD_NEW_TOOLBAR_DOUBLE_CHECK");
        if (Intrinsics.areEqual((String) getContext().b().get("cmd_new_toolbar_double_check", ""), "commerce") == false) goto L162;
        u();
        return;
    L162:
        return;
    L161:
        return;
    L23:
        if (r1.equals("cmd_specific_widget_loaded") == false) goto L164;
        String r14 = (String) r12.getData("");
        if (r14 == null) goto L28;
        r3 = r14;
    L28:
        u();
        v(new InteractionRoomControllerManager$notifyControllerSpecificWidgetLoaded$1(r3));
        return;
    L164:
        return;
    L30:
        if (r1.equals("cmd_specific_view_loaded") == false) goto L166;
        String r15 = (String) r12.getData("");
        if (r15 == null) goto L35;
        r3 = r15;
    L35:
        u();
        v(new InteractionRoomControllerManager$notifyControllerSpecificViewAttached$1(r3));
        return;
    L166:
        return;
    L37:
        if (r1.equals("cmd_specific_behavior_un_loaded") == false) goto L168;
        final ToolbarBehaviorData r16 = (ToolbarBehaviorData) r12.getData(null);
        u();
        v(new InteractionRoomControllerManager$notifyControllerSpecificBehaviorUnload$1(r16));
        return;
    L168:
        return;
    L40:
        if (r1.equals("cmd_p0_widget_loaded") == false) goto L170;
        v(InteractionRoomControllerManager$notifyControllerP0WidgetLoad$1.INSTANCE);
        return;
    L170:
        return;
    L43:
        if (r1.equals("cmd_widget_loaded") == true) goto L45;
        return;
    L45:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r12) == false) goto L173;
        v(new InteractionRoomControllerManager$notifyControllerViewHandlerAttached$1(this));
        boolean r2 = false;
        if (MultiRoomConfig.INSTANCE.isUseNewRoomController() == false) goto L65;
        on1.b r17 = new on1.b();
        r17.a = getContext().c();
        r17.b = getContext().b();
        r17.c = getContext().q.requireContext();
        boolean r6 = on1.a.b(r17, false);
        StringBuilder r7 = new StringBuilder("notifyNewRoomControllerWidget isNeedCall = ");
        r7.append(r6);
        r7.append(" roomId: ");
        Room r8 = r17.a;
        if (r8 == null) goto L51;
        r0 = Long.valueOf(r8.getRoomId());
    L51:
        r7.append(r0);
        ALogger.i("InteractionRoomControllerManager", r7.toString());
        if (r6 == false) goto L142;
        on1.a.a(r17);
        v(new InteractionRoomControllerManager$notifyNewRoomControllerWidget$1(this));
        v(new InteractionRoomControllerManager$notifyNewRoomControllerWidget$2(this));
        ILivePlayerClient r18 = LivePlatformPlayerManager.a(getContext().c().id, false);     // Catch: NullPointerException -> L61
        if (r18 == null) goto L60;
        final IRoomEventHub r19 = r18.getEventHub();     // Catch: NullPointerException -> L61
        if (r19 == null) goto L60;
        v(new InteractionRoomControllerManager$notifyNewRoomControllerWidget$3(r19));     // Catch: NullPointerException -> L61
    L63:
        v(new InteractionRoomControllerManager$notifyNewRoomControllerWidget$4(this));
        v(new InteractionRoomControllerManager$notifyNewRoomControllerWidget$5(this));
    L60:
        throw new NullPointerException("eventHub is null");     // Catch: NullPointerException -> L61
    L61:
        e = move-exception;
        ALogger.e("AbsInteractionFragment", "npe when get IRoomEventHub : " + e.getStackTrace().toString());
    L142:
        u();
        v(InteractionRoomControllerManager$notifyControllerWidgetLoadFinished$1.INSTANCE);
        DataCenter r110 = getContext().b();
        if (r110 != null) goto L145;
    L147:
        if (r2 == false) goto L174;
        com.bytedance.android.livesdk.log.d.b(getContext().b(), "detail_ad", "show", getContext().c().getAnchorId(), String.valueOf(getContext().c().id));
        return;
    L174:
        return;
    L145:
        if (((Boolean) r110.get("live_special_ad", Boolean.FALSE)).booleanValue() == false) goto L147;
        r2 = true;
        goto L147
    L65:
        if (this.d.mEnable == false) goto L142;
        if (LiveEnterRoomControllerUtilKt.getHasEcommerceInjected() == false) goto L69;
    L81:
        boolean r111 = false;
    L83:
        if (LiveEnterRoomControllerUtilKt.getHasLocalLifeInjected() == true) goto L91;
        if (this.d.mLocalLiftOpt == false) goto L91;
        IHostLiveLocalLife r9 = jc1.k.f(IHostLiveLocalLife.class);
        if (tb1.c.a == false) goto L91;
        if (r9 == null) goto L91;
        r9.initRoomController();
        LiveEnterRoomControllerUtilKt.setHasLocalLifeInjected(true);
        r111 = true;
    L91:
        if (LiveEnterRoomControllerUtilKt.getHasAdWindmillInjected() == false) goto L93;
    L95:
        boolean r10 = false;
    L97:
        if (LiveEnterRoomControllerUtilKt.getHasAdCouponInjected() == false) goto L99;
    L101:
        boolean r20 = false;
    L102:
        IHostLiveAd r21 = jc1.k.f(IHostLiveAd.class);
        if (r10 == true) goto L105;
        if (r20 == true) goto L105;
    L111:
        if (LiveEnterRoomControllerUtilKt.getHasGameCpInjected() == false) goto L113;
    L115:
        boolean r22 = false;
    L116:
        IHostGameCP r23 = jc1.k.f(IHostGameCP.class);
        if (r23 == null) goto L121;
        IGameCpLiveService r24 = r23.getGameCpLiveService();
        if (r24 == null) goto L121;
        r0 = r24.getGameCpRoomControllerProvider();
    L121:
        if (r22 == true) goto L123;
    L130:
        if (r111 == false) goto L142;
        v(new InteractionRoomControllerManager$notifyControllerWidgetLoaded$1(this));
        v(InteractionRoomControllerManager$notifyControllerWidgetLoaded$2.INSTANCE);
        v(InteractionRoomControllerManager$notifyControllerWidgetLoaded$3.INSTANCE);
        v(InteractionRoomControllerManager$notifyControllerWidgetLoaded$4.INSTANCE);
        v(new InteractionRoomControllerManager$notifyControllerWidgetLoaded$5(this));
        v(new InteractionRoomControllerManager$notifyControllerWidgetLoaded$6(this));
        ILivePlayerClient r112 = LivePlatformPlayerManager.a(getContext().c().id, false);     // Catch: NullPointerException -> L139
        if (r112 == null) goto L138;
        final IRoomEventHub r113 = r112.getEventHub();     // Catch: NullPointerException -> L139
        if (r113 == null) goto L138;
        v(new InteractionRoomControllerManager$notifyControllerWidgetLoaded$7(r113));     // Catch: NullPointerException -> L139
    L141:
        v(new InteractionRoomControllerManager$notifyControllerWidgetLoaded$8(this));
        v(new InteractionRoomControllerManager$notifyControllerWidgetLoaded$9(this));
    L138:
        throw new NullPointerException("eventHub is null");     // Catch: NullPointerException -> L139
    L139:
        e = move-exception;
        ALogger.e("AbsInteractionFragment", "npe when get IRoomEventHub : " + e.getStackTrace().toString());
        goto L141
    L123:
        if (z() == false) goto L130;
        if ((r0 instanceof ILiveRoomControllerProvider) == false) goto L130;
        ExternalFunctionInjectorService r114 = jc1.k.f(ExternalFunctionInjectorService.class);
        if (r114 == null) goto L129;
        r114.injectRoomControllerProvider((ILiveRoomControllerProvider) r0);
    L129:
        LiveEnterRoomControllerUtilKt.setHasGameCpInjected(true);
        r111 = true;
        goto L130
    L113:
        if (this.d.mGameCpOpt == false) goto L115;
        r22 = true;
    L105:
        if (r21 == null) goto L111;
        if (r20 == false) goto L108;
        r21.callInjectAdController();
        LiveEnterRoomControllerUtilKt.setHasAdCouponInjected(true);
        r111 = true;
    L108:
        if (r10 == false) goto L111;
        r21.callInjectWindmillController();
        LiveEnterRoomControllerUtilKt.setHasAdWindmillInjected(true);
        r111 = true;
        goto L111
    L99:
        if (this.d.mAdCouponOpt == false) goto L101;
        r20 = true;
        goto L102
    L93:
        if (this.d.mAdWindmillOpt == false) goto L95;
        r10 = true;
        goto L97
    L69:
        if (this.d.mEcommerceOpt == false) goto L81;
        IHostCommerceServiceLive r115 = jc1.k.f(IHostCommerceServiceLive.class);
        if (r115 == null) goto L79;
        boolean r25 = r115.enableFullLiveCommerce();
        if (tb1.c.c == false) goto L77;
        if (r25 == true) goto L77;
        r115.injectMessage();
        LiveEnterRoomControllerUtilKt.setHasEcommerceInjected(true);
    L78:
        r111 = true;
    L80:
        ExternalFunctionInjectorService.Companion.getClass();
        ExternalFunctionInjectorService.a.a("AbsInteractionFragment");
    L77:
        r115.callInjection();
        LiveEnterRoomControllerUtilKt.setHasEcommerceInjected(true);
        goto L78
    L79:
        r111 = false;
        goto L80
    L173:
        return;
    L150:
        if (r1.equals("data_right_card_loaded") == false) goto L176;
        d90 r116 = d90.a;
        if (r116.getValue() != null) goto L154;
        return;
    L154:
        if (((vc1) r116.getValue()).d() == false) goto L178;
        y();
        return;
    L178:
        return;
    L176:
        return;
    L180:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void v(Function1<? super ILiveRoomController, Unit> r5) {
        IExternalFunctionInjector r0 = jc1.k.f(IExternalFunctionInjector.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c != 0) goto L7;
        this.c = ((Number) getContext().b().get("room_controller_unique_key", 0)).intValue();
        boolean r1 = com.bytedance.android.livesdk.room.util.j.a;
        com.bytedance.android.livesdk.room.util.j.b("controllerCall mParentFragmentCode = " + this.c + ", cur = " + hashCode());
    L7:
        r5.invoke(r0.getLiveRoomController(getContext().c().id, this.c));
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void r(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
        if ((!getContext().r) == true) goto L5;
        return;
    L5:
        if (getContext().a == false) goto L15;
        IEnterGuideService r3 = jc1.k.f(IEnterGuideService.class);
        if (r3 == null) goto L16;
        l32.c r4 = r3.getKeyRoomInfoBizController();
        if (r4 == null) goto L17;
        Disposable r5 = r4.b(getContext().d());
        if (r5 == null) goto L18;
        RxUtilKt.c(r5, this.k);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public RoomState t(Bundle r10, Room r11, Map<String, String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter(r12, "eventParams");
        Intrinsics.checkNotNullParameter(r13, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r14, "adLiveParams");
        return ConvertorKt.d(false, getContext().a, r10, r11, r12, r13, r14, r15);
    }
}
