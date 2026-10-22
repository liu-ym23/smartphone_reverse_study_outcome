package h5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.lynx.clay.embedding.engine.plugins.audio.a b;

    @Override // java.lang.Runnable
    public final void run() {
        com.lynx.clay.embedding.engine.plugins.audio.a.g(this.b, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(com.lynx.clay.embedding.engine.plugins.audio.a r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
