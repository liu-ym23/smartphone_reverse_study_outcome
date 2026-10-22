package com.bytedance.android.live.livepullstream.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import gl0.a;
import gl0.c;
import gl0.d;
import gl0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.livepullstream.PullStreamService")
public interface IPullStreamService extends a {
    /* synthetic */ ILivePlayerClient getLivePlayerClient(long r1, Bundle r3);

    c getLivePlayerOptimizer();

    d getLiveStatusErrorView(Context r1, ILivePlayerScene r2);

    f getStreamStrategyOptimizer();

    /* synthetic */ boolean preCreateSurface(Context r1, long r2, Bundle r4);

    /* synthetic */ boolean prePullStream(long r1, Bundle r3);

    void tryInstallBMFPlugin();

    void tryInstallPullStreamPlugin();

    /* synthetic */ void useSurfaceControl(Context r1, long r2, Bundle r4);
}
