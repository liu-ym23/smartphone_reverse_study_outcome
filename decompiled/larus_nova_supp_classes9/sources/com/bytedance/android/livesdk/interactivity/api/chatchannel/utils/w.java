package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements DialogInterface.OnClickListener {
    public final /* synthetic */ RoomChatChannelCreator a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ Long d;
    public final /* synthetic */ Long e;
    public final /* synthetic */ Long f;
    public final /* synthetic */ Long g;

    public w(RoomChatChannelCreator r1, long r2, Long r4, Long r5, Long r6, Long r7, Long r8) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        RoomChatChannelCreator r5 = this.a;
        r5.c = Long.valueOf(this.b);
        RoomChatChannelCreator r6 = this.a;
        r6.d = this.c;
        r6.e = this.d;
        r6.f = this.e;
        r6.g = this.f;
        r6.h = this.g;
        s22.e r7 = r6.b();
        if (r7 == null) goto L5;
        r7.quitChannel(this.b);
    L5:
        r3.dismiss();
    }
}
