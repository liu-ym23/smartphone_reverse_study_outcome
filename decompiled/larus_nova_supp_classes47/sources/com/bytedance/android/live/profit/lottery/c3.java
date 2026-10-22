package com.bytedance.android.live.profit.lottery;

import android.content.Context;
import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ i1 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Ref.ObjectRef c;

    public c3(i1 r1, Context r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        ((Function0) this.c.element).invoke();
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(this.b, this.a.a);
    }
}
