package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface All extends ExplicitGroup {
    public static final DocumentFactory<All> Factory = null;
    public static final SchemaType type = null;

    public interface MaxOccurs extends AllNNI {
    }

    public interface MinOccurs extends XmlNonNegativeInteger {
    }

    static {
        DocumentFactory<All> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "all3c04type");
        Factory = r0;
        type = r0.getType();
    }
}
