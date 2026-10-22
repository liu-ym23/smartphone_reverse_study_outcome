package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.browser.jsbridge.ApiHookImpl;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.network.impl.interceptor.RequestInterceptorConstants;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.android.livesdkapi.projectmode.IMiddlewareLiveSdkProjectModeService;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i3<T, R> implements Function {
    public final /* synthetic */ FetchV3Method a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ JSONObject e;
    public final /* synthetic */ String f;
    public final /* synthetic */ JSONObject g;

    public i3(FetchV3Method r1, String r2, JSONObject r3, Ref.ObjectRef r4, JSONObject r5, String r6, JSONObject r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object apply(Object r27) {
        i3<T, R> r0 = this;
        String r1 = (String) r27;
        Intrinsics.checkNotNullParameter(r1, "it");
        FetchTimingSession r2 = r0.a.b;
        if (r2 == null) goto L5;
        r2.recordNetStartTiming();
    L5:
        int r3 = FetchV3Method.e;
        String r4 = "params";
        if (Intrinsics.areEqual(r1, "post") == false) goto L55;
        FetchV3Method r5 = r0.a;
        String r9 = r0.b;
        JSONObject r11 = r0.c;
        JSONObject r12 = (JSONObject) r0.d.element;
        JSONObject r13 = r0.e;
        String r14 = r0.f;
        JSONObject r15 = r0.g;
        r5.getClass();
        if (Intrinsics.areEqual(r11.optString("Content-Type"), "application/json") == false) goto L14;
        String r6 = r13.toString();
        String r16 = "";
        Charset r7 = Charsets.UTF_8;
        if (r6 == null) goto L13;
        byte[] r24 = r6.getBytes(r7);
        String r17 = "params";
        String r23 = "application/json; charset=UTF-8";
        JSONObject r19 = r13;
    L33:
        List<NameValuePair> r8 = FetchV3Method.o(r11);
        Function1<HttpResponse, JSONObject> r18 = r5.n(r14, r15, r8);
        if (((Boolean) com.bytedance.android.livesdk.v0.a.getValue()).booleanValue() == false) goto L36;
        LiveCall r21 = jc1.k.n(IMiddlewareNetworkService.class).post(ApiHookImpl.a(FetchV3Method.k(r9, RequestInterceptorConstants.c(r12)), 1), r8, r23, r24, Boolean.valueOf(r5.c));
    L37:
        JSONObject r22 = (JSONObject) r18.invoke(r21.execute());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L54;
        JSONObject r25 = r22.optJSONObject("header");
        if (r25 == null) goto L43;
        String r26 = r25.optString("x-tt-logid");
        if (r26 == null) goto L43;
    L44:
        Object r28 = r22.opt("raw");
        JSONObject r29 = new JSONObject();
        r11.put("log_id", r26);
        r29.put(r17, r12);
        r29.put("header", r11);
        r29.put("form", r19);
        IMiddlewareLiveSdkProjectModeService r31 = jc1.k.f(IMiddlewareLiveSdkProjectModeService.class);
        if (r31 == null) goto L54;
        String r32 = "[POST]" + new URL(r9).getPath();
        String r33 = r12.toString();
        if (r28 == null) goto L52;
        String r34 = r28.toString();
        if (r34 == null) goto L52;
        String r35 = r34;
    L53:
        r31.consumeRevNetWork(r26, r32, r33, r35);
    L52:
        r35 = r16;
    L43:
        r26 = r16;
    L54:
        JSONObject r36 = r22;
        r0 = this;
    L76:
        FetchTimingSession r37 = r0.a.b;
        if (r37 == null) goto L79;
        r37.recordNetEndTiming();
    L79:
        boolean r38 = com.bytedance.android.live.revenue.core.util.h.a;
        ca0.j r39 = (ca0.j) com.bytedance.android.live.revenue.core.util.h.e(ca0.j.class);
        if (r39 == null) goto L82;
        r39.processRevenueApiResponse(r0.b, r36);
    L82:
        return r36;
    L36:
        r21 = jc1.k.n(IMiddlewareNetworkService.class).post(ApiHookImpl.a(FetchV3Method.k(r9, RequestInterceptorConstants.c(r12)), 1), r8, r23, r24, Boolean.valueOf(r5.c));
        goto L37
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L14:
        r16 = "";
        ByteArrayOutputStream r41 = new ByteArrayOutputStream();
        Iterator<String> r42 = r13.keys();
    L16:
        if (r42.hasNext() == false) goto L32;
        Iterator<String> r110 = r42;
        String r43 = r42.next();
        if (r41.size() <= 0) goto L20;
        r41.write(38);
    L20:
        String r111 = r4;
        String r44 = URLEncoder.encode(r43, "UTF-8");
        String r45 = r13.optString(r43);
        if (r45 != null) goto L23;
        r45 = r16;
    L23:
        String r46 = URLEncoder.encode(r45, "UTF-8");
        JSONObject r112 = r13;
        Charset r113 = Charset.forName("UTF-8");
        if (r44 == null) goto L31;
        r41.write(r44.getBytes(r113));
        r41.write(61);
        Charset r47 = Charset.forName("UTF-8");
        if (r46 == null) goto L29;
        r41.write(r46.getBytes(r47));
        r4 = r111;
        r42 = r110;
        r13 = r112;
        goto L16
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L32:
        r17 = r4;
        r19 = r13;
        r24 = r41.toByteArray();
        r23 = "application/x-www-form-urlencoded; charset=UTF-8";
        goto L33
    L55:
        FetchV3Method r48 = r0.a;
        String r49 = r0.b;
        JSONObject r51 = r0.c;
        JSONObject r52 = (JSONObject) r0.d.element;
        String r114 = r0.f;
        JSONObject r115 = r0.g;
        r48.getClass();
        List<NameValuePair> r116 = FetchV3Method.o(r51);
        Function1<HttpResponse, JSONObject> r117 = r48.n(r114, r115, r116);
        if (((Boolean) com.bytedance.android.livesdk.v0.a.getValue()).booleanValue() == false) goto L58;
        LiveCall r53 = jc1.k.n(IMiddlewareNetworkService.class).get(ApiHookImpl.a(FetchV3Method.k(r49, RequestInterceptorConstants.c(r52)), 1), r116, Boolean.valueOf(r48.c));
    L59:
        r36 = (JSONObject) r117.invoke(r53.execute());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L76;
        JSONObject r118 = r36.optJSONObject("header");
        if (r118 == null) goto L65;
        String r54 = r118.optString("x-tt-logid");
        if (r54 == null) goto L65;
    L66:
        Object r55 = r36.opt("raw");
        JSONObject r119 = new JSONObject();
        r119.put("params", r52);
        r51.put("log_id", r54);
        r119.put("header", r51);
        IMiddlewareLiveSdkProjectModeService r56 = jc1.k.f(IMiddlewareLiveSdkProjectModeService.class);
        if (r56 == null) goto L76;
        String r57 = "[GET]" + new URL(r49).getPath();
        String r58 = r52.toString();
        if (r55 == null) goto L74;
        String r59 = r55.toString();
        if (r59 == null) goto L74;
        String r61 = r59;
    L75:
        r56.consumeRevNetWork(r54, r57, r58, r61);
    L74:
        r61 = "";
    L65:
        r54 = "";
        goto L66
    L58:
        r53 = jc1.k.n(IMiddlewareNetworkService.class).get(ApiHookImpl.a(FetchV3Method.k(r49, RequestInterceptorConstants.c(r52)), 1), r116, Boolean.valueOf(r48.c));
        goto L59
    }
}
