package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f7024a = null;

    static {
        f7024a = new ah.b("pia.internal.cache.updateManifest", PiaMethod$Scope.f6954c, new a(1));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        JsonObject r13 = ((t) r10).f7023a;
        if (r13 != null) goto L6;
        td.b.c("'manifest' must bu not null!", r12);
        return;
    L6:
        r5.f17099b.f20245p.h(r13);
        r11.accept(null);
    }
}
