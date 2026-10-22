package org.apache.xmlbeans.impl.xpath.xmlbeans;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.xpath.Path;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathFactory;

/* JADX INFO: loaded from: classes7.dex */
public class XmlbeansXPath implements Path {
    private final XPath _compiledPath;
    private final String _currentVar;
    private final String _pathKey;

    public XmlbeansXPath(String r1, String r2, XPath r3) {
        this._pathKey = r1;
        this._currentVar = r2;
        this._compiledPath = r3;
    }

    @Override // org.apache.xmlbeans.impl.xpath.Path
    public XPathEngine execute(Cur r3, XmlOptions r4) {
        XmlOptions r5 = XmlOptions.maskNull(r4);
        if (r3.isContainer() == false) goto L10;
        if (this._compiledPath.sawDeepDot() == true) goto L10;
        return new XmlbeansXPathEngine(this._compiledPath, r3);
    L10:
        return XPathFactory.getCompiledPathSaxon(this._pathKey, this._currentVar, null).execute(r3, r5);
    }
}
