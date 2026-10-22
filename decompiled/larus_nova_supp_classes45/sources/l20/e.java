package l20;

import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements a, o {
    public final c a;
    public final CompositeDisposable b;
    public final XplayMonitorSession c;

    public final void onStart() {
    }

    public final void onStop() {
        c r0 = this.a;
        r0.b.clear();
        r0.a = null;
        this.b.dispose();
    }

    public e(p r2, XplayMonitorSession r3) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "monitorSession");
        this.c = r3;
        this.a = new c();
        this.b = new CompositeDisposable();
    }
}
