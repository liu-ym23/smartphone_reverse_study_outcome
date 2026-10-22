package f7a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements Runnable {
    public final /* synthetic */ LynxBaseUI a;
    public final /* synthetic */ UIListContainer b;

    @Override // java.lang.Runnable
    public final void run() {
        UIListContainer.P(this.b, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(UIListContainer r1, LynxBaseUI r2) {
        this.b = r1;
        this.a = r2;
    }
}
