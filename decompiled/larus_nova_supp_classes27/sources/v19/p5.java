package v19;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p5 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final WeakReference<Function0<Unit>> a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Function0<Unit> r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public p5(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "check");
        this.a = new WeakReference(r2);
    }
}
