package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaGlobalAttribute;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaGlobalAttributeImpl extends SchemaLocalAttributeImpl implements SchemaGlobalAttribute {
    SchemaContainer _container;
    String _filename;
    private SchemaGlobalAttribute.Ref _selfref;

    public SchemaGlobalAttributeImpl(SchemaContainer r2) {
        this._selfref = new SchemaGlobalAttribute.Ref(this);
        this._container = r2;
    }

    public void setFilename(String r1) {
        this._filename = r1;
    }
}
