package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaPropertyImpl implements SchemaProperty {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Set<QName> _acceptedNames;
    private SchemaType.Ref _containerTypeRef;
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private boolean _extendsArray;
    private boolean _extendsOption;
    private boolean _extendsSingleton;
    private int _hasDefault;
    private int _hasFixed;
    private int _hasNillable;
    private boolean _isAttribute;
    private boolean _isImmutable;
    private SchemaType.Ref _javaBasedOnTypeRef;
    private String _javaPropertyName;
    private QNameSet _javaSetterDelimiter;
    private int _javaTypeCode;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    private QName _name;
    private SchemaType.Ref _typeref;

    static {
    }

    public SchemaPropertyImpl() {
    }

    private void mutate() {
        if (this._isImmutable == true) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QName[] acceptedNames() {
        Set<QName> r0 = this._acceptedNames;
        if (r0 != null) goto L6;
        return new QName[]{this._name};
    L6:
        return (QName[]) ZeusTransformUtils.preCheckCast(r0.toArray(new QName[0]), QName[].class, "com.obric.memorydata.plugin");
    }

    public SchemaType getContainerType() {
        return this._containerTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public String getDefaultText() {
        return this._defaultText;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QNameSet getJavaSetterDelimiter() {
        if (this._isAttribute == false) goto L7;
        return QNameSet.EMPTY;
    L7:
        if (this._javaSetterDelimiter != null) goto L10;
        ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(getContainerType(), SchemaTypeImpl.class, "com.obric.memorydata.plugin")).assignJavaElementSetterModel();
    L10:
        return this._javaSetterDelimiter;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public BigInteger getMinOccurs() {
        return this._minOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public SchemaType getType() {
        return this._typeref.get();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasDefault() {
        return this._hasDefault;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasFixed() {
        return this._hasFixed;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasNillable() {
        return this._hasNillable;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean isAttribute() {
        return this._isAttribute;
    }

    public void setAcceptedNames(Set<QName> r3) {
        Set<QName> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        mutate();
        this._acceptedNames = r4;
    }

    public void setAttribute(boolean r1) {
        mutate();
        this._isAttribute = r1;
    }

    public void setContainerTypeRef(SchemaType.Ref r1) {
        mutate();
        this._containerTypeRef = r1;
    }

    public void setDefault(int r1) {
        mutate();
        this._hasDefault = r1;
    }

    public void setDefaultText(String r1) {
        mutate();
        this._defaultText = r1;
    }

    public void setDefaultValue(XmlValueRef r1) {
        mutate();
        this._defaultValue = r1;
    }

    public void setExtendsJava(SchemaType.Ref r1, boolean r2, boolean r3, boolean r4) {
        mutate();
        this._javaBasedOnTypeRef = r1;
        this._extendsSingleton = r2;
        this._extendsOption = r3;
        this._extendsArray = r4;
    }

    public void setFixed(int r1) {
        mutate();
        this._hasFixed = r1;
    }

    public void setImmutable() {
        mutate();
        this._isImmutable = true;
    }

    public void setJavaPropertyName(String r1) {
        mutate();
        this._javaPropertyName = r1;
    }

    void setJavaSetterDelimiter(QNameSet r1) {
        this._javaSetterDelimiter = r1;
    }

    public void setJavaTypeCode(int r1) {
        mutate();
        this._javaTypeCode = r1;
    }

    public void setMaxOccurs(BigInteger r1) {
        mutate();
        this._maxOccurs = r1;
    }

    public void setMinOccurs(BigInteger r1) {
        mutate();
        this._minOccurs = r1;
    }

    public void setName(QName r1) {
        mutate();
        this._name = r1;
    }

    public void setNillable(int r1) {
        mutate();
        this._hasNillable = r1;
    }

    public void setTypeRef(SchemaType.Ref r1) {
        mutate();
        this._typeref = r1;
    }
}
