package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f5349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vc.c f5350b;

    public q(n r5) {
        Intrinsics.checkNotNullParameter(r5, "origin");
        this.f5349a = r5;
        this.f5350b = r5.getLynxClient();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void b() {
        this.f5349a.b();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void f() {
        this.f5349a.f();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final vc.c getLynxClient() {
        return this.f5350b;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void n() {
        this.f5349a.n();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5349a.o(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5349a.p(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        this.f5349a.q(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void s(Uri r5, hb.a r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5349a.s(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void u(Uri r5, com.bytedance.ies.bullet.core.container.e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5349a.u(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, com.bytedance.ies.bullet.service.base.h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        this.f5349a.v(r5, r10, r11);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void w(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5349a.w(r5, r10);
    }
}
