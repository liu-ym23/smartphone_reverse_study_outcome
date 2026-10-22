package org.apache.xmlbeans.impl.xb.ltgfmt;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface TestsDocument extends XmlObject {
    public static final DocumentFactory<TestsDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Tests extends XmlObject {
        public static final ElementFactory<Tests> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Tests> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "tests9d6eelemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<TestsDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "tests5621doctype");
        Factory = r0;
        type = r0.getType();
    }
}
