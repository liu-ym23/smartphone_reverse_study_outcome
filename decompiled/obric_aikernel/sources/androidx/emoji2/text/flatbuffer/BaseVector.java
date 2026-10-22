package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BaseVector {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f374bb;
    private int element_size;
    private int length;
    private int vector;

    public BaseVector() {
    }

    protected int __element(int r10) {
        return this.vector + (r10 * this.element_size);
    }

    protected void __reset(int r10, int r11, ByteBuffer r12) {
        this.f374bb = r12;
        if (r12 == null) goto L5;
        this.vector = r10;
        this.length = r12.getInt(r10 - 4);
        this.element_size = r11;
        return;
    L5:
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        __reset(0, 0, null);
    }
}
