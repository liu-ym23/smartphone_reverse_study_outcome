package x12;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.revenue.service.interact.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static int a() {
        int r0 = vh6.c.b(d.class).getMultiInteractMode();
        int r1 = f.a(ILinkService.class).getRevLinkControlService().getCurrentMode();
        int r2 = com.bytedance.android.live.utils.c.a;
        return r0 | r1;
    }

    static {
    }
}
