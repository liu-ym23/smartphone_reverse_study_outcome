package o82;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final LiveTracingMonitor.EventModule b = null;
    public final boolean a;

    static {
        b = LiveTracingMonitor.EventModule.ACTIVITY;
    }

    public g(boolean r1) {
        this.a = r1;
    }

    public final void a(String r6) {
        long r0 = System.currentTimeMillis();
        LiveMonitor.a r2 = new LiveMonitor.a("ttlive_live_load_interactive_banner", b);
        r2.j(r0 - 0);
        r.i().K();
        r2.l(-1);
        r2.c(String.valueOf(this.a));
        r2.i("url", r6);
        r2.i("msg", BuildConfig.FLAVOR);
        r2.a().report();
    }
}
