package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGuideItemClick;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends BaseMVIListItem<ItemListData, GiftAction> {
    public final TextView l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == false) goto L5;
            this.a.o(new OnGuideItemClick(15));
            return;
        L5:
            this.a.o(new ClickTabItem(0, 15, true));
        }
    }

    static {
    }

    public final void g() {
        this.l.setText("去“发现”更多礼物");
        ((BaseMVIListItem) this).j.setOnClickListener(new b(this));
    }

    public u(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r4, "parent");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.d.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.a() == false) goto L7;
        GiftPanelViewPreloadService.l.getClass();
        View r0 = GiftPanelViewPreloadService.a.a(2131566126);
        if (r0 == null) goto L7;
    L8:
        super(r0, new ItemListData());
        this.l = (TextView) ((BaseMVIListItem) this).j.findViewById(2131388772);
        return;
    L7:
        r0 = LayoutInflater.from(r4.getContext()).inflate(2131566126, r4, false);
        goto L8
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter((ItemListData) r3, "state");
    }
}
