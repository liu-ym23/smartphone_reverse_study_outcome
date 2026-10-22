package com.bytedance.android.live.browser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class GsonMap implements Map<String, Object>, KMappedMarker {
    public final Lazy a;
    public final JsonObject b;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object compute(String r1, BiFunction<? super String, ? super Object, ? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object computeIfAbsent(String r1, Function<? super String, ? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object computeIfPresent(String r1, BiFunction<? super String, ? super Object, ? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object merge(String r1, Object r2, BiFunction<? super Object, ? super Object, ? extends Object> r3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object put(String r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object putIfAbsent(String r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean remove(Object r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object replace(String r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean replace(String r1, Object r2, Object r3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Object>> entrySet() {
        return (Set) this.a.getValue();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.b.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.b.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.b.size();
    }

    @Override // java.util.Map
    public final Collection<Object> values() {
        Set r0 = this.b.entrySet();
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(UtilsKt.b((JsonElement) ((Map.Entry) r2.next()).getValue()));
        goto L4
    L6:
        return r1;
    }

    public GsonMap(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.b = r2;
        this.a = LazyKt.lazy(new GsonMap$entries$2(this));
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return false;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.b.keySet().contains(r3);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r4) {
        Set r0 = this.b.entrySet();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (Intrinsics.areEqual((JsonElement) ((Map.Entry) r1.next()).getValue(), r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    @Override // java.util.Map
    public final Object get(Object r3) {
        if ((r3 instanceof String) == true) goto L5;
        return null;
    L5:
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "key");
        JsonElement r5 = this.b.get(r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        return UtilsKt.b(r5);
    }
}
