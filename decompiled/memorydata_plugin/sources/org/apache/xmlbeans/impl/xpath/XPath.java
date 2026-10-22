package org.apache.xmlbeans.impl.xpath;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: loaded from: classes7.dex */
public class XPath {
    private final boolean _sawDeepDot;
    final Selector _selector;

    static final class Selector {
        final XPathStep[] _paths;

        Selector(XPathStep[] r1) {
            this._paths = r1;
        }
    }

    public static class XPathCompileException extends XmlException {
        XPathCompileException(XmlError r3) {
            super(r3.toString(), null, r3);
        }
    }

    XPath(Selector r1, boolean r2) {
        this._selector = r1;
        this._sawDeepDot = r2;
    }

    public static XPath compileXPath(String r2, String r3, Map<String, String> r4) {
        return new XPathCompilationContext((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), r3).compile(r2);
    }

    public static XPath compileXPath(String r2, Map<String, String> r3) {
        return compileXPath(r2, "$this", (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public boolean sawDeepDot() {
        return this._sawDeepDot;
    }
}
