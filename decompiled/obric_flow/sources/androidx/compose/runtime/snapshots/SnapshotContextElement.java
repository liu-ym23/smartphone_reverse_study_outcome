package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "Key", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalComposeApi
public interface SnapshotContextElement extends CoroutineContext.Element {
    public static final Key Key = null;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(SnapshotContextElement r5, R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r11) {
            Intrinsics.checkNotNullParameter(r11, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(r5, r10, r11);
        }

        public static <E extends CoroutineContext.Element> E get(SnapshotContextElement r5, CoroutineContext.Key<E> r10) {
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            return (E) CoroutineContext.Element.DefaultImpls.get(r5, r10);
        }

        public static CoroutineContext minusKey(SnapshotContextElement r5, CoroutineContext.Key<?> r10) {
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            return CoroutineContext.Element.DefaultImpls.minusKey(r5, r10);
        }

        public static CoroutineContext plus(SnapshotContextElement r5, CoroutineContext r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return CoroutineContext.Element.DefaultImpls.plus(r5, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "()V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<SnapshotContextElement> {
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
}
