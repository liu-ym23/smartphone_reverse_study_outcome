package yu0;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ Function0 a;

    public b(Function0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Unit) r2, "it");
        jy0.b.d("PrivilegeRepository", "exchange request is completed");
        return (SingleSource) this.a.invoke();
    }
}
