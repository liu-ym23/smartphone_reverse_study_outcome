package org.apache.xmlbeans.impl.xb.xsdownload;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface DownloadedSchemasDocument extends XmlObject {
    public static final DocumentFactory<DownloadedSchemasDocument> Factory = null;
    public static final SchemaType type = null;

    public interface DownloadedSchemas extends XmlObject {
        public static final ElementFactory<DownloadedSchemas> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<DownloadedSchemas> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "downloadedschemasb3efelemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<DownloadedSchemasDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "downloadedschemas2dd7doctype");
        Factory = r0;
        type = r0.getType();
    }
}
