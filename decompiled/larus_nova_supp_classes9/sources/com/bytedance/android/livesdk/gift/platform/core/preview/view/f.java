package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ UgcGiftPoolDialog a;

    public f(UgcGiftPoolDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a r5 = (com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a) r4;
        if (r5 == null) goto L10;
        UgcGiftPoolDialog r0 = this.a;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r1 = r0.m;
        if (r1 == null) goto L9;
        r1.y2(r5, r0.d, r0.e);
        return;
    L9:
        return;
    }
}
