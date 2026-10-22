package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import com.bytedance.android.live.revlink.impl.pk.service.j;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.g;
import com.bytedance.android.livesdk.link.model.bridge.s;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.revlink.impl.pk.vm.linkout.a {
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.c a;

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void a() {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void b() {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void d() {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void f() {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void g() {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void i() {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.i();
        return;
    }

    public a(com.bytedance.android.live.revlink.link.domain.anchorimpl.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void e(PkAutoMatchDataContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pkAutoMatchDataContext");
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void h(PkAutoMatchManager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "dismissListener");
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void k(j r2) {
        Intrinsics.checkNotNullParameter(r2, "startParams");
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.k(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void c(s r2, com.bytedance.android.live.revlink.impl.pk.vm.linkout.f r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "dismissListener");
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.linkout.a
    public final void j(s r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "dismissListener");
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.j(r2, r3);
        return;
    }
}
