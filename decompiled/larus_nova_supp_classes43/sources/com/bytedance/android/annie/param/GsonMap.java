package com.bytedance.android.annie.param;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class GsonMap implements Map<String, Object>, KMappedMarker {
    public final JsonObject a;
    public final Lazy b;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(String r1, BiFunction<? super String, ? super Object, ? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(String r1, Function<? super String, ? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(String r1, BiFunction<? super String, ? super Object, ? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(String r1, Object r10, BiFunction<? super Object, ? super Object, ? extends Object> r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(String r1, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(String r1, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean remove(Object r1, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(String r1, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String r1, Object r10, Object r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Set<Map.Entry<String, Object>> b() {
        return (Set) this.b.getValue();
    }

    public Collection<Object> c() {
        Set r0 = this.a.entrySet();
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r10 = r0.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r1.add(UtilsKt.c((JsonElement) ((Map.Entry) r10.next()).getValue()));
        goto L4
    L6:
        return r1;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.a.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return c();
    }

    public GsonMap(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.a = r10;
        this.b = LazyKt.lazy(new GsonMap$entries$2(this));
    }

    public Object a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        JsonElement r11 = this.a.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return UtilsKt.c(r11);
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r10) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        String r11 = (String) r10;
        Intrinsics.checkNotNullParameter(r11, "key");
        return this.a.keySet().contains(r11);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r10) {
        Set r0 = this.a.entrySet();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((Map.Entry) r1.next()).getValue(), r10) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Object get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return a((String) r10);
    }
}
