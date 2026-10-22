package com.larus.bmhome.chat.cotdetail.list.processor;

import android.content.Context;
import android.view.View;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.platform.service.z2;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ MsgFeedbackType c;

    public /* synthetic */ h(k r1, boolean r2, MsgFeedbackType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r0 = this.a;
        boolean r1 = this.b;
        MsgFeedbackType r2 = this.c;
        if (r0.h == true) goto L5;
        return;
    L5:
        if (z2.a.enableMessageMenuTimestamp() == true) goto L7;
        return;
    L7:
        if (r0.a.isResumed() == false) goto L29;
        View r3 = r0.a.getView();
        if (r3 == null) goto L13;
        boolean r5 = true;
        if (r3.isShown() != true) goto L13;
    L14:
        if (r5 == false) goto L31;
        Context r4 = r0.a.getContext();
        if (r4 == null) goto L32;
        if (r1 == true) goto L22;
        s.a.getClass();
        s.b(r4, 2131907052, false);
        return;
    L22:
        if (r2 != MsgFeedbackType.MsgFeedbackTypeLike) goto L24;
        int r6 = 2131910469;
    L25:
        s.a.getClass();
        s.o(r4, r6, false);
        return;
    L24:
        r6 = 2131901665;
        goto L25
    L32:
        return;
    L31:
        return;
    L13:
        r5 = false;
        goto L14
    }
}
