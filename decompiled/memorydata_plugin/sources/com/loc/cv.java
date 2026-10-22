package com.loc;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class cv {
    public cv(String r3, String r4, String r5, String r6, dh r7) {
        dh r8 = (dh) ZeusTransformUtils.wrapperContextForParams(r7, dh.class, "com.obric.memorydata.plugin");
        dc.b();
        dc.d(r6);
        dc.f(BDLocationException.ERROR_LOCATION_UPLOAD);
        dc.e("v74");
        dc.a(r3);
        dc.c(r4);
        dc.b(r5);
        cx.a(r8);
    }

    public static ca a(by.a r1) {
        return by.a().a(r1);
    }

    public static void a(List<dv> r2) {
        cu.a((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    public static boolean a(byte[] r0) {
        return cb.a(r0);
    }

    public static byte[] a() {
        return bw.b().c();
    }

    public static byte[] a(byte[] r2, byte[] r3, List<ca> r4) {
        List<? extends ca> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        return bw.b().a(r2, r3, r5);
    }

    public static void b() {
        cx.a();
    }

    public static void b(List<db> r2) {
        cu.b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    public final cv a(int r1) {
        dc.a(r1);
        return this;
    }

    public final cv a(long r1) {
        dc.a(r1);
        return this;
    }

    public final cv a(String r1) {
        dc.g(r1);
        return this;
    }

    public final cv b(String r1) {
        dc.h(r1);
        return this;
    }

    public final cv c(String r1) {
        dc.i(r1);
        return this;
    }

    public final cv d(String r1) {
        dc.j(r1);
        return this;
    }

    public final cv e(String r1) {
        dc.k(r1);
        return this;
    }

    public final cv f(String r1) {
        dc.l(r1);
        return this;
    }

    public final cv g(String r1) {
        dc.m(r1);
        return this;
    }

    public final cv h(String r1) {
        dc.n(r1);
        return this;
    }

    public final cv i(String r1) {
        dc.o(r1);
        return this;
    }

    public final cv j(String r1) {
        dc.p(r1);
        return this;
    }

    public final cv k(String r1) {
        dc.q(r1);
        return this;
    }
}
