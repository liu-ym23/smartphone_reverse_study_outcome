package com.tom_roush.fontbox.f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class ak extends af {
    private float c;
    private int d;
    private Map<Integer, Integer> e;

    ak(ah r1) {
        super(r1);
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r5, ad r6) {
        this.c = r6.h();
        this.d = r6.e();
        int r7 = r6.d();
        this.e = new ConcurrentHashMap(r7);
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        int r1 = r6.d();
        short r2 = r6.e();
        this.e.put(Integer.valueOf(r1), Integer.valueOf(r2));
        r0 = r0 + 1;
        goto L3
    L5:
        this.f15974a = true;
    }
}
