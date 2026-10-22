package d71;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends e<v61.a> {
    public Disposable c;

    public final void a() {
        Disposable r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.dispose();
        return;
    }

    public b(v61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "msgWindow");
        super(r2);
    }
}
