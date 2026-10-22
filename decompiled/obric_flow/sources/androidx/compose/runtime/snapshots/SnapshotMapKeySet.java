package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0002J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapKeySet;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "addAll", "elements", "", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "Landroidx/compose/runtime/snapshots/StateMapMutableKeysIterator;", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshotStateMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotMapKeySet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotStateMap\n+ 4 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 5 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n*L\n1#1,360:1\n1855#2,2:361\n1726#2,3:406\n84#3,2:363\n129#3,4:365\n133#3:370\n121#3:371\n134#3,5:373\n86#3,7:378\n139#3,2:385\n125#3:387\n141#3,6:393\n149#3,3:402\n93#3:405\n70#4:369\n2279#5:372\n2172#5,2:388\n1722#5:390\n2174#5,2:391\n2176#5,3:399\n*S KotlinDebug\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotMapKeySet\n*L\n227#1:361,2\n237#1:406,3\n234#1:363,2\n234#1:365,4\n234#1:370\n234#1:371\n234#1:373,5\n234#1:378,7\n234#1:385,2\n234#1:387\n234#1:393,6\n234#1:402,3\n234#1:405\n234#1:369\n234#1:372\n234#1:388,2\n234#1:390\n234#1:391,2\n234#1:399,3\n*E\n"})
final class SnapshotMapKeySet<K, V> extends SnapshotMapSet<K, V, K> {
    public SnapshotMapKeySet(SnapshotStateMap<K, V> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        super(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r5) {
        return ((Boolean) add(r5)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection r5) {
        return ((Boolean) addAll(r5)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r5) {
        return getMap().containsKey(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Collection<? extends Object> r10 = r5;
        if (r10.isEmpty() == true) goto L15;
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        Object r12 = r11.next();
        if (getMap().containsKey(r12) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r5) {
        if (getMap().remove(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Iterator<T> r10 = r5.iterator();
    L3:
        boolean r11 = false;
    L5:
        if (r10.hasNext() == false) goto L10;
        if (getMap().remove(r10.next()) != null) goto L9;
        if (r11 == false) goto L3;
    L9:
        r11 = true;
        goto L5
    L10:
        return r11;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        Set r12 = CollectionsKt.toSet(r11);
        SnapshotStateMap<K, V> r10 = getMap();
        boolean r5 = false;
    L3:
        Object r13 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r13);
        StateRecord r14 = r10.getFirstStateRecord();     // Catch: Throwable -> L38
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L38
        SnapshotStateMap.StateMapStateRecord r15 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current((SnapshotStateMap.StateMapStateRecord) r14);     // Catch: Throwable -> L38
        PersistentMap<K, V> r16 = r15.getMap$runtime_release();     // Catch: Throwable -> L38
        int r17 = r15.getModification$runtime_release();     // Catch: Throwable -> L38
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r13);
        Intrinsics.checkNotNull(r16);
        PersistentMap.Builder<K, V> r19 = r16.builder();
        Iterator<Map.Entry<K, V>> r20 = r10.entrySet().iterator();
    L8:
        boolean r21 = true;
        if (r20.hasNext() == false) goto L13;
        Map.Entry<K, V> r22 = r20.next();
        if (r12.contains(r22.getKey()) == true) goto L8;
        r19.remove(r22.getKey());
        r5 = true;
        goto L8
    L13:
        Unit r23 = Unit.INSTANCE;
        PersistentMap<K, V> r24 = r19.build();
        if (Intrinsics.areEqual(r24, r16) == true) goto L37;
        StateRecord r25 = r10.getFirstStateRecord();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        SnapshotStateMap.StateMapStateRecord r26 = (SnapshotStateMap.StateMapStateRecord) r25;
        SnapshotKt.getSnapshotInitializer();
        Object r27 = SnapshotKt.getLock();
        monitor-enter(r27);
        Snapshot r28 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L31
        SnapshotStateMap.StateMapStateRecord r29 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(r26, r10, r28);     // Catch: Throwable -> L31
        Object r30 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L31
        monitor-enter(r30);     // Catch: Throwable -> L31
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L20:
        if (r29.getModification$runtime_release() != r17) goto L25;
        r29.setMap$runtime_release(r24);     // Catch: Throwable -> L23
        r29.setModification$runtime_release(r29.getModification$runtime_release() + 1);     // Catch: Throwable -> L23
    L26:
        monitor-exit(r30);     // Catch: Throwable -> L31
        monitor-exit(r27);
        SnapshotKt.notifyWrite(r28, r10);
        if (r21 == false) goto L3;
    L25:
        r21 = false;
    L31:
        th = move-exception;
        throw th;
    L37:
        return r5;
    L38:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Set, java.util.Collection
    public Void add(K r5) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection
    public Void addAll(Collection<? extends K> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public StateMapMutableKeysIterator<K, V> iterator() {
        return new StateMapMutableKeysIterator(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }
}
