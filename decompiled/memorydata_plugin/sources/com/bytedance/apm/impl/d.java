package com.bytedance.apm.impl;

import com.bytedance.apm.util.i;
import com.bytedance.apm.util.r;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.services.apm.api.g;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1378b;
    private boolean c;
    private Map<String, String> d;
    private Map<String, TypedOutput> e;

    public d(String r3, String r4, boolean r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        this.e = new HashMap();
        this.f1377a = r3;
        this.d = r7;
        this.f1378b = r4;
        this.c = r5;
    }

    private com.bytedance.services.apm.api.c a(String r5, Map<String, TypedOutput> r6, Map<String, String> r7) {
        Map<String, TypedOutput> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        RetrofitMonitorService r9 = (RetrofitMonitorService) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r5, RetrofitMonitorService.class), RetrofitMonitorService.class, "com.obric.memorydata.plugin");
        HashMap r1 = new HashMap();
        SsResponse<TypedInput> r10 = r9.uploadFiles(r5, r4, DefaultTTNetImpl.convertHeaderMap(r8)).execute();     // Catch: Throwable -> L11
        byte[] r11 = DefaultTTNetImpl.toByteArray(((TypedInput) ZeusTransformUtils.preCheckCast(r10.body(), TypedInput.class, "com.obric.memorydata.plugin")).in());     // Catch: Throwable -> L11
        List<Header> r12 = r10.headers();     // Catch: Throwable -> L11
        if (i.a(r12) == true) goto L9;
        Iterator<Header> r13 = r12.iterator();     // Catch: Throwable -> L11
    L7:
        if (r13.hasNext() == false) goto L9;
        Header r14 = (Header) ZeusTransformUtils.preCheckCast(r13.next(), Header.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r1.put(r14.getName(), r14.getValue());     // Catch: Throwable -> L11
    L9:
        int r15 = r10.code();     // Catch: Throwable -> L11
    L19:
        return new com.bytedance.services.apm.api.c(r15, r1, r11);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r16 = new JSONObject();
        r16.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, th.getMessage() + r.a(th));     // Catch: Exception -> L15
        r16.put("exception_object", th.toString());     // Catch: Exception -> L15
    L17:
        r11 = r16.toString().getBytes();
        r15 = 100001;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // com.bytedance.services.apm.api.g
    public com.bytedance.services.apm.api.c a() {
        return a(this.f1377a, this.e, this.d);
    }

    @Override // com.bytedance.services.apm.api.g
    public void a(String r3, File r4, String r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        this.e.put(r3, new c(r7, new TypedFile(null, r4)));
    }

    @Override // com.bytedance.services.apm.api.g
    public void a(String r2, String r3) {
        this.e.put(r2, new TypedString(r3));
    }

    @Override // com.bytedance.services.apm.api.g
    public void a(String r2, String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.e.put(r2, new b(r2, r3, r6));
    }
}
