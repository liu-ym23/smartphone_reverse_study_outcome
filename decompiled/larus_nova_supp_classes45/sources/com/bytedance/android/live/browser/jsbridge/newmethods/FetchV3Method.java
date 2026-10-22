package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.in0;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonParser;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "fetch")
public final class FetchV3Method extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public static final /* synthetic */ int e = 0;
    public Disposable a;
    public FetchTimingSession b;
    public boolean c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        if (Intrinsics.areEqual((Boolean) xa1.a.d.getValue(), Boolean.TRUE) == true) goto L5;
    L6:
        super.onDestroy();
        return;
    L5:
        if (this.d == false) goto L6;
    }

    public final void onTerminate() {
        FetchTimingSession r0 = this.b;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Disposable r1 = this.a;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public FetchV3Method() {
        this.c = true;
    }

    public static List o(JSONObject r5) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        String r4 = r5.optString(r2);
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r0.add(new NameValuePair(r2, r4));
        goto L4
    L9:
        return r0;
    }

    public static String k(String r3, JSONObject r4) {
        Uri.Builder r5 = UriProtector.parse(r3).buildUpon();
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        Object r2 = r4.opt(r1);
        if (r2 == null) goto L9;
        String r6 = r2.toString();
        if (r6 == null) goto L9;
    L10:
        r5.appendQueryParameter(r1, r6);
    L9:
        r6 = "";
        goto L10
    L12:
        return r5.toString();
    }

    public final void invoke(Object r17, CallContext r18) {
        JSONObject r11 = (JSONObject) r17;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r18, "context");
        FetchTimingSession.Companion.getClass();
        Intrinsics.checkNotNullParameter(r11, "params");
        boolean r2 = false;
        boolean r0 = r11.optBoolean("enable_timing", false);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        if (r0 == false) goto L9;
        FetchTimingSession r1 = new FetchTimingSession();     // Catch: Throwable -> L7
        r1.recordJsbStartTiming();     // Catch: Throwable -> L7
    L10:
        this.b = r1;
        String r3 = r11.optString(LiveSlardarConstants.EXTRA_KEY_URL, "");
        String r5 = r11.optString("method", "");
        if (r5 == null) goto L14;
        String r6 = r5.toLowerCase(Locale.getDefault());
        if (r6 == null) goto L14;
    L15:
        String r12 = r6;
        JSONObject r7 = r11.optJSONObject("headers");
        if (r7 != null) goto L18;
        r7 = new JSONObject();
    L18:
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        JSONObject r8 = r11.optJSONObject("params");
        if (r8 != null) goto L21;
        r8 = new JSONObject();
    L21:
        r13.element = r8;
        JSONObject r9 = r11.optJSONObject("data");
        if (r9 != null) goto L24;
        r9 = new JSONObject();
    L24:
        JSONObject r14 = r9;
        this.c = r11.optBoolean("add_common_params", true);
        JSONObject r15 = (JSONObject) r13.element;
        r15.put("live_request_from_jsb", 1);
        r13.element = r15;
        String r16 = r15.optString("webcast_sdk_version");
        if (r16 != null) goto L27;
    L30:
        boolean r19 = true;
    L31:
        if (r19 == false) goto L33;
        r15.put("webcast_sdk_version", com.bytedance.android.livesdk.paas.c.b());
    L33:
        r13.element = r15;
        IMiddleWareHostContext r21 = jc1.k.f(IMiddleWareHostContext.class);
        if (r21 == null) goto L57;
        Map r22 = r21.getFEParamExtra();
        if (r22 == null) goto L57;
        Set r23 = r22.entrySet();
        if (r23 == null) goto L57;
        Iterator r24 = r23.iterator();
    L41:
        if (r24.hasNext() == false) goto L57;
        Map.Entry r25 = (Map.Entry) r24.next();
        String r110 = (String) r25.getKey();
        if (r110 == null) goto L41;
        if (r110.length() <= 0) goto L47;
        boolean r111 = true;
    L48:
        if (r111 != true) goto L41;
        String r112 = (String) r25.getValue();
        if (r112 == null) goto L41;
        if (r112.length() <= 0) goto L54;
        boolean r113 = true;
    L55:
        if (r113 != true) goto L41;
        r15.put((String) r25.getKey(), r25.getValue());
        goto L41
    L54:
        r113 = false;
        goto L55
    L47:
        r111 = false;
    L57:
        r13.element = r15;
        if (StringsKt.contains$default(r3, "aweme/v1/user/", false, 2, null) == false) goto L67;
        String r26 = ((JSONObject) r13.element).optString("sec_user_id");
        if (r26 != null) goto L62;
    L63:
        r2 = true;
    L64:
        if (r2 == true) goto L67;
        ((JSONObject) r13.element).remove("anchor_id");
        goto L67
    L62:
        if (r26.length() != 0) goto L64;
    L67:
        if ((r18.d instanceof WebView) == false) goto L69;
        r7.put("hybrid-app-engine", "webview");
    L69:
        View r27 = r18.d;
        if (r27 == null) goto L76;
        ILatchService r28 = com.bytedance.android.annie.a.c(ILatchService.class);
        if (r28.c(r27) == false) goto L74;
    L75:
        r7.put("hybrid-app-engine", "lynx");
        goto L76
    L74:
        if (r28.O0(r27) == true) goto L75;
    L76:
        l30.i.b(r7, r18);
        JSONObject r29 = r11.optJSONObject("pb_extras");
        String r31 = r18.b;
        Logger.d("AnnieBusinessLatchService", "fetchV3 invoke. head:" + r7 + ", requestObj:" + ((JSONObject) r13.element) + ", postObj:" + r14);
        this.a = Observable.just(r12).subscribeOn(Schedulers.io()).map(new i3(this, r3, r7, r13, r14, r31, r29)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j3(this, r18, r13, r11, r3, r12), new k3(this, r3, r12, r13, r18));
        return;
    L27:
        if (r16.length() == 0) goto L30;
        r19 = false;
    L14:
        r6 = "get";
    L9:
        r1 = null;
    L7:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static final JSONObject j(FetchV3Method r1, JSONObject r2, HttpResponse r3) {
        r1.getClass();
        JSONObject r4 = new JSONObject();
        r4.put("raw", r2);
        JSONObject r5 = new JSONObject();
        String r6 = r3.header("x-tt-logid");
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r5.put("x-tt-logid", r6);
        r4.put("header", r5);
        return r4;
    }

    public static void l(int r11, String r12, long r13) {
        j9.b r1 = com.bytedance.android.annie.a.c(k9.e.class).H0();
        JSONObject r5 = new JSONObject();
        r5.put("status_code", r11);
        Unit r14 = Unit.INSTANCE;
        JSONObject r6 = new JSONObject();
        r6.put("duration", r13);
        JSONObject r8 = new JSONObject();
        com.bytedance.android.annie.ng.a r15 = (com.bytedance.android.annie.ng.a) com.bytedance.android.annie.ng.g.c.get("webcast");
        if (r15 == null) goto L7;
        o8.f r16 = r15.b;
        if (r16 == null) goto L7;
        String r17 = r16.a;
    L8:
        r8.put("virtual_aid", r17);
        j9.b.a.a(r1, null, "latch_pb_result_duration", r12, r5, r6, null, r8, 1, 256);
        return;
    L7:
        r17 = null;
        goto L8
    }

    public final Function1<HttpResponse, JSONObject> n(final String r19, final JSONObject r21, List<NameValuePair> r22) {
        if (r21 == null) goto L5;
        final boolean r8 = r21.optBoolean("report_metric");
    L6:
        final FetchV3Method$modifyHeadersAndGetResponseDecoder$1 r11 = new FetchV3Method$modifyHeadersAndGetResponseDecoder$1(this, r19, r8);
        if (r19 == null) goto L94;
        if (r21 == null) goto L94;
        if (((Boolean) in0.a.getValue()).booleanValue() == true) goto L15;
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$3(r11);
    L15:
        if (r21.optBoolean("enable") == false) goto L17;
        String r0 = r21.optString("pb_definitions");
        if (r0.length() <= 0) goto L21;
        boolean r2 = true;
    L22:
        if (r2 == true) goto L25;
        r0 = null;
    L25:
        if (r0 == null) goto L27;
        final boolean r9 = true;
    L28:
        String r3 = r21.optString("data_message_name");
        if (r3.length() <= 0) goto L31;
        boolean r5 = true;
    L32:
        if (r5 == false) goto L34;
        String r12 = r3;
    L35:
        if (r12 != null) goto L38;
        m(0, "data_message_name is empty", r19, r9);
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$1(r19, r9, r11);
    L38:
        String r4 = r21.optString("extra_message_name");
        if (r4.length() <= 0) goto L41;
        boolean r6 = true;
    L42:
        if (r6 == false) goto L44;
        String r13 = r4;
    L45:
        long r14 = SystemClock.elapsedRealtime();
        if (r0 != null) goto L95;
    L69:
        String r1 = r21.optString("channel");
        if (r1.length() != 0) goto L72;
        boolean r7 = true;
    L73:
        if (r7 == false) goto L75;
        r1 = com.bytedance.android.annie.a.c(com.bytedance.android.annie.service.prefetch.p.class).A0(r19);
    L75:
        if (r1 != null) goto L78;
        m(0, "channel is empty", r19, r9);
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$2(r21, r19, r9, r11, r12, r13, r8, r14);
    L78:
        t9.b r15 = com.bytedance.android.annie.a.c(t9.c.class).w0(r1);
        if (r15 != null) goto L81;
    L91:
        m(0, "definitions is empty", r19, r9);
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$3(r21, r19, r9, r11, r12, r13, r8, r14);
    L81:
        if (r15.b(r12, r13) == false) goto L83;
        t9.b r16 = r15;
    L84:
        if (r16 == null) goto L91;
        if (r8 == false) goto L88;
        l(2, r19, SystemClock.elapsedRealtime() - r14);
    L88:
        final t9.b r17 = r16;
    L89:
        ArrayList r18 = (ArrayList) r22;
        r18.add(new NameValuePair("response-format", "protobuf"));
        final String r23 = r12;
        final String r24 = r13;
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$5(this, r17, r23, r24, r21, r19, r8, r9, r11);
    L83:
        r16 = null;
        goto L84
    L72:
        r7 = false;
        goto L73
    L95:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L55
        t9.b r26 = com.bytedance.android.annie.a.c(t9.c.class).M0(new JsonParser().parse(r0).getAsJsonObject());     // Catch: Throwable -> L55
        if (r26 != null) goto L50;
    L52:
        r26 = null;
    L53:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L55
    L58:
        if (Result.isSuccess-impl(r27) == false) goto L63;
        t9.b r28 = (t9.b) r27;
        if (r8 == false) goto L63;
        l(3, r19, SystemClock.elapsedRealtime() - r14);
    L63:
        if (Result.isFailure-impl(r27) == false) goto L65;
        r27 = null;
    L65:
        t9.b r29 = (t9.b) r27;
        if (r29 == null) goto L69;
        r17 = r29;
        goto L89
    L50:
        if (r26.b(r12, r13) == false) goto L52;
    L55:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L44:
        r13 = null;
        goto L45
    L41:
        r6 = false;
        goto L42
    L34:
        r12 = null;
        goto L35
    L31:
        r5 = false;
        goto L32
    L27:
        r9 = false;
        goto L28
    L21:
        r2 = false;
        goto L22
    L17:
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$4(r11);
    L94:
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$2(r11);
    L5:
        r8 = false;
        goto L6
    }

    public static void m(int r11, String r12, String r13, boolean r14) {
        j9.b r1 = com.bytedance.android.annie.a.c(k9.e.class).H0();
        JSONObject r5 = new JSONObject();
        r5.put("status_code", r11);
        r5.put("reason", r12);
        r5.put("dynamic", r14 ? 1 : 0);
        Unit r15 = Unit.INSTANCE;
        JSONObject r8 = new JSONObject();
        com.bytedance.android.annie.ng.a r16 = (com.bytedance.android.annie.ng.a) com.bytedance.android.annie.ng.g.c.get("webcast");
        if (r16 == null) goto L7;
        o8.f r17 = r16.b;
        if (r17 == null) goto L7;
        Object r18 = r17.a;
    L8:
        r8.put("virtual_aid", r18);
        j9.b.a.a(r1, null, "latch_pb_result_all", r13, r5, null, null, r8, 1, 256);
        return;
    L7:
        r18 = null;
        goto L8
    }
}
