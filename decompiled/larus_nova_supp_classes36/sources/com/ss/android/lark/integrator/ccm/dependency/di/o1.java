package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o1 extends c0c.b implements com.bytedance.ee.bear.lark.dependency.c0 {
    public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.c0 b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.c0> d;

    public static final class a {
    }

    static {
    }

    public final void D1(Fragment r9, UserSession r10, String r11, String r12, String r13, String r14, com.bytedance.ee.bear.lark.dependency.c0.a r15) {
        this.b.D1(r9, r10, r11, r12, r13, r14, r15);
    }

    public final void Wb(FragmentActivity r11, FragmentManager r12, UserSession r13, String r14, String r15, String r16, String r17, com.bytedance.ee.bear.lark.dependency.c0.a r18) {
        this.b.Wb(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public final void eb(Context r2, String r3, String r4, boolean r5) {
        this.b.eb(r2, r3, r4, r5);
    }

    public final Pair<Fragment, r1c.a> j4(UserSession r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        return this.b.j4(r2, r3, r4);
    }

    public final void onDestroy() {
        this.b.onDestroy();
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("ProfileDependencyProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
        ((com.bytedance.ee.bear.lark.dependency.c0) this.d.c()).onDestroy();
    }

    public o1(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.c0> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), com.bytedance.ee.bear.lark.dependency.c0.class), com.bytedance.ee.bear.lark.dependency.c0.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (com.bytedance.ee.bear.lark.dependency.c0) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        tt5.a.h("ProfileDependencyProxy", "preparing");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        com.bytedance.ee.bear.lark.dependency.c0 r6 = (com.bytedance.ee.bear.lark.dependency.c0) e0c.k.b(r4.c(r5), com.bytedance.ee.bear.lark.dependency.c0.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
