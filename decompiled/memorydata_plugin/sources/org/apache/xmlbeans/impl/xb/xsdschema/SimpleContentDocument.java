package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface SimpleContentDocument extends XmlObject {
    public static final DocumentFactory<SimpleContentDocument> Factory = null;
    public static final SchemaType type = null;

    public interface SimpleContent extends Annotated {
        public static final ElementFactory<SimpleContent> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<SimpleContent> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "simplecontent9a5belemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<SimpleContentDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "simplecontent8acedoctype");
        Factory = r0;
        type = r0.getType();
    }
}
