package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
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
        ICronetDepend r0 = this.mCronetDependAdapter;
        if (r0 != null) goto L5;
        return CronetHttpURLConnection.SS_COOKIE;
    L5:
        return r0.getSsCookieKey();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r1, String r2) {
        ICronetDepend r0 = this.mCronetDependAdapter;
        if (r0 == null) goto L6;
        r0.loggerD(r1, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        ICronetDepend r0 = this.mCronetDependAdapter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.loggerDebug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r3) {
        this.mCronetDependAdapter = (ICronetDepend) ZeusTransformUtils.wrapperContextForParams(r3, ICronetDepend.class, "com.obric.memorydata.plugin");
    }
}
