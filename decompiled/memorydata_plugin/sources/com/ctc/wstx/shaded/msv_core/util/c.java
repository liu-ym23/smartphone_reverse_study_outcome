package com.ctc.wstx.shaded.msv_core.util;

import com.ctc.wstx.shaded.msv_core.grammar.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3642b;
    public String c;
    public Attributes d;
    public g e;

    public c() {
    }

    public c(String r9, String r10, String r11, Attributes r12) {
        a(r9, r10, r11, (Attributes) ZeusTransformUtils.wrapperContextForParams(r12, Attributes.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.preCheckCast(null, g.class, "com.obric.memorydata.plugin"));
    }

    public c(String r9, String r10, String r11, Attributes r12, g r13) {
        a(r9, r10, r11, (Attributes) ZeusTransformUtils.wrapperContextForParams(r12, Attributes.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.wrapperContextForParams(r13, g.class, "com.obric.memorydata.plugin"));
    }

    public final String a(String r2) {
        return a("", r2);
    }

    public final String a(String r1, String r2) {
        return this.d.getValue(r1, r2);
    }

    public void a(String r3, String r4, String r5, Attributes r6, g r7) {
        Attributes r8 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r6, Attributes.class, "com.obric.memorydata.plugin");
        g r9 = (g) ZeusTransformUtils.wrapperContextForParams(r7, g.class, "com.obric.memorydata.plugin");
        this.f3641a = r3;
        this.f3642b = r4;
        this.c = r5;
        this.d = r8;
        this.e = r9;
    }
}
