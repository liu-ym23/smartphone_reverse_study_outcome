package org.apache.xmlbeans.impl.xb.xmlconfig;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface Extensionconfig extends XmlObject {
    public static final DocumentFactory<Extensionconfig> Factory = null;
    public static final SchemaType type = null;

    public interface Interface extends XmlObject {
        public static final ElementFactory<Interface> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Interface> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "interface02a7elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    public interface PrePostSet extends XmlObject {
        public static final ElementFactory<PrePostSet> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<PrePostSet> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "prepostset5c9delemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<Extensionconfig> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "extensionconfig2ac2type");
        Factory = r0;
        type = r0.getType();
    }
}
