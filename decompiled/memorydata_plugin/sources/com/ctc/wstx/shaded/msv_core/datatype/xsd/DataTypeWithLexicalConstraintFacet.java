package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class DataTypeWithLexicalConstraintFacet extends DataTypeWithFacet {
    private static final long serialVersionUID = 6093401348890059498L;

    DataTypeWithLexicalConstraintFacet(String r1, String r2, XSDatatypeImpl r3, String r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        Object r6 = this.baseType._createValue(r3, r5);
        if (r6 != null) goto L5;
    L8:
        return r6;
    L5:
        if (checkLexicalConstraint(r3) == true) goto L8;
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final boolean checkFormat(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if (this.baseType.checkFormat(r3, r5) == true) goto L7;
        return false;
    L7:
        return checkLexicalConstraint(r3);
    }

    public abstract boolean checkLexicalConstraint(String r1);
}
