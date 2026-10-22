package com.bytedance.apm6.java_alloc;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Trace {
    byte[] buffer;
    byte[] buffer2;
    int position;
    ByteBuffer stream;

    public Trace() {
        this.buffer = new byte[4096];
        this.buffer2 = new byte[4096];
    }

    public int getTraceLength() {
        this.stream.position(this.position);
        return this.stream.getInt();
    }

    public void onTrace(ITraceReader r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r10 = getTraceLength();
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L10;
        int r13 = JavaAllocCollector.fillStringBytes(this.stream, this.buffer);
        int r14 = JavaAllocCollector.fillStringBytes(this.stream, this.buffer2);
        int r15 = this.stream.getInt();
        if (r11.onItem(this.buffer, r13, this.buffer2, r14, r15) == false) goto L13;
        r12 = r12 + 1;
        goto L5
    L13:
        return;
    }

    public void setStream(ByteBuffer r10) {
        this.stream = r10;
        this.position = r10.position();
    }
}
