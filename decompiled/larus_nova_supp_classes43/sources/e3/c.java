package e3;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<T> implements f<T> {
    public T a;

    @Override // e3.f
    public final void release() {
        T r0 = this.a;
        if ((r0 instanceof b) == true) goto L10;
    L8:
        this.a = null;
        return;
    L10:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        ((b) r0).a();     // Catch: Throwable -> L6
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // e3.f
    public final T provideInstance() {
        return this.a;
    }

    public c(T r1) {
        this.a = r1;
    }
}
