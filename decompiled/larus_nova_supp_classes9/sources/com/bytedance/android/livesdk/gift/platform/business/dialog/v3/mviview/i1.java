package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i1<T> implements Consumer {
    public final /* synthetic */ GiftOnlineReceiverMVIView a;

    public i1(GiftOnlineReceiverMVIView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRecycled() == true) goto L11;
        ViewGroup r0 = this.a.p;
        if (r0 == null) goto L12;
        r0.setBackground(new BitmapDrawable(s1.getResources(), r5));
        return;
    L12:
        return;
    }
}
