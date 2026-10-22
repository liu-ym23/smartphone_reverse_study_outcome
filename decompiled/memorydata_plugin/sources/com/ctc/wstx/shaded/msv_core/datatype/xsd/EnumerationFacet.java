package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class EnumerationFacet extends DataTypeWithValueConstraintFacet {
    private static final long serialVersionUID = 1;
    public final Set values;

    public EnumerationFacet(String r7, String r8, XSDatatypeImpl r9, Collection r10, boolean r11) {
        Collection r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r10, Collection.class, "com.obric.memorydata.plugin");
        super(r7, r8, r9, XSDatatype.FACET_ENUMERATION, r11);
        this.values = new HashSet(r12);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        Object r6 = this.baseType._createValue(r3, r5);
        if (r6 != null) goto L5;
        return null;
    L5:
        if (this.values.contains(r6) == false) goto L10;
        return r6;
    L10:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet
    public void diagnoseByFacet(String r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e r5) {
        if (_createValue(r4, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")) == null) goto L6;
        return;
    L6:
        if (this.values.size() > 4) goto L18;
        Object[] r3 = this.values.toArray();
        if (ZeusTransformUtils.instanceOf(r3[0], String.class) == false) goto L10;
    L11:
        String r6 = "\"" + r3[0].toString() + "\"";
        int r7 = 1;
    L13:
        if (r7 >= r3.length) goto L16;
        r6 = r6 + "/\"" + r3[r7].toString() + "\"";
        r7 = r7 + 1;
        goto L13
    L16:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_ENUMERATION_WITH_ARG, "(" + r6 + ")"));
    L10:
        if (ZeusTransformUtils.instanceOf(r3[0], Number.class) == true) goto L11;
    L18:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_ENUMERATION));
    }
}
