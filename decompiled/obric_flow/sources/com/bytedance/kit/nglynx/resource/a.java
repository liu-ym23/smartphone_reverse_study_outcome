package com.bytedance.kit.nglynx.resource;

import com.bytedance.ies.bullet.base.utils.b;
import com.bytedance.ies.bullet.forest.e;
import com.bytedance.ies.bullet.kit.resourceloader.g;
import com.bytedance.ies.bullet.kit.resourceloader.h;
import com.bytedance.ies.bullet.service.base.a0;
import fo.d;
import fo.i;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements i, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f6720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.bullet.lynx.resource.forest.e f6721b;

    public a(f r5) {
        Intrinsics.checkNotNullParameter(r5, "_token");
        this.f6720a = r5;
        this.f6721b = new com.bytedance.ies.bullet.lynx.resource.forest.e(r5);
    }

    @Override // fo.i
    public final void a(final fo.e r5, final d r10) {
        Intrinsics.checkNotNullParameter(r5, "requestParams");
        f r11 = this.f6720a;
        if (u8.a.t(this, r11) == false) goto L6;
        this.f6721b.a(r5, r10);
        return;
    L6:
        final fo.f r12 = new fo.f();
        ConcurrentHashMap r13 = g.f5451a;
        h r14 = g.a(r11.getBid());
        wc.g r15 = new wc.g("");
        r15.f22846o = b.e(r11.getAllDependency());
        Unit r16 = Unit.INSTANCE;
        Function1<a0, Unit> r17 = new DefaultLynxRequestProvider$request$2(r12, r10, r5);
        Function1<Throwable, Unit> r18 = new DefaultLynxRequestProvider$request$3(r5, r10, r12);
        r14.a(r5.f16961a, r15, r17, r18);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }
}
