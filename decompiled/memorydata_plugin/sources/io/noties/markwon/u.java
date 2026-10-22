package io.noties.markwon;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class u implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<q, Object> f16692a;

    u() {
        this.f16692a = new HashMap(3);
    }

    @Override // io.noties.markwon.t
    public <T> T a(q<T> r1) {
        return (T) this.f16692a.get(r1);
    }

    @Override // io.noties.markwon.t
    public <T> T a(q<T> r1, T r2) {
        T r0 = (T) this.f16692a.get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r2;
    }

    @Override // io.noties.markwon.t
    public <T> void b(q<T> r1) {
        this.f16692a.remove(r1);
    }

    @Override // io.noties.markwon.t
    public <T> void b(q<T> r1, T r2) {
        Map<q, Object> r0 = this.f16692a;
        if (r2 != null) goto L5;
        r0.remove(r1);
        return;
    L5:
        r0.put(r1, r2);
    }
}
