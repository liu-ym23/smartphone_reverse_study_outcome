package v19;

import android.view.View;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j7 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ k7 b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        View r4 = this.a;
        k7 r0 = this.b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (r4.getViewTreeObserver().isAlive() == false) goto L6;
        r4.getViewTreeObserver().removeOnGlobalLayoutListener(r0);     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public j7(View r1, k7 r2) {
        this.a = r1;
        this.b = r2;
    }
}
