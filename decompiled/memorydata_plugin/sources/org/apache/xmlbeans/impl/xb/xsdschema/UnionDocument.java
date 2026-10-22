package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface UnionDocument extends XmlObject {
    public static final DocumentFactory<UnionDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Union extends Annotated {
        public static final ElementFactory<Union> Factory = null;
        public static final SchemaType type = null;

        public interface MemberTypes extends XmlAnySimpleType {
            public static final ElementFactory<MemberTypes> Factory = null;
            public static final SchemaType type = null;

            static {
                ElementFactory<MemberTypes> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "membertypes2404attrtype");
                Factory = r0;
                type = r0.getType();
            }
        }

        static {
            ElementFactory<Union> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "union498belemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<UnionDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "union5866doctype");
        Factory = r0;
        type = r0.getType();
    }
}
