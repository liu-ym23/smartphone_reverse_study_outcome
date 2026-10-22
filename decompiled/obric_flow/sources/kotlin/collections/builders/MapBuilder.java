package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u0080\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBE\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u0017\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00108J\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:J\r\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020<H\u0016J\b\u0010?\u001a\u00020<H\u0002J\u0019\u0010@\u001a\u00020!2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0000¢\u0006\u0002\bCJ!\u0010D\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010IJ\u0015\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010IJ\u0018\u0010L\u001a\u00020!2\u000e\u0010M\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:H\u0002J\u0010\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020<2\u0006\u0010Q\u001a\u00020\bH\u0002J\u0019\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0000¢\u0006\u0002\bTJ\u0013\u0010U\u001a\u00020!2\b\u0010M\u001a\u0004\u0018\u00010VH\u0096\u0002J\u0015\u0010W\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u0015\u0010X\u001a\u00020\b2\u0006\u0010K\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00106J\u0018\u0010Y\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010ZJ\u0015\u0010[\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020!H\u0016J\u0019\u0010^\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010_H\u0000¢\u0006\u0002\b`J\u001f\u0010a\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u00002\u0006\u0010K\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010bJ\u001e\u0010c\u001a\u00020<2\u0014\u0010d\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:H\u0016J\"\u0010e\u001a\u00020!2\u0018\u0010d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F0BH\u0002J\u001c\u0010f\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0002J\u0010\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020\bH\u0002J\b\u0010i\u001a\u00020<H\u0002J\u0010\u0010j\u001a\u00020<2\u0006\u0010k\u001a\u00020\bH\u0002J\u0017\u0010l\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010ZJ!\u0010m\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020<2\u0006\u0010p\u001a\u00020\bH\u0002J\u0010\u0010q\u001a\u00020<2\u0006\u0010r\u001a\u00020\bH\u0002J\u0017\u0010s\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\bt\u0010IJ\u0017\u0010u\u001a\u00020!2\u0006\u0010v\u001a\u00028\u0001H\u0000¢\u0006\u0004\bw\u0010IJ\u0010\u0010x\u001a\u00020!2\u0006\u0010y\u001a\u00020\bH\u0002J\b\u0010z\u001a\u00020{H\u0016J\u0019\u0010|\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010}H\u0000¢\u0006\u0002\b~J\b\u0010\u007f\u001a\u00020VH\u0002R\u0014\u0010\u0013\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0015R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00101\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity$kotlin_stdlib", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "modCount", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", STGroup.DICT_KEY, "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "registerModification", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeEntryAt", "index", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeValue", "element", "removeValue$kotlin_stdlib", "shouldCompact", "extraCapacity", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,728:1\n1#2:729\n*E\n"})
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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ int access$computeHashSize(Companion r5, int r10) {
            return r5.computeHashSize(r10);
        }

        public static final /* synthetic */ int access$computeShift(Companion r5, int r10) {
            return r5.computeShift(r10);
        }

        private final int computeHashSize(int r5) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(r5, 1) * 3);
        }

        private final int computeShift(int r5) {
            return Integer.numberOfLeadingZeros(r5) + 1;
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.access$getEmpty$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        public EntriesItr(MapBuilder<K, V> r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            super(r5);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public final void nextAppendString(StringBuilder r5) {
            Intrinsics.checkNotNullParameter(r5, "sb");
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L15;
            int r10 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r10 + 1);
            setLastIndex$kotlin_stdlib(r10);
            Object r11 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            if (r11 != getMap$kotlin_stdlib()) goto L7;
            r5.append("(this Map)");
        L8:
            r5.append('=');
            Object[] r12 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r12);
            Object r13 = r12[getLastIndex$kotlin_stdlib()];
            if (r13 != getMap$kotlin_stdlib()) goto L11;
            r5.append("(this Map)");
        L12:
            initNext$kotlin_stdlib();
            return;
        L11:
            r5.append(r13);
            goto L12
        L7:
            r5.append(r11);
            goto L8
        L15:
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L14;
            int r5 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r5 + 1);
            setLastIndex$kotlin_stdlib(r5);
            Object r10 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            int r11 = 0;
            if (r10 == null) goto L7;
            int r12 = r10.hashCode();
        L8:
            Object[] r13 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r13);
            Object r14 = r13[getLastIndex$kotlin_stdlib()];
            if (r14 == null) goto L11;
            r11 = r14.hashCode();
        L11:
            int r15 = r12 ^ r11;
            initNext$kotlin_stdlib();
            return r15;
        L7:
            r12 = 0;
            goto L8
        L14:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public EntryRef<K, V> next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r5 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r5 + 1);
            setLastIndex$kotlin_stdlib(r5);
            EntryRef<K, V> r10 = new EntryRef(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return r10;
        L7:
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", STGroup.DICT_KEY, "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        private final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "map");
            this.map = r5;
            this.index = r10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if ((r5 instanceof Map.Entry) == false) goto L9;
            Map.Entry r10 = (Map.Entry) r5;
            if (Intrinsics.areEqual(r10.getKey(), getKey()) == false) goto L9;
            if (Intrinsics.areEqual(r10.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) MapBuilder.access$getKeysArray$p(this.map)[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] r5 = MapBuilder.access$getValuesArray$p(this.map);
            Intrinsics.checkNotNull(r5);
            return (V) r5[this.index];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r5 = getKey();
            int r10 = 0;
            if (r5 == null) goto L5;
            int r11 = r5.hashCode();
        L6:
            V r12 = getValue();
            if (r12 == null) goto L10;
            r10 = r12.hashCode();
        L10:
            return r11 ^ r10;
        L5:
            r11 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r5) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] r10 = MapBuilder.access$allocateValuesArray(this.map);
            int r11 = this.index;
            V r12 = (V) r10[r11];
            r10[r11] = r5;
            return r12;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder();
            r5.append(getKey());
            r5.append('=');
            r5.append(getValue());
            return r5.toString();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0019J\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "expectedModCount", "", "index", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "checkForComodification", "", "checkForComodification$kotlin_stdlib", "hasNext", "", "initNext", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,728:1\n1#2:729\n*E\n"})
    public static class Itr<K, V> {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            this.map = r5;
            this.lastIndex = -1;
            this.expectedModCount = MapBuilder.access$getModCount$p(r5);
            initNext$kotlin_stdlib();
        }

        public final void checkForComodification$kotlin_stdlib() {
            if (MapBuilder.access$getModCount$p(this.map) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
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

        public final boolean hasNext() {
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void initNext$kotlin_stdlib() {
        L3:
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L7;
            int[] r5 = MapBuilder.access$getPresenceArray$p(this.map);
            int r10 = this.index;
            if (r5[r10] >= 0) goto L10;
            this.index = r10 + 1;
            goto L3
        L10:
            return;
        }

        public final void remove() {
            checkForComodification$kotlin_stdlib();
            if (this.lastIndex == (-1)) goto L7;
            this.map.checkIsMutable$kotlin_stdlib();
            MapBuilder.access$removeEntryAt(this.map, this.lastIndex);
            this.lastIndex = -1;
            this.expectedModCount = MapBuilder.access$getModCount$p(this.map);
            return;
        L7:
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }

        public final void setIndex$kotlin_stdlib(int r5) {
            this.index = r5;
        }

        public final void setLastIndex$kotlin_stdlib(int r5) {
            this.lastIndex = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        public KeysItr(MapBuilder<K, V> r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            super(r5);
        }

        @Override // java.util.Iterator
        public K next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r5 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r5 + 1);
            setLastIndex$kotlin_stdlib(r5);
            K r10 = (K) MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return r10;
        L7:
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        public ValuesItr(MapBuilder<K, V> r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            super(r5);
        }

        @Override // java.util.Iterator
        public V next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r5 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r5 + 1);
            setLastIndex$kotlin_stdlib(r5);
            Object[] r10 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r10);
            V r11 = (V) r10[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return r11;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new Companion(null);
        MapBuilder r5 = new MapBuilder(0);
        r5.isReadOnly = true;
        Empty = r5;
    }

    private MapBuilder(K[] r5, V[] r10, int[] r11, int[] r12, int r13, int r14) {
        this.keysArray = r5;
        this.valuesArray = r10;
        this.presenceArray = r11;
        this.hashArray = r12;
        this.maxProbeDistance = r13;
        this.length = r14;
        this.hashShift = Companion.access$computeShift(Companion, getHashSize());
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(MapBuilder r5) {
        return r5.allocateValuesArray();
    }

    public static final /* synthetic */ MapBuilder access$getEmpty$cp() {
        return Empty;
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(MapBuilder r5) {
        return r5.keysArray;
    }

    public static final /* synthetic */ int access$getLength$p(MapBuilder r5) {
        return r5.length;
    }

    public static final /* synthetic */ int access$getModCount$p(MapBuilder r5) {
        return r5.modCount;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(MapBuilder r5) {
        return r5.presenceArray;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(MapBuilder r5) {
        return r5.valuesArray;
    }

    public static final /* synthetic */ void access$removeEntryAt(MapBuilder r5, int r10) {
        r5.removeEntryAt(r10);
    }

    private final V[] allocateValuesArray() {
        V[] r5 = this.valuesArray;
        if (r5 == null) goto L5;
        return r5;
    L5:
        V[] r10 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = r10;
        return r10;
    }

    private final void compact() {
        V[] r5 = this.valuesArray;
        int r10 = 0;
        int r11 = 0;
    L3:
        int r12 = this.length;
        if (r10 >= r12) goto L12;
        if (this.presenceArray[r10] < 0) goto L11;
        K[] r13 = this.keysArray;
        r13[r11] = r13[r10];
        if (r5 == null) goto L10;
        r5[r11] = r5[r10];
    L10:
        r11 = r11 + 1;
    L11:
        r10 = r10 + 1;
        goto L3
    L12:
        ListBuilderKt.resetRange(this.keysArray, r11, r12);
        if (r5 == null) goto L15;
        ListBuilderKt.resetRange(r5, r11, this.length);
    L15:
        this.length = r11;
    }

    private final boolean contentEquals(Map<?, ?> r5) {
        if (size() == r5.size()) goto L5;
    L7:
        return false;
    L5:
        if (containsAllEntries$kotlin_stdlib(r5.entrySet()) == false) goto L7;
        return true;
    }

    private final void ensureCapacity(int r5) {
        if (r5 < 0) goto L14;
        if (r5 <= getCapacity$kotlin_stdlib()) goto L15;
        int r10 = AbstractList.Companion.newCapacity$kotlin_stdlib(getCapacity$kotlin_stdlib(), r5);
        this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, r10);
        V[] r11 = this.valuesArray;
        if (r11 == null) goto L8;
        V[] r12 = (V[]) ListBuilderKt.copyOfUninitializedElements(r11, r10);
    L9:
        this.valuesArray = r12;
        this.presenceArray = Arrays.copyOf(this.presenceArray, r10);
        int r13 = Companion.access$computeHashSize(Companion, r10);
        if (r13 <= getHashSize()) goto L16;
        rehash(r13);
        return;
    L16:
        return;
    L8:
        r12 = null;
        goto L9
    L15:
        return;
    L14:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r5) {
        if (shouldCompact(r5) == false) goto L5;
        rehash(getHashSize());
        return;
    L5:
        ensureCapacity(this.length + r5);
    }

    private final int findKey(K r10) {
        int r5 = hash(r10);
        int r11 = this.maxProbeDistance;
    L3:
        int r12 = this.hashArray[r5];
        if (r12 == 0) goto L5;
        if (r12 <= 0) goto L10;
        int r13 = r12 - 1;
        if (Intrinsics.areEqual(this.keysArray[r13], r10) == false) goto L10;
        return r13;
    L10:
        r11 = r11 - 1;
        if (r11 < 0) goto L12;
        int r14 = r5 - 1;
        if (r5 == 0) goto L15;
        r5 = r14;
        goto L3
    L15:
        r5 = getHashSize() - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    private final int findValue(V r5) {
        int r10 = this.length;
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L10;
        if (this.presenceArray[r10] < 0) goto L3;
        V[] r11 = this.valuesArray;
        Intrinsics.checkNotNull(r11);
        if (Intrinsics.areEqual(r11[r10], r5) == false) goto L3;
        return r10;
    L10:
        return -1;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K r5) {
        if (r5 == null) goto L4;
        int r10 = r5.hashCode();
    L6:
        return (r10 * MAGIC) >>> this.hashShift;
    L4:
        r10 = 0;
        goto L6
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> r5) {
        boolean r10 = false;
        if (r5.isEmpty() == false) goto L5;
        return false;
    L5:
        ensureExtraCapacity(r5.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        if (putEntry(r11.next()) == false) goto L7;
        r10 = true;
        goto L7
    L11:
        return r10;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> r5) {
        int r10 = addKey$kotlin_stdlib(r5.getKey());
        V[] r11 = allocateValuesArray();
        if (r10 < 0) goto L6;
        r11[r10] = r5.getValue();
        return true;
    L6:
        int r12 = (-r10) - 1;
        V r13 = r11[r12];
        if (Intrinsics.areEqual(r5.getValue(), r13) == true) goto L10;
        r11[r12] = r5.getValue();
        return true;
    L10:
        return false;
    }

    private final boolean putRehash(int r10) {
        int r5 = hash(this.keysArray[r10]);
        int r11 = this.maxProbeDistance;
    L3:
        int[] r12 = this.hashArray;
        if (r12[r5] == 0) goto L5;
        r11 = r11 - 1;
        if (r11 < 0) goto L9;
        int r13 = r5 - 1;
        if (r5 == 0) goto L13;
        r5 = r13;
        goto L3
    L13:
        r5 = getHashSize() - 1;
        goto L3
    L9:
        return false;
    L5:
        r12[r5] = r10 + 1;
        this.presenceArray[r10] = r5;
        return true;
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void rehash(int r5) {
        registerModification();
        if (this.length <= size()) goto L5;
        compact();
    L5:
        int r10 = 0;
        if (r5 == getHashSize()) goto L8;
        this.hashArray = new int[r5];
        this.hashShift = Companion.access$computeShift(Companion, r5);
    L10:
        if (r10 >= this.length) goto L16;
        int r11 = r10 + 1;
        if (putRehash(r10) == false) goto L15;
        r10 = r11;
        goto L10
    L15:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L16:
        return;
    L8:
        ArraysKt.fill(this.hashArray, 0, 0, getHashSize());
        goto L10
    }

    private final void removeEntryAt(int r5) {
        ListBuilderKt.resetAt(this.keysArray, r5);
        V[] r10 = this.valuesArray;
        if (r10 == null) goto L5;
        ListBuilderKt.resetAt(r10, r5);
    L5:
        removeHashAt(this.presenceArray[r5]);
        this.presenceArray[r5] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final void removeHashAt(int r10) {
        int r5 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r11 = 0;
        int r12 = r10;
    L3:
        int r13 = r10 - 1;
        if (r10 != 0) goto L6;
        r10 = getHashSize() - 1;
    L7:
        r11 = r11 + 1;
        if (r11 > this.maxProbeDistance) goto L9;
        int[] r14 = this.hashArray;
        int r15 = r14[r10];
        if (r15 == 0) goto L13;
        if (r15 >= 0) goto L19;
        r14[r12] = -1;
    L18:
        r12 = r10;
        r11 = 0;
    L22:
        r5 = r5 - 1;
        if (r5 >= 0) goto L3;
        this.hashArray[r12] = -1;
        return;
    L19:
        int r16 = r15 - 1;
        if (((hash(this.keysArray[r16]) - r10) & (getHashSize() - 1)) < r11) goto L22;
        this.hashArray[r12] = r15;
        this.presenceArray[r16] = r12;
        goto L18
    L13:
        r14[r12] = 0;
        return;
    L9:
        this.hashArray[r12] = 0;
        return;
    L6:
        r10 = r13;
        goto L7
    }

    private final boolean shouldCompact(int r5) {
        int r10 = getCapacity$kotlin_stdlib();
        int r11 = this.length;
        int r12 = r10 - r11;
        int r13 = r11 - size();
        if (r12 < r5) goto L5;
    L9:
        return false;
    L5:
        if ((r12 + r13) < r5) goto L9;
        if (r13 < (getCapacity$kotlin_stdlib() / 4)) goto L9;
        return true;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedMap(this);
    L7:
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K r10) {
        checkIsMutable$kotlin_stdlib();
    L3:
        int r5 = hash(r10);
        int r11 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r12 = 0;
    L4:
        int r13 = this.hashArray[r5];
        if (r13 <= 0) goto L7;
        if (Intrinsics.areEqual(this.keysArray[r13 - 1], r10) == true) goto L16;
        r12 = r12 + 1;
        if (r12 > r11) goto L19;
        int r14 = r5 - 1;
        if (r5 == 0) goto L22;
        r5 = r14;
        goto L4
    L22:
        r5 = getHashSize() - 1;
        goto L4
    L19:
        rehash(getHashSize() * 2);
        goto L3
    L16:
        return -r13;
    L7:
        if (this.length < getCapacity$kotlin_stdlib()) goto L9;
        ensureExtraCapacity(1);
        goto L3
    L9:
        int r15 = this.length;
        int r16 = r15 + 1;
        this.length = r16;
        this.keysArray[r15] = r10;
        this.presenceArray[r15] = r5;
        this.hashArray[r5] = r16;
        this.size = size() + 1;
        registerModification();
        if (r12 <= this.maxProbeDistance) goto L12;
        this.maxProbeDistance = r12;
    L12:
        return r15;
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) goto L7;
        MapBuilder r5 = Empty;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return r5;
    L7:
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int r5 = this.length - 1;
        if (r5 < 0) goto L10;
        int r10 = 0;
    L5:
        int[] r11 = this.presenceArray;
        int r12 = r11[r10];
        if (r12 < 0) goto L8;
        this.hashArray[r12] = 0;
        r11[r10] = -1;
    L8:
        if (r10 == r5) goto L10;
        r10 = r10 + 1;
    L10:
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] r13 = this.valuesArray;
        if (r13 == null) goto L13;
        ListBuilderKt.resetRange(r13, 0, this.length);
    L13:
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "m");
        Iterator<?> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();
        if (r11 == null) goto L9;
        if (containsEntry$kotlin_stdlib((Map.Entry) r11) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "entry");
        int r10 = findKey(r5.getKey());
        if (r10 >= 0) goto L6;
        return false;
    L6:
        V[] r11 = this.valuesArray;
        Intrinsics.checkNotNull(r11);
        return Intrinsics.areEqual(r11[r10], r5.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r5) {
        if (findKey(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object r5) {
        if (findValue(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r5 instanceof Map) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((Map) r5) == false) goto L8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r5) {
        int r10 = findKey(r5);
        if (r10 >= 0) goto L6;
        return null;
    L6:
        V[] r11 = this.valuesArray;
        Intrinsics.checkNotNull(r11);
        return r11[r10];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> r5 = this.entriesView;
        if (r5 != null) goto L6;
        MapBuilderEntries<K, V> r10 = new MapBuilderEntries(this);
        this.entriesView = r10;
        return r10;
    L6:
        return r5;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> r5 = this.keysView;
        if (r5 != null) goto L6;
        MapBuilderKeys<K> r10 = new MapBuilderKeys(this);
        this.keysView = r10;
        return r10;
    L6:
        return r5;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> r5 = this.valuesView;
        if (r5 != null) goto L6;
        MapBuilderValues<V> r10 = new MapBuilderValues(this);
        this.valuesView = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> r5 = entriesIterator$kotlin_stdlib();
        int r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r10 = r10 + r5.nextHashCode$kotlin_stdlib();
        goto L4
    L6:
        return r10;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr(this);
    }

    @Override // java.util.Map
    public V put(K r5, V r10) {
        checkIsMutable$kotlin_stdlib();
        int r11 = addKey$kotlin_stdlib(r5);
        V[] r12 = allocateValuesArray();
        if (r11 >= 0) goto L6;
        int r13 = (-r11) - 1;
        V r14 = r12[r13];
        r12[r13] = r10;
        return r14;
    L6:
        r12[r11] = r10;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(r5.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object r5) {
        checkIsMutable$kotlin_stdlib();
        int r10 = findKey(r5);
        if (r10 >= 0) goto L6;
        return null;
    L6:
        V[] r11 = this.valuesArray;
        Intrinsics.checkNotNull(r11);
        V r12 = r11[r10];
        removeEntryAt(r10);
        return r12;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "entry");
        checkIsMutable$kotlin_stdlib();
        int r10 = findKey(r5.getKey());
        if (r10 >= 0) goto L5;
        return false;
    L5:
        V[] r11 = this.valuesArray;
        Intrinsics.checkNotNull(r11);
        if (Intrinsics.areEqual(r11[r10], r5.getValue()) == true) goto L8;
        return false;
    L8:
        removeEntryAt(r10);
        return true;
    }

    public final boolean removeKey$kotlin_stdlib(K r5) {
        checkIsMutable$kotlin_stdlib();
        int r10 = findKey(r5);
        if (r10 >= 0) goto L6;
        return false;
    L6:
        removeEntryAt(r10);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V r5) {
        checkIsMutable$kotlin_stdlib();
        int r10 = findValue(r5);
        if (r10 >= 0) goto L6;
        return false;
    L6:
        removeEntryAt(r10);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder((size() * 3) + 2);
        r5.append("{");
        EntriesItr<K, V> r10 = entriesIterator$kotlin_stdlib();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r11 <= 0) goto L7;
        r5.append(", ");
    L7:
        r10.nextAppendString(r5);
        r11 = r11 + 1;
        goto L4
    L8:
        r5.append("}");
        return r5.toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int r10) {
        this(ListBuilderKt.arrayOfUninitializedElements(r10), null, new int[r10], new int[Companion.access$computeHashSize(Companion, r10)], 2, 0);
    }
}
