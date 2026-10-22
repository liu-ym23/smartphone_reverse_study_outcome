package ra;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f21714a = null;

    static {
        f21714a = new LinkedHashMap();
    }

    public static a a(String r5) {
        LinkedHashMap r10 = f21714a;
        monitor-enter(r10);
        a r11 = (a) r10.get(r5);     // Catch: Throwable -> L8
        if (r11 != null) goto L10;
        r11 = new a();     // Catch: Throwable -> L8
        r10.put(r5, r11);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r10);
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean b(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        a r11 = a(r5);     // Catch: Throwable -> L8
        boolean r12 = false;
        int r13 = 0;
    L4:
        if (r13 >= 50) goto L11;
        r11.f21713c.lock();     // Catch: Throwable -> L8
        if (r11.f21712b == false) goto L10;
        r11.f21713c.unlock();     // Catch: Throwable -> L8
        r13 = r13 + 10;     // Catch: Throwable -> L8
        Thread.sleep(10);     // Catch: Throwable -> L8
        goto L4
    L10:
        r11.f21711a++;     // Catch: Throwable -> L8
        r11.f21713c.unlock();     // Catch: Throwable -> L8
        r12 = true;
    L11:
        Object r14 = Result.m124constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L8
    L14:
        Boolean r15 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r14) == false) goto L18;
        r14 = r15;
    L18:
        return ((Boolean) r14).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static void c(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        a r11 = a(r5);     // Catch: Throwable -> L7
        r11.f21713c.lock();     // Catch: Throwable -> L13
        if (r11.f21711a != 0) goto L9;
        ReentrantLock r12 = r11.f21713c;     // Catch: Throwable -> L7
    L11:
        r12.unlock();     // Catch: Throwable -> L7
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L9:
        r11.f21711a--;     // Catch: Throwable -> L13
        r12 = r11.f21713c;     // Catch: Throwable -> L7
        goto L11
    L13:
        th = move-exception;
        r11.f21713c.unlock();     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }
}
