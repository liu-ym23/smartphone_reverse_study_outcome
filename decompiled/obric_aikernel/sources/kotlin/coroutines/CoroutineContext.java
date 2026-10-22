package kotlin.coroutines;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
public interface CoroutineContext {

    public static final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext r10, CoroutineContext r11) {
            Intrinsics.checkNotNullParameter(r11, "context");
            if (r11 != EmptyCoroutineContext.INSTANCE) goto L6;
            return r10;
        L6:
            return (CoroutineContext) r11.fold(r10, AnonymousClass1.INSTANCE);
        }
    }

    public interface Element extends CoroutineContext {

        public static final class DefaultImpls {
            public static <R> R fold(Element r10, R r11, Function2<? super R, ? super Element, ? extends R> r12) {
                Intrinsics.checkNotNullParameter(r12, "operation");
                return r12.invoke(r11, r10);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element r10, Key<E> r11) {
                Intrinsics.checkNotNullParameter(r11, "key");
                if (Intrinsics.areEqual(r10.getKey(), r11) == false) goto L5;
                Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return r10;
            L5:
                return null;
            }

            public static CoroutineContext minusKey(Element r10, Key<?> r11) {
                Intrinsics.checkNotNullParameter(r11, "key");
                if (Intrinsics.areEqual(r10.getKey(), r11) == true) goto L5;
                return r10;
            L5:
                return EmptyCoroutineContext.INSTANCE;
            }

            public static CoroutineContext plus(Element r10, CoroutineContext r11) {
                Intrinsics.checkNotNullParameter(r11, "context");
                return DefaultImpls.plus(r10, r11);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r10, Function2<? super R, ? super Element, ? extends R> r11);

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> r10);

        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        CoroutineContext minusKey(Key<?> r10);
    }

    public interface Key<E extends Element> {
    }

    <R> R fold(R r10, Function2<? super R, ? super Element, ? extends R> r11);

    <E extends Element> E get(Key<E> r10);

    CoroutineContext minusKey(Key<?> r10);

    CoroutineContext plus(CoroutineContext r10);
}
