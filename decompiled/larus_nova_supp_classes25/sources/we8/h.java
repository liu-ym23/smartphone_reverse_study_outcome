package we8;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ h(int r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a;
        Iterator r1 = j.b.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        j.a r2 = (j.a) r1.next();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        r2.a(r0);     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L4;
        FLogger.a.e("ThemeAdjustManager", "notify DarkModeObserver failed", r5);
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
