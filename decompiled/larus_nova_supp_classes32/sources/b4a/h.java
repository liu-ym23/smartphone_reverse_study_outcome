package b4a;

import hq9.c5;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new g());
    }

    public static c5 a() {
        return (c5) a.getValue();
    }
}
