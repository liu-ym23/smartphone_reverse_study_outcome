package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class IntVector extends BaseVector {
    public IntVector() {
    }

    public IntVector __assign(int r10, ByteBuffer r11) {
        __reset(r10, 4, r11);
        return this;
    }

    public int get(int r10) {
        return this.f374bb.getInt(__element(r10));
    }

    public long getAsUnsigned(int r10) {
        return ((long) get(r10)) & 4294967295L;
    }
}
