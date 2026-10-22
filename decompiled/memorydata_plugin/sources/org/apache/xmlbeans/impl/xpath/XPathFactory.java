package org.apache.xmlbeans.impl.xpath;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.xpath.saxon.SaxonXPath;
import org.apache.xmlbeans.impl.xpath.saxon.SaxonXQuery;
import org.apache.xmlbeans.impl.xpath.xmlbeans.XmlbeansXPath;

/* JADX INFO: loaded from: classes7.dex */
public class XPathFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<String, WeakReference<Path>> _xmlbeansPathCache = null;
    private static final ReentrantReadWriteLock lock = null;

    static {
        _xmlbeansPathCache = new WeakHashMap();
        lock = new ReentrantReadWriteLock();
    }

    public XPathFactory() {
    }

    public static Path getCompiledPath(String r1, XmlOptions r2) {
        XmlOptions r3 = XmlOptions.maskNull(r2);
        return getCompiledPath(r1, r3, getCurrentNodeVar(r3));
    }

    public static Path getCompiledPath(String r7, XmlOptions r8, String r9) {
        if (r8.isXPathUseSaxon() == false) goto L6;
        char r10 = 4;
    L9:
        int r0 = r10 & 4;
        Path r2 = null;
        if (r0 == 0) goto L12;
        HashMap r3 = new HashMap();
    L13:
        ReentrantReadWriteLock r4 = lock;
        r4.readLock().lock();
        int r11 = r10 & 1;
        if (r11 != 0) goto L53;
        WeakReference r5 = null;
    L19:
        if (r5 == null) goto L24;
        r2 = (Path) ZeusTransformUtils.preCheckCast(r5.get(), Path.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        lock.readLock().unlock();
        throw th;
    L24:
        if (r2 == null) goto L27;
        r4.readLock().unlock();
        return r2;
    L27:
        r4.readLock().unlock();
        r4.writeLock().lock();
        if (r11 != 0) goto L51;
    L36:
        if (r2 != null) goto L39;
        if (r0 == 0) goto L39;
        r2 = getCompiledPathSaxon(r7, r9, r3);     // Catch: Throwable -> L34
    L39:
        if (r2 != null) goto L49;
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L34
        if (r11 == 0) goto L43;
        r12.append(" Trying XmlBeans path engine...");     // Catch: Throwable -> L34
    L43:
        if (r0 == 0) goto L46;
        r12.append(" Trying Saxon path engine...");     // Catch: Throwable -> L34
    L46:
        throw new RuntimeException(r12.toString() + " FAILED on " + r7);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        lock.writeLock().unlock();
        throw th;
    L49:
        r4.writeLock().unlock();
        return r2;
    L51:
        WeakReference r6 = (WeakReference) ZeusTransformUtils.preCheckCast(_xmlbeansPathCache.get(r7), WeakReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r6 == null) goto L32;
        r2 = (Path) ZeusTransformUtils.preCheckCast(r6.get(), Path.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
    L32:
        if (r2 != null) goto L36;
        r2 = getCompiledPathXmlBeans(r7, r9, r3);     // Catch: Throwable -> L34
        goto L36
    L53:
        r5 = (WeakReference) ZeusTransformUtils.preCheckCast(_xmlbeansPathCache.get(r7), WeakReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        goto L19
    L12:
        r3 = null;
        goto L13
    L6:
        if (r8.isXPathUseXmlBeans() == false) goto L8;
        r10 = 1;
        goto L9
    L8:
        r10 = 5;
        goto L9
    }

    public static Path getCompiledPathSaxon(String r4, String r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L9;
        r7 = new HashMap();
    L9:
        XPath.compileXPath(r4, r5, r7);     // Catch: XPath.XPathCompileException -> L8
    L6:
        int r1 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r7.getOrDefault("$xmlbeans!ns_boundary", "0"), String.class, "com.obric.memorydata.plugin"));
        r7.remove("$xmlbeans!ns_boundary");
        return new SaxonXPath(r4.substring(r1), r5, r7);
    }

    private static Path getCompiledPathXmlBeans(String r2, String r3, Map<String, String> r4) {
        XmlbeansXPath r0 = new XmlbeansXPath(r2, r3, XPath.compileXPath(r2, r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")));     // Catch: XPath.XPathCompileException -> L5
        _xmlbeansPathCache.put(r2, new WeakReference(r0));     // Catch: XPath.XPathCompileException -> L5
        return r0;
    L5:
        return null;
    }

    static synchronized XQuery getCompiledQuery(String r4, String r5, XmlOptions r6) {
        monitor-enter(XPathFactory.class);
        XmlOptions r7 = XmlOptions.maskNull(r6);     // Catch: Throwable -> L15
        HashMap r1 = new HashMap();     // Catch: Throwable -> L15
        XPath.compileXPath(r4, r5, r1);     // Catch: Throwable -> L8 XPath.XPathCompileException -> L11
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getOrDefault("$xmlbeans!ns_boundary", "0"), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L12:
        SaxonXQuery r3 = new SaxonXQuery(r4, r5, Integer.valueOf(Integer.parseInt(r2)), r7);     // Catch: Throwable -> L15
        monitor-exit(XPathFactory.class);
        return r3;
    L11:
        r2 = (String) ZeusTransformUtils.preCheckCast(r1.getOrDefault("$xmlbeans!ns_boundary", "0"), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L8:
        th = move-exception;
        Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r1.getOrDefault("$xmlbeans!ns_boundary", "0"), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized XQuery getCompiledQuery(String r2, XmlOptions r3) {
        monitor-enter(XPathFactory.class);
        XQuery r4 = getCompiledQuery(r2, getCurrentNodeVar(r3), r3);     // Catch: Throwable -> L7
        monitor-exit(XPathFactory.class);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    static String getCurrentNodeVar(XmlOptions r1) {
        String r2 = XmlOptions.maskNull(r1).getXqueryCurrentNodeVar();
        if (r2 != null) goto L5;
        return "this";
    L5:
        if (r2.startsWith("$") == true) goto L8;
        return r2;
    L8:
        throw new IllegalArgumentException("Omit the '$' prefix for the current node variable");
    }

    public static XmlObject[] objectExecQuery(Cur r0, String r1, XmlOptions r2) {
        return getCompiledQuery(r1, r2).objectExecute(r0, r2);
    }
}
