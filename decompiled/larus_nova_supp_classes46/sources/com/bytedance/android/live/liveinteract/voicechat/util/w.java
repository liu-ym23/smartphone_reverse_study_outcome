package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements DialogInterface.OnClickListener {
    public final /* synthetic */ u a;

    public w(VoiceInteractSceneUtil.a r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        u r3 = this.a;
        if (r3 == null) goto L5;
        r3.a();
    L5:
        r1.dismiss();
    }
}
