package com.bytedance.android.live.liveinteract.revenue.battle;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.a1;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b1;
import com.bytedance.android.live.base.model.message.c1;
import com.bytedance.android.live.base.model.message.d1;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.v1;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkGuestBattleApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.r0;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.android.livesdk.message.model.f9;
import com.bytedance.android.livesdk.message.model.l9;
import com.bytedance.android.livesdk.message.model.y7;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/d0;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestBattleWidget extends AbsPlayModeWidget implements d0, vlc.l, Observer<KVData> {
    public static final /* synthetic */ int u = 0;
    public int a;
    public int b;
    public vlc.d c;
    public Disposable d;
    public Disposable e;
    public Disposable f;
    public final CompositeDisposable g;
    public long h;
    public long i;
    public long j;
    public long k;
    public int l;
    public final GuestBattleStateMachine m;
    public GuestBattleContext n;
    public a1 o;
    public boolean p;
    public int q;
    public String r;
    public int s;
    public final SceneType t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GuestBattleWidget a;

        public b(GuestBattleWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            ALogger.d("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [fetchGuestBattleConfig] success " + ((com.bytedance.android.livesdk.chatroom.model.interact.y) r8.data));
            com.bytedance.android.livesdk.chatroom.model.interact.y r9 = (com.bytedance.android.livesdk.chatroom.model.interact.y) r8.data;
            if (r9 == null) goto L34;
            List r0 = r9.getScoreInfoList();
            if (r0 == null) goto L7;
            int r1 = r0.size();
        L9:
            if (r1 <= 4) goto L15;
            List r2 = r9.getScoreInfoList();
            if (r2 == null) goto L13;
            List r3 = r2.subList(0, 4);
        L14:
            r9.setScoreInfoList(r3);
            goto L15
        L13:
            r3 = null;
        L15:
            GuestBattleContext r4 = this.a.n;
            if (r4 == null) goto L20;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.y> r5 = r4.getServerConfig();
            if (r5 == null) goto L20;
            r5.setValue(r9);
        L20:
            GuestBattleContext r6 = this.a.n;
            if (r6 == null) goto L28;
            com.bytedance.live.datacontext.m<String> r10 = r6.getDressId();
            if (r10 == null) goto L28;
            String r11 = r9.getDressId();
            if (r11 != null) goto L27;
            r11 = "0";
        L27:
            r10.setValue(r11);
        L28:
            ReadOnlyProperty r12 = vm2.d.u4;
            KProperty[] r13 = vm2.d.a;
            if (((Number) r12.getValue(null, r13[278(0x116, float:3.9E-43)])).intValue() <= 0) goto L35;
            List r14 = r9.getDurationList();
            if (r14 == null) goto L36;
            ListProtector.add(r14, 0, Long.valueOf(((Number) r12.getValue(null, r13[278(0x116, float:3.9E-43)])).intValue()));
            return;
        L36:
            return;
        L35:
            return;
        L7:
            r1 = 0;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            ALogger.e("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [fetchGuestBattleConfig] failed " + ((Throwable) r3));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GuestBattleWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public d(GuestBattleWidget r1, long r2, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            ALogger.i("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [preEnterRoom] [fetchGuestBattleInfo] success duration " + (System.currentTimeMillis() - this.b));
            this.a.onAsyncGetPlayModeInfo(5, this.c);
            if (r7 == null) goto L26;
            k1 r0 = (k1) r7.data;
            if (r0 == null) goto L27;
            p2 r1 = r0.getLinkmicPlayModeInfo();
            if (r1 == null) goto L28;
            com.bytedance.android.livesdk.chatroom.model.interact.a0 r2 = r1.getBattleInfo();
            if (r2 == null) goto L30;
            ii0.b r3 = ii0.b.a;
            GuestBattleWidget r4 = this.a;
            int r5 = GuestBattleWidget.u;
            String r8 = r4.Eq().b;
            boolean r9 = this.d;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r2, "battleInfo");
            Intrinsics.checkNotNullParameter(r8, "currentState");
            if (r9 == false) goto L15;
            JSONObject r10 = new JSONObject();
            r10.put("battle_info", r2);
            r10.put("current_state", r8);
            r3.o("fetch_battle_info_success", r10);
        L15:
            this.a.Iq(r2, this.d);
            k1 r11 = (k1) r7.data;
            String r12 = null;
            if (r11 == null) goto L18;
            String r13 = r11.getToast();
        L20:
            if (TextUtils.isEmpty(r13) == true) goto L29;
            k1 r14 = (k1) r7.data;
            if (r14 == null) goto L24;
            r12 = r14.getToast();
        L24:
            f2.c(r12, 0);
            return;
        L29:
            return;
        L18:
            r13 = null;
            goto L20
        L30:
            return;
        L28:
            return;
        L27:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ GuestBattleWidget a;
        public final /* synthetic */ boolean b;

        public e(GuestBattleWidget r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            ii0.b r0 = ii0.b.a;
            GuestBattleWidget r1 = this.a;
            int r2 = GuestBattleWidget.u;
            String r3 = r1.Eq().b;
            boolean r4 = this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "e");
            Intrinsics.checkNotNullParameter(r3, "currentState");
            if (r4 == false) goto L6;
            JSONObject r7 = new JSONObject();
            r7.put("current_state", r3);
            ii0.b.m(r6, r7);
            r0.o("fetch_battle_info_failed", r7);
        L6:
            ALogger.e("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [preEnterRoom] [fetchGuestBattleInfo] failed " + r6);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GuestBattleWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public f(GuestBattleWidget r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r18) {
            com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r18;
            com.bytedance.android.livesdk.chatroom.model.interact.b0 r2 = (com.bytedance.android.livesdk.chatroom.model.interact.b0) r1.data;
            if (r2 == null) goto L5;
            GuestBattleWidget.wq(this.a, "playmode_api_end", GsonProtectorUtils.toJsonTree(new Gson(), r2).getAsJsonObject());
        L5:
            com.bytedance.android.livesdk.chatroom.model.interact.b0 r3 = (com.bytedance.android.livesdk.chatroom.model.interact.b0) r1.data;
            vh7.c r4 = null;
            if (r3 == null) goto L10;
            vh7.c r5 = r3.getBattleInfo();
            if (r5 == null) goto L10;
            vh7.c r6 = jm2.a.d(r5);
        L12:
            if ((r6 instanceof com.bytedance.android.livesdk.chatroom.model.interact.a0) == false) goto L15;
            r4 = r6;
        L15:
            com.bytedance.android.livesdk.chatroom.model.interact.a0 r7 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) r4;
            if (r7 == null) goto L44;
            r7.setSourceFrom("finish_api");
            r7.setFinishReason(this.b);
            String r8 = "";
            if (this.b != 2) goto L21;
            String r9 = s1.B(2131917238);
        L22:
            r7.setFinishToast(r9);
            List r10 = r7.getRawResults();
            if (r10 == null) goto L26;
            List r11 = CollectionsKt.toMutableList(r10);
            if (r11 == null) goto L26;
        L27:
            r7.setResults(r11);
            ALogger.i("[GuestBattle]GuestBattleWidget", "finish guest battle success " + r7);
            GuestBattleWidget r12 = this.a;
            if (((Widget) r12).isViewValid == false) goto L30;
            r12.m.b(new GuestBattleStateMachine.a.b(r7));
        L30:
            ii0.b r13 = ii0.b.a;
            int r14 = this.b;
            GuestBattleWidget r15 = this.a;
            int r16 = GuestBattleWidget.u;
            String r17 = r15.Eq().b;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r7, "battleInfo");
            Intrinsics.checkNotNullParameter(r17, "currentState");
            if (r14 == 1) goto L41;
            if (r14 != 2) goto L34;
            r8 = "end_early";
        L42:
            JSONObject r19 = new JSONObject();
            r19.put("reason", r8);
            r19.put("battle_info", r7);
            r19.put("current_state", r17);
            r13.o("finish_battle_success", r19);
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("finish_battle_success", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r19.toString())}));
            MultiLinkEventModule r20 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
            long r21 = this.c;
            String r110 = r1.logId;
            int r22 = this.b;
            Intrinsics.checkNotNullParameter(r7, "guestBattleInfo");
            Intrinsics.checkNotNullParameter(r110, "logId");
            JSONObject r23 = new JSONObject();
            r23.put("reason", r22);
            com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r7, r23);
            nd0.c.s(nd0.c.a, LinkMonitorData.FinishGuestBattleRequest, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, System.currentTimeMillis() - r21, r110, r23, 96);
            StringCompanionObject r24 = StringCompanionObject.INSTANCE;
            ALogger.d("GuestBattleFullLinkMonitor", String.format("finishGuestBattleApiSuccess, extra: %s", Arrays.copyOf(new Object[]{r23}, 1)));
            return;
        L34:
            if (r14 != 3) goto L36;
            r8 = "fallback";
            goto L42
        L36:
            if (r14 != 4) goto L42;
            r8 = "switch_scene";
            goto L42
        L41:
            r8 = "normal";
        L26:
            r11 = new ArrayList();
            goto L27
        L21:
            r9 = "";
            goto L22
        L44:
            return;
        L10:
            r6 = null;
            goto L12
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ GuestBattleWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public g(GuestBattleWidget r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r11) {
            Throwable r5 = (Throwable) r11;
            ALogger.e("[GuestBattle]GuestBattleWidget", "GuestBattle.Request.Finish.Failed", r5);
            ExceptionUtils.handleException(((Widget) this.a).context, r5);
            ii0.b r12 = ii0.b.a;
            int r1 = this.b;
            GuestBattleWidget r2 = this.a;
            int r3 = GuestBattleWidget.u;
            String r4 = r2.Eq().b;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r5, "e");
            Intrinsics.checkNotNullParameter(r4, "currentState");
            ALogger.e("[GuestBattle]GuestBattleWidget", "finishBattle failed " + r5);
            JSONObject r0 = new JSONObject();
            r0.put("current_state", r4);
            r0.put("reason", r1);
            ii0.b.m(r5, r0);
            r12.o("finish_battle_failed", r0);
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("finish_battle_failed", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r0.toString())}));
            MultiLinkEventModule r6 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
            com.bytedance.android.livesdk.chatroom.model.interact.a0 r7 = this.a.Cq();
            long r8 = this.c;
            int r9 = this.b;
            JSONObject r10 = new JSONObject();
            r10.put("reason", r9);
            com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r7, r10);
            nd0.c.r(nd0.c.a, LinkMonitorData.FinishGuestBattleRequest, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, System.currentTimeMillis() - r8, r5, r10, 32);
            StringCompanionObject r13 = StringCompanionObject.INSTANCE;
            ALogger.d("GuestBattleFullLinkMonitor", String.format("finishGuestBattleApiFailed, extra: %s", Arrays.copyOf(new Object[]{r10}, 1)));
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ GuestBattleWidget a;

        public h(GuestBattleWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            UserAttr r5 = (UserAttr) r4;
            boolean r0 = true;
            if (r5 == null) goto L8;
            List r1 = r5.getAdminPrivileges();
            if (r1 == null) goto L8;
            LiveRoomPermission.D.getClass();
            if (r1.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L8;
        L15:
            boolean r6 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
            if (r0 == false) goto L21;
            com.bytedance.android.livesdk.sharedpref.e r2 = b6.N;
            if (((Boolean) r2.getValue()).booleanValue() == false) goto L21;
            if (r6 == false) goto L21;
            com.bytedance.android.livesdk.sharedpref.f.d(r2, Boolean.FALSE);
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r3 = y3.m(((Widget) this.a).dataCenter);
            ToolbarButton r7 = ToolbarButton.MORE;
            int r8 = pp1.c.o;
            r3.b(r7, pp1.c.a.a(s1.B(2131920682)));
        L21:
            if (r6 == false) goto L24;
            GuestBattleWidget r9 = this.a;
            r9.zq(r9.getRoom().getId());
            return;
        L24:
            return;
        L8:
            if (r5 == null) goto L14;
            List r10 = r5.getAdminPrivileges();
            if (r10 == null) goto L14;
            LiveRoomPermission.D.getClass();
            if (r10.contains(Integer.valueOf(LiveRoomPermission.q.a)) == true) goto L15;
        L14:
            r0 = false;
            goto L15
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ GuestBattleWidget a;

        public j(GuestBattleWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            GuestBattleWidget r6 = this.a;
            int r0 = GuestBattleWidget.u;
            GuestBattleStateMachine.c r7 = r6.Eq();
            r7.getClass();
            if ((r7 instanceof GuestBattleStateMachine.c.C0068c) == true) goto L5;
            ALogger.e("[GuestBattle]GuestBattleWidget", "countdown time is up, game already finished");
            return;
        L5:
            ALogger.e("[GuestBattle]GuestBattleWidget", "countdown time is up, start timeout retry");
            if (this.a.isAnchor() == false) goto L9;
            GuestBattleWidget r8 = this.a;
            r8.getClass();
            r8.e = Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(r8));
            return;
        L9:
            if (this.a.getRoom().isLiveTypeAudio() == false) goto L13;
            IVoiceChatAdminService.Companion.getClass();
            IVoiceChatAdminService r9 = IVoiceChatAdminService.a.a();
            if (r9 == null) goto L23;
            boolean r10 = r9.isEngineOn();
        L24:
            if (r10 == false) goto L29;
            this.a.Aq(true, false);
            return;
        L29:
            return;
        L23:
            r10 = false;
            goto L24
        L13:
            rj0.l.n2.getClass();
            rj0.l r11 = rj0.l.a.a();
            if (r11 == null) goto L16;
            boolean r12 = r11.isEngineOn();
        L19:
            Boolean r13 = Boolean.valueOf(r12);
        L21:
            if (r13 == null) goto L23;
            r10 = r13.booleanValue();
            goto L24
        L16:
            rj0.k.m2.getClass();
            rj0.k r14 = rj0.k.a.a();
            if (r14 == null) goto L20;
            r12 = r14.isEngineOn();
            goto L19
        L20:
            r13 = null;
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.viewmodel.i, Unit> {
        public AnonymousClass1(GuestBattleWidget r8) {
            super(1, r8, GuestBattleWidget.class, "onVoiceSceneChanged", "onVoiceSceneChanged(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.chatroom.viewmodel.i r8) {
            Intrinsics.checkNotNullParameter(r8, "p1");
            GuestBattleWidget r0 = (GuestBattleWidget) ((CallableReference) this).receiver;
            int r1 = r0.a;
            int r2 = r0.b;
            boolean r3 = false;
            if (r2 != 0) goto L8;
            Integer r4 = je0.d.h();
            if (r4 == null) goto L7;
            r2 = r4.intValue();
            goto L8
        L7:
            r2 = 0;
        L8:
            int r5 = r8.a;
            r0.a = r5;
            int r6 = r8.b;
            r0.b = r6;
            if (r1 == 0) goto L52;
            if (r1 != r5) goto L35;
            if (r2 != r6) goto L14;
            return;
        L14:
            if (e0.b(r2) == false) goto L17;
            if (r6 != 26) goto L17;
        L16:
            boolean r7 = true;
        L22:
            if (r7 == false) goto L24;
            return;
        L24:
            if (GuestBattleWidget.yq(r2, r0.b) == true) goto L50;
            int r9 = r0.b;
            if (r2 != 27) goto L29;
            if (r9 != 30) goto L29;
        L28:
            r3 = true;
        L32:
            if (r3 == false) goto L35;
            return;
        L29:
            if (r2 != 30) goto L32;
            if (r9 != 27) goto L32;
        L50:
            return;
        L17:
            if (r2 == 26) goto L19;
        L21:
            r7 = false;
            goto L22
        L19:
            if (e0.b(r6) == false) goto L21;
        L35:
            if (r0.Eq().a() == true) goto L37;
            return;
        L37:
            if (r8.b == 24) goto L54;
            r0.Mq("voiceSceneChangedTo " + r8.a);
            com.bytedance.android.livesdk.chatroom.model.interact.a0 r10 = r0.Eq().a;
            if (r0.isAnchor() == true) goto L42;
            String r11 = s1.B(2131917238);
        L43:
            r10.setFinishToast(r11);
            r10.setFinishReason(4);
            com.bytedance.android.livesdk.chatroom.model.interact.a0 r12 = r0.Cq();
            if (r12 == null) goto L46;
            r12.setFinishReason(4);
        L46:
            r0.m.b(new GuestBattleStateMachine.a.d(r0.Eq().a));
            return;
        L42:
            r11 = "";
            goto L43
        L54:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.chatroom.viewmodel.i) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleWidget$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.viewmodel.j, Unit> {
        public AnonymousClass2(GuestBattleWidget r8) {
            super(1, r8, GuestBattleWidget.class, "onVideoSceneChanged", "onVideoSceneChanged(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneWithPlayModeEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.chatroom.viewmodel.j r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            GuestBattleWidget r0 = (GuestBattleWidget) ((CallableReference) this).receiver;
            int r1 = r0.a;
            int r2 = r4.a;
            r0.a = r2;
            if (r1 == 0) goto L22;
            if (r1 != r2) goto L8;
            return;
        L8:
            if (r0.Eq().a() == true) goto L10;
            return;
        L10:
            if (r4.c == 24) goto L24;
            r0.Mq("videoSceneChangeTo " + r4.a + ' ' + r4.b);
            com.bytedance.android.livesdk.chatroom.model.interact.a0 r5 = r0.Eq().a;
            if (r0.isAnchor() == true) goto L15;
            String r3 = s1.B(2131917238);
        L16:
            r5.setFinishToast(r3);
            r0.Eq().a.setFinishReason(4);
            com.bytedance.android.livesdk.chatroom.model.interact.a0 r6 = r0.Cq();
            if (r6 == null) goto L19;
            r6.setFinishReason(4);
        L19:
            r0.m.b(new GuestBattleStateMachine.a.d(r0.Eq().a));
            return;
        L15:
            r3 = "";
            goto L16
        L24:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.chatroom.viewmodel.j) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<xh0.f> getIncompatibleSourceList() {
        IncompatibleTag r3 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new xh0.f[]{new xh0.f(r3, 7), new xh0.f(r3, 16, ""), new xh0.f(r3, 11, ""), new xh0.f(r3, 17, ""), new xh0.f(r3, 6, ""), new xh0.f(r3, 29, "")});
    }

    public final com.bytedance.android.livesdk.chatroom.model.interact.a0 Cq() {
        return GuestBattleContext.Companion.a();
    }

    public final GuestBattleStateMachine.c Eq() {
        return this.m.a();
    }

    public final void Lq() {
        MultiLinkEventModule r0 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d() == false) goto L5;
        ALogger.d("GuestBattleFullLinkMonitor", "uiRenderStart");
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.e r2 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d;
        r2.i = System.currentTimeMillis() - r2.a;
        r2.s.onNext(Unit.INSTANCE);
    L5:
        int r3 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, 0L);
        if (r4 == null) goto L8;
        r4.j(null);
    L8:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d() == false) goto L11;
        ALogger.d("GuestBattleFullLinkMonitor", "uiRenderEnd");
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.e r6 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d;
        r6.j = System.currentTimeMillis() - r6.a;
        r6.t.onNext(Unit.INSTANCE);
    L11:
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r5, 0L);
        if (r7 == null) goto L14;
        r7.i(null);
    L14:
        MultiSceneEnterRoomStatisticsUtils r8 = MultiSceneEnterRoomStatisticsUtils.a.a(r5, 0L);
        if (r8 == null) goto L18;
        r8.recordSubElementShow("playmode_end", System.currentTimeMillis());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget
    public final ne0.c createPlayModeStore() {
        return new q(this);
    }

    @Override // xh0.b
    public final xh0.h getPlayModeInfo() {
        return new xh0.h(5, s1.B(2131917225));
    }

    public final IRoom getRoom() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        IRoom r1 = com.bytedance.android.live.core.utils.a0.o(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return com.bytedance.android.live.core.utils.a0.a;
    }

    public final boolean isAnchor() {
        return com.bytedance.android.live.core.utils.a0.d(((Widget) this).dataCenter, false);
    }

    @Override // xh0.b
    public final boolean isOpen() {
        GuestBattleContext r0 = this.n;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isGameShowing();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        int r1 = 0;
        ii0.a.b = false;
        ii0.a.g();
        ALogger.e("[GuestBattle]GuestBattleWidget", "GuestBattle.Widget.onDestroy state=" + Eq() + ' ' + Cq());
        MultiLinkEventModule r2 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        ALogger.d("GuestBattleFullLinkMonitor", "reset");
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.b = false;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d.a();
        if (Eq().a() == false) goto L5;
        Fq(Eq().a);
    L5:
        Mq("onDestroy");
        vlc.d r3 = this.c;
        if (r3 == null) goto L8;
        r3.removeMessageListener(this);
    L8:
        int r4 = 1;
        if (isAnchor() == true) goto L11;
        LinkedHashMap r7 = new LinkedHashMap();
        ii0.a.c(r7, true);
        TalkRoomLogUtils.N(null, 5, r7, 0, 19);
    L46:
        this.g.dispose();
        ((Widget) this).dataCenter.removeObserver(this);
        return;
    L11:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r5 = Cq();
        if (r5 == null) goto L16;
        List r6 = r5.getResults();
        if (r6 == null) goto L16;
        int r8 = r6.size();
    L17:
        Integer r12 = Integer.valueOf(r8 - 1);
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r9 = Cq();
        if (r9 == null) goto L33;
        List r10 = r9.getResults();
        if (r10 == null) goto L33;
        ArrayList r11 = new ArrayList();
        Iterator r13 = r10.iterator();
    L23:
        if (r13.hasNext() == false) goto L32;
        Object r14 = r13.next();
        com.bytedance.android.livesdk.chatroom.model.interact.a0.d r15 = (com.bytedance.android.livesdk.chatroom.model.interact.a0.d) r14;
        if (TextUtils.isEmpty(r15.getScore()) == false) goto L27;
    L29:
        boolean r16 = false;
    L30:
        if (r16 == false) goto L23;
        r11.add(r14);
        goto L23
    L27:
        if ((!Intrinsics.areEqual(r15.getScore(), "0")) == false) goto L29;
        r16 = true;
        goto L30
    L32:
        r1 = r11.size();
    L33:
        Integer r17 = Integer.valueOf(r1);
        a1 r18 = this.o;
        if (r18 == null) goto L36;
        r4 = r18.getFinishReason();
    L36:
        Integer r19 = Integer.valueOf(r4);
        a1 r20 = this.o;
        if (r20 == null) goto L40;
        String r21 = r20.getFinishUserIdStr();
        if (r21 == null) goto L40;
    L41:
        String r110 = r21;
        if (isAnchor() == false) goto L44;
        String r22 = "anchor";
    L45:
        TalkRoomLogUtils.L(5, r12, r17, r19, r110, r22, null, 259);
        goto L46
    L44:
        r22 = "admin";
    L40:
        r21 = "";
    L16:
        r8 = 1;
        goto L17
    }

    public final void xq() {
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.e;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.f;
        if (r2 == null) goto L12;
        r2.dispose();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Widget.onCreate");
        vlc.d r1 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.c = r1;
        if (r1 == null) goto L5;
        r1.addMessageListener(MessageType.LINK_GUEST_BATTLE_MESSAGE.getKey(), this);
    L5:
        vlc.d r2 = this.c;
        if (r2 == null) goto L8;
        r2.addMessageListener(MessageType.LINK_GUEST_BATTLE_SCORE_MESSAGE.getKey(), this);
    L8:
        vlc.d r3 = this.c;
        List r4 = null;
        if ((r3 instanceof xlc.a) == true) goto L11;
        r3 = null;
    L11:
        xlc.a r5 = (xlc.a) r3;
        if (r5 == null) goto L15;
        r5.D(MessageType.LINK_MIC_PLAYMODE.getIntType(), this, "ChestGameSubSyncKey");
    L15:
        if (com.bytedance.android.live.liveinteract.utils.e.a() == true) goto L17;
        com.bytedance.android.livesdk.sharedpref.e r6 = b6.K;
        Boolean r7 = Boolean.FALSE;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r7);
    L17:
        Pair r8 = com.bytedance.live.datacontext.d.a(GuestBattleWidget$onCreate$pair$1.INSTANCE);
        GuestBattleContext r9 = (GuestBattleContext) r8.getFirst();
        r9.m283getWidget().d(this);
        com.bytedance.live.datacontext.b.a(r9, b0.class);
        this.g.add((Disposable) r8.getSecond());
        this.n = r9;
        if (getRoom().isLiveTypeAudio() == false) goto L31;
        this.l = ((Number) ((Widget) this).dataCenter.get("data_room_audio_chat_ui_layout", Integer.valueOf(je0.d.o()))).intValue();
        if (((Boolean) vm2.d.V0.getValue(null, vm2.d.a[97])).booleanValue() == true) goto L22;
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout", this);
    L22:
        com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r10 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r10.getValue();
        if (r11 == null) goto L40;
        BehaviorSubject r12 = r11.a();
        if (r12 == null) goto L40;
        final AnonymousClass1 r13 = new AnonymousClass1(this);
        Disposable r14 = r12.subscribe(new i(r13));
        if (r14 == null) goto L40;
        bind(r14);
    L40:
        this.a = je0.d.f();
        if (isAnchor() == false) goto L43;
        zq(getRoom().getId());
    L58:
        if (isAnchor() == false) goto L60;
    L72:
        new com.bytedance.android.live.liveinteract.revenue.battle.j(this);
        GuestBattleContext r0 = GuestBattleContext.Companion.getContext();
        if (r0 == null) goto L82;
        com.bytedance.live.datacontext.m<Integer> r15 = r0.getBattleState();
        if (r15 == null) goto L82;
        Observable r16 = r15.a();
        if (r16 == null) goto L82;
        Disposable r17 = r16.subscribe(new r(this));
        if (r17 == null) goto L82;
        RxUtilKt.c(r17, this.g);
    L82:
        if (this.t != SceneType.SCENE_VIDEO_TALKROOM) goto L85;
        LinkedHashMap r18 = new LinkedHashMap();
        r18.put("action_type", "guest_battle_video_dynamic_true");
        r18.put("card_type", "main");
        r18.put("biz_id", "guest_battle");
        j0.l().sendLog("livesdk_multilink_dynamic_element", r18, new Object[]{IRoom.class, am2.x.class});
        return;
    L85:
        return;
    L60:
        if (com.bytedance.android.live.liveinteract.utils.e.a == false) goto L72;
        IMiddlewareUserService r19 = jc1.k.f(IMiddlewareUserService.class);
        if (r19 == null) goto L72;
        com.bytedance.android.livesdk.user.e r20 = r19.user();
        if (r20 == null) goto L72;
        Observable r21 = r20.u();
        if (r21 == null) goto L72;
        Observable r22 = r21.observeOn(AndroidSchedulers.mainThread());
        if (r22 == null) goto L72;
        Disposable r23 = r22.subscribe(new h(this));
        if (r23 == null) goto L72;
        bind(r23);
        goto L72
    L43:
        StringBuilder r24 = new StringBuilder("room playModes = ");
        z5 r25 = getRoom().getLinkerDetail();
        if (r25 == null) goto L46;
        r4 = r25.getPlayModes();
    L46:
        r24.append(r4);
        ALogger.i("[GuestBattle]GuestBattleWidget", r24.toString());
        z5 r26 = getRoom().getLinkerDetail();
        if (r26 == null) goto L53;
        List r27 = r26.getPlayModes();
        if (r27 == null) goto L53;
        if (r27.contains(Long.valueOf(5)) != true) goto L53;
        Aq(false, true);
    L55:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L58;
        zq(getRoom().getId());
    L53:
        removePreGetEnterInfoObserver();
        goto L55
    L31:
        com.bytedance.live.datacontext.j r28 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r28 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r29 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r28.getValue();
        if (r29 == null) goto L40;
        BehaviorSubject r30 = r29.a();
        if (r30 == null) goto L40;
        final AnonymousClass2 r31 = new AnonymousClass2(this);
        Disposable r32 = r30.subscribe(new i(r31));
        if (r32 == null) goto L40;
        bind(r32);
        goto L40
    }

    public GuestBattleWidget(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        this.t = r2;
        this.g = new CompositeDisposable();
        this.l = je0.d.o();
        this.m = new GuestBattleStateMachine(new GuestBattleWidget$stateMachine$1(this));
        this.r = "";
        int r3 = com.bytedance.android.livesdk.message.model.f2.a;
        this.s = 0;
    }

    public static void Pq(com.bytedance.android.livesdk.chatroom.model.interact.a0 r4) {
        ALogger.i("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [updateDressId] dressId= " + r4.getDressId());
        if (r4.getDressId() == null) goto L20;
        GuestBattleContext.a r0 = GuestBattleContext.Companion;
        GuestBattleContext r2 = r0.getContext();
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m<String> r3 = r2.getDressId();
        if (r3 == null) goto L9;
        String r5 = (String) r3.getValue();
    L10:
        String r6 = r4.getDressId();
        GuestBattleContext r1 = r0.getContext();
        if (r1 == null) goto L18;
        com.bytedance.live.datacontext.m<String> r7 = r1.getDressId();
        if (r7 == null) goto L18;
        String r8 = r4.getDressId();
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r7.setValue(r8);
    L18:
        ALogger.i("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [updateDressId] currentDressId= " + r5 + " newDressId=" + r6);
        return;
    L9:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.d0
    public final void B8(String r5) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        ALogger.i("[GuestBattle]GuestBattleWidget", "showManagerDialog-requestPage=".concat(r5));
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.r = r5;
        if (((Boolean) v1.a.getValue()).booleanValue() == false) goto L8;
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "open_icon_click");
        JsonObject r1 = new JsonObject();
        r1.addProperty("request_page", r5);
        r0.add("extra", r1);
        ih0.b r6 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r6 == null) goto L12;
        r6.Dk("guest_battle", "playmode_action", r0, false);
        return;
    L12:
        return;
    L8:
        Context r2 = ((Widget) this).context;
        if (r2 == null) goto L13;
        r0.a(r2, r5);
        ii0.a.e(r5);
        return;
    }

    public final void Bq(int r6) {
        ALogger.w("[GuestBattle]GuestBattleWidget", "try finish guest battle reason=" + r6);
        if (this.m.a().a() == true) goto L6;
        ALogger.e("[GuestBattle]GuestBattleWidget", "battle already finished " + Cq());
        return;
    L6:
        GuestBattleStateMachine.c r0 = Eq();
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r1 = r0.a;
        if (r1 == null) goto L11;
        r1.setFinishReason(r6);
    L11:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r2 = Cq();
        if (r2 == null) goto L14;
        r2.setFinishReason(r6);
    L14:
        long r3 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkGuestBattleApi) com.bytedance.android.live.network.c.b().e(LinkGuestBattleApi.class)).finishBattle(getRoom().getId(), r6).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(((Widget) this).context)))).subscribe(new f(this, r6, r3), new g(this, r6, r3));
    }

    public final void Fq(com.bytedance.android.livesdk.chatroom.model.interact.a0 r10) {
        if (isAnchor() == false) goto L6;
        return;
    L6:
        if (this.h <= 0) goto L8;
        long r0 = System.currentTimeMillis() - this.h;
    L9:
        boolean r4 = ii0.a.b;
        long r1 = r0 / ((long) 1000);
        long r5 = r10.getBattleId();
        Integer r11 = Integer.valueOf(r10.getMode());
        HashMap r6 = new HashMap();
        r6.put("user_cnt", String.valueOf(je0.d.S()));
        if (r11 != null) goto L13;
    L15:
        String r12 = "bomb";
    L16:
        r6.put("game_name", r12);
        r6.put("game_id", String.valueOf(r5));
        r6.put("duration", String.valueOf(r1));
        i0 r13 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.E() == false) goto L19;
        String r14 = "1";
    L20:
        r6.put("if_enlarge", r14);
        TalkRoomLogUtils.B0(r6, null, null, 6);
        j0.l().sendLog("livesdk_connection_game_duration", r6, new Object[]{IRoom.class});
        this.h = 0;
        return;
    L19:
        r14 = "0";
        goto L20
    L13:
        if (r11.intValue() != 1) goto L15;
        r12 = "mvp";
        goto L16
    L8:
        r0 = 0;
        goto L9
    }

    public final void Kq(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
        Pq(r2);
        GuestBattleContext r0 = this.n;
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getBattleState();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r2.getBattleStatus()));
        return;
    L9:
        return;
    }

    public final void Mq(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        ALogger.w("[GuestBattle]GuestBattleWidget", "resetBattleStatus reason=" + r3 + " currentState=" + Eq());
        if (Eq().a() == true) goto L5;
    L7:
        xq();
        return;
    L5:
        if (isAnchor() == false) goto L7;
        Bq(4);
        goto L7
    }

    public final void Nq(com.bytedance.android.livesdk.chatroom.model.interact.a0 r7) {
        xq();
        long r4 = 1000;
        long r0 = r7.getFinishTime() - (r7.getCurrentTime() / r4);
        this.i = System.currentTimeMillis() + (r4 * r0);
        this.d = Observable.timer(r0, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this));
    }

    public final void Qq(int r3) {
        ALogger.i("[GuestBattle]GuestBattleWidget", "#updateStage# currentStage:" + this.q + ", newStage:" + r3);
        if (this.q != r3) goto L5;
        return;
    L5:
        this.q = r3;
    }

    public final boolean bind(Disposable r2) {
        return this.g.add(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget
    public final boolean handleGuideMessage(ILinkMicGuideMessageBridge r16) {
        Intrinsics.checkNotNullParameter(r16, MultiLinkOpenSource.MESSAGE);
        a5 r1 = null;
        if (r16.getGuidelineType() != 7) goto L15;
        y7 r2 = r16.getGuestBattleBubbleGuideContent();
        if (r2 == null) goto L8;
        r1 = r2.getText();
    L8:
        if (r1 == null) goto L12;
        String r3 = r1.getDefaultPattern();
        if (r3 == null) goto L12;
    L13:
        pp1.c r14 = new pp1.c(r3, null, null, 0, null, null, 1001, 0, MapsKt.mapOf(TuplesKt.to("message_type", "fight")), 0, 7870);
        ((Widget) this).dataCenter.put("cmd_show_self_bubble_on_openplatform_behavior", r14);
        return false;
    L12:
        r3 = s1.B(2131917227);
        goto L13
    L15:
        if (r16.getGuidelineType() != 13) goto L31;
        eb r4 = r16.getPlayModeGuideBubbleContent();
        if (r4 != null) goto L19;
        return false;
    L19:
        if (r4.getPlayMode() != 40) goto L33;
        eb r5 = r16.getPlayModeGuideBubbleContent();
        if (r5 != null) goto L23;
        return false;
    L23:
        if (r5.getRichText() == null) goto L30;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.r.g.d(r5.getRichText(), null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new t(this, r5));
        return true;
    L30:
        return true;
    L33:
        return false;
    L31:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, xh0.b
    public final xh0.g isCanOpen(HashMap<String, Object> r11) {
        com.bytedance.android.live.profit.vote.e r0 = yt0.c.m();
        if (r0 == null) goto L9;
        if (r0.fi() != true) goto L9;
        return new xh0.g(IncompatibleTag.PLAY_MODE, getPlayModeKey(), false, "giftVote", s1.B(2131919173));
    L9:
        if (getRoom().isLiveTypeAudio() == false) goto L11;
        boolean r1 = com.bytedance.android.livesdk.sharedpref.d.a();
    L12:
        if (r1 == false) goto L14;
        if (r11 == null) goto L17;
        Object r2 = r11.get("anchorEnable");
    L18:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L21;
        boolean r4 = r3.booleanValue();
    L22:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r5 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r4 == false) goto L25;
        int r6 = 1;
    L27:
        if (r5 == null) goto L29;
        int r7 = r5.b();
    L30:
        if (r7 >= r6) goto L34;
        return new xh0.g(IncompatibleTag.PLAY_MODE, getPlayModeKey(), false, "cnt", s1.C(2131917242, new Object[]{Integer.valueOf(r6)}));
    L34:
        return super.isCanOpen(r11);
    L29:
        r7 = 0;
        goto L30
    L25:
        r6 = 2;
        goto L27
    L21:
        r4 = ((Boolean) b6.K.getValue()).booleanValue();
        goto L22
    L17:
        r2 = null;
        goto L18
    L14:
        return new xh0.g(IncompatibleTag.PLAY_MODE, getPlayModeKey(), false, PbRequest.SwitchType.GIFT, s1.B(2131919172));
    L11:
        r1 = com.bytedance.android.livesdk.sharedpref.d.b();
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.d0
    public final void nj(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        if (((Widget) this).context == null) goto L6;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.r = r2;
        int r0 = r0.a;
        r0.a(((Widget) this).context, r2);
        ii0.a.e(r2);
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L5;
        String r0 = r7.getKey();
    L7:
        if (Intrinsics.areEqual(r0, "data_room_audio_chat_ui_layout") == false) goto L51;
        Integer r8 = (Integer) r7.getData();
        if (r8 == null) goto L53;
        int r9 = r8.intValue();
        int r1 = this.l;
        ALogger.d("[GuestBattle]GuestBattleWidget", "uiLayout change, currentUiLayout=" + r1 + ", newUiLayout=" + r9);
        if (r9 == r1) goto L54;
        this.l = r9;
        if (Eq().a() == false) goto L55;
        boolean r2 = true;
        if (r9 != 24) goto L21;
    L45:
        if (r2 == true) goto L52;
        Mq("voiceChatPlayMode " + r1 + " -> " + r9);
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r10 = Eq().a;
        r10.setFinishToast(s1.B(2131917238));
        r10.setFinishReason(4);
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r3 = Cq();
        if (r3 == null) goto L49;
        r3.setFinishReason(4);
    L49:
        this.m.b(new GuestBattleStateMachine.a.d(r10));
        return;
    L52:
        return;
    L21:
        if (e0.b(r1) == false) goto L24;
        if (r9 != 26) goto L24;
    L23:
        boolean r4 = true;
    L29:
        if (r4 == true) goto L45;
        if (yq(r1, r9) == true) goto L45;
        if (r1 != 27) goto L38;
        if (r9 != 30) goto L38;
    L37:
        boolean r5 = true;
    L42:
        if (r5 == true) goto L45;
        r2 = false;
    L38:
        if (r1 != 30) goto L41;
        if (r9 == 27) goto L37;
    L41:
        r5 = false;
    L24:
        if (r1 == 26) goto L26;
    L28:
        r4 = false;
        goto L29
    L26:
        if (e0.b(r9) == false) goto L28;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L51:
        return;
    L5:
        r0 = null;
        goto L7
    }

    public final void onMessage(tlc.d r27) {
        if ((r27 instanceof b1) == false) goto L110;
        b1 r2 = (b1) r27;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r8 = r2.getBattleInfo();
        switch(r2.getMsgType()) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L6:
        String r9 = "";
    L13:
        r8.setSourceFrom(r9);
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r10 = r2.getBattleInfo();
        List r11 = r2.getBattleInfo().getRawResults();
        if (r11 == null) goto L17;
        List r12 = CollectionsKt.toMutableList(r11);
        if (r12 == null) goto L17;
    L18:
        r10.setResults(r12);
        switch(r2.getMsgType()) {
            case 1: goto L72;
            case 2: goto L71;
            case 3: goto L66;
            case 4: goto L49;
            case 5: goto L35;
            case 6: goto L21;
            default: goto L125;
        };
    L21:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r3 = r2.getBattleInfo();
        if (r3 != null) goto L24;
        r3 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) vh7.f.c(com.bytedance.android.livesdk.chatroom.model.interact.a0.class);
    L24:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r13 = Cq();
        if (r13 != null) goto L27;
    L34:
        ALogger.i("[GuestBattle]GuestBattleWidget", "battle resume id different " + r3 + "  current=" + Cq());
        goto L125
    L27:
        if (r13.getBattleId() != r3.getBattleId()) goto L34;
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Message.onBattleResumeMsg.Receive " + r3);
        ii0.b r7 = ii0.b.a;
        String r14 = Eq().b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "battleInfo");
        Intrinsics.checkNotNullParameter(r14, "currentState");
        if (ii0.b.l() == false) goto L33;
        JSONObject r5 = new JSONObject();
        r5.put("battle_info", r3);
        r5.put("current_state", r14);
        r7.o("receive_battle_resume_msg", r5);
    L33:
        this.m.b(new GuestBattleStateMachine.a.h(r3));
        Qq(r3.getBattleStage());
        goto L125
    L35:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r4 = r2.getBattleInfo();
        if (r4 != null) goto L38;
        r4 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) vh7.f.c(com.bytedance.android.livesdk.chatroom.model.interact.a0.class);
    L38:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r15 = Cq();
        if (r15 != null) goto L41;
    L48:
        ALogger.i("[GuestBattle]GuestBattleWidget", "battle pause id different " + r4 + "  current=" + Cq());
        goto L125
    L41:
        if (r15.getBattleId() != r4.getBattleId()) goto L48;
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Message.onBattlePauseMsg.Receive " + r4);
        ii0.b r16 = ii0.b.a;
        String r17 = Eq().b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r4, "battleInfo");
        Intrinsics.checkNotNullParameter(r17, "currentState");
        if (ii0.b.l() == false) goto L47;
        JSONObject r6 = new JSONObject();
        r6.put("battle_info", r4);
        r6.put("current_state", r17);
        r16.o("receive_battle_pause_msg", r6);
    L47:
        this.m.b(new GuestBattleStateMachine.a.f(r4));
        Qq(r4.getBattleStage());
        goto L125
    L49:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r18 = r2.getBattleInfo();
        if (r18 != null) goto L52;
        r18 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) vh7.f.c(com.bytedance.android.livesdk.chatroom.model.interact.a0.class);
    L52:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r19 = Cq();
        if (r19 != null) goto L55;
    L65:
        ALogger.i("[GuestBattle]GuestBattleWidget", "battle finish id different " + r18 + "  current=" + Cq());
        goto L125
    L55:
        if (r19.getBattleId() != r18.getBattleId()) goto L65;
        this.o = r2.getFinishContent();
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Message.onBattleFinishMsg.Receive " + r18);
        ii0.b r20 = ii0.b.a;
        String r21 = Eq().b;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r18, "battleInfo");
        Intrinsics.checkNotNullParameter(r21, "currentState");
        if (ii0.b.l() == false) goto L61;
        JSONObject r22 = new JSONObject();
        r22.put("battle_info", r18);
        r22.put("current_state", r21);
        r20.o("receive_battle_finish_msg", r22);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("receive_battle_finish_msg", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r22.toString())}));
    L61:
        r18.setFinishToast(r2.getFinishToast());
        this.m.b(new GuestBattleStateMachine.a.c(r18));
        if (isAnchor() == false) goto L64;
        MultiLinkEventModule r23 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        JSONObject r24 = new JSONObject();
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r2.getBattleInfo(), r24);
        r24.put("reason", r2.getFinishToast());
        nd0.c.p(nd0.c.a, LinkMonitorData.ReceiveFinishGuestBattleMsg, r24, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, 0, null, false, null, 120);
        ALogger.d("GuestBattleFullLinkMonitor", "receiveFinishGuestBattleMsg, reason: " + r2.getFinishToast());
    L64:
        Qq(0);
        ALogger.i("GuestBattleChest", "Battle Finish!");
        ((Widget) this).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
        goto L125
    L66:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r25 = r2.getBattleInfo();
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Message.onBattleShowResultMsg.Receive " + r25);
        ii0.b r26 = ii0.b.a;
        String r28 = Eq().b;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r25, "battleInfo");
        Intrinsics.checkNotNullParameter(r28, "currentState");
        if (ii0.b.l() == false) goto L70;
        JSONObject r29 = new JSONObject();
        r29.put("battle_info", r25);
        r29.put("current_state", r28);
        r26.o("receive_show_result_msg", r29);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("receive_show_result_msg", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r29.toString())}));
    L70:
        this.m.b(new GuestBattleStateMachine.a.i(r25));
        Qq(r25.getBattleStage());
        goto L125
    L71:
        Gq(r2.getBattleInfo(), r2.getUpdateContent());
        goto L125
    L72:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r30 = r2.getBattleInfo();
        if (com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d() == false) goto L75;
        ALogger.d("GuestBattleFullLinkMonitor", "receiveStartGuestBattleMsg");
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.e r31 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d;
        r31.d = System.currentTimeMillis() - r31.a;
        r31.n.onNext(Unit.INSTANCE);
    L75:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r32 = Cq();
        if (r32 != null) goto L78;
    L82:
        if (r30 == null) goto L104;
        List r33 = r30.getRawResults();
        if (r33 == null) goto L104;
        GuestBattleStateMachine.c r34 = Eq();
        r34.getClass();
        if ((r34 instanceof GuestBattleStateMachine.c.C0068c) == true) goto L88;
        GuestBattleStateMachine.c r35 = Eq();
        r35.getClass();
        boolean r36 = r35 instanceof GuestBattleStateMachine.c.d;
    L88:
        Iterator r37 = r33.iterator();
    L90:
        if (r37.hasNext() == false) goto L98;
        Object r38 = r37.next();
        String r39 = ((com.bytedance.android.livesdk.chatroom.model.interact.a0.d) r38).getGuestIdStr();
        IRoom r110 = getRoom();
        if (r110 == null) goto L94;
        String r111 = r110.getOwnerUserIdString();
    L96:
        if (Intrinsics.areEqual(r39, r111) == false) goto L90;
    L100:
        if (((com.bytedance.android.livesdk.chatroom.model.interact.a0.d) r38) == null) goto L102;
        boolean r40 = true;
    L103:
        com.bytedance.android.livesdk.sharedpref.e r41 = b6.K;
        Boolean r42 = Boolean.valueOf(r40);
        r41.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r41, r42);
        ALogger.i("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [checkAnchorEnable] enable: " + r40);
        goto L104
    L102:
        r40 = false;
        goto L103
    L94:
        r111 = null;
        goto L96
    L98:
        r38 = null;
    L104:
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Message.onBattleCreateMsg.Receive " + r30);
        ii0.b r43 = ii0.b.a;
        String r44 = Eq().b;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r30, "battleInfo");
        Intrinsics.checkNotNullParameter(r44, "currentState");
        if (ii0.b.l() == false) goto L108;
        JSONObject r45 = new JSONObject();
        r45.put("battle_info", r30);
        r45.put("current_state", r44);
        r43.o("receive_battle_create_msg", r45);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("receive_battle_create_msg", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r45.toString())}));
    L108:
        this.m.b(new GuestBattleStateMachine.a.C0066a(r30));
        Qq(r30.getBattleStage());
        goto L125
    L78:
        if (r32.getBattleId() != r30.getBattleId()) goto L82;
        if (this.m.a().a() == false) goto L82;
        ALogger.e("[GuestBattle]GuestBattleWidget", "battle has created " + r30 + " current=" + Cq());
    L125:
        if ((r27 instanceof l9) == false) goto L152;
        l9 r1 = (l9) r27;
        if (Intrinsics.areEqual(r1.getWrdsSubKeyFlex(), "ChestGameSubSyncKey") == false) goto L153;
        List r46 = r1.getLinkmicChestGameStatusList();
        if (r46 == null) goto L131;
        f9 r47 = (f9) ListProtector.get(r46, 0);
    L132:
        GuestBattleContext r48 = this.n;
        if (r48 == null) goto L137;
        com.bytedance.live.datacontext.n<f9> r49 = r48.getChestGameStatus();
        if (r49 == null) goto L137;
        r49.setValue(r47);
    L137:
        int r50 = this.s;
        if (r47 != null) goto L140;
    L141:
        DataCenter r51 = ((Widget) this).dataCenter;
        if (r51 == null) goto L144;
        r51.put("data_adjust_public_screen_for_subtitle", 0);
    L144:
        if (r47 != null) goto L146;
        int r52 = com.bytedance.android.livesdk.message.model.f2.a;
        int r53 = 0;
    L147:
        this.s = r53;
        return;
    L146:
        r53 = r47.a();
        goto L147
    L140:
        if (r50 != r47.a()) goto L141;
        return;
    L131:
        r47 = null;
        goto L132
    L153:
        return;
    L152:
        return;
    L17:
        r12 = new ArrayList();
        goto L18
    L7:
        r9 = "resume_msg";
        goto L13
    L8:
        r9 = "pause_msg";
        goto L13
    L9:
        r9 = "finish_msg";
        goto L13
    L10:
        r9 = "show_result_msg";
        goto L13
    L11:
        r9 = "update_msg";
        goto L13
    L12:
        r9 = "create_msg";
        goto L13
    L110:
        if ((r27 instanceof c1) == false) goto L125;
        c1 r54 = (c1) r27;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r55 = r54.getBattleInfo();
        boolean r56 = r54.crownUpgrade();
        d1 r57 = (d1) vh7.f.c(d1.class);
        r57.setCrownUpgrade(r56);
        if (r55 == null) goto L119;
        List r58 = r55.getRawResults();
        if (r58 == null) goto L117;
        List r59 = CollectionsKt.toList(r58);
        if (r59 == null) goto L117;
    L118:
        r55.setResults(r59);
        Gq(r55, r57);
    L117:
        r59 = new ArrayList();
    L119:
        ALogger.d("[GuestBattle]GuestBattleWidget", "onBattleScoreUpdateMsg.message:" + r54);
        if (r55 == null) goto L122;
        int r60 = r55.getBattleStage();
    L123:
        Qq(r60);
        goto L125
    L122:
        r60 = 0;
        goto L123
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r27) {
        Integer r1 = (Integer) r27.get("duration");
        Boolean r2 = (Boolean) r27.get("anchorEnable");
        Integer r3 = (Integer) r27.get("loserNum");
        Integer r4 = (Integer) r27.get("scoreType");
        Integer r0 = (Integer) r27.get("uiType");
        if (r1 == null) goto L27;
        if (r2 == null) goto L27;
        if (r3 == null) goto L27;
        if (r4 == null) goto L27;
        int r10 = r1.intValue();
        boolean r9 = r2.booleanValue();
        int r8 = r3.intValue();
        int r22 = r4.intValue();
        if (r0 == null) goto L11;
        int r7 = r0.intValue();
    L12:
        ALogger.i("[GuestBattle]GuestBattleWidget", "start guest battle duration=" + r10 + ",anchorEnable：" + r9);
        if (this.p == false) goto L15;
        ALogger.i("[GuestBattle]GuestBattleWidget", "start guest battle return, cause: isWaitingStartGuestBattle");
        return;
    L15:
        this.p = true;
        GuestBattleContext.a r5 = GuestBattleContext.Companion;
        if (r5.d() == false) goto L19;
        String r6 = "stop";
    L18:
        String r23 = r6;
        String r11 = this.r;
        long r24 = System.currentTimeMillis();
        MultiLinkEventModule r12 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        ALogger.d("GuestBattleFullLinkMonitor", "createGuestBattleApiRequest");
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.e r13 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d;
        r13.b = System.currentTimeMillis() - r13.a;
        r13.l.onNext(Unit.INSTANCE);
        int r15 = r7;
        bind(((LinkGuestBattleApi) com.bytedance.android.live.network.c.b().e(LinkGuestBattleApi.class)).openBattle(getRoom().getId(), r10, r9, r8, r22, r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(this, r24, r10, r8, r23, r9, r22, r15, r11), new w(this, r10, r8, r23, r9, r22, r15, r11, r24)));
        return;
    L19:
        GuestBattleContext r14 = r5.getContext();
        if (r14 != null) goto L22;
    L24:
        r6 = "new_game";
        goto L18
    L22:
        if (r14.getCurrentState() != 2) goto L24;
        r6 = "restart_game";
        goto L18
    L11:
        r7 = 0;
    L27:
        ALogger.e("[GuestBattle]GuestBattleWidget", "tryStartPlayMode failed, cause: invalid params");
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r2) {
        Integer r3 = (Integer) r2.get("reason");
        if (r3 == null) goto L6;
        Bq(r3.intValue());
        return;
    }

    public final void zq(long r3) {
        bind(((LinkGuestBattleApi) com.bytedance.android.live.network.c.b().e(LinkGuestBattleApi.class)).fetchGuestBattleConfig(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), c.a));
    }

    public static boolean yq(int r3, int r4) {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout() == 22) goto L5;
        return false;
    L5:
        if (r3 != 22) goto L10;
        if (e0.b(r4) == false) goto L10;
        return true;
    L10:
        if (e0.b(r3) == false) goto L14;
        if (r4 != 22) goto L14;
        return true;
    L14:
        if (r3 != 26) goto L19;
        if (r4 != 22) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    }

    public final void Aq(boolean r9, boolean r10) {
        Pair r0 = com.bytedance.android.livesdk.chatroom.interact.model.d0.a(5);
        Boolean r1 = (Boolean) r0.component1();
        Long r2 = (Long) r0.component2();
        if (r1.booleanValue() == true) goto L5;
    L19:
        ALogger.i("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [preEnterRoom] [fetchGuestBattleInfo] try fetch timeout=" + r9);
        setMGetPlayModeInfoDisposable(((LinkGuestBattleApi) com.bytedance.android.live.network.c.b().e(LinkGuestBattleApi.class)).getPlayModeInfo(getRoom().getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, System.currentTimeMillis(), r10, r9), new e(this, r9)));
        Disposable r11 = getMGetPlayModeInfoDisposable();
        if (r11 == null) goto L23;
        bind(r11);
        return;
    L23:
        return;
    L5:
        if (isAnchor() == true) goto L19;
        if (r9 == true) goto L19;
        DataCenter r3 = ((Widget) this).dataCenter;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r4 = null;
        if (r3 == null) goto L10;
        EnterRoomInfoResult r5 = (EnterRoomInfoResult) r3.get("data_room_enter_info", null);
    L11:
        if (r5 == null) goto L15;
        p2 r6 = r5.getLinkmicPlayModeInfo();
        if (r6 == null) goto L15;
        r4 = r6.getBattleInfo();
    L15:
        onPreEnterConsume(r5);
        if (r4 == null) goto L19;
        ALogger.i("[GuestBattle]GuestBattleWidget", "[preEnterRoom] has got fight info from enter info, no need to fetch again");
        return;
    L10:
        r5 = null;
        goto L11
    }

    public final void Gq(com.bytedance.android.livesdk.chatroom.model.interact.a0 r10, d1 r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r0 = r10.getBattleId();
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r2 = Cq();
        long r5 = 0;
        if (r2 != null) goto L7;
    L8:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r1 = Cq();
        if (r1 == null) goto L11;
        long r3 = r1.getBattleId();
    L13:
        if (r3 <= 0) goto L16;
        ALogger.e("[GuestBattle]GuestBattleWidget", "onBattleUpdateMsg not same battle, msg:" + r10 + " current:" + Cq());
        return;
    L16:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r4 = Cq();
        if (r4 == null) goto L20;
        r5 = r4.getCurrentTime();
    L20:
        if (r5 <= r10.getCurrentTime()) goto L23;
        ALogger.e("[GuestBattle]GuestBattleWidget", "onBattleUpdateMsg timestamp invalid, msg:" + r10 + " current:" + Cq());
        return;
    L23:
        GuestBattleStateMachine.c r6 = Eq();
        r6.getClass();
        if ((r6 instanceof GuestBattleStateMachine.c.C0068c) == true) goto L33;
        GuestBattleStateMachine.c r7 = Eq();
        r7.getClass();
        if ((r7 instanceof GuestBattleStateMachine.c.d) == true) goto L33;
        if (isAnchor() == true) goto L33;
        ii0.b r8 = ii0.b.a;
        String r9 = Eq().b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r10, "battleInfo");
        Intrinsics.checkNotNullParameter(r9, "currentState");
        if (ii0.b.l() == false) goto L33;
        JSONObject r12 = new JSONObject();
        r12.put("battle_info", r10);
        r12.put("current_state", r9);
        r8.o("update_msg_start_battle", r12);
    L33:
        ALogger.d("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [onBattleUpdateMsg] push IM battleInfo: " + r10 + ". updateContent: " + r11);
        GuestBattleContext r13 = GuestBattleContext.Companion.getContext();
        if (r13 == null) goto L38;
        com.bytedance.live.datacontext.m<Integer> r14 = r13.getOnlineLoserNum();
        if (r14 == null) goto L38;
        r14.setValue(Integer.valueOf((int) r10.getLoserNum()));
    L38:
        this.m.b(new GuestBattleStateMachine.a.l(r10));
        Qq(r10.getBattleStage());
        return;
    L11:
        r3 = 0;
        goto L13
    L7:
        if (r0 == r2.getBattleId()) goto L16;
        goto L8
    }

    public final void Iq(com.bytedance.android.livesdk.chatroom.model.interact.a0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "battleInfo");
        List r0 = r3.getRawResults();
        if (r0 == null) goto L6;
        List r1 = CollectionsKt.toMutableList(r0);
        if (r1 == null) goto L6;
    L7:
        r3.setResults(r1);
        if (r4 == false) goto L10;
        String r2 = "get_info_fallback";
    L11:
        r3.setSourceFrom(r2);
        ALogger.e("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# onFetchGuestBattleInfo battleInfo=" + r3 + " timeout=" + r4);
        Pq(r3);
        this.q = r3.getBattleStage();
        this.m.b(new GuestBattleStateMachine.a.e(r3));
        return;
    L10:
        r2 = "get_info";
    L6:
        r1 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget
    public final void onPreGetEnterInfo(EnterRoomInfoResult r4, boolean r5) {
        if (r4 == null) goto L9;
        p2 r1 = r4.getLinkmicPlayModeInfo();
        if (r1 == null) goto L9;
        vh7.c r2 = r1.getBattleInfo();
        if (r2 == null) goto L9;
        vh7.c r3 = jm2.a.d(r2);
    L11:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.model.interact.a0) == true) goto L13;
        r3 = null;
    L13:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r6 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) r3;
        if (r6 != null) goto L16;
        return;
    L16:
        if (r5 == false) goto L18;
        ALogger.i("PlayMode_PreEnter_Listen", "onAsyncGetEnterInfo--嘉宾作战命中预加载异步到达");
    L19:
        onPreGetEnterInfoUniversal(5);
        Iq(r6, false);
        p2 r7 = r4.getLinkmicPlayModeInfo();
        if (r7 == null) goto L24;
        r7.setBattleInfo(null);
        return;
    L24:
        return;
    L18:
        ALogger.i("PlayMode_PreEnter_Listen", "onAsyncGetEnterInfo--嘉宾作战命中预加载提前到达");
    L9:
        r3 = null;
        goto L11
    }

    public static final void wq(GuestBattleWidget r2, String r3, JsonObject r4) {
        r2.getClass();
        JsonObject r0 = new JsonObject();
        if (r4 == null) goto L5;
        r0.add("data", r4);
    L5:
        ih0.b r5 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) r2).dataCenter);
        if (r5 == null) goto L9;
        r5.Dk("guest_battle", r3, r0, false);
        return;
    }

    public final void Jq(com.bytedance.android.livesdk.chatroom.model.interact.a0 r7, boolean r8, boolean r9) {
        if (r9 == true) goto L4;
        this.k = System.currentTimeMillis();
    L4:
        this.h = System.currentTimeMillis();
        GuestBattleContext r10 = this.n;
        if (r10 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r11 = r10.getBattleState();
        if (r11 == null) goto L9;
        r11.setValue(1);
    L9:
        GuestBattleContext r12 = this.n;
        if (r12 == null) goto L14;
        com.bytedance.live.datacontext.m<Long> r13 = r12.getBattleStartTime();
        if (r13 == null) goto L14;
        r13.setValue(Long.valueOf(r7.getCurrentTime() / ((long) 1000)));
    L14:
        xq();
        if (r8 == false) goto L18;
        Nq(r7);
    L18:
        if (isAnchor() == true) goto L33;
        if (Intrinsics.areEqual(r7.getSourceFrom(), "create_msg") == false) goto L23;
    L24:
        boolean r14 = ii0.a.b;
        long r1 = r7.getBattleId();
        Integer r15 = Integer.valueOf(r7.getMode());
        HashMap r3 = new HashMap();
        r3.put("user_cnt", String.valueOf(je0.d.S()));
        if (r15 != null) goto L28;
    L30:
        String r16 = "bomb";
    L31:
        r3.put("game_name", r16);
        r3.put("game_id", String.valueOf(r1));
        TalkRoomLogUtils.B0(r3, null, null, 6);
        ii0.a.c(r3, true);
        j0.l().sendLog("livesdk_connection_game_transform", r3, new Object[]{IRoom.class});
        goto L33
    L28:
        if (r15.intValue() != 1) goto L30;
        r16 = "mvp";
        goto L31
    L23:
        if (Intrinsics.areEqual(r7.getSourceFrom(), "update_msg") == true) goto L24;
    L33:
        if (getRoom().isLiveTypeAudio() == false) goto L35;
        this.l = ((Number) ((Widget) this).dataCenter.get("data_room_audio_chat_ui_layout", Integer.valueOf(je0.d.o()))).intValue();
    L35:
        Pq(r7);
        ((Widget) this).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.d0
    public final String xp(int r3, boolean r4, int r5, int r6, int r7) {
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.f();
        HashMap<String, Object> r0 = new HashMap();
        r0.put("duration", Integer.valueOf(r3));
        r0.put("anchorEnable", Boolean.valueOf(r4));
        r0.put("loserNum", Integer.valueOf(r5));
        r0.put("scoreType", Integer.valueOf(r6));
        r0.put("uiType", Integer.valueOf(r7));
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r8 = MultiRevenueDataContext.a.d();
        if (r8 == null) goto L5;
        xh0.g r9 = r8.h(5, r0);
    L6:
        if (r9 != null) goto L8;
        return "";
    L8:
        if (r9.c == true) goto L16;
        String r10 = r9.d;
        if (r10 != null) goto L15;
        return "playModeService";
    L15:
        return r10;
    L16:
        return "";
    L5:
        r9 = null;
        goto L6
    }
}
