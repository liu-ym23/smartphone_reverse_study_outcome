package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoVideoPreloadDependServiceImpl$b implements IPreLoaderItemCallBackListener {
    public AoVideoPreloadDependServiceImpl$b() {
    }

    public final void preloadItemInfo(PreLoaderItemCallBackInfo r2) {
        g.b("AoVideoPreloadDependServiceImpl preloadItemInfo");
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.getKey() != 2) goto L9;
        g.b("AoVideoPreloadDependServiceImpl preloadVideo success");
        return;
    }
}
