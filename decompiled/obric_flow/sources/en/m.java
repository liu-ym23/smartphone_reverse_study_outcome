package en;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.list.UIListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIListAdapter f16850b;

    public /* synthetic */ m(UIListAdapter r5, int r10) {
        this.f16849a = r10;
        this.f16850b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f16849a) {
            case 0: goto L16;
            default: goto L14;
        };
    L14:
        this.f16850b.notifyDataSetChanged();     // Catch: IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        LynxLog.b(4, "UIList", "notifyDataSetChanged leads to the IllegalStateException : " + e.getMessage());
        return;
    L16:
        this.f16850b.f10539o.a();     // Catch: IllegalStateException -> L11
        return;
    L11:
        e = move-exception;
        LynxLog.b(4, "UIList", "operationDispatcher.dispatch() leads to the IllegalStateException : " + e.getMessage());
    }
}
