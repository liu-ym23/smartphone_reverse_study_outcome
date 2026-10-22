package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MinLengthFacet extends DataTypeWithValueConstraintFacet {
    private static final long serialVersionUID = 1;
    public final int minLength;

    public MinLengthFacet(String r7, String r8, XSDatatypeImpl r9, int r10, boolean r11) {
        super(r7, r8, r9, XSDatatype.FACET_MINLENGTH, r11);
        this.minLength = r10;
        DataTypeWithFacet r12 = r9.getFacetObject(XSDatatype.FACET_MINLENGTH);
        if (r12 != null) goto L5;
        return;
    L5:
        if (((MinLengthFacet) ZeusTransformUtils.preCheckCast(r12, MinLengthFacet.class, "com.obric.memorydata.plugin")).minLength > r10) goto L8;
        return;
    L8:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_LOOSENED_FACET, XSDatatype.FACET_MINLENGTH, r12.displayName()));
    }

    public MinLengthFacet(String r8, String r9, XSDatatypeImpl r10, d r11) {
        this(r8, r9, r10, r11.e(XSDatatype.FACET_MINLENGTH), r11.a(XSDatatype.FACET_MINLENGTH));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        Object r6 = this.baseType._createValue(r3, r5);
        if (r6 != null) goto L5;
        return null;
    L5:
        if (((c) ZeusTransformUtils.preCheckCast(this.concreteType, c.class, "com.obric.memorydata.plugin")).countLength(r6) < this.minLength) goto L10;
        return r6;
    L10:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet
    public void diagnoseByFacet(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        Object r6 = this.concreteType._createValue(r3, r5);
        if (r6 == null) goto L10;
        int r7 = ((c) ZeusTransformUtils.preCheckCast(this.concreteType, c.class, "com.obric.memorydata.plugin")).countLength(r6);
        if (r7 < this.minLength) goto L8;
        return;
    L8:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_MINLENGTH, new Integer(r7), new Integer(this.minLength)));
    L10:
        throw new IllegalStateException();
    }
}
