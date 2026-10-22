package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector() {
    }

    public UnionVector __assign(int r10, int r11, ByteBuffer r12) {
        __reset(r10, r11, r12);
        return this;
    }

    public Table get(Table r10, int r11) {
        return Table.__union(r10, __element(r11), this.f374bb);
    }
}
