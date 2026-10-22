package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class z extends AbstractCoroutineContextElement implements u1<String> {
    public static final a a = null;

    static {
        a = new a();
    }

    public z() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof z) == true) goto L9;
        return false;
    L9:
        ((z) r3).getClass();
        return true;
    }

    public final int hashCode() {
        return (int) 0;
    }

    public final String toString() {
        return "CoroutineId(0)";
    }

    public final Object updateThreadContext(CoroutineContext r9) {
        a0 r10 = r9.get(a0.b);
        if (r10 == null) goto L6;
        String r11 = r10.a;
        if (r11 == null) goto L6;
    L7:
        Thread r0 = ThreadMethodProxy.currentThread();
        String r7 = r0.getName();
        int r1 = StringsKt.lastIndexOf$default(r7, " @", 0, false, 6, null);
        if (r1 >= 0) goto L10;
        r1 = r7.length();
    L10:
        StringBuilder r3 = new StringBuilder((r11.length() + r1) + 10);
        r3.append(r7.substring(0, r1));
        r3.append(" @");
        r3.append(r11);
        r3.append("#0");
        ThreadMethodProxy.setName(r0, r3.toString());
        return r7;
    L6:
        r11 = "coroutine";
        goto L7
    }

    public final void restoreThreadContext(CoroutineContext r1, Object r2) {
        Thread r3 = ThreadMethodProxy.currentThread();
        ThreadMethodProxy.setName(r3, (String) r2);
    }
}
