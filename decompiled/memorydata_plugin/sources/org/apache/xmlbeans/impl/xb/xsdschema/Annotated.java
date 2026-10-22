package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface Annotated extends OpenAttrs {
    public static final DocumentFactory<Annotated> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<Annotated> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "annotateda52dtype");
        Factory = r0;
        type = r0.getType();
    }

    AnnotationDocument.Annotation getAnnotation();
}
