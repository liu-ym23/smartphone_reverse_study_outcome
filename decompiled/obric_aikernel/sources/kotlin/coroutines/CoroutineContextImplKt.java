package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element r10, CoroutineContext.Key<E> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "key");
        if ((r11 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r12 = (AbstractCoroutineContextKey) r11;
        if (r12.isSubKey$kotlin_stdlib(r10.getKey()) == false) goto L15;
        E r13 = (E) r12.tryCast$kotlin_stdlib(r10);
        if ((r13 instanceof CoroutineContext.Element) == true) goto L9;
        return null;
    L9:
        return r13;
    L15:
        return null;
    L11:
        if (r10.getKey() != r11) goto L14;
        return r10;
    L14:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element r10, CoroutineContext.Key<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "key");
        if ((r11 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r12 = (AbstractCoroutineContextKey) r11;
        if (r12.isSubKey$kotlin_stdlib(r10.getKey()) == true) goto L7;
        return r10;
    L7:
        if (r12.tryCast$kotlin_stdlib(r10) != null) goto L9;
        return r10;
    L9:
        return EmptyCoroutineContext.INSTANCE;
    L11:
        if (r10.getKey() == r11) goto L13;
        return r10;
    L13:
        return EmptyCoroutineContext.INSTANCE;
    }
}
