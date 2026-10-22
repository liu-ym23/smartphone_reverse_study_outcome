package kotlin.coroutines;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = null;

    public static final class DefaultImpls {
        public static <R> R fold(ContinuationInterceptor r10, R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r12) {
            Intrinsics.checkNotNullParameter(r12, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(r10, r11, r12);
        }

        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor r10, CoroutineContext.Key<E> r11) {
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
            if (ContinuationInterceptor.Key != r11) goto L14;
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return r10;
        L14:
            return null;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor r10, CoroutineContext.Key<?> r11) {
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
            if (ContinuationInterceptor.Key == r11) goto L13;
            return r10;
        L13:
            return EmptyCoroutineContext.INSTANCE;
        }

        public static CoroutineContext plus(ContinuationInterceptor r10, CoroutineContext r11) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return CoroutineContext.Element.DefaultImpls.plus(r10, r11);
        }

        public static void releaseInterceptedContinuation(ContinuationInterceptor r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "continuation");
        }
    }

    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key $$INSTANCE = null;

        static {
            $$INSTANCE = new Key();
        }

        private Key() {
        }
    }

    static {
        Key = Key.$$INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r10);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> r10);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    CoroutineContext minusKey(CoroutineContext.Key<?> r10);

    void releaseInterceptedContinuation(Continuation<?> r10);
}
