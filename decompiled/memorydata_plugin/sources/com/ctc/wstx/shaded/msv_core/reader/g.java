package com.ctc.wstx.shaded.msv_core.reader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes2.dex */
public class g extends i {
    private int f;

    public g() {
        this.f = 1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.i, org.xml.sax.ContentHandler
    public void characters(char[] r1, int r2, int r3) {
    }

    @Override // org.xml.sax.ContentHandler
    public final void endDocument() {
        this.f3622b.a();
    }

    @Override // org.xml.sax.ContentHandler
    public final void endElement(String r1, String r2, String r3) {
        int r4 = this.f - 1;
        this.f = r4;
        if (r4 != 0) goto L6;
        this.f3622b.a();
        return;
    }

    @Override // org.xml.sax.ContentHandler
    public final void startElement(String r1, String r2, String r3, Attributes r4) {
        Attributes r5 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r4, Attributes.class, "com.obric.memorydata.plugin");
        this.f++;
    }
}
