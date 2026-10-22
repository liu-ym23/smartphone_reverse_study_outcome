package org.codehaus.stax2.validation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: classes7.dex */
public class XMLValidationException extends XMLStreamException {
    private static final long serialVersionUID = 1;
    protected e mCause;

    public XMLValidationException(e r1) {
        if (r1 != null) goto L5;
        throwMissing();
    L5:
        this.mCause = r1;
    }

    public XMLValidationException(e r1, String r2) {
        super(r2);
        if (r1 != null) goto L5;
        throwMissing();
    L5:
        this.mCause = r1;
    }

    public XMLValidationException(e r3, String r4, javax.xml.stream.a r5) {
        super(r4, (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r5, javax.xml.stream.a.class, "com.obric.memorydata.plugin"));
        if (r3 != null) goto L5;
        throwMissing();
    L5:
        this.mCause = r3;
    }

    public static XMLValidationException createException(e r3) {
        String r0 = r3.b();
        if (r0 == null) goto L5;
        javax.xml.stream.a r1 = r3.a();
        if (r1 != null) goto L11;
        return new XMLValidationException(r3, r0);
    L11:
        return new XMLValidationException(r3, r0, r1);
    L5:
        return new XMLValidationException(r3);
    }

    public static void throwMissing() {
        throw new IllegalArgumentException("Validation problem argument can not be null");
    }

    public e getValidationProblem() {
        return this.mCause;
    }
}
