package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector() {
    }

    public UnionVector __assign(int r5, int r10, ByteBuffer r11) {
        __reset(r5, r10, r11);
        return this;
    }

    public Table get(Table r5, int r10) {
        return Table.__union(r5, __element(r10), this.f514bb);
    }
}
