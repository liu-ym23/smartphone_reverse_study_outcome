package zo0;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.livesdk.config.ae0;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.Objects;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public boolean a;
    public long b;
    public final PerformanceScene c;

    public interface a {
        void d(PerformanceScene r1);

        void e(PerformanceScene r1, long r2, double r4, JSONObject r6);
    }

    /* JADX INFO: renamed from: zo0.b$b, reason: collision with other inner class name */
    public static final class C0301b implements IStallCallback {
        public final /* synthetic */ b a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;

        public final void onFpsReady(double r9, JSONObject r11) {
            if (v.a() == false) goto L5;
            Objects.toString(this.a.c);
            Objects.toString(r11);
        L5:
            a r1 = this.b;
            if (r1 == null) goto L9;
            r1.e(this.a.c, this.c, r9, r11);
            return;
        }

        public C0301b(b r1, a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onBlockReady(long r1, int r3, long r4) {
            if (v.a() == false) goto L5;
            Objects.toString(this.a.c);
        L5:
            a r2 = this.b;
            if (r2 == null) goto L9;
            r2.d(this.a.c);
            return;
        }
    }

    public final void a() {
        if (this.a == false) goto L5;
        return;
    L5:
        if (((Boolean) ae0.a.getValue()).booleanValue() == false) goto L13;
        this.a = true;
        this.b = SystemClock.uptimeMillis();
        IPerformanceManager r0 = k.f(IPerformanceManager.class);
        if (r0 == null) goto L12;
        r0.startMonitorFps(this.c.getValue());
        return;
    L12:
        return;
    }

    public b(PerformanceScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.c = r2;
    }

    public final void b(a r6) {
        if (this.a == true) goto L5;
        return;
    L5:
        this.a = false;
        long r0 = SystemClock.uptimeMillis() - this.b;
        IPerformanceManager r2 = k.f(IPerformanceManager.class);
        if (r2 == null) goto L9;
        r2.stopMonitorFps(this.c.getValue(), new C0301b(this, r6, r0));
        r2.releaseFpsMonitor(this.c.getValue());
        return;
    }
}
