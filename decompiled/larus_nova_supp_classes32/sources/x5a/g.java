package x5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements Runnable {
    public final /* synthetic */ UISvg a;

    public final void a() {
        SVG r0 = SVG.c(this.a.b);     // Catch: SVGParseException -> L10
        UISvg r1 = this.a;     // Catch: SVGParseException -> L10
        r1.getClass();     // Catch: SVGParseException -> L10
        if (LynxEnv.inst().enableSvgAsync() == false) goto L8;
        r1.f = r0;     // Catch: SVGParseException -> L10
        if (r1.f == null) goto L13;
        UIThreadUtils.runOnUiThread(new i(r1, new e(r0, r1.e, r1.d), r0));     // Catch: SVGParseException -> L10
    L13:
        return;
    L8:
        UIThreadUtils.runOnUiThread(new j(r1, r0));     // Catch: SVGParseException -> L10
    L10:
        e = move-exception;
        LLog.e("lynx_UISvg", " tryDecodeBase64AndUpdate():" + e.toString() + " the content is:" + this.a.b);
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

    public g(UISvg r1) {
        this.a = r1;
    }
}
