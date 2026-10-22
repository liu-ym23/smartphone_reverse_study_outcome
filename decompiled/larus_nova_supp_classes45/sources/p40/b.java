package p40;

import com.bytedance.android.live.componentsmarket.api.draggable.DraggableComponentState;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements Runnable {
    public final /* synthetic */ l40.a a;
    public final /* synthetic */ DraggableComponentState.Style b;
    public final /* synthetic */ int c;
    public final /* synthetic */ a d;

    public b(l40.a r1, DraggableComponentState.Style r2, int r3, a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.p(this.a, this.b, this.c, "post");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
