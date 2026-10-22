package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0007\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0007\u001a0\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0082\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0080\bø\u0001\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"calculationBlockNestedLevel", "Landroidx/compose/runtime/SnapshotThreadLocal;", "", "derivedStateObservers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "derivedStateOf", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "notifyObservers", "R", "derivedState", "Landroidx/compose/runtime/DerivedState;", "block", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "", "observer", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
@SourceDebugExtension({"SMAP\nDerivedState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,385:1\n1162#2:386\n460#3,11:387\n460#3,11:398\n48#3:409\n*S KotlinDebug\n*F\n+ 1 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n*L\n352#1:386\n358#1:387,11\n362#1:398,11\n382#1:409\n*E\n"})
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal<Integer> calculationBlockNestedLevel = null;
    private static final SnapshotThreadLocal<MutableVector<DerivedStateObserver>> derivedStateObservers = null;

    static {
        calculationBlockNestedLevel = new SnapshotThreadLocal();
        derivedStateObservers = new SnapshotThreadLocal();
    }

    public static final /* synthetic */ SnapshotThreadLocal access$getCalculationBlockNestedLevel$p() {
        return calculationBlockNestedLevel;
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        SnapshotThreadLocal<MutableVector<DerivedStateObserver>> r5 = derivedStateObservers;
        MutableVector<DerivedStateObserver> r10 = r5.get();
        if (r10 != null) goto L6;
        MutableVector<DerivedStateObserver> r11 = new MutableVector(new DerivedStateObserver[0], 0);
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "calculation");
        return new DerivedSnapshotState(r5, null);
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> r10, Function0<? extends R> r11) {
        MutableVector<DerivedStateObserver> r5 = SnapshotStateKt.derivedStateObservers();
        int r12 = r5.getSize();
        int r13 = 0;
        if (r12 <= 0) goto L24;
        DerivedStateObserver[] r14 = r5.getContent();
        int r15 = 0;
    L5:
        r14[r15].start(r10);
        r15 = r15 + 1;
        if (r15 < r12) goto L5;
    L24:
        R r16 = r11.invoke();     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        int r17 = r5.getSize();
        if (r17 <= 0) goto L13;
        DerivedStateObserver[] r18 = r5.getContent();
    L11:
        r18[r13].done(r10);
        r13 = r13 + 1;
        if (r13 < r17) goto L11;
    L13:
        InlineMarker.finallyEnd(1);
        return r16;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        int r19 = r5.getSize();
        if (r19 <= 0) goto L22;
        DerivedStateObserver[] r20 = r5.getContent();
    L19:
        r20[r13].done(r10);
        r13 = r13 + 1;
        if (r13 < r19) goto L19;
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver r5, Function0<? extends R> r10) {
        Intrinsics.checkNotNullParameter(r5, "observer");
        Intrinsics.checkNotNullParameter(r10, "block");
        MutableVector<DerivedStateObserver> r11 = SnapshotStateKt.derivedStateObservers();
        r11.add(r5);     // Catch: Throwable -> L6
        r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r11.removeAt(r11.getSize() - 1);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r11.removeAt(r11.getSize() - 1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "policy");
        Intrinsics.checkNotNullParameter(r10, "calculation");
        return new DerivedSnapshotState(r10, r5);
    }
}
