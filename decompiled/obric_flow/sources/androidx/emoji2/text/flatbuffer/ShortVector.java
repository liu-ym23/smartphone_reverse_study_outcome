package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public final class ShortVector extends BaseVector {
    public ShortVector() {
    }

    public ShortVector __assign(int r5, ByteBuffer r10) {
        __reset(r5, 2, r10);
        return this;
    }

    public short get(int r5) {
        return this.f514bb.getShort(__element(r5));
    }

    public int getAsUnsigned(int r5) {
        return get(r5) & UShort.MAX_VALUE;
    }
}
