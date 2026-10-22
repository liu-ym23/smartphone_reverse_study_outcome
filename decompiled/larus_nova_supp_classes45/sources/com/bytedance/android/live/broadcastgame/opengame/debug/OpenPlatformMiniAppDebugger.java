package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.g0;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.openplatform.miniapp.OpenOPAppHelper;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.wc;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.InteractOpenExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPlatformMiniAppDebugger extends OpenPlatformBaseDebugger implements vlc.l {
    public static final /* synthetic */ int h = 0;
    public vlc.d a;
    public Disposable b;
    public boolean c;
    public String d;
    public String e;
    public PluginType f;
    public final /* synthetic */ i20.a g;

    public static final class Companion {
        public static boolean b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "schema");
            if (r4.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return false;
        L8:
            Uri r5 = UriProtector.parse(r4);
            if (Intrinsics.areEqual(r5.getHost(), "microapp") == false) goto L35;
            String r1 = UriProtector.getQueryParameter(r5, "inspect");
            if (r1 != null) goto L13;
        L16:
            boolean r2 = true;
        L17:
            if (r2 == true) goto L35;
            String r3 = UriProtector.getQueryParameter(r5, "ide_inspect_version");
            if (r3 != null) goto L21;
        L24:
            boolean r6 = true;
        L25:
            if (r6 == true) goto L35;
            String r7 = UriProtector.getQueryParameter(r5, "ide_config");
            if (r7 != null) goto L29;
        L32:
            boolean r8 = true;
        L33:
            if (r8 == true) goto L35;
            return true;
        L29:
            if (r7.length() == 0) goto L32;
            r8 = false;
            goto L33
        L21:
            if (r3.length() == 0) goto L24;
            r6 = false;
            goto L25
        L13:
            if (r1.length() == 0) goto L16;
            r2 = false;
        L35:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        public static void a(final String r2, final a r3) {
            Intrinsics.checkNotNullParameter(r2, "shortLinkStr");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ThreadPoolHelper.c().execute(new OpenPlatformMiniAppDebugger$Companion$getDeepLink$1(r2, r3));
        }
    }

    public interface a {
        void onError(Throwable r1);

        void onSuccess(String r1);
    }

    public static final class b implements a {
        public final /* synthetic */ OpenPlatformMiniAppDebugger a;

        public b(OpenPlatformMiniAppDebugger r1) {
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
        public final void onSuccess(String r9) {
            Intrinsics.checkNotNullParameter(r9, "httpsLink");
            int r0 = q.a;
            q.g("访问短链，重定向后的 url : " + r9, "OP_MP_DEBUGGER");
            this.a.getClass();
            boolean r2 = false;
            if (r9.length() != 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L31;
            String r3 = UriProtector.parse(r9).getEncodedQuery();
            if (r3 != null) goto L12;
        L15:
            boolean r7 = true;
        L16:
            if (r7 == true) goto L31;
            String r11 = UriProtector.getQueryParameter(UriProtector.parse(r9), "tech_type");
            if (r11 == null) goto L21;
            Integer r12 = Integer.valueOf(CastIntegerProtector.parseInt(r11));
        L22:
            PluginType.a r8 = PluginType.Companion;
            if (r12 == null) goto L31;
            Integer r13 = Integer.valueOf(r12.intValue());
            r8.getClass();
            PluginType r14 = PluginType.a.b(r13);
            if (r14 == null) goto L31;
            if (l.b[r14.ordinal()] != 1) goto L31;
            String r15 = UriProtector.parse("snssdk1128://live_open_platform?").buildUpon().appendQueryParameter("timor_schema", "snssdk1128://microapp?" + r3).appendQueryParameter("enter_from", "IDE").appendQueryParameter("open_type", "developer_debug").build().toString();
        L32:
            q.g("url 适配为长链后 : " + r15, "OP_MP_DEBUGGER");
            OpenPlatformMiniAppDebugger r4 = this.a;
            r4.getClass();
            if (r15.length() != 0) goto L35;
            boolean r16 = true;
        L36:
            if (r16 == true) goto L60;
            Uri r17 = UriProtector.parse(r15);
            String r6 = UriProtector.getQueryParameter(r17, "timor_schema");
            String r5 = UriProtector.getQueryParameter(r17, "open_type");
            String r18 = UriProtector.getQueryParameter(r17, "enter_from");
            if (r6 != null) goto L41;
        L44:
            boolean r19 = true;
        L45:
            if (r19 == true) goto L60;
            if (r5 != null) goto L48;
        L51:
            boolean r21 = true;
        L52:
            if (r21 == true) goto L60;
            if (r18 != null) goto L55;
        L56:
            r2 = true;
        L57:
            if (r2 == true) goto L60;
            int r22 = r4.d(r6);
        L61:
            r4.e(r22);
            q.g("完成扫码校验，schema = " + this.a.d, "OP_MP_DEBUGGER");
            return;
        L55:
            if (r18.length() != 0) goto L57;
        L48:
            if (r5.length() == 0) goto L51;
            r21 = false;
            goto L52
        L41:
            if (r6.length() == 0) goto L44;
            r19 = false;
        L60:
            r22 = 101;
            goto L61
        L35:
            r16 = false;
            goto L36
        L21:
            r12 = null;
            goto L22
        L12:
            if (r3.length() == 0) goto L15;
            r7 = false;
        L31:
            r15 = "";
            goto L32
        L5:
            r1 = false;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            if ((((h0.c) sh6.c.b((sh6.b) r2)) instanceof h0.a) == false) goto L6;
            f2.b(2131920857, 0);
            int r3 = q.a;
            q.g("调试打开小游戏，加载失败", "OP_MP_DEBUGGER");
            return;
        }
    }

    static {
    }

    public final void h() {
        int r0 = q.a;
        q.g("执行 startDebug()", "OP_MP_DEBUGGER");
        String r3 = "";
        String r5 = JSONObjectProtectorUtils.getString(new JSONObject(this.e), "name");     // Catch: JSONException -> L8
        r3 = JSONObjectProtectorUtils.getString(new JSONObject(this.e), "icon");     // Catch: JSONException -> L6
    L12:
        if (r5.length() <= 0) goto L14;
        boolean r1 = true;
    L16:
        if (r1 == true) goto L19;
        r5 = "调试";
    L19:
        String r2 = "{\"game_id\":" + getGameId() + ",\"game_type\":1,\"group_type\":1,\"text_intro\" : \"当前直播间本地调试 : " + r5 + "\",\"need_game_desc\":false,\"rank\":99999,\"show_anchor_float_entrance\":true,\"show_audience_float_entrance\":true,\"app_id\":\"" + getAppId() + "\",\"schema\":\"" + this.d + "\"}";
        if (l.a[this.f.ordinal()] == 1) goto L22;
        int r9 = InteractID.Unknown.getValue();
    L23:
        int r19 = r9;
        u r15 = new u(r19, r5, CollectionsKt.emptyList(), 1, 1, CollectionsKt.emptyList(), r2);
        if (r15.c() == null) goto L70;
        r15.iconUrl = CollectionsKt.listOf(r3);
        Map r4 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_debug", Boolean.TRUE), TuplesKt.to("game", r15), TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, getAppId()), TuplesKt.to("game_id", Long.valueOf(getGameId())), TuplesKt.to("OPEN_APP_ICON_URL", r3)});
        if (r5.length() != 0) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L31;
        String r12 = "调试";
    L32:
        ImageModel r6 = new ImageModel();
        r6.setUrls(CollectionsKt.listOf(r3));
        Unit r7 = Unit.INSTANCE;
        InteractEntranceCell r8 = new InteractEntranceCell(r19, r12, "当前直播间本地调试", r6, 1, r2, 130976);
        r8.f.a = true;
        xs2.b.a().post(new g0(true, r8));
        if (this.f != PluginType.MINI_APP) goto L53;
        int r13 = OpenOPAppHelper.a;
        Context r14 = getContextWeakRef().get();
        if (r14 != null) goto L37;
        return;
    L37:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r16 = getPluginManager();
        if (r16 != null) goto L40;
        return;
    L40:
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "item");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r16, "pluginManager");
        ArrayList r17 = new ArrayList();
        RoomContext r18 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r18 == null) goto L52;
        com.bytedance.live.datacontext.n r21 = r18.getDataCenter();
        if (r21 == null) goto L52;
        DataCenter r22 = (DataCenter) r21.getValue();
        if (r22 == null) goto L52;
        OpenOPAppHelper.CheckOpenPlatformPluginRunningNode r23 = new OpenOPAppHelper.CheckOpenPlatformPluginRunningNode(r15, r22, r14, true);
        Intrinsics.checkNotNullParameter(r23, "node");
        r17.add(r23);
        OpenOPAppHelper.CheckGameConflictNode r24 = new OpenOPAppHelper.CheckGameConflictNode(r15, r22, r14);
        Intrinsics.checkNotNullParameter(r24, "node");
        r17.add(r24);
        OpenOPAppHelper.e r25 = new OpenOPAppHelper.e(r15, r4, r16);
        Intrinsics.checkNotNullParameter(r25, "node");
        r17.add(r25);
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r26 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.a();
        Iterator r27 = r17.iterator();
    L49:
        if (r27.hasNext() == false) goto L51;
        ((ArrayList) r26.a).add((com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b) r27.next());
        goto L49
    L51:
        r26.b = 0;
        r26.a();
    L52:
        int r28 = q.a;
        q.g("调试打开小程序，schema : " + this.d, "OP_MP_DEBUGGER");
    L53:
        InteractGameContext r29 = InteractGameContext.Companion.getContext();
        if (r29 == null) goto L71;
        com.bytedance.live.datacontext.n<h0.c> r31 = r29.getOpenGameLaunchResult();
        if (r31 == null) goto L72;
        Observable r32 = r31.a();
        if (r32 == null) goto L73;
        Observable r33 = r32.observeOn(AndroidSchedulers.mainThread());
        if (r33 == null) goto L74;
        Disposable r34 = r33.subscribe(c.a);
        if (r34 == null) goto L75;
        Intrinsics.checkNotNullParameter(r34, "$this$autoDispose");
        this.g.a(r34);
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L31:
        r12 = r5;
        goto L32
    L28:
        r11 = false;
        goto L29
    L70:
        return;
    L22:
        r9 = InteractID.OpenMicroApp.getValue();
        goto L23
    L14:
        r1 = false;
    L6:
        e = e;
    L10:
        e.printStackTrace();
        q.j(e, "OP_MP_DEBUGGER", 4);
    L8:
        e = e;
        r5 = "";
        goto L10
    }

    public OpenPlatformMiniAppDebugger() {
        this.g = new i20.a();
        this.d = "";
        this.e = "";
        this.f = PluginType.UNKNOWN_TYPE;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void releaseDebug() {
        super.releaseDebug();
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
        this.g.b();
        vlc.d r1 = this.a;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        this.a = null;
        int r2 = q.a;
        q.g("执行完 releaseDebug()", "OP_MP_DEBUGGER");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.debug.c
    public final PluginType getPluginType() {
        return this.f;
    }

    public final int d(String r6) {
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return 101;
    L9:
        PluginType r1 = this.f;
        PluginType.Companion.getClass();
        if (r1 == PluginType.a.a(r6)) goto L12;
        return 101;
    L12:
        Uri r2 = UriProtector.parse(r6);
        String r3 = UriProtector.getQueryParameter(r2, OpenPlatformBaseDebugger.APP_ID);
        String r4 = "";
        if ((!Intrinsics.areEqual(getAppId(), "")) == true) goto L15;
    L21:
        return OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH;
    L15:
        if (Intrinsics.areEqual(r3, getAppId()) == false) goto L21;
        this.d = r6;
        String r7 = UriProtector.getQueryParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        if (r7 == null) goto L20;
        r4 = r7;
    L20:
        this.e = r4;
        return 1;
    L5:
        r0 = false;
        goto L7
    }

    public final void e(int r7) {
        boolean r0 = true;
        if (r7 != 1) goto L5;
        h();
        String r2 = "可以调试";
    L15:
        int r3 = q.a;
        if (r7 == 1) goto L19;
        r0 = false;
    L19:
        q.b(r0, r2);
        return;
    L5:
        if (r7 == 102) goto L10;
        Context r4 = getContextWeakRef().get();
        if (r4 == null) goto L9;
        Toast r5 = Toast.makeText(r4, s1.B(2131920848), 0);
        r5.setGravity(17, 0, 0);
        r5.show();
    L9:
        r2 = s1.B(2131920847);
        goto L15
    L10:
        Context r6 = getContextWeakRef().get();
        if (r6 == null) goto L13;
        Toast r8 = Toast.makeText(r6, s1.B(2131920847), 0);
        r8.setGravity(17, 0, 0);
        r8.show();
    L13:
        r2 = s1.B(2131920848);
        goto L15
    }

    public final void g(Context r5) {
        x0.d r0 = new x0.d();
        r0.b = r5;
        r0.a = 4;
        r0.c = "提示";
        r0.d = "无法唤起调试工具, 请尝试重新开播";
        o r6 = o.a;
        x0.c[] r1 = r0.g;
        x0.c r3 = r1[0];
        if (r3 != null) goto L5;
        r3 = new x0.c();
        r1[0] = r3;
    L5:
        r3.a = "确定";
        r3.b = r6;
        x0.b.g(new x0(r0.b, r0));
    }

    public final void onMessage(tlc.d r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if ((r15 instanceof wc) == false) goto L24;
        int r0 = q.a;
        q.g("收到调试 IM：\n" + r15, "OP_MP_DEBUGGER");
        this.c = true;
        Disposable r1 = this.b;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        long r4 = 0;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L15;
        Room r5 = (Room) r3.getValue();
        if (r5 == null) goto L15;
        r4 = r5.id;
    L15:
        wc r16 = (wc) r15;
        setGameId(r16.getGameId());
        if (i(r4, getAppId(), r16.G(), r16.H(), r16.E()) == true) goto L18;
        UtilityKotlinExtentionsKt.s(0, false, false, OpenPlatformMiniAppDebugger$onMessage$1$1.INSTANCE, 7);
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：IM 消息校验失败"));
        return;
    L18:
        if (r16.E() != 8) goto L20;
        setPluginType(PluginType.MINI_APP);
    L20:
        f(true, null);
        createDebugFloatBall();
        h();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanFail(int r4) {
        f2.c(s1.B(2131920848), 0);
        int r0 = q.a;
        q.j(new Throwable("扫码错误，errorType = " + r4), "OP_MP_DEBUGGER", 4);
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanSuccess(String r4) {
        int r0 = q.a;
        q.g("扫码结果 : " + r4, "OP_MP_DEBUGGER");
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        f2.c(s1.B(2131920848), 0);
    L15:
        return false;
    L11:
        PluginType.Companion.getClass();
        if (PluginType.a.a(r4) != PluginType.MINI_APP) goto L14;
        e(d(r4));
        goto L15
    L14:
        Companion.a(r4, new b(this));
        goto L15
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final void setPluginType(PluginType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void f(boolean r2, Throwable r3) {
        if (r2 == false) goto L6;
        com.bytedance.android.live.broadcastgame.opengame.i.a r4 = getInitCallback();
        if (r4 == null) goto L11;
        r4.onInitSuccess();
    L11:
        setInitCallback(null);
        return;
    L6:
        com.bytedance.android.live.broadcastgame.opengame.i.a r5 = getInitCallback();
        if (r5 == null) goto L11;
        if (r3 != null) goto L10;
        r3 = new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：未知错误");
    L10:
        r5.a(r3);
        goto L11
    }

    public final boolean i(long r6, String r8, int r9, String r11, long r12) {
        boolean r0 = false;
        if (r12 == 8) goto L5;
    L7:
        boolean r13 = false;
    L8:
        StringBuilder r14 = new StringBuilder();
        r14.append(String.valueOf(r6));
        r14.append(r8);
        r14.append(String.valueOf(r9));
        int r7 = o10.a.a;
        byte[] r15 = Base64.decode("MWVlMTExZmVjZmZjMTJkMTcxOWE5NzBkZDE3N2UxZGE=", 0);
        Charset r16 = Charsets.UTF_8;
        r14.append(new String(r15, r16));
        String r17 = r14.toString();
        if (r13 == true) goto L11;
    L13:
        if (r0 == false) goto L15;
        String r18 = "可以展示调试悬浮球";
    L16:
        int r19 = q.a;
        q.a(r0, r18);
        return r0;
    L15:
        r18 = "无法展示调试悬浮求，签名校验失败，";
        goto L16
    L11:
        if (o10.a.a(r17, new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFzY1BaL08vek00MjV3N1BLYXU5cHYzVUtZL0I2VmtzaHhjMlpodW02Vm12Q082dTVHeXl2R0dWUHlsWWF6Wi9lNFQ2a1orOVBEc0V6UHZUbzVRb0ZDaTdkZTZlcktEa0o5VW4wY3NwbWFKKzlnT0JiaHZodEw4d2xYREVVUDBlMzRpdmJXMWw3NGNFelJjT1hNTUJIYVNWNlZWZEJteVZhemdVYzFtZmFKK09rT3BLRFdveDFwOXUvU3BlVXJEQ2pzZXJvajJ1aldwYjArYW92bnd4M2VOSVR5ZnJuN2NkNFlSYnFTMXkwalk3U3BhMTVJaFVWTkdlU1VabGFkbkZmbUZZaXRhb2JEdGttQ2h4UWo1OG5BZ1ZrTnBwZHF1VXBza1g5Zk1tNURINUI4QUppSzJTaGhQNUJQa2FjYUVERllHdkNhdzBQMWVsdkNjbmZnbHlDSHdJREFRQUI=", 0), r16), r11) == false) goto L13;
        r0 = true;
        goto L13
    L5:
        if (this.f != PluginType.MINI_APP) goto L7;
        r13 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void initDebug(Context r16, DataCenter r17, ViewGroup r18, com.bytedance.android.live.broadcastgame.api.openplatform.b r19, Map<String, ? extends Object> r21, com.bytedance.android.live.broadcastgame.opengame.i.a r22) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "dataCenter");
        Intrinsics.checkNotNullParameter(r18, "containerView");
        Intrinsics.checkNotNullParameter(r19, "gameManager");
        Intrinsics.checkNotNullParameter(r21, "extraParams");
        Intrinsics.checkNotNullParameter(r22, "callback");
        super.initDebug(r16, r17, r18, r19, r21, r22);
        int r2 = q.a;
        q.g("执行 initDebug()", "OP_MP_DEBUGGER");
        long r4 = 0;
        String r7 = "";
        boolean r11 = true;
        Object r12 = null;
        if (((Boolean) r17.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L55;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r3 = (vlc.d) r1.getValue();
    L10:
        this.a = r3;
        if (r3 == null) goto L53;
        r3.addMessageListener(MessageType.INTERACT_OPEN_DEVELOP_MESSAGE.getIntType(), this);
        Object r5 = r21.get("source_params");
        if ((r5 instanceof String) == false) goto L16;
        r12 = r5;
    L16:
        String r13 = (String) r12;
        if (r13 != null) goto L107;
        r13 = "";
    L107:
        JSONObject r6 = new JSONObject(r13);     // Catch: JSONException -> L51
        this.d = JSONObjectProtectorUtils.getString(r6, "timor_schema");     // Catch: JSONException -> L51
        String r8 = JSONObjectProtectorUtils.getString(r6, "open_type");     // Catch: JSONException -> L51
        String r9 = JSONObjectProtectorUtils.getString(r6, "enter_from");     // Catch: JSONException -> L51
        if (this.d.length() != 0) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L27;
    L50:
        f2.c(s1.B(2131920847), 0);
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：调试所需参数为空"));
        return;
    L27:
        if (r8.length() != 0) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L50;
        if (r9.length() == 0) goto L35;
        r11 = false;
    L35:
        if (r11 == true) goto L50;
        Uri r23 = UriProtector.parse(this.d);
        String r24 = UriProtector.getQueryParameter(r23, OpenPlatformBaseDebugger.APP_ID);
        if (r24 != null) goto L40;
        r24 = "";
    L40:
        setAppId(r24);
        String r25 = UriProtector.getQueryParameter(r23, LiveSlardarConstants.EXTRA_KEY_URL);
        if (r25 == null) goto L44;
        r7 = r25;
    L44:
        this.e = r7;
        Disposable r26 = this.b;
        if (r26 == null) goto L47;
        r26.dispose();
    L47:
        Disposable r27 = Observable.timer(1, TimeUnit.MINUTES).compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this), new n(this));
        this.b = r27;
        if (r27 == null) goto L109;
        Intrinsics.checkNotNullParameter(r27, "$this$autoDispose");
        this.g.a(r27);
        return;
    L109:
        return;
    L29:
        r15 = false;
        goto L30
    L24:
        r14 = false;
    L51:
        e = move-exception;
        e.printStackTrace();
        f2.c(s1.B(2131920847), 0);
        f(false, e);
        return;
    L53:
        g(r16);
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：messageManager 为空"));
        return;
    L9:
        r3 = null;
        goto L10
    L55:
        RoomContext r28 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r28 == null) goto L60;
        com.bytedance.live.datacontext.m r29 = r28.getRoom();
        if (r29 == null) goto L60;
        Room r31 = (Room) r29.getValue();
    L61:
        if (r31 == null) goto L105;
        InteractOpenExtra r32 = r31.interactOpenExtra;
        if (r32 == null) goto L70;
        Map r33 = r32.getDebugInfo();
        if (r33 == null) goto L70;
        String r34 = (String) r33.get(OpenPlatformBaseDebugger.APP_ID);
        if (r34 == null) goto L70;
        r7 = r34;
    L70:
        setAppId(r7);
        InteractOpenExtra r35 = r31.interactOpenExtra;
        if (r35 == null) goto L77;
        Map r36 = r35.getDebugInfo();
        if (r36 == null) goto L77;
        String r37 = (String) r36.get(OpenPlatformBaseDebugger.DEBUG_GAME_ID);
        if (r37 == null) goto L77;
        r4 = CastLongProtector.parseLong(r37);
    L77:
        setGameId(r4);
        InteractOpenExtra r38 = r31.interactOpenExtra;
        if (r38 == null) goto L84;
        Map r39 = r38.getDebugInfo();
        if (r39 == null) goto L84;
        String r41 = (String) r39.get("app_kind");
        if (r41 == null) goto L84;
        long r42 = CastLongProtector.parseLong(r41);
    L85:
        long r110 = r42;
        long r43 = r31.id;
        String r44 = getAppId();
        InteractOpenExtra r45 = r31.interactOpenExtra;
        if (r45 == null) goto L105;
        Map r46 = r45.getDebugInfo();
        if (r46 == null) goto L105;
        String r47 = (String) r46.get(OpenPlatformBaseDebugger.DEVELOP);
        if (r47 == null) goto L105;
        int r48 = CastIntegerProtector.parseInt(r47);
        InteractOpenExtra r49 = r31.interactOpenExtra;
        if (r49 == null) goto L105;
        Map r51 = r49.getDebugInfo();
        if (r51 == null) goto L105;
        String r52 = (String) r51.get(OpenPlatformBaseDebugger.SIGN);
        if (r52 == null) goto L105;
        if (i(r43, r44, r48, r52, r110) == true) goto L101;
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：观众端 room extra消息校验失败"));
        goto L105
    L101:
        if (r110 != 8) goto L103;
        setPluginType(PluginType.MINI_APP);
    L103:
        f(true, null);
    L84:
        r42 = -1;
    L105:
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：小程序观众端不需要 debugger"));
        return;
    L60:
        r31 = null;
        goto L61
    }
}
