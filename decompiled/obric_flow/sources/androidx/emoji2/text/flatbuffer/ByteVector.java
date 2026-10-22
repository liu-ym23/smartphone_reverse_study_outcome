package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class ByteVector extends BaseVector {
    public ByteVector() {
    }

    public ByteVector __assign(int r5, ByteBuffer r10) {
        __reset(r5, 1, r10);
        return this;
    }

    public byte get(int r5) {
        return this.f514bb.get(__element(r5));
    }

    public int getAsUnsigned(int r5) {
        return get(r5) & UByte.MAX_VALUE;
    }
}
