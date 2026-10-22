package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements DialogInterface.OnClickListener {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.dismiss();
    }
}
