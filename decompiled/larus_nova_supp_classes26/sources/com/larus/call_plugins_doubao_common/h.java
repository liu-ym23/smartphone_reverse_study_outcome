package com.larus.call_plugins_doubao_common;

import com.larus.call_plugins_doubao_common.manager.n0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class h extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {
    public Job f;
    public n0 g;

    public String T2() {
        return "CommonMediaFocusPlugin";
    }

    public void j3() {
    }

    public void k3() {
    }

    public void b3() {
        Job r0 = this.f;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.f = null;
    }

    public void e3() {
        super.e3();
        j3();
        k3();
    }

    public void g3() {
        super.g3();
        n0 r0 = this.g;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public h(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
