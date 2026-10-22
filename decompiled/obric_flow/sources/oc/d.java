package oc;

import com.bytedance.forest.utils.m;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {
    public static final d d = null;

    static {
        d = new d(com.bytedance.ies.bullet.preloadv2.c.f5882c);
    }

    @Override // oc.c
    public final m a(int r5) {
        if (r5 > 0) goto L6;
        r5 = 10485760;
    L6:
        return new a("子资源缓存池", r5, 1);
    }
}
