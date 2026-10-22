package com.ctc.wstx.shaded.msv_core.reader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.LocatorImpl;

/* JADX INFO: loaded from: classes2.dex */
public class b implements f, ErrorHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f3600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3601b;

    public final void a() {
        this.f3601b = true;
    }

    public void a(IOException r3, Locator r4) {
        a(new Locator[]{(Locator) ZeusTransformUtils.wrapperContextForParams(r4, Locator.class, "com.obric.memorydata.plugin")}, r3.getMessage(), r3);
    }

    public void a(ParserConfigurationException r3, Locator r4) {
        a(new Locator[]{(Locator) ZeusTransformUtils.wrapperContextForParams(r4, Locator.class, "com.obric.memorydata.plugin")}, r3.getMessage(), r3);
    }

    public void a(SAXException r4, Locator r5) {
        Locator r6 = (Locator) ZeusTransformUtils.wrapperContextForParams(r5, Locator.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4.getException(), RuntimeException.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, SAXParseException.class) == false) goto L7;
        error((SAXParseException) ZeusTransformUtils.preCheckCast(r4, SAXParseException.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        a(new Locator[]{r6}, r4.getMessage(), r4);
        return;
    L10:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r4.getException(), RuntimeException.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.e
    public void a(Locator[] r1, String r2) {
        this.f3600a.a(r1, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.e
    public void a(Locator[] r1, String r2, Exception r3) {
        a();
        this.f3600a.a(r1, r2, r3);
    }

    public Locator[] a(SAXParseException r2) {
        LocatorImpl r1 = new LocatorImpl();
        r1.setColumnNumber(r2.getColumnNumber());
        r1.setLineNumber(r2.getLineNumber());
        r1.setSystemId(r2.getSystemId());
        r1.setPublicId(r2.getPublicId());
        return new Locator[]{r1};
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException r3) {
        a(a(r3), r3.getMessage(), r3.getException());
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException r1) {
        error(r1);
    }

    @Override // org.xml.sax.EntityResolver
    @Deprecated
    public InputSource resolveEntity(String r1, String r2) {
        return this.f3600a.resolveEntity(r1, r2);
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException r2) {
        a(a(r2), r2.getMessage());
    }
}
