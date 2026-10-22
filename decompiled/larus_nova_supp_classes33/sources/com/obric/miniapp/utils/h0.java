package com.obric.miniapp.utils;

import android.content.DialogInterface;
import com.obric.oui.sheet.v2.OSheet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ OSheet a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ g c;

    public h0(OSheet r1, AtomicBoolean r2, g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r3) {
        a0.t(this.b, this.c, null);
        a0 r4 = a0.a;
        OSheet r0 = this.a;
        r4.getClass();
        a0.i(r0);
    }
}
