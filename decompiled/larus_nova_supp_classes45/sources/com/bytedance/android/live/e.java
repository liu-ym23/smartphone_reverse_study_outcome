package com.bytedance.android.live;

import com.bytedance.android.live.core.verify.strategy.IVerifyStrategyFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class e implements IVerifyStrategyFactory {
    public e() {
    }

    @Override // com.bytedance.android.live.core.verify.strategy.IVerifyStrategyFactory
    public y80.b createRechargeVerifyStrategy(int r2) {
        int r0 = y80.c.a;
        if (r2 == 1) goto L5;
        return null;
    L5:
        return new y80.b(new z80.e());
    }

    @Override // com.bytedance.android.live.core.verify.strategy.IVerifyStrategyFactory
    public x80.b createVerifyStrategy(int r2) {
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L16;
        if (r2 == 4) goto L14;
        return null;
    L14:
        return new x80.b(new z80.f());
    L16:
        return new x80.b(new z80.b());
    L18:
        return new x80.b(new z80.c());
    L20:
        return new x80.b(new z80.d());
    L22:
        return new x80.b(new z80.a());
    }
}
