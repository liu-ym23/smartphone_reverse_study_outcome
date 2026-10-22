package org.apache.poi.ooxml;

import com.bytedance.rpc.internal.RpcUtils;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Collections;
import java.util.HashMap;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: classes7.dex */
public class POIXMLTypeLoader {
    public static final XmlOptions DEFAULT_XML_OPTIONS = null;

    static {
        XmlOptions r0 = new XmlOptions();
        DEFAULT_XML_OPTIONS = r0;
        r0.setSaveOuter();
        r0.setUseDefaultNamespace();
        r0.setSaveAggressiveNamespaces();
        r0.setCharacterEncoding(RpcUtils.CHARSET_UTF8);
        r0.setDisallowDocTypeDeclaration(true);
        r0.setEntityExpansionLimit(1);
        HashMap r1 = new HashMap();
        r1.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");
        r1.put("http://schemas.openxmlformats.org/drawingml/2006/chart", "c");
        r1.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
        r1.put("http://schemas.openxmlformats.org/markup-compatibility/2006", "ve");
        r1.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
        r1.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "r");
        r1.put("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vt");
        r1.put("http://schemas.openxmlformats.org/presentationml/2006/main", "p");
        r1.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        r1.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
        r1.put("urn:schemas-microsoft-com:office:office", "o");
        r1.put("urn:schemas-microsoft-com:office:excel", "x");
        r1.put("urn:schemas-microsoft-com:office:word", "w10");
        r1.put("urn:schemas-microsoft-com:vml", BaseSwitches.V);
        r0.setSaveSuggestedPrefixes(Collections.unmodifiableMap(r1));
    }
}
