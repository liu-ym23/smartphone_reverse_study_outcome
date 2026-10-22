package com.bytedance.badger.utils;

import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements z64.g {
    public e() {
    }

    @Override // z64.g
    public final void a(i r4) {
        if ((r4 instanceof i.a) == false) goto L6;
        com.bytedance.badger.e.g("vivo#", "handleLateOpenId: report failed, error=" + ((i.a) r4).a);
        return;
    L6:
        if ((r4 instanceof i.b) == false) goto L10;
        com.bytedance.badger.e.b("vivo#", "handleLateOpenId: report success, isFull=" + ((i.b) r4).c);
        return;
    }
}
