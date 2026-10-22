package ck;

import android.net.LocalSocket;
import android.util.Log;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalSocket f1215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ jk.a f1216b;

    public c(jk.a r5, LocalSocket r10) {
        this.f1216b = r5;
        this.f1215a = r10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        LocalSocket r5 = this.f1215a;
        com.lynx.animax.player.b r10 = new com.lynx.animax.player.b(1, r5, new b(r5.getInputStream()));     // Catch: Exception -> L5
        ((x0) this.f1216b.f18351c).b(r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("LocalSocketServer", e.getMessage());
    }
}
