package org.commonmark.node;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ListBlock extends Block {
    private boolean tight;

    public ListBlock() {
    }

    public boolean isTight() {
        return this.tight;
    }

    public void setTight(boolean r1) {
        this.tight = r1;
    }
}
