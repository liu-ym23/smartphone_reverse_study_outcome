package lb;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements Action {
    public final /* synthetic */ h a;
    public final /* synthetic */ Object b;

    public g(h r1, Object r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void run() {
        this.a.a.remove(this.b);
    }
}
