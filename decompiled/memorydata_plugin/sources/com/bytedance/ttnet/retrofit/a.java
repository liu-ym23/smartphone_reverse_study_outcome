package com.bytedance.ttnet.retrofit;

import android.os.Build;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.IInterceptorProperty;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ttnet.retrofit.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.ttnet.retrofit.a$a, reason: collision with other inner class name */
    private static final class C0167a implements Call<Object>, IRequestInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Request f3310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3311b;
        private boolean c;

        private C0167a(Request r1) {
            this.f3310a = r1;
        }

        /* synthetic */ C0167a(Request r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.retrofit2.Call
        public void cancel() {
            this.c = true;
        }

        @Override // com.bytedance.retrofit2.Call
        public Call<Object> clone() {
            return new C0167a(this.f3310a);
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m116clone() {
            return clone();
        }

        @Override // com.bytedance.retrofit2.Call
        public void enqueue(Callback<Object> r3) {
            Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
            this.f3311b = true;
            if (r4 != null) goto L10;
            return;
        L10:
            r4.onResponse(this, execute());     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            r4.onFailure(this, th);
        }

        @Override // com.bytedance.retrofit2.Call
        public SsResponse<Object> execute() {
            this.f3311b = true;
            return SsResponse.success(null, new Response(this.f3310a.getUrl(), 200, "Synthetic Call", Collections.emptyList(), null));
        }

        @Override // com.bytedance.retrofit2.IRequestInfo
        public Object getRequestInfo() {
            return null;
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isCanceled() {
            return this.c;
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isExecuted() {
            return this.f3311b;
        }

        @Override // com.bytedance.retrofit2.Call
        public Request request() {
            return this.f3310a;
        }
    }

    private static final class b implements Interceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Request f3312a;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        private Request a() {
            return this.f3312a;
        }

        static /* synthetic */ Request a(b r0) {
            return r0.a();
        }

        @Override // com.bytedance.retrofit2.intercept.Interceptor
        public SsResponse intercept(Interceptor.Chain r9) {
            Request r10 = ((Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r9, Interceptor.Chain.class, "com.obric.memorydata.plugin")).request();
            if (r10 != null) goto L7;
            Response r8 = new Response("", 200, "Synthetic Interceptor Merge", Collections.emptyList(), null);
        L6:
            return SsResponse.success(null, r8);
        L7:
            this.f3312a = r10;
            RetrofitMetrics r1 = r10.getMetrics();
            if (r1 == null) goto L10;
            r1.callServerInterceptorStart();
            r1.recordInterceptorRequestEnd();
            r1.lowestInterceptorRequestEnd();
            r1.lowestInterceptorResponseStart();
            r1.recordInterceptorResponseStart(this);
            r1.retrofit.misc.executeSsCallSuccess = true;
        L10:
            r8 = new Response(r10.getUrl(), 200, "Synthetic Interceptor Merge", Collections.emptyList(), null);
            goto L6
        }
    }

    private static Request a(String r2, Map<String, String> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Request.Builder r6 = new Request.Builder().get().url(b(r2)).addCommonParam(r4).tag(String.class, "ttnet-intcp-native-flag");
        r6.headers(c(r5));
        Request r7 = r6.build();
        RetrofitMetrics r8 = new RetrofitMetrics();
        r8.bizInvokeRetrofitRequestInterfaceStart(true);
        r8.bizInvokeRetrofitRequestInterfaceEnd();
        r8.ssHttpCallApiStart(false);
        r8.requestRealStart();
        r7.setMetrics(r8);
        return r7;
    }

    private static String a(String r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        if (Build.VERSION.SDK_INT < 9) goto L8;
        Locale r0 = Locale.ROOT;
    L10:
        return r2.toLowerCase(r0);
    L8:
        r0 = Locale.US;
        goto L10
    }

    public static String a(String r10, Map<String, String> r11) {
        Map<String, String> r12 = d((Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin"));
        Request r0 = b(r10, r12);
        if (r0 != null) goto L5;
        r0 = a(r10, r12, false);
    L5:
        Map<String, String> r13 = a(r0);
        String r1 = b(r0.getUrl());
        Map<String, String> r2 = e(r12);
        Map<String, String> r3 = e(r13);
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        String r8 = a(r7);
        String r9 = b((String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));
        if (r2.containsKey(r8) == false) goto L10;
        if (b((String) ZeusTransformUtils.preCheckCast(r2.get(r8), String.class, "com.obric.memorydata.plugin")).equals(r9) == true) goto L7;
    L10:
        r4.put(r7, r9);
        goto L7
    L14:
        Iterator<Map.Entry<String, String>> r15 = r12.entrySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L21;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3.containsKey(a((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin"))) == true) goto L16;
        r5.put((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin"), b((String) ZeusTransformUtils.preCheckCast(r16.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L16
    L21:
        if (r12.get("x-ttnet-intcp-merge-feature") == null) goto L23;
        r5.put("x-ttnet-intcp-merge-feature", "");
    L23:
        JSONObject r17 = new JSONObject();
        r17.put("url", r1);
        r17.put("addHeaders", f(r4));
        r17.put("deleteHeaders", f(r5));
        return r17.toString();
    }

    private static Map<String, String> a(Request r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 != null) goto L5;
    L16:
        return r0;
    L5:
        if (r4.getHeaders() == null) goto L16;
        Iterator<Header> r5 = r4.getHeaders().iterator();
    L9:
        if (r5.hasNext() == false) goto L16;
        Header r1 = (Header) ZeusTransformUtils.preCheckCast(r5.next(), Header.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        if (r1.getName() == null) goto L9;
        r0.put(r1.getName(), b(r1.getValue()));
        goto L9
    }

    private static boolean a(Map<String, String> r2) {
        String r3 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).get("x-ttnet-intcp-merge-feature"), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if ("1".equals(r3) == false) goto L7;
    L8:
        return true;
    L7:
        if ("2".equals(r3) == false) goto L9;
        goto L8
    }

    private static Request b(String r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        boolean r0 = a(r7);
        Request r8 = a(r5, r7, b(r7));
        List<Interceptor> r9 = RetrofitUtils.c(r5);
        if (r9 != null) goto L5;
    L31:
        return r8;
    L5:
        if (r9.isEmpty() == true) goto L31;
        ArrayList r2 = new ArrayList(r9.size() + 1);
        Iterator<Interceptor> r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L19;
        Interceptor r3 = (Interceptor) ZeusTransformUtils.preCheckCast(r10.next(), Interceptor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, IInterceptorProperty.class) == true) goto L13;
    L15:
        if (r0 == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, TTInternalInterceptor.class) == false) goto L9;
    L14:
        r2.add(r3);
        goto L9
    L13:
        if (((IInterceptorProperty) ZeusTransformUtils.preCheckCast(r3, IInterceptorProperty.class, "com.obric.memorydata.plugin")).shouldRunInMergeMode() == false) goto L15;
    L19:
        AnonymousClass1 r1 = null;
        b r11 = new b(r1);
        r2.add(r11);
        RealInterceptorChain r4 = new RealInterceptorChain(r2, 0, r8, new C0167a(r8, r1));     // Catch: Throwable -> L28
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L23;
        r4.proceedWithoutHook(r8);     // Catch: Throwable -> L28
    L24:
        Request r12 = b.a(r11);
        if (r12 != null) goto L27;
        return r8;
    L27:
        return r12;
    L23:
        r4.proceed(r8);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw new JavaInterceptorException("Java interceptor execution failed.", th);
    }

    private static String b(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    private static boolean b(Map<String, String> r2) {
        String r3 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).get("x-ttnet-intcp-merge-feature"), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if ("2".equals(r3) == false) goto L7;
        return true;
    }

    private static List<Header> c(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r7 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r7.isEmpty() == true) goto L14;
        Iterator r8 = r7.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2.getKey() == null) goto L9;
        r0.add(new Header((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"))));
        goto L9
    }

    private static Map<String, String> d(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L14;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2.getKey() == null) goto L9;
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L9
    }

    private static Map<String, String> e(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L14;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"));
        if (r3.length() == 0) goto L9;
        r0.put(r3, b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L9
    }

    private static JSONObject f(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        if (r6 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L14;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2.getKey() == null) goto L9;
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L9
    }
}
