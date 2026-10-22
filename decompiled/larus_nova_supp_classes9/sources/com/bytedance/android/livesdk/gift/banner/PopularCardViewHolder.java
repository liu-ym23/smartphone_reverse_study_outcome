package com.bytedance.android.livesdk.gift.banner;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class PopularCardViewHolder extends SimpleGiftViewHolder {
    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder
    public final void T3(AbsPanel r5) {
        super.T3(r5);
        Context r0 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        T r1 = r5.h;
        if ((r1 instanceof l2) == true) goto L15;
        r0.getResources().getColor(2131106882);
        T r6 = r5.h;
        if ((r6 instanceof l2) == false) goto L17;
        l2 r7 = (l2) r6;
        if (r7.getCount() > 0) goto L13;
        r0.getString(2131922975);
        r0.getResources().getColor(2131108107);
        throw null;
    L13:
        r7.getDescription();
        r0.getResources().getColor(2131106882);
        throw null;
    L17:
        throw null;
    L15:
        l2 r2 = (l2) r1;
        throw null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        super.onViewAttachedToWindow(r2);
        T r3 = this.b.h;
        if ((r3 instanceof l2) == true) goto L5;
        return;
    L5:
        l2 r4 = (l2) r3;
        throw null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        throw null;
    }
}
