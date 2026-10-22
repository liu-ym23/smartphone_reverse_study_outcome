package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlDecimal extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlDecimal> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlDecimal> r0 = new XmlObjectFactory("_BI_decimal");
        Factory = r0;
        type = r0.getType();
    }
}
