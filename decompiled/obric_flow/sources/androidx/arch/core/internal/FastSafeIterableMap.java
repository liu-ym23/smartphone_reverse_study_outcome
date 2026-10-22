package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap;

    public FastSafeIterableMap() {
        this.mHashMap = new HashMap();
    }

    @Nullable
    public Map.Entry<K, V> ceil(K r5) {
        if (contains(r5) == true) goto L5;
        return null;
    L5:
        return this.mHashMap.get(r5).mPrevious;
    }

    public boolean contains(K r5) {
        return this.mHashMap.containsKey(r5);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    @Nullable
    public SafeIterableMap.Entry<K, V> get(K r5) {
        return this.mHashMap.get(r5);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K r5, @NonNull V r10) {
        SafeIterableMap.Entry<K, V> r11 = get(r5);
        if (r11 != null) goto L5;
        this.mHashMap.put(r5, put(r5, r10));
        return null;
    L5:
        return r11.mValue;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K r5) {
        V r10 = (V) super.remove(r5);
        this.mHashMap.remove(r5);
        return r10;
    }
}
