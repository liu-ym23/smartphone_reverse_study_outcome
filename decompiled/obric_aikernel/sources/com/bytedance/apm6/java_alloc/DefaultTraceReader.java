package com.bytedance.apm6.java_alloc;

import androidx.annotation.RequiresApi;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 19)
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
    public boolean onItem(byte[] r10, int r11, byte[] r12, int r13, int r14) {
        String r15 = new String(r10, 0, r11, StandardCharsets.US_ASCII);
        String r16 = new String(r12, 0, r13, StandardCharsets.US_ASCII);
        int r17 = r15.lastIndexOf(46);
        this.result.add(new StackTraceElement(r15.substring(0, r17), r15.substring(r17 + 1, r11), r16, r14));
        return true;
    }

    public void setTrace(Trace r10) {
        this.result.ensureCapacity(r10.getTraceLength());
    }
}
