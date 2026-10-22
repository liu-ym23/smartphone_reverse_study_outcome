package y50;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    static {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "from");
        ALogger.i("ttlive_live_company", "enterRoom, from:".concat(r1));
        c("MTS:setScene:102/60/com.ss.android.ugc.aweme.live.LivePlayActivity/single-live-player-thread/computingPrefer/CPU");
        Intrinsics.checkNotNullParameter("content_consume_scene#com.ss.android.ugc.aweme_1", "info");
        IHostMonitor r0 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r0 == null) goto L6;
        r0.setCpuSceneInfo("content_consume_scene#com.ss.android.ugc.aweme_1");
        return;
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "from");
        ALogger.i("ttlive_live_company", "exitRoom, from:".concat(r1));
        c("MTS:setScene:103/60/com.ss.android.ugc.aweme.live.LivePlayActivity/single-live-player-thread/computingPrefer/CPU");
    }

    public static void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        IHostMonitor r0 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r0 == null) goto L6;
        r0.monitorOppoOptScene(r1);
        return;
    }
}
