package org.apache.xmlbeans;

import java.util.List;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlIDREFS extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlIDREFS> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlIDREFS> r0 = new XmlObjectFactory("_BI_IDREFS");
        Factory = r0;
        type = r0.getType();
    }

    List<? extends XmlAnySimpleType> xgetListValue();
}
