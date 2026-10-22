package gy;

import com.bytedance.android.live.link.ILinkServiceExternal;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c {
    public static final a c2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static c a() {
            return ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getRtcService();
        }
    }

    static {
        c2 = a.a;
    }

    f getRtcManager();
}
