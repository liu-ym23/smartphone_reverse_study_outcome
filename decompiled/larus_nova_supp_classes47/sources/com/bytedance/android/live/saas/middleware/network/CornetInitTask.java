package com.bytedance.android.live.saas.middleware.network;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.bdinstall.f;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.k;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.AppConfig;
import com.ss.android.common.applog.b0;
import com.ss.android.common.applog.c0;
import com.ss.android.common.applog.d0;
import eta.b;
import jta.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.chromium.c;
import org.chromium.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/CornetInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "()V", "init", "", "app", "Landroid/app/Application;", "params", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class CornetInitTask implements ISdkInitTask<NetworkConfig> {
    public CornetInitTask() {
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r3, NetworkConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "app");
        Intrinsics.checkNotNullParameter(r4, "params");
        final IExtraParamProvider r5 = r4.getExtraParamProvider();
        if (r5 == null) goto L14;
        c0.b r0 = new CornetInitTask$init$1$1(r5);
        b r6 = c0.a;
        if (g.f() == false) goto L12;
        b0 r7 = new b0(r0);
        k r1 = i.b;
        if (r1.e() == false) goto L14;
        f r2 = r1.i;
        if (r2.a != null) goto L14;
        r2.a = r7;
        goto L14
    L12:
        if (d0.l != null) goto L14;
        d0.l = r0;
    L14:
        AppConfig.getInstance(r3).setForceUseCronet(true);
        d r8 = d.a();
        r8.a = CronetDependAdapter.INSTANCE;
        c.h().l(CronetDependAdapter.INSTANCE);
        TTNetInit.setCronetDepend(CronetDependAdapter.INSTANCE);
        TTNetInit.preInitCronetKernel();     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r1, NetworkConfig r2) {
        init2(r1, r2);
    }
}
