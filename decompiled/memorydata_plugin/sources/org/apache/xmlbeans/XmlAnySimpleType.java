package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlAnySimpleType extends XmlObject {
    public static final XmlObjectFactory<XmlAnySimpleType> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlAnySimpleType> r0 = new XmlObjectFactory("_BI_anySimpleType");
        Factory = r0;
        type = r0.getType();
    }

    String getStringValue();

    void setStringValue(String r1);
}
