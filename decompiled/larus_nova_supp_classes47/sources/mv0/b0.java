package mv0;

import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 extends qs0.a<IPkAudienceLinkOutService> implements qs0.u {

    public static final class a extends qs0.a<com.bytedance.android.live.pkaudience.api.a> {
        public a(com.bytedance.android.live.pkaudience.api.a r2) {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            super(r2);
        }

        public final int k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            return ((com.bytedance.android.live.pkaudience.api.a) this.a).O4(r2);
        }

        public final boolean l(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            return ((com.bytedance.android.live.pkaudience.api.a) this.a).a(r2);
        }
    }

    public b0() {
        super(jc1.k.n(IPkAudienceLinkOutService.class));
    }

    @Override // qs0.u
    public final a getPkLinkUserInfoCenter() {
        com.bytedance.android.live.pkaudience.api.a r0 = ((IPkAudienceLinkOutService) this.a).getPkLinkUserInfoCenter();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new a(r0);
    }
}
