package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public final class ShortVector extends BaseVector {
    public ShortVector() {
    }

    public ShortVector __assign(int r10, ByteBuffer r11) {
        __reset(r10, 2, r11);
        return this;
    }

    public short get(int r10) {
        return this.f374bb.getShort(__element(r10));
    }

    public int getAsUnsigned(int r10) {
        return get(r10) & UShort.MAX_VALUE;
    }
}
