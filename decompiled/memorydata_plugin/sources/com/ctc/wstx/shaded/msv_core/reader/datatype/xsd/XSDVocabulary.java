package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class XSDVocabulary implements com.ctc.wstx.shaded.msv_core.reader.datatype.a, Serializable {
    public static final String XMLSchemaNamespace = "http://www.w3.org/2001/XMLSchema-datatypes";
    public static final String XMLSchemaNamespace2 = "http://www.w3.org/2001/XMLSchema";

    public XSDVocabulary() {
    }

    public com.ctc.wstx.shaded.msv_core.reader.i createTopLevelReaderState(com.ctc.wstx.shaded.msv_core.util.c r1) {
        if (r1.f3642b.equals("simpleType") == true) goto L5;
        return null;
    L5:
        return new f();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.a
    public com.ctc.wstx.shaded.msv.relaxng_datatype.a getType(String r1) {
        return com.ctc.wstx.shaded.msv_core.datatype.xsd.b.a(r1);
    }
}
