package cl0;

import com.bytedance.android.live.core.privacy.av.api.b;
import com.bytedance.android.live.livepkaudience.security.LinkSecurityMonitor;
import com.bytedance.android.livesdk.config.mh0;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends LinkSecurityMonitor {
    public static final a d = null;

    static {
        d = new a();
    }

    @Override // com.bytedance.android.live.livepkaudience.security.LinkSecurityMonitor
    public final boolean b() {
        return ((Boolean) mh0.a.getValue()).booleanValue();
    }

    public a() {
    }

    public static void f(a r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        b.a.getClass();
        b.a.a r1 = b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r2 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        Intrinsics.checkNotNullParameter(r2, "config");
        r4.c("on_link_destroyed", r0, r1, r2);
    }

    public static void g(a r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        b.a.getClass();
        b.a.a r1 = b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r2 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        Intrinsics.checkNotNullParameter(r2, "config");
        r4.d("self_mute", r0, r1, r2);
    }
}
