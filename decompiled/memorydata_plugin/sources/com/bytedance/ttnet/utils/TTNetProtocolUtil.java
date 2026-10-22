package com.bytedance.ttnet.utils;

import android.util.Pair;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetProtocolUtil {

    public interface Service {
        @GET
        @Priority(3)
        Call<TypedInput> getCall(@Url String r1, @QueryMap(encode = true) Map<String, String> r2, @AddCommonParam boolean r3, @HeaderList List<Header> r4);
    }

    public static void a(String r7, String r8, Map<String, String> r9, Map<String, String> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        String r13 = ReportConsts.HTTPS + r7 + r8;
        Pair<String, String> r14 = k.a(r13, r11);
        String r0 = (String) ZeusTransformUtils.preCheckCast(r14.first, String.class, "com.obric.memorydata.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.second, String.class, "com.obric.memorydata.plugin");
        Retrofit r2 = RetrofitUtils.b(r0);
        if (r2 == null) goto L24;
        Service r1 = (Service) ZeusTransformUtils.preCheckCast(r2.create(Service.class), Service.class, "com.obric.memorydata.plugin");
        ArrayList r3 = new ArrayList();
        r3.add(new Header("x-ttnet-protocol-handler", "1"));
        r3.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
        if (r12 != null) goto L7;
    L12:
        Call<TypedInput> r16 = r1.getCall(r15, r11, false, r3);
        r16.execute();     // Catch: Throwable -> L16 Exception -> L18
        r16.cancel();
        return;
    L18:
        e = move-exception;
        throw new IOException("TTNet-protocol request execution failed for URL: " + r13, e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r16.cancel();
        throw th;
    L7:
        if (r12.isEmpty() == true) goto L12;
        Iterator r17 = r12.entrySet().iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r3.add(new Header((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L10
    L24:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r0);
    }

    public static void a(String r6, String r7, Map<String, String> r8, Map<String, String> r9, Callback<TypedInput> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Callback<TypedInput> r13 = (Callback) ZeusTransformUtils.wrapperContextForParams(r10, Callback.class, "com.obric.memorydata.plugin");
        Pair<String, String> r14 = k.a(ReportConsts.HTTPS + r6 + r7, r11);
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.first, String.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.second, String.class, "com.obric.memorydata.plugin");
        Retrofit r0 = RetrofitUtils.b(r15);
        if (r0 == null) goto L15;
        Service r17 = (Service) ZeusTransformUtils.preCheckCast(r0.create(Service.class), Service.class, "com.obric.memorydata.plugin");
        ArrayList r1 = new ArrayList();
        r1.add(new Header("x-ttnet-protocol-handler", "1"));
        r1.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
        if (r12 != null) goto L7;
    L12:
        r17.getCall(r16, r11, false, r1).enqueue(r13);
        return;
    L7:
        if (r12.isEmpty() == true) goto L12;
        Iterator r18 = r12.entrySet().iterator();
    L10:
        if (r18.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1.add(new Header((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L10
    L15:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r15);
    }
}
