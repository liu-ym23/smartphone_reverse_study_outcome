package org.apache.xmlbeans.impl.xb.xmlconfig;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface ConfigDocument extends XmlObject {
    public static final DocumentFactory<ConfigDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Config extends XmlObject {
        public static final ElementFactory<Config> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Config> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "configf467elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<ConfigDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "config4185doctype");
        Factory = r0;
        type = r0.getType();
    }
}
