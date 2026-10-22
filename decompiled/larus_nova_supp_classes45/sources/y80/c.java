package y80;

import com.bytedance.android.live.core.verify.strategy.IVerifyStrategyFactory;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static b a() {
        IVerifyStrategyFactory r0 = (IVerifyStrategyFactory) k.f(IVerifyStrategyFactory.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.createRechargeVerifyStrategy(1);
    }

    static {
    }
}
