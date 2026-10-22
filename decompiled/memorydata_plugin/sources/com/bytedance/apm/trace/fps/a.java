package com.bytedance.apm.trace.fps;

import com.bytedance.apm.e.e;
import com.bytedance.apm.util.g;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm.l.b.InterfaceC0091b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, C0094a> f1453b;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.fps.a$a, reason: collision with other inner class name */
    private static class C0094a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f1457b;
        public float c;
        private long d;
        private int e;

        C0094a(Map<String, String> r3, String r4, float r5) {
            this.f1457b = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            this.f1456a = r4;
            this.c = r5;
            this.d = System.currentTimeMillis();
            this.e = 1;
        }

        float a() {
            int r0 = this.e;
            if (r0 > 0) goto L5;
            return -1.0f;
        L5:
            return this.c / r0;
        }

        void a(float r2) {
            this.c += r2;
            this.e++;
        }

        boolean a(long r3) {
            if ((r3 - this.d) <= 120000) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1458a = null;

        static {
            f1458a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1458a;
        }
    }

    private a() {
        this.f1453b = new HashMap();
        this.f1452a = true;
        com.bytedance.apm.l.b.a().a(this);
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return b.a();
    }

    static /* synthetic */ HashMap a(a r0) {
        return r0.f1453b;
    }

    @Override // com.bytedance.apm.l.b.InterfaceC0091b
    public void a(long r14) {
        if (this.f1453b.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, C0094a>> r0 = this.f1453b.entrySet().iterator();
        int r1 = g.b();
    L6:
        if (r0.hasNext() == false) goto L47;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        C0094a r3 = (C0094a) ZeusTransformUtils.preCheckCast(r2.getValue(), C0094a.class, "com.obric.memorydata.plugin");
        if (r3.a(r14) == false) goto L6;
        r0.remove();
        float r4 = r3.a();
        boolean r11 = false;
        if (com.bytedance.apm.b.k() == false) goto L13;
        e.c(com.bytedance.apm.e.b.c, new String[]{"aggregate fps: " + r7 + " , value: " + r4});
    L13:
        if (r4 <= 0.0f) goto L6;
        float r5 = r1;
        if (r4 <= r5) goto L36;
        r4 = r5;
    L36:
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L35
        r8.put("fps", r4);     // Catch: Exception -> L35
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L35
        r9.put(MemoryInfoSectionEditActivity.KIND_SCENE, r7);     // Catch: Exception -> L35
        com.bytedance.apm.data.a.e r6 = new com.bytedance.apm.data.a.e("fps", r7, r8, r9, null);     // Catch: Exception -> L35
        CommonDataAssembly.wrapFilters(r6, true);     // Catch: Exception -> L35
        JSONObject r10 = r6.f;     // Catch: Exception -> L35
        r10.put("refresh_rate", r1);     // Catch: Exception -> L35
        if (this.f1452a == false) goto L25;
        this.f1452a = false;     // Catch: Exception -> L35
        r10.put("device_max_refresh_rate", g.c());     // Catch: Exception -> L35
        if (g.d() == true) goto L23;
        r11 = true;
    L23:
        r10.put("refresh_rate_restricted", r11);     // Catch: Exception -> L35
    L25:
        if (r3.f1457b != null) goto L27;
    L32:
        com.bytedance.apm.data.pipeline.a.b().a(r6);     // Catch: Exception -> L35
        goto L6
    L27:
        if (r3.f1457b.isEmpty() == true) goto L32;
        Iterator<Map.Entry<String, String>> r12 = r3.f1457b.entrySet().iterator();     // Catch: Exception -> L35
    L30:
        if (r12.hasNext() == false) goto L32;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        r6.f.put((String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin"), r13.getValue());     // Catch: Exception -> L35
        goto L30
    L47:
        return;
    }

    public void a(Map<String, String> r3, final String r4, final float r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(this, r4, r6, r5));
    }
}
