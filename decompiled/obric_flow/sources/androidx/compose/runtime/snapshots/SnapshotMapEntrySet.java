package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001d\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0012H\u0096\u0002J\u001c\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\"\u0010\u0015\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "contains", "", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshotStateMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotMapEntrySet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotStateMap\n+ 4 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 5 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n*L\n1#1,360:1\n1179#2,2:361\n1253#2,4:363\n1726#2,3:410\n84#3,2:367\n129#3,4:369\n133#3:374\n121#3:375\n134#3,5:377\n86#3,7:382\n139#3,2:389\n125#3:391\n141#3,6:397\n149#3,3:406\n93#3:409\n70#4:373\n2279#5:376\n2172#5,2:392\n1722#5:394\n2174#5,2:395\n2176#5,3:403\n*S KotlinDebug\n*F\n+ 1 SnapshotStateMap.kt\nandroidx/compose/runtime/snapshots/SnapshotMapEntrySet\n*L\n209#1:361,2\n209#1:363,4\n216#1:410,3\n210#1:367,2\n210#1:369,4\n210#1:374\n210#1:375\n210#1:377,5\n210#1:382,7\n210#1:389,2\n210#1:391\n210#1:397,6\n210#1:406,3\n210#1:409\n210#1:373\n210#1:376\n210#1:392,2\n210#1:394\n210#1:395,2\n210#1:403,3\n*E\n"})
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    public SnapshotMapEntrySet(SnapshotStateMap<K, V> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        super(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r5) {
        return ((Boolean) add((Map.Entry) r5)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection r5) {
        return ((Boolean) addAll(r5)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object r5) {
        if (TypeIntrinsics.isMutableMapEntry(r5) == true) goto L7;
        return false;
    L7:
        return contains((Map.Entry) r5);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Collection<? extends Object> r10 = r5;
        if (r10.isEmpty() == true) goto L15;
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        if (contains((Map.Entry) r11.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new StateMapMutableEntriesIterator(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object r5) {
        if (TypeIntrinsics.isMutableMapEntry(r5) == true) goto L7;
        return false;
    L7:
        return remove((Map.Entry) r5);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Iterator<? extends Object> r10 = r5.iterator();
    L3:
        boolean r11 = false;
    L5:
        if (r10.hasNext() == false) goto L10;
        if (getMap().remove(((Map.Entry) r10.next()).getKey()) != null) goto L9;
        if (r11 == false) goto L3;
    L9:
        r11 = true;
        goto L5
    L10:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        Collection<? extends Object> r12 = r11;
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r12)), 16));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r10 = (Map.Entry) r13.next();
        Pair r14 = TuplesKt.to(r10.getKey(), r10.getValue());
        r5.put(r14.getFirst(), r14.getSecond());
        goto L4
    L6:
        SnapshotStateMap<K, V> r15 = getMap();
        boolean r16 = false;
    L7:
        Object r17 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r17);
        StateRecord r18 = r15.getFirstStateRecord();     // Catch: Throwable -> L44
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L44
        SnapshotStateMap.StateMapStateRecord r19 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current((SnapshotStateMap.StateMapStateRecord) r18);     // Catch: Throwable -> L44
        PersistentMap<K, V> r20 = r19.getMap$runtime_release();     // Catch: Throwable -> L44
        int r21 = r19.getModification$runtime_release();     // Catch: Throwable -> L44
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r17);
        Intrinsics.checkNotNull(r20);
        PersistentMap.Builder<K, V> r23 = r20.builder();
        Iterator<Map.Entry<K, V>> r24 = r15.entrySet().iterator();
    L12:
        boolean r25 = true;
        if (r24.hasNext() == false) goto L19;
        Map.Entry<K, V> r26 = r24.next();
        if (r5.containsKey(r26.getKey()) == false) goto L18;
        if (Intrinsics.areEqual(r5.get(r26.getKey()), r26.getValue()) == true) goto L12;
    L18:
        r23.remove(r26.getKey());
        r16 = true;
        goto L12
    L19:
        Unit r27 = Unit.INSTANCE;
        PersistentMap<K, V> r28 = r23.build();
        if (Intrinsics.areEqual(r28, r20) == true) goto L43;
        StateRecord r29 = r15.getFirstStateRecord();
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        SnapshotStateMap.StateMapStateRecord r30 = (SnapshotStateMap.StateMapStateRecord) r29;
        SnapshotKt.getSnapshotInitializer();
        Object r31 = SnapshotKt.getLock();
        monitor-enter(r31);
        Snapshot r32 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L37
        SnapshotStateMap.StateMapStateRecord r33 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(r30, r15, r32);     // Catch: Throwable -> L37
        Object r34 = SnapshotStateMapKt.access$getSync$p();     // Catch: Throwable -> L37
        monitor-enter(r34);     // Catch: Throwable -> L37
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L26:
        if (r33.getModification$runtime_release() != r21) goto L31;
        r33.setMap$runtime_release(r28);     // Catch: Throwable -> L29
        r33.setModification$runtime_release(r33.getModification$runtime_release() + 1);     // Catch: Throwable -> L29
    L32:
        monitor-exit(r34);     // Catch: Throwable -> L37
        monitor-exit(r31);
        SnapshotKt.notifyWrite(r32, r15);
        if (r25 == false) goto L7;
    L31:
        r25 = false;
    L37:
        th = move-exception;
        throw th;
    L43:
        return r16;
    L44:
        th = move-exception;
        throw th;
    }

    public Void add(Map.Entry<K, V> r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection
    public Void addAll(Collection<? extends Map.Entry<K, V>> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean contains(Map.Entry<K, V> r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        return Intrinsics.areEqual(getMap().get(r5.getKey()), r5.getValue());
    }

    public boolean remove(Map.Entry<K, V> r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        if (getMap().remove(r5.getKey()) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
