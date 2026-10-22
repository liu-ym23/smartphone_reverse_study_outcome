package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface ListDocument extends XmlObject {
    public static final DocumentFactory<ListDocument> Factory = null;
    public static final SchemaType type = null;

    public interface List extends Annotated {
        public static final ElementFactory<List> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<List> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "list391felemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<ListDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "listcde5doctype");
        Factory = r0;
        type = r0.getType();
    }
}
