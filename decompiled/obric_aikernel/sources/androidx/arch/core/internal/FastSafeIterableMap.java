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
    public Map.Entry<K, V> ceil(K r10) {
        if (contains(r10) == true) goto L5;
        return null;
    L5:
        return this.mHashMap.get(r10).mPrevious;
    }

    public boolean contains(K r10) {
        return this.mHashMap.containsKey(r10);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    @Nullable
    protected SafeIterableMap.Entry<K, V> get(K r10) {
        return this.mHashMap.get(r10);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K r10, @NonNull V r11) {
        SafeIterableMap.Entry<K, V> r12 = get(r10);
        if (r12 != null) goto L5;
        this.mHashMap.put(r10, put(r10, r11));
        return null;
    L5:
        return r12.mValue;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K r10) {
        V r11 = (V) super.remove(r10);
        this.mHashMap.remove(r10);
        return r11;
    }
}
