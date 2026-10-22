package kotlinx.serialization.modules;

import java.util.List;
import juc.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public interface g {
    <T> void a(KClass<T> r1, Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r2);

    <T> void b(KClass<T> r1, juc.d<T> r2);

    <Base> void c(KClass<Base> r1, Function1<? super String, ? extends juc.c<? extends Base>> r2);

    <Base> void d(KClass<Base> r1, Function1<? super Base, ? extends n<? super Base>> r2);

    <Base, Sub extends Base> void e(KClass<Base> r1, KClass<Sub> r2, juc.d<Sub> r3);
}
