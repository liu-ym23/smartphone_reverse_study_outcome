package com.tom_roush.pdfbox.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class RandomAccessBufferedFileInputStream$1 extends LinkedHashMap<Long, byte[]> {
    private static final long serialVersionUID = -6302488539257741101L;
    final /* synthetic */ d this$0;

    RandomAccessBufferedFileInputStream$1(d r1, int r2, float r3, boolean r4) {
        this.this$0 = r1;
        super(r2, r3, r4);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<Long, byte[]> r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        if (size() <= d.a(this.this$0)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        d.a(this.this$0, (byte[]) ZeusTransformUtils.preCheckCast(r5.getValue(), byte[].class, "com.obric.memorydata.plugin"));
    L8:
        return r0;
    L5:
        r0 = false;
        goto L6
    }
}
