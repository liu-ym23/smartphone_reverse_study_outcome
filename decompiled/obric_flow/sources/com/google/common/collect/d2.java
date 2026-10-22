package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class d2 extends f2 {
    @Override // com.google.common.collect.f2
    public final f2 a(Comparable r5, Comparable r10) {
        int r11 = r5.compareTo(r10);
        if (r11 < 0) goto L9;
        if (r11 <= 0) goto L8;
        return f2.f8967c;
    L8:
        return f2.f8965a;
    L9:
        return f2.f8966b;
    }

    @Override // com.google.common.collect.f2
    public final int b() {
        return 0;
    }
}
