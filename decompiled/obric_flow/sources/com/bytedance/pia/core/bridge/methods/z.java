package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f7031a = null;

    static {
        f7031a = new ah.b("pia.internal.tracing.get", PiaMethod$Scope.f6954c, new a(3));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        com.google.common.reflect.w r13 = r5.f17099b.f20247r;
        boolean r14 = ((x) r10).f7029a;
        r13.getClass();
        Gson r15 = com.bytedance.pia.core.utils.i.a();
        ArrayList r16 = (ArrayList) r13.f9377c;
        JsonArray r17 = r15.toJsonTree(r16).getAsJsonArray();
        if (r14 == false) goto L5;
        r16.clear();
    L5:
        r11.accept(new y(r17));
    }
}
