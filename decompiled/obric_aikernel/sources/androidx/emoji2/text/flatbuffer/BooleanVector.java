package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class BooleanVector extends BaseVector {
    public BooleanVector() {
    }

    public BooleanVector __assign(int r10, ByteBuffer r11) {
        __reset(r10, 1, r11);
        return this;
    }

    public boolean get(int r10) {
        if (this.f374bb.get(__element(r10)) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
