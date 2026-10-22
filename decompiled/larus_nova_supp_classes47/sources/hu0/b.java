package hu0;

import com.bytedance.android.live.profit.format.voicechat.viewmodel.f;
import io.reactivex.functions.Consumer;
import nu0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ a.InterfaceC0249a b;

    public b(a r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        j.c(this.a, "on chat start timeout!!", null, 6);
        this.b.c("aiNotJoin");
    }
}
