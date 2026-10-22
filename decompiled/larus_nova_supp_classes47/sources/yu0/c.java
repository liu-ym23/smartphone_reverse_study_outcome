package yu0;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Action {
    public final /* synthetic */ Disposable a;

    public c(Disposable r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.dispose();
    }
}
