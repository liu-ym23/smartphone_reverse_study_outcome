package com.bytedance.android.live.broadcastgame.opengame;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.i0;
import com.bytedance.android.live.broadcastgame.opengame.control.OpenPlatformControlService;
import com.bytedance.android.live.broadcastgame.opengame.control.OpenPlatformControlService$OpenCertificateManager$showDialog$$inlined$apply$lambda$2;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager;
import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import com.bytedance.android.live.broadcastgame.opengame.message.l0;
import com.bytedance.android.live.broadcastgame.opengame.message.w;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.config.ie0;
import com.bytedance.android.livesdk.config.ye;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.widget.e1;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.InteractOpenExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AudiencePluginManager extends LiveBasePluginManager {
    public static final /* synthetic */ int z = 0;
    public boolean l;
    public volatile f m;
    public f0 n;
    public boolean o;
    public final g p;
    public boolean q;
    public f0 r;
    public Long s;
    public e1 t;
    public final List<Class<Object>> u;
    public boolean v;
    public String w;
    public Map<String, String> x;
    public final AudiencePluginManager$liveLifeCycle$1 y;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AudiencePluginManager a;

        public a(AudiencePluginManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            w r4 = (w) r3;
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r0 = AudienceGameContext.a.a();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r1 = r0.getGameIntroCardInfo();
            if (r1 == null) goto L7;
            r1.setValue(r4.a);
        L7:
            com.bytedance.android.live.broadcastgame.opengame.runtime.q r2 = this.a.a;
            if (r2 == null) goto L10;
            r2.d(r4.a);
        L10:
            AudiencePluginManager r5 = this.a;
            if (r5.a != null) goto L16;
            f0 r6 = r5.r;
            if (r6 == null) goto L17;
            r5.t(r6);
            return;
        L17:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AudiencePluginManager a;

        public c(AudiencePluginManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((h1) r2).a != 7) goto L6;
            this.a.x("receive anchor exit room event");
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            q.j((Throwable) r3, null, 6);
        }
    }

    public static final class e {
    }

    public static final class f {
        public final String a;
        public final long b;
        public final String c;
        public final int d;
        public final String e;
        public final String f;
        public final String g;
        public final long h;
        public final boolean i;
        public final String j;
        public final int k;
        public final int l;

        public final String toString() {
            return "GameInfo(appId='" + this.a + "', gameId=" + this.b + ", gameName='" + this.e + "', gameIconUrl='" + this.f + "', schema='" + this.g + "', connId=" + this.h + ", businessType=" + this.k + ')';
        }

        public f(String r2, long r3, String r5, int r6, String r7, String r8, String r9, long r11, boolean r12, String r13, int r14, int r15) {
            Intrinsics.checkNotNullParameter(r2, "appId");
            Intrinsics.checkNotNullParameter(r5, "appVersion");
            Intrinsics.checkNotNullParameter(r7, "gameName");
            Intrinsics.checkNotNullParameter(r8, "gameIconUrl");
            Intrinsics.checkNotNullParameter(r9, "schema");
            Intrinsics.checkNotNullParameter(r13, "developer");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r11;
            this.i = r12;
            this.j = r13;
            this.k = r14;
            this.l = r15;
        }
    }

    public final class g {
        public Map<String, ? extends Object> a;
        public final Map<String, String> b;
        public long c;
        public String d;
        public boolean e;
        public final /* synthetic */ AudiencePluginManager f;

        public final String a() {
            com.bytedance.android.live.broadcastgame.opengame.runtime.q r0 = this.f.a;
            if ((r0 instanceof com.bytedance.android.live.broadcastgame.opengame.runtime.d) == true) goto L5;
            r0 = null;
        L5:
            com.bytedance.android.live.broadcastgame.opengame.runtime.d r1 = (com.bytedance.android.live.broadcastgame.opengame.runtime.d) r0;
            if (r1 == null) goto L10;
            PluginContext r2 = r1.u();
            if (r2 == null) goto L10;
            return ((BootInfoService) r2.o(BootInfoService.class)).e();
        L10:
            return "unknown";
        }

        public g(AudiencePluginManager r1) {
            this.f = r1;
            this.b = new LinkedHashMap();
            this.d = "";
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AudiencePluginManager a;

        public h(AudiencePluginManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Disposable r3 = (Disposable) r2;
            e1 r4 = this.a.t;
            if (r4 != null) goto L5;
            return;
        L5:
            if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L11;
            DialogLancet.handleBlockedDialogShow(r4);
            return;
        L11:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
        L8:
            DialogLancet.beforeDialogShow(r4);
            r4.show();
            DialogLancet.afterDialogShow(r4);
        }
    }

    public static final class i implements Action {
        public final /* synthetic */ AudiencePluginManager a;

        public i(AudiencePluginManager r1) {
            this.a = r1;
        }

        public final void run() {
            e1 r0 = this.a.t;
            if (r0 == null) goto L21;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r2 == null) goto L18;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r1.getLooper()) goto L9;
            r1.post(DialogLancet.createDismissRunnable(r0));
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ AudiencePluginManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        public j(AudiencePluginManager r1, String r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r13) {
            ExtraResponse r14 = (ExtraResponse) r13;
            int r0 = q.a;
            boolean r2 = false;
            q.f("AudiencePluginManager", new Object[]{"on audience/start success, need verify: ", Long.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.w) r14.data).a())});
            if (v.a() == false) goto L8;
            if (((Boolean) ie0.a.getValue()).booleanValue() == false) goto L8;
            r2 = true;
        L8:
            if (((com.bytedance.android.live.broadcastgame.opengame.network.w) r14.data).a() != 2) goto L32;
            if (r2 == true) goto L32;
            com.bytedance.android.live.broadcastgame.opengame.runtime.q r15 = this.a.a;
            OpenPlatformControlService r1 = null;
            if ((r15 instanceof com.bytedance.android.live.broadcastgame.opengame.runtime.d) == true) goto L13;
            r15 = null;
        L13:
            com.bytedance.android.live.broadcastgame.opengame.runtime.d r16 = (com.bytedance.android.live.broadcastgame.opengame.runtime.d) r15;
            if (r16 == null) goto L18;
            PluginContext r17 = r16.u();
            if (r17 == null) goto L18;
            r1 = (OpenPlatformControlService) r17.o(OpenPlatformControlService.class);
        L18:
            if (r1 == null) goto L37;
            final OpenPlatformControlService.e r18 = r1.g;
            if (r18 == null) goto L38;
            final Function0<Unit> r3 = new AudiencePluginManager$showPlugin$4$1(this);
            final Function0<Unit> r4 = new AudiencePluginManager$showPlugin$4$2(this);
            final Function0<Unit> r5 = new AudiencePluginManager$showPlugin$4$3(this);
            Intrinsics.checkNotNullParameter(r3, "onCancel");
            Intrinsics.checkNotNullParameter(r4, "onConfirm");
            Intrinsics.checkNotNullParameter(r5, "onCertificate");
            OpenPlatformControlService.e.a r6 = r18.b;
            if (r6 != null) goto L24;
        L26:
            final OpenPlatformControlService.e.a r7 = new OpenPlatformControlService.e.a(r18.c.h.getContext());
            r7.a.setOnClickListener(new com.bytedance.android.live.broadcastgame.opengame.control.b(r7, r3, r4, r5));
            r7.b.setOnClickListener(new OpenPlatformControlService$OpenCertificateManager$showDialog$$inlined$apply$lambda$2(r7, r18, r3, r4, r5));
            r7.setOnDismissListener(new com.bytedance.android.live.broadcastgame.opengame.control.c(r18, r3, r4, r5));
            if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L35;
            DialogLancet.handleBlockedDialogShow(r7);
        L31:
            Unit r8 = Unit.INSTANCE;
            r18.b = r7;
            return;
        L35:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
        L30:
            DialogLancet.beforeDialogShow(r7);
            r7.show();
            DialogLancet.afterDialogShow(r7);
            goto L31
        L24:
            if (r6.isShowing() != true) goto L26;
            return;
        L38:
            return;
        L37:
            return;
        L32:
            g r9 = this.a.p;
            String r11 = OpenControlDialogManager.c.getOrDefault(Long.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.w) r14.data).c()), "");
            r9.getClass();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r9.d = r11;
            this.a.s = Long.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.w) r14.data).b());
            this.a.v(this.b, this.c);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ AudiencePluginManager a;

        public k(AudiencePluginManager r1) {
            this.a = r1;
        }

        public final void accept(Object r14) {
            Throwable r15 = (Throwable) r14;
            int r0 = q.a;
            q.f("AudiencePluginManager", new Object[]{"on audience/start fail, error: ", r15});
            if ((r15 instanceof CustomApiServerException) == true) goto L5;
            r15 = null;
        L5:
            CustomApiServerException r16 = (CustomApiServerException) r15;
            if (r16 != null) goto L37;
            f2.c(s1.B(2131920880), 0);
            return;
        L37:
            JsonElement r17 = GsonHelper.parser().parse(r16.getExtra());     // Catch: Exception -> L33
            String r3 = "";
            if (r17 == null) goto L16;
            JsonObject r18 = r17.getAsJsonObject();     // Catch: Exception -> L33
            if (r18 == null) goto L16;
            JsonElement r19 = r18.get("control_content_msg");     // Catch: Exception -> L33
            if (r19 == null) goto L16;
            String r110 = r19.getAsString();     // Catch: Exception -> L33
            if (r110 == null) goto L16;
        L17:
            JsonObject r111 = GsonHelper.parser().parse(r110).getAsJsonObject();     // Catch: Exception -> L33
            final com.bytedance.android.livesdk.wrds.interact.a.b r4 = (com.bytedance.android.livesdk.wrds.interact.a.b) GsonHelper.get().fromJson(r111, com.bytedance.android.livesdk.wrds.interact.a.b.class);     // Catch: Exception -> L33
            JsonElement r112 = r111.get("toast_msg");     // Catch: Exception -> L33
            if (r112 == null) goto L20;
            String r113 = r112.getAsString();     // Catch: Exception -> L33
        L21:
            r4.a = r113;     // Catch: Exception -> L33
            int r114 = GameDataReportHelper.a;     // Catch: Exception -> L33
            AudiencePluginManager r115 = this.a;     // Catch: Exception -> L33
            DataCenter r5 = r115.h;     // Catch: Exception -> L33
            f r116 = r115.m;     // Catch: Exception -> L33
            if (r116 == null) goto L27;
            String r117 = r116.e;     // Catch: Exception -> L33
            if (r117 == null) goto L27;
            r3 = r117;
        L27:
            f r118 = this.a.m;     // Catch: Exception -> L33
            if (r118 == null) goto L30;
            Long r119 = Long.valueOf(r118.b);     // Catch: Exception -> L33
        L31:
            GameDataReportHelper.f(r3, String.valueOf(r119), r4.a(), this.a.p.a(), false);     // Catch: Exception -> L33
            UtilityKotlinExtentionsKt.s(0, false, false, new AudiencePluginManager$showPlugin$5$$special$$inlined$let$lambda$1(r4, this), 7);     // Catch: Exception -> L33
            return;
        L30:
            r119 = null;
            goto L31
        L20:
            r113 = null;
        L16:
            r110 = "";
        L33:
            e = move-exception;
            q.j(e, null, 6);
            f2.c(s1.B(2131920880), 0);
        }
    }

    public static final class l<T> implements Consumer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final void accept(Object r3) {
            ExtraResponse r4 = (ExtraResponse) r3;
            int r5 = q.a;
            q.f("AudiencePluginManager", new Object[]{"on audience/stop success"});
        }
    }

    public static final class m<T> implements Consumer {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final void accept(Object r4) {
            int r0 = q.a;
            q.f("AudiencePluginManager", new Object[]{"on audience/stop fail, error: ", (Throwable) r4});
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager, com.bytedance.android.live.broadcastgame.opengame.runtime.r
    public final void onStop() {
        x("on stop");
        super.onStop();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager, com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void onDestroy() {
        super.onDestroy();
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.y);
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.g(this.h, NewToolbarButtonConstants.MiniGame.INSTANCE);
    L5:
        boolean r1 = com.bytedance.android.live.broadcastgame.api.interactgame.b.a;
        com.bytedance.android.live.broadcastgame.api.interactgame.b.a = false;
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.e("release");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager, com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void j(final String r8) {
        Intrinsics.checkNotNullParameter("sei", "name");
        Intrinsics.checkNotNullParameter(r8, "params");
        if (Intrinsics.areEqual("sei", "sei") == false) goto L6;
        UtilityKotlinExtentionsKt.s(0, false, false, new AudiencePluginManager$sendPluginData$1(this, r8), 7);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.r
    public final void p(String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        int r0 = q.a;
        q.e("AudiencePluginManager", new Object[]{"start plugin failed ", ", errorCode: ", -1, ", errorMsg: ", r4});
        this.b = null;
        this.a = null;
    }

    public final void t(f0 r6) {
        Intrinsics.checkNotNullParameter(r6, "entrance");
        int r0 = q.a;
        q.f("AudiencePluginManager", new Object[]{"receive magic box message, status: " + r6.r});
        if (r6.r != 1) goto L9;
        this.r = r6;
        this.h.put("data_anchor_current_game_id", Long.valueOf(r6.f));
        if (this.m == null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r6.y, Boolean.TRUE) == false) goto L17;
        w(r6);
        return;
    L17:
        return;
    L9:
        String r1 = null;
        this.r = null;
        this.h.put("data_anchor_current_game_id", null);
        String r7 = r6.a;
        f r2 = this.m;
        if (r2 == null) goto L13;
        r1 = r2.a;
    L13:
        if (Intrinsics.areEqual(r7, r1) == false) goto L19;
        x("receive anchor exit game event");
        return;
    }

    public final void u(boolean r44) {
        f r1 = this.m;
        if (r1 == null) goto L5;
        String r2 = r1.a;
    L6:
        f0 r3 = this.r;
        if (r3 == null) goto L9;
        String r4 = r3.a;
    L10:
        boolean r5 = Intrinsics.areEqual(r2, r4);
        Map<String, String> r6 = this.p.b;
        f r7 = this.m;
        if (r7 == null) goto L13;
        String r8 = r7.a;
    L14:
        String r9 = (String) ((LinkedHashMap) r6).get(r8);
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r11 = this.a;
        if (r11 == null) goto L21;
        t r12 = r11.getPluginInfo();
        if (r12 == null) goto L21;
        if (r12.c != true) goto L21;
    L22:
        boolean r13 = true;
    L24:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r14 = AudienceGameContext.a.a();
        if (r14 == null) goto L33;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r15 = r14.getGameIntroCardInfo();
        if (r15 == null) goto L33;
        com.bytedance.android.live.broadcastgame.api.openplatform.a r16 = (com.bytedance.android.live.broadcastgame.api.openplatform.a) r15.getValue();
        if (r16 == null) goto L33;
        if (r16.a != true) goto L33;
        boolean r17 = true;
    L35:
        if (r44 == false) goto L73;
        int r34 = GameDataReportHelper.a;
        boolean r35 = r17;
        f r18 = this.m;
        if (r18 == null) goto L39;
        String r19 = r18.e;
    L40:
        f r110 = this.m;
        if (r110 == null) goto L43;
        Long r21 = Long.valueOf(r110.b);
    L44:
        f r22 = this.m;
        if (r22 == null) goto L48;
        String r23 = r22.a;
        if (r23 == null) goto L48;
    L49:
        g r111 = this.p;
        String r0 = r111.d;
        boolean r112 = r111.e;
        Intrinsics.checkNotNullParameter(r23, "appid");
        Intrinsics.checkNotNullParameter(r0, "userCertType");
        Pair[] r24 = new Pair[13];
        r24[0] = TuplesKt.to("game_name", String.valueOf(r19));
        r24[1] = TuplesKt.to("game_id", String.valueOf(r21));
        r24[2] = TuplesKt.to("user_id", jc1.k.n(IUserService.class).user().n());
        r24[3] = TuplesKt.to("game_app_id", r23);
        if (r9 != null) goto L52;
        r9 = "more";
    L52:
        r24[4] = TuplesKt.to("source_type", r9);
        r24[5] = TuplesKt.to("user_type", "user");
        boolean r25 = com.bytedance.android.live.broadcastgame.api.interactgame.b.a;
        if (com.bytedance.android.live.broadcastgame.api.interactgame.b.a == false) goto L55;
        Object r26 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L56:
        r24[6] = TuplesKt.to("share_screen_when_started", r26);
        if (r5 == false) goto L59;
        Object r27 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L60:
        r24[7] = TuplesKt.to("if_started_by_anchor", r27);
        if (r13 == false) goto L63;
        Object r28 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L64:
        r24[8] = TuplesKt.to("if_in_collection", r28);
        if (r35 == false) goto L67;
        Object r29 = "on";
    L68:
        r24[9] = TuplesKt.to("ad_status", r29);
        r24[10] = TuplesKt.to("certification", r0);
        if (r112 == false) goto L71;
        Object r31 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L72:
        r24[11] = TuplesKt.to("if_started_after_certification", r31);
        r24[12] = TuplesKt.to("source", jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource());
        Map r32 = MapsKt.mutableMapOf(r24);
        r32.put("room_live_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        u.l().sendLog("livesdk_live_game_start", r32, new Object[]{x.class, Room.class, com.bytedance.android.live.broadcastgame.api.c.class});
        this.p.c = System.currentTimeMillis();
        return;
    L71:
        r31 = "0";
        goto L72
    L67:
        r29 = "off";
        goto L68
    L63:
        r28 = "0";
        goto L64
    L59:
        r27 = "0";
        goto L60
    L55:
        r26 = "0";
    L48:
        r23 = "";
        goto L49
    L43:
        r21 = null;
        goto L44
    L39:
        r19 = null;
        goto L40
    L73:
        boolean r36 = r17;
        if (this.q == false) goto L148;
        int r113 = GameDataReportHelper.a;
        f r114 = this.m;
        if (r114 == null) goto L78;
        String r115 = r114.e;
    L79:
        f r33 = this.m;
        if (r33 == null) goto L82;
        Long r37 = Long.valueOf(r33.b);
    L83:
        f r38 = this.m;
        if (r38 == null) goto L87;
        String r39 = r38.a;
        if (r39 == null) goto L87;
    L88:
        long r310 = System.currentTimeMillis() - this.p.c;
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r41 = this.a;
        if (r41 == null) goto L91;
        Long r42 = r41.i();
    L92:
        String r116 = this.p.a();
        Intrinsics.checkNotNullParameter(r39, "appid");
        Pair[] r117 = new Pair[10];
        r117[0] = TuplesKt.to("game_name", String.valueOf(r115));
        r117[1] = TuplesKt.to("game_id", String.valueOf(r37));
        com.bytedance.android.livesdk.user.f r43 = jc1.k.n(IUserService.class).user();
        if (r43 == null) goto L95;
        String r45 = r43.n();
    L96:
        r117[2] = TuplesKt.to("user_id", r45);
        r117[3] = TuplesKt.to("game_app_id", r39);
        r117[4] = TuplesKt.to("user_type", "user");
        Long r46 = r42;
        if (r5 == false) goto L99;
        Object r47 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L100:
        r117[5] = TuplesKt.to("if_started_by_anchor", r47);
        boolean r210 = r13;
        if (r13 == false) goto L103;
        Object r48 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L104:
        r117[6] = TuplesKt.to("if_in_collection", r48);
        boolean r49 = com.bytedance.android.live.broadcastgame.api.interactgame.b.a;
        if (com.bytedance.android.live.broadcastgame.api.interactgame.b.a == false) goto L107;
        Object r51 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L108:
        r117[7] = TuplesKt.to("share_screen_when_started", r51);
        if (r9 != null) goto L111;
        String r52 = "more";
    L112:
        r117[8] = TuplesKt.to("source_type", r52);
        if (r36 == false) goto L115;
        Object r53 = "on";
    L116:
        r117[9] = TuplesKt.to("ad_status", r53);
        Map r54 = MapsKt.mutableMapOf(r117);
        String r311 = (String) r54.put("game_category", r116);
        r54.put("miniplugin_live_scene_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        u.l().sendLog("livesdk_live_game_end", r54, new Object[]{x.class, Room.class});
        Pair[] r55 = new Pair[13];
        r55[0] = TuplesKt.to("game_name", r115);
        r55[1] = TuplesKt.to("game_id", String.valueOf(r37));
        com.bytedance.android.livesdk.user.f r56 = jc1.k.n(IUserService.class).user();
        if (r56 == null) goto L119;
        String r57 = r56.n();
    L120:
        r55[2] = TuplesKt.to("user_id", r57);
        r55[3] = TuplesKt.to("game_app_id", r39);
        r55[4] = TuplesKt.to("user_type", "user");
        r55[5] = TuplesKt.to("duration", String.valueOf(r310));
        if (r5 == false) goto L123;
        Object r58 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L124:
        r55[6] = TuplesKt.to("if_started_by_anchor", r58);
        if (r210 == false) goto L127;
        Object r59 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L128:
        r55[7] = TuplesKt.to("if_in_collection", r59);
        if (com.bytedance.android.live.broadcastgame.api.interactgame.b.a == false) goto L131;
        Object r61 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L132:
        r55[8] = TuplesKt.to("share_screen_when_started", r61);
        if (r9 != null) goto L135;
        String r62 = "more";
    L136:
        r55[9] = TuplesKt.to("source_type", r62);
        if (r46 == null) goto L140;
        String r63 = String.valueOf(r46.longValue());
        if (r63 == null) goto L140;
    L141:
        r55[10] = TuplesKt.to("valid_duration", r63);
        if (r36 == false) goto L144;
        Object r64 = "on";
    L145:
        r55[11] = TuplesKt.to("ad_status", r64);
        r55[12] = TuplesKt.to("source", jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource());
        Map r65 = MapsKt.mutableMapOf(r55);
        String r66 = (String) r65.put("game_category", r116);
        u.l().sendLog("livesdk_game_duration", r65, new Object[]{x.class, Room.class});
        return;
    L144:
        r64 = "off";
    L140:
        r63 = String.valueOf(r310);
        goto L141
    L135:
        r62 = r9;
        goto L136
    L131:
        r61 = "0";
        goto L132
    L127:
        r59 = "0";
        goto L128
    L123:
        r58 = "0";
        goto L124
    L119:
        r57 = null;
        goto L120
    L115:
        r53 = "off";
        goto L116
    L111:
        r52 = r9;
        goto L112
    L107:
        r51 = "0";
        goto L108
    L103:
        r48 = "0";
        goto L104
    L99:
        r47 = "0";
        goto L100
    L95:
        r45 = null;
        goto L96
    L91:
        r42 = null;
    L87:
        r39 = "";
        goto L88
    L82:
        r37 = null;
        goto L83
    L78:
        r115 = null;
        goto L79
    L148:
        return;
    L33:
        r17 = false;
    L21:
        if (Intrinsics.areEqual(r9, "collection") == true) goto L22;
        r13 = false;
        goto L24
    L13:
        r8 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void w(f0 r31) {
        int r1 = q.a;
        q.f("AudiencePluginManager", new Object[]{"start plugin from entrance msg, name: ", r31.i, ", appId: ", r31.a, ", launch mode: ", Long.valueOf(r31.k)});
        ((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class)).recordGameIdentifier(r31.l);
        int r2 = com.bytedance.android.live.broadcastgame.api.interactgame.o.a;
        String r3 = r31.a;
        String r11 = r31.i;
        int r13 = (int) r31.k;
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r11, "appName");
        com.bytedance.android.live.broadcastgame.api.interactgame.o.a = r13;
        System.currentTimeMillis();
        this.l = true;
        this.n = r31;
        this.m = new f(r31.a, r31.f, r31.g, r31.m, r31.i, r31.j, r31.h, r31.c, r31.o, r31.p, r31.q, r31.u);
        if (Intrinsics.areEqual(r31.y, Boolean.FALSE) == false) goto L6;
        q.f("AudiencePluginManager", new Object[]{"start plugin intercepted by game info"});
        return;
    L6:
        Intrinsics.checkNotNullParameter(r31, "entrance");
        f r0 = this.m;
        if (r0 == null) goto L24;
        f r4 = this.m;
        if (r4 == null) goto L21;
        Pair[] r5 = new Pair[15];
        r5[0] = TuplesKt.to("game_type", Integer.valueOf(r4.d));
        r5[1] = TuplesKt.to("metrics", Boolean.valueOf(r4.i));
        r5[2] = TuplesKt.to("OPEN_APP_ICON_URL", r4.f);
        r5[3] = TuplesKt.to("OPEN_APP_NAME", r4.e);
        r5[4] = TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, r4.a);
        r5[5] = TuplesKt.to("conn_id", Long.valueOf(r4.h));
        r5[6] = TuplesKt.to("game_id", Long.valueOf(r4.b));
        r5[7] = TuplesKt.to("developer", r4.j);
        r5[8] = TuplesKt.to("business_type", Integer.valueOf(r4.k));
        r5[9] = TuplesKt.to("app_version", r4.c);
        r5[10] = TuplesKt.to("origin_info", this.n);
        r5[11] = TuplesKt.to("schema", r4.g);
        r5[12] = TuplesKt.to(NewBroadcastMonitor.PAGE.ROOM, m());
        DataCenter r6 = this.h;
        if (r6 != null) goto L14;
    L19:
        String r7 = "natural";
    L20:
        r5[13] = TuplesKt.to("is_ad_channel", r7);
        r5[14] = TuplesKt.to("source", Integer.valueOf(r4.l));
        Map<String, ? extends Object> r8 = MapsKt.mutableMapOf(r5);
    L22:
        Map<String, ? extends Object> r9 = r8;
        this.p.a = r9;
        i(r0.b, r0.a, r0.g, r9, false, false);
        return;
    L14:
        if (c1.b(r6) == false) goto L17;
        r7 = "dou_plus";
        goto L20
    L17:
        if (c1.c(r6) == false) goto L19;
        r7 = "effective_ad";
        goto L20
    L21:
        r8 = new LinkedHashMap();
        goto L22
    }

    public final void x(String r8) {
        if (this.m != null) goto L5;
        return;
    L5:
        int r0 = q.a;
        q.f("AudiencePluginManager", new Object[]{"stop plugin, reason: ", r8});
        u(false);
        Long r1 = this.s;
        if (r1 == null) goto L12;
        long r4 = r1.longValue();
        Lazy r2 = LiveOpenGameClient.d;
        OpenGameApi r3 = (OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class);
        Long r5 = Long.valueOf(r4);
        f r6 = this.m;
        if (r6 == null) goto L10;
        String r7 = r6.a;
    L11:
        a(r3.sendAudienceStop(r5, r7).subscribe(l.a, m.a));
        goto L12
    L10:
        r7 = null;
    L12:
        Map<String, String> r9 = this.p.b;
        f r11 = this.m;
        if (r11 == null) goto L15;
        String r12 = r11.a;
    L16:
        r9.remove(r12);
        this.m = null;
        this.l = false;
        this.o = true;
        b(r8);
        return;
    L15:
        r12 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager, com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void d(String r11, Map<String, String> r12) {
        int r0 = q.a;
        q.f("AudiencePluginManager", new Object[]{"show plugin unchecked, has shown: ", Boolean.valueOf(this.q), ", appId: ", r11});
        if (this.t != null) goto L12;
        Activity r1 = ContextUtil.contextToActivity(getContext());
        if (r1 == null) goto L7;
        e1 r7 = new e1(r1);
    L8:
        this.t = r7;
        if (r7 == null) goto L12;
        r7.c = s1.B(2131918967);
        goto L12
    L7:
        r7 = null;
    L12:
        if (this.q == false) goto L15;
        v(r11, r12);
        return;
    L15:
        if (r12 == null) goto L17;
        String r8 = r12.get("location");
    L19:
        if (Intrinsics.areEqual(r8, "from_debug") == true) goto L28;
        InteractGameContext r9 = InteractGameContext.Companion.getContext();
        if (r9 == null) goto L27;
        com.bytedance.live.datacontext.m<Boolean> r13 = r9.getHasDebugFloatBallShow();
        if (r13 == null) goto L27;
        if (((Boolean) r13.getValue()).booleanValue() == true) goto L28;
    L27:
        boolean r14 = false;
    L29:
        if (r12 == null) goto L32;
        String r2 = r12.get("location");
        if (r2 == null) goto L32;
    L34:
        switch(r2.hashCode()) {
            case -1808586370: goto L55;
            case -1741312354: goto L52;
            case -1271529498: goto L49;
            case -1244332508: goto L46;
            case -949931101: goto L43;
            case 214339523: goto L40;
            case 2139598963: goto L37;
            default: goto L57;
        };
    L57:
        int r15 = 8;
    L58:
        Lazy r3 = LiveOpenGameClient.d;
        OpenGameApi r4 = (OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class);
        Long r5 = Long.valueOf(this.i);
        Room r6 = m();
        if (r6 == null) goto L61;
        String r16 = r6.getOwnerUserIdString();
    L62:
        a(r4.sendAudienceStart(r5, r11, r16, com.bytedance.android.live.broadcastgame.api.interactgame.j.a(), r14, r15).subscribeOn(Schedulers.io()).doOnSubscribe(new h(this)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).doFinally(new i(this)).subscribe(new j(this, r11, r12), new k(this)));
        return;
    L61:
        r16 = null;
        goto L62
    L37:
        if (r2.equals("game_promote") == false) goto L57;
        r15 = 3;
        goto L58
    L40:
        if (r2.equals("from_temp_area") == false) goto L57;
        r15 = 6;
        goto L58
    L43:
        if (r2.equals("from_mini_card") == false) goto L57;
        r15 = 5;
        goto L58
    L46:
        if (r2.equals("from_jsb") == false) goto L57;
    L53:
        r15 = 4;
        goto L58
    L49:
        if (r2.equals("from_toolbar") == false) goto L57;
        r15 = 1;
        goto L58
    L52:
        if (r2.equals("collection") == false) goto L57;
    L55:
        if (r2.equals("from_debug") == false) goto L57;
        r15 = 2;
    L32:
        r2 = "";
    L28:
        r14 = true;
        goto L29
    L17:
        r8 = null;
        goto L19
    }

    public final void v(String r2, Map<String, String> r3) {
        super.d(r2, r3);
        if (this.q == true) goto L5;
        u(true);
    L5:
        this.p.e = false;
        this.q = true;
    }

    public static final void s(AudiencePluginManager r5, f0 r6, String r7) {
        r5.getClass();
        AudiencePluginManager$askSwitchGameIfNeed$1 r0 = new AudiencePluginManager$askSwitchGameIfNeed$1(r5, r6, r7);
        f r8 = r5.m;
        Context r1 = null;
        if (r8 == null) goto L5;
        String r9 = r8.a;
    L7:
        if (r9 != null) goto L9;
    L12:
        boolean r11 = true;
    L13:
        if (r11 == true) goto L34;
        f r12 = r5.m;
        if (r12 == null) goto L17;
        String r13 = r12.a;
    L19:
        if ((!Intrinsics.areEqual(r13, r6.a)) == false) goto L34;
        if (r5.q == false) goto L34;
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r14 = r5.a;
        if (r14 == null) goto L27;
        PluginContext r15 = r14.mo311getContext();
        if (r15 == null) goto L27;
        r1 = r15.getContext();
    L27:
        x0.d r16 = new x0.d();
        r16.b = r1;
        r16.a = 7;
        r16.k = false;
        r16.l = false;
        r16.c = "确认要切换吗?";
        r16.d = "进行中的功能将会自动结束";
        com.bytedance.android.live.broadcastgame.opengame.b r2 = new com.bytedance.android.live.broadcastgame.opengame.b(r5, r6, r0);
        x0.c[] r3 = r16.g;
        x0.c r4 = r3[0];
        if (r4 != null) goto L30;
        r4 = new x0.c();
        r3[0] = r4;
    L30:
        r4.a = "确认";
        r4.b = r2;
        com.bytedance.android.live.broadcastgame.opengame.c r17 = new com.bytedance.android.live.broadcastgame.opengame.c(r5, r6);
        x0.c[] r18 = r16.g;
        x0.c r19 = r18[1];
        if (r19 != null) goto L33;
        r19 = new x0.c();
        r18[1] = r19;
    L33:
        r19.a = "取消";
        r19.b = r17;
        x0.b.g(new x0(r16.b, r16));
        return;
    L17:
        r13 = null;
    L34:
        r0.m164invoke();
        return;
    L9:
        if (r9.length() == 0) goto L12;
        r11 = false;
        goto L13
    L5:
        r9 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.android.live.broadcastgame.opengame.AudiencePluginManager$startAndShowPlugin$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.live.broadcastgame.opengame.AudiencePluginManager$startAndShowPlugin$2] */
    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void g(final String r4, final Map<String, String> r5, final com.bytedance.android.live.broadcastgame.api.openplatform.f.a r6) {
        final String r0 = null;
        this.s = null;
        if (r5 == null) goto L5;
        r0 = r5.get("location");
    L5:
        OpenPlatformMonitorUtils r1 = OpenPlatformMonitorUtils.c;
        OpenPlatformMonitorUtils.a = System.currentTimeMillis();
        ?? r2 = new AudiencePluginManager$startAndShowPlugin$1(this, r4, r0, r5);
        ?? r3 = new AudiencePluginManager$startAndShowPlugin$2(this, r6, r4, r5);
        if (r6 == null) goto L8;
        r3.invoke(r0);
        return;
    L8:
        r2.invoke(r0);
    }

    public AudiencePluginManager(Context r11, DataCenter r12, long r13, ViewGroup r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "containerView");
        super(r11, r12, r13, r14);
        i0 r15 = new i0();
        this.o = true;
        this.p = new g(this);
        this.u = jc1.k.n(IHostApp.class).getAllLiveActivity();
        this.w = "";
        AudiencePluginManager$liveLifeCycle$1 r16 = new AudiencePluginManager$liveLifeCycle$1(this);
        this.y = r16;
        vlc.d r0 = (vlc.d) r12.get("data_message_manager", null);
        Room r1 = (Room) r12.get("data_room", null);
        if (r0 == null) goto L15;
        if (r1 == null) goto L15;
        r15.b(com.bytedance.android.live.broadcastgame.v.class, new l0(r0, r13, false, r12));
        r15.b(w.class, new com.bytedance.android.live.broadcastgame.opengame.message.x(r0));
        Observable r17 = r15.f(w.class);
        if (r17 == null) goto L15;
        Observable r18 = r17.subscribeOn(Schedulers.io());
        if (r18 == null) goto L15;
        Observable r19 = r18.observeOn(AndroidSchedulers.mainThread());
        if (r19 == null) goto L15;
        Disposable r110 = r19.subscribe(new a(this), b.a);
        if (r110 == null) goto L15;
        a(r110);
    L15:
        if (((Boolean) ye.a.getValue()).booleanValue() == false) goto L17;
        a(xs2.b.a().b(h1.class).subscribe(new c(this), d.a));
    L17:
        LinkedHashMap r6 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r6, "extraParams");
        Intrinsics.checkNotNullParameter(this, "pluginManager");
        Room r111 = m();
        if (r111 == null) goto L26;
        InteractOpenExtra r112 = r111.interactOpenExtra;
        if (r112 == null) goto L26;
        Map r113 = r112.getDebugInfo();
        if (r113 == null) goto L26;
        String r114 = (String) r113.get("app_kind");
        if (r114 == null) goto L26;
        long r115 = CastLongProtector.parseLong(r114);
    L28:
        if (r115 != 8) goto L30;
        PluginType r116 = PluginType.MINI_APP;
    L31:
        PluginType r2 = r116;
        if (r2 != PluginType.LYNX) goto L34;
        this.d.c(r2, getContext(), this.h, this.j, this, r6);
    L34:
        jc1.a.b().registerActivityLifecycleCallbacks(r16);
        return;
    L30:
        r116 = PluginType.LYNX;
    L26:
        r115 = -1;
        goto L28
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager
    public final com.bytedance.android.live.broadcastgame.opengame.runtime.q l(Context r9, long r11, DataCenter r12, com.bytedance.android.live.broadcastgame.opengame.f r13, PluginType r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r13, "gameIMManager");
        Intrinsics.checkNotNullParameter(r14, "pluginType");
        com.bytedance.android.live.broadcastgame.opengame.debug.d r0 = this.d;
        OpenPlatformBaseDebugger r1 = null;
        if (r0 == null) goto L8;
        if (r0.a == false) goto L8;
        r1 = r0.b;
    L8:
        return new com.bytedance.android.live.broadcastgame.opengame.runtime.d(r9, r11, r12, r13, r1);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager, com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void i(long r2, String r4, String r5, Map<String, ? extends Object> r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r6, "params");
        super.i(r2, r4, r5, r6, r7, r8);
        this.q = false;
    }
}
