package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaLocalElementImpl extends SchemaParticleImpl implements SchemaLocalElement {
    protected boolean _abs;
    private SchemaAnnotation _annotation;
    private boolean _blockExt;
    private boolean _blockRest;
    private boolean _blockSubst;
    private SchemaIdentityConstraint.Ref[] _constraints;
    private SOAPArrayType _wsdlArrayType;

    public SchemaLocalElementImpl() {
        this._constraints = new SchemaIdentityConstraint.Ref[0];
        setParticleType(4);
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockExtension() {
        return this._blockExt;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockRestriction() {
        return this._blockRest;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockSubstitution() {
        return this._blockSubst;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public SchemaIdentityConstraint[] getIdentityConstraints() {
        int r0 = this._constraints.length;
        SchemaIdentityConstraint[] r1 = new SchemaIdentityConstraint[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this._constraints[r2].get();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean isAbstract() {
        return this._abs;
    }

    public void setAbstract(boolean r1) {
        this._abs = r1;
    }

    public void setAnnotation(SchemaAnnotation r3) {
        this._annotation = (SchemaAnnotation) ZeusTransformUtils.wrapperContextForParams(r3, SchemaAnnotation.class, "com.obric.memorydata.plugin");
    }

    public void setBlock(boolean r1, boolean r2, boolean r3) {
        mutate();
        this._blockExt = r1;
        this._blockRest = r2;
        this._blockSubst = r3;
    }

    public void setIdentityConstraints(SchemaIdentityConstraint.Ref[] r3) {
        mutate();
        if (r3 != null) goto L5;
        SchemaIdentityConstraint.Ref[] r4 = null;
    L6:
        this._constraints = r4;
        return;
    L5:
        r4 = (SchemaIdentityConstraint.Ref[]) ZeusTransformUtils.preCheckCast(r3.clone(), SchemaIdentityConstraint.Ref[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void setWsdlArrayType(SOAPArrayType r1) {
        this._wsdlArrayType = r1;
    }
}
