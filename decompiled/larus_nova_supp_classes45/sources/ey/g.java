package ey;

import com.bytedance.android.live.link.ILinkServiceExternal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface g {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static nc0.b a() {
            com.bytedance.android.live.revenuelink.connect.f r0 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getConnectService();
            if (r0 != null) goto L7;
            return null;
        L7:
            return new nc0.b(r0);
        }
    }

    static {
        a = a.a;
    }

    void a(int r1, j r2);
}
