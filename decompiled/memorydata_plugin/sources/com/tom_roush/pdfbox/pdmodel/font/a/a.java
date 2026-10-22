package com.tom_roush.pdfbox.pdmodel.font.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class a extends c {
    public a(Map<Integer, String> r5) {
        Iterator r6 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        a(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        throw new UnsupportedOperationException("Built-in encodings cannot be serialized");
    }
}
