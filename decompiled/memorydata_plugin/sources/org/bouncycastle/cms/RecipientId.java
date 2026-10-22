package org.bouncycastle.cms;

import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RecipientId implements Selector {
    private final int type;

    public RecipientId(int r1) {
        this.type = r1;
    }

    @Override // org.bouncycastle.util.Selector
    public abstract Object clone();

    public int getType() {
        return this.type;
    }
}
