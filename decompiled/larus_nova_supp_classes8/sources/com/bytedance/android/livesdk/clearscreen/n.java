package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ o a;

    public n(o r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        o r0 = this.a;
        if (r0.g0 == true) goto L13;
        int r1 = ClearScreenConst.InteractType.INTERACT_SHOW.getId();
        if (r4 != null) goto L8;
    L9:
        boolean r5 = true;
    L11:
        r0.e0 = r5;
        return;
    L8:
        if (r4.intValue() != r1) goto L9;
        r5 = false;
        goto L11
    }
}
