package n62;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Action {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    public final void run() {
        e r0 = this.a;
        r0.j.removeListener(r0);
    }
}
