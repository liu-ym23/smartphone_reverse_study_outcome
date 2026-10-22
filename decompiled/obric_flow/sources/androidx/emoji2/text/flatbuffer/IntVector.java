package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class IntVector extends BaseVector {
    public IntVector() {
    }

    public IntVector __assign(int r5, ByteBuffer r10) {
        __reset(r5, 4, r10);
        return this;
    }

    public int get(int r5) {
        return this.f514bb.getInt(__element(r5));
    }

    public long getAsUnsigned(int r5) {
        return ((long) get(r5)) & 4294967295L;
    }
}
