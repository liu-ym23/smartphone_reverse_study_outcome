package org.ehcache.shadow.org.terracotta.offheapstore.paging;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f18123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18124b;

    public int a() {
        ByteBuffer r0 = this.f18123a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.capacity();
    }

    public int b() {
        return this.f18124b;
    }
}
