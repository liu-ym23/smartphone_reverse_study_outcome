package va1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final Map<String, Object> a;
    public final Set<String> b;

    public static class a {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public c() {
        this.a = new ConcurrentHashMap();
        this.b = Collections.synchronizedSet(new HashSet());
    }
}
