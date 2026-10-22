package srb;

import com.facebook.soloader.SoLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static volatile boolean a;
    public static volatile boolean b;

    static {
        new ReentrantLock();
    }

    public static void a() {
        if (b == true) goto L10;
        Log.i("CardPreload", "current thread name" + ThreadMethodProxy.currentThread().getName());     // Catch: IllegalStateException -> L6
        SoLoader.init(com.ss.android.lark.message.card.b.a().getContext(), false);     // Catch: IllegalStateException -> L6
    L8:
        b = true;
    L6:
        e = move-exception;
        Log.i("CardPreload", e.getMessage());
    L10:
        if (a == false) goto L12;
        return;
    L12:
        a = true;
    }
}
