package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class SnapshotDoubleStateKt {
    public static final double getValue(DoubleState r5, Object r10, KProperty<?> r11) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue(r5, r10, r11);
    }

    @StateFactoryMarker
    public static final MutableDoubleState mutableDoubleStateOf(double r5) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(r5);
    }

    public static final void setValue(MutableDoubleState r5, Object r10, KProperty<?> r11, double r12) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue(r5, r10, r11, r12);
    }
}
