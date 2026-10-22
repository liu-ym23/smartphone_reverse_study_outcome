package com.tom_roush.pdfbox.contentstream.operator.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class o extends com.tom_roush.pdfbox.contentstream.operator.c {
    public o() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "'";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r3, List<com.tom_roush.pdfbox.a.b> r4) {
        List<com.tom_roush.pdfbox.a.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f16096a.a("T*", null);
        this.f16096a.a("Tj", r5);
    }
}
