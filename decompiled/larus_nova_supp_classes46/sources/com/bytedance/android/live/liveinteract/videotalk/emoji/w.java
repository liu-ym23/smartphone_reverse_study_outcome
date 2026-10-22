package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements DialogInterface.OnClickListener {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
