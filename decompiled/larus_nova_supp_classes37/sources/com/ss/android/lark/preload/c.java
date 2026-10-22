package com.ss.android.lark.preload;

import android.os.SystemClock;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static StrategyConfig a;

    static {
    }

    public static StrategyConfig a() {
        long r0 = SystemClock.elapsedRealtime();
        StrategyConfig r2 = e1c.c.d.get();
        if (r2 == null) goto L7;
        Log.d("StrategyConfig", "getStrategyConfig from AB = " + r2.getBizFrequencyDisableValue() + ", " + r2.getHitRateDisableValue());
        return r2;
    L7:
        if (a != null) goto L9;
        a = (StrategyConfig) SettingManager.getInstance().get(StrategyConfig.class);
    L9:
        Log.d("StrategyConfig", "getStrategyConfig cost = " + (SystemClock.elapsedRealtime() - r0));
        StrategyConfig r1 = a;
        if (r1 == null) goto L12;
        return r1;
    L12:
        return new StrategyConfig(0.0d, 0.0d, 3, null);
    }
}
