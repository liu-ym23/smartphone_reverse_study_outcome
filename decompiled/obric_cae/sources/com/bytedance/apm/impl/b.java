package com.bytedance.apm.impl;

import a7.c;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedString;
import e9.d;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u8.e;

/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f3768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f3769c;

    public b(String r8, Map r10) {
        this.f3769c = new HashMap();
        this.f3767a = r8;
        this.f3768b = r10;
    }

    @Override // u8.e
    public final void a(String r8, File r10, HashMap r11) {
        this.f3769c.put(r8, new a(r11, new TypedFile(null, r10)));
    }

    @Override // u8.e
    public final void b(String r8, String r10) {
        this.f3769c.put(r8, new TypedString(r10));
    }

    @Override // u8.e
    public final u8.b finish() {
        HashMap r8 = this.f3769c;
        Map<String, String> r10 = this.f3768b;
        String r11 = this.f3767a;
        RetrofitMonitorService r12 = (RetrofitMonitorService) d.c(RetrofitMonitorService.class, r11);
        HashMap r13 = new HashMap();
        byte[] r14 = null;
        SsResponse<TypedInput> r15 = r12.uploadFiles(r11, r8, DefaultTTNetImpl.convertHeaderMap(r10)).execute();     // Catch: Throwable -> L11
        r14 = DefaultTTNetImpl.toByteArray(r15.body().in());     // Catch: Throwable -> L11
        List<Header> r16 = r15.headers();     // Catch: Throwable -> L11
        if (l6.a.e0(r16) == true) goto L9;
        Iterator<Header> r17 = r16.iterator();     // Catch: Throwable -> L11
    L7:
        if (r17.hasNext() == false) goto L9;
        Header r18 = r17.next();     // Catch: Throwable -> L11
        r13.put(r18.getName(), r18.getValue());     // Catch: Throwable -> L11
    L9:
        int r19 = r15.code();     // Catch: Throwable -> L11
    L21:
        return new u8.b(r19, r13, r14);
    L11:
        th = move-exception;
        th.printStackTrace();
        if ((th instanceof b7.b) == false) goto L15;
        int r20 = ((b7.b) th).f3131a;
    L17:
        if ((th instanceof c) == false) goto L19;
        r19 = ((c) th).f78a;
        goto L21
    L19:
        r19 = r20;
        goto L21
    L15:
        r20 = 0;
        goto L17
    }
}
