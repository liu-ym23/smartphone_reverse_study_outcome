package org.commonmark.node;

import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class Block extends b {
    @Override // uvc.b
    public final b c() {
        return (Block) this.a;
    }

    public Block() {
    }

    @Override // uvc.b
    public final void e(b r2) {
        if ((r2 instanceof Block) == false) goto L7;
        this.a = r2;
        return;
    L7:
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }
}
