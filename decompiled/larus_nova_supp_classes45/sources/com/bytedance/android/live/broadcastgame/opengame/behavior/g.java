package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.config.ve;
import com.bytedance.android.livesdk.config.x20;
import com.bytedance.android.livesdk.message.model.e0;
import com.bytedance.android.livesdk.message.model.hn;
import com.bytedance.android.livesdk.message.model.mh;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.model.WtnPlayEvent;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends a0 {
    public static final /* synthetic */ int m = 0;
    public Room f;
    public f0 g;
    public final CompositeDisposable h;
    public com.bytedance.android.live.broadcastgame.xplay.screendetect.a i;
    public Disposable j;
    public final DataCenter k;
    public final Context l;

    public static final class a implements ToolbarComponentCheckInterface {
        public final /* synthetic */ g a;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.behavior.g$a$a, reason: collision with other inner class name */
        public static final class C0058a<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ Function1 b;
            public final /* synthetic */ Function0 c;
            public final /* synthetic */ long d;
            public final /* synthetic */ ToolbarMatchInterface e;

            public C0058a(a r1, Function1 r2, Function0 r3, long r4, ToolbarMatchInterface r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r6;
            }

            public final void accept(Object r13) {
                f0 r14 = (f0) r13;
                if (r14 == null) goto L37;
                g.q(this.a.a, r14);
                this.a.a.getClass();
                if (tb1.c.a == true) goto L7;
                int r15 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"not support game type"});
                this.b.invoke("not support game type");
                return;
            L7:
                int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"start show toolbar icon, business type: " + r14.q + ", hideUserEntrance: " + r14.x});
                this.a.a.g = r14;
                if (Intrinsics.areEqual(r14.y, Boolean.TRUE) == false) goto L12;
                Disposable r1 = this.a.a.j;
                if (r1 == null) goto L14;
                r1.dispose();
            L14:
                if (r14.x == true) goto L32;
                this.a.a.k.put("revenue_interact", Boolean.valueOf(r14.A));
                this.c.invoke();
                long r2 = SystemClock.elapsedRealtime() - this.d;
                OpenPlatformMonitorUtils r6 = OpenPlatformMonitorUtils.c;
                g r3 = this.a.a;
                r6.k(r3.u(r3.g), this.a.a.v(), r2, this.e.isPreloadScene());
                String r4 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
                com.bytedance.android.live.broadcastgame.opengame.service.e.e(Long.valueOf(r14.f), r14.i, r14.n, null);
                g r5 = this.a.a;
                r5.getClass();
                if (((Boolean) x20.a.getValue()).booleanValue() == true) goto L39;
            L20:
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).cacheEntranceVisibility(r14.a, 1);
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).consumeCacheOpenPlatformMessage(r14.a, this.a.a.k);
                g r7 = this.a.a;
                int r8 = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.c;
                Room r9 = r7.f;
                if (r9 == null) goto L23;
                long r11 = r9.getRoomId();
            L24:
                Room r12 = this.a.a.f;
                if (r12 == null) goto L28;
                String r16 = r12.getOwnerUserIdString();
                if (r16 == null) goto L28;
            L29:
                r7.i = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.C0106a.a(new com.bytedance.android.live.broadcastgame.xplay.screendetect.c(false, r11, r16, r14.f, r14.a, r14.i));
                com.bytedance.android.live.broadcastgame.xplay.screendetect.a r17 = this.a.a.i;
                if (r17 == null) goto L32;
                r17.g();
            L28:
                r16 = "";
                goto L29
            L23:
                r11 = 0;
                goto L24
            L39:
                ThreadPoolHelper.d().execute(new q(r5, r2));     // Catch: Exception -> L19
            L32:
                AudienceGameContext.Companion.getClass();
                AudienceGameContext r18 = AudienceGameContext.a.a();
                if (r18 == null) goto L42;
                com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r19 = r18.getAnchorCurrentGameIconInfo();
                if (r19 == null) goto L43;
                r19.setValue(new com.bytedance.android.live.broadcastgame.api.model.h(r14.a, r14.i, r14.j));
                return;
            L43:
                return;
            L42:
                return;
            L12:
                g.r(this.a.a);
                goto L14
            L37:
                this.b.invoke("ENTRANCE_INVISIBLE");
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ Function1 b;

            public b(a r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.k("MiniGameComponentConfig", new Object[]{"load small rocker fail, " + ((Throwable) r4)});
                this.b.invoke("ENTRANCE_INVISIBLE");
                IInteractGameService r5 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                f0 r1 = this.a.a.g;
                String r2 = "";
                if (r1 == null) goto L6;
                String r3 = r1.a;
                if (r3 == null) goto L6;
            L7:
                r5.cacheEntranceVisibility(r3, 0);
                IInteractGameService r6 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                g r7 = this.a.a;
                f0 r8 = r7.g;
                if (r8 == null) goto L13;
                String r9 = r8.a;
                if (r9 == null) goto L13;
                r2 = r9;
            L13:
                r6.consumeCacheOpenPlatformMessage(r2, r7.k);
                return;
            L6:
                r3 = "";
                goto L7
            }
        }

        public a(g r1) {
            this.a = r1;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r11, Function0<Unit> r12, Function1<? super String, Unit> r13) {
            Intrinsics.checkNotNullParameter(r11, "model");
            Intrinsics.checkNotNullParameter(r12, "loadButton");
            Intrinsics.checkNotNullParameter(r13, "stopLoadCallback");
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"prepare load small rocker on toolbar, this=" + this.a + ", pre=" + r11.isPreloadScene()});
            if (r11.isPreloadScene() == false) goto L6;
            g r1 = this.a;
            r1.getClass();
            RxUtilKt.c(r1.t(r11, r11.isPreloadScene()).subscribe(new m(r1, r12, r13), new n(r13)), r1.h);
            return true;
        L6:
            RxUtilKt.c(this.a.t(r11, r11.isPreloadScene()).subscribe(new C0058a(this, r13, r12, SystemClock.elapsedRealtime(), r11), new b(this, r13)), this.a.h);
            return true;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ g a;
        public final /* synthetic */ Observer b;

        public b(g r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            Lazy r0 = ToolbarComponentCheckManager.a;
            ToolbarComponentCheckManager.g(this.a.k, NewToolbarButtonConstants.MiniGame.INSTANCE);
            this.a.k.removeObserver("cmd_specific_behavior_un_loaded", this.b);
            this.a.k.removeObserver("data_link_state", this.b);
        }
    }

    public static final class c {
    }

    public static final class d<T> implements ObservableOnSubscribe {
        public final /* synthetic */ g a;
        public final /* synthetic */ ToolbarMatchInterface b;
        public final /* synthetic */ boolean c;

        public d(g r1, ToolbarMatchInterface r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(ObservableEmitter<e0> r6) {
            Intrinsics.checkNotNullParameter(r6, "emitter");
            String r0 = this.b.getComponentExtra();
            int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"receive toolbar message, " + r0});
            Object r2 = null;
            if (this.c == false) goto L54;
            this.a.getClass();
            Type r3 = new j().getType();
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
            Object r5 = Result.constructor-impl((List) GsonHelper.get().fromJson(r0, r3));     // Catch: Throwable -> L7
        L10:
            if (Result.isFailure-impl(r5) == false) goto L12;
            r5 = null;
        L12:
            List r7 = (List) r5;
            if (r7 != null) goto L15;
            r7 = CollectionsKt.emptyList();
        L15:
            RoomStampInfo r8 = (RoomStampInfo) CollectionsKt.firstOrNull(r7);
            if (r8 == null) goto L48;
            e0 r9 = new e0();
            r9.appId = r8.getId();
            Gson r11 = GsonHelper.get();     // Catch: Throwable -> L26
            String r12 = r8.getEntrances();     // Catch: Throwable -> L26
            if (r12 != null) goto L21;
            r12 = "";
        L21:
            e0 r13 = (e0) r11.fromJson(r12, e0.class);     // Catch: Throwable -> L26
            e0 r14 = r13;
            if (r13 != null) goto L24;
            r14 = r9;
        L24:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L26
        L28:
            Object r16 = r9;
            if (Result.isFailure-impl(r15) == true) goto L32;
            r16 = r15;
        L32:
            r2 = (e0) r16;
        L26:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
        L48:
            if (r2 == null) goto L50;
            r6.onNext(r2);
            return;
        L50:
            r6.onError(new Exception("invalid extras, " + r0));
            return;
        L7:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        L54:
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L41
            mh r21 = (mh) GsonHelper.get().fromJson(r0, mh.class);     // Catch: Throwable -> L41
            if (r21 == null) goto L38;
            List r22 = r21.entrances;     // Catch: Throwable -> L41
            if (r22 == null) goto L38;
            e0 r23 = (e0) CollectionsKt.firstOrNull(r22);     // Catch: Throwable -> L41
        L39:
            Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L41
        L44:
            if (Result.isFailure-impl(r24) == true) goto L47;
            r2 = r24;
        L47:
            r2 = (e0) r2;
        L38:
            r23 = null;
        L41:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r24 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L44
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ g a;
        public final /* synthetic */ boolean b;

        public e(g r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            e0 r7 = (e0) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            int r0 = r7.visibleType;
            int r1 = hn.a;
            if (r0 != 1) goto L8;
            f0 r2 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r7, this.b ? 1 : 0);
            if (r2 == null) goto L10;
            com.bytedance.revenue.platform.api.core.rx.l r8 = com.bytedance.revenue.platform.api.core.rx.l.a;
            return Observable.just(r2);
        L10:
            int r3 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"request entrance visible v2, entranceExtra: " + r7.entranceExtra + ", extra: " + r7.extra});
            long r4 = SystemClock.elapsedRealtime();
            AudienceGameNetApi r5 = (AudienceGameNetApi) com.bytedance.android.live.network.c.b().e(AudienceGameNetApi.class);
            Room r9 = this.a.f;
            if (r9 == null) goto L13;
            long r11 = r9.getRoomId();
        L14:
            String r12 = r7.appId;
            if (r12 != null) goto L18;
            r12 = "";
        L18:
            return r5.getEntranceVisibleV2(r11, r12).compose(RxUtil.rxSchedulerHelper()).map(new h(this, r4)).doOnError(new i(this, r4));
        L13:
            r11 = 0;
            goto L14
        L8:
            if (r0 != 3) goto L10;
            com.bytedance.revenue.platform.api.core.rx.l r13 = com.bytedance.revenue.platform.api.core.rx.l.a;
            return Observable.error(new Exception("name: " + r7.name + ", visible type: " + r7.visibleType));
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ g a;

        public f(g r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            KVData r7 = (KVData) r6;
            if (Intrinsics.areEqual(r7.getKey(), "cmd_specific_behavior_un_loaded") == false) goto L22;
            ToolbarBehaviorData r8 = (ToolbarBehaviorData) r7.getData();
            if (r8 != null) goto L7;
            return;
        L7:
            if (r8.getId() == 6) goto L9;
            return;
        L9:
            if (r8.isFold() == true) goto L32;
            int r9 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"receive unload icon event"});
            f0 r0 = this.a.g;
            if (r0 == null) goto L20;
            r0.r = 2;
            g.s();
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"clear resource"});
            g.q(this.a, r0);
            this.a.k.put("revenue_interact", Boolean.FALSE);
            ((IInteractGameService) jc1.k.n(IInteractGameService.class)).clearCache();
            OpenPlatformMonitorUtils.c.h(this.a.u(r0), this.a.v());
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r11 = AudienceGameContext.a.a();
            if (r11 == null) goto L17;
            com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r12 = r11.getAnchorCurrentGameIconInfo();
            if (r12 == null) goto L17;
            r12.setValue(null);
        L17:
            com.bytedance.android.live.broadcastgame.xplay.screendetect.a r13 = this.a.i;
            if (r13 == null) goto L20;
            r13.f();
        L20:
            this.a.g = null;
            return;
        L32:
            return;
        L22:
            if (Intrinsics.areEqual(r7.getKey(), "data_link_state") == false) goto L34;
            Integer r14 = (Integer) r7.getData();
            if (r14 != null) goto L27;
            r14 = 0;
        L27:
            if (r14.intValue() != 32) goto L35;
            this.a.getClass();
            g.s();
            return;
        L35:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.behavior.g$g, reason: collision with other inner class name */
    public static final class C0059g extends b7.a {
        public C0059g() {
        }

        public final boolean onFallback(int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMessage");
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("MiniGameComponentConfig", new Object[]{"show magic box lynx dialog failed, errorCode: " + r4 + ", errorMesage: " + r5});
            return super.onFallback(r4, r5);
        }
    }

    static {
    }

    public final w j() {
        return new w(ToolbarButton.OPEN_PLATFORM_MINI_GAME, null, null, null);
    }

    public final boolean m() {
        if (((Boolean) oz0.a.getValue()).booleanValue() == false) goto L6;
        return false;
    L6:
        return super.m();
    }

    public final void p() {
        if (((Boolean) oz0.a.getValue()).booleanValue() == false) goto L15;
        s();
        Disposable r0 = this.j;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        CompositeDisposable r1 = this.h;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        this.f = null;
        this.g = null;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r2 = this.i;
        if (r2 == null) goto L13;
        r2.f();
    L13:
        this.i = null;
        return;
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.e v() {
        return new com.bytedance.android.live.broadcastgame.api.openplatform.e(this.f, "audience", 12);
    }

    public final void w() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"show magic box lynx dialog"});
        f0 r1 = this.g;
        Long r4 = null;
        if (r1 == null) goto L5;
        String r2 = r1.B;
    L6:
        if (r2 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        r2 = (String) ve.a.getValue();
    L14:
        if (r2 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
    L50:
        com.bytedance.android.live.broadcastgame.opengame.q.e("MiniGameComponentConfig", new Object[]{"show magic box lynx dialog failed, entranceMessage: " + this.g + ", url: " + r2});
        return;
    L22:
        if (this.g == null) goto L50;
        u6 r7 = new u6(r2);
        u6 r3 = r7.d(LiveSlardarConstants.EXTRA_KEY_URL);
        f0 r8 = this.g;
        String r9 = "";
        if (r8 == null) goto L28;
        String r11 = r8.a;
        if (r11 == null) goto L28;
    L29:
        r3.b("mini_app_id", r11);
        f0 r12 = this.g;
        if (r12 != null) goto L32;
    L41:
        Uri r13 = r7.c();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L44
        Object r15 = Result.constructor-impl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(this.l, r13, new C0059g()));     // Catch: Throwable -> L44
    L46:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L54;
        int r17 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("MiniGameComponentConfig", new Object[]{"Magic box lynx start failed, cause: " + r16.getCause() + ", message: " + r16.getMessage()});
        return;
    L54:
        return;
    L44:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L32:
        if (r12.A != true) goto L41;
        boolean r19 = com.bytedance.android.live.revenue.core.util.h.a;
        p11.j r21 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevenueLinkDataHolder();
        if (r21 == null) goto L36;
        r4 = Long.valueOf(r21.getChannelId());
    L36:
        String r22 = String.valueOf(r4.longValue());
        if (r22 == null) goto L40;
        r9 = r22;
    L40:
        r3.b("channel_id", r9);
    L28:
        r11 = "";
        goto L29
    L16:
        if (r2.length() == 0) goto L19;
        r6 = false;
        goto L20
    L8:
        if (r2.length() == 0) goto L11;
        r5 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static void s() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L7;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L7;
        MutableLiveData r2 = r1.getWtnPlayEvent();
    L8:
        if (r2 == null) goto L17;
        WtnPlayEvent r3 = (WtnPlayEvent) r2.getValue();
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.getState() != WtnPlayEvent.Companion.getSTATE_PLAYING()) goto L19;
        ILivePlayerClient r4 = LivePlatformPlayerManager.f();
        if (r4 == null) goto L20;
        r4.closeWtnPlay();
        return;
    L20:
        return;
    L19:
        return;
    L17:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final Context getContext() {
        return this.l;
    }

    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.MiniGame.INSTANCE;
    }

    public static final void r(g r3) {
        r3.getClass();
        r3.j = xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class).subscribe(new p(new MiniGameComponentConfig$registerShowPanelEvent$1(r3)), new o(r3));
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.d u(f0 r5) {
        if (r5 != null) goto L15;
        f0 r6 = this.g;
        String r1 = null;
        if (r6 == null) goto L7;
        String r2 = r6.a;
    L8:
        if (r6 == null) goto L10;
        String r3 = r6.i;
    L11:
        if (r6 == null) goto L14;
        r1 = r6.h;
    L14:
        return new com.bytedance.android.live.broadcastgame.api.openplatform.d(r2, r3, r1);
    L10:
        r3 = null;
        goto L11
    L7:
        r2 = null;
        goto L8
    L15:
        return new com.bytedance.android.live.broadcastgame.api.openplatform.d(r5.a, r5.i, r5.h);
    }

    public g(DataCenter r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "context");
        Room r1 = null;
        super(null, null, 7);
        this.k = r5;
        this.l = r6;
        if (((Boolean) oz0.a.getValue()).booleanValue() == false) goto L11;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r7 == null) goto L9;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L9;
        r1 = (Room) r8.getValue();
    L9:
        this.f = r1;
        CompositeDisposable r9 = new CompositeDisposable();
        this.h = r9;
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r5, NewToolbarButtonConstants.MiniGame.INSTANCE, new a(this));
        f r2 = new f(this);
        r5.observe("cmd_specific_behavior_un_loaded", r2);
        r5.observe("data_link_state", r2);
        RxUtilKt.c(Disposables.fromAction(new b(this, r2)), r9);
        return;
    }

    public static final void q(g r11, f0 r12) {
        r11.getClass();
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"receive entrance msg from anchor, name: ", r12.i, ", appId: ", r12.a, ", status: ", Integer.valueOf(r12.r)});
        if (r12.r != 1) goto L5;
        boolean r1 = true;
    L6:
        Object r2 = bi1.a(Boolean.valueOf(r1), NewBroadcastMonitor.STAGE.START);
        if (r2 != null) goto L9;
        r2 = NewBroadcastMonitor.STAGE.STOP;
    L9:
        String r8 = (String) r2;
        if (r12.u != 1) goto L12;
        boolean r7 = true;
    L13:
        OpenPlatformMonitorUtils.c.n(r11.u(r12), r11.v(), r7, r8, r12.t);
        InteractGameContext r13 = InteractGameContext.Companion.getContext();
        if (r13 == null) goto L19;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i> r14 = r13.getGameOpenInfo();
        if (r14 == null) goto L20;
        r14.setValue(new com.bytedance.android.live.broadcastgame.api.model.i(r12.a, r12.f, r12.i, r12.C, r12.D));
        return;
    L20:
        return;
    L19:
        return;
    L12:
        r7 = false;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public final Observable<f0> t(ToolbarMatchInterface r5, boolean r6) {
        if (r5.getSource() != 0) goto L5;
        boolean r0 = true;
    L6:
        OpenPlatformMonitorUtils.c.j(u(this.g), v(), r0, r6);
        com.bytedance.revenue.platform.api.core.rx.l r7 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return Observable.create(new d(this, r5, r0)).flatMap(new e(this, r0));
    L5:
        r0 = false;
        goto L6
    }

    public final c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "button");
        return new MiniGameToolbarBehavior();
    }
}
