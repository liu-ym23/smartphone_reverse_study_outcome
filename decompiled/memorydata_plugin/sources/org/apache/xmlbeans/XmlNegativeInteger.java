package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlNegativeInteger extends XmlNonPositiveInteger {
    public static final XmlObjectFactory<XmlNegativeInteger> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlNegativeInteger> r0 = new XmlObjectFactory("_BI_negativeInteger");
        Factory = r0;
        type = r0.getType();
    }
}
