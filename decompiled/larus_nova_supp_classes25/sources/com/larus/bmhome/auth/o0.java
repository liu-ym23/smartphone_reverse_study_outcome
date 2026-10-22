package com.larus.bmhome.auth;

import com.larus.platform.service.AccountService;
import com.larus.utils.t0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o0 implements Runnable {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ o0(g r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final Function1 r0 = this.a;
        String r2 = z0.b();
        if (r2.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L14;
        boolean r3 = AccountService.a.isLogin().booleanValue();
        if (r3 == false) goto L11;
        String r4 = "login";
    L12:
        final g1 r8 = new g1(r2, r3, (h0) z0.h(z0.i("launch_cache_core_info", r2, r4), h0.class), (e0) z0.h(z0.i("launch_cache_basic_info", r2, r4), e0.class), (j0) z0.h(z0.i("launch_cache_im_info", r2, r4), j0.class), (b) z0.h(z0.i("launch_cache_audio_info", r2, r4), b.class));
        t0.e(new p0(r0, r8));
        return;
    L11:
        r4 = "guest";
        goto L12
    L14:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
