package e3;

import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<T> implements f<T> {
    public WeakReference<T> a;

    @Override // e3.f
    public final T provideInstance() {
        WeakReference<T> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // e3.f
    public final void release() {
        WeakReference<T> r0 = this.a;
        if (r0 == null) goto L5;
        T r1 = r0.get();
    L7:
        if ((r1 instanceof b) == true) goto L17;
    L12:
        WeakReference<T> r10 = this.a;
        if (r10 == null) goto L15;
        r10.clear();
    L15:
        this.a = null;
        return;
    L17:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        ((b) r1).a();     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public h(T r10) {
        if (r10 != null) goto L5;
        WeakReference<T> r11 = null;
    L6:
        this.a = r11;
        return;
    L5:
        r11 = new WeakReference(r10);
        goto L6
    }
}
