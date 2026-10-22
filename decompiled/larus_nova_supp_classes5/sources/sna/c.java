package sna;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public final Keva a() {
        return (Keva) this.a.getValue();
    }

    public c() {
        this.a = LazyKt.lazy(new sna.a());
        this.b = LazyKt.lazy(new b());
    }
}
