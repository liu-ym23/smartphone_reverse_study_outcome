package com.lynx.tasm.behavior.shadow.text;

import android.graphics.drawable.Drawable;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends d7a.f {
    public final /* synthetic */ com.lynx.tasm.behavior.ui.text.a h2;

    @Override // d7a.f
    public final void j(LynxError r1, int r2, int r3) {
    }

    @Override // d7a.f
    public final void k(int r1, int r2) {
    }

    @Override // d7a.f
    public final void f() {
        Drawable.Callback r0 = this.h2.o;
        if (r0 == null) goto L6;
        r0.invalidateDrawable(this.j);
        return;
    }

    public c(LynxContext r1, d7a.b r2) {
        this.h2 = r2;
        super(r1);
    }
}
