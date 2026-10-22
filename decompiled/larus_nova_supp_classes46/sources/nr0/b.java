package nr0;

import com.bytedance.android.live.profit.lottery.k3;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T, R> implements Function {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        k3 r3 = (k3) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.c;
    }
}
