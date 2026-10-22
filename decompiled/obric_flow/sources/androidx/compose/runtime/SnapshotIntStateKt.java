package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class SnapshotIntStateKt {
    public static final int getValue(IntState r5, Object r10, KProperty<?> r11) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue(r5, r10, r11);
    }

    @StateFactoryMarker
    public static final MutableIntState mutableIntStateOf(int r5) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(r5);
    }

    public static final void setValue(MutableIntState r5, Object r10, KProperty<?> r11, int r12) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue(r5, r10, r11, r12);
    }
}
