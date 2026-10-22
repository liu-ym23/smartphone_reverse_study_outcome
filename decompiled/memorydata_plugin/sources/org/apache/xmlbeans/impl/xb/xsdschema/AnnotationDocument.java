package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface AnnotationDocument extends XmlObject {
    public static final DocumentFactory<AnnotationDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Annotation extends OpenAttrs {
        public static final ElementFactory<Annotation> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Annotation> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "annotation5abfelemtype");
            Factory = r0;
            type = r0.getType();
        }

        DocumentationDocument.Documentation[] getDocumentationArray();
    }

    static {
        DocumentFactory<AnnotationDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "annotationb034doctype");
        Factory = r0;
        type = r0.getType();
    }
}
