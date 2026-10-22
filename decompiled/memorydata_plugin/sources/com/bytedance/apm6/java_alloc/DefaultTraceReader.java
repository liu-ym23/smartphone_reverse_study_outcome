package com.bytedance.apm6.java_alloc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTraceReader implements ITraceReader {
    private final ArrayList<StackTraceElement> result;

    public DefaultTraceReader() {
        this.result = new ArrayList();
    }

    public void clear() {
        this.result.clear();
    }

    public ArrayList<StackTraceElement> getResult() {
        return this.result;
    }

    @Override // com.bytedance.apm6.java_alloc.ITraceReader
    public boolean onItem(byte[] r4, int r5, byte[] r6, int r7, int r8) {
        String r0 = new String(r4, 0, r5, StandardCharsets.US_ASCII);
        String r9 = new String(r6, 0, r7, StandardCharsets.US_ASCII);
        int r10 = r0.lastIndexOf(46);
        this.result.add(new StackTraceElement(r0.substring(0, r10), r0.substring(r10 + 1, r5), r9, r8));
        return true;
    }

    public void setTrace(Trace r1) {
        this.result.ensureCapacity(r1.getTraceLength());
    }
}
