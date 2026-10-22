package com.larus.audio.call.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class a {
    public final u0 a;

    /* JADX INFO: renamed from: com.larus.audio.call.plugins.a$a, reason: collision with other inner class name */
    public static final class C0081a {
    }

    static {
    }

    public void a(pf9.a r1) {
    }

    public void b() {
    }

    public u0 getContext() {
        return this.a;
    }

    public a(u0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public void c(String r2, Boolean r3) {
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L5;
        return;
    L5:
        getContext().e0().d(true, true, "query_begin");
    }
}
