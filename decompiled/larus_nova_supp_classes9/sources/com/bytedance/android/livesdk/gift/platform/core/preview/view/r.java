package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ UgcGiftSaleDialog a;

    public r(UgcGiftSaleDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a r10 = (com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a) r9;
        if (r10 == null) goto L54;
        UgcGiftSaleDialog r0 = this.a;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r1 = r0.m;
        if (r1 == null) goto L8;
        r1.y2(r10, r0.d, r0.e);
    L8:
        UgcGiftSaleDialog r2 = this.a;
        int r3 = r10.a.size();
        int r4 = UgcGiftSaleDialog.z;
        TextView r5 = r2.h;
        boolean r6 = false;
        if (r5 == null) goto L11;
        r5.setVisibility(0);
    L11:
        TextView r7 = r2.h;
        if (r7 == null) goto L15;
        r7.setText(r2.getString(2131917631, new Object[]{String.valueOf(r3)}));
    L15:
        if (this.a.w == true) goto L53;
        Iterator<com.bytedance.android.livesdk.gift.platform.core.preview.b> r11 = r10.a.iterator();
        int r8 = 0;
    L18:
        if (r11.hasNext() == false) goto L29;
        long r13 = r11.next().a;
        Long r14 = this.a.r;
        if (r14 != null) goto L23;
    L25:
        boolean r15 = false;
    L26:
        if (r15 == true) goto L30;
        r8 = r8 + 1;
    L30:
        Integer r16 = Integer.valueOf(r8);
        if (r16.intValue() < 0) goto L33;
        r6 = true;
    L33:
        RecyclerView.LayoutManager r17 = null;
        if (r6 == true) goto L37;
        r16 = null;
    L37:
        if (r16 == null) goto L49;
        int r18 = r16.intValue();
        RecyclerView r19 = this.a.g;
        if (r19 == null) goto L41;
        RecyclerView.LayoutManager r20 = r19.getLayoutManager();
    L43:
        if ((r20 instanceof LinearLayoutManager) == false) goto L46;
        r17 = r20;
    L46:
        LinearLayoutManager r21 = (LinearLayoutManager) r17;
        if (r21 == null) goto L49;
        r21.smoothScrollToPosition(this.a.g, new RecyclerView.State(), r18);
        goto L49
    L41:
        r20 = null;
    L49:
        this.a.w = true;
        return;
    L23:
        if (r13 != r14.longValue()) goto L25;
        r15 = true;
        goto L26
    L29:
        r8 = -1;
        goto L30
    L53:
        return;
    }
}
