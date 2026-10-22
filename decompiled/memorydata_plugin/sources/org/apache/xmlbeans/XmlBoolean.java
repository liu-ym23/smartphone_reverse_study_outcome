package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlBoolean extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlBoolean> Factory = null;
    public static final SchemaType type = null;

    static {
        Factory = new XmlObjectFactory("_BI_boolean");
        type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_boolean");
    }

    boolean getBooleanValue();
}
