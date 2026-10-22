package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.cglib.core.ag;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f434b;

    /* JADX INFO: renamed from: com.alibaba.excel.support.cglib.proxy.a$a, reason: collision with other inner class name */
    private static class C0051a extends com.alibaba.excel.support.asm.f {
        private Map c;
        private Set d;
        private ag e;

        C0051a(Set r3, Map r4) {
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            super(com.alibaba.excel.support.cglib.core.i.h);
            this.e = null;
            this.c = r6;
            this.d = r5;
        }

        static /* synthetic */ ag a(C0051a r0) {
            return r0.e;
        }

        static /* synthetic */ ag a(C0051a r0, ag r1) {
            r0.e = r1;
            return r1;
        }

        static /* synthetic */ Map b(C0051a r0) {
            return r0.c;
        }

        @Override // com.alibaba.excel.support.asm.f
        public com.alibaba.excel.support.asm.r a(int r1, String r2, String r3, String r4, String[] r5) {
            ag r6 = new ag(r2, r3);
            if (this.d.remove(r6) == false) goto L6;
            this.e = r6;
            final int r7 = com.alibaba.excel.support.cglib.core.i.h;
            return new AnonymousClass1(this, r7);
        L6:
            return null;
        }

        @Override // com.alibaba.excel.support.asm.f
        public void a(int r1, int r2, String r3, String r4, String r5, String[] r6) {
        }
    }

    public a(Map r3, ClassLoader r4) {
        this.f433a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.f434b = r4;
    }

    public Map a() {
        HashMap r0 = new HashMap();
        Iterator r1 = this.f433a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Class r3 = (Class) ZeusTransformUtils.preCheckCast(r2.getKey(), Class.class, "com.obric.memorydata.plugin");
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(r2.getValue(), Set.class, "com.obric.memorydata.plugin");
        InputStream r5 = this.f434b.getResourceAsStream(r3.getName().replace('.', '/') + ".class");     // Catch: IOException -> L15
        if (r5 == null) goto L8;
        new com.alibaba.excel.support.asm.e(r5).a(new C0051a(r4, r0), 6);     // Catch: Throwable -> L11
        goto L4
    L10:
        r5.close();     // Catch: IOException -> L15
    L11:
        th = move-exception;
        r5.close();     // Catch: IOException -> L15
        throw th;     // Catch: IOException -> L15
    L8:
        return r0;
    L14:
        return r0;
    }
}
