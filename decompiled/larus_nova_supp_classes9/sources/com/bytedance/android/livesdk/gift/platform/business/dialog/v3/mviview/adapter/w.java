package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends BasePanelViewHolderItem {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final void v(com.bytedance.android.anya.k<ItemListData> r2, ItemListData r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$handleUIDiff");
        Intrinsics.checkNotNullParameter(r3, "state");
    }

    public w(ViewGroup r7, int r8, int r9, boolean r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        int r4 = -1;
    L7:
        if ((r11 & 8) == 0) goto L9;
        boolean r5 = false;
    L10:
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r7, "parent");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.d.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.c.f() == false) goto L16;
        GiftPanelViewPreloadService.l.getClass();
        View r13 = GiftPanelViewPreloadService.a.a(2131565255);
        if (r13 == null) goto L16;
    L23:
        super(r7, r13, r8, r4, r5);
        return;
    L16:
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L22;
        GiftPanelNitaViewInfo r14 = GiftPanelNitaViewInfo.TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL;
        int r15 = r14.getResId();
        String r16 = r14.getTag();
        Context r0 = r7.getContext();
        if (r0 == null) goto L21;
        r13 = NitaInflateUtil.a(r15, r16, (Activity) r0, r7, false);
        goto L23
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L22:
        r13 = LayoutInflater.from(r7.getContext()).inflate(2131565255, r7, false);
        goto L23
    L9:
        r5 = r10;
        goto L10
    L5:
        r4 = r9;
        goto L7
    }
}
