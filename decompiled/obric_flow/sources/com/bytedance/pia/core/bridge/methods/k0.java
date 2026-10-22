package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f6997a = null;

    static {
        f6997a = new ah.b("pia.internal.worker.postMessage", PiaMethod$Scope.f6953b, new a(6));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        j0 r13 = (j0) r10;
        if (j0.a(r13) != null) goto L5;
    L25:
        td.b.c("Parameter 'message' is required!", r12);
        return;
    L5:
        if (j0.a(r13).isJsonObject() == false) goto L25;
        nh.d r14 = r5.f17099b;
        Object r15 = r14.a(j0.b(r13));
        if ((r15 instanceof rh.i) == false) goto L10;
        rh.i r16 = (rh.i) r15;
    L11:
        if (r16 != null) goto L13;
    L17:
        r12.accept(new PiaMethod$Error(-10004));
        String r17 = j0.b(r13);
        if (r14.f20231b.get() == false) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r17) == false) goto L23;
        return;
    L23:
        r14.f20232c.remove(r17);
        return;
    L13:
        if (r16.e() == false) goto L17;
        r16.f.sendWorkerMessage(com.bytedance.pia.core.utils.j.e(j0.a(r13).getAsJsonObject()));
        r11.accept(null);
        return;
    L10:
        r16 = null;
        goto L11
    }
}
