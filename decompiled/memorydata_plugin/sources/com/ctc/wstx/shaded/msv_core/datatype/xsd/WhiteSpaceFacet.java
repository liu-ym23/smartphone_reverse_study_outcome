package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class WhiteSpaceFacet extends DataTypeWithFacet {
    private static final long serialVersionUID = 1;

    WhiteSpaceFacet(String r8, String r9, XSDatatypeImpl r10, WhiteSpaceProcessor r11, boolean r12) {
        super(r8, r9, r10, XSDatatype.FACET_WHITESPACE, r12, r11);
        if (r10.whiteSpace.tightness() <= this.whiteSpace.tightness()) goto L9;
        XSDatatype r13 = r10.getFacetObject(XSDatatype.FACET_WHITESPACE);
        if (r13 != null) goto L8;
        r13 = getConcreteType();
    L8:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_LOOSENED_FACET, XSDatatype.FACET_WHITESPACE, r13.displayName()));
    }

    WhiteSpaceFacet(String r9, String r10, XSDatatypeImpl r11, d r12) {
        this(r9, r10, r11, WhiteSpaceProcessor.get((String) ZeusTransformUtils.preCheckCast(r12.b(XSDatatype.FACET_WHITESPACE), String.class, "com.obric.memorydata.plugin")), r12.a(XSDatatype.FACET_WHITESPACE));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return this.baseType._createValue(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return this.baseType.checkFormat(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet
    public void diagnoseByFacet(String r1, com.ctc.wstx.shaded.msv.relaxng_datatype.e r2) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r0 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
    }
}
