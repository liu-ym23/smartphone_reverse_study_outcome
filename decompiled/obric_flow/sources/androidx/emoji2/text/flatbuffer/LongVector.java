package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class LongVector extends BaseVector {
    public LongVector() {
    }

    public LongVector __assign(int r5, ByteBuffer r10) {
        __reset(r5, 8, r10);
        return this;
    }

    public long get(int r5) {
        return this.f514bb.getLong(__element(r5));
    }
}
