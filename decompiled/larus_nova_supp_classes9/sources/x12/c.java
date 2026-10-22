package x12;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.scope.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final int a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        int r3 = vh6.c.b(d.class).getMultiInteractMode();
        int r0 = f.a(ILinkService.class).getRevLinkControlService().getCurrentMode();
        int r1 = com.bytedance.android.live.utils.c.a;
        return r3 | r0;
    }
}
