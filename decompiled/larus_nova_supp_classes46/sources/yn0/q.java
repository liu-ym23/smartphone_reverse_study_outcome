package yn0;

import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements l81.q {
    public static final q a = null;

    public q() {
    }

    static {
        a = new q();
    }

    public final RechargeCurrentCacheData getCurrentRechargeCacheDataObject() {
        IRechargeServiceExternal r0 = jc1.k.f(IRechargeServiceExternal.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentRechargeCacheDataObject();
    }
}
