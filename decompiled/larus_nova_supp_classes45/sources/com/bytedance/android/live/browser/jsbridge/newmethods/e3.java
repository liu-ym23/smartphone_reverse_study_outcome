package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.gson.ILiveGsonService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e3 extends com.bytedance.ies.web.jsbridge2.f<JsonObject, String> {
    public static final /* synthetic */ int e = 0;
    public Disposable a;
    public boolean b;
    public FetchTimingSession c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
        FetchTimingSession r0 = this.c;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Disposable r1 = this.a;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public e3() {
        this.d = true;
    }

    public static JsonObject k(HttpResponse r5) {
        JsonObject r0 = new JsonObject();
        r0.add("raw", GsonProtectorUtils.parse(((ILiveGsonService) jc1.k.n(ILiveGsonService.class)).parser(), new String(r5.getBody(), Charsets.UTF_8)).getAsJsonObject());
        JsonObject r1 = new JsonObject();
        String r6 = r5.header("x-tt-logid");
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r1.addProperty("x-tt-logid", r6);
        r0.add("header", r1.getAsJsonObject());
        return r0;
    }

    public final List<NameValuePair> l(JsonObject r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) r6.next();
        String r3 = (String) r1.getKey();
        JsonElement r2 = (JsonElement) r1.getValue();
        if (r2 == null) goto L9;
        String r4 = r2.getAsString();
        if (r4 == null) goto L9;
    L10:
        r0.add(new NameValuePair(r3, r4));
    L9:
        r4 = "";
        goto L10
    L11:
        return r0;
    }

    public final void invoke(Object r16, CallContext r17) {
        JsonObject r6 = (JsonObject) r16;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r17, "context");
        FetchTimingSession.Companion.getClass();
        this.c = FetchTimingSession.a.a(r6);
        JsonElement r1 = r6.get(LiveSlardarConstants.EXTRA_KEY_URL);
        String r2 = null;
        if (r1 == null) goto L5;
        String r9 = r1.getAsString();
    L6:
        Intrinsics.checkNotNull(r9);
        JsonElement r3 = r6.get("method");
        if (r3 == null) goto L12;
        String r4 = r3.getAsString();
        if (r4 == null) goto L12;
        String r5 = r4.toLowerCase(Locale.getDefault());
        if (r5 == null) goto L12;
    L13:
        String r11 = r5;
        JsonElement r7 = r6.get("headers");
        if (r7 == null) goto L17;
        JsonObject r8 = r7.getAsJsonObject();
        if (r8 == null) goto L17;
    L18:
        JsonObject r12 = r8;
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        JsonElement r0 = r6.get("params");
        if (r0 == null) goto L22;
        JsonObject r14 = r0.getAsJsonObject();
        if (r14 == null) goto L22;
    L23:
        r13.element = r14;
        JsonElement r15 = r6.get("data");
        if (r15 == null) goto L27;
        JsonObject r18 = r15.getAsJsonObject();
        if (r18 == null) goto L27;
    L28:
        JsonObject r19 = r18;
        JsonElement r21 = r6.get("num_to_string");
        boolean r22 = false;
        if (r21 == null) goto L31;
        boolean r23 = r21.getAsBoolean();
    L32:
        this.b = r23;
        JsonElement r24 = r6.get("add_common_params");
        if (r24 == null) goto L35;
        boolean r25 = r24.getAsBoolean();
    L36:
        this.d = r25;
        JsonObject r26 = (JsonObject) r13.element;
        if (r26 != null) goto L39;
        JsonObject r110 = new JsonObject();
    L40:
        if (r26 == null) goto L42;
        r26.addProperty("live_request_from_jsb", 1);
    L42:
        r13.element = r110;
        IMiddleWareHostContext r27 = jc1.k.f(IMiddleWareHostContext.class);
        if (r27 == null) goto L66;
        Map r28 = r27.getFEParamExtra();
        if (r28 == null) goto L66;
        Set r29 = r28.entrySet();
        if (r29 == null) goto L66;
        Iterator r31 = r29.iterator();
    L50:
        if (r31.hasNext() == false) goto L66;
        Map.Entry r111 = (Map.Entry) r31.next();
        String r112 = (String) r111.getKey();
        if (r112 == null) goto L50;
        if (r112.length() <= 0) goto L56;
        boolean r113 = true;
    L57:
        if (r113 != true) goto L50;
        String r114 = (String) r111.getValue();
        if (r114 == null) goto L50;
        if (r114.length() <= 0) goto L63;
        boolean r115 = true;
    L64:
        if (r115 != true) goto L50;
        r110.addProperty((String) r111.getKey(), (String) r111.getValue());
        goto L50
    L63:
        r115 = false;
        goto L64
    L56:
        r113 = false;
    L66:
        r13.element = r110;
        if (StringsKt.contains$default(r9, "aweme/v1/user/", false, 2, null) == false) goto L78;
        JsonElement r32 = ((JsonObject) r13.element).get("sec_user_id");
        if (r32 == null) goto L71;
        r2 = r32.getAsString();
    L71:
        if (r2 != null) goto L73;
    L74:
        r22 = true;
    L75:
        if (r22 == true) goto L78;
        ((JsonObject) r13.element).remove("anchor_id");
        goto L78
    L73:
        if (r2.length() != 0) goto L75;
    L78:
        if ((r17.d instanceof WebView) == false) goto L80;
        r12.addProperty("hybrid-app-engine", "webview");
    L80:
        View r33 = r17.d;
        if (r33 == null) goto L87;
        ILatchService r34 = com.bytedance.android.annie.a.c(ILatchService.class);
        if (r34.c(r33) == false) goto L85;
    L86:
        r12.addProperty("hybrid-app-engine", "lynx");
        goto L87
    L85:
        if (r34.O0(r33) == true) goto L86;
    L87:
        this.a = Observable.just(r11).subscribeOn(Schedulers.io()).map(new f3(this, r9, r12, r13, r19)).observeOn(AndroidSchedulers.mainThread()).subscribe(new g3(this, r17, r13, r6, r9, r11), new h3(this, r9, r11, r13, r17));
        return;
    L39:
        r110 = r26;
        goto L40
    L35:
        r25 = true;
        goto L36
    L31:
        r23 = false;
    L27:
        r18 = new JsonObject();
    L22:
        r14 = new JsonObject();
    L17:
        r8 = new JsonObject();
    L12:
        r5 = "get";
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    public final String j(String r5, JsonObject r6) {
        Uri.Builder r7 = UriProtector.parse(r5).buildUpon();
        Iterator r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r0 = (Map.Entry) r8.next();
        String r1 = (String) r0.getKey();
        String r2 = null;
        JsonElement r3 = (JsonElement) r0.getValue();     // Catch: UnsupportedOperationException -> L10
        if (r3 == null) goto L13;
        r2 = r3.getAsString();     // Catch: UnsupportedOperationException -> L10
    L13:
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        r7.appendQueryParameter(r1, r2);
    L10:
        JsonElement r4 = (JsonElement) r0.getValue();
        if (r4 == null) goto L13;
        r2 = r4.toString();
        goto L13
    L17:
        return r7.toString();
    }
}
