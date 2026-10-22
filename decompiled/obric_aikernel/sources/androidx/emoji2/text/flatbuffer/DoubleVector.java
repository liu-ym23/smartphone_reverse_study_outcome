package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector() {
    }

    public DoubleVector __assign(int r10, ByteBuffer r11) {
        __reset(r10, 8, r11);
        return this;
    }

    public double get(int r10) {
        return this.f374bb.getDouble(__element(r10));
    }
}
