package com.tom_roush.pdfbox.contentstream.operator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class MissingOperandException extends IOException {
    public MissingOperandException(b r3, List<com.tom_roush.pdfbox.a.b> r4) {
        super("Operator " + r3.a() + " has too few operands: " + ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")));
    }
}
