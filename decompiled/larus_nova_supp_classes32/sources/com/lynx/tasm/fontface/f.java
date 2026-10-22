package com.lynx.tasm.fontface;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends LynxResourceCallback<String> {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ String b;
    public final /* synthetic */ LynxContext c;
    public final /* synthetic */ FontFaceManager d;

    @Override // com.lynx.tasm.provider.LynxResourceCallback
    public final void onResponse(LynxResourceResponse<String> r5) {
        super.onResponse(r5);
        String r0 = r5.getData();
        if (r5.success() == false) goto L5;
        this.a[0] = r0;
        return;
    L5:
        FontFaceManager r1 = this.d;
        String r6 = r5.getError().getMessage();
        String r2 = this.b;
        LynxContext r3 = this.c;
        r1.getClass();
        FontFaceManager.n(30202, r6, r2, null, r3);
    }

    public f(FontFaceManager r1, String[] r2, String r3, LynxContext r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
