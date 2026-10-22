package nca;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p0 {
    public static final AtomicInteger a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    static {
        a = new AtomicInteger(0);
        b = LazyKt.lazy(new a());
        c = LazyKt.lazy(new l());
        d = LazyKt.lazy(new w());
        e = LazyKt.lazy(new h0());
    }

    public static void a(Map r1, Class r2, Function1 r3) {
        if (r1.containsKey(r2) == true) goto L7;
        r1.put(r2, TuplesKt.to(Integer.valueOf(a.getAndIncrement()), r3));
        return;
    L7:
        throw new IllegalArgumentException("is already added: " + r2);
    }
}
