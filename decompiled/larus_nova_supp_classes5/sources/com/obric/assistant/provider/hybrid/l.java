package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.bytedance.ai.api.AppletExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l implements a {
    public l() {
    }

    public Bundle call(String r3, Bundle r4) {
        if (r4 == null) goto L8;
        AppletExtService r0 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q(r4);
    L8:
        return null;
    }
}
