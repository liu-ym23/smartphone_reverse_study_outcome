package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final String a = null;
    public static final String b = null;

    static {
        a = k.n(IHostContext.class).getServerDeviceId();
        b = k.n(IUserService.class).user().getSessionKey();
    }
}
