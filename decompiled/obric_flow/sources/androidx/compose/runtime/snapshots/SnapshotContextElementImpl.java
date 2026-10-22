package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElementImpl;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlinx/coroutines/a2;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "<init>", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Landroidx/compose/runtime/snapshots/Snapshot;", "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/snapshots/Snapshot;)V", "Landroidx/compose/runtime/snapshots/Snapshot;", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", STGroup.DICT_KEY, "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalComposeApi
final class SnapshotContextElementImpl implements SnapshotContextElement, a2 {
    private final Snapshot snapshot;

    public SnapshotContextElementImpl(Snapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        this.snapshot = r5;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r5, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r10) {
        return (R) SnapshotContextElement.DefaultImpls.fold(this, r5, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r5) {
        return (E) SnapshotContextElement.DefaultImpls.get(this, r5);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return SnapshotContextElement.Key;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r5) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, r5);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r5) {
        return SnapshotContextElement.DefaultImpls.plus(this, r5);
    }

    @Override // kotlinx.coroutines.a2
    public /* bridge */ /* synthetic */ void restoreThreadContext(CoroutineContext r5, Object r10) {
        restoreThreadContext(r5, (Snapshot) r10);
    }

    @Override // kotlinx.coroutines.a2
    public /* bridge */ /* synthetic */ Object updateThreadContext(CoroutineContext r5) {
        return updateThreadContext(r5);
    }

    public void restoreThreadContext(CoroutineContext r5, Snapshot r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.snapshot.unsafeLeave(r10);
    }

    @Override // kotlinx.coroutines.a2
    public Snapshot updateThreadContext(CoroutineContext r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return this.snapshot.unsafeEnter();
    }
}
