package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements ICronetDepend {
    public static volatile d b;
    public ICronetDepend a;

    public static d a() {
        if (b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public final String getSsCookieKey() {
        ICronetDepend r0 = this.a;
        if (r0 != null) goto L5;
        return "X-SS-Cookie";
    L5:
        return r0.getSsCookieKey();
    }

    public final boolean loggerDebug() {
        ICronetDepend r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.loggerDebug();
    }

    public d() {
    }

    public final void setAdapter(ICronetDepend r1) {
        this.a = r1;
    }

    public final void loggerD(String r2, String r3) {
        ICronetDepend r0 = this.a;
        if (r0 == null) goto L6;
        r0.loggerD(r2, r3);
        return;
    }
}
