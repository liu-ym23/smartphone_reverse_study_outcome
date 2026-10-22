package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector() {
    }

    public UnionVector __assign(int r1, int r2, ByteBuffer r3) {
        __reset(r1, r2, r3);
        return this;
    }

    public Table get(Table r1, int r2) {
        return Table.__union(r1, __element(r2), this.bb);
    }
}
