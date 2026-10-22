package com.bytedance.android.live.effect.beauty;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements com.bytedance.android.live.effect.api.k.f {
    public c() {
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r4, Sticker r5) {
        StringBuilder r6 = new StringBuilder("onDownloadFail,id:");
        String r0 = null;
        if (r5 == null) goto L5;
        Long r1 = Long.valueOf(r5.getId());
    L6:
        r6.append(r1);
        r6.append(",name:");
        if (r5 == null) goto L9;
        r0 = r5.getName();
    L9:
        r6.append(r0);
        ALogger.i("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment", r6.toString());
        if (r5 == null) goto L13;
        r5.setDownloaded(true);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r4, Sticker r5) {
        StringBuilder r6 = new StringBuilder("onDownloadStart,id:");
        String r0 = null;
        if (r5 == null) goto L5;
        Long r1 = Long.valueOf(r5.getId());
    L6:
        r6.append(r1);
        r6.append(",name:");
        if (r5 == null) goto L9;
        r0 = r5.getName();
    L9:
        r6.append(r0);
        ALogger.i("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment", r6.toString());
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r3, Sticker r4, ExceptionResult r5) {
        StringBuilder r6 = new StringBuilder("onDownloadFail,id:");
        String r7 = null;
        if (r4 == null) goto L5;
        Long r0 = Long.valueOf(r4.getId());
    L6:
        r6.append(r0);
        r6.append(",name:");
        if (r4 == null) goto L9;
        r7 = r4.getName();
    L9:
        r6.append(r7);
        ALogger.i("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment", r6.toString());
        return;
    L5:
        r0 = null;
        goto L6
    }
}
