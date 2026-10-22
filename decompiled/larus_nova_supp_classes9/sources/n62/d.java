package n62;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Action {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void run() {
        c r0 = this.a;
        r0.g.removeListener(r0);
    }
}
