package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchPanelInfoListener;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 implements IFetchPanelInfoListener {
    public final /* synthetic */ LiveStickerDataManager a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.k.d b;
    public final /* synthetic */ String c;

    public final void onFail(ExceptionResult r3) {
        com.bytedance.android.live.effect.api.k.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.onFetchFailed();
    L5:
        String r1 = this.c;
        if (r3 == null) goto L8;
        int r2 = r3.getErrorCode();
    L9:
        if (r3 == null) goto L11;
        String r4 = r3.getMsg();
    L12:
        LiveEffectMonitor.e(r1, r2, r4);
        return;
    L11:
        r4 = null;
        goto L12
    L8:
        r2 = -1;
        goto L9
    }

    public final void onSuccess(Object r3) {
        PanelInfoModel r4 = (PanelInfoModel) r3;
        if (r4 != null) goto L5;
    L11:
        com.bytedance.android.live.effect.api.k.d r5 = this.b;
        if (r5 == null) goto L14;
        r5.onFetchFailed();
    L14:
        LiveEffectMonitor.e(this.c, 1000, "fetchPanelInfo empty result");
        return;
    L5:
        if (r4.getCategoryList().isEmpty() == true) goto L11;
        this.a.d.put(this.c, r4);
        com.bytedance.android.live.effect.api.k.d r0 = this.b;
        if (r0 == null) goto L10;
        r0.a(r4, EffectDataFetchCacheType.NoCache);
    L10:
        LiveEffectMonitor.f(this.c, r4.getCategoryList());
    }

    public b0(LiveStickerDataManager r1, com.bytedance.android.live.effect.api.k.d r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
