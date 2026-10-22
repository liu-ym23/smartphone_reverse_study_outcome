package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentFactory<T> extends AbstractDocumentFactory<T> {
    public DocumentFactory(SchemaTypeSystem r3, String r4) {
        super((SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance() {
        return (T) getTypeLoader().newInstance(getType(), null);
    }

    @Override // org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance(XmlOptions r2) {
        return (T) getTypeLoader().newInstance(getType(), r2);
    }
}
