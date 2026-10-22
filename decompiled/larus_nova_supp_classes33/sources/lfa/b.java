package lfa;

import android.os.IBinder;
import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements IBinder.DeathRecipient {
    public final /* synthetic */ c a;

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        ILogDepend.a.w("CaeMultipathClient", "Service binder died, reconnecting...");
        c r0 = this.a;
        r0.a = null;
        r0.c.sendEmptyMessage(1);
    }

    public b(c r1) {
        this.a = r1;
    }
}
