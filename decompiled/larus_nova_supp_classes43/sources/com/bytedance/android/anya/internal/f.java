package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.g0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<DATA_STORE extends BaseMVIDataStore<?>> implements com.bytedance.android.anya.n {
    public final Map<n<?, ?>, Object> a;
    public volatile boolean b;

    public f() {
        this.a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.anya.n
    public final <T> T b(com.bytedance.android.anya.t<DATA_STORE, T> r10) {
        n r11 = (n) r10;
        if ((!this.b) == false) goto L7;
        return (T) r11.a();
    L7:
        throw new IllegalStateException("Changes are already published. Consider using mutate{...} or mutateExternal{...} in async callbacks.".toString());
    }

    @Override // com.bytedance.android.anya.n
    public final <T> void a(com.bytedance.android.anya.t<DATA_STORE, T> r10, T r11) {
        n<?, ?> r12 = (n) r10;
        if ((!this.b) == false) goto L13;
        Object r0 = r12.a();
        Map<Object, Object> r1 = r12.b.d;
        if (r11 != null) goto L8;
        r11 = (T) g0.a;
    L8:
        ((ConcurrentHashMap) r1).put(r12, r11);
        if (this.a.containsKey(r12) == true) goto L14;
        this.a.put(r12, r0);
        return;
    L14:
        return;
    L13:
        throw new IllegalStateException("Changes are already published. Consider using mutate{...} or mutateExternal{...} in async callbacks.".toString());
    }
}
