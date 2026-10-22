package com.bytedance.apm.internal;

import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.j;
import com.bytedance.services.apm.api.IHttpService;
import d6.c;
import java.io.File;
import java.util.List;
import java.util.Map;
import jg.k;
import oj.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApmDelegate implements pj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f3881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3882b;

    /* JADX INFO: renamed from: com.bytedance.apm.internal.ApmDelegate$7, reason: invalid class name */
    class AnonymousClass7 implements IHttpService {
        final /* synthetic */ ApmDelegate this$0;

        public AnonymousClass7(ApmDelegate r5) {
            this.this$0 = r5;
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public f buildMultipartUpload(String r5, String r10, boolean r11) throws Exception {
            return j.d.buildMultipartUpload(r5, r10, r11);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public oj.b doGet(String r5, Map<String, String> r10) throws Exception {
            return j.d.doGet(r5, r10);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public oj.b doPost(String r5, byte[] r10, Map<String, String> r11) throws Exception {
            return j.d.doPost(r5, r10, r11);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public oj.b uploadFiles(String r5, List<File> r10, Map<String, String> r11) throws Exception {
            return j.d.uploadFiles(r5, r10, r11);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public f buildMultipartUpload(String r5, String r10, boolean r11, Map<String, String> r12) throws Exception {
            return j.d.buildMultipartUpload(r5, r10, r11, r12);
        }
    }

    public static e6.a a() {
        uj.a r5 = new uj.a();
        e6.a r10 = new e6.a();
        r10.f16759a = 1000;
        r10.f16760b = 20000;
        r10.f16761c = 15000;
        r10.d = 1000;
        r10.e = 30000;
        j.f3887a = false;
        td.b.f22124a = false;
        r10.f = r5;
        return r10;
    }

    private void initEvilMethodTraceInject() {
    }

    private static void initTraceEvilMethod() {
        xg.b.f23140i = 1000;
        xg.b.f23142k = false;
        xg.b.f23141j = true;
        c.f16598k.b();
        MethodCollector.getInstance().onStart();
        new xg.b(false).b();
        k.m().getClass();
    }

    @Override // pj.a
    public final void d(JSONObject r5, boolean r10) {
        JSONObject r11 = r5.optJSONObject("general");
        if (r11 == null) goto L5;
        this.f3882b = r11.optBoolean("enable_active_upload_alog", true);
        return;
    L5:
        this.f3882b = true;
    }

    @Override // pj.a
    public final void e() {
        this.f3881a = true;
        Object r5 = null;
        r5.getClass();
        throw null;
    }
}
