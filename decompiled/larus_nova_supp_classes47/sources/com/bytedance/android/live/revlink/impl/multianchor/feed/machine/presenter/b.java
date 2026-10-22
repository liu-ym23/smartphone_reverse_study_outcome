package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.r;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ h b;

    public b(a r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        r r6 = (r) ((ExtraResponse) r5).data;
        this.b.a(r6);
        a r0 = this.a;
        List r7 = r6.getLinkUsers();
        ((ArrayList) r0.g).clear();
        if (r7 == null) goto L5;
        ((ArrayList) r0.g).addAll(r7);
    L5:
        z41.f.d.getClass();
        if (z41.f.c == true) goto L12;
        StringBuilder r1 = new StringBuilder("updateOnlineList ");
        if (r7 == null) goto L10;
        String r8 = ef2.a.a(r7);
    L11:
        r1.append(r8);
        jy0.b.c("xuzr", r1.toString(), null, 4);
        goto L12
    L10:
        r8 = null;
    L12:
        r0.r.f().c(r0.g);
    }
}
