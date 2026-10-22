package com.tom_roush.pdfbox.contentstream.operator.state;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class b extends com.tom_roush.pdfbox.contentstream.operator.c {
    public b() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "Q";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r2, List<com.tom_roush.pdfbox.a.b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (this.f16096a.f() <= 1) goto L7;
        this.f16096a.d();
        return;
    L7:
        throw new EmptyGraphicsStackException();
    }
}
