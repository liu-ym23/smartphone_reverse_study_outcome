package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements IPreLoaderItemCallBackListener {
    public d() {
    }

    public final void preloadItemInfo(PreLoaderItemCallBackInfo r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.getKey();
    }
}
