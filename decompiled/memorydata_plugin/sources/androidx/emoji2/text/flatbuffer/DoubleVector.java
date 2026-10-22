package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector() {
    }

    public DoubleVector __assign(int r2, ByteBuffer r3) {
        __reset(r2, 8, r3);
        return this;
    }

    public double get(int r2) {
        return this.bb.getDouble(__element(r2));
    }
}
