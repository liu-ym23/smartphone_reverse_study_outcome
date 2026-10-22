package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements DialogInterface.OnClickListener {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r3 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r3 == null) goto L6;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r3);
        return;
    }
}
