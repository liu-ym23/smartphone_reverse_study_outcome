package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class PrimitiveSnapshotStateKt {
    public static final float getValue(FloatState r5, Object r10, KProperty<?> r11) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue(r5, r10, r11);
    }

    @StateFactoryMarker
    public static final MutableFloatState mutableFloatStateOf(float r5) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(r5);
    }

    public static final void setValue(MutableFloatState r5, Object r10, KProperty<?> r11, float r12) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue(r5, r10, r11, r12);
    }
}
