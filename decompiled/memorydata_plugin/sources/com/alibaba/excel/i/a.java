package com.alibaba.excel.i;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.alibaba.excel.i.a$a, reason: collision with other inner class name */
    public static class C0047a extends com.alibaba.excel.support.cglib.core.m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0047a f202b = null;

        static {
            f202b = new C0047a();
        }

        public C0047a() {
        }

        @Override // com.alibaba.excel.support.cglib.core.m
        public String a() {
            return "ByEasyExcelCGLIB";
        }
    }

    public static com.alibaba.excel.support.cglib.beans.a a(Object r1) {
        com.alibaba.excel.support.cglib.beans.a.C0048a r0 = new com.alibaba.excel.support.cglib.beans.a.C0048a();
        r0.a(r1);
        r0.c(r1.getClass());
        r0.a(C0047a.f202b);
        return r0.c();
    }
}
