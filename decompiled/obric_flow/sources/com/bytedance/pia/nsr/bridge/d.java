package com.bytedance.pia.nsr.bridge;

import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.nsr.h;
import com.lynx.jsbridge.LynxResourceModule;
import ko.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f7180a = null;

    static {
        f7180a = new ah.b("pia.nsr", PiaMethod$Scope.f6953b, a.f7175a);
    }

    @Override // ah.a
    public final void a(gh.c r10, Object r11, final gh.b r12, final n0 r13) {
        b r14 = (b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridge");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        if (r14.d() != null) goto L6;
        td.b.c("Parameter 'url' requested!", r13);
        return;
    L6:
        nh.d r5 = r10.f17099b;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.pia.core.runtime.PiaRuntime");
        r r15 = h.f7194a;
        String r16 = r14.d();
        Long r17 = r14.a();
        if (r17 == null) goto L10;
        long r18 = r17.longValue();
    L9:
        long r19 = r18;
        String r20 = r14.b();
        if (r20 != null) goto L14;
        r20 = r5.e;
    L14:
        String r21 = r20;
        Boolean r22 = r14.c();
        if (r22 == null) goto L17;
        boolean r23 = r22.booleanValue();
    L18:
        h.b(r16, r19, r21, !r23, r5, new PiaNsrMethod$invoke$1(r12), new PiaNsrMethod$invoke$2(r13));
        return;
    L17:
        r23 = true;
        goto L18
    L10:
        r18 = 60000;
        goto L9
    }
}
