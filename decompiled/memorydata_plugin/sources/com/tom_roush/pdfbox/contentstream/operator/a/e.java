package com.tom_roush.pdfbox.contentstream.operator.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class e extends com.tom_roush.pdfbox.contentstream.operator.c {
    public e() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "T*";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r2, List<com.tom_roush.pdfbox.a.b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ArrayList r5 = new ArrayList(2);
        r5.add(new com.tom_roush.pdfbox.a.f(0.0f));
        r5.add(new com.tom_roush.pdfbox.a.f(-this.f16096a.g().b().d()));
        this.f16096a.a("Td", r5);
    }
}
