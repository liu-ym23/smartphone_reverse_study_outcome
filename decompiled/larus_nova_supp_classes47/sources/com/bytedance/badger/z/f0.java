package com.bytedance.badger.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0 implements z64.g {
    public f0() {
    }

    @Override // z64.g
    public final void a(z64.i r4) {
        if ((r4 instanceof z64.i.a) == false) goto L6;
        com.bytedance.badger.e.g("oppo#", " complete and set async. error" + ((z64.i.a) r4).a);
        return;
    L6:
        if ((r4 instanceof z64.i.b) == false) goto L10;
        com.bytedance.badger.e.b("oppo#", " complete and set async. is full?" + ((z64.i.b) r4).c);
        return;
    }
}
