package com.bytedance.android.livesdk.gift.banner;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.rank.model.e;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ AbsPanel b;
    public final /* synthetic */ l2 c;
    public final /* synthetic */ String d;

    public b(d r1, AbsPanel r2, l2 r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r6) {
        ExtraResponse r7 = (ExtraResponse) r6;
        if (r7 == null) goto L11;
        e r8 = (e) r7.data;
        if (r8 == null) goto L11;
        List r9 = r8.options;
        if (r9 == null) goto L11;
        boolean r1 = true;
        if ((!r9.isEmpty()) != true) goto L11;
    L12:
        d.I(this.a, this.b, this.c, this.d, r1);
        this.a.e = false;
        return;
    L11:
        r1 = false;
        goto L12
    }
}
