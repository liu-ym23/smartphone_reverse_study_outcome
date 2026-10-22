package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotLongStateKt__SnapshotLongStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class SnapshotLongStateKt {
    public static final long getValue(LongState r5, Object r10, KProperty<?> r11) {
        return SnapshotLongStateKt__SnapshotLongStateKt.getValue(r5, r10, r11);
    }

    @StateFactoryMarker
    public static final MutableLongState mutableLongStateOf(long r5) {
        return SnapshotLongStateKt__SnapshotLongStateKt.mutableLongStateOf(r5);
    }

    public static final void setValue(MutableLongState r5, Object r10, KProperty<?> r11, long r12) {
        SnapshotLongStateKt__SnapshotLongStateKt.setValue(r5, r10, r11, r12);
    }
}
