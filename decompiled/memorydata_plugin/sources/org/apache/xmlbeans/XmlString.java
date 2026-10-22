package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlString extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlString> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlString> r0 = new XmlObjectFactory("_BI_string");
        Factory = r0;
        type = r0.getType();
    }
}
