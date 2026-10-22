package ri0;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements g {
    public final /* synthetic */ MultiLinkGameWindowManager a;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;
        public final /* synthetic */ i b;

        public a(f r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkGameWindowManager r0 = this.a.a;     // Catch: Throwable -> L4
            r0.V0 = false;     // Catch: Throwable -> L4
            r0.W0(this.b.a, false);     // Catch: Throwable -> L4
            this.a.a.V0 = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(MultiLinkGameWindowManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(h r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        ALogger.e("MultiLinkGameWindowManager", "updateLayoutConfigIfNeed, loadLayoutConfig onFailed");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(h r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        ALogger.i("MultiLinkGameWindowManager", "updateLayoutConfigIfNeed, loadLayoutConfig success");
        MultiLinkGameWindowManager r4 = this.a;
        int r0 = MultiLinkGameWindowManager.b1;
        l r5 = r4.d;
        if (r5 == null) goto L8;
        ViewGroup r6 = r5.td();
        if (r6 == null) goto L9;
        r6.post(new a(this, r3));
        return;
    L9:
        return;
    }
}
