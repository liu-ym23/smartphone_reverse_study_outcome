package j8b;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h<T, R> implements Function {
    public static final h<T, R> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r2) {
        com.ss.android.lark.security.compliance.infra.network.h r3 = (com.ss.android.lark.security.compliance.infra.network.h) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (i) r3.d;
    }
}
