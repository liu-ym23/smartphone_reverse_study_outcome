package com.bytedance.apm.impl;

import com.bytedance.apm.util.e;
import com.bytedance.apm.util.i;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.g;
import com.bytedance.services.apm.api.h;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    public static List<Header> convertHeaderMap(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r7 != null) goto L5;
    L13:
        h r8 = com.bytedance.apm.b.m();
        if (r8 == null) goto L26;
        Map<String, String> r9 = r8.a();
        if (r9 == null) goto L26;
        if (r9.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L21:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L21;
        r0.add(new Header((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
    L26:
        return r0;
    L5:
        if (r7.isEmpty() == true) goto L13;
        Iterator r11 = r7.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        r0.add(new Header((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L8
    }

    public static byte[] toByteArray(InputStream r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
        if (r5 == null) goto L5;
    L6:
        int r4 = r5.read(r1);
        if ((-1) == r4) goto L9;
        r0.write(r1, 0, r4);
        goto L6
    L9:
        r5.close();
        return r0.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r2, String r3, boolean r4) {
        return new d(r2, r3, r4, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r2, String r3, boolean r4, Map<String, String> r5) {
        return new d(r2, r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public com.bytedance.services.apm.api.c doGet(String r5, Map<String, String> r6) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        List<Header> r7 = convertHeaderMap(null);
        RetrofitMonitorService r1 = (RetrofitMonitorService) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r5, RetrofitMonitorService.class), RetrofitMonitorService.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L7:
        Call<TypedInput> r8 = r1.fetch(r5, r4, false);
    L8:
        SsResponse<TypedInput> r9 = r8.execute();
        byte[] r10 = toByteArray(((TypedInput) ZeusTransformUtils.preCheckCast(r9.body(), TypedInput.class, "com.obric.memorydata.plugin")).in());
        return new com.bytedance.services.apm.api.c(r9.code(), r10);
    L5:
        if (r7.size() <= 0) goto L7;
        r8 = r1.fetch(r5, r7, r4, false);
        goto L8
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public com.bytedance.services.apm.api.c doPost(String r6, byte[] r7, Map<String, String> r8) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        RetrofitMonitorService r9 = (RetrofitMonitorService) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r6, RetrofitMonitorService.class), RetrofitMonitorService.class, "com.obric.memorydata.plugin");
        List<Header> r10 = convertHeaderMap(r5);
        int r2 = 0;
        Call<TypedInput> r11 = r9.report(r6, new TypedByteArray("application/json; charset=utf-8", r7, new String[0]), r10, false);
        HashMap r12 = new HashMap();
        byte[] r13 = null;
        SsResponse<TypedInput> r14 = r11.execute();     // Catch: Throwable -> L11
        r13 = toByteArray(((TypedInput) ZeusTransformUtils.preCheckCast(r14.body(), TypedInput.class, "com.obric.memorydata.plugin")).in());     // Catch: Throwable -> L11
        List<Header> r15 = r14.headers();     // Catch: Throwable -> L11
        if (i.a(r15) == true) goto L9;
        Iterator<Header> r16 = r15.iterator();     // Catch: Throwable -> L11
    L7:
        if (r16.hasNext() == false) goto L9;
        Header r1 = (Header) ZeusTransformUtils.preCheckCast(r16.next(), Header.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r12.put(r1.getName(), r1.getValue());     // Catch: Throwable -> L11
    L9:
        int r17 = r14.code();     // Catch: Throwable -> L11
    L21:
        return new com.bytedance.services.apm.api.c(r17, r12, r13);
    L11:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, HttpResponseException.class) == false) goto L16;
        r2 = ((HttpResponseException) ZeusTransformUtils.preCheckCast(th, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode();     // Catch: Exception -> L22
    L16:
        if (ZeusTransformUtils.instanceOf(th, CronetIOException.class) == false) goto L19;
        r17 = ((CronetIOException) ZeusTransformUtils.preCheckCast(th, CronetIOException.class, "com.obric.memorydata.plugin")).getStatusCode();     // Catch: Exception -> L22
    L19:
        r17 = r2;
        goto L21
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public com.bytedance.services.apm.api.c uploadFiles(String r2, List<File> r3, Map<String, String> r4) {
        return e.a(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }
}
