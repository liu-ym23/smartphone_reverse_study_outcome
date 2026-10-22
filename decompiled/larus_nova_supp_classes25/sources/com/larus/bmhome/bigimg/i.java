package com.larus.bmhome.bigimg;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements k1 {
    public final /* synthetic */ List<l> a;

    public i(List<l> r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.bigimg.k1
    public final l a(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.a.size()) goto L7;
        return null;
    L7:
        return (l) ListProtector.get(this.a, r2);
    }
}
