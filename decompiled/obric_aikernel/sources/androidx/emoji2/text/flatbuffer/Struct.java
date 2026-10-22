package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Struct {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f379bb;
    protected int bb_pos;

    public Struct() {
    }

    public void __reset() {
        __reset(0, null);
    }

    protected void __reset(int r10, ByteBuffer r11) {
        this.f379bb = r11;
        if (r11 != null) goto L6;
        r10 = 0;
    L6:
        this.bb_pos = r10;
    }
}
