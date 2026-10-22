package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.p2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateKt {
    @Composable
    public static final <T extends R, R> State<R> collectAsState(g r5, R r10, CoroutineContext r11, Composer r12, int r13, int r14) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(r5, r10, r11, r12, r13, r14);
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> r5, Function0<? extends T> r10) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(r5, r10);
    }

    public static final <T> T getValue(State<? extends T> r5, Object r10, KProperty<?> r11) {
        return (T) SnapshotStateKt__SnapshotStateKt.getValue(r5, r10, r11);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    @StateFactoryMarker
    public static final <T> MutableState<T> mutableStateOf(T r5, SnapshotMutationPolicy<T> r10) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(r5, r10);
    }

    public static /* synthetic */ MutableState mutableStateOf$default(Object r5, SnapshotMutationPolicy r10, int r11, Object r12) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r10, r11, r12);
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver r5, Function0<? extends R> r10) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(r5, r10);
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Object r10, Object r11, Object r12, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r13, Composer r14, int r15) {
        return SnapshotStateKt__ProduceStateKt.produceState(r5, r10, r11, r12, r13, r14, r15);
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    @Composable
    public static final <T> State<T> rememberUpdatedState(T r5, Composer r10, int r11) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(r5, r10, r11);
    }

    public static final <T> void setValue(MutableState<T> r5, Object r10, KProperty<?> r11, T r12) {
        SnapshotStateKt__SnapshotStateKt.setValue(r5, r10, r11, r12);
    }

    public static final <T> g snapshotFlow(Function0<? extends T> r5) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(r5);
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> r5) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(r5);
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> r5) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(r5);
    }

    @Composable
    public static final <T> State<T> collectAsState(p2 r5, CoroutineContext r10, Composer r11, int r12, int r13) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(r5, r10, r11, r12, r13);
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(Function0<? extends T> r5) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(r5);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf(T... r5) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(r5);
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... r5) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(r5);
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Object r10, Object r11, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r12, Composer r13, int r14) {
        return SnapshotStateKt__ProduceStateKt.produceState(r5, r10, r11, r12, r13, r14);
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Object r10, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r11, Composer r12, int r13) {
        return SnapshotStateKt__ProduceStateKt.produceState(r5, r10, r11, r12, r13);
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r10, Composer r11, int r12) {
        return SnapshotStateKt__ProduceStateKt.produceState(r5, r10, r11, r12);
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Object[] r10, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r11, Composer r12, int r13) {
        return SnapshotStateKt__ProduceStateKt.produceState(r5, r10, r11, r12, r13);
    }
}
