package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class FloatVector extends BaseVector {
    public FloatVector() {
    }

    public FloatVector __assign(int r5, ByteBuffer r10) {
        __reset(r5, 4, r10);
        return this;
    }

    public float get(int r5) {
        return this.f514bb.getFloat(__element(r5));
    }
}
