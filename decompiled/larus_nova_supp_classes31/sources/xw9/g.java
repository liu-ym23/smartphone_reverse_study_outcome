package xw9;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new f());
    }

    public static boolean a() {
        return !((Boolean) a.getValue()).booleanValue();
    }
}
