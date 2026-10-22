package oc;

import com.bytedance.forest.utils.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {
    public static final b d = null;

    static {
        d = new b(com.bytedance.ies.bullet.preloadv2.c.f5882c);
    }

    @Override // oc.c
    public final m a(int r5) {
        if (r5 > 0) goto L6;
        r5 = 10485760;
    L6:
        return new a("高优子资源缓存池", r5, 0);
    }
}
