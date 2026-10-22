package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.live.browser.jsbridge.ApiHookImpl;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.network.impl.interceptor.RequestInterceptorConstants;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f3<T, R> implements Function {
    public final /* synthetic */ e3 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JsonObject c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ JsonObject e;

    public f3(e3 r1, String r2, JsonObject r3, Ref.ObjectRef r4, JsonObject r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object apply(Object r13) {
        String r14 = (String) r13;
        Intrinsics.checkNotNullParameter(r14, "it");
        FetchTimingSession r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.recordNetStartTiming();
    L5:
        int r1 = e3.e;
        if (Intrinsics.areEqual(r14, "post") == false) goto L45;
        e3 r15 = this.a;
        String r2 = this.b;
        JsonObject r3 = this.c;
        JsonObject r4 = (JsonObject) this.d.element;
        JsonObject r5 = this.e;
        r15.getClass();
        JsonObject r6 = RequestInterceptorConstants.a(r5);
        JsonElement r7 = r3.get("Content-Type");
        if (r7 == null) goto L10;
        String r8 = r7.getAsString();
    L12:
        if (Intrinsics.areEqual(r8, "application/json") == false) goto L19;
        String r9 = r6.toString();
        Charset r11 = Charsets.UTF_8;
        if (r9 == null) goto L18;
        byte[] r12 = r9.getBytes(r11);
        String r16 = "application/json; charset=UTF-8";
    L16:
        byte[] r17 = r12;
        String r18 = r16;
        if (((Boolean) com.bytedance.android.livesdk.v0.a.getValue()).booleanValue() == false) goto L43;
        LiveCall r19 = jc1.k.n(IMiddlewareNetworkService.class).post(ApiHookImpl.a(r15.j(r2, RequestInterceptorConstants.a(r4)), 1), r15.l(r3), r18, r17, Boolean.valueOf(r15.d));
    L44:
        JsonObject r110 = e3.k((HttpResponse) r19.execute());
    L50:
        FetchTimingSession r21 = this.a.c;
        if (r21 == null) goto L53;
        r21.recordNetEndTiming();
    L53:
        return r110;
    L43:
        r19 = jc1.k.n(IMiddlewareNetworkService.class).post(ApiHookImpl.a(r15.j(r2, RequestInterceptorConstants.a(r4)), 1), r15.l(r3), r18, r17, Boolean.valueOf(r15.d));
        goto L44
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        ByteArrayOutputStream r22 = new ByteArrayOutputStream();
        Iterator<T> r23 = r6.entrySet().iterator();
    L21:
        if (r23.hasNext() == false) goto L39;
        Map.Entry r24 = (Map.Entry) r23.next();
        if (r22.size() <= 0) goto L25;
        r22.write(38);
    L25:
        String r25 = URLEncoder.encode((String) r24.getKey(), "UTF-8");
        JsonElement r26 = (JsonElement) r24.getValue();
        if (r26 == null) goto L29;
        String r27 = r26.getAsString();
        if (r27 == null) goto L29;
    L30:
        String r28 = URLEncoder.encode(r27, "UTF-8");
        Charset r111 = Charset.forName("UTF-8");
        if (r25 == null) goto L38;
        r22.write(r25.getBytes(r111));
        r22.write(61);
        Charset r29 = Charset.forName("UTF-8");
        if (r28 == null) goto L36;
        r22.write(r28.getBytes(r29));
        goto L21
    L36:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L38:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L29:
        r27 = "";
        goto L30
    L39:
        r12 = r22.toByteArray();
        r16 = "application/x-www-form-urlencoded; charset=UTF-8";
        goto L16
    L10:
        r8 = null;
        goto L12
    L45:
        e3 r112 = this.a;
        String r31 = this.b;
        JsonObject r32 = this.c;
        JsonObject r33 = (JsonObject) this.d.element;
        r112.getClass();
        if (((Boolean) com.bytedance.android.livesdk.v0.a.getValue()).booleanValue() == false) goto L48;
        LiveCall r113 = jc1.k.n(IMiddlewareNetworkService.class).get(ApiHookImpl.a(r112.j(r31, RequestInterceptorConstants.a(r33)), 1), r112.l(r32), Boolean.valueOf(r112.d));
    L49:
        r110 = e3.k((HttpResponse) r113.execute());
        goto L50
    L48:
        r113 = jc1.k.n(IMiddlewareNetworkService.class).get(ApiHookImpl.a(r112.j(r31, RequestInterceptorConstants.a(r33)), 1), r112.l(r32), Boolean.valueOf(r112.d));
        goto L49
    }
}
