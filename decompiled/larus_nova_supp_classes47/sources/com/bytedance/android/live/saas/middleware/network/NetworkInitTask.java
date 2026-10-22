package com.bytedance.android.live.saas.middleware.network;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.android.live.saas.middleware.network.imp.TTNetDepend;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/NetworkInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "Landroid/app/Application;", "app", "params", "", "init", "unInit", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "mApiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$j;", "mMonitorProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$j;", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkInitTask implements ISdkInitTask<NetworkConfig> {
    private final NetworkParams.ApiProcessHook<HttpRequestInfo> mApiProcessHook;
    private final NetworkParams.j<HttpRequestInfo> mMonitorProcessHook;

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
    }

    public NetworkInitTask() {
        this.mApiProcessHook = new NetworkInitTask$mApiProcessHook$1();
        this.mMonitorProcessHook = new NetworkInitTask$mMonitorProcessHook$1();
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r8, NetworkConfig r9) {
        Intrinsics.checkNotNullParameter(r8, "app");
        Intrinsics.checkNotNullParameter(r9, "params");
        TTNetInit.setTTNetDepend(TTNetDepend.inst());
        TTNetInit.tryInitTTNet(r8, r8, this.mApiProcessHook, this.mMonitorProcessHook, null, true, new boolean[0]);
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r1, NetworkConfig r2) {
        init2(r1, r2);
    }
}
