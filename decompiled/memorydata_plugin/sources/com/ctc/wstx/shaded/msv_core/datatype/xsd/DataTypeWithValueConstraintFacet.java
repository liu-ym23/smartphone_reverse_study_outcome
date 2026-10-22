package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class DataTypeWithValueConstraintFacet extends DataTypeWithFacet {
    private static final long serialVersionUID = 2497055158497151572L;

    DataTypeWithValueConstraintFacet(String r1, String r2, XSDatatypeImpl r3, String r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final boolean checkFormat(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        if (_createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final boolean needValueCheck() {
        return true;
    }
}
