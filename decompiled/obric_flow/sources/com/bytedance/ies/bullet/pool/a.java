package com.bytedance.ies.bullet.pool;

import android.net.Uri;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.core.t;
import com.bytedance.ies.bullet.service.base.CacheItemStatus;
import com.bytedance.ies.bullet.service.base.h;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f5785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f5786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5787c;
    public boolean d;
    public Uri e;
    public com.bytedance.ies.bullet.core.container.e f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public rd.e f5788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5793m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Throwable f5794n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5795o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Throwable f5796p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Function2 f5797q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.service.base.e f5798r;

    public a(Function2 r5, com.bytedance.ies.bullet.service.base.e r10) {
        this.f5797q = r5;
        this.f5798r = r10;
        this.f5785a = new AtomicBoolean(false);
        this.f5786b = new t();
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void b() {
        this.f5790j = true;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void f() {
        this.f5787c = true;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final vc.c getLynxClient() {
        return this.f5786b;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void n() {
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5789i = true;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        if (this.f5785a.compareAndSet(false, true) == false) goto L5;
        CacheItemStatus r11 = CacheItemStatus.f5914b;
        com.bytedance.ies.bullet.service.base.e r12 = this.f5798r;
        this.f5797q.mo2invoke(r11, r12);
    L5:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5792l = true;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        this.f5795o = true;
        this.f5796p = r10;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void r(Uri r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        if (this.f5785a.compareAndSet(false, true) == false) goto L5;
        CacheItemStatus r5 = CacheItemStatus.f5915c;
        com.bytedance.ies.bullet.service.base.e r12 = this.f5798r;
        this.f5797q.mo2invoke(r5, r12);
    L5:
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        this.f5793m = true;
        this.f5794n = r11;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void s(Uri r5, hb.a r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void u(Uri r5, com.bytedance.ies.bullet.core.container.e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        CacheItemStatus r11 = CacheItemStatus.f5913a;
        com.bytedance.ies.bullet.service.base.e r12 = this.f5798r;
        this.f5797q.mo2invoke(r11, r12);
        if (r10 == null) goto L7;
        com.bytedance.ies.bullet.core.e r13 = r10.getBulletContext();
        if (r13 == null) goto L7;
        com.bytedance.ies.bullet.core.c r14 = r13.f5308w;
    L8:
        if (r14 == null) goto L11;
        r14.f5275b = Boolean.TRUE;
    L11:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.d = true;
        this.e = r5;
        this.f = r10;
        return;
    L7:
        r14 = null;
        goto L8
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        this.g = true;
        this.f5788h = r11;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void w(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f5791k = true;
    }
}
