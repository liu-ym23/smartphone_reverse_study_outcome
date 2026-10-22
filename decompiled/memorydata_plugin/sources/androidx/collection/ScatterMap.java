package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001KB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J&\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\u0006\u0010\u001a\u001a\u00020\u0017J&\u0010\u001a\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fJ\u0016\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u0013\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00028\u0001¢\u0006\u0002\u0010\"J\u0006\u0010&\u001a\u00020\u0006J&\u0010&\u001a\u00020\u00062\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\u0013\u0010'\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010!\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b*\u0010+JD\u0010,\u001a\u00020-26\u0010.\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(!\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020-0\u0019H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020-2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020-02H\u0081\bø\u0001\u0000J/\u00104\u001a\u00020-2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020-02H\u0086\bø\u0001\u0000J/\u00105\u001a\u00020-2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020-02H\u0086\bø\u0001\u0000J\u0018\u00106\u001a\u0004\u0018\u00018\u00012\u0006\u0010!\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00107J\u001b\u00108\u001a\u00028\u00012\u0006\u0010!\u001a\u00028\u00002\u0006\u00109\u001a\u00028\u0001¢\u0006\u0002\u0010:J'\u0010;\u001a\u00028\u00012\u0006\u0010!\u001a\u00028\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00010<H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020\u0006H\u0016J\u0006\u0010?\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020\u0017Jv\u0010A\u001a\u00020\u001c2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020\u00062\b\b\u0002\u0010G\u001a\u00020C2:\b\u0002\u0010H\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(!\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020C\u0018\u00010\u0019H\u0007J\u0006\u0010I\u001a\u00020\u0017J\b\u0010J\u001a\u00020\u001cH\u0016R\u0012\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0004R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\u0015\u0010\u0004\u0082\u0001\u0001L\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006M"}, d2 = {"Landroidx/collection/ScatterMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "getValues$annotations", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "predicate", "Lkotlin/Function2;", "any", "asDebugString", "", "asDebugString$collection", "asMap", "", "contains", "key", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", EventBody.KEY_VALUE, CommonConsts.COUNT_TYPE, "equals", "other", "findKeyIndex", "findKeyIndex$collection", "(Ljava/lang/Object;)I", "forEach", "", "block", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "MapWrapper", "Landroidx/collection/MutableScatterMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ScatterMap<K, V> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public Object[] values;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0090\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0013H\u0016R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Landroidx/collection/ScatterMap$MapWrapper;", "", "(Landroidx/collection/ScatterMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", EventBody.KEY_VALUE, "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public class MapWrapper implements Map<K, V>, KMappedMarker {
        final /* synthetic */ ScatterMap<K, V> this$0;

        public MapWrapper(ScatterMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V compute(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V computeIfAbsent(K r1, Function<? super K, ? extends V> r2) {
            Function r0 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V computeIfPresent(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean containsKey(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.Map
        public boolean containsValue(Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        @Override // java.util.Map
        public V get(Object r1) {
            return this.this$0.get(r1);
        }

        public Set<Map.Entry<K, V>> getEntries() {
            return (Set) ZeusTransformUtils.preCheckCast(new ScatterMap$MapWrapper$entries$1(this.this$0), Set.class, "com.obric.memorydata.plugin");
        }

        public Set<K> getKeys() {
            return (Set) ZeusTransformUtils.preCheckCast(new ScatterMap$MapWrapper$keys$1(this.this$0), Set.class, "com.obric.memorydata.plugin");
        }

        public int getSize() {
            return this.this$0._size;
        }

        public Collection<V> getValues() {
            return (Collection) ZeusTransformUtils.preCheckCast(new ScatterMap$MapWrapper$values$1(this.this$0), Collection.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.Map
        public final Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.Map
        public V merge(K r1, V r2, BiFunction<? super V, ? super V, ? extends V> r3) {
            BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V put(K r1, V r2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V putIfAbsent(K r1, V r2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V remove(Object r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean remove(Object r1, Object r2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V replace(K r1, V r2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean replace(K r1, V r2, V r3) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r2) {
            BiFunction r1 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final Collection<V> values() {
            return getValues();
        }
    }

    private ScatterMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public /* synthetic */ ScatterMap(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ScatterMap r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, Function2 r14, int r15, Object r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Function2<? super K, ? super V, ? extends CharSequence> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r14, Function2.class, "com.obric.memorydata.plugin");
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

    public final boolean all(Function2<? super K, ? super V, Boolean> r19) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.keys;
        Object[] r4 = this.values;
        long[] r0 = this.metadata;
        int r5 = r0.length - 2;
        if (r5 < 0) goto L21;
        int r8 = 0;
    L5:
        long r9 = r0[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r8 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r8 << 3) + r13;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[r15], r4[r15]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        return false;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 != 8) goto L21;
    L19:
        if (r8 == r5) goto L21;
        r8 = r8 + 1;
    L21:
        return true;
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean any(Function2<? super K, ? super V, Boolean> r18) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r18, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.keys;
        Object[] r4 = this.values;
        long[] r0 = this.metadata;
        int r5 = r0.length - 2;
        if (r5 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r0[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        int r14 = (r7 << 3) + r12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[r14], r4[r14]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return true;
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
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
    L21:
        return false;
    }

    public final String asDebugString$collection() {
        StringBuilder r0 = new StringBuilder();
        r0.append('{');
        r0.append("metadata=[");
        int r1 = getCapacity();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L14;
        long r5 = (this.metadata[r3 >> 3] >> ((r3 & 7) << 3)) & 255;
        if (r5 != 128) goto L10;
        String r6 = "Empty";
    L8:
        r0.append(r6);
    L13:
        r0.append(", ");
        r3 = r3 + 1;
        goto L4
    L10:
        if (r5 != 254) goto L12;
        r6 = "Deleted";
        goto L8
    L12:
        r0.append(r5);
        goto L13
    L14:
        r0.append("], ");
        r0.append("keys=[");
        int r4 = this.keys.length;
        int r7 = 0;
    L15:
        if (r7 >= r4) goto L17;
        r0.append(this.keys[r7]);
        r0.append(", ");
        r7 = r7 + 1;
        goto L15
    L17:
        r0.append("], ");
        r0.append("values=[");
        int r8 = this.values.length;
    L18:
        if (r2 >= r8) goto L20;
        r0.append(this.values[r2]);
        r0.append(", ");
        r2 = r2 + 1;
        goto L18
    L20:
        r0.append("]");
        r0.append('}');
        String r9 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    }

    public final Map<K, V> asMap() {
        return (Map) ZeusTransformUtils.preCheckCast(new MapWrapper(this), Map.class, "com.obric.memorydata.plugin");
    }

    public final boolean contains(K r18) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L20;
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

    public final boolean containsKey(K r18) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L20;
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

    public final boolean containsValue(V r14) {
        Object[] r0 = this.values;
        long[] r13 = this.metadata;
        int r1 = r13.length - 2;
        if (r1 < 0) goto L21;
        int r3 = 0;
    L5:
        long r4 = r13[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L18;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L17;
        if (Intrinsics.areEqual(r14, r0[(r3 << 3) + r8]) == false) goto L17;
        return true;
    L17:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L18:
        if (r6 != 8) goto L21;
    L19:
        if (r3 == r1) goto L21;
        r3 = r3 + 1;
    L21:
        return false;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super K, ? super V, Boolean> r19) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.keys;
        Object[] r4 = this.values;
        long[] r0 = this.metadata;
        int r5 = r0.length - 2;
        int r6 = 0;
        if (r5 < 0) goto L23;
        int r7 = 0;
        int r8 = 0;
    L5:
        long r9 = r0[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r7 << 3) + r13;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[r15], r4[r15]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        r8 = r8 + 1;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 == 8) goto L19;
        return r8;
    L19:
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
        goto L5
    L21:
        r6 = r8;
    L23:
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r18) {
        if (r18 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r18, ScatterMap.class) == true) goto L9;
        return false;
    L9:
        if (((ScatterMap) ZeusTransformUtils.preCheckCast(r18, ScatterMap.class, "com.obric.memorydata.plugin")).getSize() == getSize()) goto L11;
        return false;
    L11:
        ScatterMap r1 = (ScatterMap) ZeusTransformUtils.preCheckCast(r18, ScatterMap.class, "com.obric.memorydata.plugin");
        Object[] r2 = this.keys;
        Object[] r4 = this.values;
        long[] r0 = this.metadata;
        int r6 = r0.length - 2;
        if (r6 < 0) goto L37;
        int r7 = 0;
    L14:
        long r8 = r0[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L35;
        int r10 = 8 - ((~(r7 - r6)) >>> 31);
        int r12 = 0;
    L17:
        if (r12 >= r10) goto L34;
        if ((255 & r8) >= 128) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L33;
        int r14 = (r7 << 3) + r12;
        Object r15 = r2[r14];
        Object r16 = r4[r14];
        if (r16 != null) goto L31;
        if (r1.get(r15) != null) goto L29;
        if (r1.containsKey(r15) == true) goto L33;
    L29:
        return false;
    L31:
        if (Intrinsics.areEqual(r16, r1.get(r15)) == true) goto L33;
        return false;
    L33:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L17
    L21:
        r13 = false;
        goto L22
    L34:
        if (r10 != 8) goto L37;
    L35:
        if (r7 == r6) goto L37;
        r7 = r7 + 1;
    L37:
        return true;
    }

    public final int findKeyIndex$collection(K r18) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L15;
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

    public final void forEach(Function2<? super K, ? super V, Unit> r15) {
        Function2 r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r15, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "block");
        Object[] r0 = this.keys;
        Object[] r1 = this.values;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L19;
        int r4 = 0;
    L5:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L16;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        int r11 = (r4 << 3) + r9;
        r16.invoke(r0[r11], r1[r11]);
    L15:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L16:
        if (r7 == 8) goto L17;
        return;
    L17:
        if (r4 == r2) goto L26;
        r4 = r4 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> r13) {
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

    public final void forEachKey(Function1<? super K, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "block");
        Object[] r0 = this.keys;
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

    public final void forEachValue(Function1<? super V, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "block");
        Object[] r0 = this.values;
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

    public final V get(K r18) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L20;
        r15 = r15 & (r15 - 1);
    L20:
        if (r17 >= 0) goto L28;
        return null;
    L28:
        return (V) this.values[r17];
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

    public final int getCapacity() {
        return this._capacity;
    }

    public final V getOrDefault(K r18, V r19) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L20;
        r15 = r15 & (r15 - 1);
    L20:
        if (r17 >= 0) goto L22;
        return r19;
    L22:
        return (V) this.values[r17];
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

    public final V getOrElse(K r3, Function0<? extends V> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        V r2 = get(r3);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (V) r5.invoke();
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] r0 = this.keys;
        Object[] r1 = this.values;
        long[] r15 = this.metadata;
        int r2 = r15.length - 2;
        int r3 = 0;
        if (r2 < 0) goto L28;
        int r4 = 0;
        int r5 = 0;
    L5:
        long r6 = r15[r4];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r8 = 8 - ((~(r4 - r2)) >>> 31);
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L23;
        if ((255 & r6) >= 128) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L22;
        int r12 = (r4 << 3) + r10;
        Object r13 = r0[r12];
        Object r14 = r1[r12];
        if (r13 == null) goto L17;
        int r16 = r13.hashCode();
    L18:
        if (r14 == null) goto L20;
        int r17 = r14.hashCode();
    L21:
        r5 = r5 + (r17 ^ r16);
        goto L22
    L20:
        r17 = 0;
        goto L21
    L17:
        r16 = 0;
    L22:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L8
    L12:
        r11 = false;
        goto L13
    L23:
        if (r8 == 8) goto L24;
        return r5;
    L24:
        if (r4 == r2) goto L26;
        r4 = r4 + 1;
        goto L5
    L26:
        r3 = r5;
    L28:
        return r3;
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

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, int r24, CharSequence r25, Function2<? super K, ? super V, ? extends CharSequence> r26) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r26, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "truncated");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        Object[] r8 = this.keys;
        Object[] r9 = this.values;
        long[] r0 = this.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L32;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r0[r11];
        int r27 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r14 = 8;
        int r15 = 8 - ((~(r27 - r10)) >>> 31);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L25;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L23;
        int r18 = (r27 << 3) + r16;
        Object r19 = r8[r18];
        Object r2 = r9[r18];
        if (r12 == r24) goto L16;
        if (r12 == 0) goto L19;
        r7.append(r1);
    L19:
        if (r6 != null) goto L21;
        r7.append(r19);
        r7.append('=');
        r7.append(r2);
    L22:
        r12 = r12 + 1;
        int r20 = 8;
    L24:
        r13 = r13 >> r20;
        r16 = r16 + 1;
        r14 = r20;
        r8 = r8;
        r0 = r0;
        goto L8
    L21:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r6.invoke(r19, r2), CharSequence.class, "com.obric.memorydata.plugin"));
        goto L22
    L16:
        r7.append(r5);
    L33:
        String r28 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r28, "StringBuilder().apply(builderAction).toString()");
        return r28;
    L23:
        r20 = r14;
        goto L24
    L12:
        r17 = false;
        goto L13
    L25:
        long[] r110 = r0;
        Object[] r111 = r8;
        if (r15 != r14) goto L32;
    L30:
        if (r27 == r10) goto L32;
        r11 = r27 + 1;
        r8 = r111;
        r0 = r110;
        goto L5
    L28:
        r110 = r0;
        r111 = r8;
    L32:
        r7.append(r4);
        goto L33
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r1 = new StringBuilder().append('{');
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L31;
        int r7 = 0;
        int r8 = 0;
    L9:
        long r9 = r4[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L29;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L28;
        if ((255 & r9) >= 128) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L27;
        int r15 = (r7 << 3) + r13;
        Object r16 = r2[r15];
        Object r17 = r3[r15];
        if (r16 != this) goto L21;
        r16 = "(this)";
    L21:
        r1.append(r16);
        r1.append("=");
        if (r17 != this) goto L24;
        r17 = "(this)";
    L24:
        r1.append(r17);
        r8 = r8 + 1;
        if (r8 >= this._size) goto L27;
        r1.append(',').append(' ');
    L27:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L12
    L16:
        r14 = false;
        goto L17
    L28:
        if (r11 != 8) goto L31;
    L29:
        if (r7 == r5) goto L31;
        r7 = r7 + 1;
    L31:
        String r0 = r1.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(r0, "s.append('}').toString()");
        return r0;
    }
}
