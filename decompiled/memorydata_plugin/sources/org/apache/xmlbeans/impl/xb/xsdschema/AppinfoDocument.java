package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface AppinfoDocument extends XmlObject {
    public static final DocumentFactory<AppinfoDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Appinfo extends XmlObject {
        public static final ElementFactory<Appinfo> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Appinfo> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "appinfo650belemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<AppinfoDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "appinfo2ea6doctype");
        Factory = r0;
        type = r0.getType();
    }
}
