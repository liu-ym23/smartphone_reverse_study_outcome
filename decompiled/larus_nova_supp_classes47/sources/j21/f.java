package j21;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ int b;

    public f(e r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.revlink.impl.multianchor.vm.h r6 = (com.bytedance.android.live.revlink.impl.multianchor.vm.h) r5;
        jy0.b.c("ttlive_anchor_link_panel", "fetchRecommendList from preload completed event " + r6.b + ' ' + this.b, null, 4);
        if (r6.b != this.b) goto L5;
        this.a.e(r6.a);
        return;
    L5:
        this.a.c(false);
    }
}
