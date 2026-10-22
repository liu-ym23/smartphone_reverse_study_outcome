package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BaseVector {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f514bb;
    private int element_size;
    private int length;
    private int vector;

    public BaseVector() {
    }

    public int __element(int r5) {
        int r10 = this.vector;
        return (r5 * this.element_size) + r10;
    }

    public void __reset(int r5, int r10, ByteBuffer r11) {
        this.f514bb = r11;
        if (r11 == null) goto L5;
        this.vector = r5;
        this.length = r11.getInt(r5 - 4);
        this.element_size = r10;
        return;
    L5:
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    public int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        __reset(0, 0, null);
    }
}
