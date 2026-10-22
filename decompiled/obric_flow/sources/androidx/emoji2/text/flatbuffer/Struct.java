package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Struct {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f519bb;
    protected int bb_pos;

    public Struct() {
    }

    public void __reset(int r5, ByteBuffer r10) {
        this.f519bb = r10;
        if (r10 == null) goto L5;
        this.bb_pos = r5;
        return;
    L5:
        this.bb_pos = 0;
    }

    public void __reset() {
        __reset(0, null);
    }
}
