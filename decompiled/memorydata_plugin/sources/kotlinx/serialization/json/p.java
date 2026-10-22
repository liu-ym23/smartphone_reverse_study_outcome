package kotlinx.serialization.json;

import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001!B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0001H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0003J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\t\u0010\u001f\u001a\u00020\u0016H\u0096\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b0\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", Params.CONTENT, "(Ljava/util/Map;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", EventBody.KEY_VALUE, "equals", "other", "", "get", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlinx.serialization.h(a = q.class)
public final class p extends g implements Map<String, g>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17861a = null;
    private final Map<String, g> c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f17861a = new a(null);
    }

    public p(Map<String, ? extends g> r3) {
        Map<String, g> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        super(null);
        this.c = r4;
    }

    public Set<Map.Entry<String, g>> a() {
        return this.c.entrySet();
    }

    public g a(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.containsKey(r2);
    }

    public boolean a(g r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        return this.c.containsValue(r2);
    }

    public Set<String> b() {
        return this.c.keySet();
    }

    public g b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (g) ZeusTransformUtils.preCheckCast(this.c.get(r2), g.class, "com.obric.memorydata.plugin");
    }

    public int c() {
        return this.c.size();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ g compute(String r1, BiFunction<? super String, ? super g, ? extends g> r2) {
        BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ g computeIfAbsent(String r1, Function<? super String, ? extends g> r2) {
        Function r0 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ g computeIfPresent(String r1, BiFunction<? super String, ? super g, ? extends g> r2) {
        BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return false;
    L7:
        return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, g.class) == true) goto L7;
        return false;
    L7:
        return a((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin"));
    }

    public Collection<g> d() {
        return this.c.values();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, g>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(Object r1) {
        return Intrinsics.areEqual(this.c, r1);
    }

    @Override // java.util.Map
    public final /* synthetic */ g get(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return b();
    }

    @Override // java.util.Map
    public /* synthetic */ g merge(String r1, g r2, BiFunction<? super g, ? super g, ? extends g> r3) {
        BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ g put(String r1, g r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends g> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ g putIfAbsent(String r1, g r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ g remove(Object r1) {
        return a(r1);
    }

    @Override // java.util.Map
    public boolean remove(Object r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ g replace(String r1, g r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ boolean replace(String r1, g r2, g r3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super g, ? extends g> r2) {
        BiFunction r1 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return c();
    }

    public String toString() {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(this.c.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("{", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("}", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(JsonObject$toString$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 24, null);
    }

    @Override // java.util.Map
    public final Collection<g> values() {
        return d();
    }
}
