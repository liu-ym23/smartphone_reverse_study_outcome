package com.bytedance.apm.impl;

import ai.q0;
import bi.c;
import bi.e;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.ttnet.utils.d;
import fi.g;
import fi.i;
import i4.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oj.b;
import oj.f;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    public static List<c> convertHeaderMap(Map<String, String> r5) {
        ArrayList r10 = new ArrayList();
        if (r5 != null) goto L5;
    L13:
        return r10;
    L5:
        if (r5.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r11 = r5.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<String, String> r12 = r11.next();
        if (r12 == null) goto L8;
        r10.add(new c(r12.getKey(), r12.getValue()));
        goto L8
    }

    public static byte[] toByteArray(InputStream r5) throws IOException {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        byte[] r11 = new byte[8192];
        if (r5 == null) goto L5;
    L6:
        int r12 = r5.read(r11);
        if ((-1) == r12) goto L9;
        r10.write(r11, 0, r12);
        goto L6
    L9:
        r5.close();
        return r10.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public f buildMultipartUpload(String r5, String r10, boolean r11) throws Exception {
        return new a(r5, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String r5, Map<String, String> r10) throws Exception {
        q0 r11 = ((RetrofitMonitorService) d.c(RetrofitMonitorService.class, r5)).fetch(r5, r10, false).execute();
        byte[] r12 = toByteArray(((i) r11.f291b).c());
        return new b(r11.f290a.f930b, r12);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String r5, byte[] r10, Map<String, String> r11) throws Exception {
        RetrofitMonitorService r12 = (RetrofitMonitorService) d.c(RetrofitMonitorService.class, r5);
        List<c> r13 = convertHeaderMap(r11);
        int r14 = 0;
        ai.c r15 = r12.report(r5, new g("application/json; charset=utf-8", r10, new String[0]), r13, false);
        HashMap r16 = new HashMap();
        byte[] r17 = null;
        q0 r18 = r15.execute();     // Catch: Throwable -> L11
        Object r19 = r18.f291b;     // Catch: Throwable -> L11
        e r20 = r18.f290a;
        r17 = toByteArray(((i) r19).c());     // Catch: Throwable -> L11
        List r21 = (List) r20.d;     // Catch: Throwable -> L11
        if (wn.f.j(r21) == true) goto L13;
        Iterator r22 = r21.iterator();     // Catch: Throwable -> L11
    L9:
        if (r22.hasNext() == false) goto L13;
        c r23 = (c) r22.next();     // Catch: Throwable -> L11
        r16.put(r23.f915a, r23.f916b);     // Catch: Throwable -> L11
    L13:
        int r24 = r20.f930b;     // Catch: Throwable -> L11
    L24:
        return new b(r24, r16, r17);
    L11:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L19;
        r14 = ((HttpResponseException) th).getStatusCode();     // Catch: Exception -> L25
    L19:
        if ((th instanceof CronetIOException) == false) goto L22;
        r24 = ((CronetIOException) th).getStatusCode();     // Catch: Exception -> L25
    L22:
        r24 = r14;
        goto L24
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b uploadFiles(String r5, List<File> r10, Map<String, String> r11) throws Exception {
        return td.e.o(r5, r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public f buildMultipartUpload(String r5, String r10, boolean r11, Map<String, String> r12) throws Exception {
        return new a(r5, r12);
    }
}
