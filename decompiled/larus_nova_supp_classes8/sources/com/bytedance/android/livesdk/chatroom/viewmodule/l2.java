package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l2 implements Consumer<Boolean> {
    public final /* synthetic */ NewFullVideoButtonWidget a;

    public l2(NewFullVideoButtonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r9) throws Exception {
        Boolean r10 = (Boolean) r9;
        NewFullVideoButtonWidget r0 = this.a;
        r0.yq();
        if (r0.f == false) goto L22;
        long r1 = System.currentTimeMillis();
        if ((r1 - r0.x) >= 500) goto L8;
        r0.x = r1;
        r0.o.setVisibility(8);
        return;
    L8:
        r0.x = r1;
        if (r10.booleanValue() == true) goto L11;
        r0.Fq(false);
        return;
    L11:
        if (r0.o.getVisibility() == 0) goto L13;
        boolean r11 = true;
    L14:
        r0.o.setVisibility(0);
        if (r11 == false) goto L17;
        ut1.h.c();
    L17:
        r0.Fq(true);
        return;
    L13:
        r11 = false;
        goto L14
    }
}
