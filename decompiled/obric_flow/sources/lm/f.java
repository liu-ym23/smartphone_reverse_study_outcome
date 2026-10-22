package lm;

import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.SvgImageView;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f19683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UISvg f19684c;

    public /* synthetic */ f(UISvg r5, n0 r10, int r11) {
        this.f19682a = r11;
        this.f19684c = r5;
        this.f19683b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f19682a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f19684c.e = this.f19683b;
        LynxLog.b(2, "lynx_UISvg", "postDrawableOnUI(),option:" + this.f19684c.d.toString() + " svg hashCode:" + this.f19683b.hashCode() + " ui-svg hashCode:" + this.f19684c);
        ((SvgImageView) UISvg.b(this.f19684c)).setImageDrawable(new b(this.f19683b, this.f19684c.d, this.f19684c.f9726c));
        this.f19684c.invalidate();
        UISvg.k(this.f19684c, this.f19683b);
        return;
    L6:
        int r5 = UISvg.f9723j;
        this.f19684c.i(this.f19683b);
    }
}
