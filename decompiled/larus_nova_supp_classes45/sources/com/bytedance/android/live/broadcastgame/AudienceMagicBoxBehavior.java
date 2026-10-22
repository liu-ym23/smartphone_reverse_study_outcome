package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.config.ve;
import com.bytedance.android.livesdk.message.model.mh;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
public final class AudienceMagicBoxBehavior implements k0, vlc.l {
    public static final /* synthetic */ int k = 0;
    public Room a;
    public vlc.d b;
    public com.bytedance.android.live.broadcastgame.opengame.message.f0 c;
    public final CompositeDisposable d;
    public com.bytedance.android.live.broadcastgame.xplay.screendetect.a e;
    public Disposable f;
    public Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> g;
    public long h;
    public final Context i;
    public final DataCenter j;

    public static final class a implements ToolbarComponentCheckInterface {
        public final /* synthetic */ AudienceMagicBoxBehavior a;

        public a(AudienceMagicBoxBehavior r1) {
            this.a = r1;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r9, final Function0<Unit> r11, final Function1<? super String, Unit> r12) {
            Intrinsics.checkNotNullParameter(r9, "model");
            Intrinsics.checkNotNullParameter(r11, "loadButton");
            Intrinsics.checkNotNullParameter(r12, "stopLoadCallback");
            final AudienceMagicBoxBehavior r0 = this.a;
            r0.getClass();
            String r1 = r9.getComponentExtra();
            r0.h = SystemClock.elapsedRealtime();
            int r13 = r9.getSource();
            Object r5 = null;
            if (r13 == 0) goto L27;
            if (r13 != 1) goto L56;
            OpenPlatformMonitorUtils.c.j(r0.c(r0.c), r0.d(), false, false);
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L17
            mh r15 = (mh) GsonHelper.get().fromJson(r1, mh.class);     // Catch: Throwable -> L17
            if (r15 == null) goto L14;
            List r16 = r15.entrances;     // Catch: Throwable -> L17
            if (r16 == null) goto L14;
            com.bytedance.android.livesdk.message.model.e0 r17 = (com.bytedance.android.livesdk.message.model.e0) CollectionsKt.firstOrNull(r16);     // Catch: Throwable -> L17
            if (r17 == null) goto L14;
            com.bytedance.android.live.broadcastgame.opengame.message.f0 r18 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r17, 0);     // Catch: Throwable -> L17
        L15:
            Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L17
        L20:
            if (Result.isFailure-impl(r19) == true) goto L23;
            r5 = r19;
        L23:
            com.bytedance.android.live.broadcastgame.opengame.message.f0 r6 = (com.bytedance.android.live.broadcastgame.opengame.message.f0) r5;
            if (r6 == null) goto L26;
            r0.e(r6, r11, r12);
            goto L56
        L26:
            int r21 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.k("MagicBoxBehavior", new Object[]{"entrance message to open entrance message error"});
        L14:
            r18 = null;
        L17:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r19 = Result.constructor-impl(ResultKt.createFailure(th));
        L56:
            return true;
        L27:
            OpenPlatformMonitorUtils.c.j(r0.c(r0.c), r0.d(), true, false);
            Type r22 = new n().getType();
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L30
            Object r23 = Result.constructor-impl((List) GsonHelper.get().fromJson(r1, r22));     // Catch: Throwable -> L30
        L33:
            if (Result.isFailure-impl(r23) == true) goto L36;
            r5 = r23;
        L36:
            List r8 = (List) r5;
            if (r8 != null) goto L39;
            r8 = CollectionsKt.emptyList();
        L39:
            RoomStampInfo r24 = (RoomStampInfo) CollectionsKt.firstOrNull(r8);
            if (r24 != null) goto L42;
        L48:
            boolean r25 = false;
        L49:
            if (r25 == false) goto L56;
            Room r26 = r0.a;
            if (r26 == null) goto L54;
            long r27 = r26.getRoomId();
        L55:
            Function1<com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r28 = new AudienceMagicBoxBehavior$check$1(r0, r11, r12);
            AudienceMagicBoxBehavior$check$2 r110 = AudienceMagicBoxBehavior$check$2.INSTANCE;
            int r111 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"start request entrance_info..."});
            long r3 = SystemClock.elapsedRealtime();
            RxUtilKt.c(((OpenGameApi) com.bytedance.android.live.network.c.b().e(OpenGameApi.class)).getEntranceInfo(r27).compose(RxUtil.rxSchedulerHelper()).map(new r(r0, r3)).subscribe(new s(r0, r28, r110), new t(r0, r3, r110)), r0.d);
            goto L56
        L54:
            r27 = 0;
            goto L55
        L42:
            if (r24.getStatus() == 0) goto L46;
            if (r24.getStatus() != 1) goto L48;
        L46:
            if (r24.getType() == 4) goto L48;
            r25 = true;
        L30:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r23 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L33
        }
    }

    public static final class b {
    }

    public static final class c extends b7.a {
        public c() {
        }

        public final boolean onFallback(int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMessage");
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehavior", new Object[]{"show magic box lynx dialog failed, errorCode: " + r4 + ", errorMesage: " + r5});
            return super.onFallback(r4, r5);
        }
    }

    static {
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.e d() {
        return new com.bytedance.android.live.broadcastgame.api.openplatform.e(this.a, "audience", 12);
    }

    public final void f() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"show magic box lynx dialog"});
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r1 = this.c;
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
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehavior", new Object[]{"show magic box lynx dialog failed, entranceMessage: " + this.c + ", url: " + r2});
        return;
    L22:
        if (this.c == null) goto L50;
        u6 r7 = new u6(r2);
        u6 r3 = r7.d(LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r8 = this.c;
        String r9 = "";
        if (r8 == null) goto L28;
        String r11 = r8.a;
        if (r11 == null) goto L28;
    L29:
        r3.b("mini_app_id", r11);
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r12 = this.c;
        if (r12 != null) goto L32;
    L41:
        Uri r13 = r7.c();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L44
        Object r15 = Result.constructor-impl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(this.i, r13, new c()));     // Catch: Throwable -> L44
    L46:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L54;
        int r17 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehavior", new Object[]{"Magic box lynx start failed, cause: " + r16.getCause() + ", message: " + r16.getMessage()});
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
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        CompositeDisposable r1 = this.d;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.a = null;
        this.c = null;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r2 = this.e;
        if (r2 == null) goto L11;
        r2.f();
    L11:
        this.e = null;
        Lazy r3 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.g(this.j, NewToolbarButtonConstants.MiniGame.INSTANCE);
        vlc.d r4 = this.b;
        if (r4 == null) goto L14;
        r4.removeMessageListener(this);
    L14:
        this.b = null;
    }

    public final Context getContext() {
        return this.i;
    }

    public static final void b(AudienceMagicBoxBehavior r3) {
        r3.getClass();
        r3.f = xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class).subscribe(new u(new AudienceMagicBoxBehavior$registerShowPanelEvent$1(r3)), new q(r3));
    }

    @Override // com.bytedance.android.live.broadcastgame.k0
    public final void a(Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.g = r2;
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.d c(com.bytedance.android.live.broadcastgame.opengame.message.f0 r5) {
        if (r5 != null) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r6 = this.c;
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

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof mh) == false) goto L20;
        List r5 = ((mh) r4).entrances;
        if (r5 == null) goto L21;
        com.bytedance.android.livesdk.message.model.e0 r6 = (com.bytedance.android.livesdk.message.model.e0) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L22;
        boolean r0 = false;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r7 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r6, 0);
        if (r7 != null) goto L11;
        return;
    L11:
        if (r7.r != 2) goto L14;
        r0 = true;
    L14:
        if (r0 == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L24;
        e(r7, null, null);
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    }

    public AudienceMagicBoxBehavior(Context r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        this.i = r8;
        this.j = r9;
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r4 = RoomContext.a.c(r0, r9, 0, 2);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r5 = null;
        if (r4 == null) goto L7;
        com.bytedance.live.datacontext.m r6 = r4.getRoom();
        if (r6 == null) goto L7;
        Room r7 = (Room) r6.getValue();
    L8:
        this.a = r7;
        vlc.d r11 = (vlc.d) r9.get("data_message_manager");
        this.b = r11;
        if (r11 == null) goto L11;
        r11.addMessageListener(MessageType.OPEN_PLATFORM_AUDIENCE_ENTRANCE_MESSAGE.getIntType(), this);
    L11:
        this.d = new CompositeDisposable();
        if (((Boolean) oz0.a.getValue()).booleanValue() == true) goto L25;
        RoomContext r1 = RoomContext.a.c(r0, r9, 0, 2);
        if (r1 == null) goto L18;
        com.bytedance.live.datacontext.j r2 = r1.getTbCompConfigRegister();
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o) r2.getValue();
    L20:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o) == false) goto L23;
        r5 = r3;
    L23:
        if (r5 == null) goto L25;
        r5.register(new com.bytedance.android.live.broadcastgame.opengame.behavior.g(r9, r8));
    L18:
        r3 = null;
    L25:
        Lazy r12 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r9, NewToolbarButtonConstants.MiniGame.INSTANCE, new a(this));
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void e(final com.bytedance.android.live.broadcastgame.opengame.message.f0 r21, final Function0<Unit> r22, final Function1<? super String, Unit> r23) {
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"receive entrance msg from anchor, name: ", r21.i, ", appId: ", r21.a, ", status: ", Integer.valueOf(r21.r)});
        if (r21.r != 1) goto L5;
        boolean r2 = true;
    L6:
        Object r3 = bi1.a(Boolean.valueOf(r2), NewBroadcastMonitor.STAGE.START);
        if (r3 != null) goto L9;
        r3 = NewBroadcastMonitor.STAGE.STOP;
    L9:
        String r13 = (String) r3;
        if (r21.u != 1) goto L12;
        boolean r12 = true;
    L13:
        OpenPlatformMonitorUtils r4 = OpenPlatformMonitorUtils.c;
        r4.n(c(r21), d(), r12, r13, r21.t);
        InteractGameContext r5 = InteractGameContext.Companion.getContext();
        if (r5 == null) goto L27;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i> r6 = r5.getGameOpenInfo();
        if (r6 == null) goto L27;
        String r9 = r21.a;
        if (r9 != null) goto L20;
        String r11 = "";
    L21:
        long r14 = Long.valueOf(r21.f).longValue();
        String r15 = r21.i;
        if (r15 != null) goto L24;
        String r16 = "";
    L25:
        r6.setValue(new com.bytedance.android.live.broadcastgame.api.model.i(r11, r14, r16, Boolean.valueOf(r21.C).booleanValue(), Boolean.valueOf(r21.D).booleanValue()));
        goto L27
    L24:
        r16 = r15;
        goto L25
    L20:
        r11 = r9;
    L27:
        if (r21.r == 1) goto L29;
        this.j.put("revenue_interact", Boolean.FALSE);
        Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r0 = this.g;
        if (r0 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("sonicPluginMessageReceiver");
    L50:
        r0.invoke(r21);
        ((IInteractGameService) jc1.k.n(IInteractGameService.class)).clearCache();
        r4.h(c(r21), d());
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r7 = AudienceGameContext.a.a();
        if (r7 == null) goto L55;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r8 = r7.getAnchorCurrentGameIconInfo();
        if (r8 == null) goto L55;
        r8.setValue(null);
    L55:
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r17 = this.e;
        if (r17 == null) goto L63;
        r17.f();
        return;
    L63:
        return;
    L29:
        if (tb1.c.a == true) goto L34;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"not support game type"});
        if (r23 == null) goto L59;
        Unit r18 = (Unit) r23.invoke("not support game type");
        return;
    L59:
        return;
    L34:
        Function0<Unit> r19 = new AudienceMagicBoxBehavior$receiveOpenEntranceMessage$showIcon$1(this, r21, r22);
        this.c = r21;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"receive anchor message, need check visible: " + r21.t});
        if (r21.t == false) goto L41;
        Function0<Unit> r24 = new AudienceMagicBoxBehavior$receiveOpenEntranceMessage$1(this, r23, r21);
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"start check entrance visible"});
        long r110 = SystemClock.elapsedRealtime();
        AudienceGameNetApi r111 = (AudienceGameNetApi) com.bytedance.android.live.network.c.b().e(AudienceGameNetApi.class);
        Room r25 = this.a;
        if (r25 == null) goto L39;
        long r26 = r25.getRoomId();
    L40:
        RxUtilKt.c(r111.getEntranceVisiable(r26, 1, r21.f).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r110, r21, r19, r24), new m(this, r110, r21, r24)), this.d);
    L42:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r27 = AudienceGameContext.a.a();
        if (r27 == null) goto L60;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r28 = r27.getAnchorCurrentGameIconInfo();
        if (r28 == null) goto L61;
        r28.setValue(new com.bytedance.android.live.broadcastgame.api.model.h(r21.a, r21.i, r21.j));
        return;
    L61:
        return;
    L60:
        return;
    L39:
        r26 = 0;
        goto L40
    L41:
        r19.invoke();
        goto L42
    L12:
        r12 = false;
        goto L13
    L5:
        r2 = false;
        goto L6
    }
}
