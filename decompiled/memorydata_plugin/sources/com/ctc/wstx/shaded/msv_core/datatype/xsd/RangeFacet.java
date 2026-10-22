package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RangeFacet extends DataTypeWithValueConstraintFacet {
    private static final long serialVersionUID = 1;
    public final Object limitValue;

    public RangeFacet(String r7, String r8, XSDatatypeImpl r9, String r10, Object r11, boolean r12) {
        super(r7, r8, r9, r10, r12);
        this.limitValue = r11;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final Object _createValue(String r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e r5) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r6 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        Object r7 = this.baseType._createValue(r4, r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        if (rangeCheck(((a) ZeusTransformUtils.preCheckCast(this.concreteType, a.class, "com.obric.memorydata.plugin")).compare(this.limitValue, r7)) == true) goto L8;
        return null;
    L8:
        return r7;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet
    public void diagnoseByFacet(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        if (_createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")) == null) goto L6;
        return;
    L6:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_OUT_OF_RANGE, this.facetName, this.limitValue));
    }

    public abstract boolean rangeCheck(int r1);
}
