package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements DialogInterface.OnClickListener {
    public final /* synthetic */ u a;
    public final /* synthetic */ Function0 b;

    public x(VoiceInteractSceneUtil.a r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        u r4 = this.a;
        if (r4 == null) goto L5;
        r4.b();
    L5:
        int r5 = y.a;
        Function0 r6 = this.b;
        u r0 = this.a;
        r6.invoke();
        if (r0 == null) goto L8;
        r0.c();
    L8:
        r2.dismiss();
    }
}
