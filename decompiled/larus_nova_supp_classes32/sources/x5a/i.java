package x5a;

import android.graphics.drawable.PictureDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.SvgImageView;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.SVG;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements Runnable {
    public final /* synthetic */ PictureDrawable a;
    public final /* synthetic */ SVG b;
    public final /* synthetic */ UISvg c;

    @Override // java.lang.Runnable
    public final void run() {
        ((SvgImageView) UISvg.Q(this.c)).setImageDrawable(this.a);     // Catch: Throwable -> L4
        this.c.invalidate();     // Catch: Throwable -> L4
        UISvg.R(this.c, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(UISvg r1, e r2, SVG r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
