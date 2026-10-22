package com.tom_roush.pdfbox.pdmodel.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class b extends a {
    public b() {
    }

    public b(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public com.tom_roush.pdfbox.a.b a(String r1, com.tom_roush.pdfbox.a.b r2) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r1);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0;
    }

    public com.tom_roush.pdfbox.a.b b(String r1) {
        return a().a(r1);
    }

    public void b(String r3, com.tom_roush.pdfbox.a.b r4) {
        com.tom_roush.pdfbox.a.b r0 = b(r3);
        a().a(com.tom_roush.pdfbox.a.i.a(r3), r4);
        a(r0, r4);
    }

    public List<String> f() {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<com.tom_roush.pdfbox.a.i, com.tom_roush.pdfbox.a.b>> r4 = a().d().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        com.tom_roush.pdfbox.a.i r1 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        if (com.tom_roush.pdfbox.a.i.ft.equals(r1) == true) goto L4;
        r0.add(r1.a());
        goto L4
    L8:
        return r0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.a.a.a
    public String toString() {
        StringBuilder r0 = new StringBuilder().append(super.toString()).append(", attributes={");
        Iterator<String> r1 = f().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        r0.append(r2).append('=').append(b(r2));
        if (r1.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L9:
        return r0.append('}').toString();
    }
}
