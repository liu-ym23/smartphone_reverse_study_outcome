package mv0;

import com.bytedance.android.live.revlink.api.ILinkService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w implements qs0.t {
    public w() {
    }

    @Override // qs0.t
    public final boolean a(String r2) {
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        p11.e r1 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo468getMultiAnchorService();
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.a(r2) != true) goto L7;
        return true;
    }
}
