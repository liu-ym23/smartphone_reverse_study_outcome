package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlInt extends XmlLong {
    public static final XmlObjectFactory<XmlInt> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlInt> r0 = new XmlObjectFactory("_BI_int");
        Factory = r0;
        type = r0.getType();
    }
}
