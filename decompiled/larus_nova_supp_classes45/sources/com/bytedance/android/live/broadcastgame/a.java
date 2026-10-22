package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.config.ve;
import com.bytedance.android.livesdk.config.x20;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.WtnPlayEvent;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements k0 {
    public static final /* synthetic */ int i = 0;
    public Room a;
    public com.bytedance.android.live.broadcastgame.opengame.message.f0 b;
    public final CompositeDisposable c;
    public com.bytedance.android.live.broadcastgame.xplay.screendetect.a d;
    public Disposable e;
    public Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> f;
    public final Context g;
    public final DataCenter h;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.a$a, reason: collision with other inner class name */
    public static final class C0051a implements ToolbarComponentCheckInterface {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.a$a$a, reason: collision with other inner class name */
        public static final class C0052a<T> implements Consumer {
            public final /* synthetic */ C0051a a;
            public final /* synthetic */ Function1 b;
            public final /* synthetic */ Function0 c;
            public final /* synthetic */ long d;

            public C0052a(C0051a r1, Function1 r2, Function0 r3, long r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void accept(Object r13) {
                com.bytedance.android.live.broadcastgame.opengame.message.f0 r14 = (com.bytedance.android.live.broadcastgame.opengame.message.f0) r13;
                if (r14 == null) goto L41;
                a.b(this.a.a, r14);
                this.a.a.getClass();
                if (tb1.c.a == true) goto L7;
                int r15 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"not support game type"});
                this.b.invoke("not support game type");
                return;
            L7:
                int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"start show toolbar icon, business type: " + r14.q + ", hideUserEntrance: " + r14.x});
                this.a.a.b = r14;
                if (Intrinsics.areEqual(r14.y, Boolean.TRUE) == false) goto L16;
                Disposable r1 = this.a.a.e;
                if (r1 == null) goto L12;
                r1.dispose();
            L12:
                Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r2 = this.a.a.f;
                if (r2 != null) goto L15;
                Intrinsics.throwUninitializedPropertyAccessException("sonicPluginMessageReceiver");
            L15:
                r2.invoke(r14);
            L18:
                if (r14.x == true) goto L36;
                this.a.a.h.put("revenue_interact", Boolean.valueOf(r14.A));
                this.c.invoke();
                long r3 = SystemClock.elapsedRealtime() - this.d;
                OpenPlatformMonitorUtils r4 = OpenPlatformMonitorUtils.c;
                a r5 = this.a.a;
                OpenPlatformMonitorUtils.c.k(r5.e(r5.b), this.a.a.f(), r3, false);
                String r6 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
                com.bytedance.android.live.broadcastgame.opengame.service.e.e(Long.valueOf(r14.f), r14.i, r14.a, r14.n);
                a r7 = this.a.a;
                r7.getClass();
                if (((Boolean) x20.a.getValue()).booleanValue() == true) goto L43;
            L24:
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).cacheEntranceVisibility(r14.a, 1);
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).consumeCacheOpenPlatformMessage(r14.a, this.a.a.h);
                a r8 = this.a.a;
                int r9 = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.c;
                Room r11 = r8.a;
                if (r11 == null) goto L27;
                long r12 = r11.getRoomId();
            L28:
                Room r16 = this.a.a.a;
                if (r16 == null) goto L32;
                String r17 = r16.getOwnerUserIdString();
                if (r17 == null) goto L32;
            L33:
                r8.d = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.C0106a.a(new com.bytedance.android.live.broadcastgame.xplay.screendetect.c(false, r12, r17, r14.f, r14.a, r14.i));
                com.bytedance.android.live.broadcastgame.xplay.screendetect.a r18 = this.a.a.d;
                if (r18 == null) goto L36;
                r18.g();
            L32:
                r17 = "";
                goto L33
            L27:
                r12 = 0;
                goto L28
            L43:
                ThreadPoolHelper.d().execute(new k(r7, r3));     // Catch: Exception -> L23
            L36:
                AudienceGameContext.Companion.getClass();
                AudienceGameContext r19 = AudienceGameContext.a.a();
                if (r19 == null) goto L46;
                com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r21 = r19.getAnchorCurrentGameIconInfo();
                if (r21 == null) goto L47;
                r21.setValue(new com.bytedance.android.live.broadcastgame.api.model.h(r14.a, r14.i, r14.j));
                return;
            L47:
                return;
            L46:
                return;
            L16:
                a.c(this.a.a);
                goto L18
            L41:
                this.b.invoke("ENTRANCE_INVISIBLE");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.a$a$b */
        public static final class b<T> implements Consumer {
            public final /* synthetic */ C0051a a;
            public final /* synthetic */ Function1 b;

            public b(C0051a r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.k("MagicBoxBehaviorV2", new Object[]{"load small rocker fail, " + ((Throwable) r4)});
                this.b.invoke("ENTRANCE_INVISIBLE");
                IInteractGameService r5 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                com.bytedance.android.live.broadcastgame.opengame.message.f0 r1 = this.a.a.b;
                String r2 = "";
                if (r1 == null) goto L6;
                String r3 = r1.a;
                if (r3 == null) goto L6;
            L7:
                r5.cacheEntranceVisibility(r3, 0);
                IInteractGameService r6 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                a r7 = this.a.a;
                com.bytedance.android.live.broadcastgame.opengame.message.f0 r8 = r7.b;
                if (r8 == null) goto L13;
                String r9 = r8.a;
                if (r9 == null) goto L13;
                r2 = r9;
            L13:
                r6.consumeCacheOpenPlatformMessage(r2, r7.h);
                return;
            L6:
                r3 = "";
                goto L7
            }
        }

        public C0051a(a r1) {
            this.a = r1;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r11, Function0<Unit> r12, Function1<? super String, Unit> r13) {
            Intrinsics.checkNotNullParameter(r11, "model");
            Intrinsics.checkNotNullParameter(r12, "loadButton");
            Intrinsics.checkNotNullParameter(r13, "stopLoadCallback");
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"prepare load small rocker on toolbar, this=" + this.a + ", pre=" + r11.isPreloadScene()});
            long r8 = SystemClock.elapsedRealtime();
            a r1 = this.a;
            r1.getClass();
            if (r11.getSource() != 0) goto L5;
            boolean r2 = true;
        L6:
            OpenPlatformMonitorUtils.c.j(r1.e(r1.b), r1.f(), r2, false);
            com.bytedance.revenue.platform.api.core.rx.l r3 = com.bytedance.revenue.platform.api.core.rx.l.a;
            RxUtilKt.c(Observable.create(new com.bytedance.android.live.broadcastgame.b(r1, r11, r2)).flatMap(new com.bytedance.android.live.broadcastgame.e(r1, r2)).subscribe(new C0052a(this, r13, r12, r8), new b(this, r13)), this.a.c);
            return true;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ a a;
        public final /* synthetic */ Observer b;

        public b(a r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            Lazy r0 = ToolbarComponentCheckManager.a;
            ToolbarComponentCheckManager.g(this.a.h, NewToolbarButtonConstants.MiniGame.INSTANCE);
            this.a.h.removeObserver("cmd_specific_behavior_un_loaded", this.b);
        }
    }

    public static final class c {
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            KVData r7 = (KVData) r6;
            ToolbarBehaviorData r0 = (ToolbarBehaviorData) r7.getData();
            if (Intrinsics.areEqual(r7.getKey(), "cmd_specific_behavior_un_loaded") == false) goto L24;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.getId() == 6) goto L8;
            return;
        L8:
            if (r0.isFold() == true) goto L27;
            int r8 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"receive unload icon event"});
            com.bytedance.android.live.broadcastgame.opengame.message.f0 r1 = this.a.b;
            if (r1 == null) goto L22;
            r1.r = 2;
            a.d();
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"clear resource"});
            a.b(this.a, r1);
            this.a.h.put("revenue_interact", Boolean.FALSE);
            Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r9 = this.a.f;
            if (r9 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("sonicPluginMessageReceiver");
        L14:
            r9.invoke(r1);
            ((IInteractGameService) jc1.k.n(IInteractGameService.class)).clearCache();
            OpenPlatformMonitorUtils.c.h(this.a.e(r1), this.a.f());
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r11 = AudienceGameContext.a.a();
            if (r11 == null) goto L19;
            com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r12 = r11.getAnchorCurrentGameIconInfo();
            if (r12 == null) goto L19;
            r12.setValue(null);
        L19:
            com.bytedance.android.live.broadcastgame.xplay.screendetect.a r13 = this.a.d;
            if (r13 == null) goto L22;
            r13.f();
        L22:
            this.a.b = null;
            return;
        L27:
            return;
        }
    }

    public static final class e extends b7.a {
        public e() {
        }

        public final boolean onFallback(int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMessage");
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehaviorV2", new Object[]{"show magic box lynx dialog failed, errorCode: " + r4 + ", errorMesage: " + r5});
            return super.onFallback(r4, r5);
        }
    }

    static {
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.e f() {
        return new com.bytedance.android.live.broadcastgame.api.openplatform.e(this.a, "audience", 12);
    }

    public final void g() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"show magic box lynx dialog"});
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r1 = this.b;
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
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehaviorV2", new Object[]{"show magic box lynx dialog failed, entranceMessage: " + this.b + ", url: " + r2});
        return;
    L22:
        if (this.b == null) goto L50;
        u6 r7 = new u6(r2);
        u6 r3 = r7.d(LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r8 = this.b;
        String r9 = "";
        if (r8 == null) goto L28;
        String r11 = r8.a;
        if (r11 == null) goto L28;
    L29:
        r3.b("mini_app_id", r11);
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r12 = this.b;
        if (r12 != null) goto L32;
    L41:
        Uri r13 = r7.c();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L44
        Object r15 = Result.constructor-impl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(this.g, r13, new e()));     // Catch: Throwable -> L44
    L46:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L54;
        int r17 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehaviorV2", new Object[]{"Magic box lynx start failed, cause: " + r16.getCause() + ", message: " + r16.getMessage()});
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

    @Override // com.bytedance.android.live.broadcastgame.k0
    public final void onDestroy() {
        if (((Boolean) oz0.a.getValue()).booleanValue() == true) goto L15;
        d();
        Disposable r0 = this.e;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        CompositeDisposable r1 = this.c;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        this.a = null;
        this.b = null;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r2 = this.d;
        if (r2 == null) goto L13;
        r2.f();
    L13:
        this.d = null;
        return;
    }

    public static void d() {
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
        return this.g;
    }

    public static final void c(a r3) {
        r3.getClass();
        r3.e = xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class).subscribe(new j(new AudienceInteractPlayBehavior$registerShowPanelEvent$1(r3)), new i(r3));
    }

    @Override // com.bytedance.android.live.broadcastgame.k0
    public final void a(Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.f = r2;
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.d e(com.bytedance.android.live.broadcastgame.opengame.message.f0 r5) {
        if (r5 != null) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r6 = this.b;
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

    public a(Context r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        this.g = r7;
        this.h = r8;
        if (((Boolean) oz0.a.getValue()).booleanValue() == true) goto L24;
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r4 = RoomContext.a.c(r0, r8, 0, 2);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r5 = null;
        if (r4 == null) goto L9;
        com.bytedance.live.datacontext.m r6 = r4.getRoom();
        if (r6 == null) goto L9;
        Room r9 = (Room) r6.getValue();
    L10:
        this.a = r9;
        CompositeDisposable r11 = new CompositeDisposable();
        this.c = r11;
        RoomContext r1 = RoomContext.a.c(r0, r8, 0, 2);
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.j r2 = r1.getTbCompConfigRegister();
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o) r2.getValue();
    L17:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o) == false) goto L20;
        r5 = r3;
    L20:
        if (r5 == null) goto L22;
        r5.register(new com.bytedance.android.live.broadcastgame.opengame.behavior.g(r8, r7));
    L22:
        Lazy r12 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r8, NewToolbarButtonConstants.MiniGame.INSTANCE, new C0051a(this));
        d r13 = new d(this);
        r8.observe("cmd_specific_behavior_un_loaded", r13);
        RxUtilKt.c(Disposables.fromAction(new b(this, r13)), r11);
        return;
    L15:
        r3 = null;
    L9:
        r9 = null;
        goto L10
    }

    public static final void b(a r11, com.bytedance.android.live.broadcastgame.opengame.message.f0 r12) {
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
        OpenPlatformMonitorUtils.c.n(r11.e(r12), r11.f(), r7, r8, r12.t);
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
}
