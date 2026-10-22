package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import com.bytedance.android.livesdk.gift.model.w1;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ FormatGiftListService a;
    public final /* synthetic */ w b;

    public e(FormatGiftListService r1, w r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        ((ArrayList) this.a.b).clear();
        List<w1> r0 = this.a.b;
        ArrayList r1 = (ArrayList) r0;
        r1.addAll(((com.bytedance.android.livesdk.gift.platform.core.model.i) r2).giftPages);
        w r3 = this.b;
        if (r3 == null) goto L6;
        r3.b(this.a.b);
        return;
    }
}
