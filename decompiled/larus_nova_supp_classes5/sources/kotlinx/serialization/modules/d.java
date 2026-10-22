package kotlinx.serialization.modules;

import java.util.List;
import juc.n;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class d {
    public d() {
    }

    @ExperimentalSerializationApi
    public abstract void a(g r1);

    @ExperimentalSerializationApi
    public abstract <T> juc.d<T> b(KClass<T> r1, List<? extends juc.d<?>> r2);

    public abstract boolean d();

    @ExperimentalSerializationApi
    public abstract <T> juc.c<T> e(KClass<? super T> r1, String r2);

    @ExperimentalSerializationApi
    public abstract <T> n<T> f(KClass<? super T> r1, T r2);

    public static /* synthetic */ juc.d c(d r1, KClass r2) {
        return r1.b(r2, CollectionsKt.emptyList());
    }
}
