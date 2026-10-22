package com.bytedance.apm.internal;

import c2.k;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import u8.b;
import u8.e;

/* JADX INFO: loaded from: classes.dex */
public class ApmDelegate implements v8.a {

    /* JADX INFO: renamed from: com.bytedance.apm.internal.ApmDelegate$8, reason: invalid class name */
    class AnonymousClass8 implements IHttpService {
        final /* synthetic */ ApmDelegate this$0;

        public AnonymousClass8(ApmDelegate r8) {
            this.this$0 = r8;
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public e buildMultipartUpload(String r8, String r10, boolean r11) {
            return k.f3301e.buildMultipartUpload(r8, r10, r11);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public b doGet(String r8, Map<String, String> r10) {
            return k.f3301e.doGet(r8, r10);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public b doPost(String r8, byte[] r10, Map<String, String> r11) {
            return k.f3301e.doPost(r8, r10, r11);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public b uploadFiles(String r8, List<File> r10, Map<String, String> r11) {
            return k.f3301e.uploadFiles(r8, r10, r11);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public e buildMultipartUpload(String r8, String r10, boolean r11, Map<String, String> r12) {
            return k.f3301e.buildMultipartUpload(r8, r10, r11, r12);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ApmDelegate f3770a = null;

        static {
            f3770a = new ApmDelegate();
        }
    }

    public ApmDelegate() {
    }

    private void initEvilMethodTraceInject() {
    }

    private static void initTraceEvilMethod() {
        h8.a.f7923i = 1000;
        h8.a.f7925k = false;
        h8.a.f7924j = true;
        i2.b r8 = i2.b.f8089k;
        r8.d();
        i2.e.f();
        h8.a r10 = new h8.a(false);
        monitor-enter(r10);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (r10.f7932g == false) goto L9;
    L6:
        monitor-exit(r10);
        com.bytedance.monitor.collector.a.b().getClass();
        return;
    L9:
        if (h8.a.f7925k == true) goto L11;
    L33:
        r10.f7932g = true;     // Catch: Throwable -> L37
        goto L6
    L11:
        if (h8.a.f7924j == false) goto L33;
        if (r8.f8090a == true) goto L31;
        monitor-enter(r8);     // Catch: Throwable -> L37
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L16:
        if (k.f() == true) goto L19;
    L23:
        monitor-exit(r8);     // Catch: Throwable -> L37
        goto L31
    L19:
        if (r8.f8099j == false) goto L26;
        if (r8.f8090a == true) goto L23;
        r8.f8090a = true;     // Catch: Throwable -> L27
        goto L23
    L26:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L27
    L31:
        if (r8.f8093d.contains(r10) == true) goto L33;
        r8.f8093d.add(r10);     // Catch: Throwable -> L37
        goto L33
    }

    @Override // v8.a
    public final void a(JSONObject r8) {
        JSONObject r10 = r8.optJSONObject("general");
        if (r10 == null) goto L6;
        r10.optBoolean("enable_active_upload_alog", true);
        return;
    }

    @Override // v8.a
    public final void b() {
        throw null;
    }
}
