package com.bytedance.apm6.java_alloc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public void onTrace(ITraceReader r9) {
        ITraceReader r10 = (ITraceReader) ZeusTransformUtils.wrapperContextForParams(r9, ITraceReader.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
        return;
    L5:
        int r6 = getTraceLength();
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        if (r10.onItem(this.buffer, JavaAllocCollector.fillStringBytes(this.stream, this.buffer), this.buffer2, JavaAllocCollector.fillStringBytes(this.stream, this.buffer2), this.stream.getInt()) == false) goto L14;
        r7 = r7 + 1;
        goto L6
    L14:
        return;
    }

    public void setStream(ByteBuffer r1) {
        this.stream = r1;
        this.position = r1.position();
    }
}
