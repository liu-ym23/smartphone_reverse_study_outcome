package com.suite.lark.platform.component.cta;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ goc.b c;
    public final /* synthetic */ goc.b.d d;
    public final /* synthetic */ goc.a e;

    public e(b r1, Context r2, goc.b r3, goc.b.d r4, goc.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        b.a(this.a, this.b, this.c, this.d, this.e);
    }
}
