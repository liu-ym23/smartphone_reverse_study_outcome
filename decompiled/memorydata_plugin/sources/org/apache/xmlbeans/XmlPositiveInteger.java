package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlPositiveInteger extends XmlNonNegativeInteger {
    public static final XmlObjectFactory<XmlPositiveInteger> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlPositiveInteger> r0 = new XmlObjectFactory("_BI_positiveInteger");
        Factory = r0;
        type = r0.getType();
    }
}
