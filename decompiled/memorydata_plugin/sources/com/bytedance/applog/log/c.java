package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements j {
    private static final Map<String, j> c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f1627b;

    static {
        c = new ConcurrentHashMap();
    }

    public c() {
        ArrayList r0 = new ArrayList();
        this.f1627b = r0;
        r0.add("logger@" + hashCode());
    }

    private String a(Object r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.toString();
    }

    public static j b(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(c.get(r2), j.class, "com.obric.memorydata.plugin");
    }

    public String a(String r8, Object... r9) {
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L28
        if (r9 != null) goto L5;
    L25:
        r0.append(r8);     // Catch: Throwable -> L28
    L26:
        return r0.toString();
    L5:
        if (r9.length == 0) goto L25;
        if (r8.contains("{}") == false) goto L25;
        int r1 = r8.length();     // Catch: Throwable -> L28
        int r2 = 0;
        int r3 = 0;
    L10:
        if (r2 >= r1) goto L26;
        char r4 = r8.charAt(r2);     // Catch: Throwable -> L28
        if (r2 >= (r1 - 1)) goto L14;
        char r5 = r8.charAt(r2 + 1);     // Catch: Throwable -> L28
    L16:
        if (r4 == '{') goto L18;
    L23:
        r0.append(r4);     // Catch: Throwable -> L28
    L24:
        r2 = r2 + 1;     // Catch: Throwable -> L28
        goto L10
    L18:
        if (r5 != '}') goto L23;
        if (r3 >= r9.length) goto L22;
        r0.append(a(r9[r3]));     // Catch: Throwable -> L28
        r3 = r3 + 1;     // Catch: Throwable -> L28
    L22:
        r2 = r2 + 1;     // Catch: Throwable -> L28
        goto L24
    L14:
        r5 = ' ';
    L28:
        return r8;
    }

    public List<String> a(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        if (r4.size() <= 0) goto L9;
        ArrayList r0 = new ArrayList();
        r0.addAll(this.f1627b);
        r0.addAll(r4);
        return r0;
    L9:
        return this.f1627b;
    }

    public void a(int r3, int r4, List<String> r5, Throwable r6, String r7, Object... r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (o.a() == false) goto L5;
        return;
    L5:
        l r10 = l.a().a(this.f1626a).b(r3).a(r4).b(Thread.currentThread().getName()).a(r6).a(a(r9)).c(a(r7, r8)).a();
        o.a(r10);
        k r2 = o.a(this.f1626a);
        if (r2 == null) goto L9;
        r2.a(r10);
        return;
    }

    @Override // com.bytedance.applog.log.j
    public void a(String r3) {
        this.f1626a = r3;
        c.put(r3, this);
        c("Current logger bind to appId {}", new Object[]{r3});
    }
}
