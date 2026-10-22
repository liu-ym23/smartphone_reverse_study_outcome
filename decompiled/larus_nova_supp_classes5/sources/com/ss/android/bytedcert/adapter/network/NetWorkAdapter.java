package com.ss.android.bytedcert.adapter.network;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.cert.manager.ablity.INetWork;
import com.ss.android.cert.manager.constants.UrlConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import zra.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class NetWorkAdapter implements INetWork {
    public NetWorkAdapter() {
    }

    public static RequestContext a(Map r3) {
        RequestContext r0 = new RequestContext();
        if (r3 != null) goto L5;
    L13:
        return r0;
    L5:
        if (r3.containsKey("timeout_connect") == false) goto L8;
        ((BaseRequestContext) r0).timeout_connect = ((Long) r3.get("timeout_connect")).longValue();
    L8:
        if (r3.containsKey("timeout_read") == false) goto L11;
        ((BaseRequestContext) r0).timeout_read = ((Long) r3.get("timeout_read")).longValue();
    L11:
        if (r3.containsKey("timeout_write") == false) goto L13;
        ((BaseRequestContext) r0).timeout_write = ((Long) r3.get("timeout_write")).longValue();
        goto L13
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public int checkResponseException(Throwable r2) {
        if ((r2 instanceof HttpResponseException) == false) goto L6;
        return 105;
    L6:
        if ((r2 instanceof NetworkNotAvailabeException) == false) goto L8;
        return -106;
    L8:
        return 0;
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public int getExceptionStatusCode(Throwable r2) {
        if ((r2 instanceof HttpResponseException) == false) goto L6;
        return ((HttpResponseException) r2).getStatusCode();
    L6:
        if ((r2 instanceof CronetIOException) == true) goto L11;
        return 0;
    L11:
        return ((CronetIOException) r2).getStatusCode();
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executeGet(String r7, Map<String, String> r8, Map<String, String> r9, Map<String, Object> r10) throws Exception {
        RequestContext r5 = a(r10);
        Call r11 = a.b(r7).doGet(true, r7, r9, a.a(r8), r5);
        if (r11 == null) goto L5;
        SsResponse r12 = r11.execute();
    L6:
        if (r12 != null) goto L9;
        return "request error";
    L9:
        return (String) r12.body();
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executePost(String r7, Map<String, String> r8, String r9, Map<String, Object> r10) throws Exception {
        RequestContext r5 = a(r10);
        Call r11 = a.b(r7).postBody(true, r7, a.a(r8), new TypedString(r9), r5);
        if (r11 == null) goto L5;
        SsResponse r12 = r11.execute();
    L6:
        if (r12 != null) goto L9;
        return "request error";
    L9:
        return (String) r12.body();
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executePostFile(String r8, Map<String, String> r9, Map<String, String> r10, Map<String, Pair<String, byte[]>> r11) throws Exception {
        HashMap r5 = new HashMap();
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r12.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        if (TextUtils.isEmpty(r1) == true) goto L4;
        if (TextUtils.isEmpty(r2) == true) goto L4;
        r5.put(r1, new TypedString(r2));
        goto L4
    L10:
        if (r11 != null) goto L12;
    L23:
        Call r13 = ((NetService) RetrofitUtils.createSsService(UrlConstant.getBaseUrl(), NetService.class)).postMultiPart(true, -1, r8, null, r5, a.a(r9));
        if (r13 == null) goto L26;
        SsResponse r14 = r13.execute();
    L27:
        if (r14 != null) goto L30;
        return "request error";
    L30:
        return (String) r14.body();
    L26:
        r14 = null;
        goto L27
    L12:
        if (r11.size() == 0) goto L23;
        Iterator<Map.Entry<String, Pair<String, byte[]>>> r15 = r11.entrySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L23;
        Map.Entry<String, Pair<String, byte[]>> r16 = r15.next();
        String r3 = r16.getKey();
        Pair<String, byte[]> r17 = r16.getValue();
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (r17 == null) goto L15;
        String r4 = (String) r17.first;
        byte[] r18 = (byte[]) r17.second;
        if (TextUtils.isEmpty(r4) == true) goto L15;
        if (r18 == null) goto L15;
        r5.put(r3, new TypedByteArray("application/octet-stream", r18, new String[]{r4}));
        goto L15
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executePost(String r7, Map<String, String> r8, Map<String, String> r9, Map<String, Object> r10) throws Exception {
        RequestContext r5 = a(r10);
        Call r11 = a.b(r7).doPost(true, r7, a.a(r8), r9, r5);
        if (r11 == null) goto L5;
        SsResponse r12 = r11.execute();
    L6:
        if (r12 != null) goto L9;
        return "request error";
    L9:
        return (String) r12.body();
    L5:
        r12 = null;
        goto L6
    }
}
