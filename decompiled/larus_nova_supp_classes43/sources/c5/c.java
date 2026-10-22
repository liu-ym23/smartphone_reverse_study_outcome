package c5;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(Runnable r0, Throwable r1) {
        if (r1 == null) goto L4;
    L13:
        Throwable r10 = null;
    L14:
        if (r10 == null) goto L20;
        Logger.throwException(r10);
        return;
    L20:
        return;
    L4:
        if ((r0 instanceof Future) == false) goto L13;
        Future r11 = (Future) r0;
        if (r11.isDone() == false) goto L13;
        if (r11.isCancelled() == true) goto L13;
        r11.get();     // Catch: ExecutionException -> L11 Throwable -> L17
    L11:
        e = move-exception;
        r10 = e.getCause();
        goto L14
    }
}
