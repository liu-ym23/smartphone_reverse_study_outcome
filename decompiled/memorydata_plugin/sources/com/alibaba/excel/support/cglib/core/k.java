package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.security.AccessController;

/* JADX INFO: loaded from: classes.dex */
public class k extends com.alibaba.excel.support.asm.f {
    private static String c;
    private static Constructor d;
    private String e;
    private String f;

    static {
        String r0 = System.getProperty("cglib.debugLocation");
        c = r0;
        if (r0 == null) goto L10;
        System.err.println("CGLIB debugging enabled, writing to '" + c + "'");
        d = ZeusTransformUtils.forName("com.alibaba.excel.support.asm.util.TraceClassVisitor", "com.obric.memorydata.plugin").getConstructor(new Class[]{com.alibaba.excel.support.asm.f.class, PrintWriter.class});     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public k(int r3) {
        super(i.h, new com.alibaba.excel.support.asm.g(r3));
    }

    static /* synthetic */ com.alibaba.excel.support.asm.f a(k r0) {
        return r0.f313b;
    }

    static /* synthetic */ String b(k r0) {
        return r0.e;
    }

    static /* synthetic */ String c() {
        return c;
    }

    static /* synthetic */ Constructor d() {
        return d;
    }

    @Override // com.alibaba.excel.support.asm.f
    public void a(int r4, int r5, String r6, String r7, String r8, String[] r9) {
        this.e = r6.replace('/', '.');
        this.f = r8.replace('/', '.');
        super.a(r4, r5, r6, r7, r8, r9);
    }

    public byte[] b() {
        return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1(this)), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
    }
}
