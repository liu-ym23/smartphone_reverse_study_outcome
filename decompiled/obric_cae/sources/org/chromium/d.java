package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ICronetDepend {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f9797b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICronetDepend f9798a;

    public d() {
    }

    public static d a() {
        if (f9797b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9797b != null) goto L9;
        f9797b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f9797b;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final String getSsCookieKey() {
        ICronetDepend r8 = this.f9798a;
        if (r8 != null) goto L5;
        return CronetHttpURLConnection.SS_COOKIE;
    L5:
        return r8.getSsCookieKey();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final void loggerD(String r8, String r10) {
        ICronetDepend r11 = this.f9798a;
        if (r11 == null) goto L6;
        r11.loggerD(r8, r10);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final boolean loggerDebug() {
        ICronetDepend r8 = this.f9798a;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.loggerDebug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final void setAdapter(ICronetDepend r8) {
        this.f9798a = r8;
    }
}
