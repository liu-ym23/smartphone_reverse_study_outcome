package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.model.VideoInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements IPreLoaderItemCallBackListener {
    public e() {
    }

    public final void preloadItemInfo(PreLoaderItemCallBackInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.getKey();
        if (r3.getKey() != 1) goto L12;
        List r4 = r3.usingUrlInfos;
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.size() <= 0) goto L14;
        VideoInfo r5 = (VideoInfo) ListProtector.get(r4, 0);
        r5.getValueStr(15);
        r5.getResolution();
        return;
    L14:
        return;
    }
}
