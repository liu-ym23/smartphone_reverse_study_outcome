package e0a;

import com.bytedance.keva.Keva;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final Keva a = null;

    static {
        a = Keva.getRepo("worldcup_lottery_state", 0);
    }

    public static boolean a() {
        boolean r0 = a.getBoolean("lottery_state_".concat(o.a.getDeviceId()), false);
        FLogger.a.i("WorldCupLotteryManager", "getLotteryState state:" + r0);
        return r0;
    }
}
