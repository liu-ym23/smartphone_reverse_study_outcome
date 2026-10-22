package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;
    public final /* synthetic */ s c;
    public final /* synthetic */ s d;
    public final /* synthetic */ i e;

    public g(d r1, long r2, s r4, s r5, i r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r7, int r8) {
        this.a.b(this.b, this.c, this.d, this.e);
        r7.dismiss();
    }
}
