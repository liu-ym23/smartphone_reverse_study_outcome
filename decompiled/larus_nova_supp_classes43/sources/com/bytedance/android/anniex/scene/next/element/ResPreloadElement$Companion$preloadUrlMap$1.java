package com.bytedance.android.anniex.scene.next.element;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001c\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0007H\u0014¨\u0006\b"}, d2 = {"com/bytedance/android/anniex/scene/next/element/ResPreloadElement$Companion$preloadUrlMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "eldest", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ResPreloadElement$Companion$preloadUrlMap$1 extends LinkedHashMap<String, Boolean> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Boolean>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Boolean> getValues() {
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
    public final /* bridge */ Collection<Boolean> values() {
        return getValues();
    }

    public ResPreloadElement$Companion$preloadUrlMap$1(int r10) {
        super(r10, 0.75f, true);
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
        if ((r10 instanceof Boolean) == true) goto L7;
        return false;
    L7:
        return containsValue((Boolean) r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Boolean get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Boolean remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "eldest");
        if (size() <= ResPreloadElement.a) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(Boolean r1) {
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

    public /* bridge */ Boolean get(String r1) {
        return (Boolean) super.get(r1);
    }

    public /* bridge */ Boolean remove(String r1) {
        return (Boolean) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, (Boolean) r11);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof Boolean) == true) goto L9;
        return false;
    L9:
        return remove((String) r10, (Boolean) r11);
    }

    public final /* bridge */ Boolean getOrDefault(Object r10, Boolean r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, r11);
    }

    public /* bridge */ boolean remove(String r1, Boolean r10) {
        return super.remove(r1, r10);
    }

    public /* bridge */ Boolean getOrDefault(String r1, Boolean r10) {
        return (Boolean) super.getOrDefault(r1, r10);
    }
}
