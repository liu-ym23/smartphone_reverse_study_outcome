package com.ss.android.lark.feed.shared.page.experiment;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedCallbackExecutor {
    public static final FeedCallbackExecutor a = null;
    public static volatile WeakReference<RecyclerView> b;
    public static final ConcurrentHashMap<String, Runnable> c = null;
    public static final FeedCallbackExecutor$onScrollListener$1 d = null;

    public FeedCallbackExecutor() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor$onScrollListener$1] */
    static {
        a = new FeedCallbackExecutor();
        c = new ConcurrentHashMap();
        d = new FeedCallbackExecutor$onScrollListener$1();
    }

    public static RecyclerView d() {
        WeakReference<RecyclerView> r0 = b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public static void b() {
        RecyclerView r0 = d();
        StringBuilder r2 = new StringBuilder("detach: ");
        if (r0 == null) goto L5;
        String r4 = r0.getClass().getSimpleName();
    L6:
        r2.append(r4);
        r2.append('@');
        if (r0 == null) goto L9;
        int r5 = r0.hashCode();
    L10:
        r2.append(r5);
        Log.i("FeedCallbackExecutor", r2.toString());
        if (r0 != null) goto L13;
        return;
    L13:
        monitor-enter(FeedCallbackExecutor.class);
        Log.i("FeedCallbackExecutor", "detach clear observingRecyclerViewRef");     // Catch: Throwable -> L20
        a.getClass();     // Catch: Throwable -> L20
        RecyclerView r1 = d();     // Catch: Throwable -> L20
        if (r1 == null) goto L17;
        r1.removeOnScrollListener(d);     // Catch: Throwable -> L20
    L17:
        b = null;     // Catch: Throwable -> L20
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(FeedCallbackExecutor.class);
        return;
    L20:
        th = move-exception;
        throw th;
    L9:
        r5 = 0;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static void a(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Log.i("FeedCallbackExecutor", "attach: " + r2.getClass().getSimpleName() + '@' + r2.hashCode());
        b = new WeakReference(r2);
        r2.addOnScrollListener(d);
    }

    public static void c(Runnable r3) {
        Intrinsics.checkNotNullParameter("afterDispatchDiff", "key");
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (d() != null) goto L5;
    L19:
        UICallbackExecutor.execute(r3);
        return;
    L5:
        monitor-enter(FeedCallbackExecutor.class);
        a.getClass();     // Catch: Throwable -> L16
        RecyclerView r2 = d();     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
    L14:
        monitor-exit(FeedCallbackExecutor.class);
        goto L19
    L9:
        if (r2.getScrollState() == 0) goto L13;
        c.put("afterDispatchDiff", r3);     // Catch: Throwable -> L16
        monitor-exit(FeedCallbackExecutor.class);
        return;
    L13:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
