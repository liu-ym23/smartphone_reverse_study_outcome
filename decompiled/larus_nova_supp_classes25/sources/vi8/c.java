package vi8;

import com.larus.im.FlowRuntime;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new b());
    }

    public static boolean a() {
        a r0 = (a) b.getValue();
        FlowRuntime.b().a().isOversea();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return r0.b;
    }
}
