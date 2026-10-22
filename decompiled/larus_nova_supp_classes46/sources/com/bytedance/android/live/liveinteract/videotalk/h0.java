package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 implements qh0.d<rh0.a> {
    public final /* synthetic */ rj0.b a;

    public h0(rj0.b r1) {
        this.a = r1;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        this.a.onFailed(r2);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r1) {
        this.a.onSuccess();
    }
}
