package com.bytedance.android.live.effect.sticker.chain;

import android.content.DialogInterface;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ l b;

    public e(Ref.BooleanRef r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        if (this.a.element == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.X3;
        Boolean r0 = Boolean.TRUE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
    L5:
        this.b.a();
        r2.dismiss();
    }
}
