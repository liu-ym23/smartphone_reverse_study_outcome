package wi8;

import com.larus.platform.model.chat.v;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new b());
        b = LazyKt.lazy(new c());
    }

    public static v a() {
        return (v) a.getValue();
    }
}
