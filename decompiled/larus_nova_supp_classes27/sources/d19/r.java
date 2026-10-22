package d19;

import android.animation.Animator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r implements Runnable {
    public final /* synthetic */ Function1<Animator, Unit> a;
    public final /* synthetic */ Animator b;

    /* JADX WARN: Multi-variable type inference failed */
    public r(Function1<? super Animator, Unit> r1, Animator r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1<Animator, Unit> r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.invoke(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
