package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 implements DialogInterface.OnClickListener {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.dismiss();
    }
}
