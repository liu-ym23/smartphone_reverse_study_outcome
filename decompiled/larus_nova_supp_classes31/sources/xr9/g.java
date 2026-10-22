package xr9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import kotlin.jvm.internal.Intrinsics;
import wr9.k;
import wr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final wr9.d a(wr9.d r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter("unitm_status_unavailable", CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        if (r5.a != 0) goto L7;
        int r0 = wr9.d.f;
        return wr9.d.a.a(PowerMetricAvailability.TEMPORARILY_UNAVAILABLE, r5.c, r5.d, "unitm_status_unavailable");
    L7:
        return wr9.d.a(r5, PowerMetricAvailability.STALE, "unitm_status_unavailable", 13);
    }

    public static final wr9.j b(long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        return new wr9.j(r10, new l(c(r10, r12), c(r10, r12), c(r10, r12), c(r10, r12), c(r10, r12)), new wr9.b(c(r10, r12), c(r10, r12)), new wr9.c(c(r10, r12), c(r10, r12), c(r10, r12), c(r10, r12)), new wr9.a(c(r10, r12), c(r10, r12), c(r10, r12)), new k(c(r10, r12), c(r10, r12), c(r10, r12), c(r10, r12)));
    }

    public static final <T> wr9.d<T> c(long r2, String r4) {
        int r0 = wr9.d.f;
        return wr9.d.a.a(PowerMetricAvailability.TEMPORARILY_UNAVAILABLE, PowerMetricSource.UNKNOWN, r2, r4);
    }
}
