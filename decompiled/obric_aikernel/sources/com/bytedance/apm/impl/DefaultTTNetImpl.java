package com.bytedance.apm.impl;

import com.bytedance.apm.d;
import com.bytedance.apm.util.j;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.a0;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r4.e;
import t4.g;
import t4.h;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    protected static List<n4.b> convertHeaderMap(Map<String, String> r10) {
        ArrayList r11 = new ArrayList();
        if (r10 != null) goto L5;
    L13:
        h r12 = d.z();
        if (r12 == null) goto L26;
        Map<String, String> r13 = r12.a();
        if (r13 == null) goto L26;
        if (r13.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();
    L21:
        if (r14.hasNext() == false) goto L26;
        Map.Entry<String, String> r15 = r14.next();
        if (r15 == null) goto L21;
        r11.add(new n4.b(r15.getKey(), r15.getValue()));
    L26:
        return r11;
    L5:
        if (r10.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r16 = r10.entrySet().iterator();
    L8:
        if (r16.hasNext() == false) goto L13;
        Map.Entry<String, String> r17 = r16.next();
        if (r17 == null) goto L8;
        r11.add(new n4.b(r17.getKey(), r17.getValue()));
        goto L8
    }

    public static byte[] toByteArray(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[8192];
        if (r10 == null) goto L5;
    L6:
        int r13 = r10.read(r12);
        if ((-1) == r13) goto L9;
        r11.write(r12, 0, r13);
        goto L6
    L9:
        r10.close();
        return r11.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r10, String r11, boolean r12) {
        return new c(r10, r11, r12, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r10, String r11, boolean r12, Map<String, String> r13) {
        return new c(r10, r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public t4.c doGet(String r10, Map<String, String> r11) {
        List<n4.b> r12 = convertHeaderMap(null);
        RetrofitMonitorService r13 = (RetrofitMonitorService) RetrofitUtils.g(r10, RetrofitMonitorService.class);
        if (r12 != null) goto L5;
    L7:
        com.bytedance.retrofit2.b<e> r14 = r13.fetch(r10, r11, false);
    L8:
        a0<e> r15 = r14.execute();
        byte[] r16 = toByteArray(r15.a().c());
        return new t4.c(r15.b(), r16);
    L5:
        if (r12.size() <= 0) goto L7;
        r14 = r13.fetch(r10, r12, r11, false);
        goto L8
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public t4.c doPost(String r10, byte[] r11, Map<String, String> r12) {
        RetrofitMonitorService r13 = (RetrofitMonitorService) RetrofitUtils.g(r10, RetrofitMonitorService.class);
        List<n4.b> r14 = convertHeaderMap(r12);
        int r15 = 0;
        com.bytedance.retrofit2.b<e> r16 = r13.report(r10, new com.bytedance.retrofit2.mime.c(NetConst.CONTENT_TYPE, r11, new String[0]), r14, false);
        HashMap r17 = new HashMap();
        byte[] r18 = null;
        a0<e> r19 = r16.execute();     // Catch: Throwable -> L11
        r18 = toByteArray(r19.a().c());     // Catch: Throwable -> L11
        List<n4.b> r20 = r19.e();     // Catch: Throwable -> L11
        if (j.b(r20) == true) goto L9;
        Iterator<n4.b> r21 = r20.iterator();     // Catch: Throwable -> L11
    L7:
        if (r21.hasNext() == false) goto L9;
        n4.b r22 = r21.next();     // Catch: Throwable -> L11
        r17.put(r22.a(), r22.b());     // Catch: Throwable -> L11
    L9:
        int r23 = r19.b();     // Catch: Throwable -> L11
    L21:
        return new t4.c(r23, r17, r18);
    L11:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L16;
        r15 = ((HttpResponseException) th).getStatusCode();     // Catch: Exception -> L22
    L16:
        if ((th instanceof CronetIOException) == false) goto L19;
        r23 = ((CronetIOException) th).getStatusCode();     // Catch: Exception -> L22
    L19:
        r23 = r15;
        goto L21
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public t4.c uploadFiles(String r10, List<File> r11, Map<String, String> r12) {
        return com.bytedance.apm.util.e.a(r10, r11, r12);
    }
}
