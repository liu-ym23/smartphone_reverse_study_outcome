package com.ctc.wstx.shaded.msv_core.reader.trex;

import com.ctc.wstx.shaded.msv_core.grammar.trex.TREXGrammar;
import com.ctc.wstx.shaded.msv_core.reader.d;
import com.ctc.wstx.shaded.msv_core.util.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends d {
    protected TREXGrammar f;
    protected String g;
    private b h;

    @Override // com.ctc.wstx.shaded.msv_core.reader.d
    public String a(String r1, Object[] r2) {
        String r0 = ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.reader.trex.Messages").getString(r1);     // Catch: Exception -> L4
    L6:
        return MessageFormat.format(r0, r2);
    L4:
        r0 = ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.reader.Messages").getString(r1);
        goto L6
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endElement(String r1, String r2, String r3) {
        super.endElement(r1, r2, r3);
        this.g = (String) ZeusTransformUtils.preCheckCast(this.h.a(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startElement(String r4, String r5, String r6, Attributes r7) {
        Attributes r8 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r7, Attributes.class, "com.obric.memorydata.plugin");
        this.h.a(this.g);
        if (r8.getIndex("ns") == (-1)) goto L5;
        this.g = r8.getValue("ns");
    L5:
        super.startElement(r4, r5, r6, r8);
    }
}
