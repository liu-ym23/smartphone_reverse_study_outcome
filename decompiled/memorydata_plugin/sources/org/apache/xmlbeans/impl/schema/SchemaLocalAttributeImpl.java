package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaLocalAttributeImpl implements SchemaLocalAttribute {
    private SchemaAnnotation _annotation;
    private String _defaultText;
    XmlValueRef _defaultValue;
    private boolean _isDefault;
    private boolean _isFixed;
    protected XmlObject _parseObject;
    private SchemaType.Ref _typeref;
    private int _use;
    private Object _userData;
    private SOAPArrayType _wsdlArrayType;
    private QName _xmlName;

    public SchemaLocalAttributeImpl() {
    }

    @Override // org.apache.xmlbeans.SchemaField
    public String getDefaultText() {
        return this._defaultText;
    }

    @Override // org.apache.xmlbeans.SchemaField
    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef r0 = this._defaultValue;
        if (r0 == null) goto L7;
        return r0.get();
    L7:
        if (this._defaultText != null) goto L9;
        return null;
    L9:
        if (XmlAnySimpleType.type.isAssignableFrom(getType()) == true) goto L11;
        return null;
    L11:
        if (this._parseObject == null) goto L19;
        NamespaceContext.push(new NamespaceContext(this._parseObject));     // Catch: Throwable -> L15
        XmlAnySimpleType r2 = getType().newValue(this._defaultText);     // Catch: Throwable -> L15
        NamespaceContext.pop();
        return r2;
    L15:
        th = move-exception;
        NamespaceContext.pop();
        throw th;
    L19:
        return getType().newValue(this._defaultText);
    }

    @Override // org.apache.xmlbeans.SchemaField
    public QName getName() {
        return this._xmlName;
    }

    @Override // org.apache.xmlbeans.SchemaField
    public SchemaType getType() {
        return this._typeref.get();
    }

    @Override // org.apache.xmlbeans.SchemaLocalAttribute
    public int getUse() {
        return this._use;
    }

    public void init(QName r3, SchemaType.Ref r4, int r5, String r6, XmlObject r7, XmlValueRef r8, boolean r9, SOAPArrayType r10, SchemaAnnotation r11, Object r12) {
        XmlObject r13 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r7, XmlObject.class, "com.obric.memorydata.plugin");
        SchemaAnnotation r14 = (SchemaAnnotation) ZeusTransformUtils.wrapperContextForParams(r11, SchemaAnnotation.class, "com.obric.memorydata.plugin");
        if (this._xmlName != null) goto L13;
        if (this._typeref != null) goto L13;
        this._use = r5;
        this._typeref = r4;
        this._defaultText = r6;
        this._parseObject = r13;
        this._defaultValue = r8;
        if (r6 == null) goto L9;
        boolean r15 = true;
    L10:
        this._isDefault = r15;
        this._isFixed = r9;
        this._xmlName = r3;
        this._wsdlArrayType = r10;
        this._annotation = r14;
        this._userData = r12;
        return;
    L9:
        r15 = false;
    L13:
        throw new IllegalStateException("Already initialized");
    }

    @Override // org.apache.xmlbeans.SchemaField
    public boolean isAttribute() {
        return true;
    }

    @Override // org.apache.xmlbeans.SchemaField
    public boolean isDefault() {
        return this._isDefault;
    }

    @Override // org.apache.xmlbeans.SchemaField
    public boolean isFixed() {
        return this._isFixed;
    }

    @Override // org.apache.xmlbeans.SchemaField
    public boolean isNillable() {
        return false;
    }
}
