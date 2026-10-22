package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001<B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J:\u0010\u0013\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u001a\u001a\u00020\u0014J:\u0010\u001a\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0016\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0007J:\u0010\u001f\u001a\u00020\u00052!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\u00028\u0000H\u0086\b¢\u0006\u0002\u0010&J?\u0010%\u001a\u00028\u00002!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010'JA\u0010(\u001a\u0004\u0018\u00018\u00002!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010'J:\u0010)\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020*0\u0016H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010,\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020*0\u0016H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010.\u001a\u00020\u0005H\u0016J\u0006\u0010/\u001a\u00020\u0014J\u0006\u00100\u001a\u00020\u0014JR\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u0002042\b\b\u0002\u00107\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u0002042\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000204\u0018\u00010\u0016H\u0007J\u0006\u0010:\u001a\u00020\u0014J\b\u0010;\u001a\u000202H\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\f\u0010\u0003R\u0018\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003R\u0011\u0010\u0011\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\t\u0082\u0001\u0001=\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006>"}, d2 = {"Landroidx/collection/ScatterSet;", ExifInterface.LONGITUDE_EAST, "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "element", "any", "asSet", "", "contains", "(Ljava/lang/Object;)Z", CommonConsts.COUNT_TYPE, "equals", "other", "findElementIndex", "findElementIndex$collection", "(Ljava/lang/Object;)I", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "forEach", "", "block", "forEachIndex", "index", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "SetWrapper", "Landroidx/collection/MutableScatterSet;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ScatterSet<E> {
    public int _capacity;
    public int _size;
    public Object[] elements;
    public long[] metadata;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0090\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/collection/ScatterSet$SetWrapper;", "", "(Landroidx/collection/ScatterSet;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "isEmpty", "iterator", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public class SetWrapper implements Set<E>, KMappedMarker {
        final /* synthetic */ ScatterSet<E> this$0;

        public SetWrapper(ScatterSet r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(E r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.contains(r1);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<? extends Object> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
            ScatterSet<E> r2 = this.this$0;
            Iterator r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L9;
            if (r2.contains((E) r6.next()) == true) goto L4;
            return false;
        L9:
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
        public Iterator<E> iterator() {
            return SequencesKt.iterator((Function2) ZeusTransformUtils.preCheckCast(new ScatterSet$SetWrapper$iterator$1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<? extends Object> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<? extends Object> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    private ScatterSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public /* synthetic */ ScatterSet(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ScatterSet r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, Function1 r14, int r15, Object r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Function1<? super E, ? extends CharSequence> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L26;
        if ((r15 & 1) == 0) goto L8;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
    L8:
        if ((r15 & 2) == 0) goto L11;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L11:
        if ((r15 & 4) == 0) goto L14;
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L14:
        if ((r15 & 8) == 0) goto L16;
        int r6 = -1;
    L18:
        if ((r15 & 16) == 0) goto L21;
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
    L21:
        if ((r15 & 32) == 0) goto L24;
        r5 = null;
    L24:
        return r8.joinToString(r0, r2, r3, r6, r4, r5);
    L16:
        r6 = r12;
        goto L18
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(Function1<? super E, Boolean> r18) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.elements;
        long[] r0 = this.metadata;
        int r4 = r0.length - 2;
        if (r4 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r0[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[(r7 << 3) + r12]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        return false;
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 != 8) goto L21;
    L19:
        if (r7 == r4) goto L21;
        r7 = r7 + 1;
    L21:
        return true;
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean any(Function1<? super E, Boolean> r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "predicate");
        Object[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L21;
        int r4 = 0;
    L5:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L18;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.invoke(r0[(r4 << 3) + r9]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return true;
    L17:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L18:
        if (r7 != 8) goto L21;
    L19:
        if (r4 == r2) goto L21;
        r4 = r4 + 1;
    L21:
        return false;
    }

    public final Set<E> asSet() {
        return (Set) ZeusTransformUtils.preCheckCast(new SetWrapper(this), Set.class, "com.obric.memorydata.plugin");
    }

    public final boolean contains(E r18) {
        if (r18 == null) goto L5;
        int r3 = r18.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 & 127;
        int r7 = this._capacity;
        int r8 = (r5 >>> 7) & r7;
        int r9 = 0;
    L7:
        long[] r10 = this.metadata;
        int r11 = r8 >> 3;
        int r12 = (r8 & 7) << 3;
        long r13 = ((r10[r11 + 1] << (64 - r12)) & ((-r12) >> 63)) | (r10[r11] >>> r12);
        long r14 = (((long) r6) * ScatterMapKt.BitmaskLsb) ^ r13;
        long r15 = ((~r14) & (r14 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r15 == 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L18;
        int r17 = ((Long.numberOfTrailingZeros(r15) >> 3) + r8) & r7;
        if (Intrinsics.areEqual(this.elements[r17], r18) == true) goto L20;
        r15 = r15 & (r15 - 1);
    L20:
        if (r17 >= 0) goto L22;
        return false;
    L22:
        return true;
    L18:
        if (((r13 & ((~r13) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r9 = r9 + 8;
        r8 = (r8 + r9) & r7;
        goto L7
    L19:
        r17 = -1;
        goto L20
    L11:
        r16 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function1<? super E, Boolean> r18) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.elements;
        long[] r0 = this.metadata;
        int r4 = r0.length - 2;
        int r5 = 0;
        if (r4 < 0) goto L23;
        int r6 = 0;
        int r7 = 0;
    L5:
        long r8 = r0[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r6 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[(r6 << 3) + r12]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        r7 = r7 + 1;
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 == 8) goto L19;
        return r7;
    L19:
        if (r6 == r4) goto L21;
        r6 = r6 + 1;
        goto L5
    L21:
        r5 = r7;
    L23:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r15) {
        if (r15 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r15, ScatterSet.class) == true) goto L9;
        return false;
    L9:
        if (((ScatterSet) ZeusTransformUtils.preCheckCast(r15, ScatterSet.class, "com.obric.memorydata.plugin")).getSize() == getSize()) goto L11;
        return false;
    L11:
        ScatterSet r16 = (ScatterSet) ZeusTransformUtils.preCheckCast(r15, ScatterSet.class, "com.obric.memorydata.plugin");
        Object[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L30;
        int r4 = 0;
    L14:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L17:
        if (r9 >= r7) goto L27;
        if ((255 & r5) >= 128) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L26;
        if (r16.contains(r0[(r4 << 3) + r9]) == true) goto L26;
        return false;
    L26:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L17
    L21:
        r10 = false;
        goto L22
    L27:
        if (r7 != 8) goto L30;
    L28:
        if (r4 == r2) goto L30;
        r4 = r4 + 1;
    L30:
        return true;
    }

    public final int findElementIndex$collection(E r18) {
        if (r18 == null) goto L5;
        int r3 = r18.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 & 127;
        int r7 = this._capacity;
        int r8 = (r5 >>> 7) & r7;
        int r9 = 0;
    L7:
        long[] r10 = this.metadata;
        int r11 = r8 >> 3;
        int r12 = (r8 & 7) << 3;
        long r13 = ((r10[r11 + 1] << (64 - r12)) & ((-r12) >> 63)) | (r10[r11] >>> r12);
        long r14 = (((long) r6) * ScatterMapKt.BitmaskLsb) ^ r13;
        long r15 = ((~r14) & (r14 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r15 == 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L18;
        int r17 = ((Long.numberOfTrailingZeros(r15) >> 3) + r8) & r7;
        if (Intrinsics.areEqual(this.elements[r17], r18) == true) goto L15;
        r15 = r15 & (r15 - 1);
        goto L9
    L15:
        return r17;
    L18:
        if (((r13 & ((~r13) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r9 = r9 + 8;
        r8 = (r8 + r9) & r7;
        goto L7
    L19:
        return -1;
    L11:
        r16 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public final E first() {
        Object[] r0 = this.elements;
        long[] r13 = this.metadata;
        int r1 = r13.length - 2;
        if (r1 < 0) goto L21;
        int r3 = 0;
    L5:
        long r4 = r13[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L17;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L15;
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L15:
        return (E) r0[(r3 << 3) + r8];
    L12:
        r9 = false;
        goto L13
    L17:
        if (r6 != 8) goto L21;
    L18:
        if (r3 == r1) goto L21;
        r3 = r3 + 1;
    L21:
        throw new NoSuchElementException("The ScatterSet is empty");
    }

    public final E first(Function1<? super E, Boolean> r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "predicate");
        Object[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L22;
        int r4 = 0;
    L5:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L18;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        E r11 = (E) r0[(r4 << 3) + r9];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.invoke(r11), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return r11;
    L17:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L18:
        if (r7 != 8) goto L22;
    L19:
        if (r4 == r2) goto L22;
        r4 = r4 + 1;
    L22:
        throw new NoSuchElementException("Could not find a match");
    }

    public final E firstOrNull(Function1<? super E, Boolean> r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "predicate");
        Object[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L21;
        int r4 = 0;
    L5:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L18;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        E r11 = (E) r0[(r4 << 3) + r9];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.invoke(r11), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return r11;
    L17:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L18:
        if (r7 == 8) goto L19;
        return null;
    L19:
        if (r4 == r2) goto L30;
        r4 = r4 + 1;
        goto L5
    L30:
        return null;
    L21:
        return null;
    }

    public final void forEach(Function1<? super E, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "block");
        Object[] r0 = this.elements;
        long[] r13 = this.metadata;
        int r1 = r13.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r13[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        r15.invoke(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndex(Function1<? super Integer, Unit> r13) {
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "block");
        long[] r12 = this.metadata;
        int r0 = r12.length - 2;
        if (r0 < 0) goto L20;
        int r2 = 0;
    L5:
        long r3 = r12[r2];
        if (((((~r3) << 7) & r3) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r5 = 8 - ((~(r2 - r0)) >>> 31);
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L16;
        if ((255 & r3) >= 128) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        r14.invoke(Integer.valueOf((r2 << 3) + r7));
    L15:
        r3 = r3 >> 8;
        r7 = r7 + 1;
        goto L8
    L12:
        r8 = false;
        goto L13
    L16:
        if (r5 == 8) goto L18;
        return;
    L18:
        if (r2 == r0) goto L26;
        r2 = r2 + 1;
        goto L5
    L26:
        return;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r1 = r14.length - 2;
        int r2 = 0;
        if (r1 < 0) goto L25;
        int r3 = 0;
        int r4 = 0;
    L5:
        long r5 = r14[r3];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r7 = 8 - ((~(r3 - r1)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L20;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L19;
        Object r11 = r0[(r3 << 3) + r9];
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        r4 = r4 + r12;
        goto L19
    L17:
        r12 = 0;
    L19:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L20:
        if (r7 == 8) goto L21;
        return r4;
    L21:
        if (r3 == r1) goto L23;
        r3 = r3 + 1;
        goto L5
    L23:
        r2 = r4;
    L25:
        return r2;
    }

    public final boolean isEmpty() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final String joinToString(CharSequence r10) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        return joinToString$default(this, r1, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        return joinToString$default(this, r3, r4, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13, CharSequence r14) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        return joinToString$default(this, r3, r4, r5, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13, CharSequence r14, int r15) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        return joinToString$default(this, r3, r4, r5, r15, null, null, 48, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        Intrinsics.checkNotNullParameter(r7, "truncated");
        return joinToString$default(this, r3, r4, r5, r15, r7, null, 32, null);
    }

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, int r24, CharSequence r25, Function1<? super E, ? extends CharSequence> r26) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "truncated");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        Object[] r8 = this.elements;
        long[] r0 = this.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L31;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r14) goto L25;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L23;
        Object r17 = r8[(r10 << 3) + r13];
        if (r11 == r24) goto L16;
        if (r11 == 0) goto L19;
        r7.append(r1);
    L19:
        if (r6 != null) goto L21;
        r7.append(r17);
    L22:
        r11 = r11 + 1;
        int r2 = 8;
    L24:
        r12 = r12 >> r2;
        r13 = r13 + 1;
        r15 = r2;
        r0 = r0;
        goto L8
    L21:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r6.invoke(r17), CharSequence.class, "com.obric.memorydata.plugin"));
        goto L22
    L16:
        r7.append(r5);
    L32:
        String r18 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L23:
        r2 = r15;
        goto L24
    L12:
        r16 = false;
        goto L13
    L25:
        long[] r19 = r0;
        if (r14 != r15) goto L31;
    L29:
        if (r10 == r9) goto L31;
        r10 = r10 + 1;
        r0 = r19;
        goto L5
    L28:
        r19 = r0;
    L31:
        r7.append(r4);
        goto L32
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function1.class, "com.obric.memorydata.plugin"), 25, null);
    }
}
