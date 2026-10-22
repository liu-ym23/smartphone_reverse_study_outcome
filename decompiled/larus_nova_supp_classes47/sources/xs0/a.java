package xs0;

import am2.l;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.revlink.api.ILinkService;
import p11.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final l a() {
        boolean r0 = h.a;
        j r1 = ((ILinkService) h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        l r2 = new l();
        r2.a = r1.getChannelId();
        r2.b = r1.a();
        r2.c = (int) r1.getDuration();
        r2.d = r1.A();
        r2.e = r1.getPkId();
        r2.h = r1.B();
        r2.i = r1.getRequestId();
        r2.a(Boolean.valueOf(r1.isOnceMore()));
        r2.f = r1.getTheme();
        return r2;
    }
}
