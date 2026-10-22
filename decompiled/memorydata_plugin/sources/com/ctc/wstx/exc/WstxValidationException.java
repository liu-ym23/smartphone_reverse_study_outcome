package com.ctc.wstx.exc;

import com.ctc.wstx.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.stream.a;
import org.codehaus.stax2.validation.XMLValidationException;
import org.codehaus.stax2.validation.e;

/* JADX INFO: loaded from: classes2.dex */
public class WstxValidationException extends XMLValidationException {
    public WstxValidationException(e r1, String r2) {
        super(r1, r2);
    }

    public WstxValidationException(e r3, String r4, a r5) {
        super(r3, r4, (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin"));
    }

    public static WstxValidationException create(e r3) {
        a r0 = r3.a();
        if (r0 != null) goto L7;
        return new WstxValidationException(r3, r3.b());
    L7:
        return new WstxValidationException(r3, r3.b(), r0);
    }

    public String getLocationDesc() {
        a r0 = getLocation();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r0 = getLocationDesc();
        if (r0 == null) goto L5;
        String r4 = getValidationProblem().b();
        StringBuilder r1 = new StringBuilder((r4.length() + r0.length()) + 20);
        r1.append(r4);
        i.a(r1);
        r1.append(" at ");
        r1.append(r0);
        return r1.toString();
    L5:
        return super.getMessage();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
