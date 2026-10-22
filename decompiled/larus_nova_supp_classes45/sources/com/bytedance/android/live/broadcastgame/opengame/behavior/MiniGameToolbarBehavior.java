package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.n0;
import com.bytedance.android.live.broadcastgame.xplay.f1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class MiniGameToolbarBehavior implements y {
    public static final /* synthetic */ int f = 0;
    public HSImageView a;
    public DataCenter b;
    public HSImageView c;
    public HSImageView d;
    public final CompositeDisposable e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/behavior/MiniGameToolbarBehavior$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/g;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends com.bytedance.android.live.broadcastgame.opengame.network.g>> {
        public b() {
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final void onShow() {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void yl() {
    }

    public final void a() {
        ALogger.d("MiniGameToolbarAnim", "runDefaultIconAnim");
        int r0 = f1.a;
        String r5 = f1.b(XplayScene.Video, false, true);
        if (r5 == null) goto L6;
        HSImageView r4 = this.d;
        MiniGameToolbarBehavior$runDefaultIconAnim$1 r9 = MiniGameToolbarBehavior$runDefaultIconAnim$1.INSTANCE;
        b(r4, r5, true, Boolean.FALSE, 0, r9);
        return;
    }

    public final boolean b80() {
        return y3.m(this.b).n(ToolbarButton.OPEN_PLATFORM_MINI_GAME);
    }

    public MiniGameToolbarBehavior() {
        this.e = new CompositeDisposable();
    }

    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r13) {
        StringBuilder r0 = new StringBuilder("toolbar onShow pre=");
        Object r1 = null;
        if (r13 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r13.n);
    L6:
        r0.append(r2);
        ALogger.d("MiniGameToolbarAnim", r0.toString());
        int r3 = f1.a;
        boolean r4 = false;
        Pair r5 = TuplesKt.to(2131251241, f1.b(XplayScene.Video, false, false));
        int r6 = ((Number) r5.component1()).intValue();
        String r7 = (String) r5.component2();
        if (r7 != null) goto L9;
    L14:
        HSImageView r8 = this.c;
        if (r8 == null) goto L17;
        r8.setActualImageResource(r6);
    L17:
        boolean r9 = true;
        if (((Boolean) oz0.a.getValue()).booleanValue() == false) goto L24;
        if (r13 == null) goto L24;
        if (r13.n != true) goto L24;
        ALogger.d("MiniGameToolbarAnim", "toolbar onShow skip");
        return;
    L24:
        DataCenter r11 = this.b;
        if (r11 == null) goto L27;
        Boolean r12 = (Boolean) r11.get("revenue_interact", Boolean.FALSE);
    L29:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L35;
        HashMap<String, String> r14 = new HashMap();
        r14.put("user_type", "user");
        ILinkServiceExternal r15 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r15 == null) goto L35;
        lc0.a r16 = r15.getControlService();
        if (r16 == null) goto L35;
        r16.d("livesdk_cohost_game_operate_icon_show", r14);
    L35:
        if (r13 == null) goto L101;
        String r17 = r13.d;
        if (r17 == null) goto L102;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L45
        com.bytedance.android.live.broadcastgame.opengame.network.g r19 = (com.bytedance.android.live.broadcastgame.opengame.network.g) CollectionsKt.firstOrNull((List) GsonHelper.get().fromJson(r17, new b().getType()));     // Catch: Throwable -> L45
        Gson r21 = GsonHelper.get();     // Catch: Throwable -> L45
        if (r19 == null) goto L42;
        String r22 = r19.entrances;     // Catch: Throwable -> L45
        if (r22 == null) goto L42;
    L43:
        Object r23 = Result.constructor-impl((com.bytedance.android.live.broadcastgame.opengame.network.l) r21.fromJson(r22, com.bytedance.android.live.broadcastgame.opengame.network.l.class));     // Catch: Throwable -> L45
    L48:
        if (Result.isFailure-impl(r23) == false) goto L50;
        r23 = null;
    L50:
        com.bytedance.android.live.broadcastgame.opengame.network.l r24 = (com.bytedance.android.live.broadcastgame.opengame.network.l) r23;
        if (r24 == null) goto L98;
    L65:
        if (r24 != null) goto L68;
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo is null");
        a();
        return;
    L68:
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType:" + r24.visionType);
        int r110 = r24.visionType;
        int r25 = n0.a;
        if (r110 != 1) goto L79;
        if (r24.visionIcon.length() == 0) goto L74;
        r9 = false;
    L74:
        if (r9 == false) goto L76;
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType is DIRECT but visionIcon is empty");
        a();
        return;
    L76:
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType is DIRECT and visionIcon is not empty");
        b(this.d, r24.visionIcon, true, Boolean.FALSE, 0, MiniGameToolbarBehavior$onShow$4$2.INSTANCE);
        return;
    L79:
        if (r110 != 2) goto L94;
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType is REQUEST");
        long r26 = 0;
        RoomContext r111 = RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
        if (r111 == null) goto L87;
        com.bytedance.live.datacontext.m r112 = r111.getRoom();
        if (r112 == null) goto L87;
        Room r113 = (Room) r112.getValue();
        if (r113 == null) goto L87;
        r26 = r113.id;
    L87:
        String r114 = r24.appId;
        if (r114.length() != 0) goto L90;
        r4 = true;
    L90:
        if (r4 == false) goto L92;
        r114 = r24.elemId;
    L92:
        ALogger.d("MiniGameToolbarAnim", "runConfigIconAnim appId: " + r114 + ", roomId: " + r26);
        com.bytedance.revenue.platform.api.core.rx.f.a(((AudienceGameNetApi) com.bytedance.android.live.network.c.b().e(AudienceGameNetApi.class)).getEntranceVision(r114, r26).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this), new u(this)), this.e);
        return;
    L94:
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo is unknown");
        return;
    L98:
        List<com.bytedance.android.live.broadcastgame.opengame.network.l> r115 = ((com.bytedance.android.live.broadcastgame.opengame.network.h) GsonHelper.get().fromJson(r17, com.bytedance.android.live.broadcastgame.opengame.network.h.class)).entrances;     // Catch: Throwable -> L58
        if (r115 == null) goto L55;
        com.bytedance.android.live.broadcastgame.opengame.network.l r116 = (com.bytedance.android.live.broadcastgame.opengame.network.l) CollectionsKt.firstOrNull(r115);     // Catch: Throwable -> L58
    L56:
        Object r117 = Result.constructor-impl(r116);     // Catch: Throwable -> L58
    L61:
        if (Result.isFailure-impl(r117) == true) goto L64;
        r1 = r117;
    L64:
        r24 = (com.bytedance.android.live.broadcastgame.opengame.network.l) r1;
        goto L65
    L55:
        r116 = null;
    L58:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
    L42:
        r22 = "";
    L45:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L102:
        return;
    L101:
        return;
    L27:
        r12 = null;
        goto L29
    L9:
        if (r2.a(r7) == true) goto L12;
        r7 = null;
    L12:
        if (r7 == null) goto L14;
        a1.n(this.c, r7);
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r9) {
        Intrinsics.checkNotNullParameter(r9, "command");
        if ((r9 instanceof pp1.i) == false) goto L21;
        Object r0 = ((pp1.i) r9).a;
        if ((r0 instanceof Pair) == false) goto L22;
        if (r0 == null) goto L20;
        Object r1 = ((Pair) r0).getFirst();
        if ((r1 instanceof Boolean) == true) goto L10;
        r1 = null;
    L10:
        Boolean r2 = (Boolean) r1;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r2.booleanValue() == false) goto L15;
        String r3 = "https://p1-webcast.douyinpic.com/obj/live-android/ttlive_card_small_card_anim_show.webp";
    L16:
        Function0<Unit> r4 = new MiniGameToolbarBehavior$onCommand$$inlined$let$lambda$1(this, r9);
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = r4;
        HSImageView r5 = this.a;
        if (r5 == null) goto L24;
        PipelineDraweeControllerBuilder r6 = Fresco.newDraweeControllerBuilder().setUri(r3).setAutoPlayAnimations(false);
        MiniGameToolbarBehavior$runAnimation$1 r7 = MiniGameToolbarBehavior$runAnimation$1.INSTANCE;
        Function0<Unit> r8 = new MiniGameToolbarBehavior$runAnimation$2(r11);
        r5.setController(r6.setControllerListener(new s(new MiniGameToolbarBehavior$runAnimation$3(r11), r7, r8, false, new MiniGameToolbarBehavior$runAnimation$4(r11))).build());
        return;
    L24:
        return;
    L15:
        r3 = "https://p1-webcast.douyinpic.com/obj/live-android/ttlive_card_small_card_anim_hide.webp";
        goto L16
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<*, *>");
    L22:
        return;
    }

    public final void onClick(View r3) {
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f("from_toolbar"));
        DataCenter r4 = this.b;
        if (r4 == null) goto L5;
        Boolean r5 = (Boolean) r4.get("revenue_interact", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L14;
        HashMap<String, String> r6 = new HashMap();
        r6.put("user_type", "user");
        ILinkServiceExternal r0 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r0 == null) goto L15;
        lc0.a r1 = r0.getControlService();
        if (r1 == null) goto L16;
        r1.d("livesdk_cohost_game_operate_icon_click", r6);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e.dispose();
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        ALogger.d("MiniGameToolbarAnim", "toolbar onLoad");
        this.b = r4;
        this.c = (HSImageView) r3.findViewById(2131381528);
        this.d = (HSImageView) r3.findViewById(2131381523);
        this.a = (HSImageView) r3.findViewById(2131381527);
    }

    public final void b(final HSImageView r15, final String r16, final boolean r17, final Boolean r18, final Integer r19, Function0<Unit> r21) {
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = r21;
        if (r15 == null) goto L6;
        r15.getHierarchy().setPlaceholderImage(2131251241);
        r15.getHierarchy().setFailureImage(2131251241);
        PipelineDraweeControllerBuilder r11 = Fresco.newDraweeControllerBuilder().setUri(r16).setAutoPlayAnimations(false).setImageOriginListener(new MiniGameToolbarBehavior$runEnterAnimation$2(this));
        MiniGameToolbarBehavior$runEnterAnimation$3 r12 = MiniGameToolbarBehavior$runEnterAnimation$3.INSTANCE;
        Function0<Unit> r13 = new MiniGameToolbarBehavior$runEnterAnimation$4(this, r18, r19, r15, r16, r17, r9);
        MiniGameToolbarBehavior$runEnterAnimation$5 r5 = MiniGameToolbarBehavior$runEnterAnimation$5.INSTANCE;
        r15.setController(r11.setControllerListener(new s(new MiniGameToolbarBehavior$runEnterAnimation$6(r9), r12, r13, r17, r5)).build());
        return;
    }
}
