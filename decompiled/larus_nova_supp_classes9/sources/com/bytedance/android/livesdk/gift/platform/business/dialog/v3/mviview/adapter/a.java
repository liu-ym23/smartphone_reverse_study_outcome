package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenBackpackGiftRecord;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseMVIListItem<ItemListData, GiftAction> {
    public final View l;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0044a implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ a b;

        public ViewOnClickListenerC0044a(View r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.b.o(new OpenBackpackGiftRecord(this.a.getContext()));
        }
    }

    public a(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L9;
        GiftPanelNitaViewInfo r0 = GiftPanelNitaViewInfo.TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM;
        int r2 = r0.getResId();
        String r1 = r0.getTag();
        Context r3 = r5.getContext();
        if (r3 == null) goto L8;
        View r6 = NitaInflateUtil.a(r2, r1, (Activity) r3, r5, false);
    L10:
        super(r6, new ItemListData());
        View r7 = ((BaseMVIListItem) this).j.findViewById(2131363823);
        r7.setOnClickListener(new ViewOnClickListenerC0044a(r7, this));
        Unit r4 = Unit.INSTANCE;
        this.l = r7;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L9:
        r6 = LayoutInflater.from(r5.getContext()).inflate(2131566116, null, false);
        goto L10
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        ItemListData r4 = (ItemListData) r3;
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r4, "state");
        r0<ItemListData, ItemStatus> r5 = r4.getItemStatus();
        Object r0 = r2.c.a(r5);
        if (r0 == null) goto L6;
        r2.b.a.invoke(r5);
        ItemStatus r1 = (ItemStatus) r0;
        return;
    }
}
