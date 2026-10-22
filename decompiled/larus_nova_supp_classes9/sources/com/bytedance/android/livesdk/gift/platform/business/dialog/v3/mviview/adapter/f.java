package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends GiftPanelIconLoadListener {
    public final /* synthetic */ BasePanelViewHolderItem h;
    public final /* synthetic */ Long i;
    public final /* synthetic */ h1 j;

    @Override // com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener
    public final Map<String, String> g() {
        HashMap r0 = new HashMap();
        h1 r1 = this.j;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.getId());
    L6:
        r0.put("gift_id", String.valueOf(r3));
        h1 r4 = this.j;
        if (r4 == null) goto L9;
        r2 = Integer.valueOf(r4.getType());
    L9:
        r0.put("gift_type", String.valueOf(r2));
        r0.put("position", String.valueOf(this.h.p()));
        r0.put("tab_position", String.valueOf(this.h.a0));
        r0.put("icon_type", "show_item");
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener
    public final void b(py.k r5, Exception r6) {
        super.b(r5, r6);
        Long r0 = this.i;
        if (r0 == null) goto L18;
        r0.longValue();
        long r1 = this.i.longValue();
        String r2 = BuildConfig.FLAVOR;
        if (r5 == null) goto L8;
        String r3 = r5.getUri();
        if (r3 == null) goto L8;
    L9:
        if (r5 == null) goto L11;
        List r7 = r5.getUrls();
    L12:
        String r8 = r6.getMessage();
        if (r8 == null) goto L16;
        r2 = r8;
    L16:
        com.bytedance.android.livesdk.gift.platform.core.c0.c(r1, r3, r7, r2);
        return;
    L11:
        r7 = null;
    L8:
        r3 = BuildConfig.FLAVOR;
        goto L9
    }

    public f(BasePanelViewHolderItem r1, Long r2, h1 r3, GiftContext r4) {
        this.h = r1;
        this.i = r2;
        this.j = r3;
        super(r4);
    }

    @Override // com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener
    public final void c(py.k r2, int r3, int r4, boolean r5) {
        super.c(r2, r3, r4, r5);
        GiftContext r6 = this.h.X;
        if (r6 != null) goto L5;
        return;
    L5:
        if (((Number) r6.getFirstGiftImageRenderSucAt().getValue()).longValue() != 0) goto L9;
        this.h.X.getFirstGiftImageRenderSucAt().setValue(Long.valueOf(System.currentTimeMillis()));
        return;
    }
}
