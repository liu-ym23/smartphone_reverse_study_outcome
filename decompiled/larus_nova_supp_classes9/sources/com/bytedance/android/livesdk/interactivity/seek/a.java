package com.bytedance.android.livesdk.interactivity.seek;

import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Object r9 = sh6.c.b((sh6.b) r8);
        if (r9 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.b r10 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.b) r9;
        long r0 = r10.b - r10.a;
        b r11 = this.a;
        if (r0 <= r11.f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L16;
        if (r11.g == true) goto L24;
        r11.g = true;
        Iterator<jc1.h> r13 = r11.a.iterator();
    L13:
        if (r13.hasNext() == false) goto L26;
        r13.next().g(true);
        goto L13
    L26:
        return;
    L24:
        return;
    L16:
        if (r11.g == false) goto L25;
        r11.g = false;
        Iterator<jc1.h> r14 = r11.a.iterator();
    L19:
        if (r14.hasNext() == false) goto L27;
        r14.next().g(false);
        goto L19
    L27:
        return;
    L25:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
