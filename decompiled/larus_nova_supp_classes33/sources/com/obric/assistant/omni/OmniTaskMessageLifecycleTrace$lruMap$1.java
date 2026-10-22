package com.obric.assistant.omni;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000`\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/obric/assistant/omni/OmniTaskMessageLifecycleTrace$lruMap$1", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniTaskMessageLifecycleTrace$lruMap$1 extends LinkedHashMap<String, Object> {
    final /* synthetic */ int $maxSize;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
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
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public OmniTaskMessageLifecycleTrace$lruMap$1(int r3) {
        this.$maxSize = r3;
        super(r3, 0.75f, true);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Object> r2) {
        if (size() <= this.$maxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ Object get(String r1) {
        return super.get(r1);
    }

    public /* bridge */ Object remove(String r1) {
        return super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return remove((String) r2, r3);
    }

    public /* bridge */ Object getOrDefault(String r1, Object r2) {
        return super.getOrDefault(r1, r2);
    }

    public /* bridge */ boolean remove(String r1, Object r2) {
        return super.remove(r1, r2);
    }
}
