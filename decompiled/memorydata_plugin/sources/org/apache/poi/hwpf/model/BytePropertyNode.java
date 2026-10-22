package org.apache.poi.hwpf.model;

import org.apache.poi.hwpf.model.BytePropertyNode;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class BytePropertyNode<T extends BytePropertyNode<T>> extends PropertyNode<T> {
    private final int endBytes;
    private final int startBytes;

    public BytePropertyNode(int r2, int r3, Object r4) {
        super(r2, r3, r4);
        if (r2 > r3) goto L7;
        this.startBytes = -1;
        this.endBytes = -1;
        return;
    L7:
        throw new IllegalArgumentException("charStart (" + r2 + ") > charEnd (" + r3 + ")");
    }

    @Deprecated
    public int getEndBytes() {
        return this.endBytes;
    }

    @Deprecated
    public int getStartBytes() {
        return this.startBytes;
    }
}
