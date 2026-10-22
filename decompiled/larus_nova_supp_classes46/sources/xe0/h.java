package xe0;

import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public long a;
    public long b;
    public Disposable c;
    public final CopyOnWriteArrayList<a> d;

    public interface a {
        void B0(long r1);
    }

    public h() {
        this.d = new CopyOnWriteArrayList();
    }

    public final void a(boolean r6, Long r7) {
        long r0 = this.b;
        if (r0 >= 1000) goto L9;
        if (r6 == false) goto L6;
        int r8 = fj0.d.a;
        fj0.d.b(r0, this.a);
    L7:
        String r9 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.k(LinkmicOnlineFloatWindowManager.c.a(), null, Boolean.TRUE, 1);
        return;
    L6:
        int r10 = fj0.d.a;
        fj0.d.a(r0, this.a, r7);
        goto L7
    }
}
