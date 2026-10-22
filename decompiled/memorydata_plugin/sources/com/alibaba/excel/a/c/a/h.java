package com.alibaba.excel.a.c.a;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.i.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Optional;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class h extends b {
    public h() {
    }

    private static /* synthetic */ void a(String r2, com.alibaba.excel.e.c.b r3, URI r4) {
        com.alibaba.excel.e.a r5 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.f r0 = new com.alibaba.excel.metadata.f(CellExtraTypeEnum.HYPERLINK, r4.toString(), r2);
        r5.b().a(r0);
        r5.e().a(r5);
    }

    public static /* synthetic */ void lambda$Tj0SZGd9clT0nxydZTDtRgEHaHg(String r0, com.alibaba.excel.e.c.b r1, URI r2) {
        a(r0, r1, r2);
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r2, String r3, Attributes r4) {
        final com.alibaba.excel.e.c.b r1 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        Attributes r5 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r4, Attributes.class, "com.obric.memorydata.plugin");
        final String r6 = r5.getValue("ref");
        if (o.a(r6) == false) goto L5;
        return;
    L5:
        String r7 = r5.getValue("location");
        if (r7 == null) goto L9;
        com.alibaba.excel.metadata.f r8 = new com.alibaba.excel.metadata.f(CellExtraTypeEnum.HYPERLINK, r7, r6);
        r1.b().a(r8);
        r1.e().a(r1);
        return;
    L9:
        String r9 = r5.getValue("r:id");
        PackageRelationshipCollection r10 = r1.g().B();
        if (r9 == null) goto L15;
        if (r10 == null) goto L16;
        Optional.ofNullable(r10.getRelationshipByID(r9)).map($$Lambda$_08WljObB0W5_7qVQKHK7XrdF0.INSTANCE).ifPresent(new $$Lambda$h$Tj0SZGd9clT0nxydZTDtRgEHaHg(r6, r1));
        return;
    L16:
        return;
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public boolean a(com.alibaba.excel.e.c.b r2) {
        return ((com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin")).a().B().contains(CellExtraTypeEnum.HYPERLINK);
    }
}
