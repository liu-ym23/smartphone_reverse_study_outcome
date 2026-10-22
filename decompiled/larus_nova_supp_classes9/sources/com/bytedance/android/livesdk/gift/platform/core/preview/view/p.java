package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.PanelOperationState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ UgcGiftSaleDialog a;

    public p(UgcGiftSaleDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        r5.setVisibility(8);
        View r6 = this.a.q;
        int r1 = 0;
        if (r6 == null) goto L5;
        r6.setVisibility(0);
    L5:
        View r7 = this.a.v;
        if (r7 == null) goto L8;
        r7.setVisibility(8);
    L8:
        com.bytedance.android.livesdk.gift.platform.core.preview.j.b.setValue(null, com.bytedance.android.livesdk.gift.platform.core.preview.j.a[0], Boolean.FALSE);
        this.a.T90(PanelOperationState.Top);
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r8 = this.a.m;
        if (r8 == null) goto L11;
        r8.B2();
    L11:
        com.bytedance.android.livesdk.gift.platform.core.preview.a r9 = com.bytedance.android.livesdk.gift.platform.core.preview.a.a;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r0 = this.a.m;
        if (r0 == null) goto L14;
        r1 = r0.getItemCount();
    L14:
        UgcGiftSaleDialog r2 = this.a;
        int r3 = r2.d;
        String r4 = r2.e;
        r9.getClass();
        com.bytedance.android.livesdk.gift.platform.core.preview.a.a(r1, r3, r4, "top");
    }
}
