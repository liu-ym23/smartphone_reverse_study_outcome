package com.bytedance.badger.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0 implements z64.g {
    public i0() {
    }

    @Override // z64.g
    public final void a(z64.i r3) {
        if ((r3 instanceof z64.i.a) == false) goto L6;
        StringBuilder r0 = new StringBuilder(" complete and set async. error");
        r0.append(((z64.i.a) r3).a);
    L8:
        com.bytedance.badger.e.b("sensor#", r0.toString());
        return;
    L6:
        if ((r3 instanceof z64.i.b) == false) goto L10;
        r0 = new StringBuilder(" complete and set async. is full?");
        r0.append(((z64.i.b) r3).c);
        goto L8
    }
}
