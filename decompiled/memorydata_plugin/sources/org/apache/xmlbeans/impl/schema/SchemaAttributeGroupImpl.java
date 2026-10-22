package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaAttributeGroupImpl implements SchemaAttributeGroup {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _filename;
    private String _formDefault;
    private QName _name;
    private XmlObject _parseObject;
    private String _parseTNS;
    private boolean _redefinition;
    private SchemaAttributeGroup.Ref _selfref;
    private Object _userData;

    static {
    }

    public SchemaAttributeGroupImpl(SchemaContainer r2) {
        this._selfref = new SchemaAttributeGroup.Ref(this);
        this._container = r2;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    public void init(QName r3, String r4, boolean r5, String r6, boolean r7, XmlObject r8, SchemaAnnotation r9, Object r10) {
        XmlObject r11 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r8, XmlObject.class, "com.obric.memorydata.plugin");
        SchemaAnnotation r12 = (SchemaAnnotation) ZeusTransformUtils.wrapperContextForParams(r9, SchemaAnnotation.class, "com.obric.memorydata.plugin");
        this._name = r3;
        this._parseTNS = r4;
        this._chameleon = r5;
        this._formDefault = r6;
        this._redefinition = r7;
        this._parseObject = r11;
        this._annotation = r12;
        this._userData = r10;
    }

    public void setFilename(String r1) {
        this._filename = r1;
    }
}
