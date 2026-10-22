package com.bytedance.android.annie.service.prerender;

import com.bytedance.android.annie.api.card.HybridCard;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u0001`\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/annie/service/prerender/PrerenderMaxSizeLruCache;", "V", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/annie/api/card/HybridCard;", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "maxSize", "", "(I)V", "removeEldestEntry", "", "eldest", "", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PrerenderMaxSizeLruCache<V extends WeakReference<HybridCard>> extends LinkedHashMap<String, V> {
    private final int maxSize;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, V>> entrySet() {
        return (Set<Map.Entry<String, V>>) getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, WeakReference<?>>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<WeakReference<?>> getValues() {
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
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }

    public PrerenderMaxSizeLruCache(int r10) {
        super(r10, 0.75f, true);
        this.maxSize = r10;
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
        if ((r10 instanceof WeakReference) == true) goto L7;
        return false;
    L7:
        return containsValue((WeakReference) r10);
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

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, V> r10) {
        if (size() <= this.maxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(WeakReference<?> r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ V get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return (V) get((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ V remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return (V) remove((String) r10);
    }

    public /* bridge */ WeakReference<?> get(String r1) {
        return (WeakReference) super.get(r1);
    }

    public /* bridge */ WeakReference<?> remove(String r1) {
        return (WeakReference) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, (WeakReference) r11);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof WeakReference) == true) goto L9;
        return false;
    L9:
        return remove((String) r10, (WeakReference) r11);
    }

    public final /* bridge */ WeakReference getOrDefault(Object r10, WeakReference r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, r11);
    }

    public /* bridge */ boolean remove(String r1, WeakReference<?> r10) {
        return super.remove(r1, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ WeakReference<?> getOrDefault(String r1, WeakReference<?> r10) {
        return (WeakReference) super.getOrDefault(r1, r10);
    }
}
