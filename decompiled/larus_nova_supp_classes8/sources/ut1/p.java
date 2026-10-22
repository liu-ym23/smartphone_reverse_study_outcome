package ut1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.livesdk.drawer.LiveMergeDrawerAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements Runnable {
    public final /* synthetic */ LiveMergeDrawerAdapter a;
    public final /* synthetic */ Integer b;

    public p(LiveMergeDrawerAdapter r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CenterScrollLayoutManager r0 = this.a.g;     // Catch: Throwable -> L4
        int r1 = this.b.intValue();     // Catch: Throwable -> L4
        LiveMergeDrawerAdapter r2 = this.a;     // Catch: Throwable -> L4
        r0.scrollToPositionWithOffset(r1, (r2.e / 2) - (s1.f(r2.d) / 2));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
