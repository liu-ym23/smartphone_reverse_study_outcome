package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class CronetDependManager implements ICronetDepend {
    private static volatile CronetDependManager sCronetDependManager;
    private ICronetDepend mCronetDependAdapter;

    private CronetDependManager() {
    }

    public static CronetDependManager inst() {
        if (sCronetDependManager != null) goto L15;
        monitor-enter(CronetDependManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sCronetDependManager != null) goto L9;
        sCronetDependManager = new CronetDependManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetDependManager.class);     // Catch: Throwable -> L11
    L15:
        return sCronetDependManager;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        ICronetDepend r10 = this.mCronetDependAdapter;
        if (r10 != null) goto L5;
        return CronetHttpURLConnection.SS_COOKIE;
    L5:
        return r10.getSsCookieKey();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r10, String r11) {
        ICronetDepend r12 = this.mCronetDependAdapter;
        if (r12 == null) goto L6;
        r12.loggerD(r10, r11);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        ICronetDepend r10 = this.mCronetDependAdapter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.loggerDebug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r10) {
        this.mCronetDependAdapter = r10;
    }
}
