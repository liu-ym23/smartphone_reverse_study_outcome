package tz0;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {
    public abstract List<com.bytedance.android.livesdk.revenue.network.a> a();

    public abstract INetworkService.Biz b();

    public a() {
        Iterator<T> r0 = a().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.revenue.network.a r1 = (com.bytedance.android.livesdk.revenue.network.a) r0.next();
        ((INetworkService) f.a(INetworkService.class)).s(b(), r1);
        goto L4
    }
}
