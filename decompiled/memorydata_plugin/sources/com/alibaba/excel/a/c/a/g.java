package com.alibaba.excel.a.c.a;

import com.alibaba.excel.i.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class g extends b {
    public g() {
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r1, String r2, Attributes r3) {
        com.alibaba.excel.e.c.b r0 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        String r4 = ((Attributes) ZeusTransformUtils.wrapperContextForParams(r3, Attributes.class, "com.obric.memorydata.plugin")).getValue("ref");
        String r5 = r4.substring(r4.indexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR) + 1);
        r0.b().a(Integer.valueOf(m.a(r5) + 1));
    }
}
