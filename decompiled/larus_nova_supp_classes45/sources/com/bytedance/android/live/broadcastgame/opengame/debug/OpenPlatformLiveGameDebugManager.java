package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.g0;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.LogLevel;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.message.model.wc;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.InteractOpenExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsClient;
import com.bytedance.bdp.bdpbase.schema.SchemaInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/OpenPlatformLiveGameDebugManager;", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/OpenPlatformBaseDebugger;", "Lcom/bytedance/android/live/broadcastgame/opengame/j;", "Lvlc/l;", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/c;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/LynxDebugBridge;", "lynxDebugBridge", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/LynxDebugBridge;", "<init>", "()V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformLiveGameDebugManager extends OpenPlatformBaseDebugger implements com.bytedance.android.live.broadcastgame.opengame.j, vlc.l {
    public static final /* synthetic */ int g = 0;
    public boolean a;
    public Room b;
    public final String c;
    public vlc.d d;
    public PluginType e;
    public final /* synthetic */ i20.a f;
    private LynxDebugBridge lynxDebugBridge;

    public static final class a {
    }

    public static final class b implements OpenPlatformMiniAppDebugger.a {
        public final /* synthetic */ OpenPlatformLiveGameDebugManager a;

        public b(OpenPlatformLiveGameDebugManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger.a
        public final void onError(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Context r4 = this.a.getContextWeakRef().get();
            if (r4 == null) goto L6;
            Toast r5 = Toast.makeText(r4, s1.B(2131920848), 0);
            r5.setGravity(17, 0, 0);
            r5.show();
            return;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger.a
        public final void onSuccess(String r11) {
            Intrinsics.checkNotNullParameter(r11, "httpsLink");
            int r0 = q.a;
            q.h("访问短链，重定向后的 url : " + r11);
            OpenPlatformLiveGameDebugManager r1 = this.a;
            int r2 = OpenPlatformLiveGameDebugManager.g;
            r1.getClass();
            boolean r3 = false;
            if (r11.length() != 0) goto L5;
            boolean r4 = true;
        L6:
            Integer r5 = null;
            if (r4 == true) goto L43;
            String r6 = UriProtector.parse(r11).getEncodedQuery();
            if (r6 != null) goto L12;
        L13:
            r3 = true;
        L14:
            if (r3 == true) goto L43;
            String r7 = UriProtector.getQueryParameter(UriProtector.parse(r11), "tech_type");
            if (r7 == null) goto L19;
            Integer r8 = Integer.valueOf(CastIntegerProtector.parseInt(r7));
        L20:
            String r9 = UriProtector.getQueryParameter(UriProtector.parse(r11), "shelled_tech_type");
            if (r9 == null) goto L23;
            Integer r12 = Integer.valueOf(CastIntegerProtector.parseInt(r9));
        L25:
            if (r8 != null) goto L28;
        L34:
            PluginType.a r13 = PluginType.Companion;
            if (r8 == null) goto L43;
            Integer r14 = Integer.valueOf(r8.intValue());
            r13.getClass();
            PluginType r15 = PluginType.a.b(r14);
            if (r15 == null) goto L43;
            if (g.a[r15.ordinal()] != 1) goto L43;
            String r16 = "sslocal://microapp?" + r6;
        L44:
            String r17 = UriProtector.getQueryParameter(UriProtector.parse(r11), "shelled_tech_type");
            if (r17 == null) goto L47;
            r5 = Integer.valueOf(CastIntegerProtector.parseInt(r17));
        L47:
            if (r5 != null) goto L50;
        L52:
            this.a.h(r16);
            return;
        L50:
            if (r5.intValue() != 2) goto L52;
            this.a.g(r16);
            return;
        L28:
            if (r8.intValue() != 16) goto L34;
            if (r12 == null) goto L34;
            if (r12.intValue() != 2) goto L34;
            r16 = "sslocal://microapp?" + r6;
            goto L44
        L23:
            r12 = null;
            goto L25
        L19:
            r8 = null;
            goto L20
        L12:
            if (r6.length() != 0) goto L14;
        L43:
            r16 = "";
            goto L44
        L5:
            r4 = false;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r7) {
            if ((((h0.c) sh6.c.b((sh6.b) r7)) instanceof h0.a) == false) goto L6;
            UtilityKotlinExtentionsKt.s(0, false, false, OpenPlatformLiveGameDebugManager$startSonicPlugin$1$1$1.INSTANCE, 7);
            int r8 = q.a;
            q.g("调试打开小游戏，加载失败", "");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.j
    public final void a() {
        LynxDebugBridge r0 = this.lynxDebugBridge;
        if (r0 == null) goto L8;
        ILiveWsClient r1 = r0.a;
        if (r1 == null) goto L9;
        r1.disconnect();
        return;
    L9:
        return;
    }

    public OpenPlatformLiveGameDebugManager() {
        this.f = new i20.a();
        this.c = "tt-test_version";
        this.e = PluginType.LYNX;
    }

    public final boolean f() {
        if (v.a() == false) goto L13;
        Context r0 = getContextWeakRef().get();
        if (r0 == null) goto L9;
        SharedPreferences r1 = r0.getSharedPreferences("miniapp_live_card_tool", 0);
        if (r1 == null) goto L9;
        boolean r2 = r1.getBoolean("float_btn_enable", false);
    L10:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r2 = false;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void releaseDebug() {
        super.releaseDebug();
        vlc.d r0 = this.d;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.d = null;
        this.b = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void stopDebug() {
        super.stopDebug();
        this.f.b();
        xs2.b.a().post(new g0(false, null));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.debug.c
    public final PluginType getPluginType() {
        return this.e;
    }

    public final void g(String r8) {
        boolean r0 = f();
        if (r8 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        char r1 = 'e';
    L20:
        int r4 = q.a;
        if (r1 != 1) goto L23;
        boolean r5 = true;
    L24:
        q.b(r5, "");
        if (r1 == 1) goto L32;
        if (r1 == 'e') goto L30;
        if (r1 != 'f') goto L46;
        f2.b(2131920847, 0);
        return;
    L46:
        return;
    L30:
        f2.b(2131920848, 0);
        return;
    L32:
        SchemaInfo.a r2 = new SchemaInfo.a(r8);
        r2.a.put("origin_reference", "native_live");
        r2.a.put("business_extra", "{\"debugMode\":true}");
        SchemaInfo r6 = r2.a();     // Catch: Exception -> L35
    L36:
        if (r6 != null) goto L39;
        q.g("悬浮球增加 schema 参数失败", "");
        f2.c("悬浮球增加 schema 参数失败", 0);
        return;
    L39:
        IBroadcastService r7 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r7 == null) goto L47;
        r7.openPluginMiniApp(r6.s(), r6.a(), null, null);
        return;
    L47:
        return;
    L35:
        r6 = null;
        goto L36
    L23:
        r5 = false;
        goto L24
    L12:
        if (r0 == true) goto L18;
        String r9 = UriProtector.getQueryParameter(UriProtector.parse(r8), OpenPlatformBaseDebugger.APP_ID);
        if ((!Intrinsics.areEqual(getAppId(), "")) == true) goto L17;
    L19:
        r1 = 'f';
        goto L20
    L17:
        if (Intrinsics.areEqual(r9, getAppId()) == false) goto L19;
    L18:
        r1 = 1;
        goto L20
    L5:
        if (r8.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    public final void h(String r21) {
        int r2 = d(r21, true);
        if (r2 != 1) goto L27;
        Uri r3 = UriProtector.parse(r21);
        if (r3 == null) goto L7;
        String r4 = UriProtector.getQueryParameter(r3, "interact_type");
    L9:
        if (Intrinsics.areEqual("4", r4) == false) goto L11;
        String r5 = "{\"game_id\":" + getGameId() + ",\"game_type\":1,\"business_type\":5,\"group_type\":1,\"need_game_desc\":false,\"rank\":10,\"show_anchor_float_entrance\":true,\"show_audience_float_entrance\":true,\"app_id\":\"" + getAppId() + "\",\"app_version\":\"" + this.c + "\"}";
    L12:
        String r17 = r5;
        InteractID r18 = InteractID.SonicMiniGame;
        u r6 = new u(r18.getValue(), "调试", CollectionsKt.emptyList(), 1, 1, CollectionsKt.emptyList(), r17);
        r6.b.a = true;
        r r7 = r6.c();
        if (r7 == null) goto L34;
        Map<String, ? extends Object> r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_debug", Boolean.TRUE), TuplesKt.to("game", r6), TuplesKt.to("app_version", this.c), TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, getAppId()), TuplesKt.to("game_id", Long.valueOf(getGameId()))});
        com.bytedance.android.live.broadcastgame.api.openplatform.b r9 = getPluginManager();
        if (r9 == null) goto L17;
        r9.i(r7.p(), r7.b(), r21, r8, true, true);
    L17:
        ImageModel r11 = new ImageModel();
        r11.setUrls(CollectionsKt.emptyList());
        Unit r12 = Unit.INSTANCE;
        InteractEntranceCell r13 = new InteractEntranceCell(r18.getValue(), "调试", "当前直播间本地调试", r11, 1, r17, 130976);
        r13.f.a = true;
        xs2.b.a().post(new g0(true, r13));
        InteractGameContext r1 = InteractGameContext.Companion.getContext();
        if (r1 == null) goto L35;
        com.bytedance.live.datacontext.n<h0.c> r14 = r1.getOpenGameLaunchResult();
        if (r14 == null) goto L36;
        Observable r15 = r14.a();
        if (r15 == null) goto L37;
        Disposable r16 = r15.subscribe(c.a);
        if (r16 == null) goto L38;
        Intrinsics.checkNotNullParameter(r16, "$this$autoDispose");
        this.f.a(r16);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L11:
        r5 = "{\"game_id\":" + getGameId() + ",\"game_type\":1,\"group_type\":1,\"need_game_desc\":false,\"rank\":10,\"show_anchor_float_entrance\":true,\"show_audience_float_entrance\":true,\"app_id\":\"" + getAppId() + "\",\"app_version\":\"" + this.c + "\"}";
        goto L12
    L7:
        r4 = null;
        goto L9
    L27:
        if (r2 != 101) goto L29;
        f2.b(2131920848, 0);
        return;
    L29:
        if (r2 != 102) goto L41;
        f2.b(2131920847, 0);
        return;
    }

    public final void onMessage(tlc.d r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if ((r9 instanceof wc) == false) goto L18;
        Room r0 = this.b;
        if (r0 == null) goto L19;
        wc r11 = (wc) r9;
        if (e(r0.id, r11.getAppId(), r11.G(), r11.H(), r11.E()) == false) goto L13;
        setAppId(r11.getAppId());
        setGameId(r11.getGameId());
        createDebugFloatBall();
        com.bytedance.android.live.broadcastgame.opengame.i.a r12 = getInitCallback();
        if (r12 == null) goto L12;
        r12.onInitSuccess();
    L12:
        setInitCallback(null);
        return;
    L13:
        com.bytedance.android.live.broadcastgame.opengame.i.a r13 = getInitCallback();
        if (r13 == null) goto L21;
        r13.a(new Throwable("Lynx Debug 初始化失败，原因：校验失败"));
        return;
    L21:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanFail(int r2) {
        f2.b(2131920850, 0);
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanSuccess(String r22) {
        int r0 = q.a;
        ALogger.d("OpenPlatformLog", "扫描成功, schema: " + r22);
        if (r22 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        f2.c(s1.B(2131920848), 0);
        return false;
    L13:
        Object r4 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        String r3 = UriProtector.getQueryParameter(UriProtector.parse(r22), "tech_type");     // Catch: Throwable -> L20
        if (r3 == null) goto L17;
        Integer r5 = Integer.valueOf(CastIntegerProtector.parseInt(r3));     // Catch: Throwable -> L20
    L18:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r6) == false) goto L25;
        r6 = null;
    L25:
        Integer r7 = (Integer) r6;
        String r8 = UriProtector.getQueryParameter(UriProtector.parse(r22), "shelled_tech_type");     // Catch: Throwable -> L32
        if (r8 == null) goto L29;
        Integer r9 = Integer.valueOf(CastIntegerProtector.parseInt(r8));     // Catch: Throwable -> L32
    L30:
        Object r11 = Result.constructor-impl(r9);     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r11) == true) goto L38;
        r4 = r11;
    L38:
        Integer r12 = (Integer) r4;
        if (r7 != null) goto L42;
    L49:
        PluginType.Companion.getClass();
        if (PluginType.a.a(r22) != PluginType.LYNX) goto L68;
        int r13 = d(r22, false);
        if (r13 != 1) goto L60;
        u r14 = new u(1, "test", CollectionsKt.emptyList(), 1, 1, CollectionsKt.emptyList(), "{\"game_id\":" + getGameId() + ",\"game_type\":1,\"group_type\":1,\"need_game_desc\":false,\"rank\":10,\"show_anchor_float_entrance\":true,\"show_audience_float_entrance\":true,\"app_id\":\"" + getAppId() + "\",\"app_version\":\"" + this.c + "\"}");
        r14.b.a = true;
        r r15 = r14.c();
        if (r15 == null) goto L58;
        Map<String, ? extends Object> r16 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_debug", Boolean.TRUE), TuplesKt.to("game", r14), TuplesKt.to("app_version", this.c), TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, getAppId()), TuplesKt.to("game_id", Long.valueOf(getGameId()))});
        com.bytedance.android.live.broadcastgame.api.openplatform.b r17 = getPluginManager();
        if (r17 == null) goto L58;
        r17.i(r15.p(), r15.b(), r22, r16, true, true);
    L58:
        return false;
    L60:
        if (r13 != 101) goto L62;
        f2.b(2131920848, 0);
        return true;
    L62:
        if (r13 != 102) goto L79;
        f2.b(2131920847, 0);
        return true;
    L79:
        return true;
    L68:
        if (PluginType.a.a(r22) != PluginType.SONIC_GAME) goto L71;
        h(r22);
        return false;
    L71:
        int r18 = OpenPlatformMiniAppDebugger.h;
        OpenPlatformMiniAppDebugger.Companion.a(r22, new b(this));
        return false;
    L42:
        if (r7.intValue() != 16) goto L49;
        if (r12 == null) goto L49;
        if (r12.intValue() != 2) goto L49;
        g(r22);
        return false;
    L29:
        r9 = null;
    L32:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L17:
        r5 = null;
    L20:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L5:
        if (r22.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final void setPluginType(PluginType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.j
    public final void b(Uri r8, Function3<? super String, ? super String, ? super String, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "schemaInfo");
        Intrinsics.checkNotNullParameter(r9, "openPanel");
        String r1 = UriProtector.getQueryParameter(r8, LiveSlardarConstants.EXTRA_KEY_URL);
        String r11 = UriProtector.getQueryParameter(r8, NewBroadcastMonitor.PAGE.ROOM);
        if (r1 == null) goto L15;
        if (r11 == null) goto L16;
        LynxDebugBridge r3 = this.lynxDebugBridge;
        if (r3 == null) goto L17;
        Context r4 = getContextWeakRef().get();
        Intrinsics.checkNotNullParameter(r1, "wsUrl");
        Intrinsics.checkNotNullParameter(r11, NewBroadcastMonitor.PAGE.ROOM);
        Intrinsics.checkNotNullParameter(r9, "openPanel");
        r3.d = r11;
        r3.b = r9;
        if (r3.c == false) goto L12;
        r3.c = false;
        ILiveWsClient r12 = r3.a;
        if (r12 == null) goto L12;
        r12.disconnect();
    L12:
        if (r4 == null) goto L18;
        r3.a = jc1.k.n(IHostBusiness.class).connectWebsocket(r4, r1, r3, 0L);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.j
    public final void c(String r6, LogLevel r7) {
        Intrinsics.checkNotNullParameter(r6, "log");
        Intrinsics.checkNotNullParameter(r7, "level");
        LynxDebugBridge r2 = this.lynxDebugBridge;
        if (r2 == null) goto L13;
        Intrinsics.checkNotNullParameter(r6, "log");
        Intrinsics.checkNotNullParameter(r7, "level");
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("log", r6);
        String r8 = r7.name();
        Locale r9 = Locale.getDefault();
        if (r8 == null) goto L12;
        r3[1] = TuplesKt.to("level", r8.toLowerCase(r9));
        if (r2.e == false) goto L9;
        String r11 = "anchor";
    L10:
        r3[2] = TuplesKt.to("target", r11);
        r2.a("log", null, MapsKt.mutableMapOf(r3));
        return;
    L9:
        r11 = "audience";
        goto L10
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final int d(String r11, boolean r12) {
        Uri r0 = UriProtector.parse(r11);
        boolean r2 = false;
        if (r0 == null) goto L25;
        Intrinsics.checkNotNullParameter(r0, "$this$isDebugOrPreviewMode");
        if (Intrinsics.areEqual(r0.getScheme(), "livegame") == false) goto L9;
        if (Intrinsics.areEqual(r0.getHost(), "remote_debug_livegame") == false) goto L9;
    L22:
        boolean r6 = true;
    L24:
        if (r6 != true) goto L25;
    L26:
        String r13 = UriProtector.getQueryParameter(r0, OpenPlatformBaseDebugger.APP_ID);
        if (r11 != null) goto L29;
    L36:
        int r14 = 101;
    L37:
        if (r14 == 1) goto L43;
        if (r14 == 101) goto L42;
        if (r14 == 102) goto L41;
        String r15 = "未知原因";
    L44:
        int r1 = q.a;
        if (r14 != 1) goto L47;
        r2 = true;
    L47:
        q.b(r2, r15);
        return r14;
    L41:
        r15 = "二维码 appid 与房间的调试 appid 不匹配";
        goto L44
    L42:
        r15 = "二维码不合法";
        goto L44
    L43:
        r15 = "可以调试";
        goto L44
    L29:
        if ((!Intrinsics.areEqual(getAppId(), "")) == true) goto L31;
    L35:
        r14 = OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH;
        goto L37
    L31:
        if ((!Intrinsics.areEqual(r11, "")) == false) goto L35;
        if (Intrinsics.areEqual(r13, getAppId()) == false) goto L35;
        r14 = 1;
    L9:
        if (Intrinsics.areEqual(r0.getScheme(), "sslocal") == true) goto L11;
    L23:
        r6 = false;
        goto L24
    L11:
        if (Intrinsics.areEqual(r0.getHost(), "microgame") == false) goto L23;
        String r7 = UriProtector.getQueryParameter(r0, "version_type");
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        if (Intrinsics.areEqual(r7, "preview") == true) goto L22;
        String r8 = UriProtector.getQueryParameter(r0, "version_type");
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        if (Intrinsics.areEqual(r8, "latest") == false) goto L23;
    L25:
        if (r12 == false) goto L36;
        goto L26
    }

    public static boolean e(long r5, String r7, int r8, String r9, long r11) {
        boolean r0 = true;
        if (r11 != 6) goto L5;
    L8:
        boolean r12 = true;
    L9:
        StringBuilder r13 = new StringBuilder();
        r13.append(String.valueOf(r5));
        r13.append(r7);
        r13.append(String.valueOf(r8));
        int r6 = o10.a.a;
        byte[] r14 = Base64.decode("MWVlMTExZmVjZmZjMTJkMTcxOWE5NzBkZDE3N2UxZGE=", 0);
        Charset r15 = Charsets.UTF_8;
        r13.append(new String(r14, r15));
        String r16 = r13.toString();
        if (r12 == true) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == false) goto L17;
        String r17 = "可以展示调试悬浮球";
    L18:
        int r18 = q.a;
        q.a(r0, r17);
        return r0;
    L17:
        r17 = "无法展示调试悬浮求，签名校验失败，";
        goto L18
    L12:
        if (o10.a.a(r16, new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFzY1BaL08vek00MjV3N1BLYXU5cHYzVUtZL0I2VmtzaHhjMlpodW02Vm12Q082dTVHeXl2R0dWUHlsWWF6Wi9lNFQ2a1orOVBEc0V6UHZUbzVRb0ZDaTdkZTZlcktEa0o5VW4wY3NwbWFKKzlnT0JiaHZodEw4d2xYREVVUDBlMzRpdmJXMWw3NGNFelJjT1hNTUJIYVNWNlZWZEJteVZhemdVYzFtZmFKK09rT3BLRFdveDFwOXUvU3BlVXJEQ2pzZXJvajJ1aldwYjArYW92bnd4M2VOSVR5ZnJuN2NkNFlSYnFTMXkwalk3U3BhMTVJaFVWTkdlU1VabGFkbkZmbUZZaXRhb2JEdGttQ2h4UWo1OG5BZ1ZrTnBwZHF1VXBza1g5Zk1tNURINUI4QUppSzJTaGhQNUJQa2FjYUVERllHdkNhdzBQMWVsdkNjbmZnbHlDSHdJREFRQUI=", 0), r15), r9) == false) goto L14;
    L5:
        if (r11 == 9) goto L8;
        r12 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void initDebug(Context r8, DataCenter r9, ViewGroup r11, com.bytedance.android.live.broadcastgame.api.openplatform.b r12, Map<String, ? extends Object> r13, com.bytedance.android.live.broadcastgame.opengame.i.a r14) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        Intrinsics.checkNotNullParameter(r11, "containerView");
        Intrinsics.checkNotNullParameter(r12, "gameManager");
        Intrinsics.checkNotNullParameter(r13, "extraParams");
        Intrinsics.checkNotNullParameter(r14, "callback");
        super.initDebug(r8, r9, r11, r12, r13, r14);
        this.a = ((Boolean) r9.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        Room r15 = (Room) r9.get("data_room", null);
        this.b = r15;
        if (this.a == true) goto L50;
        if (r15 == null) goto L56;
        InteractOpenExtra r16 = r15.interactOpenExtra;
        if (r16 == null) goto L11;
        Map r17 = r16.getDebugInfo();
        if (r17 == null) goto L11;
        String r18 = (String) r17.get(OpenPlatformBaseDebugger.APP_ID);
        if (r18 == null) goto L11;
    L12:
        setAppId(r18);
        InteractOpenExtra r19 = r15.interactOpenExtra;
        if (r19 == null) goto L19;
        Map r21 = r19.getDebugInfo();
        if (r21 == null) goto L19;
        String r22 = (String) r21.get(OpenPlatformBaseDebugger.DEBUG_GAME_ID);
        if (r22 == null) goto L19;
        long r110 = CastLongProtector.parseLong(r22);
    L20:
        setGameId(r110);
        InteractOpenExtra r23 = r15.interactOpenExtra;
        if (r23 == null) goto L27;
        Map r24 = r23.getDebugInfo();
        if (r24 == null) goto L27;
        String r25 = (String) r24.get("app_kind");
        if (r25 == null) goto L27;
        long r111 = CastLongProtector.parseLong(r25);
    L28:
        long r5 = r111;
        long r0 = r15.id;
        String r2 = getAppId();
        InteractOpenExtra r26 = r15.interactOpenExtra;
        if (r26 == null) goto L56;
        Map r27 = r26.getDebugInfo();
        if (r27 == null) goto L56;
        String r28 = (String) r27.get(OpenPlatformBaseDebugger.DEVELOP);
        if (r28 == null) goto L56;
        int r3 = CastIntegerProtector.parseInt(r28);
        InteractOpenExtra r29 = r15.interactOpenExtra;
        if (r29 == null) goto L56;
        Map r31 = r29.getDebugInfo();
        if (r31 == null) goto L56;
        String r4 = (String) r31.get(OpenPlatformBaseDebugger.SIGN);
        if (r4 == null) goto L56;
        if (e(r0, r2, r3, r4, r5) == false) goto L47;
        createDebugFloatBall();
        com.bytedance.android.live.broadcastgame.opengame.i.a r32 = getInitCallback();
        if (r32 == null) goto L46;
        r32.onInitSuccess();
    L46:
        setInitCallback(null);
        goto L56
    L47:
        com.bytedance.android.live.broadcastgame.opengame.i.a r33 = getInitCallback();
        if (r33 == null) goto L56;
        r33.a(new Throwable("Lynx Debug 初始化失败，原因：校验失败"));
    L27:
        r111 = -1;
    L19:
        r110 = 0;
    L11:
        r18 = "";
    L56:
        this.lynxDebugBridge = new LynxDebugBridge(this.a);
        return;
    L50:
        vlc.d r34 = (vlc.d) r9.get("data_message_manager", null);
        this.d = r34;
        if (r34 == null) goto L54;
        r34.addMessageListener(MessageType.INTERACT_OPEN_DEVELOP_MESSAGE.getIntType(), this);
    L54:
        if (f() == false) goto L56;
        createDebugFloatBall();
        goto L56
    }
}
