package com.ss.android.lark.officesdk.utils.di;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        DependencyContainer r0 = DependencyContainer.a;
        ntb.n r1 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r1 == null) goto L6;
        r1.d(r2, r3);
        return;
    }

    @JvmStatic
    public static final void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        c(r1, r2, null);
    }

    @JvmStatic
    public static final void d(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        c(r1, "", r2);
    }

    @JvmStatic
    public static final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        DependencyContainer r0 = DependencyContainer.a;
        ntb.n r1 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r1 == null) goto L6;
        r1.i(r2, r3);
        return;
    }

    @JvmStatic
    public static final void f(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        g(r1, r2, null);
    }

    @JvmStatic
    public static final void c(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r2, "tag");
        DependencyContainer r0 = DependencyContainer.a;
        ntb.n r1 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r1 == null) goto L8;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r1.g(r2, r3, r4, false);
        return;
    }

    @JvmStatic
    public static final void g(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        DependencyContainer r0 = DependencyContainer.a;
        ntb.n r1 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r1 == null) goto L6;
        r1.w(r2, r3, r4);
        return;
    }
}
