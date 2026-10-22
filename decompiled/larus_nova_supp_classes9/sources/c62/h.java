package c62;

import io.reactivex.functions.Consumer;
import zg1.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ d a;

    public h(d r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((k1) r2).a == false) goto L11;
        com.ss.ugc.live.sdk.msg.network.l r3 = this.a.h;
        if ((r3 instanceof im2.k) == true) goto L7;
        r3 = null;
    L7:
        im2.k r4 = (im2.k) r3;
        if (r4 == null) goto L12;
        r4.b("login status changed");
        return;
    L12:
        return;
    }
}
