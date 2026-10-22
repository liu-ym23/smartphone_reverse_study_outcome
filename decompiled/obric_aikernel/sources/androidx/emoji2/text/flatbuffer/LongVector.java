package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class LongVector extends BaseVector {
    public LongVector() {
    }

    public LongVector __assign(int r10, ByteBuffer r11) {
        __reset(r10, 8, r11);
        return this;
    }

    public long get(int r10) {
        return this.f374bb.getLong(__element(r10));
    }
}
