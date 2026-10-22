package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class LanguageType extends TokenType {
    private static final long serialVersionUID = 1;
    public static final LanguageType theInstance = null;

    static {
        theInstance = new LanguageType();
    }

    private LanguageType() {
        super(Api.KEY_LANGUAGE, false);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r6, com.ctc.wstx.shaded.msv.relaxng_datatype.e r7) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r7, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r8 = r6.length();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r8) goto L23;
        int r3 = r0 + 1;
        char r2 = r6.charAt(r0);
        if ('a' > r2) goto L10;
        if (r2 > 'z') goto L10;
    L13:
        r1 = r1 + 1;
        if (r1 != 9) goto L21;
        return null;
    L21:
        r0 = r3;
    L10:
        if ('A' > r2) goto L17;
        if (r2 <= 'Z') goto L13;
    L17:
        if (r2 != '-') goto L22;
        if (r1 == 0) goto L19;
        r1 = 0;
        goto L21
    L19:
        return null;
    L22:
        return null;
    L23:
        if (r1 != 0) goto L26;
        return null;
    L26:
        return r6.toLowerCase();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.TokenType, com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return TokenType.theInstance;
    }
}
