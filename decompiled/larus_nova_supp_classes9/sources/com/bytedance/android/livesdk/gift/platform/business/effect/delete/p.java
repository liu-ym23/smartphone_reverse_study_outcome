package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ LRUCleanStrategy a;

    public p(LRUCleanStrategy r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r14 = ((Map) r13).entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L30;
        Map.Entry r1 = (Map.Entry) r14.next();
        String r3 = (String) r1.getKey();
        List r2 = (List) r1.getValue();
        Map<String, v> r4 = this.a.b.get(r3);
        if (r4 == null) goto L4;
        Iterator<Map.Entry<String, v>> r5 = r4.entrySet().iterator();
        if (r5 == null) goto L4;
        long r6 = 0;
        ArrayList r8 = new ArrayList();
    L12:
        if (r5.hasNext() == false) goto L22;
        v r9 = r5.next().getValue();
        if (r2.contains(r9) == true) goto L15;
        r6 = r6 + r9.getSize();
        if (r9.getMd5().length() <= 0) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L12;
        r8.add(r9.getMd5());
        goto L12
    L19:
        r10 = false;
        goto L20
    L15:
        r5.remove();
        goto L12
    L22:
        Iterator r7 = r2.iterator();
    L24:
        if (r7.hasNext() == false) goto L29;
        v r11 = (v) r7.next();
        if (this.a.h().c3().contains(r3) == true) goto L28;
        this.a.l.I(r11.getMd5());
    L28:
        this.a.l.A(r11.getMd5());
        goto L24
    L29:
        this.a.l.f();
        r0.put(r3, Long.valueOf(r6));
        jy0.b.c("GiftAssetClean", r3 + ", 直播间内手动清理之后size大小: " + r6, null, 4);
        goto L4
    L30:
        ((LinkedHashMap) this.a.c).clear();
        this.a.c.putAll(r0);
        LRUCleanStrategy r15 = this.a;
        r15.i = true;
        r15.l.E();
        t r16 = this.a.k;
        if (r16 == null) goto L52;
        r16.b();
        return;
    }
}
