package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector() {
    }

    public DoubleVector __assign(int r5, ByteBuffer r10) {
        __reset(r5, 8, r10);
        return this;
    }

    public double get(int r5) {
        return this.f514bb.getDouble(__element(r5));
    }
}
