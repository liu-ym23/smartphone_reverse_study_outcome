package com.ss.ugc.live.sdk.platform.bytelink;

import com.bytedance.common.utility.collection.WeakContainer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import vlc.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements d {
    public final ConcurrentHashMap<String, WeakContainer<com.ss.ugc.live.sdk.platform.bytelink.dispatch.c>> a;

    @Override // vlc.f
    public final boolean c() {
        return false;
    }

    @Override // vlc.f
    public final void p(n r1) {
    }

    @Override // vlc.f
    public final boolean w(tlc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadItem");
        return false;
    }

    public f() {
        new ConcurrentHashMap();
        this.a = new ConcurrentHashMap();
        new b();
    }

    @Override // com.ss.ugc.live.sdk.platform.bytelink.d
    public final void d(String r3, com.ss.ugc.live.sdk.platform.bytelink.dispatch.c r4) {
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "listener");
        WeakContainer<com.ss.ugc.live.sdk.platform.bytelink.dispatch.c> r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        r0 = new WeakContainer();
        this.a.put(r3, r0);
    L5:
        r0.add(r4);
    }

    @Override // com.ss.ugc.live.sdk.platform.bytelink.d
    public final void m(String r2, com.ss.ugc.live.sdk.platform.bytelink.dispatch.c r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "listener");
        WeakContainer<com.ss.ugc.live.sdk.platform.bytelink.dispatch.c> r4 = this.a.get(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L9;
        r4.remove(r3);
        return;
    }
}
