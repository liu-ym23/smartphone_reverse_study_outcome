package com.bytedance.android.annie.bridge.method;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "request")
public final class s1 extends e7.v<e7.s0, RequestResultModel> {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;

    public static final class a {
        @JvmStatic
        public static String a(JsonObject r10) {
            if (r10 != null) goto L5;
            return "application/x-www-form-urlencoded";
        L5:
            JsonElement r1 = r10.get("Content-Type");
            if (r1 == null) goto L11;
            String r11 = r1.getAsString();
            if (r11 == null) goto L11;
            return r11;
        L11:
            JsonElement r12 = r10.get("content-type");
            if (r12 == null) goto L14;
            String r13 = r12.getAsString();
        L15:
            if (r13 != null) goto L18;
            return "application/x-www-form-urlencoded";
        L18:
            return r13;
        L14:
            r13 = null;
            goto L15
        }
    }

    public final void onTerminate() {
    }

    static {
        a = CollectionsKt.listOf(new String[]{"get", "post"});
        b = CollectionsKt.listOf(new String[]{"json", "text"});
        c = CollectionsKt.listOf(new String[]{"application/x-www-form-urlencoded", "application/json"});
    }

    public s1() {
    }

    public static void j(e7.s0 r10) {
        String r0 = r10.g();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if ((!r11) == false) goto L30;
        List<String> r12 = a;
        String r13 = r10.c();
        Intrinsics.checkNotNull(r13);
        if (r12.contains(r13) == false) goto L28;
        String r14 = a.a(r10.b());
        Iterator<String> r15 = c.iterator();
    L15:
        if (r15.hasNext() == false) goto L19;
        if (StringsKt.startsWith$default(r14, r15.next(), false, 2, null) == false) goto L15;
        r1 = true;
    L19:
        if (r1 == false) goto L26;
        List<String> r16 = b;
        String r17 = r10.f();
        Intrinsics.checkNotNull(r17);
        if (r16.contains(r17) == false) goto L24;
        return;
    L24:
        throw new IllegalStateException("invalid response type".toString());
    L26:
        throw new IllegalStateException(" invalid content-type ".toString());
    L28:
        throw new IllegalStateException(" invalid method ".toString());
    L30:
        throw new IllegalStateException(" invalid url ".toString());
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r11 = false;
        goto L10
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.s0 r12 = (e7.s0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.c();
        if (r0 == null) goto L6;
        String r1 = r0.toLowerCase(Locale.getDefault());
        if (r1 == null) goto L6;
    L7:
        r12.j(r1);
        Boolean r13 = r12.d();
        if (r13 != null) goto L10;
        r13 = Boolean.TRUE;
    L10:
        r12.k(r13);
        String r14 = r12.f();
        if (r14 != null) goto L13;
        r14 = "json";
    L13:
        r12.l(r14);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L16
        j(r12);     // Catch: Throwable -> L16
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L21;
        RequestResultModel r18 = new RequestResultModel();
        r18.b(RequestResultModel.Code.InvalidParam);
        r18.e(r17.getMessage());
        finishWithResult(r18);
        return;
    L21:
        t1 r19 = new t1(this);
        if (Intrinsics.areEqual(r12.h(), Boolean.TRUE) == false) goto L24;
        RequestResultModel r110 = new RequestResultModel();
        r110.e("prefetch not impl");
        r110.b(RequestResultModel.Code.InvalidParam);
        finishWithResult(r110);
        return;
    L24:
        String r20 = r12.g();
        Intrinsics.checkNotNull(r20);
        JsonObject r21 = r12.e();
        if (r21 == null) goto L43;
        Uri.Builder r22 = UriProtector.parse(r20).buildUpon();
        Iterator r23 = r21.entrySet().iterator();
    L29:
        if (r23.hasNext() == false) goto L42;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r24.getKey();
        JsonElement r26 = (JsonElement) r24.getValue();     // Catch: UnsupportedOperationException -> L35
        if (r26 == null) goto L38;
        String r27 = r26.getAsString();     // Catch: UnsupportedOperationException -> L35
    L39:
        if (r27 != null) goto L41;
        r27 = "";
    L41:
        r22.appendQueryParameter(r25, r27);
    L38:
        r27 = null;
    L35:
        JsonElement r28 = (JsonElement) r24.getValue();
        if (r28 == null) goto L38;
        r27 = r28.toString();
        goto L39
    L42:
        r20 = r22.toString();
    L43:
        r12.m(r20);
        JsonObject r29 = r12.b();
        if (r29 != null) goto L46;
        r29 = new JsonObject();
    L46:
        Set r30 = SecurityContextUtils.a;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        String r31 = SecurityContextUtils.b(r11);
        Iterator r32 = r29.keySet().iterator();
    L48:
        if (r32.hasNext() == false) goto L52;
        Object r33 = r32.next();
        if (StringsKt.equals((String) r33, "x-security-argus", true) == false) goto L48;
    L53:
        String r34 = (String) r33;
        if (r34 == null) goto L56;
        r29.remove(r34);
    L56:
        r29.addProperty("x-security-argus", r31);
        r12.i(r29);
        if ((r11.d instanceof WebView) == false) goto L61;
        JsonObject r35 = r12.b();
        if (r35 == null) goto L61;
        r35.addProperty("hybrid-app-engine", "webview");
    L61:
        View r36 = r11.d;
        if (r36 == null) goto L70;
        ILatchService r37 = (ILatchService) Annie.getService$default(ILatchService.class, null, 2, null);
        if (r37.c(r36) == false) goto L66;
    L67:
        JsonObject r38 = r12.b();
        if (r38 == null) goto L70;
        r38.addProperty("hybrid-app-engine", "lynx");
        goto L70
    L66:
        if (r37.O0(r36) == true) goto L67;
    L70:
        u1.b r39 = new u1.b(r12, r19, r11);
        String r111 = r39.b.c();
        Intrinsics.checkNotNull(r111);
        Observable.just(r111).subscribeOn(Schedulers.io()).map(new v1(r39)).observeOn(AndroidSchedulers.mainThread()).subscribe(new w1(r39), new x1(r39));
        return;
    L52:
        r33 = null;
    L16:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L6:
        r1 = "get";
        goto L7
    }
}
