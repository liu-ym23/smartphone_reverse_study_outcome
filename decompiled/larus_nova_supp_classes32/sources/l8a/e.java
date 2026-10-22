package l8a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.executors.HandlerExecutorServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends HandlerExecutorServiceImpl {
    public static volatile e a;
    public static Handler b;

    public static e a() {
        if (a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        Handler r1 = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
        b = r1;     // Catch: Throwable -> L11
        a = new e(r1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public e(Handler r1) {
        super(r1);
    }

    public final void execute(Runnable r3) {
        if (isHandlerThread() == false) goto L5;
        r3.run();
        return;
    L5:
        Handler r0 = b;
        if (r0 == null) goto L13;
        Message r4 = Message.obtain(r0, r3);
        if (Build.VERSION.SDK_INT < 22) goto L10;
        r4.setAsynchronous(true);
    L10:
        b.sendMessageAtFrontOfQueue(r4);
        return;
    }
}
