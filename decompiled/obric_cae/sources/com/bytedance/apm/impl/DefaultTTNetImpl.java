package com.bytedance.apm.impl;

import a7.c;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.services.apm.api.IHttpService;
import e9.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u8.e;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    public static List<Header> convertHeaderMap(Map<String, String> r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
    L13:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r11 = r8.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<String, String> r12 = r11.next();
        if (r12 == null) goto L8;
        r10.add(new Header(r12.getKey(), r12.getValue()));
        goto L8
    }

    public static byte[] toByteArray(InputStream r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        byte[] r11 = new byte[8192];
        if (r8 == null) goto L5;
    L6:
        int r12 = r8.read(r11);
        if ((-1) == r12) goto L9;
        r10.write(r11, 0, r12);
        goto L6
    L9:
        r8.close();
        return r10.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String r8, String r10, boolean r11) {
        return new b(r8, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public u8.b doGet(String r8, Map<String, String> r10) {
        SsResponse<TypedInput> r11 = ((RetrofitMonitorService) d.c(RetrofitMonitorService.class, r8)).fetch(r8, r10, false).execute();
        byte[] r12 = toByteArray(r11.body().in());
        return new u8.b(r11.code(), r12);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public u8.b doPost(String r8, byte[] r10, Map<String, String> r11) {
        RetrofitMonitorService r12 = (RetrofitMonitorService) d.c(RetrofitMonitorService.class, r8);
        List<Header> r13 = convertHeaderMap(r11);
        int r14 = 0;
        Call<TypedInput> r15 = r12.report(r8, new TypedByteArray("application/json; charset=utf-8", r10, new String[0]), r13, false);
        HashMap r16 = new HashMap();
        byte[] r17 = null;
        SsResponse<TypedInput> r18 = r15.execute();     // Catch: Throwable -> L11
        r17 = toByteArray(r18.body().in());     // Catch: Throwable -> L11
        List<Header> r19 = r18.headers();     // Catch: Throwable -> L11
        if (l6.a.e0(r19) == true) goto L9;
        Iterator<Header> r20 = r19.iterator();     // Catch: Throwable -> L11
    L7:
        if (r20.hasNext() == false) goto L9;
        Header r21 = r20.next();     // Catch: Throwable -> L11
        r16.put(r21.getName(), r21.getValue());     // Catch: Throwable -> L11
    L9:
        int r22 = r18.code();     // Catch: Throwable -> L11
    L21:
        return new u8.b(r22, r16, r17);
    L11:
        th = move-exception;
        if ((th instanceof b7.b) == false) goto L16;
        r14 = ((b7.b) th).f3131a;     // Catch: Exception -> L22
    L16:
        if ((th instanceof c) == false) goto L19;
        r22 = ((c) th).f78a;     // Catch: Exception -> L22
    L19:
        r22 = r14;
        goto L21
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public u8.b uploadFiles(String r8, List<File> r10, Map<String, String> r11) {
        return g3.c.a(r8, r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String r8, String r10, boolean r11, Map<String, String> r12) {
        return new b(r8, r12);
    }
}
