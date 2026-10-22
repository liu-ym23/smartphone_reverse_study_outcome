package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlNonPositiveInteger extends XmlInteger {
    public static final XmlObjectFactory<XmlNonPositiveInteger> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlNonPositiveInteger> r0 = new XmlObjectFactory("_BI_nonPositiveInteger");
        Factory = r0;
        type = r0.getType();
    }
}
