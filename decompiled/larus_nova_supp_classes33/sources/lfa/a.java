package lfa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends Handler {
    public final /* synthetic */ c a;

    @Override // android.os.Handler
    public final void handleMessage(Message r6) {
        int r7 = r6.what;
        boolean r0 = false;
        if (r7 == 1) goto L14;
        if (r7 != 2) goto L19;
        c r8 = this.a;
        int r1 = r8.e + 1;
        r8.e = r1;
        if (r1 > 3) goto L13;
        ILogDepend.a.i("CaeMultipathClient", "Reconnecting, attempt: " + this.a.e);
        c r9 = this.a;
        if (r9.a == null) goto L11;
        r0 = true;
    L11:
        if (r0 == true) goto L16;
        c.b(r9);
        return;
    L16:
        return;
    L13:
        ILogDepend.a.e("CaeMultipathClient", "Max reconnect times (3) reached, stop.");
        return;
    L19:
        return;
    L14:
        this.a.e = 0;
        removeMessages(2);
        c.b(this.a);
    }

    public a(c r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
