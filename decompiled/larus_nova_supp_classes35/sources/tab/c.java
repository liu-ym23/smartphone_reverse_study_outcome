package tab;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final WheelView a;

    @Override // java.lang.Runnable
    public final void run() {
        WheelView r0 = this.a;     // Catch: Throwable -> L4
        r0.c.onItemSelected(r0.getCurrentItem());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(WheelView r1) {
        this.a = r1;
    }
}
