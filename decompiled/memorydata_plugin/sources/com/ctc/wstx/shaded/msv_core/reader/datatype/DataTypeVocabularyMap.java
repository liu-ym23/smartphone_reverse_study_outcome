package com.ctc.wstx.shaded.msv_core.reader.datatype;

import com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.XSDVocabulary;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DataTypeVocabularyMap implements Serializable {
    private final Map impl;

    public DataTypeVocabularyMap() {
        this.impl = new HashMap();
    }

    public a get(String r4) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.impl.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r4.equals(XSDVocabulary.XMLSchemaNamespace) == false) goto L9;
        XSDVocabulary r1 = new XSDVocabulary();
        this.impl.put(XSDVocabulary.XMLSchemaNamespace, r1);
        this.impl.put("http://www.w3.org/2001/XMLSchema", r1);
        return r1;
    L9:
        return r0;
    }

    public void put(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        this.impl.put(r3, r5);
    }
}
