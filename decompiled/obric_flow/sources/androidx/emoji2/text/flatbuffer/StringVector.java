package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class StringVector extends BaseVector {
    private Utf8 utf8;

    public StringVector() {
        this.utf8 = Utf8.getDefault();
    }

    public StringVector __assign(int r5, int r10, ByteBuffer r11) {
        __reset(r5, r10, r11);
        return this;
    }

    public String get(int r5) {
        return Table.__string(__element(r5), this.f514bb, this.utf8);
    }
}
