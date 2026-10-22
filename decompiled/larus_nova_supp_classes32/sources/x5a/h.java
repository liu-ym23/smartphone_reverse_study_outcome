package x5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements Runnable {
    public final /* synthetic */ SVG a;
    public final /* synthetic */ UISvg b;

    @Override // java.lang.Runnable
    public final void run() {
        UISvg r0 = this.b;     // Catch: Throwable -> L7
        SVG r1 = this.a;     // Catch: Throwable -> L7
        int r2 = UISvg.l;     // Catch: Throwable -> L7
        r0.f = r1;     // Catch: Throwable -> L7
        if (r0.f == null) goto L10;
        UIThreadUtils.runOnUiThread(new i(r0, new e(r1, r0.e, r0.d), r1));     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public h(UISvg r1, SVG r2) {
        this.b = r1;
        this.a = r2;
    }
}
