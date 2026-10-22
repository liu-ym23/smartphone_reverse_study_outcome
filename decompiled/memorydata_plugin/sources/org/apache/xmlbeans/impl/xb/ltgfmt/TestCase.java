package org.apache.xmlbeans.impl.xb.ltgfmt;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface TestCase extends XmlObject {
    public static final DocumentFactory<TestCase> Factory = null;
    public static final SchemaType type = null;

    public interface Files extends XmlObject {
        public static final ElementFactory<Files> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Files> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "files7c3eelemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<TestCase> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "testcase939btype");
        Factory = r0;
        type = r0.getType();
    }
}
