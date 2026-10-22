package com.bytedance.android.annie.lynx.bridge;

import android.content.Context;
import c8.b;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.g;
import com.bytedance.android.annie.bridge.n;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import d8.e;
import e8.d;
import h8.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/bytedance/android/annie/lynx/bridge/AnnieLynxBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "", "methodName", "Lorg/json/JSONObject;", "params", "", "checkIgnoreCallback", "func", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/lynx/react/bridge/Callback;", "callback", "", "call", "data", "Lcom/bytedance/ies/web/jsbridge2/c0;", "invokeCallback$annie_lynx_release", "(Lorg/json/JSONObject;Lcom/bytedance/ies/web/jsbridge2/c0;)V", "invokeCallback", "invokeFakeJsCallback$annie_lynx_release", "(Lcom/bytedance/ies/web/jsbridge2/c0;)V", "invokeFakeJsCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "callRegistry", "Ljava/util/concurrent/ConcurrentHashMap;", "Lc8/b;", "bridgeImpl", "Lc8/b;", "Landroid/content/Context;", "context", "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Companion", "a", "annie-lynx_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieLynxBridgeModule extends LynxModule {
    public static final a Companion = null;
    public static final int EC_ERROR_CODE = 10086;
    public static final String IGNORE_CALLBACK = "enable_ignore_callback";
    private static final String TAG = "AnnieLynxBridgeModule";
    private final b bridgeImpl;
    private final ConcurrentHashMap<c0, Callback> callRegistry;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCallRegistry$p(AnnieLynxBridgeModule r0) {
        return r0.callRegistry;
    }

    public final void invokeFakeJsCallback$annie_lynx_release(c0 r10) {
        Intrinsics.checkNotNullParameter(r10, "call");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L9
        r1.put("code", EC_ERROR_CODE);     // Catch: Throwable -> L9
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L9
        r11.put("errorMsg", "not authorized by ec security authenticator");     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r1.put("data", r11);     // Catch: Throwable -> L9
        Callback r13 = this.callRegistry.remove(r10);     // Catch: Throwable -> L9
        if (r13 == null) goto L6;
        r13.invoke(new Object[]{c8.a.d(r1)});     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r14);     // Catch: Throwable -> L9
        return;
    L6:
        r14 = null;
    L9:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public AnnieLynxBridgeModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "param");
        super(r10);
        this.callRegistry = new ConcurrentHashMap();
        if ((r11 instanceof b) == false) goto L5;
        b r12 = (b) r11;
    L6:
        this.bridgeImpl = r12;
        if (r12 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r12.s = this;
        return;
    L11:
        return;
    L5:
        r12 = null;
        goto L6
    }

    private final boolean checkIgnoreCallback(String r10, JSONObject r11) {
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.optBoolean(IGNORE_CALLBACK) == true) goto L16;
        JSONObject r12 = r11.optJSONObject("params");
        if (r12 != null) goto L10;
    L12:
        boolean r13 = false;
    L13:
        if (r13 == true) goto L16;
        return false;
    L10:
        if (r12.optBoolean(IGNORE_CALLBACK) != true) goto L12;
        r13 = true;
    L16:
        if (((n) Annie.getService$default(n.class, null, 2, null)).F().contains(r10) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final void invokeCallback$annie_lynx_release(JSONObject r13, c0 r14) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "call");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L55
        if (Intrinsics.areEqual(1, 1) == true) goto L8;
        int r11 = x8.a.a;     // Catch: Throwable -> L55
        x8.a.d("LynxBridgeImpl", r13.toString(), false);     // Catch: Throwable -> L55
    L8:
        if (this.callRegistry.containsKey(r14) == true) goto L10;
        return;
    L10:
        Object r12 = r13.remove("__params");     // Catch: Throwable -> L55
        if (r12 != null) goto L14;
    L25:
        Object r15 = 1;
        boolean r16 = false;
    L26:
        Callback r0 = this.callRegistry.remove(r14);     // Catch: Throwable -> L55
        if (r0 == null) goto L51;
        Object[] r1 = new Object[1];     // Catch: Throwable -> L55
        if (r16 == false) goto L48;
        ConcurrentHashMap<String, d8.b> r17 = d.a;     // Catch: Throwable -> L55
        b r18 = this.bridgeImpl;     // Catch: Throwable -> L55
        String r19 = "host";
        if (r18 == null) goto L43;
        String r110 = ((com.bytedance.ies.web.jsbridge2.b) r18).h;     // Catch: Throwable -> L55
        if (r110 != null) goto L36;
    L39:
        String r20 = "host";
    L40:
        if (r20 == null) goto L43;
        r19 = r20;
        goto L43
    L36:
        if (r110.isEmpty() == true) goto L39;
        r20 = ((com.bytedance.ies.web.jsbridge2.b) r18).h;     // Catch: Throwable -> L55
    L43:
        e r21 = d.a(r19).d;     // Catch: Throwable -> L55
        if (r21 == null) goto L47;
        Object r22 = r21.a(r13);     // Catch: Throwable -> L55
        if (r22 == null) goto L47;
    L49:
        r1[0] = r22;     // Catch: Throwable -> L55
        r0.invoke(r1);     // Catch: Throwable -> L55
    L47:
        r22 = c8.a.d(r13);     // Catch: Throwable -> L55
        goto L49
    L48:
        r22 = c8.a.d(r13);     // Catch: Throwable -> L55
    L51:
        if (Intrinsics.areEqual(r15, 1) == true) goto L53;
        int r23 = x8.a.a;     // Catch: Throwable -> L55
        JSONObject r24 = new JSONObject(r13.toString());     // Catch: Throwable -> L55
        r24.remove("__callback_id");     // Catch: Throwable -> L55
        r24.remove("eventId");     // Catch: Throwable -> L55
        r24.put("namespace", r14.g);     // Catch: Throwable -> L55
        r24.put("methodName", r14.d);     // Catch: Throwable -> L55
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L55
        x8.a.d("LynxBridgeImpl", r24.toString(), false);     // Catch: Throwable -> L55
    L53:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
        return;
    L14:
        if ((r12 instanceof JSONObject) == false) goto L25;
        int r25 = g.a;     // Catch: Throwable -> L55
        JSONObject r26 = (JSONObject) r12;     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter(r26, "data");     // Catch: Throwable -> L55
        Integer r27 = Integer.valueOf(r26.optInt("__jsb_invoke_back_mode", 0));     // Catch: Throwable -> L21
        if (r27 == null) goto L23;
        if (r27.intValue() <= 0) goto L23;
        r16 = true;
    L24:
        r15 = ((JSONObject) r12).remove("code");     // Catch: Throwable -> L55
        ((JSONObject) r12).remove("__data");     // Catch: Throwable -> L55
        ((JSONObject) r12).remove("__msg_type");     // Catch: Throwable -> L55
        r13.put("eventId", CastLongProtector.parseLong(((JSONObject) r12).optString("__callback_id", "0")));     // Catch: Throwable -> L55
        r13.put("code", r15);     // Catch: Throwable -> L55
        r13.put("data", r12);     // Catch: Throwable -> L55
        goto L26
    L23:
        r16 = false;
    L21:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L55
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final /* synthetic */ boolean access$checkIgnoreCallback(AnnieLynxBridgeModule r0, String r1, JSONObject r10) {
        return r0.checkIgnoreCallback(r1, r10);
    }

    @LynxMethod
    public final void call(String r10, ReadableMap r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "func");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L77
        JSONObject r13 = c8.a.b(r11);     // Catch: Throwable -> L77
        JSONObject r14 = r13.optJSONObject("data");     // Catch: Throwable -> L77
        b r15 = this.bridgeImpl;     // Catch: Throwable -> L77
        c0 r16 = null;
        if (r15 == null) goto L75;
        String r17 = r13.optString("namespace", "webcast");     // Catch: Throwable -> L77
        String r18 = r13.optString("eventId", "0");     // Catch: Throwable -> L77
        c0.a r19 = new c0.a();     // Catch: Throwable -> L77
        r19.c = r10;     // Catch: Throwable -> L77
        if (r14 == null) goto L9;
        String r20 = r14.toString();     // Catch: Throwable -> L77
        if (r20 == null) goto L9;
    L10:
        r19.d = r20;     // Catch: Throwable -> L77
        r19.e = r18;     // Catch: Throwable -> L77
        r19.f = r17;     // Catch: Throwable -> L77
        c0 r110 = new c0(r19);     // Catch: Throwable -> L77
        if (access$checkIgnoreCallback(this, r10, r14) == false) goto L14;
        int r111 = x8.a.a;     // Catch: Throwable -> L77
        x8.a.d(TAG, "jsb " + r10 + "  is  ignore callback", false);     // Catch: Throwable -> L77
    L15:
        Iterator<T> r112 = r15.o.iterator();     // Catch: Throwable -> L77
    L17:
        if (r112.hasNext() == false) goto L19;
        ((f) r112.next()).b(r110);     // Catch: Throwable -> L77
        goto L17
    L19:
        b7.b r113 = r15.q.getCommonLifecycle();     // Catch: Throwable -> L77
        if ((r113 instanceof c) == false) goto L22;
        c r114 = (c) r113;     // Catch: Throwable -> L77
    L23:
        if (r114 == null) goto L25;
        b7.b r115 = r114.a;     // Catch: Throwable -> L77
    L26:
        if (r115 == null) goto L43;
        if ((r115 instanceof b7.a) == false) goto L30;
        b7.a r116 = (b7.a) r115;     // Catch: Throwable -> L77
    L31:
        if (r116 == null) goto L33;
        Boolean r117 = Boolean.valueOf(r116.enableInvoke(r10, r14, r15.p));     // Catch: Throwable -> L77
    L34:
        if (r117 == null) goto L43;
        if (r117.booleanValue() == true) goto L43;
        c0 r21 = r15.s;     // Catch: Throwable -> L77
        if (r21 == null) goto L40;
        r16 = r21;
    L41:
        r16.invokeFakeJsCallback$annie_lynx_release(r110);     // Catch: Throwable -> L77
    L74:
        r16 = r110;
        goto L75
    L40:
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");     // Catch: Throwable -> L77
        goto L41
    L33:
        r117 = null;
        goto L34
    L30:
        r116 = null;
    L43:
        if (c0.b(r110) == false) goto L45;
    L73:
        r15.o(r110);     // Catch: Throwable -> L77
        goto L74
    L45:
        if (r110.d == null) goto L66;
        boolean r22 = true;
        if (r14 != null) goto L50;
    L52:
        boolean r23 = false;
    L53:
        if (r23 == true) goto L64;
        if (r14 == null) goto L60;
        JSONObject r0 = r14.optJSONObject("params");     // Catch: Throwable -> L77
        if (r0 == null) goto L60;
        if (r0.optBoolean("enable_async_jsb") != true) goto L60;
        boolean r118 = true;
    L61:
        if (r118 == true) goto L64;
    L60:
        r118 = false;
    L64:
        if (((n) Annie.getService$default(n.class, null, 2, null)).F().contains(r110.d) == false) goto L66;
    L67:
        if (r22 == false) goto L73;
        Intrinsics.checkNotNullParameter(r110, "call");     // Catch: Throwable -> L77
        if (((com.bytedance.ies.web.jsbridge2.b) r15).f == true) goto L72;
        b.u.scheduleDirect(new c8.c(r110, r15));     // Catch: Throwable -> L77
    L72:
        int r119 = x8.a.a;     // Catch: Throwable -> L77
        x8.a.d("LynxBridgeImpl", "jsb " + r10 + "  is  async run", false);     // Catch: Throwable -> L77
        goto L74
    L50:
        if (r14.optBoolean("enable_async_jsb") != true) goto L52;
        r23 = true;
    L66:
        r22 = false;
        goto L67
    L25:
        r115 = null;
        goto L26
    L22:
        r114 = null;
        goto L23
    L14:
        access$getCallRegistry$p(this).put(r110, r12);     // Catch: Throwable -> L77
    L9:
        r20 = "{}";
    L75:
        Result.constructor-impl(r16);     // Catch: Throwable -> L77
        return;
    L77:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
