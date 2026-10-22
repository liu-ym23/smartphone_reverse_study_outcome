package com.bytedance.android.live.profit.lottery;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Ref.ObjectRef a;

    public d3(Ref.ObjectRef r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        ((Function0) this.a.element).invoke();
    }
}
