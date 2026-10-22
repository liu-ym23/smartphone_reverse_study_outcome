package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0016J\"\u0010\n\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010\u000f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002J\"\u0010\u0010\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u001b\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0013H\u0096\u0002J\u001c\u0010\u0014\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0016J\"\u0010\u0015\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016J\"\u0010\u0016\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$entries$1", "", "", "size", "", "getSize", "()I", "add", "", "element", "addAll", "elements", "", "clear", "", "contains", "containsAll", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableScatterMap$MutableMapWrapper$entries$1<K, V> implements Set<Map.Entry<K, V>>, KMutableSet {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap<K, V> r1) {
        this.this$0 = r1;
    }

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean add(Object r3) {
        return add((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
    }

    public boolean add(Map.Entry<K, V> r2) {
        Intrinsics.checkNotNullParameter((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin"), "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> r2) {
        Intrinsics.checkNotNullParameter((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.this$0.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object r3) {
        if (TypeIntrinsics.isMutableMapEntry(r3) == true) goto L7;
        return false;
    L7:
        return contains((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
    }

    public boolean contains(Map.Entry<K, V> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "element");
        return Intrinsics.areEqual(this.this$0.get((K) r4.getKey()), r4.getValue());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "elements");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        MutableScatterMap<K, V> r4 = this.this$0;
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L15;
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.get((K) r0.getKey()), r0.getValue()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(this.this$0), Iterator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object r3) {
        if (TypeIntrinsics.isMutableMapEntry(r3) == true) goto L7;
        return false;
    L7:
        return remove((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
    }

    public boolean remove(Map.Entry<K, V> r19) {
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r19, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "element");
        ScatterMap r2 = (ScatterMap) ZeusTransformUtils.preCheckCast(this.this$0, ScatterMap.class, "com.obric.memorydata.plugin");
        Object r3 = r1.getKey();
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = r5 * ScatterMapKt.MurmurHashC1;
        int r7 = r6 ^ (r6 << 16);
        int r8 = r7 & 127;
        int r9 = r2._capacity;
        int r10 = (r7 >>> 7) & r9;
        int r11 = 0;
    L7:
        long[] r12 = r2.metadata;
        int r13 = r10 >> 3;
        int r14 = (r10 & 7) << 3;
        long r15 = ((r12[r13 + 1] << (64 - r14)) & ((-r14) >> 63)) | (r12[r13] >>> r14);
        long r16 = (((long) r8) * ScatterMapKt.BitmaskLsb) ^ r15;
        long r17 = ((~r16) & (r16 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r17 == 0) goto L11;
        boolean r18 = true;
    L12:
        if (r18 == false) goto L18;
        int r110 = ((Long.numberOfTrailingZeros(r17) >> 3) + r10) & r9;
        if (Intrinsics.areEqual(r2.keys[r110], r3) == true) goto L20;
        r17 = r17 & (r17 - 1);
    L20:
        if (r110 >= 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.this$0.values[r110], r1.getValue()) == false) goto L31;
        this.this$0.removeValueAt(r110);
        return true;
    L31:
        return false;
    L18:
        if (((r15 & ((~r15) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r11 = r11 + 8;
        r10 = (r10 + r11) & r9;
        goto L7
    L19:
        r110 = -1;
        goto L20
    L11:
        r18 = false;
        goto L12
    L5:
        r5 = 0;
        goto L6
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r18) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r18, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "elements");
        ScatterMap r3 = (ScatterMap) ZeusTransformUtils.preCheckCast(this.this$0, ScatterMap.class, "com.obric.memorydata.plugin");
        MutableScatterMap<K, V> r0 = this.this$0;
        long[] r4 = r3.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L31;
        int r6 = 0;
        boolean r7 = false;
    L5:
        long r8 = r4[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r11 = 8;
        int r10 = 8 - ((~(r6 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L27;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L24;
        int r14 = (r6 << 3) + r12;
        Iterator r15 = r1.iterator();
    L16:
        if (r15.hasNext() == false) goto L23;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r9.getKey(), r0.keys[r14]) == false) goto L16;
        if (Intrinsics.areEqual(r9.getValue(), r0.values[r14]) == false) goto L16;
        r0.removeValueAt(r14);
        r7 = true;
    L23:
        int r16 = 8;
    L25:
        r8 = r8 >> r16;
        r12 = r12 + 1;
        r11 = r16;
        goto L8
    L24:
        r16 = r11;
        goto L25
    L12:
        r13 = false;
        goto L13
    L27:
        if (r10 == r11) goto L28;
        return r7;
    L28:
        if (r6 == r5) goto L30;
        r6 = r6 + 1;
        goto L5
    L30:
        boolean r17 = r7;
    L33:
        return r17;
    L31:
        r17 = false;
        goto L33
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> r18) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r18, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "elements");
        ScatterMap r3 = (ScatterMap) ZeusTransformUtils.preCheckCast(this.this$0, ScatterMap.class, "com.obric.memorydata.plugin");
        MutableScatterMap<K, V> r0 = this.this$0;
        long[] r4 = r3.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L34;
        int r6 = 0;
        boolean r7 = false;
    L5:
        long r8 = r4[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L31;
        int r11 = 8;
        int r10 = 8 - ((~(r6 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L30;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L27;
        int r14 = (r6 << 3) + r12;
        Iterator r15 = r1.iterator();
    L16:
        if (r15.hasNext() == false) goto L23;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r9.getKey(), r0.keys[r14]) == false) goto L16;
        if (Intrinsics.areEqual(r9.getValue(), r0.values[r14]) == false) goto L16;
        boolean r16 = true;
    L24:
        if (r16 == true) goto L26;
        r0.removeValueAt(r14);
        r7 = true;
    L26:
        int r17 = 8;
    L28:
        r8 = r8 >> r17;
        r12 = r12 + 1;
        r11 = r17;
        goto L8
    L23:
        r16 = false;
        goto L24
    L27:
        r17 = r11;
        goto L28
    L12:
        r13 = false;
        goto L13
    L30:
        if (r10 == r11) goto L31;
        return r7;
    L31:
        if (r6 == r5) goto L33;
        r6 = r6 + 1;
        goto L5
    L33:
        boolean r19 = r7;
    L36:
        return r19;
    L34:
        r19 = false;
        goto L36
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r3) {
        Intrinsics.checkNotNullParameter(r3, "array");
        return (T[]) CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"), r3);
    }
}
