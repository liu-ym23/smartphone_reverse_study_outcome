package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public static final h<Object> a = null;
    public static final int b = 0;
    public static final int c = 0;
    public static final b0 d = null;
    public static final b0 e = null;
    public static final b0 f = null;
    public static final b0 g = null;
    public static final b0 h = null;
    public static final b0 i = null;
    public static final b0 j = null;
    public static final b0 k = null;
    public static final b0 l = null;
    public static final b0 m = null;
    public static final b0 n = null;
    public static final b0 o = null;
    public static final b0 p = null;
    public static final b0 q = null;
    public static final b0 r = null;
    public static final b0 s = null;

    static {
        a = new h(-1, null, null, 0);
        b = c0.b("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);
        c = c0.b("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);
        d = new b0("BUFFERED");
        e = new b0("SHOULD_BUFFER");
        f = new b0("S_RESUMING_BY_RCV");
        g = new b0("RESUMING_BY_EB");
        h = new b0("POISONED");
        i = new b0("DONE_RCV");
        j = new b0("INTERRUPTED_SEND");
        k = new b0("INTERRUPTED_RCV");
        l = new b0("CHANNEL_CLOSED");
        m = new b0("SUSPEND");
        n = new b0("SUSPEND_NO_WAITER");
        o = new b0("FAILED");
        p = new b0("NO_RECEIVE_RESULT");
        q = new b0("CLOSE_HANDLER_CLOSED");
        r = new b0("CLOSE_HANDLER_INVOKED");
        s = new b0("NO_CLOSE_CAUSE");
    }

    public static final <T> boolean a(kotlinx.coroutines.i<? super T> r0, T r1, Function1<? super Throwable, Unit> r2) {
        b0 r3 = r0.b(r1, r2);
        if (r3 == null) goto L5;
        r0.d(r3);
        return true;
    L5:
        return false;
    }
}
