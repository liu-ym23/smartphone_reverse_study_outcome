package org.apache.xmlbeans.impl.xb.xmlconfig;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface NamespacePrefixList extends XmlAnySimpleType {
    public static final SimpleTypeFactory<NamespacePrefixList> Factory = null;
    public static final SchemaType type = null;

    static {
        SimpleTypeFactory<NamespacePrefixList> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "namespaceprefixlistec0ctype");
        Factory = r0;
        type = r0.getType();
    }
}
