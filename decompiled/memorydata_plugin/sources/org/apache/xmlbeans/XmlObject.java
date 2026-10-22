package org.apache.xmlbeans;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlObject extends XmlTokenSource {
    public static final XmlObjectFactory<XmlObject> Factory = null;
    public static final SchemaType type = null;

    static {
        XmlObjectFactory<XmlObject> r0 = new XmlObjectFactory("_BI_anyType");
        Factory = r0;
        type = r0.getType();
    }

    int compareTo(Object r1);

    XmlObject copy();

    boolean isImmutable();

    boolean isNil();

    SchemaType schemaType();

    XmlObject[] selectChildren(QName r1);

    XmlObject[] selectPath(String r1);

    XmlObject set(XmlObject r1);

    String toString();

    boolean valueEquals(XmlObject r1);

    int valueHashCode();
}
