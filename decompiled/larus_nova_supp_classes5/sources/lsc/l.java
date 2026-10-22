package lsc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l implements k {
    public final Map<Class<? extends uvc.b>, x> a;

    public static class a {
        public final Map<Class<? extends uvc.b>, x> a;

        public a() {
            this.a = new HashMap(3);
        }

        public final a a(Class r2, x r3) {
            ((HashMap) this.a).put(r2, r3);
            return this;
        }
    }

    public l(Map<Class<? extends uvc.b>, x> r1) {
        this.a = r1;
    }

    public final <N extends uvc.b> x a(Class<N> r2) {
        return this.a.get(r2);
    }
}
