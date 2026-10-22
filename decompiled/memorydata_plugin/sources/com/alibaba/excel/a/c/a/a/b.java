package com.alibaba.excel.a.c.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.excel.a.c.a.e;
import com.alibaba.excel.a.c.a.g;
import com.alibaba.excel.a.c.a.h;
import com.alibaba.excel.a.c.a.i;
import com.alibaba.excel.a.c.a.j;
import com.alibaba.excel.a.c.a.k;
import com.bytedance.apm.util.f;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.c;
import org.slf4j.d;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes.dex */
public class b extends DefaultHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f134a = null;
    private static final Map<String, k> c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.alibaba.excel.e.c.b f135b;

    static {
        f134a = d.a(b.class);
        HashMap r0 = new HashMap(64);
        c = r0;
        com.alibaba.excel.a.c.a.c r1 = new com.alibaba.excel.a.c.a.c();
        r0.put(f.f1488a, r1);
        r0.put("x:f", r1);
        r0.put("ns2:f", r1);
        com.alibaba.excel.a.c.a.d r2 = new com.alibaba.excel.a.c.a.d();
        r0.put("t", r2);
        r0.put("x:t", r2);
        r0.put("ns2:t", r2);
        e r3 = new e();
        r0.put("c", r3);
        r0.put("x:c", r3);
        r0.put("ns2:c", r3);
        com.alibaba.excel.a.c.a.f r4 = new com.alibaba.excel.a.c.a.f();
        r0.put(BaseSwitches.V, r4);
        r0.put("x:v", r4);
        r0.put("ns2:v", r4);
        g r5 = new g();
        r0.put(TypedValues.Custom.S_DIMENSION, r5);
        r0.put("x:dimension", r5);
        r0.put("ns2:dimension", r5);
        h r6 = new h();
        r0.put("hyperlink", r6);
        r0.put("x:hyperlink", r6);
        r0.put("ns2:hyperlink", r6);
        i r7 = new i();
        r0.put("mergeCell", r7);
        r0.put("x:mergeCell", r7);
        r0.put("ns2:mergeCell", r7);
        j r8 = new j();
        r0.put("row", r8);
        r0.put("x:row", r8);
        r0.put("ns2:row", r8);
    }

    public b(com.alibaba.excel.e.c.b r3) {
        this.f135b = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] r4, int r5, int r6) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f135b.g().x().peek(), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        k r1 = (k) ZeusTransformUtils.preCheckCast(c.get(r0), k.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.a(this.f135b) == false) goto L13;
        r1.a(this.f135b, r4, r5, r6);
        return;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String r2, String r3, String r4) {
        k r5 = (k) ZeusTransformUtils.preCheckCast(c.get(r4), k.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.a(this.f135b) == false) goto L10;
        r5.a(this.f135b, r4);
        this.f135b.g().x().pop();
        return;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String r2, String r3, String r4, Attributes r5) {
        Attributes r6 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r5, Attributes.class, "com.obric.memorydata.plugin");
        k r7 = (k) ZeusTransformUtils.preCheckCast(c.get(r4), k.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.a(this.f135b) == false) goto L10;
        this.f135b.g().x().push(r4);
        r7.a(this.f135b, r4, r6);
        return;
    }
}
