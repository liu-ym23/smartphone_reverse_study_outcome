package x5a;

import android.graphics.drawable.Drawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ SVG c;
    public final /* synthetic */ com.lynx.component.svg.a d;

    public class a implements Runnable {
        public final /* synthetic */ Drawable a;
        public final /* synthetic */ b b;

        public final void a() {
            if (this.b.d.v == false) goto L6;
            this.b.d.p = false;
            return;
        L6:
            com.lynx.component.svg.a r0 = this.b.d;
            r0.q = this.a;
            this.b.d.e(0);
            com.lynx.component.svg.a.k(this.b.d);
            this.b.d.p = false;
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

        public a(b r1, e r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: x5a.b$b, reason: collision with other inner class name */
    public class RunnableC0123b implements Runnable {
        public final /* synthetic */ b a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d.p = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0123b(b r1) {
            this.a = r1;
        }
    }

    public final void a() {
        com.lynx.component.svg.parser.c r0 = new com.lynx.component.svg.parser.c(this.d.d.d.getUIBody().getFontSize(), this.d.d.d.getUIBody().getFontSize());     // Catch: Exception -> L4
        r0.a = new SVG.b(0.0f, 0.0f, this.a, this.b);     // Catch: Exception -> L4
        UIThreadUtils.runOnUiThread(new a(this, new e(this.c, r0, this.d.s)));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("lynx_SVGRenderer", "renderLegacySVG failed: " + e.getMessage());
        UIThreadUtils.runOnUiThread(new RunnableC0123b(this));
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

    public b(com.lynx.component.svg.a r1, int r2, int r3, SVG r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
