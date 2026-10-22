package org.apache.xmlbeans.impl.schema;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaAnnotationImpl implements SchemaAnnotation {
    private String[] _appInfoAsXml;
    private SchemaAnnotation.Attribute[] _attributes;
    private SchemaContainer _container;
    private String[] _documentationAsXml;

    static class AttributeImpl implements SchemaAnnotation.Attribute {
        private QName _name;
        private String _value;
        private String _valueUri;

        AttributeImpl(QName r1, String r2, String r3) {
            this._name = r1;
            this._value = r2;
            this._valueUri = r3;
        }
    }

    SchemaAnnotationImpl(SchemaContainer r1, String[] r2, String[] r3, SchemaAnnotation.Attribute[] r4) {
        this._container = r1;
        this._appInfoAsXml = r2;
        this._documentationAsXml = r3;
        this._attributes = r4;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return null;
    }
}
