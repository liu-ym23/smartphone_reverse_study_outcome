package goa;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public final CopyOnWriteArrayList<coa.a> a;
    public volatile int b;
    public volatile int c;
    public volatile b d;
    public final Set<Integer> e;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = new CopyOnWriteArrayList();
        this.b = -1;
        this.e = SetsKt.setOf(new Integer[]{2, 3, 6});
    }

    public final void a(int r5) {
        FLogger.a.i("UpdateStateHolder", "publishProgress:" + r5);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        this.c = r5;     // Catch: Throwable -> L9
        Iterator<T> r1 = this.a.iterator();     // Catch: Throwable -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        ((coa.a) r1.next()).onProgress(r5);     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        FLogger.a.e("UpdateStateHolder", "publishProgress fail:" + r7);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void b(int r5) {
        FLogger.a.i("UpdateStateHolder", "transitTo:" + r5);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        this.b = r5;     // Catch: Throwable -> L9
        Iterator<T> r1 = this.a.iterator();     // Catch: Throwable -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        ((coa.a) r1.next()).onStateUpdate(r5);     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        FLogger.a.i("UpdateStateHolder", "transitTo fail:" + r7);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
