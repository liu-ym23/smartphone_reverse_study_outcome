package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaModelGroupImpl implements SchemaModelGroup {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private String _attFormDefault;
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _elemFormDefault;
    private String _filename;
    private QName _name;
    private XmlObject _parseObject;
    private String _parseTNS;
    private boolean _redefinition;
    private SchemaModelGroup.Ref _selfref;
    private Object _userData;

    static {
    }

    public SchemaModelGroupImpl(SchemaContainer r2) {
        this._selfref = new SchemaModelGroup.Ref(this);
        this._container = r2;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    public void init(QName r3, String r4, boolean r5, String r6, String r7, boolean r8, XmlObject r9, SchemaAnnotation r10, Object r11) {
        XmlObject r12 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r9, XmlObject.class, "com.obric.memorydata.plugin");
        SchemaAnnotation r13 = (SchemaAnnotation) ZeusTransformUtils.wrapperContextForParams(r10, SchemaAnnotation.class, "com.obric.memorydata.plugin");
        this._name = r3;
        this._parseTNS = r4;
        this._chameleon = r5;
        this._elemFormDefault = r6;
        this._attFormDefault = r7;
        this._redefinition = r8;
        this._parseObject = r12;
        this._annotation = r13;
        this._userData = r11;
    }

    public void setFilename(String r1) {
        this._filename = r1;
    }
}
