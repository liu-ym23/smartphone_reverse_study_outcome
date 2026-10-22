package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f6968a = null;

    static {
        f6968a = new ah.b("pia.internal.tracing.set", PiaMethod$Scope.f6954c, new a(4));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        nh.d r13 = r5.f17099b;
        List<a0> r14 = ((b0) r10).f6966a;
        if (r14 == null) goto L12;
        Iterator<a0> r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L12;
        a0 r16 = r15.next();
        if (TextUtils.isEmpty(r16.f6962a) == true) goto L6;
        Long r17 = r16.f6963b;
        if (r17 == null) goto L6;
        r13.s.c(r16.f6962a, r17.longValue());
    L12:
        r11.accept(null);
    }
}
