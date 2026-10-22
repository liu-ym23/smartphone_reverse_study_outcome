package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.PanelOperationState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ UgcGiftSaleDialog a;

    public q(UgcGiftSaleDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        r4.setVisibility(8);
        View r5 = this.a.s;
        int r0 = 0;
        if (r5 == null) goto L5;
        r5.setVisibility(0);
    L5:
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r6 = this.a.m;
        if (r6 == null) goto L8;
        r6.A2();
    L8:
        this.a.T90(PanelOperationState.Remove);
        com.bytedance.android.livesdk.gift.platform.core.preview.a r7 = com.bytedance.android.livesdk.gift.platform.core.preview.a.a;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r1 = this.a.m;
        if (r1 == null) goto L11;
        r0 = r1.getItemCount();
    L11:
        UgcGiftSaleDialog r2 = this.a;
        int r3 = r2.d;
        String r8 = r2.e;
        r7.getClass();
        com.bytedance.android.livesdk.gift.platform.core.preview.a.a(r0, r3, r8, "save");
    }
}
