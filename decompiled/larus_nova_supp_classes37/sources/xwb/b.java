package xwb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officewebview.bridge.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ d c;
    public final /* synthetic */ Message d;
    public final /* synthetic */ a e;

    public b(f r1, Object r2, d r3, Message r4, a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b, this.c, this.d.getExtra(), this.e.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
