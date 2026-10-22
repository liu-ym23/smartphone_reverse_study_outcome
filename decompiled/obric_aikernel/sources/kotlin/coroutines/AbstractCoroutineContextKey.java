package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@ExperimentalStdlibApi
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    private final Function1<CoroutineContext.Element, E> safeCast;
    private final CoroutineContext.Key<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Key<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractCoroutineContextKey(CoroutineContext.Key<B> r10, Function1<? super CoroutineContext.Element, ? extends E> r11) {
        Intrinsics.checkNotNullParameter(r10, "baseKey");
        Intrinsics.checkNotNullParameter(r11, "safeCast");
        this.safeCast = r11;
        boolean r12 = r10 instanceof AbstractCoroutineContextKey;
        ?? r13 = r10;
        if (r12 == false) goto L5;
        r13 = (CoroutineContext.Key<B>) ((AbstractCoroutineContextKey) r10).topmostKey;
    L5:
        this.topmostKey = r13;
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.Key<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (r10 != this) goto L5;
    L8:
        return true;
    L5:
        if (this.topmostKey == r10) goto L8;
        return false;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineContext.Element r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return (CoroutineContext.Element) this.safeCast.invoke(r10);
    }
}
