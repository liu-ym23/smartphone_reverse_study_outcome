package com.bytedance.pia.core.plugins;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh.c;
import nh.d;
import rh.i;
import yg.b;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/plugins/PrefetchPlugin;", "Lnh/c;", "Lnh/d;", "runtime", "Lyg/b;", "manifest", "<init>", "(Lnh/d;Lyg/b;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PrefetchPlugin extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f7047c;
    public p d;

    public PrefetchPlugin(d r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "runtime");
        Intrinsics.checkNotNullParameter(r10, "manifest");
        super(r5);
        this.f7047c = r10;
    }

    @Override // nh.c
    public final String c() {
        return "prefetch";
    }

    @Override // nh.c
    public final void f() {
        this.d = new p(this.f20236b, this.f7047c);
    }

    @Override // nh.c, fh.c
    public final void release() {
        p r5 = this.d;
        if (r5 == null) goto L8;
        i r10 = (i) r5.f23313c;
        if (r10 == null) goto L9;
        r10.b(null);
        return;
    L9:
        return;
    }
}
