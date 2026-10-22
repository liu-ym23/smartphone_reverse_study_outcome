package lsc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class p$a implements m$b {
    public final Map<Class<? extends uvc.b>, m$c<? extends uvc.b>> a;
    public m$a b;

    public p$a() {
        this.a = new HashMap();
    }

    public final p$a a(Class r2, m$c r3) {
        ((HashMap) this.a).put(r2, r3);
        return this;
    }
}
