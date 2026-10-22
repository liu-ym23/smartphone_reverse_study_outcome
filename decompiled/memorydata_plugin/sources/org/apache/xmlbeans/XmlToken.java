package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlToken extends XmlNormalizedString {
    public static final XmlObjectFactory<XmlToken> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlToken> r0 = new XmlObjectFactory("_BI_token");
        Factory = r0;
        type = r0.getType();
    }
}
