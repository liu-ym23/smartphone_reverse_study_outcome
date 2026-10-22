package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.model.net.EffectListResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements r {
    public final /* synthetic */ t a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ EffectListResponse e;

    @Override // com.ss.ugc.effectplatform.task.r
    public final void onSuccess() {
        t.q(this.a, this.b, this.c, this.d, this.e);
    }

    public s(t r1, long r2, long r4, long r6, EffectListResponse r8) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r8;
    }
}
