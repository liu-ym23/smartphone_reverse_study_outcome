package com.tom_roush.pdfbox.contentstream.operator.state;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class c extends com.tom_roush.pdfbox.contentstream.operator.c {
    public c() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "q";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r2, List<com.tom_roush.pdfbox.a.b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f16096a.c();
    }
}
