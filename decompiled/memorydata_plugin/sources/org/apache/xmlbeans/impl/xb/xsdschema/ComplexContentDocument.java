package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface ComplexContentDocument extends XmlObject {
    public static final DocumentFactory<ComplexContentDocument> Factory = null;
    public static final SchemaType type = null;

    public interface ComplexContent extends Annotated {
        public static final ElementFactory<ComplexContent> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<ComplexContent> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "complexcontentaa7felemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<ComplexContentDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "complexcontentc57adoctype");
        Factory = r0;
        type = r0.getType();
    }
}
