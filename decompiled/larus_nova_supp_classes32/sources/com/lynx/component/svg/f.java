package com.lynx.component.svg;

import android.text.TextUtils;
import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.l;
import d8a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements d8a.g {
    public final /* synthetic */ d.InterfaceC0046d a;

    public f(d.c r1) {
        this.a = r1;
    }

    @Override // d8a.g
    public final void onFailed(i r2) {
        this.a.onError(r2.b);
    }

    @Override // d8a.g
    public final void onSuccess(i r5) {
        byte[] r0 = l.a(r5.d);     // Catch: SVGParseException -> L15
        if (r0 != null) goto L6;
        String r1 = null;
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        r5.b = "data is empty!";     // Catch: SVGParseException -> L15
    L17:
        this.a.onError(r5.b);
        return;
    L10:
        SVG r2 = SVG.c(r1);     // Catch: SVGParseException -> L15
        d.InterfaceC0046d r3 = this.a;     // Catch: SVGParseException -> L15
        if ((r3 instanceof d.c) == false) goto L13;
        ((d.c) r3).a(r1, r2);     // Catch: SVGParseException -> L15
        return;
    L13:
        r3.onSuccess();     // Catch: SVGParseException -> L15
        return;
    L6:
        r1 = new String(r0);     // Catch: SVGParseException -> L15
    L15:
        e = move-exception;
        r5.b = e.toString();
        LLog.DTHROW(new RuntimeException(e));
        goto L17
    }
}
