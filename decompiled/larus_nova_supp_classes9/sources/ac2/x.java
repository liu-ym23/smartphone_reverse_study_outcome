package ac2;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.interactivity.service.uplink.FrontierTransformConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x {
    public static final FrontierTransformConfig a = null;

    static {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L9;
        HostBoeParams r1 = r0.getHostBoeParams();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.getBoeEnable() != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        FrontierTransformConfig r3 = FrontierTransformConfig.BOE_DOUYIN_DOULITE;
    L13:
        a = r3;
        return;
    L12:
        r3 = FrontierTransformConfig.ONLINE_DOUYIN_DOULITE;
    L9:
        r2 = false;
        goto L10
    }
}
