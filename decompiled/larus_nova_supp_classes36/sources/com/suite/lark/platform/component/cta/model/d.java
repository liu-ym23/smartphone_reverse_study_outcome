package com.suite.lark.platform.component.cta.model;

import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static com.larksuite.rucket.job.base.b a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        goc.b r3 = (goc.b) new Gson().fromJson(r2, goc.b.class);     // Catch: Exception -> L8
        if (r3.a() == 0) goto L6;
        com.larksuite.rucket.job.base.b.b r0 = new com.larksuite.rucket.job.base.b.b(new ErrorResult(r3.c()));     // Catch: Exception -> L8
    L11:
        return r0;
    L6:
        r0 = new com.larksuite.rucket.job.base.b.c(r3);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        return new com.larksuite.rucket.job.base.b.b(new ErrorResult(e));
    }
}
