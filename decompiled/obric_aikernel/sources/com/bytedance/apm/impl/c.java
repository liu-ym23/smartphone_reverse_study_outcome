package com.bytedance.apm.impl;

import com.bytedance.apm.util.j;
import com.bytedance.apm.util.u;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.retrofit2.a0;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import r4.d;
import r4.e;
import r4.f;
import t4.g;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, f> f960c;

    public c(String r10, String r11, boolean r12, Map<String, String> r13) {
        this.f960c = new HashMap();
        this.f958a = r10;
        this.f959b = r13;
    }

    private t4.c b(String r10, Map<String, f> r11, Map<String, String> r12) {
        RetrofitMonitorService r13 = (RetrofitMonitorService) RetrofitUtils.g(r10, RetrofitMonitorService.class);
        HashMap r14 = new HashMap();
        a0<e> r15 = r13.uploadFiles(r10, r11, DefaultTTNetImpl.convertHeaderMap(r12)).execute();     // Catch: Throwable -> L11
        byte[] r16 = DefaultTTNetImpl.toByteArray(r15.a().c());     // Catch: Throwable -> L11
        List<n4.b> r17 = r15.e();     // Catch: Throwable -> L11
        if (j.b(r17) == true) goto L9;
        Iterator<n4.b> r18 = r17.iterator();     // Catch: Throwable -> L11
    L7:
        if (r18.hasNext() == false) goto L9;
        n4.b r19 = r18.next();     // Catch: Throwable -> L11
        r14.put(r19.a(), r19.b());     // Catch: Throwable -> L11
    L9:
        int r20 = r15.b();     // Catch: Throwable -> L11
    L19:
        return new t4.c(r20, r14, r16);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r21 = new JSONObject();
        r21.put("message", th.getMessage());     // Catch: Exception -> L15
        r21.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, th.getMessage() + u.a(th));     // Catch: Exception -> L15
        r21.put("exception_object", th.toString());     // Catch: Exception -> L15
    L17:
        r16 = r21.toString().getBytes();
        r20 = 100001;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // t4.g
    public void a(String r10, File r11, String r12, Map<String, String> r13) {
        this.f960c.put(r10, new b(r13, new d(null, r11)));
    }

    @Override // t4.g
    public void addFormField(String r10, String r11) {
        this.f960c.put(r10, new r4.g(r11));
    }

    @Override // t4.g
    public t4.c finish() {
        return b(this.f958a, this.f960c, this.f959b);
    }
}
