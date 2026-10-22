package com.ss.ugc.effectplatform.task;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z implements com.ss.ugc.effectplatform.download.e {
    public final /* synthetic */ y a;
    public final /* synthetic */ Ref.ObjectRef b;

    public final void onStart() {
    }

    public final void a(com.ss.ugc.effectplatform.download.g r5) {
        if (r5.a() == false) goto L5;
        a0.b r0 = this.a.f;
        r0.a = Long.valueOf(r5.d);
        a0.b r1 = this.a.e;
        r1.a = Long.valueOf(r5.a);
        long r2 = r5.e;
        int r6 = elc.a.a;
        long r3 = r2 / ((long) 1024);
        a0.b r7 = this.a.g;
        r7.a = Long.valueOf(r3);
        this.a.h.setZipSize(r3);
        return;
    L5:
        Ref.ObjectRef r4 = this.b;
        r4.element = r5.f;
    }

    public z(y r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onProgress(int r2, long r3) {
        y r0 = this.a;
        r0.g(r0, r2, r3);
    }
}
