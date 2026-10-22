package org.apache.xmlbeans.impl.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.stream.a;

/* JADX INFO: loaded from: classes7.dex */
public class InvalidLexicalValueException extends RuntimeException {
    private a _location;

    public InvalidLexicalValueException() {
    }

    public InvalidLexicalValueException(String r1) {
        super(r1);
    }

    public InvalidLexicalValueException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public InvalidLexicalValueException(String r3, Throwable r4, a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        setLocation(r6);
    }

    public InvalidLexicalValueException(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        super(r3);
        setLocation(r5);
    }

    public InvalidLexicalValueException(Throwable r1) {
        super(r1);
    }

    public InvalidLexicalValueException(Throwable r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        super(r3);
        setLocation(r5);
    }

    public a getLocation() {
        return this._location;
    }

    public void setLocation(a r3) {
        this._location = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }
}
