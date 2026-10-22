package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TryLoadMoreAction;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 extends BaseMVIListItem<ItemListData, GiftAction> {
    public final LiveDoubleColorBallAnimationView l;
    public final int m;
    public final Function0<Long> n;

    public final void g() {
        this.l.b();
        o(new TryLoadMoreAction(this.m, ((Number) this.n.invoke()).longValue()));
    }

    public final void i() {
        this.l.c();
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter((ItemListData) r3, "state");
    }

    public c0(ViewGroup r5, int r6, Function0<Long> r7) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r7, "getSelectedTopicId");
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L9;
        GiftPanelNitaViewInfo r0 = GiftPanelNitaViewInfo.TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM;
        int r2 = r0.getResId();
        String r1 = r0.getTag();
        Context r3 = r5.getContext();
        if (r3 == null) goto L8;
        View r8 = NitaInflateUtil.a(r2, r1, (Activity) r3, r5, false);
    L10:
        super(r8, new ItemListData());
        this.m = r6;
        this.n = r7;
        this.l = ((BaseMVIListItem) this).j.findViewById(2131379091);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L9:
        r8 = LayoutInflater.from(r5.getContext()).inflate(2131565257, r5, false);
        goto L10
    }
}
