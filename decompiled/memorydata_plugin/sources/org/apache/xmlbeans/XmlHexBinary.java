package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlHexBinary extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlHexBinary> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlHexBinary> r0 = new XmlObjectFactory("_BI_hexBinary");
        Factory = r0;
        type = r0.getType();
    }

    byte[] getByteArrayValue();
}
