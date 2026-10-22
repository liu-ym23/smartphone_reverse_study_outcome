package bz1;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.api.ILinkService;
import kotlin.jvm.internal.Intrinsics;
import mz0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final void a(j r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        p11.j r0 = f.a(ILinkService.class).getRevenueLinkDataHolder();
        r3.d(r0.getChannelId());
        r3.i(r0.a());
        r3.f((int) r0.getDuration());
        r3.c(r0.A());
        r3.h(r0.getPkId());
        r3.j(r0.B());
        r3.b(r0.getRequestId());
        r3.e(r0.isOnceMore());
        r3.g(r0.getTheme());
    }
}
