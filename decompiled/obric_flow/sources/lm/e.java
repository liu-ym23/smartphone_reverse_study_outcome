package lm;

import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.SvgImageView;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.component.svg.parser.n0;
import com.lynx.serval.svg.SVGRender;
import com.lynx.tasm.ui.image.v;
import com.lynx.tasm.utils.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UISvg f19681b;

    public /* synthetic */ e(UISvg r5, int r10) {
        this.f19680a = r10;
        this.f19681b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f19680a) {
            case 0: goto L39;
            case 1: goto L36;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L10;
            default: goto L5;
        };
    L36:
        StringBuilder r5 = new StringBuilder("recycleResourcesAsync():ui-svg hashCode:");
        UISvg r10 = this.f19681b;
        r5.append(r10);
        LynxLog.b(2, "lynx_UISvg", r5.toString());
        r10.f9726c.k();
        return;
    L5:
        if (this.f19681b.e == null) goto L47;
        LynxLog.b(2, "lynx_UISvg", "invalidateDrawableAsync(), options:" + this.f19681b.d.toString() + "width:" + this.f19681b.getWidth() + "height:" + this.f19681b.getHeight() + "svg hashCode:" + this.f19681b.e.hashCode() + " ui-svg hashCode:" + this.f19681b);
        j.a().post(new v(16, this, new b(this.f19681b.e, this.f19681b.d, this.f19681b.f9726c)));
        return;
    L47:
        return;
    L10:
        if (this.f19681b.f9728i == true) goto L48;
        SVGRender r11 = new SVGRender();
        r11.setResourceManager(new w8.f(this));
        this.f19681b.f9727h = r11;
        return;
    L48:
        return;
    L43:
        n0 r12 = n0.e(this.f19681b.f9725b);     // Catch: SVGParseException -> L18
        StringBuilder r13 = new StringBuilder("onPropsUpdated():svg hashCode:");     // Catch: SVGParseException -> L18
        if (r12 == null) goto L20;
        int r14 = r12.hashCode();     // Catch: SVGParseException -> L18
    L21:
        r13.append(r14);     // Catch: SVGParseException -> L18
        r13.append(" ui-svg hashCode:");     // Catch: SVGParseException -> L18
        r13.append(this.f19681b);     // Catch: SVGParseException -> L18
        LynxLog.b(2, "lynx_UISvg", r13.toString());     // Catch: SVGParseException -> L18
        UISvg.c(this.f19681b, r12);     // Catch: SVGParseException -> L18
        return;
    L20:
        r14 = -1;
    L18:
        e = move-exception;
        LynxLog.b(4, "lynx_UISvg", "onPropsUpdated():  the content is:" + this.f19681b.f9725b + "the error message is " + e.toString());
        return;
    L45:
        n0 r15 = n0.e(this.f19681b.f9725b);     // Catch: SVGParseException -> L29
        StringBuilder r16 = new StringBuilder("tryDecodeBase64AndUpdate(): svg hashCode:");     // Catch: SVGParseException -> L29
        if (r15 == null) goto L31;
        int r17 = r15.hashCode();     // Catch: SVGParseException -> L29
    L32:
        r16.append(r17);     // Catch: SVGParseException -> L29
        r16.append(" ui-svg hashCode:");     // Catch: SVGParseException -> L29
        r16.append(this.f19681b);     // Catch: SVGParseException -> L29
        LynxLog.b(2, "lynx_UISvg", r16.toString());     // Catch: SVGParseException -> L29
        UISvg.c(this.f19681b, r15);     // Catch: SVGParseException -> L29
        return;
    L31:
        r17 = -1;
    L29:
        e = move-exception;
        StringBuilder r18 = new StringBuilder(" tryDecodeBase64AndUpdate():");
        r18.append(e.toString());
        r18.append(" the content is:");
        com.lynx.tasm.behavior.ui.utils.e.i(r18, this.f19681b.f9725b, 4, "lynx_UISvg");
        return;
    L39:
        if (this.f19681b.e == null) goto L51;
        ((SvgImageView) UISvg.m(this.f19681b)).setImageDrawable(new b(this.f19681b.e, this.f19681b.d, this.f19681b.f9726c));
        this.f19681b.invalidate();
        return;
    }
}
