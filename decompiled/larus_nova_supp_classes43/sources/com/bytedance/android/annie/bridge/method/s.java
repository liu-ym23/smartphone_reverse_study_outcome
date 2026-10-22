package com.bytedance.android.annie.bridge.method;

import android.net.Uri;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "fetch")
public final class s extends com.bytedance.ies.web.jsbridge2.f<JsonObject, String> {
    public Disposable a;
    public boolean b;
    public IAnnieNetworkService c;
    public FetchTimingSession d;

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
        FetchTimingSession r0 = this.d;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Disposable r1 = this.a;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public s() {
    }

    public static JsonObject k(com.bytedance.android.annie.service.network.d r10) {
        JsonObject r0 = new JsonObject();
        r0.add("raw", GsonProtectorUtils.parse(new JsonParser(), new String(r10.c, Charsets.UTF_8)).getAsJsonObject());
        JsonObject r1 = new JsonObject();
        int r11 = 0;
    L4:
        if (r11 >= r10.b.size()) goto L9;
        if ("x-tt-logid".equalsIgnoreCase((String) ((Pair) ListProtector.get(r10.b, r11)).first) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        String r12 = (String) ((Pair) ListProtector.get(r10.b, r11)).second;
    L10:
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        r1.addProperty("x-tt-logid", r12);
        r0.add("header", r1.getAsJsonObject());
        return r0;
    L9:
        r12 = null;
        goto L10
    }

    public final List<Pair<String, String>> l(JsonObject r10) {
        ArrayList r0 = new ArrayList();
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r11.next();
        Object r12 = r1.getKey();
        JsonElement r13 = (JsonElement) r1.getValue();
        if (r13 == null) goto L8;
        String r14 = r13.getAsString();
    L9:
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        r0.add(new Pair(r12, r14));
        goto L4
    L8:
        r14 = null;
        goto L9
    L12:
        return r0;
    }

    public final void invoke(Object r13, CallContext r14) {
        JsonObject r15 = (JsonObject) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        this.c = (IAnnieNetworkService) Annie.getService(IAnnieNetworkService.class, r14.a());
        FetchTimingSession.Companion.getClass();
        this.d = FetchTimingSession.a.a(r15);
        JsonElement r1 = r15.get(com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r1 == null) goto L5;
        String r10 = r1.getAsString();
    L6:
        Intrinsics.checkNotNull(r10);
        JsonElement r11 = r15.get("method");
        if (r11 == null) goto L12;
        String r12 = r11.getAsString();
        if (r12 == null) goto L12;
        String r16 = r12.toLowerCase(Locale.getDefault());
        if (r16 == null) goto L12;
    L13:
        String r17 = r16;
        JsonElement r18 = r15.get("headers");
        if (r18 == null) goto L16;
        JsonObject r19 = r18.getAsJsonObject();
    L17:
        if (r19 != null) goto L19;
        r19 = new JsonObject();
    L19:
        JsonObject r20 = r19;
        Set r21 = SecurityContextUtils.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        String r22 = SecurityContextUtils.b(r14);
        Iterator r23 = r20.keySet().iterator();
    L20:
        boolean r24 = true;
        if (r23.hasNext() == false) goto L25;
        Object r25 = r23.next();
        if (StringsKt.equals((String) r25, "x-security-argus", true) == false) goto L20;
    L26:
        String r26 = (String) r25;
        if (r26 == null) goto L29;
        r20.remove(r26);
    L29:
        r20.addProperty("x-security-argus", r22);
        Ref.ObjectRef r27 = new Ref.ObjectRef();
        JsonElement r0 = r15.get("params");
        if (r0 == null) goto L32;
        JsonObject r28 = r0.getAsJsonObject();
    L33:
        if (r28 != null) goto L35;
        r28 = new JsonObject();
    L35:
        r27.element = r28;
        JsonElement r29 = r15.get("data");
        if (r29 == null) goto L38;
        JsonObject r30 = r29.getAsJsonObject();
    L39:
        if (r30 != null) goto L41;
        r30 = new JsonObject();
    L41:
        JsonElement r31 = r15.get("num_to_string");
        if (r31 == null) goto L44;
        boolean r32 = r31.getAsBoolean();
    L45:
        this.b = r32;
        JsonObject r33 = (JsonObject) r27.element;
        if (r33 != null) goto L48;
        JsonObject r34 = new JsonObject();
    L49:
        if (r33 == null) goto L51;
        r33.addProperty("live_request_from_jsb", 1);
    L51:
        r27.element = r34;
        if (com.bytedance.android.annie.ng.g.b().c.a == false) goto L67;
        if (StringsKt.contains$default(r10, "aweme/v1/user/", false, 2, null) == false) goto L67;
        JsonElement r35 = ((JsonObject) r27.element).get("sec_user_id");
        if (r35 == null) goto L58;
        String r36 = r35.getAsString();
    L59:
        if (r36 != null) goto L61;
    L64:
        if (r24 == true) goto L67;
        ((JsonObject) r27.element).remove(com.bytedance.android.ec.core.event.a.KEY_ANCHOR_ID);
        goto L67
    L61:
        if (r36.length() == 0) goto L64;
        r24 = false;
        goto L64
    L58:
        r36 = null;
    L67:
        if ((r14.d instanceof WebView) == false) goto L69;
        r20.addProperty("hybrid-app-engine", "webview");
    L69:
        View r37 = r14.d;
        if (r37 == null) goto L76;
        ILatchService r38 = (ILatchService) Annie.getService$default(ILatchService.class, null, 2, null);
        if (r38.c(r37) == false) goto L74;
    L75:
        r20.addProperty("hybrid-app-engine", "lynx");
        goto L76
    L74:
        if (r38.O0(r37) == true) goto L75;
    L76:
        this.a = Observable.just(r17).subscribeOn(Schedulers.io()).map(new t(this, r10, r20, r27, r30)).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(this, r14, r15), new v(this, r14, r10, r17));
        return;
    L48:
        r34 = r33;
        goto L49
    L44:
        r32 = false;
        goto L45
    L38:
        r30 = null;
        goto L39
    L32:
        r28 = null;
        goto L33
    L25:
        r25 = null;
        goto L26
    L16:
        r19 = null;
    L12:
        r16 = "get";
        goto L13
    L5:
        r10 = null;
        goto L6
    }

    public final String j(String r10, JsonObject r11) {
        Uri.Builder r12 = UriProtector.parse(r10).buildUpon();
        Iterator r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L17;
        Map.Entry r0 = (Map.Entry) r13.next();
        String r1 = (String) r0.getKey();
        String r14 = null;
        JsonElement r15 = (JsonElement) r0.getValue();     // Catch: UnsupportedOperationException -> L10
        if (r15 == null) goto L13;
        r14 = r15.getAsString();     // Catch: UnsupportedOperationException -> L10
    L13:
        if (r14 != null) goto L15;
        r14 = "";
    L15:
        r12.appendQueryParameter(r1, r14);
    L10:
        JsonElement r16 = (JsonElement) r0.getValue();
        if (r16 == null) goto L13;
        r14 = r16.toString();
        goto L13
    L17:
        return r12.toString();
    }
}
