package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class BooleanVector extends BaseVector {
    public BooleanVector() {
    }

    public BooleanVector __assign(int r5, ByteBuffer r10) {
        __reset(r5, 1, r10);
        return this;
    }

    public boolean get(int r5) {
        if (this.f514bb.get(__element(r5)) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
