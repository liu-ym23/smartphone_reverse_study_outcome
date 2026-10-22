package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ LRUCleanStrategy a;
    public final /* synthetic */ String b;

    public m(LRUCleanStrategy r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Map<String, v> r0 = this.a.b.get(this.b);
        Iterator r9 = ((List) r8).iterator();
        long r1 = 0;
    L4:
        if (r9.hasNext() == false) goto L14;
        v r3 = (v) r9.next();
        if (r0 == null) goto L11;
        if (r0.containsKey(r3.getMd5()) != true) goto L11;
        r0.remove(r3.getMd5());
        r1 = r3.getSize();
    L11:
        if (this.a.h().c3().contains(this.b) == true) goto L13;
        this.a.l.I(r3.getMd5());
    L13:
        this.a.l.A(r3.getMd5());
        goto L4
    L14:
        this.a.l.f();
        Long r10 = (Long) ((LinkedHashMap) this.a.c).get(this.b);
        if (r10 == null) goto L19;
        long r4 = r10.longValue();
        if (r4 <= 0) goto L19;
        long r5 = r4 - r1;
        this.a.c.put(this.b, Long.valueOf(r5));
        jy0.b.c("GiftAssetClean", this.b + ", 直播间内清理之后size大小: " + r5, null, 4);
    L19:
        this.a.l.E();
    }
}
