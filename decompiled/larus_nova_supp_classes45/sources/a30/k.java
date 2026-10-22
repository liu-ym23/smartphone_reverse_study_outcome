package a30;

import com.bytedance.android.live.revlink.api.ILinkService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;

    public k(j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        p11.i r6 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionService();
        if (r6 == null) goto L5;
        r6.enableRenderFilter("", false, true);
    L5:
        if (r6 == null) goto L7;
        kc0.i.a.a(r6, this.b);
    L7:
        this.a.k("enable success, from = removeAndEnableWithDelay, linkRegionService = " + r6);
    }
}
