package org.apache.poi.ooxml.util;

import com.microsoft.schemas.compatibility.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFactory;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;

/* JADX INFO: loaded from: classes7.dex */
public final class XPathHelper {
    private static final QName ALTERNATE_CONTENT_TAG = null;
    private static final c LOG = null;
    static final XPathFactory xpathFactory = null;

    static {
        LOG = b.a(XPathHelper.class);
        ALTERNATE_CONTENT_TAG = new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "AlternateContent");
        XPathFactory r0 = XPathFactory.newInstance();
        xpathFactory = r0;
        trySetFeature(r0, "http://javax.xml.XMLConstants/feature/secure-processing", true);
    }

    private XPathHelper() {
    }

    private static XmlCursor selectProperty(XmlCursor r8, QName[][] r9, int r10, boolean r11, boolean r12) {
        XmlCursor r13 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r8, XmlCursor.class, "com.obric.memorydata.plugin");
        QName[] r0 = r9[r10];
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L16;
        QName r6 = r0[r4];
        boolean r7 = r13.toChild(r6);
    L6:
        if (r7 == false) goto L14;
        if (r10 == (r9.length - 1)) goto L9;
        r13.push();
        XmlCursor r14 = selectProperty(r13, r9, r10 + 1, r11, false);
        if (r14 != null) goto L12;
        r13.pop();
        r7 = r13.toNextSibling(r6);
        goto L6
    L12:
        return r14;
    L9:
        return r13;
    L14:
        r4 = r4 + 1;
        goto L4
    L16:
        if (r12 == false) goto L18;
    L67:
        return null;
    L18:
        if (r13.toChild(ALTERNATE_CONTENT_TAG) == false) goto L67;
        XmlObject r15 = r13.getObject();
        if (ZeusTransformUtils.instanceOf(r15, a.InterfaceC0224a.class) == false) goto L23;
        a.InterfaceC0224a r16 = (a.InterfaceC0224a) ZeusTransformUtils.preCheckCast(r15, a.InterfaceC0224a.class, "com.obric.memorydata.plugin");
    L25:
        int r17 = r16.sizeOfChoiceArray();
    L26:
        if (r3 >= r17) goto L51;
        a.InterfaceC0224a.InterfaceC0225a r1 = r16.getChoiceArray(r3);
        XmlCursor r5 = r1.newCursor();
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r5 != null) goto L68;
    L49:
        throw th;
    L68:
        r5.close();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.addSuppressed(th);
        goto L49
    L29:
        if ("http://schemas.microsoft.com/office/mac/drawingml/2008/main".equalsIgnoreCase(r5.namespaceForPrefix(r1.getRequires())) == false) goto L32;
        if (r5 == null) goto L40;
    L31:
        r5.close();
    L40:
        r3 = r3 + 1;
        goto L26
    L32:
        XmlCursor r18 = selectProperty(r5, r9, r10, r11, true);     // Catch: Throwable -> L41
        if (r18 == null) goto L38;
        if (r18 == r5) goto L38;
        if (r5 == null) goto L37;
        r5.close();
    L37:
        return r18;
    L38:
        if (r5 == null) goto L40;
    L51:
        if (r16.isSetFallback() == true) goto L53;
        return null;
    L53:
        XmlCursor r19 = r16.getFallback().newCursor();
        XmlCursor r20 = selectProperty(r19, r9, r10, r11, true);     // Catch: Throwable -> L58
        if (r20 == r19) goto L57;
        r19.close();
    L57:
        return r20;
    L58:
        th = move-exception;
        if (r19 == null) goto L61;
        r19.close();
    L61:
        throw th;
    L23:
        if (r11 == false) goto L66;
        r16 = ((a) ZeusTransformUtils.preCheckCast(a.f5657a.parse(r13.newXMLStreamReader()), a.class, "com.obric.memorydata.plugin")).getAlternateContent();     // Catch: XmlException -> L62
    L62:
        e = move-exception;
        throw new XmlException("unable to parse AlternateContent element", e);
    L66:
        throw new XmlException("Schemas (*.xsb) for <CLASS> can't be loaded - usually this happens when OSGI loading is used and the thread context classloader has no reference to the xmlbeans classes - please either verify if the <XSB>.xsb is on the classpath or alternatively try to use the poi-ooxml-full-x.x.jar".replace("<CLASS>", "AlternateContent").replace("<XSB>", "alternatecontentelement"));
    }

    public static <T extends XmlObject> T selectProperty(XmlObject r4, Class<T> r5, XSLFShape.ReparseFactory<T> r6, QName[]... r7) {
        XmlObject r8 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        XSLFShape.ReparseFactory r9 = (XSLFShape.ReparseFactory) ZeusTransformUtils.wrapperContextForParams(r6, XSLFShape.ReparseFactory.class, "com.obric.memorydata.plugin");
        XmlCursor r10 = r8.newCursor();
        if (r9 == null) goto L5;
        boolean r1 = true;
    L44:
        XmlCursor r11 = selectProperty(r10, r7, 0, r1, false);     // Catch: Throwable -> L35
        if (r11 == null) goto L9;
        T r0 = (T) r11.getObject();
        if (ZeusTransformUtils.instanceOf(r0, XmlAnyTypeImpl.class) == false) goto L21;
        String r12 = "Schemas (*.xsb) for <CLASS> can't be loaded - usually this happens when OSGI loading is used and the thread context classloader has no reference to the xmlbeans classes - please either verify if the <XSB>.xsb is on the classpath or alternatively try to use the poi-ooxml-full-x.x.jar".replace("<CLASS>", r5.getSimpleName()).replace("<XSB>", r5.getSimpleName().toLowerCase(Locale.ROOT) + "*");     // Catch: Throwable -> L26
        if (r9 == null) goto L20;
        r0 = (T) r9.parse(r11.newXMLStreamReader());
        goto L21
    L20:
        throw new XmlException(r12);     // Catch: Throwable -> L26
    L21:
        if (r11 == null) goto L23;
        r11.close();     // Catch: Throwable -> L35
    L23:
        if (r10 == null) goto L25;
        r10.close();
    L25:
        return r0;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r11 != null) goto L52;
    L34:
        throw th;     // Catch: Throwable -> L35
    L52:
        r11.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L35
        goto L34
    L9:
        if (r11 == null) goto L11;
        r11.close();     // Catch: Throwable -> L35
    L11:
        if (r10 == null) goto L13;
        r10.close();
    L13:
        return null;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r10 != null) goto L50;
    L43:
        throw th;
    L50:
        r10.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.addSuppressed(th);
        goto L43
    L5:
        r1 = false;
        goto L44
    }

    private static void trySetFeature(XPathFactory r0, String r1, boolean r2) {
        r0.setFeature(r1, r2);     // Catch: AbstractMethodError -> L4 Exception -> L6
    L12:
        return;
    L4:
        e = move-exception;
        org.apache.logging.log4j.a r3 = LOG.atWarn().a(e);
        String r4 = "Cannot set XPathFactory feature ({}) because outdated XML parser in classpath";
    L8:
        r3.a(r4, r1);
        return;
    L6:
        e = move-exception;
        r3 = LOG.atWarn().a(e);
        r4 = "XPathFactory Feature ({}) unsupported";
        goto L8
    }
}
