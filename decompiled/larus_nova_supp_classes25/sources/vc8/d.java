package vc8;

import android.util.LruCache;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final d a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final boolean d = false;

    public d() {
    }

    static {
        a = new d();
        b = LazyKt.lazy(new b());
        c = LazyKt.lazy(new c());
        d = z2.a.coroutinesOptV1();
    }

    public static List a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        if (d == true) goto L7;
        return null;
    L7:
        return (List) ((LruCache) b.getValue()).get(r1);
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        if (d == true) goto L5;
        return;
    L5:
        ((LruCache) c.getValue()).remove(r1);
    }
}
