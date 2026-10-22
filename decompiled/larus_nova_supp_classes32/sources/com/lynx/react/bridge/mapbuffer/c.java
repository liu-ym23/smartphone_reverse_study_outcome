package com.lynx.react.bridge.mapbuffer;

import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Iterator<d.a> {
    public int a;
    public final int b;
    public final /* synthetic */ d c;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a >= this.b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final d.a next() {
        d r1 = this.c;
        int r2 = this.a;
        this.a = r2 + 1;
        return new d.a(r1, r1.a(r2));
    }

    public c(d r2) {
        this.c = r2;
        this.a = 0;
        this.b = r2.b;
    }
}
