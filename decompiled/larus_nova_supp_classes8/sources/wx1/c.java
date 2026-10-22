package wx1;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ hw.a a;

    public c(hw.a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        hw.a r5 = this.a;
        if (r5 == null) goto L6;
        r5.onCancel(new Throwable("login fail"));
        return;
    }
}
