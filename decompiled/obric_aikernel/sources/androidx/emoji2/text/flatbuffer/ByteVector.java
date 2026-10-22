package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ByteVector extends BaseVector {
    public ByteVector() {
    }

    public ByteVector __assign(int r10, ByteBuffer r11) {
        __reset(r10, 1, r11);
        return this;
    }

    public byte get(int r10) {
        return this.f374bb.get(__element(r10));
    }

    public int getAsUnsigned(int r10) {
        return get(r10) & 255;
    }
}
