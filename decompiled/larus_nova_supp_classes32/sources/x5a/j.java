package x5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.SvgImageView;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.SVG;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements Runnable {
    public final /* synthetic */ SVG a;
    public final /* synthetic */ UISvg b;

    public final void a() {
        UISvg r0 = this.b;
        r0.f = this.a;
        e r1 = new e(this.a, this.b.e, this.b.d);
        ((SvgImageView) UISvg.M(this.b)).setImageDrawable(r1);
        this.b.invalidate();
        UISvg.R(this.b, this.a);
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

    public j(UISvg r1, SVG r2) {
        this.b = r1;
        this.a = r2;
    }
}
