package m69;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements e {
    public static final a a = null;
    public static final CopyOnWriteArrayList<e> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new CopyOnWriteArrayList();
    }

    public static void b(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        CopyOnWriteArrayList<e> r0 = b;
        if (r0.contains(r2) == true) goto L6;
        r0.add(r2);
        return;
    }

    @Override // m69.e
    public final void a(String r6) {
        Iterator<T> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        e r1 = (e) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.a(r6);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        StringBuilder r5 = new StringBuilder("dispatchAsrResult failed, listener=");
        r5.append(r1);
        r5.append(", hasText=");
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        r5.append(true ^ r7);
        g49.d.c("DoraAsrDispatcher", r5.toString(), r4);
        goto L4
    L15:
        if (r6.length() == 0) goto L18;
        r7 = false;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
