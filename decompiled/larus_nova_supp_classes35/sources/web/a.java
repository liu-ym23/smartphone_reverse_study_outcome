package web;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a() {
        FeedCallbackExecutor.a.getClass();
        if (FeedCallbackExecutor.d() != null) goto L6;
        Log.i("FeedCallbackExecutor", "flush skipped: recyclerView is null, clearing runnableMap");
        FeedCallbackExecutor.c.clear();
        return;
    L6:
        Iterator<Map.Entry<String, Runnable>> r0 = FeedCallbackExecutor.c.entrySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<String, Runnable> r2 = r0.next();
        String r3 = r2.getKey();
        Runnable r4 = r2.getValue();
        Log.i("FeedCallbackExecutor", "flush Runnable " + r3);
        r4.run();
        goto L8
    L10:
        FeedCallbackExecutor.c.clear();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
