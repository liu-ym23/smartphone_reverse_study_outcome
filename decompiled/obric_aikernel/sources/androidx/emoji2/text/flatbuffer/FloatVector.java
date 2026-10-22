package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class FloatVector extends BaseVector {
    public FloatVector() {
    }

    public FloatVector __assign(int r10, ByteBuffer r11) {
        __reset(r10, 4, r11);
        return this;
    }

    public float get(int r10) {
        return this.f374bb.getFloat(__element(r10));
    }
}
