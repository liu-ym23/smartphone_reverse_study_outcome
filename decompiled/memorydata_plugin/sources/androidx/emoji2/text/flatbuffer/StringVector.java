package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class StringVector extends BaseVector {
    private Utf8 utf8;

    public StringVector() {
        this.utf8 = Utf8.getDefault();
    }

    public StringVector __assign(int r1, int r2, ByteBuffer r3) {
        __reset(r1, r2, r3);
        return this;
    }

    public String get(int r2) {
        return Table.__string(__element(r2), this.bb, this.utf8);
    }
}
