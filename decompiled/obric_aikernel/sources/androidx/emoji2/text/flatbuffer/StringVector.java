package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class StringVector extends BaseVector {
    private Utf8 utf8;

    public StringVector() {
        this.utf8 = Utf8.getDefault();
    }

    public StringVector __assign(int r10, int r11, ByteBuffer r12) {
        __reset(r10, r11, r12);
        return this;
    }

    public String get(int r10) {
        return Table.__string(__element(r10), this.f374bb, this.utf8);
    }
}
