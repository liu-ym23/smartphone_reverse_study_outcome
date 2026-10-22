package com.tom_roush.pdfbox.filter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f16109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.tom_roush.pdfbox.a.i, j> f16110b;

    static {
        f16109a = new k();
    }

    private k() {
        HashMap r0 = new HashMap();
        this.f16110b = r0;
        l r10 = new l();
        g r1 = new g();
        e r2 = new e();
        o r3 = new o();
        c r4 = new c();
        a r5 = new a();
        q r6 = new q();
        f r7 = new f();
        n r8 = new n();
        r0.put(com.tom_roush.pdfbox.a.i.cZ, r10);
        r0.put(com.tom_roush.pdfbox.a.i.da, r10);
        r0.put(com.tom_roush.pdfbox.a.i.bv, r1);
        r0.put(com.tom_roush.pdfbox.a.i.bw, r1);
        r0.put(com.tom_roush.pdfbox.a.i.av, r2);
        r0.put(com.tom_roush.pdfbox.a.i.aw, r2);
        r0.put(com.tom_roush.pdfbox.a.i.eI, r3);
        r0.put(com.tom_roush.pdfbox.a.i.eJ, r3);
        r0.put(com.tom_roush.pdfbox.a.i.G, r4);
        r0.put(com.tom_roush.pdfbox.a.i.H, r4);
        r0.put(com.tom_roush.pdfbox.a.i.I, r5);
        r0.put(com.tom_roush.pdfbox.a.i.f16056J, r5);
        r0.put(com.tom_roush.pdfbox.a.i.hb, r6);
        r0.put(com.tom_roush.pdfbox.a.i.hc, r6);
        r0.put(com.tom_roush.pdfbox.a.i.bp, r7);
        r0.put(com.tom_roush.pdfbox.a.i.eg, r8);
    }

    public j a(com.tom_roush.pdfbox.a.i r3) {
        j r2 = (j) ZeusTransformUtils.preCheckCast(this.f16110b.get(r3), j.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IOException("Invalid filter: " + r3);
    }
}
