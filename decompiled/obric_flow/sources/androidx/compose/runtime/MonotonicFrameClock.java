package androidx.compose.runtime;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ:\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u00070\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/coroutines/CoroutineContext$Element;", STGroup.DICT_KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Key", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MonotonicFrameClock extends CoroutineContext.Element {
    public static final Key Key = null;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(MonotonicFrameClock r5, R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r11) {
            Intrinsics.checkNotNullParameter(r11, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(r5, r10, r11);
        }

        public static <E extends CoroutineContext.Element> E get(MonotonicFrameClock r5, CoroutineContext.Key<E> r10) {
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            return (E) CoroutineContext.Element.DefaultImpls.get(r5, r10);
        }

        @Deprecated
        public static CoroutineContext.Key<?> getKey(MonotonicFrameClock r5) {
            return MonotonicFrameClock.access$getKey$jd(r5);
        }

        public static CoroutineContext minusKey(MonotonicFrameClock r5, CoroutineContext.Key<?> r10) {
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            return CoroutineContext.Element.DefaultImpls.minusKey(r5, r10);
        }

        public static CoroutineContext plus(MonotonicFrameClock r5, CoroutineContext r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return CoroutineContext.Element.DefaultImpls.plus(r5, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/MonotonicFrameClock$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/MonotonicFrameClock;", "()V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<MonotonicFrameClock> {
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

    static /* synthetic */ CoroutineContext.Key access$getKey$jd(MonotonicFrameClock r5) {
        return super.getKey();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    default CoroutineContext.Key<?> getKey() {
        return Key;
    }

    <R> Object withFrameNanos(Function1<? super Long, ? extends R> r5, Continuation<? super R> r10);
}
