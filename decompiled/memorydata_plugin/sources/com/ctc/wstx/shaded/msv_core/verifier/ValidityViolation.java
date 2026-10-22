package com.ctc.wstx.shaded.msv_core.verifier;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: classes2.dex */
public class ValidityViolation extends SAXParseException {
    private d errorInfo;

    public ValidityViolation(Locator r3, String r4, d r5) {
        super(r4, (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin"));
        this.errorInfo = r5;
    }

    public d getErrorInfo() {
        return this.errorInfo;
    }
}
