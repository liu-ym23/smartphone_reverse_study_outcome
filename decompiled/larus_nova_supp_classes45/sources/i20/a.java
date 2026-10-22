package i20;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final CompositeDisposable a;

    public final void b() {
        this.a.clear();
    }

    public a() {
        this.a = new CompositeDisposable();
    }

    public final void a(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.a.add(r2);
    }
}
