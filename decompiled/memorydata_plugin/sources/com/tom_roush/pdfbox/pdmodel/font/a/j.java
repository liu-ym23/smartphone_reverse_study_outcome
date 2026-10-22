package com.tom_roush.pdfbox.pdmodel.font.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class j extends c {
    public j() {
    }

    public j(com.tom_roush.fontbox.a.e r4) {
        Iterator<com.tom_roush.fontbox.a.b> r5 = r4.l().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.tom_roush.fontbox.a.b r0 = (com.tom_roush.fontbox.a.b) ZeusTransformUtils.preCheckCast(r5.next(), com.tom_roush.fontbox.a.b.class, "com.obric.memorydata.plugin");
        a(r0.a(), r0.b());
        goto L4
    }

    public static j a(com.tom_roush.fontbox.d.b r5) {
        Map<Integer, String> r6 = r5.b();
        j r0 = new j();
        Iterator<Map.Entry<Integer, String>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.a(((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return null;
    }
}
