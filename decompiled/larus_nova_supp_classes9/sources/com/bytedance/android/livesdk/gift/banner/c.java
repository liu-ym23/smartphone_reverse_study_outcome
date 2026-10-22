package com.bytedance.android.livesdk.gift.banner;

import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ AbsPanel b;
    public final /* synthetic */ l2 c;
    public final /* synthetic */ String d;

    public c(d r1, AbsPanel r2, l2 r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        d.I(this.a, this.b, this.c, this.d, false);
        this.a.e = false;
    }
}
