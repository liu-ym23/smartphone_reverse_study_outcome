package org.apache.xmlbeans;

import java.math.BigInteger;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlInteger extends XmlDecimal {
    public static final XmlObjectFactory<XmlInteger> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlInteger> r0 = new XmlObjectFactory("_BI_integer");
        Factory = r0;
        type = r0.getType();
    }

    BigInteger getBigIntegerValue();
}
