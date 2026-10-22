package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b1 extends com.larus.audio.call.arch.a<n4> {
    public final String f;
    public final a g;

    public static final class a implements l {
        public final /* synthetic */ b1 a;
        public final /* synthetic */ n4 b;

        public final void g(boolean r1, boolean r2, t39.d r3) {
            Intrinsics.checkNotNullParameter(r3, "deviceInfo");
        }

        public a(b1 r1, n4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void f(boolean r3, boolean r4, t39.d r5) {
            Intrinsics.checkNotNullParameter(r5, "deviceInfo");
            com.larus.avlink.n1.d(this.a.f, "onWearStateChanged leftOn=" + r3 + " rightOn=" + r4);
            if (r3 == true) goto L7;
            if (r4 == true) goto L8;
            this.b.d(false, 12, 101);
            return;
        L8:
            return;
        }
    }

    public final void e3() {
        super.e3();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L8;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        r1.v0(this.g);
        return;
    L9:
        return;
    }

    public final void g3() {
        super.g3();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L8;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        r1.z0(this.g);
        return;
    L9:
        return;
    }

    public final String T2() {
        return this.f;
    }

    public b1(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraHardixPlugin";
        this.g = new a(this, r2);
    }
}
