package com.bytedance.android.live.browser.service;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.service.network.AnnieNetworkError;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.jsbridge.ApiHookImpl;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdk.v0;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.bpea.cert.token.TokenCert;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements IAnnieNetworkService {

    public static final class a implements com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> {
        public final /* synthetic */ x a;
        public final /* synthetic */ LiveCall b;

        public final com.bytedance.android.annie.service.network.d execute() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Object r1 = Result.constructor-impl((HttpResponse) this.b.execute());     // Catch: Throwable -> L4
        L6:
            ArrayList r2 = null;
            if (Result.isSuccess-impl(r1) == false) goto L15;
            HttpResponse r3 = (HttpResponse) r1;
            this.a.getClass();
            com.bytedance.android.annie.service.network.d r4 = new com.bytedance.android.annie.service.network.d();
            r4.c = r3.getBody();
            List r5 = r3.getHeaders();
            if (r5 == null) goto L14;
            r2 = new ArrayList();
            Iterator r6 = r5.iterator();
        L12:
            if (r6.hasNext() == false) goto L14;
            NameValuePair r7 = (NameValuePair) r6.next();
            r2.add(new Pair(r7.getName(), r7.getValue()));
        L14:
            r4.b = r2;
            r3.getMimeType();
            r4.e = r3.getReason();
            r4.a = r3.getStatusCode();
            r4.d = r3.getStream();
            r3.getUrl();
            return r4;
        L15:
            Throwable r8 = Result.exceptionOrNull-impl(r1);
            if (r8 != null) goto L18;
            return null;
        L18:
            if ((r8 instanceof NetworkErrorException) == false) goto L21;
            AnnieNetworkError r9 = new AnnieNetworkError();
            r9.setStatusCode(((NetworkErrorException) r8).statusCode);
            r9.setMessage(r8.getMessage());
            throw r9;
        L21:
            throw r8;
        L4:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L6
        }

        public a(x r1, LiveCall r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> {
        public b() {
        }

        public final com.bytedance.android.annie.service.network.d execute() {
            return new com.bytedance.android.annie.service.network.d();
        }
    }

    public x() {
    }

    public final Map<String, String> getCommonParams() {
        Map<String, String> r1 = null;
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r0 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r0 == null) goto L10;
        r1 = r0.getCommonParams();
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return new LinkedHashMap();
    L7:
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L10;
        r1 = r2.getCommonParams();
        goto L10
    }

    public final String getHostDomain() {
        String r1 = null;
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r0 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r0 == null) goto L10;
        r1 = r0.getHostDomain();
    L10:
        if (r1 != null) goto L13;
        return "";
    L13:
        return r1;
    L7:
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L10;
        r1 = r2.getHostDomain();
        goto L10
    }

    public final String getNetworkAccessType() {
        return NetworkUtils.a(jc1.k.n(IMiddleWareHostContext.class).context(), TokenCert.Companion.with("bpea-annie_network_annie_init_network_access")).toUpperCase();
    }

    public static List H1(List r4) {
        if (r4 == null) goto L8;
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L7;
        Pair r1 = (Pair) r5.next();
        r0.add(new NameValuePair((String) r1.first, (String) r1.second));
        goto L5
    L7:
        return r0;
    L8:
        return null;
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> I1(LiveCall<HttpResponse> r2) {
        if (r2 == null) goto L6;
        return new a(this, r2);
    L6:
        return new b();
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> get(String r3, List<Pair<String, String>> r4) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r0 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r0 == null) goto L10;
        LiveCall<HttpResponse> r5 = r0.get(ApiHookImpl.a(r3, 1), H1(r4));
    L12:
        return I1(r5);
    L10:
        r5 = null;
        goto L12
    L7:
        IMiddlewareNetworkService r1 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r1 == null) goto L10;
        r5 = r1.get(ApiHookImpl.a(r3, 1), H1(r4));
        goto L12
    }

    public final void handleStatusCodeInterception(JsonObject r7, Context r8) {
        if (r7 == null) goto L25;
        JsonElement r9 = r7.get("raw");
        if (r9 == null) goto L26;
        JsonObject r11 = r9.getAsJsonObject();
        if (r11 == null) goto L27;
        JsonElement r12 = r11.get("status_code");
        if (r12 == null) goto L28;
        int r2 = r12.getAsInt();
        RequestError r13 = new RequestError();
        ((ILiveCoreService) jc1.k.n(ILiveCoreService.class)).minorInterceptOld(null, r2, "live_detail", r13, null);
        String r0 = r13.alert;
        if (r0 != null) goto L12;
    L15:
        boolean r1 = true;
    L17:
        if ((!r1) == true) goto L20;
        r13 = null;
    L20:
        if (r13 == null) goto L29;
        Activity r14 = ContextUtil.contextToActivity(r8);
        if (r14 == null) goto L30;
        ExceptionUtils.displayAlert(r14, r13.alert, s1.B(2131915969));
        return;
    L30:
        return;
    L29:
        return;
    L12:
        if (r0.length() == 0) goto L15;
        r1 = false;
        goto L17
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> get(String r3, List<Pair<String, String>> r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        boolean r1 = true;
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L10;
        IMiddlewareNetworkService r0 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r0 == null) goto L16;
        String r6 = ApiHookImpl.a(r3, 1);
        List r7 = H1(r4);
        if (r5 == null) goto L9;
        r1 = r5.booleanValue();
    L9:
        LiveCall<HttpResponse> r8 = r0.get(r6, r7, Boolean.valueOf(r1));
    L18:
        return I1(r8);
    L16:
        r8 = null;
        goto L18
    L10:
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L16;
        String r9 = ApiHookImpl.a(r3, 1);
        List r11 = H1(r4);
        if (r5 == null) goto L15;
        r1 = r5.booleanValue();
    L15:
        r8 = r2.get(r9, r11, Boolean.valueOf(r1));
        goto L18
    }

    public final InputStream doPost(String r3, String r4, Map<String, String> r5, Map<String, Object> r6) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L6;
        return jc1.k.n(IMiddlewareNetworkService.class).doPost(ApiHookImpl.a(r3, 1), r4, r5, r6);
    L6:
        return jc1.k.n(IMiddlewareNetworkService.class).doPost(ApiHookImpl.a(r3, 1), r4, r5, r6);
    }

    public final void handleFetchError(View r8, String r9, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r9, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "method");
        Intrinsics.checkNotNullParameter(r12, "error");
        if ((r12 instanceof NetworkErrorException) == true) goto L5;
        Throwable r0 = null;
    L6:
        NetworkErrorException r1 = (NetworkErrorException) r0;
        if (r1 == null) goto L9;
        int r5 = r1.statusCode;
    L10:
        if (r8 != null) goto L13;
        return;
    L13:
        if ((r8 instanceof WebView) == false) goto L19;
        IBrowserService r2 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r2 == null) goto L23;
        v30.a r3 = r2.webViewMonitorHelper();
        if (r3 == null) goto L24;
        r3.a((WebView) r8, r9, r11, r5, r12.getMessage());
        return;
    L24:
        return;
    L23:
        return;
    L19:
        IBrowserService r4 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r4 == null) goto L26;
        r4.reportLynxFetchJsbError(r8, r9, r11, r5, r12.getMessage());
        return;
    L26:
        return;
    L9:
        r5 = -1;
        goto L10
    L5:
        r0 = r12;
        goto L6
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> post(String r3, List<Pair<String, String>> r4, String r5, byte[] r6) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r0 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r0 == null) goto L10;
        LiveCall<HttpResponse> r7 = r0.post(ApiHookImpl.a(r3, 1), H1(r4), r5, r6);
    L12:
        return I1(r7);
    L10:
        r7 = null;
        goto L12
    L7:
        IMiddlewareNetworkService r1 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r1 == null) goto L10;
        r7 = r1.post(ApiHookImpl.a(r3, 1), H1(r4), r5, r6);
        goto L12
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> downloadFile(boolean r8, int r9, String r11, List<Pair<String, String>> r12, Object r13) {
        Intrinsics.checkNotNullParameter(r11, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r1 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r1 == null) goto L10;
        LiveCall<HttpResponse> r14 = r1.downloadFile(r8, r9, r11, H1(r12), r13);
    L12:
        return I1(r14);
    L10:
        r14 = null;
        goto L12
    L7:
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L10;
        r14 = r2.downloadFile(r8, r9, r11, H1(r12), r13);
        goto L12
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> downloadFileStreaming(boolean r8, int r9, String r11, List<Pair<String, String>> r12, Object r13) {
        Intrinsics.checkNotNullParameter(r11, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r1 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r1 == null) goto L10;
        LiveCall<HttpResponse> r14 = r1.downloadFileStreaming(r8, r9, r11, H1(r12), r13);
    L12:
        return I1(r14);
    L10:
        r14 = null;
        goto L12
    L7:
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L10;
        r14 = r2.downloadFileStreaming(r8, r9, r11, H1(r12), r13);
        goto L12
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> post(String r9, List<Pair<String, String>> r11, String r12, byte[] r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r9, LiveSlardarConstants.EXTRA_KEY_URL);
        boolean r1 = true;
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L10;
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L16;
        String r3 = ApiHookImpl.a(r9, 1);
        List r4 = H1(r11);
        if (r14 == null) goto L9;
        r1 = r14.booleanValue();
    L9:
        LiveCall<HttpResponse> r15 = r2.post(r3, r4, r12, r13, Boolean.valueOf(r1));
    L18:
        return I1(r15);
    L16:
        r15 = null;
        goto L18
    L10:
        IMiddlewareNetworkService r5 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r5 == null) goto L16;
        String r6 = ApiHookImpl.a(r9, 1);
        List r7 = H1(r11);
        if (r14 == null) goto L15;
        r1 = r14.booleanValue();
    L15:
        r15 = r5.post(r6, r7, r12, r13, Boolean.valueOf(r1));
        goto L18
    }

    public final com.bytedance.android.annie.service.network.c<com.bytedance.android.annie.service.network.d> uploadFile(int r11, String r12, List<Pair<String, String>> r13, String r14, byte[] r15, long r16, String r18) {
        Intrinsics.checkNotNullParameter(r12, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r1 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r1 == null) goto L10;
        LiveCall<HttpResponse> r0 = r1.uploadFile(r11, r12, H1(r13), r14, r15, r16, r18);
    L12:
        return I1(r0);
    L10:
        r0 = null;
        goto L12
    L7:
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L10;
        r0 = r2.uploadFile(r11, r12, H1(r13), r14, r15, r16, r18);
        goto L12
    }
}
