package com.bytedance.android.live.broadcastgame.behavior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b30.l;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractItemGroupProperty;
import com.bytedance.android.live.broadcastgame.api.model.g0;
import com.bytedance.android.live.broadcastgame.openplatform.behavior.ToolbarOpenPlatformBehavior;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2;
import com.bytedance.android.livesdk.config.InteractGameItemIntensifyConfig;
import com.bytedance.android.livesdk.config.ah;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\rR\"\u0010\f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/behavior/BaseToolbarInteractBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/d;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "Landroid/content/Context;", "j", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseToolbarInteractBehavior extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d implements Observer<KVData> {
    public yo2.e b;
    public View c;
    public View d;
    public ImageView e;
    public ImageView f;
    public final CompositeDisposable g;
    public final Type h;
    public long i;
    public final Context j;
    public DataCenter k;
    public final /* synthetic */ com.bytedance.android.live.core.arch.mvvm.e l;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/broadcastgame/behavior/BaseToolbarInteractBehavior$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/config/InteractGameItemIntensifyConfig;", "Lkotlin/collections/HashMap;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<HashMap<String, InteractGameItemIntensifyConfig>> {
        public b() {
        }
    }

    public static final class c implements js0.b {
        public c() {
        }

        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
            String.valueOf(39);
            throw null;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BaseToolbarInteractBehavior a;

        public d(BaseToolbarInteractBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseToolbarInteractBehavior r0 = this.a;
            r0.g((l) r2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ BaseToolbarInteractBehavior a;

        public e(BaseToolbarInteractBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseToolbarInteractBehavior r0 = this.a;
            r0.g((a2) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BaseToolbarInteractBehavior a;

        public f(BaseToolbarInteractBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseToolbarInteractBehavior r0 = this.a;
            r0.g((g0) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            AnchorGameContext.Companion.getClass();
            AnchorGameContext r6 = AnchorGameContext.a.a();
            if (r6 == null) goto L16;
            m<Integer> r7 = r6.getRecentUsedGameIdListMaxSize();
            if (r7 == null) goto L17;
            AnchorGameContext r0 = AnchorGameContext.a.a();
            if (r0 == null) goto L13;
            n<InteractItemGroupProperty> r1 = r0.getGameGroupPropertyMap();
            if (r1 == null) goto L13;
            InteractItemGroupProperty r2 = (InteractItemGroupProperty) r1.getValue();
            if (r2 == null) goto L13;
            int r3 = (int) r2.getGroupCapacity(3);
        L14:
            r7.setValue(Integer.valueOf(r3));
            return;
        L13:
            r3 = 0;
            goto L14
        L17:
            return;
        }
    }

    public static final class h implements com.bytedance.android.livesdk.popup.manager.c {
        public final /* synthetic */ BaseToolbarInteractBehavior a;
        public final /* synthetic */ View b;

        public final void b() {
        }

        public final void waiting() {
        }

        public final void a() {
            this.a.getClass();
        }

        public h(ToolbarOpenPlatformBehavior r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final int a() {
        return 2131392581;
    }

    public void b(KVData r1) {
    }

    public void g(Object r1) {
    }

    public void h() {
    }

    public final Context getContext() {
        return this.j;
    }

    public void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r7) {
        Intrinsics.checkNotNullParameter(r7, "command");
        if ((r7 instanceof pp1.c) == false) goto L16;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.k, 0, 2);
        if (r0 == null) goto L9;
        j r1 = r0.getToolbarBubbleManager();
        if (r1 == null) goto L9;
        a0 r2 = (a0) r1.getValue();
    L10:
        Context r3 = this.j;
        final View r4 = this.c;
        if (r2 == null) goto L17;
        if (r3 == null) goto L18;
        if (r4 == null) goto L19;
        r2.addBubble(r7, ((pp1.c) r7).k, new q2(this.k, r3, r4), new BaseToolbarInteractBehavior$onCommand$$inlined$lets$lambda$1(r4, this, r7));
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void i(String r7) {
        View r1 = this.c;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r7 == null) goto L19;
        yo2.e r0 = this.b;
        if (r0 == null) goto L9;
        r0.d();
    L9:
        LayoutInflater r2 = LayoutInflater.from(this.j);
        TextView r3 = null;
        if (r2 == null) goto L12;
        View r4 = r2.inflate(2131567813, null);
    L13:
        if (r4 == null) goto L15;
        r3 = (TextView) r4.findViewById(2131367794);
    L15:
        if (r3 == null) goto L17;
        r3.setText(r7);
    L17:
        yo2.e r5 = new yo2.e(this.j);
        ((yo2.d) r5).d = r4;
        ((yo2.d) r5).e = 0;
        ((yo2.d) r5).m = 5;
        ((yo2.d) r5).l = true;
        ((yo2.d) r5).b = new h((ToolbarOpenPlatformBehavior) this, r1);
        r5.a();
        this.b = r5;
        r5.i(r1, 1, 0, 0, s1.f(-10.0f));
        return;
    L12:
        r4 = null;
        goto L13
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        b((KVData) r1);
    }

    public final void onClick(View r15) {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.i) <= 500) goto L5;
        boolean r2 = false;
    L6:
        this.i = r0;
        if (r2 == false) goto L10;
        return;
    L10:
        if (((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).isInterceptOnClickToolBar(this.k, ToolbarButton.INTERACT_GAME) == false) goto L12;
        return;
    L12:
        Boolean r1 = Boolean.FALSE;
        yo2.e r3 = this.b;
        if (r3 == null) goto L15;
        r3.d();
    L15:
        Object r4 = this.k.get("cmd_hide_other_toolbar");
        if (r4 != null) goto L19;
        r4 = r1;
    L19:
        if (((Boolean) r4).booleanValue() == false) goto L22;
        return;
    L22:
        if (v.a(((Integer) this.k.get("data_link_state", 0)).intValue(), 4) == true) goto L24;
    L26:
        String r5 = "0";
    L27:
        u.l().sendLog("livesdk_interacticon_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("guide_type", "no"), TuplesKt.to("is_pk", r5)}), new Object[]{Room.class});
        LiveMode r6 = (LiveMode) this.k.get("data_live_mode", LiveMode.VIDEO);
        LiveMode r7 = LiveMode.AUDIO;
        if (r6 != r7) goto L30;
        String r8 = "voice_live";
    L31:
        int r9 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a;
        DataCenter r11 = this.k;
        Integer r12 = null;
        if (r11 == null) goto L77;
        boolean r13 = ((Boolean) r11.get("data_is_anchor", r1)).booleanValue();
        Object r14 = r11.get("data_room", null);
        if ((r14 instanceof Room) == true) goto L37;
        r14 = null;
    L37:
        Room r16 = (Room) r14;
        if (r16 == null) goto L77;
        if (r13 == false) goto L68;
        if (r16.getStreamType() != r7) goto L60;
        Integer r17 = (Integer) r11.get("data_link_state", 0);
        if (r17 == null) goto L46;
        int r18 = r17.intValue();
    L48:
        if (v.a(r18, 8) == false) goto L60;
        RoomContext r19 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if (r19 == null) goto L59;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r21 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r19.getVoiceTalkRoomSubScene().getValue();
        if (r21 == null) goto L60;
        i r22 = r21.t();
        if (r22 == null) goto L60;
        if (r22.a != 5) goto L60;
    L78:
        boolean r23 = true;
    L79:
        if (r23 == false) goto L81;
        String r24 = "chatroom";
    L82:
        Map r110 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("live_type", r8), TuplesKt.to("interaction_room_type", r24)});
        RoomContext.a r25 = RoomContext.Companion;
        RoomContext r26 = RoomContext.a.c(r25, this.k, 0, 2);
        if (r26 == null) goto L92;
        j r27 = r26.getVoiceTalkRoomSubScene();
        if (r27 == null) goto L92;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r28 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r27.getValue();
        if (r28 == null) goto L92;
        i r29 = r28.t();
        if (r29 == null) goto L92;
        r12 = Integer.valueOf(r29.a);
    L92:
        if (r12 != null) goto L95;
    L97:
        if (r12 != null) goto L100;
    L102:
        if (r12 != null) goto L105;
    L109:
        RoomContext r31 = RoomContext.a.c(r25, this.k, 0, 2);
        if (r31 == null) goto L118;
        j r32 = r31.getVideoTalkRoomSubScene();
        if (r32 == null) goto L118;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r33 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r32.getValue();
        if (r33 == null) goto L118;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r34 = r33.t();
        if (r34 == null) goto L118;
        Integer r35 = Integer.valueOf(r34.a);
    L119:
        if (r35 != null) goto L122;
    L124:
        if (r35 != null) goto L127;
    L129:
        if (r35 != null) goto L132;
    L134:
        IOpenPlatformMgAnchorService r36 = k.f(IOpenPlatformMgAnchorService.class);
        if (r36 == null) goto L139;
        Map r37 = r36.getMiniGameLotteryCommonLogMap();
        if (r37 == null) goto L139;
        r110.putAll(r37);
    L139:
        u.l().sendLog("livesdk_interaction_click", r110, new Object[]{Room.class});
        h();
        if (((Boolean) ah.a.getValue()).booleanValue() == false) goto L142;
    L143:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new c()).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("BaseToolbarInteractBehavior");
        return;
    L142:
        if (rf2.a.a() == true) goto L143;
        return;
    L132:
        if (r35.intValue() != 12) goto L134;
        r110.put("function_type", "party");
        goto L134
    L127:
        if (r35.intValue() != 4) goto L129;
        r110.put("function_type", "audience");
        goto L134
    L122:
        if (r35.intValue() != 8) goto L124;
        r110.put("function_type", "radio");
    L118:
        r35 = null;
        goto L119
    L105:
        if (r12.intValue() != 5) goto L109;
        r110.put("function_type", "radio");
        if (d0.h((IRoom) r26.getRoom().getValue()) == false) goto L109;
        r110.put("function_type", "party");
        goto L109
    L100:
        if (r12.intValue() != 10) goto L102;
        r110.put("function_type", "watch");
        goto L109
    L95:
        if (r12.intValue() != 9) goto L97;
        r110.put("function_type", "ktv");
        goto L109
    L81:
        r24 = "normal";
        goto L82
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.RoomContext");
    L46:
        r18 = 0;
    L60:
        Integer r38 = (Integer) r11.get("data_link_state", 0);
        if (r38 == null) goto L63;
        int r39 = r38.intValue();
    L65:
        if (v.a(r39, 32) == false) goto L77;
    L63:
        r39 = 0;
        goto L65
    L68:
        if (r16.getLinkMap() == null) goto L77;
        if (r16.getLinkMap().containsKey(String.valueOf(5)) == true) goto L78;
        if (r16.getLinkMap().containsKey(String.valueOf(8)) == true) goto L78;
        if ((((Number) r11.get("data_link_state", 0)).intValue() & 40) != 0) goto L78;
    L77:
        r23 = false;
        goto L79
    L30:
        r8 = "video_live";
        goto L31
    L24:
        if (((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal().getMatchType() != 0) goto L26;
        r5 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L27
    L5:
        r2 = true;
        goto L6
    }

    public void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        r3.removeObserver(this);
        this.l.a.clear();
        yo2.e r4 = this.b;
        if (r4 == null) goto L5;
        r4.d();
    L5:
        this.g.clear();
    }

    public void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super.p4(r2, r3);
        this.k = r3;
        this.c = r2;
        this.d = r2.findViewById(2131392581);
        this.e = (ImageView) r2.findViewById(2131373440);
        this.f = (ImageView) r2.findViewById(2131375547);
        r3.observe("cmd_update_income_dot", this);
        r3.observe("cmd_hide_other_toolbar", this);
        r3.observe("cmd_income_more_pop", this);
        r3.observe("data_link_state", this);
        r3.observe("data_join_channel_finished", this);
        CompositeDisposable r4 = this.g;
        r4.add(xs2.b.a().b(l.class).subscribe(new d(this)));
        r4.add(xs2.b.a().b(a2.class).subscribe(new e(this)));
        r4.add(xs2.b.a().b(g0.class).subscribe(new f(this)));
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r5 = AnchorGameContext.a.a();
        if (r5 == null) goto L12;
        n<InteractItemGroupProperty> r6 = r5.getGameGroupPropertyMap();
        if (r6 == null) goto L13;
        Observable r7 = r6.a();
        if (r7 == null) goto L14;
        Disposable r8 = r7.subscribe(g.a);
        if (r8 == null) goto L15;
        RxUtilKt.c(r8, this.g);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public BaseToolbarInteractBehavior(Context r2, DataCenter r3, com.bytedance.android.live.broadcastgame.api.interactgame.g r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "createFactory");
        this.l = new com.bytedance.android.live.core.arch.mvvm.e();
        this.j = r2;
        this.k = r3;
        LiveMode r5 = (LiveMode) r3.get("data_live_mode", LiveMode.VIDEO);
        this.g = new CompositeDisposable();
        this.h = new b().getType();
    }
}
