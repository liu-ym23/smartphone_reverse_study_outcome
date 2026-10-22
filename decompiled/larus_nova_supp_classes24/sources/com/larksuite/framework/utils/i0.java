package com.larksuite.framework.utils;

import android.util.LruCache;
import com.lark.kmp.server.pb.improto.Packet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i0<T> {
    public final LruCache<String, T> a;

    public i0() {
        this.a = new LruCache(Packet.DEFAULT_STATUS);
    }

    public final T a(String r3, String r4) {
        if (r3 == null) goto L6;
        if (r4 != null) goto L5;
        return null;
    L5:
        return this.a.get(r3 + "-" + r4);
    L6:
        return null;
    }

    public final void b(String r3, String r4, T r5) {
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        if (r5 == null) goto L9;
        this.a.put(r3 + "-" + r4, r5);
        return;
    L9:
        return;
    L8:
        return;
    }
}
