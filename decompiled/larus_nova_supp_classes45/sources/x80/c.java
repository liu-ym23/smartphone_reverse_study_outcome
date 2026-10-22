package x80;

import com.bytedance.android.live.core.verify.strategy.IVerifyStrategyFactory;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static b a(int r1) {
        IVerifyStrategyFactory r0 = (IVerifyStrategyFactory) k.f(IVerifyStrategyFactory.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.createVerifyStrategy(r1);
    }
}
