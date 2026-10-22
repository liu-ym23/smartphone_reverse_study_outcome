package rha;

import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = LazyKt.lazy(new b());
        b = LazyKt.lazy(new c());
        c = LazyKt.lazy(new d());
        d = LazyKt.lazy(new e());
    }

    public static String a(int r1) {
        return AppHost.a.getApplication().getString(r1);
    }
}
