package com.bytedance.android.live.broadcastgame.opengame;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.LruCache;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.debug.GameReceiver;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class LiveBasePluginManager implements com.bytedance.android.live.broadcastgame.api.openplatform.b, com.bytedance.android.live.broadcastgame.opengame.runtime.r {
    public com.bytedance.android.live.broadcastgame.opengame.runtime.q a;
    public String b;
    public final f c;
    public final com.bytedance.android.live.broadcastgame.opengame.debug.d d;
    public final Lazy e;
    public com.bytedance.android.live.broadcastgame.api.d f;
    public final Context g;
    public final DataCenter h;
    public final long i;
    public final ViewGroup j;
    public final /* synthetic */ i20.a k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveBasePluginManager a;

        public b(LiveBasePluginManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LiveBasePluginManager r0 = this.a;
            r0.r((com.bytedance.android.live.broadcastgame.api.openplatform.f) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveBasePluginManager a;

        public c(LiveBasePluginManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r0 = q.a;
            q.i((Throwable) r3, "LiveBasePluginManager", "on registerShowPanelEvent Error");
            this.a.q();
            LocalTestManager.a(new Class[]{wy.a.class});
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveBasePluginManager a;
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.f b;

        public d(LiveBasePluginManager r1, com.bytedance.android.live.broadcastgame.api.openplatform.f r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            IBaseUser r5 = (IBaseUser) r4;
            LiveBasePluginManager r6 = this.a;
            r6.g(r6.b, MapsKt.mapOf(TuplesKt.to("location", this.b.b)), this.b.a);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            int r0 = q.a;
            q.i((Throwable) r3, "LiveBasePluginManager", "on registerShowPanelEvent login Error");
        }
    }

    static {
    }

    public final void a(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.k.a(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.n
    public final void f(String r1, File r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void j(String r3) {
        Intrinsics.checkNotNullParameter("sei", "name");
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    public abstract com.bytedance.android.live.broadcastgame.opengame.runtime.q l(Context r1, long r2, DataCenter r4, f r5, PluginType r6);

    public final Room m() {
        return (Room) this.e.getValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.n
    public final void n(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "stage");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.r
    public final void o() {
    }

    public void onStop() {
        this.b = null;
        this.a = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String getGameCategory() {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 == null) goto L7;
        PluginContext r1 = r0.mo311getContext();
        if (r1 == null) goto L7;
        return ((BootInfoService) r1.o(BootInfoService.class)).e();
    L7:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String h() {
        Intrinsics.checkNotNullParameter("", "appId");
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void k() {
        Intrinsics.checkNotNullParameter("", "appId");
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void onDestroy() {
        ReportPicUploader.c.clear();
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 == null) goto L5;
        r0.b("on destroy");
    L5:
        com.bytedance.android.live.broadcastgame.opengame.debug.d r1 = this.d;
        OpenPlatformBaseDebugger r2 = r1.b;
        if (r2 == null) goto L8;
        r2.releaseDebug();
    L8:
        r1.b = null;
        r1.a = false;
        this.a = null;
        this.b = null;
        f r3 = this.c;
        r3.getClass();
        int r4 = q.a;
        q.g("销毁游戏IM", "");
        vlc.d r5 = r3.b;
        if (r5 == null) goto L11;
        r5.release();
    L11:
        com.bytedance.android.live.broadcastgame.api.interactgame.o.a = 0;
        int r6 = InteractGameLocalStatusUtils.a;
        InteractGameLocalStatusUtils.c("in_game_cast", String.valueOf(false));
        this.k.b();
        GameReceiver r7 = com.bytedance.android.live.broadcastgame.opengame.debug.a.a;
        if (v.a() == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.live.broadcastgame.opengame.debug.a.a == null) goto L26;
        Application r8 = jc1.a.b();
        GameReceiver r9 = com.bytedance.android.live.broadcastgame.opengame.debug.a.a;
        ReceiverRegisterLancet.loge(r9, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L31;
        r8.unregisterReceiver(r9);
        goto L26
    L31:
    L21:
        e = move-exception;
        if (r9 == null) goto L24;
        Npth.addTag("unregisterReceiver", r9.toString());
    L24:
        e.printStackTrace();
        goto L26
    L18:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r9, r8) == false) goto L26;
        r8.unregisterReceiver(r9);     // Catch: Exception -> L21
    L26:
        GameReceiver r11 = com.bytedance.android.live.broadcastgame.opengame.debug.a.a;
        if (r11 == null) goto L29;
        r11.b = null;
    L29:
        com.bytedance.android.live.broadcastgame.opengame.debug.a.a = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void stopGameCastToAudience() {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 == null) goto L6;
        r0.stopGameCastToAudience();
        return;
    }

    public final void q() {
        a(RxUtilKt.h(xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class)).subscribe(new b(this), new c(this)));
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 == null) goto L5;
        r0.b(r2);
    L5:
        this.a = null;
        this.b = null;
        int r3 = com.bytedance.android.live.broadcastgame.api.interactgame.o.a;
        com.bytedance.android.live.broadcastgame.api.interactgame.o.a = 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void c(boolean r2) {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void e(u r11) {
        Intrinsics.checkNotNullParameter(r11, "gameItem");
        int r1 = q.a;
        Object[] r2 = new Object[1];
        StringBuilder r3 = new StringBuilder("start intro dialog, game name: ");
        r3.append(r11.name);
        r3.append(", appId: ");
        com.bytedance.android.live.broadcastgame.api.model.r r4 = r11.c();
        if (r4 == null) goto L6;
        String r5 = r4.b();
        if (r5 == null) goto L6;
    L7:
        r3.append(r5);
        r2[0] = r3.toString();
        q.f("LiveBasePluginManager", r2);
        LruCache<String, byte[]> r6 = ReportPicUploader.a;
        com.bytedance.android.live.broadcastgame.api.model.r r7 = r11.c();
        if (r7 == null) goto L11;
        String r8 = r7.b();
        if (r8 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r8, "appId");
        ReportPicUploader.a r9 = ReportPicUploader.c.get(r8);
        Long r12 = null;
        if (r9 == null) goto L19;
        q.f("LiveBasePluginManager", new Object[]{"startPluginWithIntroduction: game is in black list, cancel start"});
        f2.b(2131921120, 0);
        int r0 = GameDataReportHelper.a;
        String r13 = r11.name;
        com.bytedance.android.live.broadcastgame.api.model.r r14 = r11.c();
        if (r14 == null) goto L17;
        r12 = Long.valueOf(r14.p());
    L17:
        GameDataReportHelper.f(r13, String.valueOf(r12), r9.a, r9.b, z.e(this.h, false));
        return;
    L19:
        Context r15 = this.g;
        DataCenter r16 = this.h;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r11, "gameItem");
        Intrinsics.checkNotNullParameter(r16, "dataCenter");
        LiveBasePluginManager$startPluginWithIntroduction$2 r17 = LiveBasePluginManager$startPluginWithIntroduction$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r17, "fallback");
        int r18 = com.bytedance.android.live.broadcastgame.opengame.view.i.j;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "dataCenter");
        Intrinsics.checkNotNullParameter(r11, "gameItem");
        Intrinsics.checkNotNullParameter(this, "gameManager");
        com.bytedance.android.live.broadcastgame.opengame.view.i r19 = new com.bytedance.android.live.broadcastgame.opengame.view.i(r15, r16, r11, this);
        Intrinsics.checkNotNullParameter(r17, "fallback");
        r19.e(r17, null);
        return;
    L11:
        r8 = "";
    L6:
        r5 = "null";
        goto L7
    }

    public final void r(com.bytedance.android.live.broadcastgame.api.openplatform.f r8) {
        Intrinsics.checkNotNullParameter(r8, "openEvent");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L56
        if (Intrinsics.areEqual(r8.b, "from_toolbar") == false) goto L7;
    L10:
        String r2 = r8.b;     // Catch: Throwable -> L56
        int r4 = r2.hashCode();     // Catch: Throwable -> L56
        if (r4 == (-1271529498)) goto L24;
        if (r4 == (-949931101)) goto L21;
        if (r4 == 214339523) goto L18;
    L26:
        String r0 = "";
    L27:
        OpenPlatformMonitorUtils r3 = OpenPlatformMonitorUtils.c;     // Catch: Throwable -> L56
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r5 = this.a;     // Catch: Throwable -> L56
        String r6 = null;
        if (r5 == null) goto L32;
        t r7 = r5.getPluginInfo();     // Catch: Throwable -> L56
        if (r7 == null) goto L32;
        String r9 = r7.i;     // Catch: Throwable -> L56
    L33:
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r11 = this.a;     // Catch: Throwable -> L56
        if (r11 == null) goto L40;
        t r12 = r11.getPluginInfo();     // Catch: Throwable -> L56
        if (r12 == null) goto L40;
        Map<String, ? extends Object> r13 = r12.k;     // Catch: Throwable -> L56
        if (r13 == null) goto L40;
        Object r14 = r13.get("OPEN_APP_NAME");     // Catch: Throwable -> L56
    L42:
        if ((r14 instanceof String) == true) goto L44;
        r14 = null;
    L44:
        String r15 = (String) r14;     // Catch: Throwable -> L56
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r16 = this.a;     // Catch: Throwable -> L56
        if (r16 == null) goto L49;
        t r17 = r16.getPluginInfo();     // Catch: Throwable -> L56
        if (r17 == null) goto L49;
        r6 = r17.n;     // Catch: Throwable -> L56
    L49:
        r3.g(new com.bytedance.android.live.broadcastgame.api.openplatform.d(r9, r15, r6), new com.bytedance.android.live.broadcastgame.api.openplatform.e(m(), "audience", 12), r0);     // Catch: Throwable -> L56
    L51:
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L53;
        com.bytedance.android.livesdk.user.f r18 = jc1.k.n(IUserService.class).user();     // Catch: Throwable -> L56
        Context r19 = this.g;     // Catch: Throwable -> L56
        com.bytedance.android.livesdk.user.l.a r21 = new com.bytedance.android.livesdk.user.l.a();     // Catch: Throwable -> L56
        r21.a = s1.B(2131915990);     // Catch: Throwable -> L56
        r21.d = "open_platform";     // Catch: Throwable -> L56
        r21.c = -1;     // Catch: Throwable -> L56
        a(r18.login(r19, new com.bytedance.android.livesdk.user.l(r21)).subscribe(new d(this, r8), e.a));     // Catch: Throwable -> L56
    L54:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
        return;
    L53:
        g(this.b, MapsKt.mapOf(TuplesKt.to("location", r8.b)), r8.a);     // Catch: Throwable -> L56
    L40:
        r14 = null;
    L32:
        r9 = null;
        goto L33
    L18:
        if (r2.equals("from_temp_area") == false) goto L26;
        r0 = "temp_area";
        goto L27
    L21:
        if (r2.equals("from_mini_card") == false) goto L26;
        r0 = "card";
        goto L27
    L24:
        if (r2.equals("from_toolbar") == false) goto L26;
        r0 = NewBroadcastMonitor.STAGE.TOOLBAR;
        goto L27
    L7:
        if (Intrinsics.areEqual(r8.b, "from_mini_card") == true) goto L10;
        if (Intrinsics.areEqual(r8.b, "from_temp_area") == false) goto L51;
    L56:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void d(String r1, Map<String, String> r2) {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r3 = this.a;
        if (r3 == null) goto L6;
        r3.g(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void notifyStartLinkCastResult(boolean r2, Surface r3, int r4) {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.a;
        if (r0 == null) goto L6;
        r0.notifyStartLinkCastResult(r2, r3, r4);
        return;
    }

    public LiveBasePluginManager(Context r9, DataCenter r11, long r12, ViewGroup r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        Intrinsics.checkNotNullParameter(r13, "containerView");
        this.k = new i20.a();
        this.g = r9;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.c = new f(r9, r12);
        this.d = new com.bytedance.android.live.broadcastgame.opengame.debug.d();
        this.e = LazyKt.lazy(LiveBasePluginManager$room$2.INSTANCE);
        InteractGameService.Companion.getClass();
        i10.f r14 = (i10.f) InteractGameService.access$getDiComponent$cp();
        r14.getClass();
        com.bytedance.android.live.broadcastgame.api.d r15 = (com.bytedance.android.live.broadcastgame.api.d) r14.a.e.get();
        this.f = r15;
        if (r15 == null) goto L6;
        r15.a();
    L6:
        if (v.a() == false) goto L10;
        a(RxUtilKt.h(xs2.b.a().b(d10.c.class)).subscribe(new n(this), o.a));
    L10:
        if (v.a() == false) goto L13;
        a(RxUtilKt.h(xs2.b.a().b(d10.a.class)).subscribe(new l(this), m.a));
    L13:
        q();
        GameReceiver r16 = com.bytedance.android.live.broadcastgame.opengame.debug.a.a;
        Intrinsics.checkNotNullParameter(this, "manager");
        if (v.a() == false) goto L86;
        int r17 = q.a;
        q.g("ADBDebugManager: init", "");
        IntentFilter r18 = new IntentFilter("com.bytedance.android.live.game");
        GameReceiver r19 = com.bytedance.android.live.broadcastgame.opengame.debug.a.a;
        if (r19 != null) goto L18;
        r19 = new GameReceiver(this);
    L18:
        com.bytedance.android.live.broadcastgame.opengame.debug.a.a = r19;
        if (Build.VERSION.SDK_INT < 34) goto L49;
        Application r110 = jc1.a.b();
        GameReceiver r111 = com.bytedance.android.live.broadcastgame.opengame.debug.a.a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L83;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L83:
    L44:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L48;
        ReceiverRegisterCrashOptimizer.registerReceiver(r111, r18, 2);
        return;
    L48:
        throw e;
    L24:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L35;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r18) == false) goto L35;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r18, 2, null, null, 3, r110).result;     // Catch: Exception -> L44
        if (r0 == 1) goto L33;
        if (r0 == 2) goto L32;
        if (r0 == 3) goto L82;
        r110.registerReceiver(r111, r18, 2);     // Catch: Exception -> L44
    L82:
        return;
    L32:
        new Intent();     // Catch: Exception -> L44
        goto L82
    L33:
        r110.registerReceiver(r111, r18, 2);     // Catch: Exception -> L44
    L35:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L38;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L44
        r110.registerReceiver(r111, r18, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L44
        goto L82
    L38:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L40;
    L42:
        r110.registerReceiver(r111, r18, 2);     // Catch: Exception -> L44
        goto L82
    L40:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r18) == false) goto L42;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L44
        ContextCompat.registerReceiver(r110, r111, r18, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L44
        goto L82
    L49:
        Application r112 = jc1.a.b();
        GameReceiver r113 = com.bytedance.android.live.broadcastgame.opengame.debug.a.a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L80;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L80:
    L73:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L77;
        ReceiverRegisterCrashOptimizer.registerReceiver(r113, r18);
        return;
    L77:
        throw e;
    L53:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L64;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r18) == false) goto L64;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r113, r18, 0, null, null, 2, r112).result;     // Catch: Exception -> L73
        if (r1 == 1) goto L62;
        if (r1 == 2) goto L61;
        if (r1 == 3) goto L79;
        r112.registerReceiver(r113, r18);     // Catch: Exception -> L73
    L79:
        return;
    L61:
        new Intent();     // Catch: Exception -> L73
        goto L79
    L62:
        r112.registerReceiver(r113, r18);     // Catch: Exception -> L73
    L64:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L67;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L73
        r112.registerReceiver(r113, r18, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L73
        goto L79
    L67:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L69;
    L71:
        r112.registerReceiver(r113, r18);     // Catch: Exception -> L73
        goto L79
    L69:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r18) == false) goto L71;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L73
        ContextCompat.registerReceiver(r112, r113, r18, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L73
        goto L79
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void i(long r17, String r19, String r21, Map<String, ? extends Object> r22, boolean r23, boolean r24) {
        String r1 = r21;
        Intrinsics.checkNotNullParameter(r19, "appId");
        Intrinsics.checkNotNullParameter(r1, "schema");
        Intrinsics.checkNotNullParameter(r22, "params");
        LruCache<String, byte[]> r3 = ReportPicUploader.a;
        Intrinsics.checkNotNullParameter(r19, "appId");
        ReportPicUploader.a r2 = ReportPicUploader.c.get(r19);
        Long r4 = null;
        if (r2 == null) goto L18;
        int r0 = q.a;
        q.f("LiveBasePluginManager", new Object[]{"startPlugin: game is in black list, cancel start"});
        f2.b(2131921120, 0);
        Object r5 = r22.get("game");
        if ((r5 instanceof u) == true) goto L7;
        r5 = null;
    L7:
        u r6 = (u) r5;
        int r7 = GameDataReportHelper.a;
        if (r6 == null) goto L10;
        String r8 = r6.name;
    L11:
        String r9 = String.valueOf(r8);
        if (r6 == null) goto L16;
        com.bytedance.android.live.broadcastgame.api.model.r r11 = r6.c();
        if (r11 == null) goto L16;
        r4 = Long.valueOf(r11.p());
    L16:
        GameDataReportHelper.f(r9, String.valueOf(r4), r2.a, r2.b, z.e(this.h, false));
        return;
    L10:
        r8 = null;
        goto L11
    L18:
        int r12 = q.a;
        q.f("LiveBasePluginManager", new Object[]{"start plugin, appId: ", r19, ", schema: ", r1});
        if (com.bytedance.android.live.broadcastgame.api.openplatform.k.a(r21) == false) goto L22;
        r1 = r1.concat("&version_type=debug&tech_type=13");
    L21:
        String r13 = r1;
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r14 = this.a;
        if (r14 == null) goto L38;
        r14.b("start another plugin");
    L38:
        PluginType.Companion.getClass();
        PluginType r15 = PluginType.a.a(r13);
        if (r15 != null) goto L43;
        q.f("LiveBasePluginManager", new Object[]{"pluginType is null"});
        f2.b(2131920848, 0);
        return;
    L43:
        if (this.i == 0) goto L45;
        q.f("LiveBasePluginManager", new Object[]{"update js sdk"});
        this.b = r19;
        q.f("LiveBasePluginManager", new Object[]{"create runtime"});
        this.a = l(this.g, this.i, this.h, this.c, r15);
        q.f("LiveBasePluginManager", new Object[]{"do start plugin"});
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r16 = this.a;
        if (r16 == null) goto L53;
        r16.e(r13, r15, r22, r24, this);
        return;
    L53:
        return;
    L45:
        if (v.a() == false) goto L47;
        f2.c("roomid is null", 0);
    L47:
        q.e("LiveBasePluginManager", new Object[]{"roomid is null"});
        return;
    L22:
        Intrinsics.checkNotNullParameter(r1, "$this$isNeedPerformance");
        androidx.collection.LruCache r18 = LiveSchemaInfo.r;
        LiveSchemaInfo r25 = LiveSchemaInfo.c.a(r21);
        if (r25 == null) goto L25;
        String r26 = r25.b("needPerformance");
    L27:
        if (Intrinsics.areEqual(r26, GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L29;
        Intrinsics.checkNotNullParameter(r1, "$this$getWithoutPerfParam");
        String r27 = i2.e(i2.e(i2.e(UriProtector.parse(r21), "needPerformance"), "report_id"), "live_app_version").toString();
    L31:
        if (p.a(r27, r19) == false) goto L34;
        q.e("LiveBasePluginManager", new Object[]{"schema is invalid, appId: ", r19, ", schema: ", r27});
        f2.b(2131920848, 0);
        OpenPlatformMonitorUtils r28 = OpenPlatformMonitorUtils.c;
        OpenPlatformMonitorUtils.o(r22, new com.bytedance.android.live.broadcastgame.api.openplatform.e(m(), null, 6), 1);
        return;
    L34:
        OpenPlatformMonitorUtils r29 = OpenPlatformMonitorUtils.c;
        OpenPlatformMonitorUtils.o(r22, new com.bytedance.android.live.broadcastgame.api.openplatform.e(m(), null, 6), 0);
        goto L21
    L29:
        r27 = r1;
        goto L31
    L25:
        r26 = null;
        goto L27
    }
}
