package com.bytedance.ttnet.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, b> f3213b;

    public a() {
        this.f3213b = new ConcurrentHashMap();
    }

    public static synchronized a a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f3212a != null) goto L7;
        f3212a = new a();     // Catch: Throwable -> L10
    L7:
        a r1 = f3212a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r1;
    }

    public c a(String r3, int r4, Map<String, String> r5) {
        b r0 = new b(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
        this.f3213b.put(r0.a(), r0);
        r0.e();
        r0.b();
        this.f3213b.remove(r0.a());
        return r0.d();
    }

    public void a(String r8, String r9, int r10, int r11, int r12, List<String> r13, String r14) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        b r15 = (b) ZeusTransformUtils.preCheckCast(this.f3213b.get(r8), b.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L6;
        r15.setResult(new c(r10, r11, r12, r5, r14));
        r15.c();
        this.f3213b.remove(r8);
        return;
    }
}
