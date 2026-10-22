package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CheckAnchorEffectInUsedResultModel;
import com.bytedance.android.livesdkapi.eventbus.CheckAnchorStickerStatusCallback;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t1 implements CheckAnchorStickerStatusCallback {
    public final /* synthetic */ u1 a;

    public t1(u1 r1) {
        this.a = r1;
    }

    public final void onResult(boolean r4) {
        u1 r0 = this.a;
        CheckAnchorEffectInUsedResultModel r1 = new CheckAnchorEffectInUsedResultModel();
        r1.a(CheckAnchorEffectInUsedResultModel.Code.Success);
        CheckAnchorEffectInUsedResultModel.a r2 = new CheckAnchorEffectInUsedResultModel.a();
        r2.a(Boolean.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        r1.b(r2);
        r0.finishWithResult(r1);
    }
}
