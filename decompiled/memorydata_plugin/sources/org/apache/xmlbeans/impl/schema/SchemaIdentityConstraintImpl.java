package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.impl.xpath.XPath;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaIdentityConstraintImpl implements SchemaIdentityConstraint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private final SchemaContainer _container;
    private volatile XPath[] _fieldPaths;
    private String[] _fields;
    private String _filename;
    private SchemaIdentityConstraint.Ref _key;
    private QName _name;
    private Map<String, String> _nsMap;
    private String _selector;
    private volatile XPath _selectorPath;
    private final SchemaIdentityConstraint.Ref _selfref;
    private int _type;

    static {
    }

    public SchemaIdentityConstraintImpl(SchemaContainer r2) {
        this._nsMap = Collections.emptyMap();
        this._selfref = new SchemaIdentityConstraint.Ref(this);
        this._container = r2;
    }

    public void buildPaths() {
        this._selectorPath = XPath.compileXPath(this._selector, this._nsMap);
        int r0 = this._fields.length;
        XPath[] r1 = new XPath[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = XPath.compileXPath(this._fields[r2], this._nsMap);
        r2 = r2 + 1;
        goto L3
    L5:
        this._fieldPaths = r1;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public int getConstraintCategory() {
        return this._type;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getFieldPath(int r2) {
        XPath[] r0 = this._fieldPaths;
        if (r0 != null) goto L9;
        buildPaths();     // Catch: XPath.XPathCompileException -> L6
        r0 = this._fieldPaths;     // Catch: XPath.XPathCompileException -> L6
    L6:
        return null;
    L9:
        return r0[r2];
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public String[] getFields() {
        String[] r3 = this._fields;
        int r0 = r3.length;
        String[] r1 = new String[r0];
        System.arraycopy(r3, 0, r1, 0, r0);
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public SchemaIdentityConstraint getReferencedKey() {
        return this._key.get();
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getSelectorPath() {
        XPath r0 = this._selectorPath;
        if (r0 == null) goto L9;
        return r0;
    L9:
        buildPaths();     // Catch: XPath.XPathCompileException -> L6
        return this._selectorPath;
    L6:
        return null;
    }

    public void setAnnotation(SchemaAnnotation r3) {
        this._annotation = (SchemaAnnotation) ZeusTransformUtils.wrapperContextForParams(r3, SchemaAnnotation.class, "com.obric.memorydata.plugin");
    }

    public void setConstraintCategory(int r1) {
        this._type = r1;
    }

    public void setFields(String[] r3) {
        this._fields = (String[]) ZeusTransformUtils.preCheckCast(r3.clone(), String[].class, "com.obric.memorydata.plugin");
    }

    public void setFilename(String r1) {
        this._filename = r1;
    }

    public void setNSMap(Map<String, String> r3) {
        this._nsMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void setName(QName r1) {
        this._name = r1;
    }

    public void setReferencedKey(SchemaIdentityConstraint.Ref r1) {
        this._key = r1;
    }

    public void setSelector(String r1) {
        this._selector = r1;
    }
}
