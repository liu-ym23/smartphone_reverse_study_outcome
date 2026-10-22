package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlDateTime extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlDateTime> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlDateTime> r0 = new XmlObjectFactory("_BI_dateTime");
        Factory = r0;
        type = r0.getType();
    }
}
