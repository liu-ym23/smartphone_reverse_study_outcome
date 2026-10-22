package gw0;

import com.bytedance.android.live.recharge.platform.service.RechargeConfigService;
import com.bytedance.android.live.recharge.utils.f;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.revenue.log.d;
import com.bytedance.android.scope.o;
import hx0.b;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o {
    public final RechargeConfigService a;

    /* JADX INFO: renamed from: gw0.a$a, reason: collision with other inner class name */
    public static final class C0246a {
        public static final C0246a a = null;

        public C0246a() {
        }

        static {
            a = new C0246a();
        }
    }

    public final void onStop() {
    }

    public final void onStart() {
        RechargeConfigService r0 = this.a;
        b r2 = new b();
        r0.getClass();
        Intrinsics.checkNotNullParameter(b.class, "key");
        Intrinsics.checkNotNullParameter(r2, "logFilter");
        HashMap<Class<?>, d<?>> r1 = f.a;
        Intrinsics.checkNotNullParameter(b.class, "logClass");
        Intrinsics.checkNotNullParameter(r2, FileUtils.FILTER);
        f.a.put(b.class, r2);
    }

    public a(RechargeConfigService r2) {
        Intrinsics.checkNotNullParameter(r2, "rechargeConfigService");
        this.a = r2;
    }
}
