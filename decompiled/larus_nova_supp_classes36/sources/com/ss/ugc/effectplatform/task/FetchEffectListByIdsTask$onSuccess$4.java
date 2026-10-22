package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.model.net.EffectListResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchEffectListByIdsTask$onSuccess$4 implements r {
    public final /* synthetic */ FetchEffectListByIdsTask a;
    public final /* synthetic */ EffectListResponse b;

    @Override // com.ss.ugc.effectplatform.task.r
    public final void onSuccess() {
        this.a.e(new FetchEffectListByIdsTask$onSuccess$4$onSuccess$1(this));
    }

    public FetchEffectListByIdsTask$onSuccess$4(FetchEffectListByIdsTask r1, EffectListResponse r2) {
        this.a = r1;
        this.b = r2;
    }
}
