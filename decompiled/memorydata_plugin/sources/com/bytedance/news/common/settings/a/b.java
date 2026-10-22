package com.bytedance.news.common.settings.a;

import com.bytedance.news.common.settings.api.i;
import com.bytedance.news.common.settings.api.j;
import com.bytedance.news.common.settings.internal.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f2911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f2912b;
    private j c;

    static {
        f2911a = new ConcurrentHashMap();
    }

    private b(j r3) {
        this.c = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
    }

    public static b a(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
        if (f2912b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2912b != null) goto L9;
        f2912b = new b(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f2912b;
    }

    @Override // com.bytedance.news.common.settings.api.j
    public i a(String r2) {
        return a(r2, false);
    }

    @Override // com.bytedance.news.common.settings.api.j
    public i a(String r4, boolean r5) {
        ConcurrentHashMap<String, a> r6 = f2911a;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r6.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        a r1 = new a(r4, this.c.a(r4));
        r6.put(r4, r1);
        return r1;
    }
}
