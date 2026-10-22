package com.larus.tts.impl;

import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ ChatTitleTtsComponent a;

    public /* synthetic */ a0(ChatTitleTtsComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatTitleTtsComponent r0 = this.a;
        int r1 = ChatTitleTtsComponent.v;
        com.larus.platform.api.g0 r2 = r0.Y2();
        boolean r3 = true;
        if (r2 == null) goto L5;
        r2.setTtsBanned(true);
    L5:
        MutableLiveData r4 = r0.j;
        com.larus.platform.api.g0 r5 = r0.Y2();
        if (r5 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L20;
        com.larus.platform.api.g0 r7 = r0.Y2();
        if (r7 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L20;
    L21:
        r4.setValue(Boolean.valueOf(r3));
        return;
    L15:
        if (r7.getTtsChecked() != true) goto L17;
        r8 = true;
    L20:
        r3 = false;
        goto L21
    L8:
        if (r5.getTtsBanned() == true) goto L10;
        r6 = true;
        goto L11
    }
}
