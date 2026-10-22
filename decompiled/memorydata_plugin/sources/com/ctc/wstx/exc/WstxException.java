package com.ctc.wstx.exc;

import com.ctc.wstx.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.a;

/* JADX INFO: loaded from: classes2.dex */
public class WstxException extends XMLStreamException {
    protected final String mMsg;

    public WstxException(String r1) {
        super(r1);
        this.mMsg = r1;
    }

    public WstxException(String r3, a r4) {
        super(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"));
        this.mMsg = r3;
    }

    public WstxException(String r3, a r4, Throwable r5) {
        super(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"), r5);
        this.mMsg = r3;
    }

    public WstxException(Throwable r2) {
        super(r2.getMessage(), r2);
        this.mMsg = r2.getMessage();
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
        StringBuilder r1 = new StringBuilder((this.mMsg.length() + r0.length()) + 20);
        r1.append(this.mMsg);
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
