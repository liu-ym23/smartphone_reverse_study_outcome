package com.larus.platform.service;

import android.content.Context;
import com.larus.office.base.host.o;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h1 implements com.larus.platform.api.q0 {
    public static final h1 a = null;
    public static final Lazy b = null;

    public h1() {
    }

    static {
        a = new h1();
        b = LazyKt.lazy(new g1());
    }

    @Override // com.larus.platform.api.q0
    public final void M(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        com.larus.platform.api.q0 r0 = (com.larus.platform.api.q0) b.getValue();
        if (r0 == null) goto L6;
        r0.M(r2);
        return;
    }

    public final boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L9;
        o r1 = r0.u();
        if (r1 == null) goto L9;
        if (r1.a(r3) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.q0
    public final boolean L(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        com.larus.platform.api.q0 r0 = (com.larus.platform.api.q0) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.L(r2, r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.q0
    public final boolean N(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "redirectUri");
        com.larus.platform.api.q0 r0 = (com.larus.platform.api.q0) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.N(r2, r3) != true) goto L7;
        return true;
    }
}
