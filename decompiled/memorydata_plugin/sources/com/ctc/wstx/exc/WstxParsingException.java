package com.ctc.wstx.exc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.stream.a;

/* JADX INFO: loaded from: classes2.dex */
public class WstxParsingException extends WstxException {
    public WstxParsingException(String r1) {
        super(r1);
    }

    public WstxParsingException(String r3, a r4) {
        super(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"));
    }
}
