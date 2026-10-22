package com.bytedance.android.anniex.scene.core;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0014¨\u0006\t"}, d2 = {"com/bytedance/android/anniex/scene/core/HotUrlCache$map$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class HotUrlCache$map$1 extends LinkedHashMap<String, Integer> {
    final /* synthetic */ HotUrlCache this$0;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Integer> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Integer> values() {
        return getValues();
    }

    public HotUrlCache$map$1(HotUrlCache r10) {
        this.this$0 = r10;
        super(50, 0.75f, true);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r10) {
        if ((r10 instanceof Integer) == true) goto L7;
        return false;
    L7:
        return containsValue((Integer) r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "eldest");
        if (size() <= this.this$0.a) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(Integer r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    public /* bridge */ Integer get(String r1) {
        return (Integer) super.get(r1);
    }

    public /* bridge */ Integer remove(String r1) {
        return (Integer) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, (Integer) r11);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof Integer) == true) goto L9;
        return false;
    L9:
        return remove((String) r10, (Integer) r11);
    }

    public final /* bridge */ Integer getOrDefault(Object r10, Integer r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, r11);
    }

    public /* bridge */ boolean remove(String r1, Integer r10) {
        return super.remove(r1, r10);
    }

    public /* bridge */ Integer getOrDefault(String r1, Integer r10) {
        return (Integer) super.getOrDefault(r1, r10);
    }
}
