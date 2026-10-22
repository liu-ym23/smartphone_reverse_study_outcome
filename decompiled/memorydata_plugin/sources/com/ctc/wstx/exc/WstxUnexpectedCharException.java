package com.ctc.wstx.exc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.stream.a;

/* JADX INFO: loaded from: classes2.dex */
public class WstxUnexpectedCharException extends WstxParsingException {
    final char mChar;

    public WstxUnexpectedCharException(String r3, a r4, char r5) {
        super(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"));
        this.mChar = r5;
    }

    public char getChar() {
        return this.mChar;
    }
}
