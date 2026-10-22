package oba;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.attention.ObricAttentionServiceImpl;
import com.obric.assistant.attention.ObricAttentionServiceImpl$b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ ObricAttentionServiceImpl a;
    public final /* synthetic */ ServiceConnection b;
    public final /* synthetic */ ComponentName c;

    public /* synthetic */ c(ObricAttentionServiceImpl r1, i r2, ComponentName r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricAttentionServiceImpl r0 = this.a;
        i r1 = this.b;
        ComponentName r2 = this.c;
        if (r0.d == r1) goto L5;
        return;
    L5:
        if (r0.c != null) goto L13;
        FLogger.a.w("ObricAttentionService", "attention service bind timed out, component=" + r2);
        r0.i("bind_timeout");
        ObricAttentionServiceImpl$b r3 = r0.b;
        if (r3 == null) goto L12;
        r0.g(r3, Boolean.FALSE, false);
        return;
    L12:
        return;
    }
}
