package dfb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Runnable {
    public final /* synthetic */ FeedActionEvent a;
    public final /* synthetic */ e b;

    public f(FeedActionEvent r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.a == FeedActionEvent.RIGHT_SWIPE_LONG) goto L10;
        this.b.a.cH();     // Catch: Throwable -> L7
        return;
    }
}
