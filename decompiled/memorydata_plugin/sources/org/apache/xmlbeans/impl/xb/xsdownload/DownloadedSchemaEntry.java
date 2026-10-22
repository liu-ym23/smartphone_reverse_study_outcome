package org.apache.xmlbeans.impl.xb.xsdownload;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface DownloadedSchemaEntry extends XmlObject {
    public static final DocumentFactory<DownloadedSchemaEntry> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<DownloadedSchemaEntry> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "downloadedschemaentry1c75type");
        Factory = r0;
        type = r0.getType();
    }
}
