package com.bytedance.ies.abmock;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f2663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile a f2664b;

    interface a {
        void a(String r1, Map<String, String> r2);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, String> f2665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2666b;

        public b() {
            this.f2665a = new HashMap();
        }

        static /* synthetic */ String a(b r0) {
            return r0.f2666b;
        }

        static /* synthetic */ Map b(b r0) {
            return r0.f2665a;
        }

        public b a(long r1) {
            return a("cost", String.valueOf(r1));
        }

        public b a(String r1) {
            this.f2666b = r1;
            return this;
        }

        public b a(String r2, String r3) {
            this.f2665a.put(r2, r3);
            return this;
        }
    }

    static {
        f2663a = new d();
    }

    private d() {
    }

    public static d a() {
        return f2663a;
    }

    public void a(a r3) {
        this.f2664b = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public void a(b r2) {
        a r1 = this.f2664b;     // Catch: Exception -> L6
        if (r1 == null) goto L9;
        r1.a(b.a(r2), b.b(r2));     // Catch: Exception -> L6
        return;
    L9:
        return;
    }
}
