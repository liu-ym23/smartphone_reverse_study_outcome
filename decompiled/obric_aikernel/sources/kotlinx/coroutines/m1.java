package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.JvmName;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 {
    public static final Executor a(CoroutineDispatcher r10) {
        if ((r10 instanceof ExecutorCoroutineDispatcher) == false) goto L5;
        ExecutorCoroutineDispatcher r11 = (ExecutorCoroutineDispatcher) r10;
    L6:
        if (r11 == null) goto L10;
        Executor r12 = r11.c0();
        if (r12 == null) goto L10;
        return r12;
    L10:
        return new y0(r10);
    L5:
        r11 = null;
        goto L6
    }

    @JvmName(name = "from")
    public static final ExecutorCoroutineDispatcher b(ExecutorService r10) {
        return new l1(r10);
    }
}
