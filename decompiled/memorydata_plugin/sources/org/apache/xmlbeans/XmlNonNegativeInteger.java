package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlNonNegativeInteger extends XmlInteger {
    public static final XmlObjectFactory<XmlNonNegativeInteger> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlNonNegativeInteger> r0 = new XmlObjectFactory("_BI_nonNegativeInteger");
        Factory = r0;
        type = r0.getType();
    }
}
