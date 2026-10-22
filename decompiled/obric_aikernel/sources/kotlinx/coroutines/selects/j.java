package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public interface j {
    Function3<Object, k<?>, Object, Unit> a();

    Object b();

    Function3<k<?>, Object, Object, Function1<Throwable, Unit>> c();

    Function3<Object, Object, Object, Object> d();
}
