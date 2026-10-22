package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaParticleImpl implements SchemaParticle {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BigInteger _maxint = null;
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private String _documentation;
    private QNameSet _excludeNextSet;
    private int _intMaxOccurs;
    private int _intMinOccurs;
    private boolean _isDefault;
    private boolean _isDeterministic;
    private boolean _isFixed;
    private boolean _isImmutable;
    private boolean _isNillable;
    private boolean _isSkippable;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    protected XmlObject _parseObject;
    private SchemaParticle[] _particleChildren;
    private int _particleType;
    private QName _qName;
    private QNameSet _startSet;
    private SchemaType.Ref _typeref;
    private int _wildcardProcess;
    private QNameSet _wildcardSet;

    static {
        _maxint = BigInteger.valueOf(2147483647L);
    }

    public SchemaParticleImpl() {
    }

    private static String parseDocumentation(XmlObject r6) {
        XmlObject r7 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r6, XmlObject.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Element.class) == false) goto L27;
        Element r8 = (Element) ZeusTransformUtils.preCheckCast(r7, Element.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        if (r8.getAnnotation() == null) goto L27;
        AnnotationDocument.Annotation r9 = r8.getAnnotation();     // Catch: Exception -> L28
        if (r9.getDocumentationArray() == null) goto L27;
        DocumentationDocument.Documentation[] r10 = r9.getDocumentationArray();     // Catch: Exception -> L28
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L28
        int r2 = r10.length;     // Catch: Exception -> L28
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L26;
        XmlCursor r4 = r10[r3].newCursor();     // Catch: Exception -> L28
        r1.append(r4.getTextValue());     // Catch: Throwable -> L16
        if (r4 == null) goto L15;
        r4.close();     // Catch: Exception -> L28
    L15:
        r3 = r3 + 1;
        goto L10
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (r4 != null) goto L31;
    L24:
        throw th;     // Catch: Exception -> L28
    L31:
        r4.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L28
        goto L24
    L26:
        return r1.toString();
    L27:
        return "";
    }

    private static int pegBigInteger(BigInteger r2) {
        if (r2 != null) goto L6;
        return Integer.MAX_VALUE;
    L6:
        if (r2.signum() > 0) goto L10;
        return 0;
    L10:
        if (r2.compareTo(_maxint) < 0) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return r2.intValue();
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QNameSet acceptedStartNames() {
        return this._startSet;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean canStartWithElement(QName r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this._startSet.contains(r1) == false) goto L6;
        return true;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int countOfParticleChild() {
        SchemaParticle[] r0 = this._particleChildren;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public String getDefaultText() {
        return this._defaultText;
    }

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
        if (this._parseObject == null) goto L21;
        if (XmlQName.type.isAssignableFrom(getType()) == false) goto L21;
        NamespaceContext.push(new NamespaceContext(this._parseObject));     // Catch: Throwable -> L17
        XmlAnySimpleType r2 = getType().newValue(this._defaultText);     // Catch: Throwable -> L17
        NamespaceContext.pop();
        return r2;
    L17:
        th = move-exception;
        NamespaceContext.pop();
        throw th;
    L21:
        return getType().newValue(this._defaultText);
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getIntMaxOccurs() {
        return this._intMaxOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getIntMinOccurs() {
        return this._intMinOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public BigInteger getMaxOccurs() {
        return this._maxOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QName getName() {
        return this._qName;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaParticle getParticleChild(int r1) {
        return this._particleChildren[r1];
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getParticleType() {
        return this._particleType;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaType getType() {
        SchemaType.Ref r0 = this._typeref;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getWildcardProcess() {
        return this._wildcardProcess;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QNameSet getWildcardSet() {
        return this._wildcardSet;
    }

    public boolean isAttribute() {
        return false;
    }

    public boolean isDefault() {
        return this._isDefault;
    }

    public boolean isFixed() {
        return this._isFixed;
    }

    public boolean isNillable() {
        return this._isNillable;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isSkippable() {
        return this._isSkippable;
    }

    public void mutate() {
        if (this._isImmutable == true) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    public void setDefault(String r3, boolean r4, XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        mutate();
        this._defaultText = r3;
        if (r3 == null) goto L5;
        boolean r7 = true;
    L6:
        this._isDefault = r7;
        this._isFixed = r4;
        this._parseObject = r6;
        this._documentation = parseDocumentation(r6);
        return;
    L5:
        r7 = false;
        goto L6
    }

    public void setDefaultValue(XmlValueRef r1) {
        mutate();
        this._defaultValue = r1;
    }

    public void setMaxOccurs(BigInteger r1) {
        mutate();
        this._maxOccurs = r1;
        this._intMaxOccurs = pegBigInteger(r1);
    }

    public void setMinOccurs(BigInteger r1) {
        mutate();
        this._minOccurs = r1;
        this._intMinOccurs = pegBigInteger(r1);
    }

    public void setNameAndTypeRef(QName r1, SchemaType.Ref r2) {
        mutate();
        this._qName = r1;
        this._typeref = r2;
    }

    public void setNillable(boolean r1) {
        mutate();
        this._isNillable = r1;
    }

    public void setParticleChildren(SchemaParticle[] r3) {
        mutate();
        if (r3 != null) goto L5;
        SchemaParticle[] r4 = null;
    L6:
        this._particleChildren = r4;
        return;
    L5:
        r4 = (SchemaParticle[]) ZeusTransformUtils.preCheckCast(r3.clone(), SchemaParticle[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void setParticleType(int r1) {
        mutate();
        this._particleType = r1;
    }

    public void setTransitionNotes(QNameSet r1, boolean r2) {
        this._excludeNextSet = r1;
        this._isDeterministic = r2;
    }

    public void setTransitionRules(QNameSet r1, boolean r2) {
        this._startSet = r1;
        this._isSkippable = r2;
    }

    public void setWildcardProcess(int r1) {
        mutate();
        this._wildcardProcess = r1;
    }

    public void setWildcardSet(QNameSet r1) {
        mutate();
        this._wildcardSet = r1;
    }
}
