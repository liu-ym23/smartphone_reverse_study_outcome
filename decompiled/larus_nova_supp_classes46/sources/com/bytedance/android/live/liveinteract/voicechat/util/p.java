package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 a;

    public p(Function0 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r3 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r3 == null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r3);
    L5:
        r1.dismiss();
        Function0 r4 = this.a;
        if (r4 == null) goto L9;
        Unit r5 = (Unit) r4.invoke();
        return;
    }
}
