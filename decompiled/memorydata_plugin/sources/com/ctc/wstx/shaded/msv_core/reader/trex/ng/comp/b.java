package com.ctc.wstx.shaded.msv_core.reader.trex.ng.comp;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ctc.wstx.shaded.msv_core.grammar.relaxng.RELAXNGGrammar;
import com.ctc.wstx.shaded.msv_core.reader.trex.ng.RELAXNGReader;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;

/* JADX INFO: loaded from: classes2.dex */
public class b extends RELAXNGReader {
    private final com.ctc.wstx.shaded.msv_core.util.b j;
    private boolean k;

    @Override // com.ctc.wstx.shaded.msv_core.reader.trex.ng.RELAXNGReader, com.ctc.wstx.shaded.msv_core.reader.trex.a, com.ctc.wstx.shaded.msv_core.reader.d
    public String a(String r2, Object[] r3) {
        return MessageFormat.format(ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.reader.trex.ng.comp.Messages").getString(r2), r3);
    L6:
        return super.a(r2, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.trex.ng.RELAXNGReader, com.ctc.wstx.shaded.msv_core.reader.trex.a, org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endElement(String r1, String r2, String r3) {
        super.endElement(r1, r2, r3);
        this.k = false;
        this.j.a();
        if (r1.equals("http://relaxng.org/ns/structure/1.0") == false) goto L6;
        this.j.a();
        this.j.a(r2);
        return;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.trex.ng.RELAXNGReader, com.ctc.wstx.shaded.msv_core.reader.trex.a, org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startElement(String r6, String r7, String r8, Attributes r9) {
        Attributes r10 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r9, Attributes.class, "com.obric.memorydata.plugin");
        super.startElement(r6, r7, r8, r10);
        if (this.k == false) goto L6;
        a("RELAXNGReader.Compatibility.Annotation.ChildElement", null, new Locator[]{c()});
        ((RELAXNGGrammar) ZeusTransformUtils.preCheckCast(this.f, RELAXNGGrammar.class, "com.obric.memorydata.plugin")).isAnnotationCompatible = false;
    L6:
        if (r6.equals("http://relaxng.org/ns/compatibility/annotations/1.0") == true) goto L8;
    L33:
        this.j.a(null);
        return;
    L8:
        if (r7.equals("annotation") == false) goto L33;
        int r11 = 0;
    L11:
        if (r11 >= r10.getLength()) goto L22;
        String r12 = r10.getURI(r11);
        if (r12.equals("") == true) goto L20;
        if (r12.equals("http://relaxng.org/ns/compatibility/annotations/1.0") == true) goto L20;
        if (r12.equals("http://relaxng.org/ns/structure/1.0") == true) goto L20;
        r11 = r11 + 1;
    L20:
        a("RELAXNGReader.Compatibility.Annotation.InvalidAttribute", new Object[]{r10.getQName(r11)}, new Locator[]{c()});
        ((RELAXNGGrammar) ZeusTransformUtils.preCheckCast(this.f, RELAXNGGrammar.class, "com.obric.memorydata.plugin")).isAnnotationCompatible = false;
    L22:
        if (this.j.c() != 0) goto L24;
    L32:
        this.k = true;
        goto L33
    L24:
        if (this.j.b() == null) goto L32;
        if (EventBody.KEY_VALUE.equals(this.j.b()) == true) goto L32;
        if (AutoTestConstant.PARAM.equals(this.j.b()) == true) goto L32;
        if (ActivityLifecycle.NAME.equals(this.j.b()) == true) goto L32;
        a("RELAXNGReader.Compatibility.Annotation.Misplaced", new Object[]{this.j.b()}, new Locator[]{c()});
        ((RELAXNGGrammar) ZeusTransformUtils.preCheckCast(this.f, RELAXNGGrammar.class, "com.obric.memorydata.plugin")).isAnnotationCompatible = false;
        goto L32
    }
}
