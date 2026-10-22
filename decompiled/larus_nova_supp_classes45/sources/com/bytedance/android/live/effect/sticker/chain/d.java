package com.bytedance.android.live.effect.sticker.chain;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ l a;

    public d(l r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        l r5 = this.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter("3D特效取消", "reason");
        r5.b = false;
        r3.dismiss();
    }
}
