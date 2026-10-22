package a40;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ long b;

    public c(d40.a.b r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
        o r5 = this.a;
        if (r5 == null) goto L6;
        dc6.a.a(this.b);
        r5.onPingSuccess();
        return;
    }
}
