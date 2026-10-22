package u82;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends q46.b<Object> {
    public final CompositeDisposable b;

    public final void detachView() {
        ((q46.b) this).a = null;
        this.b.clear();
    }

    public m() {
        this.b = new CompositeDisposable();
    }
}
