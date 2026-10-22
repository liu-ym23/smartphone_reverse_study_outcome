package x5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public final /* synthetic */ com.lynx.component.svg.a a;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.p = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public final void a() {
        SVG r0 = SVG.c(this.a.l);     // Catch: SVGParseException -> L7
        com.lynx.component.svg.a r1 = this.a;     // Catch: SVGParseException -> L7
        if (r0 != null) goto L5;
        r1.p = false;     // Catch: SVGParseException -> L7
    L10:
        return;
    L5:
        LynxThreadPool.e().execute(new b(r1, r1.t, r1.u, r0));     // Catch: SVGParseException -> L7
    L7:
        e = move-exception;
        LLog.e("lynx_SVGRenderer", "renderLegacySVGFromContent failed: " + e.getMessage());
        UIThreadUtils.runOnUiThread(new a(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(com.lynx.component.svg.a r1) {
        this.a = r1;
    }
}
