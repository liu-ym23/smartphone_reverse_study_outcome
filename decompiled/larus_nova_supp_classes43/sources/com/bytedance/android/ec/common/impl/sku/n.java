package com.bytedance.android.ec.common.impl.sku;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ SkuPanelOptimizeFragment a;

    public n(SkuPanelOptimizeFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        rg.a r11 = (rg.a) r10;
        SkuPanelOptimizeFragment r12 = this.a;
        SkuPanelOptimizeFragment.b r0 = SkuPanelOptimizeFragment.r;
        SkuInfoVO r13 = (SkuInfoVO) r12.U90().getSkuInfo().a();
        rg.a r1 = (rg.a) this.a.U90().getOnItemChange().a();
        String r14 = null;
        if (r1 == null) goto L5;
        String r15 = (String) r1.b;
    L6:
        if (r13 == null) goto L14;
        Map<String, SkuItemInfoVO> r16 = r13.getSkuList();
        if (r16 == null) goto L14;
        SkuItemInfoVO r17 = r16.get(r15);
        if (r17 == null) goto L14;
        Map<String, String> r18 = r17.getShowEventTrack();
        if (r18 == null) goto L14;
    L17:
        if (r18 == null) goto L19;
        r14 = r18.get("bcm_event_track");
    L19:
        BtmSDK r19 = BtmSDK.INSTANCE;
        PageFinder r20 = PageFinder.via(this.a);
        BcmParams.Companion.getClass();
        r19.setBcmPageParams(r20, BcmParams.a.a(r14), true);
        return;
    L14:
        if (r13 == null) goto L16;
        r18 = r13.getShowTrackParams();
        goto L17
    L16:
        r18 = null;
        goto L17
    L5:
        r15 = null;
        goto L6
    }
}
