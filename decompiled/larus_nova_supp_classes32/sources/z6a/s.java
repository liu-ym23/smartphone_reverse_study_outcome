package z6a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s implements Runnable {
    public final /* synthetic */ TextShadowNode a;
    public final /* synthetic */ m7a.a b;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getContext().getEventEmitter().sendCustomEvent(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public s(TextShadowNode r1, m7a.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
