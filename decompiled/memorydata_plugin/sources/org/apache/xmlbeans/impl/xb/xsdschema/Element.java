package org.apache.xmlbeans.impl.xb.xsdschema;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface Element extends Annotated {
    public static final AbstractDocumentFactory<Element> Factory = null;
    public static final SchemaType type = null;

    static {
        AbstractDocumentFactory<Element> r0 = new AbstractDocumentFactory(TypeSystemHolder.typeSystem, "elementd189type");
        Factory = r0;
        type = r0.getType();
    }

    QName getType();
}
