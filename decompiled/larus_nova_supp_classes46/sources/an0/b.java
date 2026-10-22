package an0;

import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.revenue.platform.api.core.c;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends tz0.a {
    public static final b a = null;

    public final List<com.bytedance.android.livesdk.revenue.network.a> a() {
        return c.a(new a[]{new a()});
    }

    static {
        a = new b();
    }

    public b() {
    }

    public final INetworkService.Biz b() {
        return INetworkService.Biz.MultiLink;
    }
}
