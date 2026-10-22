package kotlin.collections.builders;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u0080\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBE\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u0017\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00108J\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:J\r\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020<H\u0016J\b\u0010?\u001a\u00020<H\u0002J\u0019\u0010@\u001a\u00020!2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0000¢\u0006\u0002\bCJ!\u0010D\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010IJ\u0015\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010IJ\u0018\u0010L\u001a\u00020!2\u000e\u0010M\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:H\u0002J\u0010\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020<2\u0006\u0010Q\u001a\u00020\bH\u0002J\u0019\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0000¢\u0006\u0002\bTJ\u0013\u0010U\u001a\u00020!2\b\u0010M\u001a\u0004\u0018\u00010VH\u0096\u0002J\u0015\u0010W\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u0015\u0010X\u001a\u00020\b2\u0006\u0010K\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00106J\u0018\u0010Y\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010ZJ\u0015\u0010[\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020!H\u0016J\u0019\u0010^\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010_H\u0000¢\u0006\u0002\b`J\u001f\u0010a\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u00002\u0006\u0010K\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010bJ\u001e\u0010c\u001a\u00020<2\u0014\u0010d\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:H\u0016J\"\u0010e\u001a\u00020!2\u0018\u0010d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F0BH\u0002J\u001c\u0010f\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0002J\u0010\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020\bH\u0002J\b\u0010i\u001a\u00020<H\u0002J\u0010\u0010j\u001a\u00020<2\u0006\u0010k\u001a\u00020\bH\u0002J\u0017\u0010l\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010ZJ!\u0010m\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020<2\u0006\u0010p\u001a\u00020\bH\u0002J\u0010\u0010q\u001a\u00020<2\u0006\u0010r\u001a\u00020\bH\u0002J\u0017\u0010s\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\bt\u0010IJ\u0017\u0010u\u001a\u00020!2\u0006\u0010v\u001a\u00028\u0001H\u0000¢\u0006\u0004\bw\u0010IJ\u0010\u0010x\u001a\u00020!2\u0006\u0010y\u001a\u00020\bH\u0002J\b\u0010z\u001a\u00020{H\u0016J\u0019\u0010|\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010}H\u0000¢\u0006\u0002\b~J\b\u0010\u007f\u001a\u00020VH\u0002R\u0014\u0010\u0013\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0015R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00101\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity$kotlin_stdlib", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "modCount", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "ensureCapacity", "minCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "registerModification", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeEntryAt", "index", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeValue", "element", "removeValue$kotlin_stdlib", "shouldCompact", "extraCapacity", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public static final Companion Companion = null;
    private static final MapBuilder Empty = null;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/MapBuilder;", "", "getEmpty$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.access$getEmpty$cp();
        }

        private final int computeHashSize(int r2) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(r2, 1) * 3);
        }

        private final int computeShift(int r1) {
            return Integer.numberOfLeadingZeros(r1) + 1;
        }

        public static final /* synthetic */ int access$computeHashSize(Companion r0, int r1) {
            return r0.computeHashSize(r1);
        }

        public static final /* synthetic */ int access$computeShift(Companion r0, int r1) {
            return r0.computeShift(r1);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        @Override // java.util.Iterator
        public EntryRef<K, V> next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r0 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r0 + 1);
            setLastIndex$kotlin_stdlib(r0);
            EntryRef<K, V> r1 = new EntryRef(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L14;
            int r0 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r0 + 1);
            setLastIndex$kotlin_stdlib(r0);
            Object r1 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            int r2 = 0;
            if (r1 == null) goto L7;
            int r3 = r1.hashCode();
        L8:
            Object[] r4 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r4);
            Object r5 = r4[getLastIndex$kotlin_stdlib()];
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            int r6 = r3 ^ r2;
            initNext$kotlin_stdlib();
            return r6;
        L7:
            r3 = 0;
            goto L8
        L14:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public EntriesItr(MapBuilder<K, V> r2) {
            Intrinsics.checkNotNullParameter(r2, "map");
            super(r2);
        }

        public final void nextAppendString(StringBuilder r4) {
            Intrinsics.checkNotNullParameter(r4, "sb");
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L15;
            int r0 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r0 + 1);
            setLastIndex$kotlin_stdlib(r0);
            Object r1 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            if (r1 != getMap$kotlin_stdlib()) goto L7;
            r4.append("(this Map)");
        L8:
            r4.append('=');
            Object[] r2 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r2);
            Object r3 = r2[getLastIndex$kotlin_stdlib()];
            if (r3 != getMap$kotlin_stdlib()) goto L11;
            r4.append("(this Map)");
        L12:
            initNext$kotlin_stdlib();
            return;
        L11:
            r4.append(r3);
            goto L12
        L7:
            r4.append(r1);
            goto L8
        L15:
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        private final MapBuilder<K, V> map;

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) MapBuilder.access$getKeysArray$p(this.map)[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] r0 = MapBuilder.access$getValuesArray$p(this.map);
            Intrinsics.checkNotNull(r0);
            return (V) r0[this.index];
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(getKey());
            r0.append('=');
            r0.append(getValue());
            return r0.toString();
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = getKey();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            V r3 = getValue();
            if (r3 == null) goto L10;
            r1 = r3.hashCode();
        L10:
            return r2 ^ r1;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r3) {
            if ((r3 instanceof Map.Entry) == false) goto L9;
            Map.Entry r4 = (Map.Entry) r3;
            if (Intrinsics.areEqual(r4.getKey(), getKey()) == false) goto L9;
            if (Intrinsics.areEqual(r4.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r4) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] r0 = MapBuilder.access$allocateValuesArray(this.map);
            int r1 = this.index;
            V r2 = (V) r0[r1];
            r0[r1] = r4;
            return r2;
        }

        public EntryRef(MapBuilder<K, V> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "map");
            this.map = r2;
            this.index = r3;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0019J\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "expectedModCount", "", "index", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "checkForComodification", "", "checkForComodification$kotlin_stdlib", "hasNext", "", "initNext", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class Itr<K, V> {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public final void checkForComodification$kotlin_stdlib() {
            if (MapBuilder.access$getModCount$p(this.map) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        public final boolean hasNext() {
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void initNext$kotlin_stdlib() {
        L3:
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L7;
            int[] r0 = MapBuilder.access$getPresenceArray$p(this.map);
            int r1 = this.index;
            if (r0[r1] >= 0) goto L10;
            this.index = r1 + 1;
            goto L3
        L10:
            return;
        }

        public final void remove() {
            checkForComodification$kotlin_stdlib();
            if (this.lastIndex == (-1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.map.checkIsMutable$kotlin_stdlib();
            MapBuilder.access$removeEntryAt(this.map, this.lastIndex);
            this.lastIndex = -1;
            this.expectedModCount = MapBuilder.access$getModCount$p(this.map);
            return;
        L10:
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public Itr(MapBuilder<K, V> r2) {
            Intrinsics.checkNotNullParameter(r2, "map");
            this.map = r2;
            this.lastIndex = -1;
            this.expectedModCount = MapBuilder.access$getModCount$p(r2);
            initNext$kotlin_stdlib();
        }

        public final void setIndex$kotlin_stdlib(int r1) {
            this.index = r1;
        }

        public final void setLastIndex$kotlin_stdlib(int r1) {
            this.lastIndex = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        @Override // java.util.Iterator
        public K next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r0 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r0 + 1);
            setLastIndex$kotlin_stdlib(r0);
            K r1 = (K) MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        public KeysItr(MapBuilder<K, V> r2) {
            Intrinsics.checkNotNullParameter(r2, "map");
            super(r2);
        }
    }

    static {
        Companion = new Companion(null);
        MapBuilder r0 = new MapBuilder(0);
        r0.isReadOnly = true;
        Empty = r0;
    }

    public MapBuilder() {
        this(8);
    }

    private final V[] allocateValuesArray() {
        V[] r0 = this.valuesArray;
        if (r0 == null) goto L5;
        return r0;
    L5:
        V[] r1 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = r1;
        return r1;
    }

    private final void compact() {
        V[] r0 = this.valuesArray;
        int r1 = 0;
        int r2 = 0;
    L3:
        int r3 = this.length;
        if (r1 >= r3) goto L12;
        if (this.presenceArray[r1] < 0) goto L11;
        K[] r4 = this.keysArray;
        r4[r2] = r4[r1];
        if (r0 == null) goto L10;
        r0[r2] = r0[r1];
    L10:
        r2 = r2 + 1;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        ListBuilderKt.resetRange(this.keysArray, r2, r3);
        if (r0 == null) goto L15;
        ListBuilderKt.resetRange(r0, r2, this.length);
    L15:
        this.length = r2;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedMap(this);
    L7:
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr(this);
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> r0 = this.entriesView;
        if (r0 != null) goto L6;
        MapBuilderEntries<K, V> r1 = new MapBuilderEntries(this);
        this.entriesView = r1;
        return r1;
    L6:
        return r0;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> r0 = this.keysView;
        if (r0 != null) goto L6;
        MapBuilderKeys<K> r1 = new MapBuilderKeys(this);
        this.keysView = r1;
        return r1;
    L6:
        return r0;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> r0 = this.valuesView;
        if (r0 != null) goto L6;
        MapBuilderValues<V> r1 = new MapBuilderValues(this);
        this.valuesView = r1;
        return r1;
    L6:
        return r0;
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr(this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder((size() * 3) + 2);
        r0.append("{");
        EntriesItr<K, V> r1 = entriesIterator$kotlin_stdlib();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L8;
        if (r2 <= 0) goto L7;
        r0.append(", ");
    L7:
        r1.nextAppendString(r0);
        r2 = r2 + 1;
        goto L4
    L8:
        r0.append("}");
        return r0.toString();
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr(this);
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) goto L7;
        MapBuilder r0 = Empty;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return r0;
    L7:
        return this;
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int r0 = this.length - 1;
        if (r0 < 0) goto L10;
        int r2 = 0;
    L5:
        int[] r3 = this.presenceArray;
        int r4 = r3[r2];
        if (r4 < 0) goto L8;
        this.hashArray[r4] = 0;
        r3[r2] = -1;
    L8:
        if (r2 == r0) goto L10;
        r2 = r2 + 1;
    L10:
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] r1 = this.valuesArray;
        if (r1 == null) goto L13;
        ListBuilderKt.resetRange(r1, 0, this.length);
    L13:
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> r0 = entriesIterator$kotlin_stdlib();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + r0.nextHashCode$kotlin_stdlib();
        goto L4
    L6:
        return r1;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public static final /* synthetic */ MapBuilder access$getEmpty$cp() {
        return Empty;
    }

    public int getSize() {
        return this.size;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public MapBuilder(int r8) {
        this(ListBuilderKt.arrayOfUninitializedElements(r8), null, new int[r8], new int[Companion.access$computeHashSize(Companion, r8)], 2, 0);
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(MapBuilder r0) {
        return r0.allocateValuesArray();
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(MapBuilder r0) {
        return r0.keysArray;
    }

    public static final /* synthetic */ int access$getLength$p(MapBuilder r0) {
        return r0.length;
    }

    public static final /* synthetic */ int access$getModCount$p(MapBuilder r0) {
        return r0.modCount;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(MapBuilder r0) {
        return r0.presenceArray;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(MapBuilder r0) {
        return r0.valuesArray;
    }

    private final boolean contentEquals(Map<?, ?> r3) {
        if (size() == r3.size()) goto L5;
    L7:
        return false;
    L5:
        if (containsAllEntries$kotlin_stdlib(r3.entrySet()) == false) goto L7;
        return true;
    }

    private final void ensureCapacity(int r3) {
        if (r3 < 0) goto L14;
        if (r3 <= getCapacity$kotlin_stdlib()) goto L15;
        int r4 = AbstractList.Companion.newCapacity$kotlin_stdlib(getCapacity$kotlin_stdlib(), r3);
        this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, r4);
        V[] r0 = this.valuesArray;
        if (r0 == null) goto L8;
        V[] r1 = (V[]) ListBuilderKt.copyOfUninitializedElements(r0, r4);
    L9:
        this.valuesArray = r1;
        this.presenceArray = Arrays.copyOf(this.presenceArray, r4);
        int r5 = Companion.access$computeHashSize(Companion, r4);
        if (r5 <= getHashSize()) goto L16;
        rehash(r5);
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L9
    L15:
        return;
    L14:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r2) {
        if (shouldCompact(r2) == false) goto L5;
        rehash(getHashSize());
        return;
    L5:
        ensureCapacity(this.length + r2);
    }

    private final int findKey(K r6) {
        int r0 = hash(r6);
        int r1 = this.maxProbeDistance;
    L3:
        int r2 = this.hashArray[r0];
        if (r2 == 0) goto L5;
        if (r2 <= 0) goto L10;
        int r3 = r2 - 1;
        if (Intrinsics.areEqual(this.keysArray[r3], r6) == false) goto L10;
        return r3;
    L10:
        r1 = r1 - 1;
        if (r1 < 0) goto L12;
        int r4 = r0 - 1;
        if (r0 == 0) goto L15;
        r0 = r4;
        goto L3
    L15:
        r0 = getHashSize() - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    private final int findValue(V r3) {
        int r0 = this.length;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L10;
        if (this.presenceArray[r0] < 0) goto L3;
        V[] r1 = this.valuesArray;
        Intrinsics.checkNotNull(r1);
        if (Intrinsics.areEqual(r1[r0], r3) == false) goto L3;
        return r0;
    L10:
        return -1;
    }

    private final int hash(K r2) {
        if (r2 == null) goto L4;
        int r3 = r2.hashCode();
    L6:
        return (r3 * MAGIC) >>> this.hashShift;
    L4:
        r3 = 0;
        goto L6
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> r3) {
        boolean r1 = false;
        if (r3.isEmpty() == false) goto L5;
        return false;
    L5:
        ensureExtraCapacity(r3.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (putEntry(r4.next()) == false) goto L7;
        r1 = true;
        goto L7
    L11:
        return r1;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> r6) {
        int r0 = addKey$kotlin_stdlib(r6.getKey());
        V[] r1 = allocateValuesArray();
        if (r0 < 0) goto L6;
        r1[r0] = r6.getValue();
        return true;
    L6:
        int r2 = (-r0) - 1;
        V r3 = r1[r2];
        if (Intrinsics.areEqual(r6.getValue(), r3) == true) goto L10;
        r1[r2] = r6.getValue();
        return true;
    L10:
        return false;
    }

    private final boolean putRehash(int r6) {
        int r0 = hash(this.keysArray[r6]);
        int r1 = this.maxProbeDistance;
    L3:
        int[] r2 = this.hashArray;
        if (r2[r0] == 0) goto L5;
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        int r3 = r0 - 1;
        if (r0 == 0) goto L13;
        r0 = r3;
        goto L3
    L13:
        r0 = getHashSize() - 1;
        goto L3
    L9:
        return false;
    L5:
        r2[r0] = r6 + 1;
        this.presenceArray[r6] = r0;
        return true;
    }

    private final void rehash(int r3) {
        registerModification();
        if (this.length <= size()) goto L5;
        compact();
    L5:
        int r1 = 0;
        if (r3 == getHashSize()) goto L8;
        this.hashArray = new int[r3];
        this.hashShift = Companion.access$computeShift(Companion, r3);
    L10:
        if (r1 >= this.length) goto L16;
        int r4 = r1 + 1;
        if (putRehash(r1) == false) goto L15;
        r1 = r4;
        goto L10
    L15:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L16:
        return;
    L8:
        ArraysKt.fill(this.hashArray, 0, 0, getHashSize());
        goto L10
    }

    private final void removeEntryAt(int r3) {
        ListBuilderKt.resetAt(this.keysArray, r3);
        V[] r0 = this.valuesArray;
        if (r0 == null) goto L5;
        ListBuilderKt.resetAt(r0, r3);
    L5:
        removeHashAt(this.presenceArray[r3]);
        this.presenceArray[r3] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final void removeHashAt(int r10) {
        int r2 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r3 = 0;
        int r0 = r10;
    L3:
        int r4 = r10 - 1;
        if (r10 != 0) goto L6;
        r10 = getHashSize() - 1;
    L7:
        r3 = r3 + 1;
        if (r3 > this.maxProbeDistance) goto L9;
        int[] r5 = this.hashArray;
        int r6 = r5[r10];
        if (r6 == 0) goto L13;
        if (r6 >= 0) goto L19;
        r5[r0] = -1;
    L18:
        r0 = r10;
        r3 = 0;
    L22:
        r2 = r2 - 1;
        if (r2 >= 0) goto L3;
        this.hashArray[r0] = -1;
        return;
    L19:
        int r7 = r6 - 1;
        if (((hash(this.keysArray[r7]) - r10) & (getHashSize() - 1)) < r3) goto L22;
        this.hashArray[r0] = r6;
        this.presenceArray[r7] = r0;
        goto L18
    L13:
        r5[r0] = 0;
        return;
    L9:
        this.hashArray[r0] = 0;
        return;
    L6:
        r10 = r4;
        goto L7
    }

    private final boolean shouldCompact(int r4) {
        int r0 = getCapacity$kotlin_stdlib();
        int r1 = this.length;
        int r2 = r0 - r1;
        int r3 = r1 - size();
        if (r2 < r4) goto L5;
    L9:
        return false;
    L5:
        if ((r2 + r3) < r4) goto L9;
        if (r3 < (getCapacity$kotlin_stdlib() / 4)) goto L9;
        return true;
    }

    public final int addKey$kotlin_stdlib(K r8) {
        checkIsMutable$kotlin_stdlib();
    L3:
        int r0 = hash(r8);
        int r1 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r2 = 0;
    L4:
        int r3 = this.hashArray[r0];
        if (r3 <= 0) goto L7;
        if (Intrinsics.areEqual(this.keysArray[r3 - 1], r8) == true) goto L16;
        r2 = r2 + 1;
        if (r2 > r1) goto L19;
        int r4 = r0 - 1;
        if (r0 == 0) goto L22;
        r0 = r4;
        goto L4
    L22:
        r0 = getHashSize() - 1;
        goto L4
    L19:
        rehash(getHashSize() * 2);
        goto L3
    L16:
        return -r3;
    L7:
        if (this.length < getCapacity$kotlin_stdlib()) goto L9;
        ensureExtraCapacity(1);
        goto L3
    L9:
        int r5 = this.length;
        int r6 = r5 + 1;
        this.length = r6;
        this.keysArray[r5] = r8;
        this.presenceArray[r5] = r0;
        this.hashArray[r0] = r6;
        this.size = size() + 1;
        registerModification();
        if (r2 <= this.maxProbeDistance) goto L12;
        this.maxProbeDistance = r2;
    L12:
        return r5;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "m");
        Iterator<?> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r0 = r4.next();
        if (r0 == null) goto L9;
        if (containsEntry$kotlin_stdlib((Map.Entry) r0) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        int r0 = findKey(r3.getKey());
        if (r0 >= 0) goto L6;
        return false;
    L6:
        V[] r1 = this.valuesArray;
        Intrinsics.checkNotNull(r1);
        return Intrinsics.areEqual(r1[r0], r3.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        if (findKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        if (findValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof Map) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((Map) r2) == false) goto L8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r2) {
        int r3 = findKey(r2);
        if (r3 >= 0) goto L6;
        return null;
    L6:
        V[] r0 = this.valuesArray;
        Intrinsics.checkNotNull(r0);
        return r0[r3];
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(r2.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object r2) {
        checkIsMutable$kotlin_stdlib();
        int r3 = findKey(r2);
        if (r3 >= 0) goto L6;
        return null;
    L6:
        V[] r0 = this.valuesArray;
        Intrinsics.checkNotNull(r0);
        V r1 = r0[r3];
        removeEntryAt(r3);
        return r1;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r4) {
        Intrinsics.checkNotNullParameter(r4, "entry");
        checkIsMutable$kotlin_stdlib();
        int r0 = findKey(r4.getKey());
        if (r0 >= 0) goto L5;
        return false;
    L5:
        V[] r2 = this.valuesArray;
        Intrinsics.checkNotNull(r2);
        if (Intrinsics.areEqual(r2[r0], r4.getValue()) == true) goto L8;
        return false;
    L8:
        removeEntryAt(r0);
        return true;
    }

    public final boolean removeKey$kotlin_stdlib(K r1) {
        checkIsMutable$kotlin_stdlib();
        int r2 = findKey(r1);
        if (r2 >= 0) goto L6;
        return false;
    L6:
        removeEntryAt(r2);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V r1) {
        checkIsMutable$kotlin_stdlib();
        int r2 = findValue(r1);
        if (r2 >= 0) goto L6;
        return false;
    L6:
        removeEntryAt(r2);
        return true;
    }

    public static final /* synthetic */ void access$removeEntryAt(MapBuilder r0, int r1) {
        r0.removeEntryAt(r1);
    }

    @Override // java.util.Map
    public V put(K r3, V r4) {
        checkIsMutable$kotlin_stdlib();
        int r5 = addKey$kotlin_stdlib(r3);
        V[] r0 = allocateValuesArray();
        if (r5 >= 0) goto L6;
        int r6 = (-r5) - 1;
        V r1 = r0[r6];
        r0[r6] = r4;
        return r1;
    L6:
        r0[r5] = r4;
        return null;
    }

    private MapBuilder(K[] r1, V[] r2, int[] r3, int[] r4, int r5, int r6) {
        this.keysArray = r1;
        this.valuesArray = r2;
        this.presenceArray = r3;
        this.hashArray = r4;
        this.maxProbeDistance = r5;
        this.length = r6;
        this.hashShift = Companion.access$computeShift(Companion, getHashSize());
    }
}
