package r91;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements w91.a {
    public static final Disposable a = null;
    public static final e b = null;

    public e() {
    }

    @Override // w91.a
    public final int a() {
        return 0;
    }

    @Override // w91.a
    public final boolean b(w91.a.InterfaceC0339a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return false;
    }

    @Override // w91.a
    public final boolean c(w91.a.InterfaceC0339a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return false;
    }

    @Override // w91.a
    public final void d() {
    }

    @Override // w91.a
    public final boolean e(w91.a.InterfaceC0339a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return false;
    }

    static {
        b = new e();
        a = Disposables.empty();
    }

    @Override // w91.a
    public final Disposable execute() {
        return a;
    }
}
