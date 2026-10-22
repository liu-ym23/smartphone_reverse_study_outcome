package ri0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.i;
import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements g {
    public final /* synthetic */ MultiLinkGameWindowManager a;

    /* JADX INFO: renamed from: ri0.a$a, reason: collision with other inner class name */
    public static final class RunnableC0267a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ i b;

        public RunnableC0267a(a r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.W0(this.b.a, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(MultiLinkGameWindowManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(h r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        ALogger.e("MultiLinkGameWindowManager", "init, loadLayoutConfig failed");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(h r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        ALogger.i("MultiLinkGameWindowManager", "init, loadLayoutConfig success from " + r3.b);
        MainThreadPostUtils.e(new RunnableC0267a(this, r3));
    }
}
