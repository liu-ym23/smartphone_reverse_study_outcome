package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f7022a = null;

    static {
        f7022a = new ah.b("pia.internal.worker.terminate", PiaMethod$Scope.f6953b, new a(8));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        r0 r13 = (r0) r10;
        if (TextUtils.isEmpty(r0.a(r13)) == false) goto L6;
        td.b.c("Parameter 'worker' is required!", r12);
        return;
    L6:
        nh.d r14 = r5.f17099b;
        Object r15 = r14.a(r0.a(r13));
        if ((r15 instanceof rh.i) == false) goto L9;
        rh.i r16 = (rh.i) r15;
    L10:
        if (r16 != null) goto L13;
        r12.accept(new PiaMethod$Error(-10004));
        return;
    L13:
        r16.b(null);
        String r17 = r0.a(r13);
        if (r14.f20231b.get() == false) goto L17;
    L20:
        r11.accept(null);
        return;
    L17:
        if (TextUtils.isEmpty(r17) == true) goto L20;
        r14.f20232c.remove(r17);
        goto L20
    L9:
        r16 = null;
        goto L10
    }
}
