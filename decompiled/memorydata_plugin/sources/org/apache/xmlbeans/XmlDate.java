package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlDate extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlDate> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlDate> r0 = new XmlObjectFactory("_BI_date");
        Factory = r0;
        type = r0.getType();
    }
}
