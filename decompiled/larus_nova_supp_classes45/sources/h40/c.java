package h40;

import com.bytedance.revenue.platform.api.core.rx.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        l r0 = l.a;
        return Observable.fromIterable(new IntRange(0, this.a.a)).concatMap(new b(this, r5));
    }
}
