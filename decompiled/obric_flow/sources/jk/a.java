package jk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import cj.j;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.protocol.d;
import com.bytedance.sdk.xbridge.cn.protocol.e;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.ui.image.v;
import com.squareup.javapoet.i;
import com.squareup.javapoet.u;
import com.squareup.javapoet.x;
import g8.g;
import i8.b;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.lang.model.element.Modifier;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import ym.p;
import zm.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j, i8.a {
    public static volatile a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f18349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f18351c;
    public final Object d;
    public Object e;

    public a(int r5) {
        switch(r5) {
            case 1: goto L7;
            case 2: goto L3;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        this.f18349a = null;
        this.f18350b = 0;
        this.f18351c = null;
        this.d = new HashMap();
        this.e = null;
        return;
    L5:
        this.f18349a = new double[4];
        this.f18350b = new double[3];
        this.f18351c = new double[3];
        this.d = new double[3];
        this.e = new double[3];
        return;
    L7:
        this.f18350b = new AtomicInteger();
        this.e = new p(6);
        this.d = new bk.a();
    }

    public static void h(double[] r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.length) goto L6;
        r5[r10] = 0.0d;
        r10 = r10 + 1;
        goto L4
    }

    public static a m() {
        if (f != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L11;
        f = new a(0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f;
    }

    @Override // cj.j
    public void a(HashMap r24) {
        Intrinsics.checkNotNullParameter(r24, "data");
        Object r5 = r24.get("__jsb2__data__");
        boolean r10 = true;
        IDLXBridgeMethod r11 = (IDLXBridgeMethod) this.d;
        d r12 = (d) this.f18351c;
        e r13 = (e) this.f18350b;
        bj.a r14 = (bj.a) this.f18349a;
        String r16 = null;
        if (r5 != null) goto L5;
    L66:
        LinkedHashMap r15 = vi.a.f22583a;
        String r17 = r14.f932a;
        Intrinsics.checkNotNullParameter(r17, "methodName");
        cj.d r18 = (cj.d) this.e;
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r24, "data");
        if (Intrinsics.areEqual(r18.mo117b(), "webcast") == false) goto L109;
        Object r22 = "msg";
        if (r18.mo116a() != PlatformType.f7288b) goto L111;
        Boolean r19 = (Boolean) vi.a.f22583a.get(r17);
        if (r19 == null) goto L73;
        boolean r20 = r19.booleanValue();
    L74:
        if (r20 == false) goto L111;
        LinkedHashMap r21 = new LinkedHashMap();
        r21.putAll(r24);
        if ((r24.get("data") instanceof Map) == false) goto L104;
        Object r23 = r24.get("code");
        Object r25 = r24.get("data");
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Iterator r26 = ((Map) r25).entrySet().iterator();
        boolean r27 = false;
    L79:
        if (r26.hasNext() == false) goto L88;
        Map.Entry r110 = (Map.Entry) r26.next();
        Object r111 = r110.getValue();
        if (r111 == null) goto L79;
        r21.put(String.valueOf(r110.getKey()), r111);
        if (Intrinsics.areEqual("code", String.valueOf(r110.getKey())) == true) goto L84;
        if (Intrinsics.areEqual("data", String.valueOf(r110.getKey())) == false) goto L79;
        r27 = true;
        goto L79
    L84:
        r21.put("__code", r111);
        goto L79
    L88:
        if (r27 == true) goto L90;
        r21.remove("data");
    L90:
        ConcurrentHashMap r28 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r29 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r29 == null) goto L97;
        xc.d r30 = (xc.d) r29.a(xc.d.class);
        if (r30 == null) goto L97;
        Boolean r31 = r30.O0();
        if (r31 == null) goto L97;
        boolean r32 = r31.booleanValue();
    L98:
        if (r32 == true) goto L100;
        r21.put("__code", r23);
    L108:
        r21.put("code", 1);
        boolean r33 = false;
        HashMap r34 = r21;
    L140:
        Object r35 = r34.get("code");
        if ((r35 instanceof Integer) == false) goto L143;
        Integer r36 = (Integer) r35;
    L144:
        if (r36 == null) goto L146;
        int r37 = r36.intValue();
    L147:
        r14.f938k = r37;
        Object r38 = r34.get(r22);
        if ((r38 instanceof String) == false) goto L150;
        String r39 = (String) r38;
    L151:
        if (r39 != null) goto L159;
        Object r40 = r34.get("message");
        if ((r40 instanceof String) == false) goto L155;
        r16 = (String) r40;
    L155:
        if (r16 != null) goto L158;
        r39 = "unknown error 2";
        goto L159
    L158:
        r39 = r16;
    L159:
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        r14.f939l = r39;
        if (r37 != 1) goto L162;
        boolean r41 = true;
    L163:
        r14.f940m = r41;
        r13.c(r12.a().a(r34, r11.getClass(), r14));
        return;
    L162:
        r41 = r33;
        goto L163
    L150:
        r39 = null;
        goto L151
    L146:
        r37 = 1;
        goto L147
    L143:
        r36 = null;
        goto L144
    L100:
        if (r21.get("__code") != null) goto L108;
        r21.put("__code", r23);
    L97:
        r32 = true;
        goto L98
    L104:
        if (r24.get("__code") != null) goto L108;
        Object r42 = r24.get("code");
        if (r42 == null) goto L108;
        r21.put("__code", r42);
        goto L108
    L73:
        r20 = false;
    L111:
        if (Intrinsics.areEqual(r18.mo117b(), "webcast") == true) goto L113;
    L139:
        r33 = false;
        r34 = r24;
        goto L140
    L113:
        if (r18.mo116a() != PlatformType.f7287a) goto L139;
        Boolean r43 = (Boolean) vi.a.f22583a.get(r17);
        if (r43 == null) goto L117;
        boolean r44 = r43.booleanValue();
    L118:
        if (r44 == false) goto L139;
        LinkedHashMap r45 = new LinkedHashMap();
        r45.putAll(r24);
        r45.put("__msg_type", "callback");
        r33 = false;
        r45.put("eventId", 0);
        r45.put("__callback_id", "0");
        if ((r24.get("data") instanceof Map) == false) goto L138;
        ConcurrentHashMap r46 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r47 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r47 == null) goto L128;
        xc.d r48 = (xc.d) r47.a(xc.d.class);
        if (r48 == null) goto L128;
        Boolean r49 = r48.O0();
        if (r49 == null) goto L128;
        boolean r50 = r49.booleanValue();
    L129:
        if (r50 == false) goto L133;
        Object r51 = r24.get("data");
        Intrinsics.checkNotNull(r51, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Map r52 = (Map) r51;
        Object r53 = r52.get("__code");
        if (r53 != null) goto L134;
        r53 = r52.get("code");
    L134:
        LinkedHashMap r54 = new LinkedHashMap();
        Object r55 = r24.get("data");
        Intrinsics.checkNotNull(r55, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
        r54.putAll((Map) r55);
        if (r53 == null) goto L137;
        r54.put("__code", r53);
    L137:
        r45.put("data", r54);
        goto L138
    L133:
        r53 = r45.get("code");
    L128:
        r50 = true;
    L138:
        r45.put("code", 1);
        r34 = r45;
        goto L140
    L117:
        r44 = false;
        goto L118
    L109:
        r22 = "msg";
        goto L111
    L5:
        if ((r5 instanceof JSONObject) == false) goto L66;
        Object r56 = ((JSONObject) r5).opt("code");
        if ((r56 instanceof Integer) == false) goto L9;
        Integer r57 = (Integer) r56;
    L10:
        if (r57 == null) goto L12;
        int r58 = r57.intValue();
    L13:
        r14.f938k = r58;
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L17
        Object r60 = ((JSONObject) r5).opt("msg");     // Catch: Throwable -> L17
        if ((r60 instanceof String) == false) goto L19;
        String r61 = (String) r60;     // Catch: Throwable -> L17
    L20:
        if (r61 == null) goto L22;
        Object r62 = ((JSONObject) r5).opt("msg");     // Catch: Throwable -> L17
    L48:
        Object r63 = Result.m124constructorimpl(r62);     // Catch: Throwable -> L17
    L52:
        if (Result.m127exceptionOrNullimpl(r63) == null) goto L56;
        r63 = "wrap2 data: " + r5;
    L56:
        if ((r63 instanceof String) == false) goto L58;
        r16 = (String) r63;
    L58:
        if (r16 != null) goto L60;
        r16 = "wrap3 data: " + r5;
    L60:
        String r64 = r16;
        Intrinsics.checkNotNullParameter(r64, "<set-?>");
        r14.f939l = r64;
        if (r58 == 1) goto L64;
        r10 = false;
    L64:
        r14.f940m = r10;
        r13.c(r12.a().a(r24, r11.getClass(), r14));
        return;
    L22:
        Object r65 = ((JSONObject) r5).opt("message");     // Catch: Throwable -> L17
        if ((r65 instanceof String) == false) goto L25;
        String r66 = (String) r65;     // Catch: Throwable -> L17
    L26:
        if (r66 == null) goto L28;
        r62 = ((JSONObject) r5).opt("message");     // Catch: Throwable -> L17
        goto L48
    L28:
        Object r67 = ((JSONObject) r5).opt("data");     // Catch: Throwable -> L17
        if ((r67 instanceof JSONObject) == false) goto L31;
        JSONObject r68 = (JSONObject) r67;     // Catch: Throwable -> L17
    L32:
        if (r68 == null) goto L34;
        Object r69 = r68.opt("msg");     // Catch: Throwable -> L17
    L36:
        if ((r69 instanceof String) == false) goto L38;
        String r70 = (String) r69;     // Catch: Throwable -> L17
    L39:
        if (r70 == null) goto L47;
        Object r71 = ((JSONObject) r5).opt("data");     // Catch: Throwable -> L17
        if ((r71 instanceof JSONObject) == false) goto L43;
        JSONObject r72 = (JSONObject) r71;     // Catch: Throwable -> L17
    L44:
        if (r72 == null) goto L46;
        r62 = r72.opt("msg");     // Catch: Throwable -> L17
        goto L48
    L46:
        r62 = null;
        goto L48
    L43:
        r72 = null;
        goto L44
    L47:
        r62 = "wrap1 data: " + r5;     // Catch: Throwable -> L17
        goto L48
    L38:
        r70 = null;
        goto L39
    L34:
        r69 = null;
        goto L36
    L31:
        r68 = null;
        goto L32
    L25:
        r66 = null;
        goto L26
    L19:
        r61 = null;
    L17:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        r63 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L52
    L12:
        r58 = 1;
        goto L13
    L9:
        r57 = null;
        goto L10
    }

    @Override // i8.a
    public void b(String r5, JSONObject r10) {
    }

    @Override // i8.a
    public void c(WsChannelMsg r5, boolean r10) {
        int r11 = r5.f4011j;
        if (g8.e.f17066a.get(Integer.valueOf(r11)) != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    @Override // i8.a
    public void d(SocketState r5) {
        ((ConcurrentHashMap) ((i4.a) this.f18349a).f17503c).put(Integer.valueOf(r5.d), r5);
        Intent r10 = new Intent();     // Catch: Throwable -> L5
        r10.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L5
        r10.putExtra(WsConstants.KEY_CONNECTION, r5);     // Catch: Throwable -> L5
        ((c) this.f18350b).j(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // i8.a
    public void e(b r5, int r10, JSONObject r11) {
        if (r11 == null) goto L15;
        r11.put(WsConstants.KEY_CHANNEL_ID, r10);     // Catch: JSONException -> L6
    L8:
        d(SocketState.c(r11));
        if (((c5.a) g.d((Context) this.e).f17073b).b(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false) == false) goto L16;
        s8.a r12 = (s8.a) this.f18351c;
        r12.getClass();
        v r13 = new v(28, r12, r5);
        r12.f21835a.post(r13);
        return;
    L16:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // i8.a
    public void f(int r10, byte[] r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        i4.a r5 = (i4.a) this.f18349a;
    L9:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L39;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L39:
        th.printStackTrace();
        return;
    L7:
        if (Logger.debug() == false) goto L11;
        Logger.d("WsChannelService", "data = " + t8.a.b(r11) + " data.length = " + r11.length);     // Catch: Throwable -> L9
    L11:
        WsChannelMsg r12 = n8.a.f20211a.a(r11);     // Catch: Throwable -> L9
        if (r12 == WsChannelMsg.f4005k) goto L52;
        r12.f4011j = r10;     // Catch: Throwable -> L9
        r12.f4010i = new ComponentName((Context) this.e, WsChannelService.class);     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelService", "version =  seqId = " + r12.f4006a + " logId = " + r12.f4007b + " wsChannelMsg = " + r12.toString());     // Catch: Throwable -> L9
    L17:
        ConcurrentHashMap r13 = (ConcurrentHashMap) r5.d;     // Catch: Throwable -> L9
        if (r13 != null) goto L20;
        return;
    L20:
        if (r13.size() <= 0) goto L54;
        Iterator r14 = ((ConcurrentHashMap) r5.d).entrySet().iterator();     // Catch: Throwable -> L9
    L23:
        if (r14.hasNext() == false) goto L56;
        IWsApp r15 = (IWsApp) ((Map.Entry) r14.next()).getValue();     // Catch: Throwable -> L9
        if (r15 == null) goto L23;
        if (((SsWsApp) r15).f4000b != r12.f4011j) goto L23;
        Intent r16 = new Intent();     // Catch: Throwable -> L9
        r16.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L9
        r16.putExtra("payload", r12);     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L34;
        r16.putExtra(WsConstants.MSG_COUNT, ((AtomicInteger) this.d).addAndGet(1));     // Catch: Throwable -> L9
    L34:
        ((c) this.f18350b).j(r16);     // Catch: Throwable -> L9
        goto L23
    L56:
        return;
    L54:
        return;
    }

    public x0 g() {
        bk.a r5 = (bk.a) this.d;
        p r10 = (p) this.e;
        r5.getClass();
        dk.a r11 = new dk.a("/json");
        monitor-enter(r10);
        ((ArrayList) r10.f23312b).add(r11);     // Catch: Throwable -> L8
        ((ArrayList) r10.f23313c).add(r5);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        r10.k(new dk.a("/json/version"), r5);
        r10.k(new dk.a("/json/list"), r5);
        return new x0((p) this.e);
    L8:
        th = move-exception;
        throw th;
    }

    public boolean i(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        Object r5 = null;
        r5 = ((HashMap) this.d).getOrDefault(r10, null);     // Catch: Throwable -> L11
        if (r5 != null) goto L14;
        int r11 = p9.a.f21322a;     // Catch: Throwable -> L11
        throw new RuntimeException("ExperimentManager has not been init");     // Catch: Throwable -> L11
    L14:
        if (r5 != null) goto L16;
    L17:
        HashMap r12 = (HashMap) this.f18351c;
        if (r12 != null) goto L45;
        return false;
    L45:
        Map r13 = (Map) r12.get("vmsdk_common");     // Catch: Throwable -> L31
        if (r13 == null) goto L36;
        Object r14 = r13.get(r10);     // Catch: Throwable -> L31
        Log.i("VmSdkSettingsManager", "getSettingsFromCache success, key: " + r10 + " , value: " + r14);     // Catch: Throwable -> L31
        if (r14 == null) goto L36;
        if ("all".equalsIgnoreCase(r14.toString()) == false) goto L27;
    L33:
        Boolean r15 = Boolean.TRUE;     // Catch: Throwable -> L31
    L30:
        r5 = r15;
        goto L36
    L27:
        if ("true".equalsIgnoreCase(r14.toString()) == true) goto L33;
        r15 = Boolean.FALSE;     // Catch: Throwable -> L31
    L36:
        if (r5 != null) goto L38;
    L42:
        return false;
    L38:
        if (r5.equals("") == true) goto L42;
        return "true".equalsIgnoreCase(r5.toString());
    L31:
        th = move-exception;
        Log.e("VmSdkSettingsManager", "getSettingsFromCache error " + th.toString());
        goto L36
    L16:
        if (r5.equals("") == false) goto L36;
    L11:
        th = move-exception;
        Log.e("VmSdkSettingsManager", "experiment may not be initialized,failed to get experimentValue: " + th);
        goto L14
    }

    public void j() {
        k(com.squareup.javapoet.e.n(NonNull.class));
    }

    public void k(com.squareup.javapoet.e r5) {
        ((ArrayList) this.d).add(com.squareup.javapoet.b.a(r5).b());
    }

    public void l(Modifier... r5) {
        Collections.addAll((ArrayList) this.e, r5);
    }

    public u n() {
        return new u(this);
    }

    public HashMap o() {
        SharedPreferences r5 = (SharedPreferences) this.f18349a;
        if (r5 != null) goto L7;
        Log.e("VmSdkSettingsManager", "please call initSettings first");
        return null;
    L7:
        if (r5.contains("vmsdk_settings") == true) goto L10;
        Log.i("VmSdkSettingsManager", "load local cached settings: no cached.");
        return null;
    L10:
        String r10 = ((SharedPreferences) this.f18349a).getString("vmsdk_settings", "");
        if (((SharedPreferences) this.f18349a).contains("vmsdk_settings_time") == false) goto L13;
        this.f18350b = Integer.valueOf(((SharedPreferences) this.f18349a).getInt("vmsdk_settings_time", 0));
    L21:
        Gson r11 = new Gson();     // Catch: Throwable -> L18
        JsonElement r12 = (JsonElement) r11.fromJson(r10, JsonElement.class);     // Catch: Throwable -> L18
        if (r12 == null) goto L20;
        JsonObject r13 = r12.getAsJsonObject();     // Catch: Throwable -> L18
        Log.i("VmSdkSettingsManager", "tryLoadSettingsCache success: " + r10);     // Catch: Throwable -> L18
        return (HashMap) r11.fromJson(r13, HashMap.class);
    L20:
        return null;
    L18:
        th = move-exception;
        Log.i("VmSdkSettingsManager", "tryLoadSettingsCache exception: " + th.toString());
        goto L20
    L13:
        this.f18350b = 0;
        goto L21
    }

    @Override // i8.a
    public void b() {
        Intent r5 = new Intent();
        r5.setAction(WsConstants.SYNC_CONNECT_STATE);
        r5.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(((ConcurrentHashMap) ((i4.a) this.f18349a).f17503c).values()));
        ((c) this.f18350b).j(r5);
    }

    public a(Context r5, i4.a r10) {
        this.f18350b = new c(new f9.a(10), 10);
        this.d = new AtomicInteger(0);
        this.e = r5;
        this.f18349a = r10;
    }

    public a(bj.a r5, e r10, d r11, IDLXBridgeMethod r12, cj.d r13) {
        this.f18349a = r5;
        this.f18350b = r10;
        this.f18351c = r11;
        this.d = r12;
        this.e = r13;
    }

    public a(Map r5, Map r10, Map r11, Map r12, Map r13) {
        Intrinsics.checkNotNullParameter(r5, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(r10, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(r11, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(r12, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(r13, "polyBase2DefaultDeserializerProvider");
        this.f18349a = r5;
        this.f18350b = r10;
        this.f18351c = r11;
        this.d = r12;
        this.e = r13;
    }

    public a(String r5, x r10) {
        int r11 = i.f14970c;
        this.f18351c = new com.squareup.javapoet.g();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f18349a = r10;
        this.f18350b = r5;
    }

    @Override // i8.a
    public void a() {
    }
}
