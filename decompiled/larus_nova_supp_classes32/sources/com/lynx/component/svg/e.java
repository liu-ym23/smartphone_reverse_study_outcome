package com.lynx.component.svg;

import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements e8a.a<byte[]> {
    public final /* synthetic */ d.InterfaceC0046d a;
    public final /* synthetic */ String b;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r4) {
        if (r4.a != LynxResourceResponse.ResponseState.SUCCESS) goto L15;
        byte[] r5 = r4.b;
        if (r5 != null) goto L7;
        this.a.onError("data is empty!");
        return;
    L7:
        String r0 = new String(r5, StandardCharsets.UTF_8);
        SVG r6 = SVG.c(r0);     // Catch: SVGParseException -> L13
        d.InterfaceC0046d r1 = this.a;     // Catch: SVGParseException -> L13
        if ((r1 instanceof d.c) == false) goto L11;
        ((d.c) r1).a(r0, r6);     // Catch: SVGParseException -> L13
    L21:
        return;
    L11:
        r1.onSuccess();     // Catch: SVGParseException -> L13
    L13:
        e = move-exception;
        this.a.onError(e.toString());
        return;
    L15:
        d.InterfaceC0046d r2 = this.a;
        Throwable r7 = r4.c;
        if (r7 == null) goto L18;
        String r8 = r7.toString();
    L19:
        r2.onError(r8);
        return;
    L18:
        r8 = "svg fetch src failed! " + this.b;
        goto L19
    }

    public e(d.c r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
